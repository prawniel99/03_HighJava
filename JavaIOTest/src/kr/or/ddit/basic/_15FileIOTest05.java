package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15FileIOTest05 {

    public static void main(String[] args) {
        // 한글이 저장된 파일 읽어오기
        try {
//            FileReader fr = new FileReader("d:/d_other/test_ansi.txt");
            FileReader fr = new FileReader("d:/d_other/test_utf8.txt");
            FileInputStream fin = new FileInputStream("d:/d_other/test_ansi.txt");
            // 기본 인코딩 방식을 이용하여 읽어온다.
            // InputStreamReader isr = new InputStreamReader(fin); // 문자 스트림으로 변환해준건데, 이렇게만 하면 위에 file reader랑 동일한거임.

            // 인코딩 방식을 지정해서 읽어오기
            // 인코딩 방식 예시
            // - MS949(또는 CP949) ==> 윈도우즈에서 사용하는 기본 한글 인코딩방식
            // - UTF08 ==> 유니코드 UTF-8 인코딩 방식
            // - US_ASCII ==> 영문 전용 인코딩 방식
//            InputStreamReader isr = new InputStreamReader(fin, "ms949");
            InputStreamReader isr = new InputStreamReader(fin, "utf-8");
            
            int c;

            while ((c=fr.read())!=-1) {
                System.out.print((char)c);
            }
            fr.close();
            isr.close();
        } catch(IOException e) {

        }
    }
}
