package kr.or.ddit.basic.m0729;

// 데몬 쓰레드 연습 ==> 예) 자동 저장하는 쓰레드
public class ThreadTest08 {
	public static void main(String[] args) {
        AutoSave auto = new AutoSave();
        auto.setDaemon(true); // 반드시 start() 메소드 호출 전에 설정한다.
        System.out.println("데몬 쓰레드 여부 "+auto.isDaemon());
        auto.start();
        // auto.setDaemon(true); // 오류 발생
        
        try {
            for (int i=1; i<=20; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            
        }
        System.out.println("main 쓰레드 종료");

    }
}

// 자동 저장하는 쓰레드(3초에 한번씩 저장하는 쓰레드)
class AutoSave extends Thread {
    // 처리 결과를 저장하는 메소드
    public void save() {
        System.out.println("처리 결과를 저장합니다");

    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
            save();
        }
    }
}