package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	
/*
	
	서블릿이란? ==> 컨테이너(서블릿 엔진)에 의해 관리되는 자바 기반 웹 커포넌트로서
	  				동적인 웹 컨텐츠 생성을 가능하게 해준다.
	
	전체URL주소 ==> http://localhost:8080/webTest/servletTest01.do
	- http: 프로토콜
	- localhost: 컴퓨터이름(도메인명) 또는 IP주소
	- 8080: Port번호(port번호가 80번일 경우에는 생략가능하다.) 왜? 우리가 포트번호를 80으로 설정했기 때문에?
	- /webTest: 컨텍스트패스(보통 웹프로젝트 이름이 사용된다.)
	- /servletTest01.do: 서블릿 요청 URL패턴

*/

// 이 예제는 배포서술자(DD, Deployment Descriptor => web.xml)를 이용해서 

// Servlet 클래스는 HttpServlet 클래스를 상속해서 작성한다.
public class ServletTest01 extends HttpServlet {
	/*
		- Servlet 클래스에서는 service()메소드 또는 doGet() 메소드, doPost() 메소드를 재정의해서 작성한다.
		
		- doGet() 메소드나 doPost()메소드는 service() 메소드를 통해서 호출된다.
		
		- 메소드의 매개변수로 주어지는 객체
		1) HttpServletRequest object ==> 서비스 요청에 관련된 정보 및 메소드를 관리하는 객체
		2) HttpServletResponse object ==> 서비스 응답에 관련된 정보 및 메소드를 관리하는 객체
	*/
	
	// goGet() method ==> get 방식의 요청을 처리하는 method
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); // 응답 문서의 인코딩 방식 지정
		response.setContentType("text/html; charset=utf-8"); // 응답 문서의 ContentType 지정
		
		// 처리한 내용을 응답으로 보내기 위해 PrintWriter객체(스트림객체)를 생성한다.
		PrintWriter out = response.getWriter();
		
		// 처리한 내용을 출력한다. (==> 클라이언트에게 처리된 결과를 보내준다.)
		// 방법1: append() 메소드 이용하기
		out
		/*
		.append("<html>")
		   .append("<head>")
		   .append("<meta charset='utf-8'>")
		   .append("<title>첫번째 Servlet 문서</title>")
		   .append("</head>")
		   .append("<body>")
		   .append("<h1 style='text-align:center;'>안녕하세요. 첫번째 Servlet입니다.</h1>")
		   .append("</body>")
		   .append("</html>")
		*/
		.append("<!DOCTYPE html><html lang='ko'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>멋진 웹 페이지</title><style>body {font-family: 'Arial', sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; display: flex; flex-direction: column; align-items: center; justify-content: center; height: 100vh; color: #333;} header {background-color: #333; color: #fff; width: 100%; text-align: center; padding: 20px 0; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);} h1 {margin: 0; font-size: 2.5rem;} main {text-align: center; padding: 20px;} button {padding: 10px 20px; font-size: 1rem; color: #fff; background-color: #007BFF; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s;} button:hover {background-color: #0056b3;} footer {margin-top: auto; background-color: #333; color: #fff; width: 100%; text-align: center; padding: 10px 0; position: absolute; bottom: 0;}</style></head><body><header><h1>Welcome to My Awesome Web Page</h1></header><main><p>Click the button below to see a greeting message!</p><button onclick='showMessage()'>Click Me!</button><p id='greeting' style='margin-top: 20px; font-size: 1.5rem;'></p></main><footer><p>&copy; 2024 My Awesome Web Page</p></footer><script>function showMessage() {document.getElementById('greeting').textContent = 'Hello, welcome to my awesome web page!';}</script></body></html>\r\n");
	}
	
	// doPost() method ==> post 방식의 요청을 처리하는 method
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
