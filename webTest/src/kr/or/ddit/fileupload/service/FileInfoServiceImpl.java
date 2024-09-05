package kr.or.ddit.fileupload.service;

import java.util.List;

import kr.or.ddit.fileupload.dao.FileInfoDaoImpl;
import kr.or.ddit.fileupload.dao.IFileInfoDao;
import kr.or.ddit.vo.FileInfoVO;

public class FileInfoServiceImpl implements IFileInfoService {

	// 1. 다오 참조 객체
	private IFileInfoDao dao;
	
	// 2. 
	private static FileInfoServiceImpl service;
	
	// 3.
	public FileInfoServiceImpl() {
		dao = FileInfoDaoImpl.getInstance();
	}
	
	// 4.
	public static FileInfoServiceImpl getInstance() {
		if(service == null) service = new FileInfoServiceImpl();
		
		return service;
	}

	@Override
	public int insertFileInfo(FileInfoVO fileInfoVo) {
		return dao.insertFileInfo(fileInfoVo);
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		return dao.getAllFileInfo();
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		return getFileInfo(fileNo);
	}
	
}
