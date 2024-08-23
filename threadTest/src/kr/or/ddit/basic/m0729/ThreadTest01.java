package kr.or.ddit.basic.m0729;

public class ThreadTest01 {
	
	public static void main(String[] args) {
		// * 200개, $ 200개 출력하기
		for(int i=0; i<200; i++) {
			System.out.print("*");
			if(i%10==0) System.out.println();
		}
		for(int i=0; i<200; i++) {
			System.out.print("$");
			if(i%10==0) System.out.println();
		}
	}
}
