package kr.or.ddit.fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.FileInfoVO;

public class FileInfoDaoImpl implements IFileInfoDao {
	// 1. 자신 참조 객체 생성
	private static FileInfoDaoImpl dao;
	
	// 2. 기본 생성자 생성
	private FileInfoDaoImpl() {}
	
	public static FileInfoDaoImpl getInstance() {
		if(dao == null) dao = new FileInfoDaoImpl();
		
		return dao;
	}
	
	@Override
	public int insertFileInfo(FileInfoVO fileInfoVo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			// 그냥 insert는 db에 저장하기 전 '임시저장' 되어있는 상태가 된다.
			// 여기서 그냥 종료를 해버리면 날라가서 저장 안됨.
			cnt = session.insert("fileinfo.insertFileInfo", fileInfoVo);
			// 여기서 commit을 해줘야 결과가 진짜로 저장이 됨.
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			
		}
		System.out.println("cnt: " + cnt);
		return cnt;
	}
	
	@Override
	public List<FileInfoVO> getAllFileInfo() {
		SqlSession session = null;
		List<FileInfoVO> fileList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			fileList = session.selectList("fileinfo.getAllFileInfo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return fileList;
	}
	
	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		SqlSession session = null;
		FileInfoVO fileVo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			fileVo = session.selectOne("fileinfo.getFileInfo", fileNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return fileVo;
	}

	

}
