package kr.or.ddit.basic.m0729;

import java.util.Scanner;

public class ThreadTest02 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// 멀티 쓰레드 프로그램
		
		// Thread 사용방법

		// 방법1)
		// Thread 클래스를 상속한 class를 작성하고, 이 class의 인스턴스를 생성한다.
		// 생성된 Thread 클래스의 인스턴스의 start() 메소드를 호출해서 실행한다.
		MyThread1 th1 = new MyThread1();
		th1.start(); // start 대신 run 을 해도 오류 안난다. run은 싱글스레드가 됨.
		
		// 방법2)
		// Runnable 인터페이스를 구현한 class를 작성하고, 이 class의 인스턴스를 생성한다.
		// 이 인스턴스를 Thread 클래스의 인스턴스를 생성할 때 생성자의 인수값으로 넣어준다.
		// Thread 클래스의 인스턴스의 start() 메소드를 호출해서 실행한다.
		sc.nextInt(); // 쓰레드 끊기는지 테스트
		MyRunner1 r1 = new MyRunner1();
		Thread th2 = new Thread(r1);
		th2.start(); // 얘도 run 해도 됨.
		
		// 방법 2-2) Runnable의 익명 구현체를 이용하는 방법. 클래스 명이 따로 없어서 익명구현체..
		sc.nextInt(); // 쓰레드 끊기는지 테스트
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<=200; i++) {
					System.out.print("@");
					if((i*2)%(i+2)==0) {
						System.out.println();
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
					}
				}
			}
		};
		Thread th3 = new Thread(r2);
		th3.start();
		
		System.out.println("메인 메소드 끝"); // 메인 메소드가 끝나도 쓰레드는 진행되는지 확인
	}
}

// 방법1) ==> Thread class 를 상속한 class 만들기 (*문자 200개 출력하기)
class MyThread1 extends Thread {

	@Override
	public void run() {
		// 이 run() 메소드에서는 이 쓰레드가 처리할 내용을 기술하면 된다.
		for(int i=0; i<200; i++) {
			System.out.print(i);
			try {
				// Thread.sleep(시간) ==> 주어진 시간 만큼 작업을 일시정지한다.
				// 시간은 밀리세컨드 단위.
				Thread.sleep(100); 
			} catch (InterruptedException e) {
				
			}
		}
	}
}

// 방법2) ==> Runnable 인터페이스를 구현한 class 만들기($ 문자 200개 출력하기)
class MyRunner1 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<200; i++) {
			System.out.print("a");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}