package m8.d07javaNetworkTest;

import java.net.MalformedURLException;
import java.net.URL;

public class N02URLTest01 {

    public static void main(String[] args) throws MalformedURLException {
        // URL 클래스 ==> 인터넷에 존재하는 서버의 자원에 접근할 수 있는 주소를 다루는 클래스

        // http://ddit.or.kr:80/index.html?ttt=123
        // 프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조값

        URL url = new URL("http://ddit.or.kr:80/index.html?ttt=123");
        URL url2 = new URL("http", "ddit.or.kr", 80, "/index.html?ttt=123");
        System.out.println();

        System.out.println("Protocol: "+url.getProtocol());
        System.out.println("Host: "+url.getHost());
        System.out.println("Port: "+url.getPort());
        System.out.println("File: "+url.getFile());
        System.out.println("Path: "+url.getPath());
        System.out.println("Query: "+url.getQuery());
        System.out.println(url.toExternalForm());
        System.out.println();
        
        System.out.println("Protocol: "+url2.getProtocol());
        System.out.println("Host: "+url2.getHost());
        System.out.println("Port: "+url2.getPort());
        System.out.println("File: "+url2.getFile());
        System.out.println("Path: "+url2.getPath());
        System.out.println("Query: "+url2.getQuery());
        System.out.println(url2.toExternalForm());
        System.out.println();
        
    }
}
