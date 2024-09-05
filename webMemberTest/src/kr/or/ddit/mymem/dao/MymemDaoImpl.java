package kr.or.ddit.mymem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mymem.vo.MymemVO;
import kr.or.ddit.util.MybatisUtil;

public class MymemDaoImpl implements IMymemDao {
	
	// 자기 자신 객체 생성
	private static MymemDaoImpl dao;
	
	// 빈 기본생성자 생성하여 싱글톤으로 변경
	private MymemDaoImpl() {}
	
	// 자기 자신 getInstance 생성
	public static MymemDaoImpl getInstance() {
		if(dao == null) dao = new MymemDaoImpl();
		return dao;
	}
	
	// 위 세가지 기본으로 하고, 이후 기능 만들기

	@Override
	public List<MymemVO> getAllMymem() {
		// dao가 하는 일은 서비스에서 요청을 받고, db에 데이터를 요청하는 것이다.
		// 서비스에서 받는건 그냥 연결해두면 되는거고, db에는 명령을 보내야한다.
		// 자 그럼 명령을 보내려면 객체부터 생성. mybatis를 사용하는거다.
		SqlSession session = null;
		List<MymemVO> mymemList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			mymemList = session.selectList("mymem.getAllMymem");
		} catch (Exception e) {
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return mymemList;
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
