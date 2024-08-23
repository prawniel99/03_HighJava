package m8.d07TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class N01TcpServer01 {

    public static void main(String[] args) throws IOException {
        // TCP소켓 통신을 위해 Port번호를 지정하여 ServerSocket 객체를 생성한다.
        // ip와 port 번호들은 충돌하면 실행 안되니까 잘 정할 필요 있음. 7777 사용.
        ServerSocket server = new ServerSocket(7777);
        System.out.println("서버가 접속을 준비 중입니다");
        System.out.println();

        // accept() 메소드 ==> Client에서 연결 요청이 올 때까지 계속 기다린다.
        // └> 연결 요청이 오면 새로운 Socket 객체를 생성해서 Client의 Socket과 연결한다.
        Socket socket = server.accept();
        // 이 accept() 메소드 호출 명령 이후의 내용은 Client와 연결이 완료된 후의 처리내용을 작성하면 된다.
        
        System.out.println("클라이언트가 연결되었습니다");
        // 상대의 연결정보는 getInetAddress()
        // 거기서 상대의 ip는 getHostAddress()
        // 상대의 포트번호는 getPort()
        System.out.println("접속한 상대방의 정보");
        System.out.println("IP 주소: "+socket.getInetAddress().getHostAddress());
        System.out.println("Port 번호: "+socket.getPort());
        System.out.println();

        System.out.println("자신의 정보");
        System.out.println("IP 주소: "+socket.getLocalAddress());
        System.out.println("Port 번호: "+socket.getLocalPort());
        System.out.println();
        
        // server와 client가 한번씩 통신하기
        // 클라이언트가 보낸 메시지를 받아서 화면에 출력하고, 받은 메시지를 다시 클라이언트에게 보내기

        // 클라이언트가 보낸 메시지 받기
        //   ==> Socket 객체의 InputStream 객체를 이용한다.
        //   ==> Socket의 getInputStrea() 메소드를 이용하여 InputStream 객체를 구할 수 있다.
        InputStream in = socket.getInputStream();
        DataInputStream din = new DataInputStream(in);
        // 통신은 대부분 byte 기반으로 통신함. 위 InputStream은 byte 기반. 이미지나 영상 이런거 그냥 다 보내면 됨.
        // 근데 문자로 받아서 볼려면, 저건 바이트라서 문자열로 보여지지 않음.
        // DataInputStream을 사용해서 

        // 클라이언트가 보낸 메시지를 받아서 화면에 출력하기
        // DataInputStream과 readUTF는 한 짝이라고 생각하면 됨
        String str = din.readUTF();
        System.out.println("클라이언트가 보낸 메시지: "+str);
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println();

        // 클라이언트가 보낸 메시지를 그대로 클라이언트에게 다시 보낸다.
        //   ==> Socket 객체의 InputStream 객체를 이용한다.
        //   ==> Socket 객체의 getOutputStream() 메소드를 이용하여 OutputStream 객체를 구한다.
        OutputStream out = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);

        // 클라이언트로 메시지 보내기
        dout.writeUTF("["+str+"] 라는 메시지 잘 받았습니다");
        
        System.out.println("클라이언트로 메시지를 보냈습니다");
        System.out.println();
        System.out.println("연결을 종료합니다");

        // 사용했던 스트림과 소켓 닫기
        dout.close();
        din.close();
        socket.close();
        server.close();
        
        
        

    }
}
