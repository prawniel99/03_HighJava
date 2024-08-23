package kr.or.ddit.basic.m0729;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new countDown();
		
		th1.start();
		th2.start();
	}
}

// 데이터를 입력 받는 쓰레드 작성
class DataInput extends Thread {
	// 입력 여부를 확인하기 위한 변수 선언
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		inputCheck = true;
		System.out.println("입력한 값 "+str);
	}
}

// 카운트다운 쓰레드 작성
class countDown extends Thread {
	@Override
	public void run() {
		for(int i=10; i>=1; i--) {
			// 입력 받는 쓰레드에서 입력이 완료 되었는지 여부를 검사한다.
			
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			
			if(DataInput.inputCheck==true) {
				return; // run() 메소드가 종료되면 해당 쓰레드도 종료된다.
			}
		}
		System.out.println("프로그램을 종료합니다");
		System.exit(0); // 프로그램 종료
	}
}