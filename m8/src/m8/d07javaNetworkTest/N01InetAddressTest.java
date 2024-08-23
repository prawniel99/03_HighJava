package m8.d07javaNetworkTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class N01InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        // InetAddress 클래스 ==> IP 주소를 다루기 위한 클래스
        
        // www.naver.com
        InetAddress ip = InetAddress.getByName("www.naver.com");
        InetAddress ip2 = InetAddress.getByName("www.danawa.com");
        InetAddress nate = InetAddress.getByName("www.nate.com");
        InetAddress ip3 = InetAddress.getByName("www.google.com");
        // 네트워크는 try catch를 하거나 throw를 해야함.
        // throw는 메소드명 뒤에 throws UnknownHostException 넣기.
        // try catch 는 catch에 UnknownHostException 넣기.

        System.out.println("HostName: "+ip.getHostName());
        System.out.println("HostAddress: "+ip.getHostAddress());
        // toString returns hostName and hostAddress
        System.out.println("toString: "+ip.toString());
        System.out.println();
        System.out.println("HostName: "+ip2.getHostName());
        System.out.println("HostAddress: "+ip2.getHostAddress());
        System.out.println("toString: "+ip2.toString());
        System.out.println();
        System.out.println("HostName: "+nate.getHostName());
        System.out.println("HostAddress: "+nate.getHostAddress());
        System.out.println("toString: "+nate.toString());
        System.out.println();
        System.out.println("HostName: "+ip3.getHostName());
        System.out.println("HostAddress: "+ip3.getHostAddress());
        System.out.println("toString: "+ip3.toString());
        System.out.println();
        System.out.println("구글은 ip접속 안막아뒀는데 별 문제 없는거 아녀?");
        System.out.println();

        // 자신의 컴퓨터의 IP정보 가져오기
        InetAddress localIp = InetAddress.getLocalHost();
        System.out.println("내 컴퓨터의 HostName: "+localIp.getHostName());
        System.out.println("내 컴퓨터의 HostAddress: "+localIp.getAddress());
        System.out.println("toString: "+localIp);
        System.out.println();

        // IP주소가 여러개인 호스트의 IP정보 가져오기
        InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
        InetAddress[] ipArr2 = InetAddress.getAllByName("www.google.com");
        for(InetAddress ips : ipArr) {
            System.out.println("naver: "+ips.toString());
        }
        for(InetAddress ips : ipArr2) {
            System.out.println("google: "+ips.toString());
        }
        
    }
}
