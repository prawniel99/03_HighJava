package kr.or.ddit.reqNresp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirectTest.do")
public class RedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		
			- redirect 방식
			  1) 다른 페이지로 단순 이동하는 것을 말한다. (Request객체와 Response 객체를 공유하지 않는다.)
			  
			  2) 응답시 브라우저에게 '이동할 URL'을 전송하여 브라우저가 해당 URL로 재요청하여 이동하는 방식이다.
			     ==> 이동할 때는 GET방식으로 요청하기 때문에 URL의 길이에 제한이 있다.
		
		*/

		// Redirect방식은 Request객체를 공유하지 못한다.
		request.setAttribute("tel", "010-8888-8888");
		
		// Response 객체의 sendRedirect() 메소드를 이용하여 이동한다.
		// ==> 형식) Response객체.sendRedirect("이동할URL");
		//     ==> '이동할URL'은 전체 URL경로로 지정해 주어야 한다.
		//	   ==> URL경로에 한글이 포함되어 있으면 URLEncoder객체를 이용하여 인코딩해서 지정해주어야 한다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		













































	}












































































	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}









































































































