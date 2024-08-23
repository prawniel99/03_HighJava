package m8.d20;

// JavaDoc 파일 만들기 ==> 프로그램과 메뉴얼을 같이 만드는 방법

/**
 * 이 영역에서는 HTML태그를 이용하여 문서를 작성할 수 있다.
 * 
 * @author hamin
 * @version 0.0.1
 * <p>
 * 파일명: N01JavaDocTest.Java<br>
 * 설명: JavaDoc문서를 작성하기 위한 연습용 interface<br><br>
 * 
 * 수정 이력<br>
 * ---------------------------<br>
 * 변경일자: 2024-08-20<br>
 * 변경인: 홍길동<br>
 * 변경내용: 최초생성<br>
 * ---------------------------<br>
 * </p>
 */
public interface N01JavaDocTest {

    // 주석

    /*
     * 주석
     */
    
    /**
     * 
     * 슬래시+별두개 하고 엔터하면 자동으로 이렇게 만들어주고, @param으로 해서, parameter 뭔지 설명도 쓰게 해줌.
     * 
     * 메소드명: methodTest<br>
     * 설명: 반환값이 없는 메소드<br>
     * @param a 첫번째 매개변수 (정수형)
     * @param b 두번째 매개변수 (정수형)
     */
    public void methodTest(int a, int b);

    /**
     * 메소드명: methodAdd<br>
     * 설명: 반환값이 있는 메소드<br>
     * @param x 정수형 첫번째 변수
     * @param y 정수형 두번째 변수
     * @return 처리된 결과를 정수형으로 반환한다.
     */
    public int methodAdd(int x, int y);

    /**
     * 메소드명: methodInput<br>
     * 설명: 매개변수가 없는 메소드<br>
     * 
     * @return 정수형 자료를 반환한다.
     */
    public int methodInput();

}
