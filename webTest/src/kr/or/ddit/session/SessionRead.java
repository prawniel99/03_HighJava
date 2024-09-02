package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장된 Session 정보 읽어오기
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 1. Session 객체를 생성하거나 현재 Session 가져오기
		HttpSession session = request.getSession();
		
		// 2. Session객체에 setAttribute() 메소드로 저장한 값을
		//    setAttribute() 메소드를 이용하여 가져온다.
		// 형식) Session객체.getAttribute("key값");
		
		out.println("<html>");

		out.println("<head>");
		out.println("<meta charset='utf-8'><title>Session 연습</title>");
		out.println("</head>");
		
		// Session값 가져오기
		String sessionValue = (String)session.getAttribute("testSession");
		
		if(sessionValue == null) {
			out.println("<h3>testSession의 세션값이 없습니다.</h3>");
		} else {
			out.println("testSession의 세션값: " + sessionValue + "<br>");
		}
		out.println("<hr>");

		out.println("");
		
		out.println("<h3>전체 Session 정보 확인하기</h3>");
		out.println("<ol>");
		
		// Session의 전체 key값 가져오기
		Enumeration<String> sessionNames = session.getAttributeNames(); // iterator의 옛날버전이라고 보면 됨

		int cnt = 0; // session 정보의 개수가 저장될 변수
		while(sessionNames.hasMoreElements()) {
			cnt++;
			String key = sessionNames.nextElement();
			out.println("<li>" + key + " : " + session.getAttribute(key) + "</li>");
		}
		
		if(cnt == 0) {
			out.println("<li>Session 정보가 하나도 없습니다.</li>");
		}
		
		out.println("</ol>");
		out.println("<hr>");
		
		out.println("세션ID: " + session.getId() + "<br>");
		// 얘는 개발자도구 Application 탭에서 Storage 아래 Cookies 안에 JSESSIONID에 있다.
		// session은 서버에 있다.
		// 서버는 매우 많은 클라이언트의 요청이 있는데, 그 중 누구인지 구분을 할 수 있어야 함.
		// 그래서 이 값을 클라이언트에 쿠키로 보내서 그 클라이언트가 접속하면 이 세션 아이디를 사용해서 찾음.
		// session을 구분하기 위한 id 임.
		
		// 생성시간 ==> 1970년 1월 1일부터 경과한 시간 (밀리세컨드 단위)
		out.println("세션 생성 시간: " + session.getCreationTime() + "<br>");
		// 
		
		// 최근 접근 시간 ==> 1970년 1월 1일부터 경과한 시간 (밀리세컨드 단위)
		out.println("세션 최근 접근 시간: " + session.getLastAccessedTime() + "<br>");
		
		// 
		out.println("세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");
		out.println("");
		out.println("");
		out.println("");
		
		
		out.println("<a href='"+request.getContextPath()+"/basic/session/sessionTest.jsp'>시작문서로이동</a>");
		
		out.println("<body>");
		out.println("</body>");
		
		out.println("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
