package kr.or.ddit.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.qna.service.QnaService;

@WebServlet("/qnaDeletePost.do")
public class QnaDeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 전송 데이터 num // board.js 에서 num에 vidx를 담아서 보냈지
		int num = Integer.parseInt(request.getParameter("num"));
		
		// service객체 가져오기
		QnaService service = QnaService.getInstance();
		
		// service메소드 호출
		int cnt = service.qnaDeletePost(num);
		
		// 결과값 저장
		request.setAttribute("result", cnt);
		
		// view로 이동
		request.getRequestDispatcher("WEB-INF/views/qna/result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
