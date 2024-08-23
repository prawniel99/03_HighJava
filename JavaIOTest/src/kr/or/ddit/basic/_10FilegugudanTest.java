package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제) Scanner를 이용하여 출력할 단을 입력 받고
 *   입력한 단을 파일에 출력하는 프로그램을 작성하시오
 *   ( 출력할 파일명 : gugudan.txt )
 * 
 * 실행 예시 ) 
 *   출력할 단 입력 >> 3
 * 
 *   -gugudan.txt파일의 내용
 *    3단
 *    3*1 = 1
 *    3*2 = 6
 *    ..
 *    3*9 = 27  
 */
public class _10FilegugudanTest {
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			
			FileWriter fw = new FileWriter("d:/d_other/gugudan.txt");
			
			System.out.println("출력할 단 입력 >> ");
			
			int c;
			while ((c=isr.read())!=-1) {
				int i = 1;
				fw.write(c+" * "+i);
				i++;
			}
			
//            FileOutputStream fout = new FileOutputStream("d:/d_other/gugudan.txt");
//            for(int i=1; i<=9; i++) {
//            	fw.write(isr+" * "+i);
//            }
            System.out.println("출력 작업 완료");
//            fout.close(); // 스트림 닫기
			
			
			isr.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}