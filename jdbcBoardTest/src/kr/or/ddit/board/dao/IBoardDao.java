package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;

public interface IBoardDao {
	/**
	 * BoardVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param boardVo DB에 insert할 자료가 저장된 BoardVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertBoard( BoardVO boardVo );
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 삭제하는 메서드
	 * 
	 * @param boardNo 삭제할 게시글 번호
	 * @return  작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteBoard( int boardNo );
	
	/**
	 * 수정할 자료가 저장된 BoardVO객체를 매개변수로 받아서 수정하는 메서드
	 * 
	 * @param boardVo 수정할 자료가 저장된 BoardVO객체
	 * @return  작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateBoard( BoardVO boardVo);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 가져와 반환하는 메서드
	 * 
	 * @param boardNo 가져올 게시글의 번호
	 * @return 게시글에 맞는 자료가 있으면 해당 자료가 저장된 BoardVO객체,
	 * 		   게시글에 맞는 자료가 없으면 null 반환
	 */
	public BoardVO getBoard(int boardNo);
	
	/**
	 * 전체 게시글 정보를 가져와 List에 저장하여 반환하는 메서드
	 * 
	 * @return BoardVO객체가 저장된 List객체
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 검색 단어를 매개변수로 받아서 제목에 검색 단어가 포함된 자료를 검색하는 메서드
	 * 
	 * @param title 검색할 게시글 제목
	 * @return 검색된 결과가 저장된 List객체
	 */
	public List<BoardVO> getSearchBoard(String title);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 증가시키는 메서드
	 * 
	 * @param boardNo 조회수를 증가할 게시글의 번호
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int setCountIncrement(int boardNo);
	
	
}










