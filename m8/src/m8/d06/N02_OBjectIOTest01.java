package m8.d06;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class N02_OBjectIOTest01 {
    public static void main(String[] args) {
    //Member클래스의 인스턴스 생성
        N01_Member mem1 = new N01_Member("홍길동", 20, "대전");
        N01_Member mem2 = new N01_Member("홍길서", 30, "강릉");
        N01_Member mem3 = new N01_Member("홍길님", 40, "울신");
        N01_Member mem4 = new N01_Member("홍길븍", 50, "목포");
  
        //객체를 파일에 저장하기
        try {
            //출력용 스트림 객체 생성
            // FileOutputStream fout = new FileOutputStream("d:/d_other/memObj.dat");
            FileOutputStream fout = new FileOutputStream("d:/haminTest/memObj.txt");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            ObjectOutputStream oout = new ObjectOutputStream(bout);

            //쓰기(출력) 작업
            System.out.println("객체 저장작업 시작...");
            oout.writeObject(mem1);
            oout.writeObject(mem2);
            oout.writeObject(mem3);
            oout.writeObject(mem4);

            // 객체를 저장할 때 마지막에 null을 저장하면 EOFException을 방지할 수 있다.
            oout.writeObject(null);

            System.out.println("객체 저장 작업 끝...");

            oout.close(); //스트림 닫기
        } catch (IOException e) {
    
        }
    }
}
