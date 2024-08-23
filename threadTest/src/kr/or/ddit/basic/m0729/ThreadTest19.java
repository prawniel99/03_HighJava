package kr.or.ddit.basic.m0729;

public class ThreadTest19 {
	public static void main(String[] args) {
		ShareDataBox dataBox = new ShareDataBox(); // 공통으로 사용할 객체
		ProducerThread th1 = new ProducerThread(dataBox);
		ConsumerThread th2 = new ConsumerThread(dataBox);
		th1.start();
		th2.start();
	}
}

class ShareDataBox {
    private String data;

    // data변수에 값이 있으면 data 변수가 null이 될 때까지 기다린다.
    // data변수가 null이 되면 새로운 데이터를 data변수에 저장한다.
    public synchronized void setData(String data) {
        if(this.data!=null)
        try {
            wait();
        } catch (InterruptedException e) {

        }
        this.data = data;
        System.out.println("Thread에서 새로 공급한 데이터: "+data);
        notify();
    }

    // data 변수가 null이면 data 변수에 문자열이 채워질 때까지 기다린다.
    // data변수에 값이 있으면 해당 문자열을 반환한다.
    // 반환 후에는 data 변수 값을 null로 변경한다.
    public synchronized String getData() {
        if(data==null) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        // data 변수의 값을 임시변수에 저장한다.
        String returnData = data;
        data = null;
        System.out.println("스레드가 읽은 데이터: "+returnData);
        notify();
        return returnData;
    }
}

// 데이터를 넣어주는 역할만 하는 쓰레드
class ProducerThread extends Thread {
    private ShareDataBox dataBox;

    public ProducerThread(ShareDataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        String[] dataArr = new String[] {"홍길동", "이순신", "강감찬", "변학도"};
        for(int i=0; i<dataArr.length; i++) {
            dataBox.setData(dataArr[i]);
        }
    }
}

// 데이터를 꺼내서 사용하는 쓰레드
class ConsumerThread extends Thread {
    private ShareDataBox dataBox;

    public ConsumerThread(ShareDataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for(int i=0; i<4; i++) {
            dataBox.getData();
        }
    }
}