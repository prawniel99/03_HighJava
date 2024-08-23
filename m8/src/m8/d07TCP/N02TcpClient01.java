package m8.d07TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class N02TcpClient01 {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("서버에 접속합니다");
        // 자신의 컴퓨터를 나타내는 방법
        // 1) 원래의 IP주소: 예) 192.168.146.20
        // 2) 지정된 IP주소: 127.0.0.1
        // 3) 원래의 컴퓨터 이름: 예) destop-18
        // 4) 지정된 컴퓨터 이름: localhost

        // 접속할 서버의 IP주소와 Por번호를 지정하여 Socket객체를 생성한다.
        // Socket 객체는 생성이 완료되면 지정한 서버로 요청 신호를 보낸다.

        // Socket socket = new Socket("서버의 IP주소", "ServerSocket이 설정된 포트번호");
        Socket socket = new Socket("localhost", 7777);

        // Socket 객체가 생성된 이후에는 서버와 연결이 완료된 상태이므로
        // 서버와 연결된 상태에서 처리할 내용을 작성하면 된다.
        System.out.println("서버와 연결되었습니다.");
        System.out.println();

        System.out.print("서버로 보낼 메시지 입력 >> ");
        String str = scan.nextLine();

        // 서버로 메시지 보내기
        OutputStream out = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);
        dout.writeUTF(str);
        System.out.println("서버로 메시지를 보냈습니다");
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println();

        // 서버가 보내온 메시지를 받아서 화면에 출력하기
        InputStream in = socket.getInputStream();
        DataInputStream din = new DataInputStream(in);
        System.out.println("서버에서 보내온 메시지: "+din.readUTF());
        System.out.println();
        System.out.println("연결을 종료합니다");

        // 스트림과 소캣 닫기
        din.close();
        dout.close();
        scan.close();
        socket.close();
    }
}
