package kr.or.ddit.fileupload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;

@WebServlet("/fileList.do")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		
		// 파일 정보가 저장된 전체 자료를 DB에서 읽어온다.
		List<FileInfoVO> fileList = service.getAllFileInfo();
		
		System.out.println("출력" + fileList);
		
		// 가져온 파일 목록 정보를 View로 보내준다.
		request.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/basic/fileUpload/fileList.jsp")
		.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
