package kr.or.ddit.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;

@WebServlet("/images/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int fileNo = Integer.parseInt(request.getParameter("fileno"));
		
		// DB에서 파일 정보 가져오기
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		FileInfoVO fileVo = service.getFileInfo(fileNo);
		
		// 이미지 파일이 저장된 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		File file = new File(uploadPath);
		
		// 저장될 폴더가 없으면 새로 생성한다.
		if(!file.exists()) {
			file.mkdirs();
		}
		
		File imageFile = new File(file, fileVo.getSave_file_name());
		if(imageFile.exists()) {
			// Content-Type 설정
			response.setContentType("application/octet-stream; charset=utf-8");
			
			// Rseponse객체의 Header에 'content-disposition' 속성을 설정한다.
			String headerKey = "content-disposition";
			
			// 이 헤더 속성에 다운 받을 파일 이름을 설정한다. (클라이언트에 저장될 이름을 설정한다)
			// 한글이 있으면 제대로 안보여짐. 사라지거나 언더바가 되거나. 그래서 추가 작업 해줘야함.
			// encode(파일이름, 인코딩방식) 한글인것도 다 읽어오는건 filename* 이거고, 다시 원래 한글로 저장하려는건 encode(fileVo저거)
			String headerValue = "attachment; filename*=UTF-8''" + URLEncoder.encode(fileVo.getOrigin_file_name(), "utf-8")
			.replaceAll("\\+", "%20");
			
			// 이렇게 해서 헤더 작업 완료
			response.setHeader(headerKey, headerValue);
			
			// 서버에 저장된 파일을 읽어서 클라이언트로 전송하기
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				// 출력용 스트림 객체 생성 ==> Reponse객체 이용
				// response.getoutputstream 이게 클라이언트와 연결된 아웃풋 스트림이다.
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(imageFile));
				
				// 인풋스트림으로 읽어서 아웃풋스트림으로 출력해주기만 하면 됨
				byte[] temp = new byte[1024];
				int len = 0;
				
				while((len = bin.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				
				bout.flush();
				
				
			} catch (Exception e) {
				System.out.println("입출력 오류: " + e.getMessage());
				e.printStackTrace();
			} finally {
				if(bin != null) try { bin.close(); } catch(IOException e) { }
				if(bout != null) try { bout.close(); } catch(IOException e) { }
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
