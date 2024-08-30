package kr.or.ddit.cookie.excercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class Login extends HttpServlet {
	public static Cookie idCookie = new Cookie("id", "");
	public static Cookie checked = new Cookie("re", null);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String re = request.getParameter("re"); // checked = on / unchecked = null
		
		if(!id.equals("admin") && !pw.equals("admin")) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/basic/cookie/exercise/loginPage.jsp");
	        idCookie.setValue("");
	        checked.setValue(null);
	        dispatcher.forward(request, response);
		}
		
		if(re!=null) {
			if(id.equals("admin") && pw.equals("admin") && re.equals("on")) {
				out.println("어드민!");
				idCookie.setValue(id);
				checked.setValue(re);
			}
		} else {
			idCookie.setValue("");
			checked.setValue(null);
		}
		
		response.addCookie(idCookie);
		response.addCookie(checked);
		
		
		out.println("hello");
		out.println(id);
		out.println(pw);
		out.println(re);
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/exercise/loginPage.jsp'>로그인 페이지로 이동</a>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
