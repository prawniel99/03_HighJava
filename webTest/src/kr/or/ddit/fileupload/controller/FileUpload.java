package kr.or.ddit.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;

/*

	파일 업로드
	
	원래는 라이브러리 다운받아서 사용해야했고, 그래서 명령어도 제각각이고 그랬음
	
	- Servlet 3.0 이상에서는 servlet 자체에서 업로드 파일 처리 방법을 제공
	- 무조건 되는건 아니고 설정을 해줘야함
	- url mapping 할때 WebServlet이런 annotation을 썼음
	- Servlet 3.0 이상에서 파일 업로드를 하려면 servletdp @MultipartConfig 어노테이션을 설정해야 한다.
	- 기본값이란 생략했을때 라는 뜻이다
	
	- @MultipartConfig 어노테이션의 속성들
	  1) location : 업로드한 파일이 임시적으로 저장될 경로를 지정 (기본값: "") 
	  2) fileSizeThreshold : 이 곳에 설정한 값보다 큰 파일이 전송되면
	                         location에 지정한 임시 디렉토리에 저장 (단위: byte, 기본값: 0 (무조건 임시 디렉토리 사용)) 
	  3) maxFileSize : 파일 한개의 최대 크기 지정 (단위: byte, 기본값: -1L (무제한))
	  4) maxRequestSize : 서버로 전송되는 Request의 전체 데이터의 최대 크기
	                      (모든 파일의 크기 + formData) (단위: byte, 기본값: -1L (무제한))
	
	- 최소한 메소드 위에 @MultipartConfig 만 해놓고 import만 해놓던가, 아니면 () 안에다가 다 써놔야함

*/

@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
	maxRequestSize = 1024 * 1024 * 30
)
@WebServlet("/fileUpload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get 방식으로 호출하면 파일 입력 폼 문서가 나타나도록 한다
		request.getRequestDispatcher("/basic/fileUpload/fileUploadForm.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일이 전송되어 오면 처리하기
		request.setCharacterEncoding("utf-8");
		
		// 업로드된 파일들이 저장될 폴더 설정 // 서버에 있는 컴퓨터의 경로
		String uploadPath = "d:/d_other/uploadFiles/";
		
		File file = new File(uploadPath);
		
		// 저장될 폴더가 없으면 새로 생성한다.
		if(!file.exists()) file.mkdirs();
		
		//-------------------------------------------------------------------------
		// 파일이 아닌 일반 데이터들은 getParameter() 메소드나 getParameterValue() 메소드를 이용해서 구한다
		
		String userName = request.getParameter("username");
		
		System.out.println("일반 파라미터 데이터(unsername): " + userName);
		
		//-------------------------------------------------------------------------
		// 수신 받은 파일 데이터를 처리하기
		
		// Upload한 파일이 여러개 일 경우 Upload한 파일 정보가 저장될 List객체 생성
		List<FileInfoVO> fileList = new ArrayList<FileInfoVO>();
		
		// - Servlet 3.0 이상에서 새롭게 추가된 Upload용 메소드
		// 1) request.getParts() ==> 전체 Part객체를 Collection에 담아서 반환한다. part객체가 뭔데?
		// 2) request.getPart("이름") ==> 지정된 '이름'을 갖는 개별 part객체를 반환한다.
		//                                '이름'은 <form>태그 안의 입력요소의 name속성값으로 구별한다.
		
		// 전체 Part 객체 개수 만큼 반복 처리
		for(Part part : request.getParts()) {
			
			// Upload한 파일명 구하기
			String originFileName = extractFileName(part);
			System.out.println("업로드한 파일명: " + originFileName);
			
			// 찾은 파일명이 빈문자열("")이면 이것은 파일이 아닌 일반 파라미터 데이터이다.
			if(!"".equals(originFileName)) { // 파일인지 검사
				// 1개의 파일 정보를 저장할 VO객체 생성
				FileInfoVO fileVo = new FileInfoVO();
				
				fileVo.setFile_writer(userName); // 작성자 저장
				fileVo.setOrigin_file_name(originFileName); // 실제 파일명 저장
				// 한곳에 여러 사람의 데이터가 저장이 됨.
				
				// 실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 UUID클래스를 이용하여 저장할 파일명을 만든다.
				String saveFileName = UUID.randomUUID().toString() + "_" + originFileName;
				// 난수 같은걸 만들어서 문자열을 만든다. 중복 가능성 거의 없다고 함.
				
				fileVo.setSave_file_name(saveFileName); // 저장할 파일명
				
				// 전송된 파일의 크기의 part.getSize() 메소드로 구할 수 있다.
				fileVo.setFile_size(part.getSize()); // 파일 크기 저장
				
				//-------------------------------------------------------------------
				// part.write()메소드를 이용하여 upload된 파일을 지정한 폴더에 저장한다.
				try {
					part.write(uploadPath + File.pathSeparator + saveFileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// List에 1개의 파일 정보 추가
				fileList.add(fileVo);
				System.out.println("fileVo: " + fileVo);
			}
			// if문 끝
		}
		// for문 끝
		
		// List에 추가된 파일 정보를 DB에 저장한다.
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		
		for(FileInfoVO fvo : fileList) {
			service.insertFileInfo(fvo);
		}
		
		// 저장이 완료된 후 파일 목록 보여주기
		response.sendRedirect(request.getContextPath()+"/fileList.do");
		
	}
	
	//------------------------------------------------------------------------------------------------
	/*
	
		- Part 구조
		  1) 파일이 아닌 일반 파라미터 데이터일 경우
		----------------------------23faoi2j392h048gh2kj              ==> Part를 구분하는 구분선 (구분선인데 값 왜 있음? 그냥 난수라고 한다)
		content-disposition : form-data; name="username"         ==> 파라미터명
																 ==> 빈 줄
		hong 													 ==> 파라미터값
		
		
		  2) 파일인 경우
		----------------------------23faoi2j392h048gh2kj              ==> Part를 구분하는 구분선
		content-disposition: form-data; name="upFile1"; filename="test1.txt" ==> 파일 정보
		content-type: text/plain											 ==> 파일의 종류
																			 ==> 빈 줄
		abcd1234안녕														 ==> 파일의 내용
	
	
	*/

	// Part구조 안에서 파일명을 찾는 메소드
	private String extractFileName(Part part) {
		String fileName = "";
		
		String content = part.getHeader("content-disposition");
		String[] items = content.split(";");
		
		for(String item : items) {
			if(item.trim().startsWith("filename")) {
				// filename="test1.txt" 기준으로, item의 시작은 = 이 0, " 이 1, 그래서 2부터 시작, 마지막은 " 니까 -1
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return fileName;
	}

}



