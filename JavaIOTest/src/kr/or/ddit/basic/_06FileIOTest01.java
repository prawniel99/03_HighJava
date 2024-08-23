package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class _06FileIOTest01 {
    
    public static void main(String[] args) {
        // FileInputStream을 이용한 파일 내용 읽기
        try {
            // 읽어올 파일 정보를 매개변수로 갖는 FileInputStream 객체를 생성한다. 무조건 이거 써야하는 거.
            // 읽어올 정보를 어떻게 주느냐에 따라 방법이 달라짐.
            // 방법1) 파일을 바로 담는거
//            FileInputStream fin = new FileInputStream("d:/d_other/test.txt");

            // 방법2) 파일객체를 만들고, 그걸 담는거
            File file = new File("d:/d_other/test.txt");
            FileInputStream fin = new FileInputStream(file);

            int c; // 읽어온 자료를 저장할 변수
            while((c=fin.read())!=-1) {
                // 읽어온 문자를 화면에 출력하기
                System.out.print((char)c); // 그냥 c 하면 int type이라서 숫자가 나오니까, char로 변경함.
            }
            fin.close(); // 작업 완료 후 스트림 닫기
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
