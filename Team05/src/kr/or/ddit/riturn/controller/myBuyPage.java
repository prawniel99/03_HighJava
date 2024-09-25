 package kr.or.ddit.riturn.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.image.service.IImageService;
import kr.or.ddit.image.service.ImageServiceImpl;
import kr.or.ddit.image.vo.ImageVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.payment.vo.PaymentVO;
import kr.or.ddit.riturn.service.IRiturnService;
import kr.or.ddit.riturn.service.RiturnServiceImpl;
import kr.or.ddit.riturn.vo.RiturnVO;


@WebServlet("/riturn/myBuyPage.do")
public class myBuyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//memId갖고오는거임
		HttpSession session = request.getSession();
		String memId = (String) session.getAttribute("memId");

		if (memId == null) {
			MemberVO loggedInMember = (MemberVO) session.getAttribute("loggedInMember");
			if (loggedInMember != null) {
				memId = loggedInMember.getMemId(); // loggedInMember에서 memId 가져오기
			}
		}
		
		IRiturnService service = RiturnServiceImpl.getInstance();
		
		List<RiturnVO> riturnList = service.myBuyList(memId);

		IImageService imageService = ImageServiceImpl.getInstance();

		Map<String, ImageVO> imagesMap = new HashMap<>();

		for (RiturnVO riturn : riturnList) {
			String prodId = riturn.getProd_id();
			List<ImageVO> imageList = imageService.getImagesByTargetId(prodId, "PROD");

			if (!imageList.isEmpty()) {
				imagesMap.put(prodId, imageList.get(0)); // 첫번째 이미지 매핑
			}
		}
		
		request.setAttribute("riturnList", riturnList);
		request.setAttribute("imagesMap", imagesMap);
		
		request.getRequestDispatcher("/main?view=myOrder").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
