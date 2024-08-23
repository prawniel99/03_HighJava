package m8.d08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class N05TcpFileServer {
    
    public static void main(String[] args) {

        // 클라이언트로부터 파일을 받아서 특정 폴더에 저장하는 프로그램
        

        // 저장할 폴더 정보를 갖는 File 객체 생성한다.
        File file = new File("d:/d_other/upload");

        // 저장할 폴더가 없으면 새로 만든다.
        if(!file.exists()) {
            file.mkdirs();
        }

        try {
            ServerSocket server = new ServerSocket(7777);
            System.out.println("서버가 준비중입니다");
            Socket socket = server.accept();

            System.out.println("file tranfer initiated");

            // 클라이언트가 보낸 파일명을 받아올 스트림 객체 생성하기.
            DataInputStream din = new DataInputStream(socket.getInputStream());
            String filename = din.readUTF(); // 파일 이름 받기.. 이거 뭔데 utf

            // 저장할 파일 위치와 파일명을 지정해서 새로운 File 객체 생성하기.
            File saveFile = new File(file, filename);

            // 소켓에서 읽어서 파일로 출력하기
            BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());

            // 파일로 저장할 출력용 스트림 객체 생성하기
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(saveFile));

            // 소켓으로 읽어서 파일로 저장하기
            byte[] temp = new byte[1024];
            int length = 0;

            while((length = bin.read(temp))>0) {
                bout.write(temp, 0, length);
            }
            bout.flush();

            System.out.println("file transfer successful");
            
            din.close();
            bin.close();
            bout.close();
            server.close();
            System.out.println("?");
            socket.close();
        } catch (IOException e) {
            System.out.println("file transer failed");
            e.printStackTrace();
        }
    }
}
