package m8.d08;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class N02Receiver extends Thread {
    private Socket socket; // socket to store
    private DataInputStream din;
    
    public N02Receiver(Socket socket) {
        this.socket = socket;
        try {
            din = new DataInputStream(this.socket.getInputStream());
        } catch (IOException e) {

        }
    }

    @Override
    public void run() {
        while(din!=null){
            try {
                System.out.println(din.readUTF());
            } catch (Exception e) {

            }
        }
    }
    
    
}
