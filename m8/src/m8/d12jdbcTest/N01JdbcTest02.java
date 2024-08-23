package m8.d12jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) 사용자로부터 Lprod_id값을 입력 받아 입력한 값보다 Lprod_id가 큰 자료들을  출력하시오.

public class N01JdbcTest02 {
    public static void main(String[] args) {
        Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
        Scanner scan = new Scanner(System.in);

        try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분해야함

			// 2. DB에 접속 ==> Connection 객체 생성
			// 오라클용 매개변수 첫번째꺼 정해져있음
			// 내 컴터에 있는 오라클db니까 localhost인거.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BHM93", "java");

            // 사용자 입력받기.
            System.out.println("lprod_id 입력 (범위 1~9): ");
            int userIn = scan.nextInt();

			// 3. 질의

			// 3-1. SQL문 작성
			String sql = "select * from lprod where lprod_id>"+userIn;

			// 3-2. Statement 객체 생성
			stmt = conn.createStatement();
			// Statement satement = new Statement(); 이거 아니다 ㅋㅋ.. 스테이트먼트 객체를 커넥션 객체를 이용해서 만드는거

			// 3-3. SQL문을 서버로 보내서 결과를 얻어온다.
			//      (실행할 SQL문이 select문이기 떄문에 실행 결과가 ResultSet객체에 저장되어서 반환된다)
			rs = stmt.executeQuery(sql);

			System.out.println(rs);

			// 4. 결과 처리하기 ==> 한 레코드씩 화면에 출력하기
			System.out.println("== 처리 결과 출력 ==");
			// Result 객체에 저장된 데이터를 차례로 꺼내오려면 반복문과 next() 메소드를 이용하여 처리한다.
			// next() 메소드 ==> ResultSet 객체의 데이터를 가리키는 포인터를 다음번째 레코드로 이동시키고
			//                   그 곳에 데이터가 있으면 true를 반환하고 없으면 false를 반환한다.
			while(rs.next()) { // next는 포인터를 다음 칸으로 이동시켜줌. 그 자리에 데이터가 있으면 true, 없으면 false 반환.
				// 데이터 가져오기
				// 방법1) ResultSet객체.get자료형이름("컬럼명 또는 alias명")
				// 방법2) ResultSet객체.get자료형이름(컬럼번호) ==> 컬럼번호는 1부터 시작*
				System.out.println("lprod_id: "+rs.getInt(1));
				System.out.println("lprod_gu: "+rs.getString("lprod_gu"));
				System.out.println("lprod_nm: "+rs.getString(3));
				System.out.println("-----------------------------------");
			}
		} catch (SQLException e) {
		} catch (Exception e) {
		} finally {
			
			try{if(rs!=null) rs.close();} catch (Exception e){}
			try{if(stmt!=null) stmt.close();} catch (Exception e){}
			try{if(conn!=null) conn.close();} catch (Exception e){}
		}
        scan.close();
    }
}
