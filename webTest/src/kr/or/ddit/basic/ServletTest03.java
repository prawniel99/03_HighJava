package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

	서블릿 동작 과정
	1. 사용자(클라이언트)가 URL을 클릭하면 HTTP요청(request)을 Servlet Container로 전송(요청)한다.
	2. 컨테이너는 web.xml에 정의된 'url패턴'을 확인해서 어느 서블릿을 통해 처리해야 할 지를 검색한다.
	   (로딩이 안된 경우에는 로딩을 한다. 처음 로딩시 init()메소드가 호출된다.)
	   (서블릿 3.0 이상에서는 @WebServlet 어노테이션으로 설정할 수 있다.)
	3. 컨테이너는 개별 요청을 처리할 쓰레드를 생성하여 해당 서블릿 객체의 service() 메소드를 호출한다.
	   (이 때 HttpServletRequest객체와 HttpServletRespone객체를 생성하여 파라미터로 넘겨준다.)
	4. service() 메소드는 전송방식(GET, POST)을 체크하여 적절한 메소드를 호출한다.
	   (doGet(), doPost(), doPut(), doDelete() 등...)
	5. 요청 및 응답 처리가 모두 완료되면 HttpServletRequest객체와 HttpServletResponse객체는 자동으로 소멸된다.
	6. 컨테이너로 부터 서블릿이 제거되는 경우에는 destroy()메소드가 호출된다. 
	수정을 하면 몇초걸림? 9초걸리는데?
	두번째는 3초걸림, 2초걸림, 3초, 4초, 5초 뭐 이런식으로 그냥 걸리는것 같네. 자바단에 있는 부분이 수정이 되면 알아서 재부팅 됨.
	
*/

@WebServlet("/servletTest03.do")
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet: "+this.getServletName()+"에서 init()메소드 호출");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("service 메소드 호출");
		
		// GET방식과 POST방식에 맞는 메소드 호출하기
		
		// 방법1 ==> 부모 클래스인 HttpServlet의 service()메소드로 위임하기
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 메소드 시작");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset=utf-8></head>"
				+ "<body><h2 style='color:red;'>goGet() method에서 처리한 결과입니다</h2></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 메소드 시작");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset=utf-8></head>"
				+ "<body><h2 style='color:blue;'>goPost() method에서 처리한 결과입니다</h2></body></html>");
	}
	
	@Override
	public void destroy() {
		System.out.println(this.getServletName()+" 서블릿에서 destory() 메소드 호출");
		
	}

}
