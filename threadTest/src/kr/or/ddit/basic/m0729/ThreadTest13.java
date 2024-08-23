package kr.or.ddit.basic.m0729;

public class ThreadTest13 {
	public static void main(String[] args) {
   //  ThreadStopTest01 th1 = new ThreadStopTest01();
   //  th1.start();
   //  
   //  try {Thread.sleep(1000);}
   //  catch(InterruptedException e){}
   //  
   //  //th1.stop();
   //  th1.setStop(true);
	 
	 //interrupt()메서드를 이용하여 쓰레드 멈추기
	 ThreadStopTest02 th2 = new ThreadStopTest02();
	 th2.start();
	 try {Thread.sleep(1000);}
	 catch(InterruptedException e){}
	 
	 th2.interrupt();
	}
   }

//쓰레드 멈추기 연습용 클래스
class ThreadStopTest01 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
	 this.stop = stop;
	}
	
	@Override
	public void run() {
	 while (!stop) {
	  System.out.println("쓰레드 실행 중...");
	 }
	 
	 System.out.println("자원정리...");
	 System.out.println("쓰레드 종료...");
	}
   }

//interrupt()메서드를 이용하여 쓰레드를 멈추게 하는 클래스
class ThreadStopTest02 extends Thread {
	@Override
	public void run() {
		//방법1
		/*
		try {
			while(true) {
				System.out.println("Thread 실행중");
				Thread.sleep(1); // 일시정지 상태에서 interrupt() 메소드가 실행되면 InterruptedException이 발생한다.
			}
		} catch (InterruptedException e) {

		}
		*/

		// 방법2 ==> interrupt() 메소드가 호출되었는지 직접 검사하기
		while(true) {
			System.out.println("쓰레드 실행중");

			// interrupt() 메소드가 호출되었는지 검사한다.

			/*
			// 검사방법1 ==> Thread의 인스턴스 메소드인 isInterrupted() 메소드 이용하기
			// isInterrupted() 메소드 ==> interrupt() 메소드가 호출되면 true를 반환한다.
			if(this.isInterrupted()) {
			break;
			}
			*/
			
			// 검사방법2 ==> Thread의 정적 메소드인 interrupted() 메소드 이용하기
			// isInterrupted() 메소드 ==> interrupt() 메소드가 호출되면 true를 반환한다.
			if(Thread.interrupted()) {
				break;
			}
				
		}

		System.out.println("자원 정리");
		System.out.println("쓰레드 종료");
	}
}
