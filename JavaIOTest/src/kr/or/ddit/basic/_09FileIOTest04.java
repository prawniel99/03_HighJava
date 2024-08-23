package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class _09FileIOTest04 {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 저장하기
		try {
			// System.in ==> 콘솔(표준입출력장치) 입력 장치
			/*
			System.out.print("자료 입력 >> ");
			int c = System.in.read();
			System.out.println((char)c);
			 */
			
			// 바이트 기반의 입력용 스트림을 문자 기반의 입력용 스트림으로 변환하기
			InputStreamReader isr = new InputStreamReader(System.in);
			
			// 출력용 스트림 객체 생성
			FileWriter fw = new FileWriter("d:/d_other/charTest.txt");
			
			System.out.println("아무 내용이나 입력하세요");
			System.out.println("Ctrl - Z 를 누르면 입력을 종료합니다");
			
			int c;
			
			while((c=isr.read())!=-1) {
				fw.write(c); // 콘솔로 입력받은 데이터를 파일로 출력한다.
			}
			
			// 스트림 닫기
			isr.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
