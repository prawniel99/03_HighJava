package kr.or.ddit.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.review.service.IReviewService;
import kr.or.ddit.review.service.ReviewServiceImpl;
import kr.or.ddit.review.vo.ReviewVO;

@WebServlet("/reviewProd.do")
public class ReviewProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    // 문자열 그대로 받음
	    String pid = request.getParameter("prodid");
	    
	    // 이후 처리
	    System.out.println("Received reviewpid: " + pid);
		
		IReviewService service = ReviewServiceImpl.getInstance();
		
		List<ReviewVO> list = service.reviewProd(pid);

		request.setAttribute("reviewList", list);
		
		request.getRequestDispatcher("/WEB-INF/views/review/reviewProd.jsp").forward(request, response);
	}

}
