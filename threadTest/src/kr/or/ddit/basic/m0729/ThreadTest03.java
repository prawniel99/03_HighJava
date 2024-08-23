package kr.or.ddit.basic.m0729;

public class ThreadTest03 {
	// 쓰레드가 수행되는 시간을 체크해보자
	
	public static void main(String[] args) {
		/*
		 * 
		 */
//		MyRunner2 r = new MyRunner2(); // 2줄로 하는 방법
//		Thread th = new Thread(r);
		
		Thread th = new Thread(new MyRunner2()); // 1줄로 하는 방법
		long startTime = System.currentTimeMillis(); // 1970년 1월 1일 00시 00분 00초부터 지금까지 지난 시간(표준시간)
		System.out.println(startTime);
		th.start();
		try {
			th.join(); // ==> 현재 위치에서 대상이 되는 쓰레드(변수 th가 가리키는 쓰레드)가 종료될 때까지 기다린다.
		} catch (InterruptedException e) {
			
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		System.out.println("경과 시간: "+(endTime-startTime));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		long startTime2 = System.currentTimeMillis();
		System.out.println(startTime2);
		long sum = 0L;
		for(long i=1L; i<=1_000_000_000L; i++) sum += i;
		System.out.println("합계 "+sum);
		long endTime2 = System.currentTimeMillis();
		System.out.println(endTime2);
		System.out.println("경과 시간: "+(endTime-startTime));
	}
}

class MyRunner2 implements Runnable {
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i=1L; i<=1_000_000_000L; i++) {
			sum += i;
		}
		System.out.println("합계 "+sum);
	}
}