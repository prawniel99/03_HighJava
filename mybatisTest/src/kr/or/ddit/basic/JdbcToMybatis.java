package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

// JDBC 예제 중 'JdbcTest05.java'를 Mybatis로 처리하는 프로그램을 작성하시오.
// 핵심 기능은 lprod_gu가 중복이 되면 새로 입력하도록 하는 기능이다.
// 그럼 lprod_id는 입력받지 않고, 맥스+1로 설정한다.

public class JdbcToMybatis {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 1. MyBatis의 환경 설정 파일(mybatis-config.xml)을 읽어와서 그 내용을 처리한 후
		// 처리된 결과를 갖는 SqlSessionFactory객체를 생성한다.

		InputStream in = null; // 스트림 객체 변수 선언
		SqlSessionFactory sqlSessionFactory = null; // SqlSessionFactory객체 변수 선언

		try {
			// 1-1. 환경 설정 파일을 읽어 올 스트림 객체를 생성한다.
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");

			// 1-2. 환경 설정 파일을 읽어와 환경 설정 작업을 수행하고 작업이 완료되면 SqlSessionFactory객체를 생성한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			System.out.println("MyBatis 초기화 실패");
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					
				}
		}
		
		// insert
		String lprodGu;
		String lprodNm;
		LprodVO lvo;
		
		SqlSession session = null;
		// 중복 확인하기
		while(true) {
			System.out.println("Lprod_gu 입력 >> ");
			lprodGu = scan.next();
			
			System.out.println("Lprod_nm 입력 >> ");
			lprodNm = scan.next();
			
			// insert할 데이터들을 VO객체에 저장한다.
			lvo = new LprodVO();
			lvo.setLprod_gu(lprodGu);
			lvo.setLprod_nm(lprodNm);
			
			// 중복 확인하기
			try {
				session = sqlSessionFactory.openSession();
				if(session.selectOne("jdbc.checkLprod", lvo)==null) {
					break;
				} else {
					System.out.println("gu값 중복, 다시 입력하세요");
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			int insertCnt = session.insert("jdbc.insertLprod", lvo);

			if(insertCnt>0){
				session.commit();
				System.out.println("insert 작업 성공");
			} else {
				System.out.println("insert 작업 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		System.out.println("-----------------------------------------------------------------------");
		scan.close();
	}

}
