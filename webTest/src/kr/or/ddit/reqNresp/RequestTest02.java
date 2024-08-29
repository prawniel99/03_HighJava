package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String num1 = request.getParameter("num1");
		String calc = request.getParameter("calc");
		String num2 = request.getParameter("num2");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<meta charset='utf-8'><title>Request객체연습2: 계산하기</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("");
		out.println("<hr>");
		out.println("<h1>계산 결과</h1>");
		out.println("<hr>");
		out.println(num1);
		out.println(calc);
		out.println(num2);
		out.println("=");
		int no1 = Integer.valueOf(num1);
		int no2 = Integer.parseInt(num2);
		double result = 0.0;
		boolean calcOk = true;
		
		if(calc.equals("+")) result = no1 + no2;
		else if(calc.equals("-")) result = no1 - no2; 
		else if(calc.equals("*")) result = no1 * no2;
		else if(calc.equals("/")) {
			if(no2!=0) result = (double)no1 / no2;
			else calcOk = false;
		} else {
			if(no2!=0) result = no1 % no2;
			else calcOk = false;
		}
		if(calcOk==true) out.println(result);
		else out.println("계산 불가능<br>");
		
		out.println("</body>");
		
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
