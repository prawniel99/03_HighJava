package kr.or.ddit.payment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;  // JSON 응답을 위해 GSON 라이브러리 사용
import java.io.PrintWriter;

import kr.or.ddit.payment.service.IPaymentService;
import kr.or.ddit.payment.service.PaymentServiceImpl;
import kr.or.ddit.payment.vo.PaymentVO;

@WebServlet("/payment/mileageUpdate.do")
public class MileageUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        
        // 파라미터로 받은 값들을 처리
        String memId = request.getParameter("memId");
        int memmileage = Integer.parseInt(request.getParameter("mem_mileage"));
        System.out.println("꺼낸 값"+memmileage);
        

        
        // 서비스 호출
        IPaymentService service = PaymentServiceImpl.getInstance();
        PaymentVO payVo = new PaymentVO();
        payVo.setMem_mileage(memmileage);
        payVo.setMem_id(memId);
        
        int cnt = service.mileageUpdate(payVo);
        
        // JSON 응답 설정
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        // JSON 객체 생성
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("result", cnt);
        jsonResponse.addProperty("memMileage", memmileage);
        
        // 출력 스트림을 사용해 클라이언트에 JSON 응답을 보냄
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}
