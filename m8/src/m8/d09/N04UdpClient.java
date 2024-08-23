package m8.d09;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class N04UdpClient {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            // 소켓 객체 생성
            DatagramSocket socket = new DatagramSocket();
            
            // 상대방의 주소 정보 생성하기
            InetAddress address = InetAddress.getByName("localhost");

            while(true) {
                System.out.println("전송할 메시지 입력 >> ");
                String msg = scan.nextLine();

                // 전송용 패킷 객체 생성
                DatagramPacket outPacket = new DatagramPacket(msg.getBytes("utf-8"), msg.getBytes("utf-8").length, address, 9999);

                // 전송하기
                socket.send(outPacket);

                if("/end".equals(msg)) { // 종료메시지가 입력되면
                    break; // 탈출!
                }

                System.out.println();

                // 상대방이 보낸 메시지 받아서 출력하기
                byte[] inMsg = new byte[1024];

                // 수신용 패킷 객체 생성
                DatagramPacket inPacket = new DatagramPacket(inMsg, inMsg.length);

                // 데이터 수신
                socket.receive(inPacket);

                // 수신된 데이터를 무낮열로 변환하여 출력하기
                String receiveMsg = new String(inMsg, 0, inPacket.getLength(), "utf-8");
                // 가져온 inMsg 데이터를 0번째부터 inPacket 길이 까지 utf-8 인코딩 형식으로 문자열로 만들어라

                System.out.println("서버의 응답 메시지 >>> "+receiveMsg);
                System.out.println();

            } // while문 종료
            System.out.println("통신 끝");
            socket.close();
            
        } catch (Exception e) {
        }
        scan.close();
    }
}
