package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieDelete.do")
public class CookieDeleteTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		
		// 저장된 쿠키 삭제하기
		
		
		// 1. 전체 쿠키 정보를 가져온다.
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<meta charset=utf-8><title>Cookie 읽기연습</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h3>Cookie 데이터 삭제하기</h3>");
		
		// 2. 쿠키 배열에서 삭제하려는 쿠키를 구해온다. (예: gender쿠키 삭제하기)
		if(cookieArr==null || cookieArr.length==0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다</h3>");
		} else {
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName(); // 쿠키 이름 구하기
				
				if("gender".equals(name)) { // 삭제하려는 쿠키 구하기
					// 3. 찾은 쿠키의 유지 시간을 0으로 설정한 후 다시 저장한다.
					cookie.setMaxAge(0); // 배열에서 불러온 쿠키의 맥스를 0으로 해서 즉시삭제가 되도록 하는 것.
					response.addCookie(cookie); // 그렇게 맥스 변경한 쿠키를 reponse에 저장함. 그럼 돌아가서 그 서버가 종료되면 바로 삭제되겠지?
					
				}
			}
		}
		
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest01.jsp'>시작 문서로 이동</a>"); // contextPath는 WebContent
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
























