package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectTargetTest
 */
@WebServlet("/redirectTargetTest.do")
public class RedirectTargetTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// Redirect로 전달되는 데이터는 GET방식으로 전달되기 때문에
		// 파라미터를 읽어오는 명령으로 처리해야한다.
		String userName = request.getParameter("username");
		// String tel = (String)request.getAttribute("tel");
		String tel = request.getParameter("tel"); // 파라미터로 받는걸로 했으니까, attribute 대신 parameter
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<meta charset='utf-8'><title>redirect 연습</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h3>Redirect로 이동한 결과</h3>");
		
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
