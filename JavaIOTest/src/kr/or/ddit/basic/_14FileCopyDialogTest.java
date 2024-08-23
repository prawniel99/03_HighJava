package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * 문제) 'd:/d_other' 폴더에 있는 '펭귄.jpg' 파일을
 *       'd:/d_other/연습용' 폴더에 '복사본_펭귄.jpg' 파일로
 *       복사하는 프로그램을 작성하시오.
 */

public class _14FileCopyDialogTest {
	
	public static void main(String[] args) {
		_14FileCopyDialogTest test = new _14FileCopyDialogTest();

		// 원본 파일의 정보를 갖는 File 객체 생성
		// File file = new File("d:/d_other/펭귄.jpg");
		File file = test.selectFile("OPEN");
		// 복사를 하는데 원본이 없으면 안되고, 원본이 있는지 확인하기 위해서 file 객체를 생성함.

		if(file==null) {
			System.out.println("복사할 원본 파일을 선택하세요");
			return;
		}

		// 원본 파일이 없는지 검사
		if(!file.exists()) {
			System.out.println(file.getAbsolutePath()+"파일이 없습니다");
			System.out.println("복사 작업을 중지합니다");
			return;
		}

		File saveFile = test.selectFile("SAVE");
		if(saveFile==null) {
			System.out.println("대상 파일을 선택하세요");
			return;
		}

		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			// 원본 파일을 읽어올 스트림 객체 생성
			fin = new FileInputStream(file); // 원본파일
			// 대상 파일에 저장할 스트림 객체 생성
			// fout = new FileOutputStream("d:/d_other/연습용/파일이름지정 디렉토리는 생성되어있어야 함.jpg");
			fout = new FileOutputStream(saveFile); //대상 파일
			System.out.println("복사 시작");
			int data; // 읽어온 데이터를 저장할 변수
			while ((data=fin.read())!=-1) {
				fout.write(data);
			}
			System.out.println("복사 작업 끝");
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 이거 안닫아주면 무슨 문제가 생기는거였지? 앞에 많이 설명해주셨을텐데..
			if(fin!=null) try { fin.close(); } catch(IOException e) { }
			if(fout!=null) try { fout.close(); } catch(IOException e) { }
		}
	}

	// 열기용, 또는 저장용 창을 나타내는 메소드
	// 매개변수가 'OPEN'이면 열기용, 'SAVE'면 저장용
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
