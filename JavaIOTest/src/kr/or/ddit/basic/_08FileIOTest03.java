package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class _08FileIOTest03 {
    
    public static void main(String[] args) {
        // 문자 기반 스트림을 이용한 파일 내용 읽기
        try {
            FileReader fr = new FileReader("d:/d_other/test.txt");
            int c;
            while((c=fr.read())!=-1) {
                System.out.print((char)c);
            }
            fr.close();
        } catch (IOException e) {

        }
    }
}
