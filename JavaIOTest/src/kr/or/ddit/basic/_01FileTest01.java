package kr.or.ddit.basic;

import java.io.File;

public class _01FileTest01 {
    public static void main(String[] args) {
        // File 객체 만들기 연습

        // 1. new File(String 파일또는경로);
        //    ==> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분 문자는
        //        슬레쉬('/')를 사용하거나 역슬레쉬('\')를 사용할 수 있다.

        // File file1 = new File("d:/D_Other/test.txt"); // 구분문자를 '/'로 사용
        File file1 = new File("d:\\D_Other\\test.txt"); // 구분문자를 '\'로 사용. \ 하나만 하면 escape가 됨. \t가 탭으로 인식됨.
        System.out.println("file1");
        System.out.println("파일명: "+file1.getName());
        System.out.println("파일인가?: "+file1.isFile());
        System.out.println("디렉토리인가?: "+file1.isDirectory());
        System.out.println();

        File file2 = new File("d:/D_Other");
        System.out.println("file2");
        System.out.println("파일명: "+file2.getName());
        System.out.println("파일인가?: "+file2.isFile());
        System.out.println("디렉토리인가?: "+file2.isDirectory());
        System.out.println();
        
        // 2. new File(File parent, String child)
        //    ==> 'parent' 디렉토리 안에 있는 'child' 파일을 의미한다.
        File file3 = new File(file2, "test.txt");
        System.out.println("file3");
        System.out.println("파일명: "+file3.getName());
        System.out.println("파일인가?: "+file3.isFile());
        System.out.println("디렉토리인가?: "+file3.isDirectory());
        System.out.println();
        
        // 3. new File(String parent, String child)
        //    ==> 
        File file4 = new File("d:/D_Other", "test.txt");
        System.out.println("file4");
        System.out.println("파일명: "+file4.getName());
        System.out.println("파일인가?: "+file4.isFile());
        System.out.println("디렉토리인가?: "+file4.isDirectory());
        System.out.println();
        //------------------------------------------------------------

        // 디렉토리(폴더) 만들기
        // -mkdir()  ==> File객체의 경로 중에서 마지막 위치의 디렉토리를 만든다.
        //           ==> 만들기 성공 true, 실패 false 반환.
        // -mkdirs() ==> 중간의 경로가 없으면 중간의 경로도 같이 만들어 준다.
        //           ==> 만들기 성공 true, 실패 flase 반환.
        File file5 = new File("d:/D_Other/연습용");

        System.out.println(file5.getName()+"의 존재여부: "+file5.exists());

        if(file5.mkdir()) {
            System.out.println(file5.getName()+"만들기 성공");
        } else {
            System.out.println(file5.getName()+"만들기 실패");
        }
        // file5.delete();
        System.out.println();

        File file6 = new File("d:/D_Other/test/java/src");
        System.out.println(file6.getName()+"의 존재여부: "+file6.exists());
        if(file6.mkdirs()) { // 오홍, mkdir은 중간에 디렉토리들이 없으면 안되고, mkdirs는 없는것들도 전부 만들어 줌. 오홍.
            System.out.println(file6.getName()+" 만들기 성공");
        } else {
            System.out.println(file6.getName()+" 만들기 실패");
        }
    }
}
