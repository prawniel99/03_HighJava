package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/seLogin.do")
public class SeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("admin") && pw.equals("1234")) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			out.println("<h1>"+id+"님 반갑습니다</h1>");
			out.println("<a href='"+request.getContextPath()+"/basic/session/sessionExercise.jsp'>로그아웃</a>");
			response.sendRedirect(request.getContextPath()+"/basic/session/sessionExercise.jsp");
		} else {
			response.sendRedirect(request.getContextPath()+"/basic/session/sessionExercise.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
