package a.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aservlet.do")
public class Aservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("if there is nothing specified, it's always get");
		out.println("<a href=\""+request.getContextPath()+"/ajsp/main.jsp\">go</a>");
		out.println("</body>");
		out.println("<html>");
		
		// request.getRequestDispatcher("/basic/fileUpload/fileList.jsp").forward(request, response);
		// request.getRequestDispatcher("/ajsp/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("is this post?");
		out.println("</body>");
		out.println("<html>");
	}
}
