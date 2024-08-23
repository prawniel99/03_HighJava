package m8.d12jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 
 * LPROD 테이블에 새로운 데이터를 추가하시오.
 * 
 * lprod_gu와 lprod_nm은 직접 입력 받아서 처리하고,
 * lprod_id는 현재의 lprod_id에서 제일 큰 값보다 1 크게 한다.
 * 
 * 입력 받은 lprod_gu가 이미 등록되어 있는 값이면, 새로운 값으로 다시 입력받아서 처리한다.
 * 
 */

public class N04JdbcTest05 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scan = new Scanner(System.in);
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BHM93", "java");

            System.out.println("gu와 nm 입력하기");

            System.out.print("gu >> ");
            String gu = scan.nextLine();

            System.out.println("nm >> ");
            String nm = scan.nextLine();

            String guTest = "select count(*) from lprod where lprod_gu=?";
            pstmt = conn.prepareStatement(guTest);
            pstmt.setString(1, gu);
            rs = pstmt.executeQuery();
            rs.next();
            int a = rs.getInt(1);

            if(a==0) {
                String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) "
                + "values ((select max(lprod_id)+1 from lprod), ?, ?) ";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, gu);
                pstmt.setString(2, nm);

                // int cnt = pstmt.executeUpdate();
                rs = pstmt.executeQuery();
                // System.out.println("반환값: " + cnt);
    
            } else {
                System.out.println("중복");
            }








        } catch (SQLException e) {
            System.out.println("으잉");
        } catch (Exception e) {

        }
        scan.close();
    }
}
