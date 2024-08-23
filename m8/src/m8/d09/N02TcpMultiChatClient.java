package m8.d09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class N02TcpMultiChatClient {

    public static void main(String[] args) {
        new N02TcpMultiChatClient().clientStart();
    }

    // 시작 메소드
    public void clientStart() {
        Socket socket = null;
        try {
            socket = new Socket("192.168.146.63", 7777);
            System.out.println("서버에 연결됐습니다");
            System.out.println();

            // ---------------------------------------------

            // 전송용 쓰레드 객체와 수신용 쓰레드 객체를 생성하여 실행한다.
            ClientReceiver receiver = new ClientReceiver(socket);
            ClientSender sender = new ClientSender(socket);

            receiver.start();
            sender.start();

        } catch (Exception e) {
        }
    } // 시작 메소드 끝

    // --------------------------------------------
    // 전송용 쓰레드 클래스 작성
    class ClientSender extends Thread {
        private Socket socket;
        private DataInputStream din;
        private DataOutputStream dout;
        private String name;
        private Scanner scan;

        // 생성자
        public ClientSender(Socket socket) {
            this.socket = socket;
            scan = new Scanner(System.in);
            try {
                // 수신용
                din = new DataInputStream(this.socket.getInputStream());

                // 송신용
                dout = new DataOutputStream(this.socket.getOutputStream());

                if(din!=null) {
                    while(true) {
                        // 클라이언트가 '대화명'을 입력 받아 서버로 전송하고,
                        // 서버의 응답 결과(대화명 중복여부)를 받아서 처리하기
                        System.out.println("대화명 입력 >> ");
                        String name = scan.nextLine();

                        dout.writeUTF(name); // '대화명' 전송
                        
                        // 서버의 응답 결과를 받는다.
                        String feedBack = din.readUTF();

                        if("대화명중복".equals(feedBack)) {
                            // 대화명이 중복될 때
                            System.out.println(name+"은 중복되는 대화명입니다");
                            System.out.println("다른 대화명을 입력하세요");
                        } else { 
                            // 대화명이 중복되지 않을때
                            this.name = name;
                            System.out.println("["+name+"] 대화명으로 입장했습니다");
                            break;
                        }
                    } // while문 종료
                }
            } catch (Exception e) {
            }
        } // 생성자 종료

        @Override
        public void run() {
            try {
                while(dout!=null) {
                    // 키보드로 입력한 메시지를 입력
                    dout.writeUTF("["+name+"]"+scan.nextLine());
                }
            } catch (Exception e) {
            }
        }
    } // 전송용 쓰레드 클래스 끝

    // ----------------------------------------------
    // 수신용 쓰레드 클래스
    class ClientReceiver extends Thread {
        private Socket socket;
        private DataInputStream din;

        // 생성자
        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                // 스트림 객체 생성
                din = new DataInputStream(this.socket.getInputStream());
            } catch (Exception e) {
            }
        } // 생성자 종료

        @Override
        public void run() {
            try {
                while(din!=null) {
                    System.out.println(din.readUTF());
                }
            } catch (Exception e) {
            }
        }
    }
}
