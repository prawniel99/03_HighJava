package kr.or.ddit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mainHAMIN")
public class FrontControllerHAMIN extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String viewName = request.getParameter("view");
        String page = "/indexHAMIN.jsp"; // 기본 페이지

        if (viewName != null) {
            switch (viewName) {
                case "indexHAMIN":
                    page = "/indexHAMIN.jsp";
                    break;
                case "myPage":
                    page = "/WEB-INF/views/member/myPageHAMIN.jsp";
                    break;
                case "prodList":
                    page = "/WEB-INF/views/prod/prodListHAMIN.jsp";
                    break;
                case "wishList":
                    page = "/WEB-INF/views/wish/wishListHAMIN.jsp";
                    break;
                case "login":
                    page = "/WEB-INF/views/member/LoginHAMIN.jsp";
                    break;
                case "noticeList":
                    page = "/WEB-INF/views/notice/noticeListHAMIN.jsp";
                    break;
                case "notiDetail":
                    page = "/WEB-INF/views/notice/noticeDetailHAMIN.jsp";
                    break;
                case "insertNotice":
                    page = "/WEB-INF/views/notice/insertNoticeHAMIN.jsp";
                    break;
                case "updateNotice":
                    page = "/WEB-INF/views/notice/updateNoticeHAMIN.jsp";
                    break;
                case "review":
                    page = "/WEB-INF/views/review/reviewMainHAMIN.jsp";
                    break;
                case "report":
                    page = "/WEB-INF/views/report/adminReportViewHAMIN.jsp";
                    break;
                case "paymentInsert":
                    page = "/WEB-INF/views/payment/paymentListHAMIN.jsp";
                    break;
                case "prodListView":
                    page = "/WEB-INF/views/prod/prodListViewHAMIN.jsp";
                    break;
    	        // 변하민 수정 지점
    	        case "qnaMain":
    	          	page = "/WEB-INF/views/qna/qnaMainHAMIN.jsp";
    	          	break;
    	        case "qnaProdTemp":
    	        	page = "/WEB-INF/views/qna/qnaProdTempHAMIN.jsp";
    	          	break;
    	        case "adminDashboardHAMIN":
    	        	page = "/WEB-INF/views/admin/dashboardHAMIN.jsp";
    	        	break;
    	        case "memberListHAMIN":
    	        	page = "/WEB-INF/views/member/memberListHAMIN.jsp";
    	        	break;
    	        // 변하민 수정 지점
    	        

                // 필요한 페이지를 더 추가하면 됩니다.
            }
        }

        // 메인 레이아웃에 페이지 전달
        request.setAttribute("contentPage", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mainLayoutHAMIN.jsp");
        dispatcher.forward(request, response);
    }
}
