package kr.or.ddit.coupon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.coupon.service.CouponServiceImpl;
import kr.or.ddit.coupon.service.ICouponService;
import kr.or.ddit.coupon.vo.CouponVO;

@WebServlet("/coupon/couponInsert.do")
public class CouponInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		ICouponService service = CouponServiceImpl.getInstance();
		
		List<CouponVO> coupList = service.memId();
		
		request.setAttribute("coupList", coupList);
		
		request.getRequestDispatcher("/main?view=adminCouponInsert").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("mem_id");
		String coupEdate = request.getParameter("coup_edate");
		int coupAmount = Integer.parseInt(request.getParameter("coup_amount"));
		String coupName = request.getParameter("coup_name");
		
		
		ICouponService service = CouponServiceImpl.getInstance();
		
		CouponVO coupVo = new CouponVO();
		coupVo.setCoup_edate(coupEdate);
		coupVo.setCoup_amount(coupAmount);
		coupVo.setCoup_name(coupName);
		
		int cnt = service.coupInsert(memId);

		int cnt2 = service.couponInsert(coupVo);
		
		response.sendRedirect(request.getContextPath() + "/coupon/couponList.do");
		
	}


}
