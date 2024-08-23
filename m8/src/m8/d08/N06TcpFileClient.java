package m8.d08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFileChooser;
import java.awt.Panel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class N06TcpFileClient {
    public static void main(String[] args) {

        N06TcpFileClient tt = new N06TcpFileClient();
        File file = tt.selectFile("OPEN");
        if(file==null) {
            return;
        }
        
        // 전송할 파일 정보를 갖는 File 객체를 생성
        // String fileToSend = "펭귄.jpg";
        // String fileToSend = "";
        // File file = new File("d:/d_other/cat-jump.png");
        // File file = new File("d:/d_other/"+fileToSend);
        if(!file.exists()) {
            System.out.println(file.getAbsolutePath()+"file doesn't exist");
            System.out.println("program will close");
            System.exit(0);
        }

        try {
            // 연결 소켓 생성하기
            Socket socket = new Socket("localhost", 7777);
            System.out.println("initiate file transfer");
            // 파일 이름 전송하기
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream()); // 펭귄.jpg라는 파일 이름을 보내줘야 하기 떄문.
            // 파일 이름 전송하기
            dout.writeUTF(file.getName());
            // 파일을 읽어서 소켓으로 출력하기
            // 파일을 읽어올 스트림 객체 생성하기. Fileinputstream과 하나로 뭉침
            BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
            // 서버로 전송할 출력용 스트림 객체 생성 (소켓 이용)
            BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());
            byte[] temp = new byte[1024];
            int length = 0;
            // 파일 내용을 읽어서 소켓으로 출력하기
            while((length = bin.read(temp))>0) {
                bout.write(temp, 0, length);
            }
            bout.flush(); // buffer은 출력작업을 마치면 flush를 해주는게 좋다. 일정 크기가 되어야 하기 때문에, 일정 크기가 못되고 쌓인게 있을 수 있음.
            System.out.println("fil transfer successful");
            bout.close();
            bin.close();
            dout.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("file transfer failed");
            e.printStackTrace();
        }
    }
    public File selectFile(String option) {
		// SWING에서 제공하는 파일 열기, 저장 창 연습
        JFileChooser chooser = new JFileChooser();

        // 선택할 파일의 확장자 설정
        FileNameExtensionFilter txt = new FileNameExtensionFilter("text파일(*.txt)", "txt"); // 매개변수 첫번째는 표시할 텍스트, 두번째는 확장자
        FileNameExtensionFilter doc = new FileNameExtensionFilter("MS Word File", "doc", "docx"); // 매개변수 두번째는 확장자(확장자 여러개 콤마 분리로 나열 가능)
        FileNameExtensionFilter img = new FileNameExtensionFilter("Image File", new String[] {"png", "jpg", "gif"}); // 배열로 만들 수도 있음

        // 확장자 목록을 FileChooser에 등록한다.
        chooser.addChoosableFileFilter(txt);
        chooser.addChoosableFileFilter(doc);
        chooser.addChoosableFileFilter(img);
        
		// Dialog창 열기
		int result;
		if("SAVE".equals(option.toUpperCase())) {
			result = chooser.showSaveDialog(new Panel()); // 저장 창
		} else if("OPEN".equals(option.toUpperCase())) {
			result = chooser.showOpenDialog(new Panel()); // 열기 창
		} else {
			System.out.println("메소드를 호출할 때 매개변수에 'SVAE' 또는 'OPEN'을 지정하세요");
			return null;
		}
        // int result = chooser.showSaveDialog(new Panel()); // 저장 창

		File selectedFile = null;
        // 창에서 '열기' 또는 '저장' 버튼을 눌렀는지 확인
        if(result==JFileChooser.APPROVE_OPTION) {
			selectedFile = chooser.getSelectedFile();
        }
		return selectedFile;
	}
}