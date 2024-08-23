package kr.or.ddit.basic;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVO;

// MyBatis를 사용하여 DB자료를 처리하는 순서 및 방법 예제
public class LprodMybatisTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 2. mapper에 등록된 SQL문 중 실행할 SQL문을 호출해서 실행하여 원하는 작업을 수행한다.
		
		/*
		// 2-1. insert 작업 System.out.println("insert 작업 시작");
		System.out.println("Lprod_id 입력 >> ");
		int lprodId = scan.nextInt();
		
		System.out.println("Lprod_gu 입력 >> ");
		String lprodGu = scan.next();
		
		System.out.println("Lprod_nm 입력 >> ");
		String lprodNm = scan.next();
		
		// insert할 데이터들을 VO객체에 저장한다.
		LprodVO lvo = new LprodVO();
		lvo.setLprod_id(lprodId);
		lvo.setLprod_gu(lprodGu);
		lvo.setLprod_nm(lprodNm);
		
		SqlSession session = null;
		try {
			// SQL문을 호출해서 실행할 수 있는 SqlSession 객체를 생성한다.
			// ==> SqlSessionFactory 객체의 openSession() 메소드를 이용한다.
			// 형식) SqlSessionFactory객체.openSession(논리값)
			// ==> '논리값'이 true이면 AutoCommit이 활성화된 상태로 생성되고
			// '논리값'이 false이거나 생략되면 AutoCommit이 비활성화된 상태로 생성된다.
//			session = sqlSessionFactory.openSession();
			session = MybatisUtil.getSqlSession();
		
			// SqlSession 객체를 이용하여 처리할 SQL문을 호출해서 실행한다.
			// 형식) SqlSession객체.insert("namespace속성값.id속성값", 파라미터값);
			// ==> 반환값: 실행에 성공한 레코드 수
			int insertCnt = session.insert("lprod.insertLprod", lvo);
		
			// SqlSession객체를 생성할 때 AutoCommit을 비활성화된 상태로 생성했을 때에는
			// commit을 직접 실행해야 한다.
			if(insertCnt>0){
				session.commit();
				System.out.println("insert 작업 성공");
			} else {
				System.out.println("insert 작업 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 작업이 끝나면 SqlSession 객체를 닫아준다. session.close();
		}
		
		System.out.println("-----------------------------------------------------------------------");
		*/

		
		
		/*
		// 2-2. update 작업 System.out.println("update 작업 시작");
		System.out.println("수정할 Lprod_gu 입력 >> ");
		String lprodGu2 = scan.next();
		
		System.out.println("새로운 Lprod_id 입력 >> ");
		int newLprodId = scan.nextInt();
		
		System.out.println("새로운 Lprod_nm 입력 >> ");
		String newLprodNm = scan.next();
		
		// 입력받은 자료를 VO객체에 저장한다.
		LprodVO lvo2 = new LprodVO();
		lvo2.setLprod_gu(lprodGu2); lvo2.setLprod_id(newLprodId);
		lvo2.setLprod_nm(newLprodNm);
		
		SqlSession session = null;
		try {
//			session = sqlSessionFactory.openSession();
			session = MybatisUtil.getSqlSession();
		
			// SQL문 실행하기 --> update문 실행
			// 형식) SqlSession객체.update("namespace속성값.id속성값", 파라미터값)
			//       ==> 반환값: 작업에 성공한 레코드 수
			int updateCnt = session.update("lprod.updateLprod", lvo2);
		
			if(updateCnt>0) {
				session.commit();
				System.out.println("update 작업 성공");
			} else {
				System.out.println("update 작업 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.clearCache();
		}
		*/


		
		/*
		// 2-3. delete 작업
		System.out.println("delete 작업 시작");
		System.out.println("삭제할 Lprod_gu 입력 >> ");
		String lprodGu3 = scan.next();

		SqlSession session = null;
		try {
//			session = sqlSessionFactory.openSession();
			session = MybatisUtil.getSqlSession();

			// SQL문 실행하기 ==> delete문 실행
			// 형식) SqlSession객체.delete("namespace속성값.id속성값", 파라미터값);
			//       ==> 반환값: 작업에 성공한 레코드 수
			int deleteCnt = session.delete("lprod.deleteLprod", lprodGu3);

			if(deleteCnt>0){
				session.commit();
				System.out.println("delete 작업 성공");
			} else {
				System.out.println("delete 작업 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("-----------------------------------------------------------");
		*/

		
		
		
		// 2-4. select 작업
		
		
		// 1) SQL문을 실행한 결과가 여러개 일 경우
		System.out.println("select 작업 시작(결과가 여러개 일 경우)");

		SqlSession session = null;
		try {
//			session = sqlSessionFactory.openSession();
			session = MybatisUtil.getSqlSession();

			// SQL문 실행하기 ==> select문 실행(결과가 여러개 일 경우)
			// 형식) sqlSession객체.selectList("namespace속성값.id속성값", 파라미터값); // 파라미터값은 없으면 생략
			//       ==> 반환값: SELECT문이 실행된 결과가 저장된 List 객체
			List<LprodVO> lprodList = session.selectList("lprod.getAllLprod");

			for(LprodVO lvo3 : lprodList) {
				System.out.println("Lprod_id: "+lvo3.getLprod_id());
				System.out.println("Lprod_gu: "+lvo3.getLprod_gu());
				System.out.println("Lprod_nm: "+lvo3.getLprod_nm());
				System.out.println("--------------------------------------------------");
			}
			System.out.println("출력 끝");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("-------------------------------------------------------------------------------");
		
		
		/*
		// 2) SQL문을 실행한 결과가 한 개 일 경우
		System.out.println("select 작업 시작(결과가 한 개 일 경우)");
		System.out.println("검색할 Lprod_gu 입력 >> ");
		String lprodGu4 = scan.next();
		
		SqlSession session = null;
		try {
//			session = sqlSessionFactory.openSession();
			session = MybatisUtil.getSqlSession();
			
			// SQL문 실행하기 ==> select문 실행(결과가 한 개 일 경우)
			// 형식) SqlSession객체.selectOne("namespace속성값.id속성값", 파라미터값);
			//       ==> 반환값: 검색된 결과가 없으면 null을 반환한다. (있으면 당연히 결과 반환)
			LprodVO lvo4 = session.selectOne("lprod.getLprod", lprodGu4);
			if(lvo4==null) {
				System.out.println("검색한 결과가 하나도 없습니다.");
				scan.close();
				return;
			}

			System.out.println("Lprod_id: "+lvo4.getLprod_id());
			System.out.println("Lprod_gu: "+lvo4.getLprod_gu());
			System.out.println("Lprod_nm: "+lvo4.getLprod_nm());
			System.out.println("--------------------------------------------------");

			System.out.println("출력 끝");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		*/
		scan.close();
	}
}
