package kr.or.ddit.wish.service;

import kr.or.ddit.wish.dao.IWishListDao;
import kr.or.ddit.wish.dao.WishListDaoImpl;
import kr.or.ddit.wish.vo.WishListVO;

import java.util.List;

public class WishListServiceImpl implements IWishListService {

    private IWishListDao dao;

    private WishListServiceImpl() {
        dao = WishListDaoImpl.getInstance();
    }

    private static IWishListService service;

    public static IWishListService getInstance() {
        if (service == null) {
            service = new WishListServiceImpl();
        }
        return service;
    }


    @Override
    public int addToWishList(WishListVO wishVo) {
        return dao.addToWishList(wishVo);
    }

    @Override
    public int removeFromWishList(WishListVO wishVo) {
        return dao.removeFromWishList(wishVo);
    }

    @Override
    public boolean isProductWishListed(String memId, String prodId) {
        return dao.isProductWishListed(memId, prodId);
    }


	@Override
	public List<WishListVO> imageWish(String memId) {
		// TODO Auto-generated method stub
		return dao.imageWish(memId);
	}
}
