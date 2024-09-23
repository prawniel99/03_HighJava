package kr.or.ddit.coupon.service;

import java.util.List;

import kr.or.ddit.coupon.vo.CouponVO;

public interface ICouponService {
	
	public int coupInsert(String memId);
	
	public int couponInsert(CouponVO coupVo);
	
	public List<CouponVO> couponList();
	
	public List<CouponVO> memId();
	
	public int batchCoupInsertAll();
	
	public int batchCouponInsertAll(CouponVO coupon);
	
	public List<CouponVO> mileCoupon(String memId);
	
	public int deleteCoupon(String coupId);
}
