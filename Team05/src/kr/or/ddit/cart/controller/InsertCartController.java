package kr.or.ddit.cart.controller;

import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.cart.vo.CartVO;
import kr.or.ddit.image.service.IImageService;
import kr.or.ddit.image.service.ImageServiceImpl;
import kr.or.ddit.image.vo.ImageVO;
import kr.or.ddit.member.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/cart/insertCart.do")
public class InsertCartController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //memId갖고오는거임
        HttpSession session = request.getSession();
        String memId = (String) session.getAttribute("memId");

        int result = 0;

        if (memId == null) {
            MemberVO loggedInMember = (MemberVO) session.getAttribute("loggedInMember");
            if (loggedInMember != null) {
                memId = loggedInMember.getMemId(); // loggedInMember에서 memId 가져오기
            }
        }
        String prodId = request.getParameter("prod_id");
        String optionId = request.getParameter("option2");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String action = request.getParameter("action");

        System.out.println("prodId = " + prodId);
        System.out.println("optionId = " + optionId);
        System.out.println("quantity = " + quantity);
        System.out.println("action = " + action);

        // cart 테이블에 데이터 삽입 (장바구니생성)
        ICartService service = CartServiceImpl.getInstance();

        // 'addToCart'라면 CART_STATUS가 'CART'인 장바구니 확인
        if ("addToCart".equals(action)) {
                // 장바구니는 몇개가 만들어져도 상관없음
                String cartId = service.insertCart(memId , "CART");
                service.insertDetailCart(cartId, optionId, prodId, quantity);
                double totalPrice = service.calculateTotalPrice(cartId);
                result =  service.updateCartTotalPrice(cartId, totalPrice);
            if (result > 0) {
                // 비동기 처리
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }

        // 'buyNow'라면 별도 처리
        else if ("buyNow".equals(action)) {
            //바로구매 cartId는 딱한개만존재해야함
            //제일 먼저 cart에서 pending인 cart_id 레코드가 있는지 확인하고 있으면 삭제함
            //없으면 삭제안하고 그대로 진행
            String pendingCartId = service.getPendingCartByMemId(memId);
            System.out.println("pendingCartId = " + pendingCartId);

            //만약 있으면삭제함
            if (pendingCartId != null) {
                int res = service.deletePendingCart(memId); //return값안주면 자꾸 실행안돼서 억지로추가함
            }



            // 결제 준비를 위해 새로운 카트 생성 후 결제 페이지로 이동
            String cartId = service.insertCart(memId, "PENDING");
            service.insertDetailCart(cartId, optionId, prodId, quantity);
            double totalPrice = service.calculateTotalPrice(cartId);
            result = service.updateCartTotalPrice(cartId, totalPrice);
            if (result == 1) {
                response.sendRedirect(request.getContextPath() + "/payment/paymentList.do");
            } else {
                System.out.println("실패한듯");
            }
        }

    }
}
