package kr.or.ddit.session;

public class SessionLoginDbServiceImpl implements SessionLoginDbService {
	
	private SessionLoginDbDao dao;
	
    private SessionLoginDbServiceImpl() {
//      dao = new MemberDaoImpl();
    	dao = SessionLoginDbDaoImpl.getInstance();
    }

	@Override
	public String loginCheck(String id, String pw) {
		return dao.loginCheck(id, pw);
	}

}
