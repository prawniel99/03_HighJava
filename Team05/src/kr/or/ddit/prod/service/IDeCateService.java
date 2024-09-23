package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.vo.DeCateVO;

public interface IDeCateService {
	
	public int insertDeCate(DeCateVO dcvo);
	
	public int deleteDeCate(String dcateId);
	
	public int updateDeCate(DeCateVO dcvo);
	
	public List<DeCateVO> getAllDeCate();
	
	public List<DeCateVO> getIdDeCate(String cateId);
}
