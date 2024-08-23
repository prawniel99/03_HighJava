package m8.d08;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 이 쓰레드 클래스는 소켓을 통해서 메시지를 보내는 역할만 수행한다.
public class N01Sender extends Thread {
    private Socket socket; // 데이터를 가져올 소켓.
    private DataOutputStream dout; // 메시지 보내기.
    private String name; // 메시지 받을 사람.
    private Scanner scan; // 메시지 보내려면 입력 받아야 하니까.
    
    // 생성자
    public N01Sender(Socket socket) {
        this.socket = socket;
        scan = new Scanner(System.in);

        System.out.println("이름 입력 >> ");
        name = scan.nextLine();

        try {
            dout = new DataOutputStream(this.socket.getOutputStream()); // 바이트는 까다롭기 때문에, 스트링을 보내기 쉬운 Data OutputStream으로 한 것. OutputStreamWriter도 가능.
        } catch (IOException e) {

        }
    }

    @Override
    public void run() {
        while(dout!=null) {
            try {
                dout.writeUTF(name+" : "+scan.nextLine());
            } catch (IOException e) {

            }
        }
    }
}
