package kr.or.ddit.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;

@WebServlet("/sessionLoginDb.do")
public class SessionLoginDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		// id와 password 받기
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pw");
		
		// id와 password를 VO에 저장
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userId);
		memVo.setMem_pass(userPass);
		
		// service 객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		// id와 password가 일치하는 회원을 검색하여 가져오기
		MemberVO loginMember = service.getLoginMember(memVo);
		System.out.println(loginMember);
		
		if(loginMember != null) { // 로그인 성공
			session.setAttribute("loginMemVo", loginMember);
		}
		
		response.sendRedirect(request.getContextPath()+"/basic/session/sessionLoginDb.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
