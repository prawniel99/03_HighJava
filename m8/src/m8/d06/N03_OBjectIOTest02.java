package m8.d06;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class N03_OBjectIOTest02 {

    public static void main(String[] args) {
        // 저장된 객체를 읽어와 그 내용을 화면에 출력하기
        try {
            // 입력용 스트림 객체 생성
            ObjectInputStream oin = new ObjectInputStream(
                new BufferedInputStream(
                    new FileInputStream("d:/d_other/memObj.dat")
                )
            );
            Object obj = null; // 읽어온 객체를 저장할 변수
            System.out.println("객체 읽기 작업 시작");
            while((obj=oin.readObject())!=null) {
                // 읽어온 데이터를 원래의 객체형으로 변환해서 사용한다
            	N01_Member mem = (N01_Member) obj;
                System.out.println("이름: "+mem.getName());
                System.out.println("나이: "+mem.getAge());
                System.out.println("주소: "+mem.getAddr());
                System.out.println("----------------------");
            }
            oin.close();
        } catch (EOFException e) {
            System.out.println("읽기 작업 끝");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
