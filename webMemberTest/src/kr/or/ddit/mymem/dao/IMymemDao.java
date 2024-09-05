package kr.or.ddit.mymem.dao;

import java.util.List;

import kr.or.ddit.mymem.vo.MymemVO;

public interface IMymemDao {
	
	// 회원 전체 정보 출력
	public List<MymemVO> getAllMymem();
	
	// 회원 한명 정보 출력
	public MymemVO getOneMymem(int mymemNo);
	
	// 회원 정보 삽입
	public MymemVO insertOneMymem(MymemVO mymemInfoVo);
	
	// 회원 정보 수정
	public MymemVO updateOneMymem(MymemVO mymemInfoVo);
	
	// 회원 정보 삭제
	public MymemVO deleteOneMymem(MymemVO mymemInfoVo);

}
