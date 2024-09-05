package kr.or.ddit.mymem.service;

import java.util.List;

import kr.or.ddit.mymem.dao.IMymemDao;
import kr.or.ddit.mymem.dao.MymemDaoImpl;
import kr.or.ddit.mymem.vo.MymemVO;

public class MymemServiceImpl implements IMymemService {
	
	// dao 참조 객체 생성
	private IMymemDao dao;
	
	// 싱글톤 만들기 순서 1) 자기자신 참조 변수 생성 2) 기본생성자에 daoimpl getinstance 한줄 넣어서 private으로 생성 3) 자기자신 getinstance 생성
	
	// 1 자기자신 참조 변수 static 으로 생성
	private static MymemServiceImpl service;
	
	// 2 기본생성자 private으로 생성
	private MymemServiceImpl() {
		dao = MymemDaoImpl.getInstance();
	}
	
	// 3. 자기자신 getinstance 생성
	public static MymemServiceImpl getInstance() {
		if(service == null) service = new MymemServiceImpl();
		return service;
	}
	
	// 위 4가지 생성 후 아래 작업 시작. 아오 어렵네.
	
	@Override
	public List<MymemVO> getAllMymem() {
		return dao.getAllMymem();
	}

	@Override
	public MymemVO getOneMymem(int mymemNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MymemVO insertOneMymem(MymemVO mymemInfoVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MymemVO updateOneMymem(MymemVO mymemInfoVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MymemVO deleteOneMymem(MymemVO mymemInfoVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
