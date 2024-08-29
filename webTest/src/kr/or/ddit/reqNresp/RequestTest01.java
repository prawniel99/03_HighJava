package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest01
 */
@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식으로 전달되는 데이터의 문자 인코딩 방식 설정
		// request로 넘어옴
		request.setCharacterEncoding("utf-8");
		
		// 전달되는 데이터 받기
		// 형식1) Request객체.getParameter("파라미터명");
		//		  ==> 지정한 '파라미터명'에 설정된 '값'을 가져온다.
		//		  ==> 가져오는 '값'의 자료형은 'String'이다.
		//		  ==> 파라미터명은 스크립트에 있는 name속성과 동일해야 한다.
		//		  ==> value가 있으면 value 값이 데이터가 되고, 없으면 태그 사이 내용이 데이터가 된다.
		String userName = request.getParameter("username");
		String job = request.getParameter("job");
		
		// 형식2) Request객체.getParameterValues("파라미터명");
		//		  ==> '파라미터명'이 같은 것이 여러개일 경우 사용한다.
		//		  ==> 가져오는 '값'의 자료형은 'String[]'이다.
		String[] hobbies = request.getParameterValues("hobby");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 오옹.. 이거 out 뭐야!!
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'><title>Request객체연습</title>");
		
		out.println("<style>");
		out.println("body{background: rgb(0,98,65); color: white;}");
		out.println("h2{text-align: center; margin-top: 60px}");
		out.println("#h1{text-align: center; margin-top: 100px}");
		out.println("body table{width: 300px; position: relative; left: calc(50% - 150px); text-align: center; border-color: rgb(233, 240,228);}");
		out.println("li{margin-left: 40%;}");
		out.println("</style>");
		
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h2 id='h1'>수신 받은 자료들</h2>"
				+ "<table border='1'>");
		
		out.println("<tr><td>이름</td>"
				+ "<td>"+userName+"</td></tr>");
		
		out.println("<tr><td>직업</td>"
				+ "<td>"+job+"</td></tr>");

		out.println("<tr><td>취미</td>"
				+ "<td>");
		if(hobbies!=null) {
			// 일반 for문
			for(int i=0; i<hobbies.length; i++) {
				out.println(hobbies[i]+"<br>");
			}
			out.println("<br>");
			
			// 향상된 for문
			for(String hobby : hobbies) {
				out.print(hobby + "<br>");
			}
		}
		out.println("</td></tr>");
		out.println("</table>");
		
		out.println("");
		out.println("<br><br><br><hr>");
		out.println("<h2>HttpServletRequest객체의 메소드들</h2>");
		out.println("<ol>");
		out.println("<li>클라이언트의 IP주소: "+request.getRemoteAddr()+"</li>");
		out.println("<li>요청 메소드: "+request.getMethod()+"</li>");
		out.println("<li>ContextPath: "+request.getContextPath()+"</li>");
		out.println("<li>프로토콜: "+request.getProtocol()+"</li>");
		out.println("<li>URL 정보: "+request.getRequestURL()+"</li>");
		out.println("<li>URI 정보: "+request.getRequestURI()+"</li>");
		out.println("");
		
		out.println("<body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
