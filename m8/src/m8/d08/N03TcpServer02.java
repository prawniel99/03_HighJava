package m8.d08;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class N03TcpServer02 {
    public static void main(String[] args) {
        try {
            // 서버 소켓을 만들고 클라이언트가 접속해오면 클라이언트와 연결된 소켓을 만든다.
            // 이 만들어진 소켓을 메시지를 보내는 쓰레드와 메시지를 받는 쓰레드에 주입시키고
            // 이 쓰레드들을 실행한다.
            ServerSocket server = new ServerSocket(7777);
            System.out.println("서버가 준비중입니다");
            Socket socket = server.accept(); // 연결되면 소켓이 만들어짐
            N01Sender sender = new N01Sender(socket);
            N02Receiver receiver = new N02Receiver(socket);
            sender.start();
            receiver.start();
            
            server.close();
        } catch (IOException e) {

        }
    }
}
