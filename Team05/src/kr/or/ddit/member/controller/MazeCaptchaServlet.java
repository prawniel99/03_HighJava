package kr.or.ddit.member.controller;

/**
 * 미로 CAPTCHA를 처리하는 서블릿
 * 
 * 이 서블릿은 로봇이 아님을 증명하기 위한 미로 퍼즐 CAPTCHA를 처리합니다.
 * URL 매핑: /member/mazeCaptcha.do
 * - 정석진 2024-09-23- 
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/mazeCaptcha.do")
public class MazeCaptchaServlet extends HttpServlet {
	// GET 요청 처리 메서드
	// 미로 CAPTCHA 페이지를 표시합니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 미로 CAPTCHA JSP 페이지로 포워딩
		request.getRequestDispatcher("/WEB-INF/views/member/mazeCaptcha.jsp").forward(request, response);
	}

	// POST 요청 처리 메서드
	// 미로 완료 여부를 처리하고 세션에 결과를 저장합니다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		// 미로가 완료되었음을 세션에 저장
		if ("complete".equals(action)) {
			session.setAttribute("captchaCompleted", true);

			// JSON 형식으로 성공 응답 전송
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print("{\"success\": true}");
			out.flush();
		}
	}
}