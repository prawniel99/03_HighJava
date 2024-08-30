package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 저장된 쿠키 정보를 읽어오는 서블릿
@WebServlet("/cookieRead.do")
public class CookieReadTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		
		// 저장된 쿠키 읽어오기
		
		// 1. 전체 쿠키 정보를 Request객체를 통해서 가져온다.
		//    ==> 가져온 쿠키 정보들을 배열에 저장한다.
		// 형식) Cookie[] 쿠키배열변수 = Request객체.getCookies();
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<meta charset=utf-8><title>Cookie 읽기연습</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h2>저장된 Cookie 데이터 확인하기</h2><br><br>");
		
		if(cookieArr==null || cookieArr.length==0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");
		} else {
			for(Cookie cookie : cookieArr) {
				// 쿠키 이름 가져오기
				String name = cookie.getName();

				// 쿠키값 가져오기 ==> 저장된 쿠키값이 한글일 경우 URLEncoder.decode() 메소드를 이용하여
				//					   디코딩한 후 사용한다.
				String value = cookie.getValue();
				
				out.println("쿠키이름: "+name+"<br>");
				out.println("쿠키값: "+value+"<hr>");
			}
		}
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest01.jsp'>시작 문서로 이동</a>"); // contextPath는 WebContent
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
