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

public class N04JdbcTest05Teacher {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scan = new Scanner(System.in);
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BHM93", "java");

            String sql = "select nvl(max(lprod_id), 0) + 1 maxid from lprod";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            int maxId = 0;

            if(rs.next()) {
                maxId = rs.getInt("maxid"); // 방법1: alias명 이용
                // maxId = rs.getInt(1);    // 방법2: 컬럼번호 이용
            }

            // 입력 받은 lprod_gu가 이미 등록되어 있는 값이면 새로운 값으로 다시 입력 받아서 처리한다.
            String gu;      // 입력한 lprod_gu가 저장될 변수
            int count = 0;  // 입력한 lprod_gu의 개수가 저장될 변수

            String sql2 = "select count(*) cnt from lprod where lprod_gu=?";
            pstmt = conn.prepareStatement(sql2);

            do {
                System.out.println("LPROD_GU값 입력 >> ");
                gu = scan.next();

                // SQL문의 물음표 자리에 값 세팅하기
                pstmt.setString(1, gu);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                    count = rs.getInt(1);
                    // count = rs.getInt("cnt");

                    if(count>0) {
                        System.out.println("입력한 "+gu+"는 이미 있는 값입니다");
                        System.out.println("다시입력하세요");
                        System.out.println();
                    }
                }
            } while (count>0);

            System.out.println("LPROD_NM값 입력 >> ");
            String nm = scan.next();

            String sql3 = "insert into lprod (Lprod_id, lprod_gu, lprod_nm) "
            + "values (?, ?, ?)";

            pstmt = conn.prepareStatement(sql3);

            pstmt.setInt(1, maxId);
            pstmt.setString(2, gu);
            pstmt.setString(3, nm);
            int cnt = pstmt.executeUpdate();

            if(cnt>0) {
                System.out.println("추가 성공");
            } else {
                System.out.println("추가 실패");
            }
            






        } catch (SQLException e) {
            System.out.println("으잉");
        } catch (Exception e) {

        } finally {
            try{if(rs!=null) rs.close();} catch (Exception e){}
			try{if(conn!=null) conn.close();} catch (Exception e){}
        }
        scan.close();
    }
}
