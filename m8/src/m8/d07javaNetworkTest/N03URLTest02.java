package m8.d07javaNetworkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class N03URLTest02 {

    public static void main(String[] args) throws IOException {
        // URLConnection 클래스 ==> 애플리케이션과 URL간의 통신 연결을 위한 클래스

        // 특정 서버의 정보와 파일 내용 가져오기.
        URL url = new URL("https://www.naver.com/index.html");
        // MalformedURLException 자동 던지기는 이거 나왔는데,
        // 교수님은 IOException 을 throw 하심

        // URL객체를 이용하여 URLConnection 객체를 구한다.
        URLConnection urlCon = url.openConnection();

        Map<String, List<String>> headerMap = urlCon.getHeaderFields();
        
        // Header의 key값(또는 Header의 name값) 가져오기
        System.out.println("-----------------------------------------------------");
        for(String headerKey : headerMap.keySet()) {

            // key 값을 이용해서 HeaderValue 값 가져오기
            System.out.println(headerKey+" : "+headerMap.get(headerKey));
        }
        System.out.println("-----------------------------------------------------");

        // 해당 문서의 내용 가져오기 (index.html문서의 내용 가져오기)

        /*
        // 방법1) ==> URLConnection객체를 이용하는 방법
        // 파일 내용을 읽어오기 위한 스트림 객체 생성
        InputStream in = urlCon.getInputStream();
        // 위는 byte기반 stream 이라서, String 기반 stream 으로 변경 필요
        // Reader 로 해서 in 을 집어넣는다
        // 그리고 인코더도 지정해준다
        InputStreamReader isr = new InputStreamReader(in, "utf-8");
        // 빠르게 해오기 위해, 위에서 string 으로 변경한 isr 을 bufferreader로 집어넣어 만든다
        BufferedReader br = new BufferedReader(isr);

        // 파일 내용을 읽어와 화면에 출력하기
        while(true) {
            String str = br.readLine();
            if(str==null) {
                break;
            }
            System.out.println(str);
        }
        br.close();
        */


        // 방법2) ==> URL 객체의 openStream() 메소드 이용하기
        InputStream in2 = url.openStream();
        BufferedReader br2 = new BufferedReader(
            new InputStreamReader(in2, "utf-8"));
        String str2 = null;
        while((str2=br2.readLine())!=null) {
            System.out.println(str2);
        }
        br2.close();


    }
}
