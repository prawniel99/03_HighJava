package kr.or.ddit.basic.m0729;

// yield() 연습용

public class ThreadTest10 {
    public static void main(String[] args) {
        YieldTest th1 = new YieldTest("1번 쓰레드");
        YieldTest th2 = new YieldTest("2번 쓰레드");

        th1.start();
        th2.start();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) { }
        System.out.println("111111111111111111-----------------------");
        th1.work = false;
        
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) { }
        System.out.println("222222222222222222-----------------------");
        th1.work = true;

        try {
        	Thread.sleep(5);
        } catch (InterruptedException e) { }
        System.out.println("333333333333333333-----------------------");
        th1.work = true;
        th2.work = true;

    }
}

// yield() 메소드 연습용 쓰레드
class YieldTest extends Thread {
    public boolean stop = false;
    public boolean work = true;

    // 생성자
    public YieldTest(String name) {
        super(name); // 쓰레드 생성자 중 String값을 받는 생성자가 있음.
        // 문자열 받아서 Thread의 이름으로 설정해주는 생성자임.
    }

    @Override
    public void run() {
        while(!stop) { // stop변수의 값이 true가 되면 반복문이 종료된다.
            if(work) {
                // getName()메소드 ==> 쓰레드의 이름을 반환한다.
                System.out.println(getName()+"작업중");
            } else {
                System.out.println(getName()+"양보");
                Thread.yield();
            }
        }
    }
}