package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IOprodDao;
import kr.or.ddit.prod.dao.OprodDaoImpl;
import kr.or.ddit.prod.vo.OprodVO;

public class OprodServiceImpl implements IOprodService {

	private static OprodServiceImpl service;
	
	private IOprodDao dao;
	
	private OprodServiceImpl() {
		dao = OprodDaoImpl.getInstance();
	}
	
	public static OprodServiceImpl getInstance() {
		if(service==null) service = new OprodServiceImpl();
		
		return service;
	}
	
	@Override
	public int insertOprod(OprodVO oprvo) {
		// TODO Auto-generated method stub
		return dao.insertOprod(oprvo);
	}

	@Override
	public int deleteOprod(String prodId) {
		// TODO Auto-generated method stub
		return dao.deleteOprod(prodId);
	}

	@Override
	public int updateOprod(OprodVO oprvo) {
		// TODO Auto-generated method stub
		return dao.updateOprod(oprvo);
	}

	@Override
	public List<OprodVO> getAllOprod() {
		// TODO Auto-generated method stub
		return dao.getAllOprod();
	}

}
