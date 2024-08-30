package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitReset.do")
public class VisitReset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		
		VisitCount.visitCountCookie.setValue("0");
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<meta charset=utf-8><title>Cookie 읽기연습</title>");
		out.println("<style>body{font-size: 80px; margin: 100px;}</style>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h3>count가 초기화 되었습니다.</h3>");
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>"); // contextPath는 WebContent
		out.println("</body>");
		out.println("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
