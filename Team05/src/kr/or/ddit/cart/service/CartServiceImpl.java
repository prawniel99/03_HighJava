package kr.or.ddit.cart.service;

import kr.or.ddit.cart.dao.CartDaoImpl;
import kr.or.ddit.cart.dao.ICartDao;
import kr.or.ddit.cart.vo.CartVO;

import java.util.Collections;
import java.util.List;

public class CartServiceImpl implements ICartService {

    private ICartDao dao;

    private CartServiceImpl() {
        dao = CartDaoImpl.getInstance();
    }

    private static ICartService service;

    public static ICartService getInstance() {
        if (service == null) {
            service = new CartServiceImpl();
        }
        return service;
    }

    @Override
    public String insertCart(String memId, String action) {
        return dao.insertCart(memId, action);
    }

    @Override
    public void insertDetailCart(String cartId, String optionId, String prodId, int quantity) {
        dao.insertDetailCart(cartId, optionId, prodId, quantity);
    }

    public double calculateTotalPrice(String cartId){
        //바로 가격총합구해야함
        return dao.calculateTotalPrice(cartId);
    }

    public int updateCartTotalPrice(String cartId, double totalPrice){
        //총합 구한걸 업데이트하고 성공 실패여부 int값 반환
        return dao.updateCartTotalPrice(cartId, totalPrice);
    }

    public int updateCartStatus(String cartId, String status) {
        return dao.updateCartStatus(cartId, status);
    }

    @Override
    public String getRecentPendingCart(String memId) {
        return dao.getRecentPendingCart(memId);
    }

    @Override
    public String getPendingCartByMemId(String memId) {
        return dao.getPendingCartByMemId(memId);
    }

    @Override
    public int deletePendingCart(String memId) {
        return dao.deletePendingCart(memId);
    }

    @Override
    public String getCartIdByMemId(String memId, String cart) {
        return dao.getCartIdByMemId(memId, cart);
    }

    @Override
    public List<CartVO> getCartListByMemId(String memId) {
        return dao.getCartListByMemId(memId);
    }

	@Override
	public List<String> getProdId(String memId) {
		// TODO Auto-generated method stub
		return dao.getProdId(memId);
	}

	@Override
	public int removeCartItem(String cartId) {
		// TODO Auto-generated method stub
		return dao.removeCartItem(cartId);
	}

}
