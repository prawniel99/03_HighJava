package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 문제) 'd:/d_other' 폴더에 있는 '펭귄.jpg' 파일을
 *       'd:/d_other/연습용' 폴더에 '복사본_펭귄.jpg' 파일로
 *       복사하는 프로그램을 작성하시오.
 */

public class _11FileCopyTest {
	
	public static void main(String[] args) {
				// 원본 파일의 정보를 갖는 File 객체 생성
		File file = new File("d:/d_other/펭귄.jpg");
		// 복사를 하는데 원본이 없으면 안되고, 원본이 있는지 확인하기 위해서 file 객체를 생성함.

		// 원본 파일이 없는지 검사
		if(!file.exists()) {
			System.out.println(file.getAbsolutePath()+"파일이 없습니다");
			System.out.println("복사 작업을 중지합니다");
			return;
		}
		FileInputStream fin = null;
		FileOutputStream fout = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		try {
			// 원본 파일을 읽어올 스트림 객체 생성
			fin = new FileInputStream(file);
			bin = new BufferedInputStream(fin);
			// 대상 파일에 저장할 스트림 객체 생성
			fout = new FileOutputStream("d:/d_other/연습용/펭귄버퍼.jpg");
			bout = new BufferedOutputStream(fout);

			System.out.println("복사 시작");

			int data; // 읽어온 데이터를 저장할 변수

			// while ((data=fin.read())!=-1) {
			// 	fout.write(data);
			// }

			while ((data=bin.read())!=-1) {
				bout.write(data);
			}
			bout.flush();

			System.out.println("복사 작업 끝");
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 이거 안닫아주면 무슨 문제가 생기는거였지? 앞에 많이 설명해주셨을텐데..
			// if(fin!=null) try { fin.close(); } catch(IOException e) { }
			// if(fout!=null) try { fout.close(); } catch(IOException e) { }
			if(bin!=null) try { bin.close(); } catch(IOException e) { }
			if(bout!=null) try { bout.close(); } catch(IOException e) { }
		}
	}
}
