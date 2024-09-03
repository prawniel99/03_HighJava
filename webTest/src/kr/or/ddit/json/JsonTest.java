package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/json/jsonTest.do")
public class JsonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 응답 데이터를 JSON으로 할 때 설정
		response.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html; charset=utf-8"); // 이건 html로 보낼때
		response.setContentType("application/json; charset=utf-8");
		
		// 파라미터 데이터 받기
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson();
		
		// 처리한 결과를 JSON 형태의 문자열로 변환한 후 이 문자열을 응답으로 보낸다
		String jsonData = null;
		
		switch(choice) {
			case "string" :
				String str = "안녕하세요"; // 처리한 결과로 한다.
				jsonData = gson.toJson(str); // JSON 문자열로 변환
				break;
			case "array" :
				int[] intArr = {10,20,30,40,50};
				jsonData = gson.toJson(intArr);
				break;
			case "object" :
				SampleVO sampleVo = new SampleVO(1, "홍길동");
				jsonData = gson.toJson(sampleVo);
				break;
			case "list" :
				List<SampleVO> sampleList = new ArrayList<SampleVO>(); 
				sampleList.add(new SampleVO(100, "초콜렛"));
				sampleList.add(new SampleVO(200, "햄버거"));
				sampleList.add(new SampleVO(300, "설렁탕"));
				jsonData = gson.toJson(sampleList);
				break;
			case "map" :
				Map<String, String> sampleMap = new HashMap<String, String>();
				sampleMap.put("name", "머스크");
				sampleMap.put("tel", "010-6666-8888");
				sampleMap.put("addr", "대전");
				sampleMap.put("대한", "민국");
				jsonData = gson.toJson(sampleMap);
				break;
		}
		
		// JSON 문자열 확인용
		System.out.println("jsonData = " + jsonData);
		
		PrintWriter out = response.getWriter();
		out.write(jsonData); // 위에서 jsonData에 뭘 담았고 그걸 out.write로 했어. 그럼 보내진다니
		// 왜냐면 그 위에 out이 response.getWriter.. 저게 뭔데..
		response.flushBuffer();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
