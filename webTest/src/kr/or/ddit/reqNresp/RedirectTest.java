package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.net.URLEncoder;

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
		// redirect 방식으로 보내려면 그냥 여기서 request set attribute 하고 send한다고 되는게 아님. 다른 방식 사용해야함.
		request.setCharacterEncoding("utf-8");
		
		
		

		// ----------------------------------------------------------------------------------------------------------------------------
		// Redirect방식은 Request객체를 공유하지 못한다.
		// request.setAttribute("tel", "010-8888-8888"); // 저장해도 가져가지 못한다.
		// response.sendRedirect(request.getContextPath()+"/redirectTargetTest.do");
		// ----------------------------------------------------------------------------------------------------------------------------
		
		// 일단 파라미터 데이터들을 먼저 구한다.
		String userName = request.getParameter("username");
		
		// 기타 전달할 데이터를 구성한다. set.Attribute 하는게 아니고 그냥 만드는 거.
		String tel = "010-8888-8888";
		
		// Response 객체의 sendRedirect() 메소드를 이용하여 이동한다.
		// ==> 형식) Response객체.sendRedirect("이동할URL");
		//     ==> '이동할URL'은 전체 URL경로로 지정해 주어야 한다.
		//	   ==> URL경로에 한글이 포함되어 있으면 URLEncoder객체를 이용하여 인코딩해서 지정해주어야 한다.
		response.sendRedirect(request.getContextPath() // 물음표 사용. = 왼쪽이 파라미터변수명, 오른쪽이 값
				+"/redirectTargetTest.do?username="
				+ URLEncoder.encode(userName, "utf-8") // &로 추가하기
				+"&tel="+tel); // ? 뒤에 따옴표 안에 띄어쓰기 있으면 안됨.
		// send 하면 request랑 response 보내고, 값 다 지움. 그리고 RedirectTargetTest.java로 이동함.
		
		
		
		











	}








	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}









































































































