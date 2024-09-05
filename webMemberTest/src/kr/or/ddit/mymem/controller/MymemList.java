package kr.or.ddit.mymem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mymem.service.IMymemService;
import kr.or.ddit.mymem.service.MymemServiceImpl;
import kr.or.ddit.mymem.vo.MymemVO;

@WebServlet("/mymemList.do")
public class MymemList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 컨트롤러에서 최초로 할 일은 서비스에 요청을 하는 것이다.
		// 이 컨트롤러는 리스트를 가져오는 클래스이다.
		// 그러므로 서비스 인터페이스로 연결하여 db에서 데이터 가져올 것을 요청해야한다.
		// 서비스 인터페이스 객체를 생성해서 서비스임플 인스턴스를 담는다.
		IMymemService service = MymemServiceImpl.getInstance();
		
		// mymemVO 타입의 리스으를 생성해서 전체 회원 정보를 가져오는 메소드를 서비스로 보낸다. 모든건 서비스로 보내기.
		// 이렇게 만들어두고 daoimpl 에서 sql 다녀오는 기능 만들면 됨. 그럼 거기서 mapper에 query만들고 다 할거임. 내가.
		List<MymemVO> mymemList = service.getAllMymem();
		
		// 이제 가져왔으면 뭐 해야해? request가 요청을 했으니 고생해서 가져온거잖아.
		// 그럼 이제 request에 담아줘야지.
		request.setAttribute("mymemList", mymemList);
		
		// 담았으면 이제 forward로 돌려보내줘
		request.getRequestDispatcher("/begin/mymemList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
