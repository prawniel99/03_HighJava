package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardTargetTest
 */
@WebServlet("/forwardTargetTest.do")
public class ForwardTargetTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// Request객체와 Response객체를 공유하기 때문에 파라미터도 이곳에서 읽어올 수 있다.
		String userName = request.getParameter("username");
		
		// 이전 문서에서 setAttribute() 메소드로 세팅한 데이터 가져오기
		String tel = (String)request.getAttribute("tel");
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<meta charset='utf-8'><title>forward 연습</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h3>Forward로 이동한 결과</h3>");
		
		out.println("<table border='40px inlet'>");
		out.println("<tr>");
		out.println("<td>이름</td>");
		out.println("<td>"+userName+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>전화</td>");
		out.println("<td>"+tel+"</td>");
		out.println("</tr>");
		
		out.println("</table>");
		
		out.println("</body>");
		
		out.println("</html>");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




































