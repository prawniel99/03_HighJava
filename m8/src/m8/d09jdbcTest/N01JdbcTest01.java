package m8.d09jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class N01JdbcTest01 {
	/*
	 * 
	 * - JDBC (Java DataBase Connectivity) 라이브러리를 이용하여 DB자료 처리하기
	 * 
	 * - JDBC 처리 순서
	 * 1. 드라이버 로딩 ==> 라이브러리를 사용할 수 있게 메모리로 읽어 들이는 작업
	 *    Class.forName("oracle.jdbc.driver.OracleDriver");
	 *    
	 * 2. DB시스템에 접속하기 ==> 접속이 완료되면
	 *    DriverManager.getConnection() 메소드를 이용한다.
	 *    
	 *    1, 2번은 정해져있는거고, 3, 4번을 잘 처리하는게 중요.
	 *    
	 * 3. 질의 ==> SQL 문장을 DB서버로 보내서 결과를 얻어온다.
	 *    (Statement 객체 또는 PreparedStatement객체를 이용하여 작업한다.)
	 * 
	 * 4. 결과 처리 작업 ==> 질의 결과를 받아서 원하는 작업을 수행한다.
	 *    1) SQL문이 select문일 경우 ==> select한 결과가 ResultSet 객체에 저장되어서 반환된다.
	 *    2) SQL문이 select문이 아닐 경우(insert, update, delete 등)
	 *       ==> 작업에 성공한 레코드 수가 반환된다.
	 * 
	 * 5. 사용했던 자원 반납하기
	 *    ==> 각 단계에서 생성한 객체를 close() 메소드를 이용하여 닫아준다.
	 * 
	 */
	
	public static void main(String[] args) {
		// DB작업에 필요한 객체 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분해야함

			// 2. DB에 접속 ==> Connection 객체 생성
			// 오라클용 매개변수 첫번째꺼 정해져있음
			// 내 컴터에 있는 오라클db니까 localhost인거.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BHM93", "java");

			// 3. 질의

			// 3-1. SQL문 작성
			String sql = "select * from member";

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
				System.out.println("mem_name: "+rs.getString(3));
				System.out.println("mem_mileage: "+rs.getInt("mem_mileage"));
				System.out.println("mem_job: "+rs.getString("mem_job"));
				System.out.println("-----------------------------------");
			}
		} catch (SQLException e) {
		} catch (Exception e) {
		} finally {
			
			try{if(rs!=null) rs.close();} catch (Exception e){}
			try{if(stmt!=null) stmt.close();} catch (Exception e){}
			try{if(conn!=null) conn.close();} catch (Exception e){}
		}

	}
}
