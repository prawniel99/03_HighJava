package a.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import a.vo.Avo;
import util.MybatisUtil;

@WebServlet("/cservlet")
public class Cservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// service 부를거면 service 부르는거고
		// dao 부를거면 dao 부르는거고
		// 바로 sql 실행할거면 실행하는거고
		SqlSession session = MybatisUtil.getSqlSession();
		List<Avo> list = session.selectList("member.memberList");
		for(Avo mem : list) {
			System.out.println("id: " + mem.getMem_id());
			System.out.println("pw: " + mem.getMem_pass());
			System.out.println("nm: " + mem.getMem_name());
			System.out.println("------------");
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/ajsp/memberList.jsp").forward(request, response);
	}
}
