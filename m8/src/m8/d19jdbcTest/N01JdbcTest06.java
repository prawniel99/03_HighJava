package m8.d19jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import m8.util.DBUtil;

/*
 * Statement 객체를 사용하면 SQL injection 해킹을 당할 수 있는 예제
 * 1. 정상 검색 ==> (계좌번호) 입력
 */

public class N01JdbcTest06 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Connection conn = null;
        Statement stmt = null; // 해킹 가능이 발견되면서 아무도 안쓰게 됨
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            /* 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BHM93", "java");
            */

            conn = DBUtil.getConnection(); // DBUtil.java 클래스랑 연결해서 바로 위에꺼 말고 이 방법으로 해봄.
            
            System.out.println("계좌번호 정보 검색하기");
            System.out.println();
            System.out.println("검색할 계좌번호 입력 >> ");
            String bankNo = scan.nextLine();

            // Statement 객체를 이용한 경우
            String sql = "select * from bankinfo where bank_no = '"+bankNo+"'";

            System.out.println("sql ==> "+sql);

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            /* 
            // PreparedStatement 객체);
            rs = pstmt.executeQuery();

            System.out.println();
            System.out.println("\t=== 검색 결과 ===");
            System.out.println("게좌번호\t은행명\t예금주명\t개설날짜");
            System.out.println("--------------------------------------------------------------");
            */

            while(rs.next()){
                String bNo = rs.getString("bank_no");
                String bName = rs.getString("bank_name");
                String bUser = rs.getString("bank_user_name");
                String bDate = rs.getString("bank_date");
                
                System.out.println(bNo+"\t"+bName+"\t"+bUser+"\t"+bDate);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        // } catch(ClassNotFoundException e) {
        //     e.printStackTrace();
        } finally {
            if(rs!=null) try { rs.close(); } catch (SQLException e) {}
            if(stmt!=null) try { stmt.close(); } catch (SQLException e) {}
            if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
            if(conn!=null) try { conn.close(); } catch (SQLException e) {}

        }
        scan.close();
    }
}
