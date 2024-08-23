package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

public class _02FileTest02 {
    
    public static void main(String[] args) {
        File f1 = new File("d:/D_Other/test.txt");
        System.out.println(f1.getName()+"의 크기: "+f1.length()+"bytes(s)");
        System.out.println("path: "+f1.getPath());
        System.out.println("absolutePath: "+f1.getAbsolutePath());

        // 현재 위치 나타내기
        File f2 = new File(".");
        System.out.println("Path: "+f2.getPath());
        System.out.println("absolutePath: "+f2.getAbsolutePath());
        System.out.println();
        
        if(f1.isFile()) {
            System.out.println(f1.getName()+"는 파일입니다");
        } else if(f1.isDirectory()) {
            System.out.println(f1.getName()+"은 디렉토리입니다");
        } else {
            System.out.println(f1.getName()+"는(은) 뭘까?");
        }
        System.out.println();
        
        if(f2.isFile()) {
            System.out.println(f2.getName()+"는 파일입니다");
        } else if(f2.isDirectory()) {
            System.out.println(f2.getName()+"은 디렉토리입니다");
        } else {
            System.out.println(f2.getName()+"는(은) 뭘까?");
        }
        System.out.println();


        File f3 = new File("d:/D_Other/sample.txt");
        
        if(f3.isFile()) {
            System.out.println(f3.getName()+"는 파일입니다");
        } else if(f3.isDirectory()) {
            System.out.println(f3.getName()+"은 디렉토리입니다");
        } else {
            System.out.println(f3.getName()+"는(은) 뭘까?"); // 없어서 뭘까라고 나옴
        }
        System.out.println();

        if(f3.exists()) {
            System.out.println(f3.getAbsolutePath()+"는(은) 이미 존재합니다");
        } else {
            System.out.println(f3.getAbsolutePath()+"는(은) 존재하지 않습니다");
            try {
                if(f3.createNewFile()) {
                    System.out.println(f3.getAbsolutePath()+" 파일 만들기 성공");
                } else {
                    System.out.println(f3.getAbsolutePath()+" 파일 만들기 실패");
                }
            } catch (IOException e) {

            }
        }




        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());
        System.out.println(f3.isAbsolute());
        System.out.println(f3.isHidden());

    }
}
