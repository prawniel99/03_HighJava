package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 쿠키 정보를 저장하는 서블릿
@WebServlet("/cookieAdd.do")
public class CookieAddTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter(); // 이게 뭘까. printwriter은 어디 클래스고, getwriter은 뭔 메소드고
		
		// Cookie 저장하는 방법
		
		// 1. Cookie 객체를 생성한다. ==> '쿠키 이름'과 '쿠키값'을 문자열로 지정하여 생성한다.
		// 형식) Cookie cookie변수 = new Cookie("쿠키이름", "쿠키값");
		// ==> 쿠키값이 한글일 경우, URLEncoder.encode() method로 인코딩한 후 저장한다.
		// ==> 하나의 쿠키는 4KB(4,096byte)까지 저장 가능 // 쿠키는 파일 유형이 뭐지!
		// ==> 하나의 도메인 당 20개(총 300개) 까지 저장 가능 // 도메인이 뭘까
		Cookie nameCookie = new Cookie("name", "홍길동");
//		Cookie ageCookie = new Cookie("age", 20); // 문자여야 함
//		Cookie ageCookie = new Cookie("age", "20");
//		Cookie ageCookie = new Cookie("age", 20+"");
		Cookie ageCookie = new Cookie("age", String.valueOf(20));
		Cookie genderCookie = new Cookie("gender", "Male");
		
		// 2. 쿠키 속성을 설정한다.
		// 쿠키변수.setPath("적용경로"); // ==> 지정한 경로와 그 하위 경로에서만 사용 가능하다.
										 // ==> 생략하면 쿠키를 저장할 당시의 경로가 설정된다.
										 // ==> 저장 경로가 아니라 적용. 상위 폴더로 해두면 하위 경로에서 모두 사용 가능.
		// 쿠키변수.setMaxAge(유지시간); // ==> 단위(초)
										 // ==> -1 : 브라우저가 종료될 때 까지 유지된다.(이게 기본값)
										 // ==> 0: 즉시 삭제된다. (만드는 이유가 없네 그럼)
										 // ==> 이 초는 누가 셈? 컴터 꺼도 됨? 안되겄지 당연히.
		// 쿠키변수.setDomain("적용도메인명") // ==> 예) ".ddit.or.kr"
		//											 www.ddit.or.kr, mail.ddit.or.kr, cafe.ddit.or.kr 뭐 다 가능
		
		// 쿠키변수.setSecure(보안여부); // ==> true: 적용, false: 미적용(기본값)
										 // ==> 'https' 프로토콜에서는 true값으로 설정해야 사용할 수 있다.
		
		// 3. Response객체를 이용하여 쿠키를 웹브라우저로 보내면 웹브라우저가 이 쿠키를 받아서 저장한다.
		// 형식) Response객체.addCookie(1번에서 만든 cookie객체);
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<meta charset=utf-8><title>Cookie 저장연습</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h3>Cookie 데이터가 저장되었습니다</h3><br><br>");
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest01.jsp'>시작 문서로 이동</a>"); // contextPath는 WebContent
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("</body>");
		
		
		out.println("</html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}































