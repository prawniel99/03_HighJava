package kr.or.ddit.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.qna.service.QnaService;
import kr.or.ddit.qna.vo.QnaVO;

@WebServlet("/qnaReplyList.do")
public class QnaReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("replyList 들어오긴 함?");
		// 전송 데이터 받기
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		System.out.println("bonum 출력 " + bonum);
		
		// service객체 얻기
		QnaService service = QnaService.getInstance();
		
		// srevice메소드 호출 - 결과값 받기
		List<QnaVO> list = service.qnaReplyList(bonum);
		System.out.println("list 출력 " + list);
		System.out.println("list 1번 " + list.get(0));
		for(QnaVO a : list) {
			System.out.println("글번호는 " + a.getQna_no());
			System.out.println("답변은 " + a.getQna_answer());
			System.out.println("제목도 뜸? " + a.getQna_title());
		}
		
		// 결과값을 저장
		request.setAttribute("list", list);
		
		// view 페이지로 이동
		request.getRequestDispatcher("WEB-INF/views/qna/replyList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
