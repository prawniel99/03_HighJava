package kr.or.ddit.wish.dao;

import java.util.List;

import kr.or.ddit.wish.vo.WishListVO;

public interface IWishListDao {


    public int addToWishList(WishListVO wishVo);

    public int removeFromWishList(WishListVO wishVo);

    public boolean isProductWishListed(String memId, String prodId);
    
    public List<WishListVO> imageWish(String memId);
}
