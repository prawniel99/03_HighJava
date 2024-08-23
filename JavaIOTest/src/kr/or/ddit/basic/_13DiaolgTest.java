package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class _13DiaolgTest {
    
    public static void main(String[] args) {
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
        
        int result = chooser.showOpenDialog(new Panel()); // 열기 창
        // int result = chooser.showSaveDialog(new Panel()); // 저장 창

        // 창에서 '열기' 또는 '저장' 버튼을 눌렀는지 확인
        if(result==JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("선택한 파일: "+selectedFile.getAbsolutePath());
        }
    }
}
