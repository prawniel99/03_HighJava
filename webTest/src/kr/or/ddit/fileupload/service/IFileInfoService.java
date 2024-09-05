package kr.or.ddit.fileupload.service;

import java.util.List;

import kr.or.ddit.vo.FileInfoVO;

public interface IFileInfoService {
	
	// 서비스는 다오 복붙하기!! 다오 먼저만들기!!

	/**
	 * fileInfoVo에 저장된 자료를 DB에 insert하게 하는 메소드
	 * 
	 * @param fileInfoVo insert할 자료가 저장된 FileInoVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 */
	// 파일정보 넣기 vo활용해서 db 컬럼 정보 저장해둔 vo값 받아오기
	public int insertFileInfo(FileInfoVO fileInfoVo);
	
	/**
	 * DB에 저장된 전체 파일 목록을 가져와 List에 담아서 반환하는 메소드
	 * 
	 * @return 파일 정보 목록이 저장된 List객체
	 */
	public List<FileInfoVO> getAllFileInfo();
	
	/**
	 * 파일 번호를 매개변수로 받아서 해당 파일 정보를 VO객체에 담아서 반환하는 메소드
	 * 
	 * @param fileNo 검색할 파일 번호
	 * @return 검색된 파일 정보가 저장된 FileInfoVO객체
	 */
	public FileInfoVO getFileInfo(int fileNo);
	// 왜 list가 아닌가!
	// public List<FileInfoVO> getFileInfo();
}
