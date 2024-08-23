package kr.or.ddit.basic.m0729;

import java.util.ArrayList;
import java.util.Collections;

/*
	1 ~ 20억 까지의 합계를 구하는 프로그램을 하나의 쓰레드가 단독으로 처리할 때와
	여러개의 쓰레드가 협력해서 처리할 때의 경과시간을 비교해 보자

*/

public class ThreadTest04 {
	ArrayList<Long> list = new ArrayList<Long>();
	
	public static void main(String[] args) {
		new ThreadTest04().b();
	}
	public void b() {
		// 단독 처리 쓰레드 생성
		SumThread sm = new SumThread(1L, 2_000_000_000L);
//		long sum = 0L;
//		long st1 = System.currentTimeMillis();
//		for(long i=1L; i<=2000000000; i++) {
//			sum += i;
//		}
//		long et1 = System.currentTimeMillis();
//		System.out.println(sum);
//		System.out.println("경과시간 "+(et1-st1));
		
		System.out.println("---------------------------------------------------");		
		System.out.println("---------------------------------------------------");		
		System.out.println("---------------------------------------------------");		


		
		// 단독으로 처리하기
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			
		}
		long endTime = System.currentTimeMillis();
		long alone = endTime-startTime;
		System.out.println("단독으로 처리했을 때 경과 시간: "+(endTime-startTime));
		System.out.println("---------------------------------------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("---------------------------------------------------");
		
		// 여러개 협력해서 처리하는 쓰레스 객체 생성
		SumThread[] sumArr = new SumThread[] {
				new SumThread(1L, 500_000_000L),
				new SumThread(500_000_000L, 1_000_000_000L),
				new SumThread(1_000_000_000L, 1_500_000_000L),
				new SumThread(1_500_000_000L, 2_000_000_000L)
		};
		
		// 여러개 쓰레드 협력 처리하기
		startTime = System.currentTimeMillis();
		for(int i=0; i<sumArr.length; i++) {
			sumArr[i].start();
		}
		
		for(SumThread smt : sumArr) {
			try {
				smt.join();
			} catch (InterruptedException e) {
				
			}
		}
		endTime = System.currentTimeMillis();
		long together = endTime-startTime;
		System.out.println("협력으로 처리했을 때 경과 시간: "+(endTime-startTime));
		System.out.println("---------------------------------------------------");
		long difference = alone-together;
		System.out.println("시간차이: "+(difference));
		list.add(difference);
		Collections.sort(list);
		System.out.println("최소 "+list.get(0));
		System.out.println("최대 "+list.get(list.size()-1));
		
//		c();
//	}
//	
//	public void c() {
//		b();
	}
}

class SumThread extends Thread {
	// 합계를 구할 영역의 시작값과 종료값이 저장될 변수 선언
	private long start;
	private long end;
	
	// 초기화
	public SumThread(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	// 생성자로 들어온 값 범위 합계
	@Override
	public void run() {
		long sum = 0L;
		for(long i=start; i<=end; i++) {
			sum += i;
		}
		System.out.println(start+"부터 "+end+" 까지의 합계: "+sum);
	}
}