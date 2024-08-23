package kr.or.ddit.basic.m0729;

// 쓰레드의 상태값을 출력하는 프로그램

public class ThreadTest09 {
	
	public static void main(String[] args) {
		PrintThreadState th = new PrintThreadState(new TargetThread());
		th.start();
	}
}

class TargetThread extends Thread {
	@Override
	public void run() {
		for(long i=1L; i<=20_000_000_000L; i++) {
//			long a = i+1;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

		}

		for(long i=1L; i<=20_000_000_000L; i++) {
//			long a = i+1;
		}

	}
}

class PrintThreadState extends Thread {
	private TargetThread target;
	
	// 생성자
	public PrintThreadState(TargetThread target) {
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true) {
			Thread.State state = target.getState();
			System.out.println("TargetThread의 상태값: "+state);
			
			if(state==Thread.State.NEW) { // 현재의 쓰레드 상태가 NEW 상태이면
				target.start();
			}
			
			if(state==Thread.State.TERMINATED) { // 현재의 쓰레드 상태가 종료 상태이면
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
}