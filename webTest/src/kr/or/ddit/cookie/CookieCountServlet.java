package kr.or.ddit.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieCountServlet")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int count = 0;
		// 증가된 count 값을 갖는 Cookie 객체 생성
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		
		// 쿠키 저장
		response.addCookie(countCookie);
		
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
