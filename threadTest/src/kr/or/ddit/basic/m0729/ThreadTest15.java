package kr.or.ddit.basic.m0729;

// 두개의 쓰레드가 하나의 객체에 값 더하기

public class ThreadTest15 {
    public static void main(String[] args) {
        ShareObject sObj = new ShareObject(); // 공통 객체 생성
        TestThread th1 = new TestThread("1번쓰레드", sObj);    
        TestThread th2 = new TestThread("2번쓰레드", sObj);    
        th1.start();
        th2.start();
    }
}

// 공통으로 사용할 객체
class ShareObject {
    private int sum = 0;

    // 기본
//     public void add() {
//         int num = sum;
//         num += 10; // 10 증가하기
//         sum = num; // sum+=10; 으로 안한 이유는 에러 확률을 높이기 위해.
//         System.out.println(Thread.currentThread().getName()+"합계: "+sum);
//     }
    
    // 동기화 처리 하기(메소드에 동기화 걸기)
//    public synchronized void add() {
//        int num = sum;
//        num += 10; // 10 증가하기
//        sum = num; // sum+=10; 으로 안한 이유는 에러 확률을 높이기 위해.
//        System.out.println(Thread.currentThread().getName()+"합계: "+sum);
//    }
    
    // 동기화 처리 하기(동기화 블럭 사용)
    public void add() {
    	synchronized (this) {
    		int num = sum;
    		num += 10; // 10 증가하기
    		sum = num; // sum+=10; 으로 안한 이유는 에러 확률을 높이기 위해.
    		System.out.println(Thread.currentThread().getName()+"합계: "+sum);
		}
    }
}

class TestThread extends Thread {
    private ShareObject sObj;

    public TestThread(String name, ShareObject sObj) {
        super(name); // Thread의 name값 설정
        this.sObj = sObj;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++) {
            sObj.add();
        }
    }

    // ShareObject에 더하기를 열번 해주는 단순한 쓰레드
}