package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class _04ByteArrayIOTest01 {
    
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        // 스트림 객체 생성
        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        int data; // 읽어온 자료가 저장될 변수

        // read()메소드는 더 이상 읽어올 자료가 없으면 -1을 반환한다.
        while((data=input.read())!=-1) {
            // 읽어온 자료를 이용한 처리를 한다.
            output.write(data); // 출력하기
        }

        // 출력된 스트림값을 배열로 변환해서 저장하기
        outSrc = output.toByteArray();

        // 사용했던 스트림은 작업이 끝나면 닫아준다 ==> 자원 반납
        try {
            input.close();
            output.close();
        } catch (IOException e) {

        }
        System.out.println("inSrc => "+Arrays.toString(inSrc));
        System.out.println("outSrc => "+Arrays.toString(outSrc));
    }
}
