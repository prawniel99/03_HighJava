package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
public class _12FilegugudanTest_Teacher {
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		_12FilegugudanTest_Teacher test = new _12FilegugudanTest_Teacher();
		// test.displayGugudan01();
		test.displayGugudan02();
	}

	// 문자기반 스트림을 이용하는 방법
	public void displayGugudan01() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("d:/d_other/gugudan01.txt");
			System.out.println("출력할 단 입력");
			int dan = scan.nextInt();
			String result = dan + "단\n\n";
			for(int i=1; i<=9; i++) {
				result += dan+"*"+i+"="+(dan*i)+"\n";
			}
			// System.out.println(result);
			fw.write(result); // 이렇게 해서 파일로 내보낸다
			System.out.println("출력 작업 끝"); // try 작업이 제대로 끝났는지 확인하기 위함
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw!=null) try { fw.close(); } catch(IOException e) { }
		}
	}

	// 바이트기반 스트림을 이용하는 방법
	public void displayGugudan02() {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("d:/d_other/gugudan01.txt");
			System.out.println("출력할 단 입력 >> ");
			int dan = scan.nextInt();
			String result = dan + "단\n\n";
			for(int i=1; i<=9; i++) {
				result += dan+"*"+i+"="+(dan*i)+"\n";
			}
			// System.out.println(result);
			fout.write(result.getBytes("utf-8")); // 이렇게 해서 파일로 내보낸다
			System.out.println("출력 작업 끝"); // try 작업이 제대로 끝났는지 확인하기 위함
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fout!=null) try { fout.close(); } catch(IOException e) { }
		}
	}
}