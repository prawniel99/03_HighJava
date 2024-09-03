package kr.or.ddit.session;

import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private static MemberServiceImpl service;
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public MemberVO getLoginMember(MemberVO memVo) {
		return dao.getLoginMember(memVo);
	}
}
