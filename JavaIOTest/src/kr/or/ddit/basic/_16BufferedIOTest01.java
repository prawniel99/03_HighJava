package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _16BufferedIOTest01 {
	
	public static void main(String[] args) {
		// 입출력의 성능 향상을 위해서 Buffered 스트림을 사용한다.
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			
			// 버퍼의 크기
			// 버퍼의 크기가 5인 버퍼 스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(char c='1'; c<='9'; c++) {
				bout.write(c);
			}
			bout.flush(); // 이거 왜 하는거라고?
			bout.close(); // close() 메소드에서는 flush()를 자동으로 호출한다.
			System.out.println("작업 끝");
			System.out.println("읭");
		} catch (IOException e) {
		}
	}
}
