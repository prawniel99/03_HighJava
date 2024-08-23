package m8.d08;

import java.net.Socket;

public class N04TcpClient02 {
    public static void main(String[] args) {
        try {
            // 소켓 객체를 생성하여 서버에 접속 요청을 보내고, 접속이 완료되면
            // 생성된 소켓을 수신용 쓰레드와 송신용 쓰레드를 생성할 때 주입하여 실행한다.
            // Socket socket = new Socket("localhost", 7777); // 로컬
            Socket socket = new Socket("192.168.146.76", 7777); // 하민
            // Socket socket = new Socket("192.168.146.65", 7777); // 민섭
            // Socket socket = new Socket("192.168.146.62", 7777); // 민재
            // Socket socket = new Socket("192.168.146.5", 7777); // 서혜
            System.out.println("서버에 연결되었습니다");

            N01Sender sender = new N01Sender(socket);
            N02Receiver receiver = new N02Receiver(socket);

            sender.start();
            receiver.start();

        } catch (Exception e) {

        }
    }
}
