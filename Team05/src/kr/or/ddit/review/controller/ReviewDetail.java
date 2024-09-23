package kr.or.ddit.review.controller;

import kr.or.ddit.image.service.IImageService;
import kr.or.ddit.image.service.ImageServiceImpl;
import kr.or.ddit.image.vo.ImageVO;
import kr.or.ddit.review.service.IReviewService;
import kr.or.ddit.review.service.ReviewServiceImpl;
import kr.or.ddit.review.vo.ReviewVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/reviewDetail.do")
public class ReviewDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 리뷰 ID를 파라미터로 받아옴
        String reviewId = request.getParameter("review_id").trim();

        // 리뷰 서비스 호출하여 리뷰 정보를 가져옴
        IReviewService reviewService = ReviewServiceImpl.getInstance();
        ReviewVO reviewOne = reviewService.reviewDetail(reviewId);

        // 이미지 서비스 호출하여 해당 리뷰에 연결된 이미지 리스트 가져오기
        IImageService imageService = ImageServiceImpl.getInstance();
        List<ImageVO> imageList = imageService.getImagesByTargetId(reviewId, "REVIEW");
        for (ImageVO image : imageList) {
        	System.out.println(image.getImageId());
        }
        
        // 리뷰 정보와 이미지 리스트를 request에 저장
        request.setAttribute("reviewVo", reviewOne);
        request.setAttribute("imageList", imageList);

        // 리뷰 상세보기 페이지로 포워딩
        request.getRequestDispatcher("/main?view=reviewView").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
