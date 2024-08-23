package kr.or.ddit.basic.m0729;

// wait(), notify()를 이용해서 두 쓰레드가 번갈아 한번씩 실행하는 예제

// wait(), notify(), notifyAll() 메소드들은 동기화 블러에서만 사용 가능하다.
public class ThreadTest18 {

    public static void main(String[] args) {
        WorkObject workObj = new WorkObject();

        Thread01 th1 = new Thread01(workObj);
        Thread02 th2 = new Thread02(workObj);

        th1.start();
        th2.start();
    }
}

// 공통으로 사용할 class
class WorkObject {
    public synchronized void method01() {
        System.out.println("method01() 메소드 실행중");

        notify();

        try {
        	System.out.println("1wait");
            wait();
            System.out.println("1wait 끝");
        } catch (InterruptedException e) {

        }
    }

    public synchronized void method02() {
        System.out.println("method02() 메소드 실행중");

        notify();

        try {
        	System.out.println("2wait");
            wait();
            System.out.println("2wait 끝");
        } catch (InterruptedException e) {

        }
    }
}

// WorkObject의 method01() 메소드만 호출하는 쓰레드
class Thread01 extends Thread {
    private WorkObject workObj;

    public Thread01(WorkObject workObj) {
        this.workObj = workObj;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++) {
            workObj.method01();
        }
        synchronized (workObj) {
            workObj.notify();
        }
    }
}

class Thread02 extends Thread {
    private WorkObject workObj;

    public Thread02(WorkObject workObj) {
        this.workObj = workObj;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++) {
            workObj.method02();
        }
        synchronized (workObj) {
            workObj.notify();
        }
    }
}