package kr.or.ddit.coupon.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.coupon.vo.CouponVO;
import kr.or.ddit.util.MybatisUtil;

public class CouponDaoImpl implements ICouponDao {

	private static CouponDaoImpl dao;

	private CouponDaoImpl() {
	}

	public static CouponDaoImpl getInstance() {
		if (dao == null)
			dao = new CouponDaoImpl();

		return dao;
	}

	@Override
	public int couponInsert(CouponVO coupVo) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = MybatisUtil.getSqlSession();

			cnt = session.insert("coupon.couponInsert", coupVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return cnt;
	}

	@Override
	public List<CouponVO> couponList() {
		SqlSession session = null;
		List<CouponVO> couponList = null;

		try {
			session = MybatisUtil.getSqlSession();

			couponList = session.selectList("coupon.couponList");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return couponList;
	}

	@Override
	public int coupInsert(String memId) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = MybatisUtil.getSqlSession();

			cnt = session.insert("coupon.coupInsert", memId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return cnt;
	}

	@Override
	public List<CouponVO> memId() {
		SqlSession session = null;
		List<CouponVO> couponList = null;

		try {
			session = MybatisUtil.getSqlSession();

			couponList = session.selectList("coupon.memId");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return couponList;
	}
	@Override
	public int batchCoupInsertAll() {
	    SqlSession session = MybatisUtil.getSqlSession();
	    int result = 0;
	    try {
	        result = session.insert("coupon.batchCoupInsertAll");
	    } finally {
	        session.commit();
	        session.close();
	    }
	    return result;
	}

	@Override
	public int batchCouponInsertAll(CouponVO coupon) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    int result = 0;
	    try {
	        result = session.insert("coupon.batchCouponInsertAll", coupon);
	    } finally {
	        session.commit();
	        session.close();
	    }
	    return result;
	}

	@Override
	public List<CouponVO> mileCoupon(String memId) {
		SqlSession session = null;
		List<CouponVO> coupList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			coupList = session.selectList("coupon.mileCoupon", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return coupList;
	}

	@Override
	public int deleteCoupon(String coupId) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = MybatisUtil.getSqlSession();

			cnt = session.delete("coupon.deleteCoupon", coupId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return cnt;
	}




}
