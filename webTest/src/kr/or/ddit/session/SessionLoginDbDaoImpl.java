package kr.or.ddit.session;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.vo.MemberVO;

public class SessionLoginDbDaoImpl implements SessionLoginDbDao {
	
	private static SessionLoginDbDaoImpl dao;
	
	private SessionLoginDbDaoImpl() {}

	public static SessionLoginDbDao getInstance() {
		if(dao==null) dao = new SessionLoginDbDaoImpl();
		return dao;
	}

	@Override
	public String loginCheck(String id, String pw) {
		
    	SqlSession session = null;
    	int cnt = 0;
		
		// 2) SQL문을 실행한 결과가 한 개 일 경우
		System.out.println("select 작업 시작(결과가 한 개 일 경우)");
		System.out.println("검색할 Lprod_gu 입력 >> ");
		String lprodGu4 = scan.next();
		
		try {
//			session = sqlSessionFactory.openSession();
			session = MybatisUtil.getSqlSession();
			
			// SQL문 실행하기 ==> select문 실행(결과가 한 개 일 경우)
			// 형식) SqlSession객체.selectOne("namespace속성값.id속성값", 파라미터값);
			//       ==> 반환값: 검색된 결과가 없으면 null을 반환한다. (있으면 당연히 결과 반환)
			MemberVO lvo4 = session.selectOne("lprod.getLprod", lprodGu4);
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
		
		
		return null;
	}

}
