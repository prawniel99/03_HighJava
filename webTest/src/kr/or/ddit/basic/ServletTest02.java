package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

	이 예제는 어노테이션(@WebServlet)을 이용하여 Servlet을 등록하고 처리하는 예제
	이 어노테이션(@WebServlet)은 Servlet 버전 3.0 이상에서 사용할 수 있다.
	
	@WebServlet 어노테이션의 속성들
	1) name: 서블릿의 이름을 설정한다. (기본값: 빈문자열(""))
	2) urlPatterns: 서블릿의 URL패턴의 목록을 설정한다. (기본값: 빈배열({}))
	   예) urlPatterns="/url1" 또는 urlPatterns={"/url1"} ==> 패턴이 한개일 경우
	   예) urlPatterns={"/url1", "/url2", ...} ==> 패턴이 두개 이상일 경우
	3) value: urlPatterns와 동일한 기능을 한다.
	4) description: 주석(설명글)을 설정한다.

*/
/*
@WebServlet(
	name="servletTest02", // 이름은 별 의미가 없다.
	urlPatterns="/servletTest02.ddit", // 
	description="어노테이션을 이용한 서블릿 등록"
)
*/
@WebServlet("/servletTest02.ddit") // 동일한 방법임. 이걸 더 많이 씀. 그냥 이거 쓰면 됨.
public class ServletTest02 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		// 처리한 내용 출력하기
		// 방법2) print() method, println() method, printf() method
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>두번째 Servlet</title></head>");
		out.println("<body>");
		out.println("<h1 style='text-align:center; color:blue;'>안녕하세요 두번째 Servlet 입니다. (어노테이션 이용한 예제)</h1>");
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}











































