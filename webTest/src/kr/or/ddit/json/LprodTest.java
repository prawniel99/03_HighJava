package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import kr.or.ddit.util.MybatisUtil;

@WebServlet("/json/lprodTest.do")
public class LprodTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// String a = request.getAttribute("table");
		// String b = request.getParameter("table");
		// String c = request.getParameter("test");
		// System.out.println(b+c);
		
		Gson gson = new Gson();
		// LprodVO vo = new LprodVO();
		SqlSession session = null;
		
		List<String> ing = new ArrayList<String>();
		
		try {
			session = MybatisUtil.getSqlSession();
			// vo = (LprodVO)session.selectList("lprod.getLprodAll");
			ing = session.selectList("lprod.getLprodAll"); // 이거 selectOne 일때 콤마찍고 뒤에 뭐 있는 이유가 그 값을 대입하려고 하는거네.
			// 예를 들어, 뒤에 memVo를 줬다고 생각해봐. memVo는 MemberVO 라는 VO 클래스 객체잖아.
			// 그 VO 클래스 안에는 이런게 있겠지
			// private String mem_id;
			// private String mem_name;
			// 그럼 쿼리를 보낼때, namespace="member" 에서 select 태그 id="getMember" 이라고 치면 그 안에,
			// select * from member where mem_id = ${mem_id} and mem_name = ${mem_name} 이렇게 써져있겠지.
			// 보임? 참조하는 그 VO 클래스에 있는 그 멤버값을 사용해서 어떤 값을 어디에 넣는지 확인하는거지.
			// 저번에 뭐 쿼리 쓰고 ? 쓰고 할 때, ? 가 열개면 열개 순서대로 넣었어야 하잖아
			// 근데 이거는 '이름'을 주니까, 뭐가 뭔지 순서를 딱히 구분할 필요는 없고,
			// 순서는 부가적인거고 일단 저런식으로, VO클래스와 멤버 그리고 참조객체를 사용해서
			// mapper에 만들어둔 것을 정확하게 지정해서 실행을 시키는거고
			// 이게 정확하게 실행되려면 이제 config 파일에서 넣어야 하는건데,
			// 자 그럼 이제 config가 어떻게 구성이 되길래 이게 mybatis 뭐가 되는건지는 이제
			// 더 생각을 해봐야 하는거지. 일단 여기까지만 이해를 하자.
			// System.out.println(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		String jsonData = null;
		jsonData = gson.toJson(ing);
		PrintWriter out = response.getWriter();
		out.write(jsonData);

		// System.out.println(jsonData);
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
