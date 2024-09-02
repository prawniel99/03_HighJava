package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 1. Session 객체를 생성하거나 현재 Session 가져오기
		HttpSession session = request.getSession();
		
		// 2. Session 정보 삭제하기
		// 방법1) Session 객체의 removeAttribute() 메소드를 이용하여 개별적인 'Session값' 삭제하기
		// 형식) Session객체.removeAttribute("삭제할 key값");
		// session.removeAttribute("testSession");
		
		// 방법2) Session객체의 invalidate() 메소드를 이용하여 'Session' 자체를 삭제하기
		// 형식) Session객체.invalidate();
		session.invalidate();
		//----------------------------------------------------
		
		out.println("<html>");

		out.println("<head>");
		out.println("<meta charset='utf-8'><title>Session 연습</title>");
		out.println("</head>");
		
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		
		
		out.println("<h3>Session 정보 삭제하기</h3>");
		
		out.println("<a href='"+request.getContextPath()+"/basic/session/sessionTest.jsp'>시작문서로이동</a>");
		
		out.println("<body>");
		out.println("</body>");
		
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
