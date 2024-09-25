package kr.or.ddit.payment.controller;

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

import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.image.service.IImageService;
import kr.or.ddit.image.service.ImageServiceImpl;
import kr.or.ddit.image.vo.ImageVO;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.payment.service.IPaymentService;
import kr.or.ddit.payment.service.PaymentServiceImpl;
import kr.or.ddit.payment.vo.PaymentVO;


@WebServlet("/payment/paymentList.do")
public class PaymentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//memId갖고오는거임
		HttpSession session = request.getSession();
		String memId = (String) session.getAttribute("memId");

		if (memId == null) {
			MemberVO loggedInMember = (MemberVO) session.getAttribute("loggedInMember");
			if (loggedInMember != null) {
				memId = loggedInMember.getMemId(); // loggedInMember에서 memId 가져오기
			}
		}

        String cartId = CartServiceImpl.getInstance().getRecentPendingCart(memId);


		IPaymentService paymentService = PaymentServiceImpl.getInstance();

		IImageService imageService = ImageServiceImpl.getInstance();
		String prodId = null;

		List<PaymentVO> payList = paymentService.paymentList(memId, cartId);

		Map<String, ImageVO> imagesMap = new HashMap<>();


		for (PaymentVO payment : payList) {
			prodId = payment.getProd_id();
			List<ImageVO> imageList = imageService.getImagesByTargetId(prodId, "PROD");

			if (!imageList.isEmpty()) {
				imagesMap.put(prodId, imageList.get(0)); // 첫번째 이미지 매핑
			}
		}

		request.setAttribute("imagesMap", imagesMap);

		request.setAttribute("payList", payList);
		List<PaymentVO> couponList = paymentService.couponList(memId);
		request.setAttribute("couponList", couponList);

		List<PaymentVO> cardList = paymentService.cardList();
		request.setAttribute("cardList", cardList);

		request.getRequestDispatcher("/main?view=paymentList").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
