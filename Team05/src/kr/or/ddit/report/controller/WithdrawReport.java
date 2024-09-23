package kr.or.ddit.report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.report.service.IReportService;
import kr.or.ddit.report.service.ReportServiceImpl;
import kr.or.ddit.report.vo.ReportVO;

/**
 * Servlet implementation class WithdrawReport
 */
@WebServlet("/withdrawReport.do")
public class WithdrawReport extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportId = request.getParameter("report_id");
        
        if (reportId != null && !reportId.isEmpty()) {
            // ReportVO 객체 생성 및 설정
            ReportVO reVo = new ReportVO();
            reVo.setReport_id(reportId);

            IReportService service = ReportServiceImpl.getInstance();
            try {
                int cnt = service.adminUpdate(reVo);
                
                if (cnt > 0) {
                    // 업데이트 성공 시 성공 페이지로 리다이렉트
                	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/report/updateSuccess.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // 업데이트 실패 시 에러 페이지로 리다이렉트
                	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/report/updateFail.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (Exception e) {
                // 예외 처리 및 에러 페이지로 리다이렉트
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/WEB-INF/views/report/updateFail.jsp");
            }
        } else {
            // report_id 파라미터가 없거나 빈 경우 에러 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/WEB-INF/views/report/updateFail.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
