package kr.or.ddit.basic.sec02;

/*
 * enum(열거형) ==> 서로 관련있는 상수들의 집합을 나타낸다.
 *              ==> 클래스처럼 보이게하는 상수
 * 
 * 작성방법
 * ==> 열거형은 클래스처럼 독립된 java파일에 만들 수 있고,
 *     하나의 java파일에 클래스와 같이 만들 수 있고,
 *     클래스 내부에 내부 클래스처럼 만들 수 있다.
 *     
 * 열거형의 속성 및 메소드
 * 1) 열거형변수.name()		==> 열거형 상수의 이름을 문자열로 반환한다.
 * 2) 열거형변수.ordinal()	==> 얼거형 상수가 정의된 순서값(index값)을 반환한다. (0부터 시작)
 * 3) 열거형이름.valueOf("열거형상수명") ==> 인수값에 지정한 '열거형상수명'과 일치하는 열거형 상수를 반환한다.
 * 4) 열거형이름.상수명		==> valueOf() 메소드를 사용한 결과와 같다.
 * 5) 열거형이름.values()	==> 모든 상수들을 배열에 담아서 반환한다.
 * ------------------------------------------------------------------------------
 * 
 * - 열거형 선언하기
 * 방법1)
 *    enum 열거형이름 {상수명1, 상수명2, 상수명3, ...}
 *    
 * 방법2)
 *    enum 열거형이름 {
 *        상수명1(값1, 값2, ...),
 *        상수명2(값a, 값b, ...),
 *        :
 *        상수명n(값A, 값B, ...);
 *        
 *        // '값'들이 저장될 변수들을 선언한다.
 *        private 자료형이름 변수명1;
 *        private 자료형이름 변수명2;
 *        :
 *        
 *        // 열거형의 생성자를 만든다.
 *        // 열거형의 생성자는 접근 제한자가 묵시적으로 'private'이다.
 *        // 열거형의 생성자의 역할은 '열거형상수'에 '값'들을 세팅하는 일을 한다.
 *        
 *        // 생성자의 매개변수 '값'들과 개수가 같고, 자료형이 맞아야 한다.
 *        [private] 열거형이름(자료형이름 변수명1, ...) {
 *            위에 선언된 '값'들이 저장될 변수들을 매개변수로 초기화 한다.
 *        }
 *        
 *        // 위에서 선언한 변수들을 외부에서 불러올 수 있는 getter 메소드를 작성한다.
 *    }
 */

public class EnumTest {
	public enum Color {RED, GREEN, BLUE}
	public enum Count {ONE, TWO, THREE}
	
	public enum Season {
		// 상수명(값들...) 형식으로 선언하기
		봄("3~5월", 13),
		여름("6~8월", 27),
		가을("9~11월", 15),
		겨울("12~2월", 1);
		
		// 값들이 저장될 변수 선언
		private String span;
		private int temp;
		
		// 생성자
//		private Season() { private 생략 가능
		Season(String months, int temp) {
			this.span = months;
			this.temp = temp;
		}
		
		// getter 메소드 작성
		public String getSpan() {
			return span;
		}
		
		public int getTemp() {
			return temp;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Red: "+ConstTest.RED);
		System.out.println("Three: "+ConstTest.THREE);
		
//		if(ConstTest.ONE == ConstTest.RED) {
//			System.out.println("같습니다");
//		} else {
//			System.out.println("다릅니다");
//		}
		
		Color mycol = Color.valueOf("GREEN");	// Color.GREEN; 과 같다.
		Count mycnt = Count.ONE;				// Count.valueOf("ONE"); 과 같다.
		
		System.out.println("mycol: "+mycol.name());
		System.out.println("mycol: "+mycol); // 출력할 때 name() 메소드 생략 가능. 출력할때만.
		System.out.println("mycnt: "+mycnt.name());
		System.out.println();
		
		System.out.println("mycol의 ordinal: "+mycol.ordinal());
		System.out.println("mycnt의 ordinal: "+mycnt.ordinal());
		System.out.println();
		
		/*
		if(Color.BLUE == Count.THREE) { // 오류. 서로 다른 종류의 열거형끼리는 비교가 불가능.
			System.out.println("같다");
		} else {
			System.out.println("같지 않다");
		}
		*/
		
		if(mycol == Color.BLUE) { // 같은 종류의 열거형끼리는 비교 가능.
			System.out.println("same");
		} else {
			System.out.println("different");
		}
		System.out.println("---------------------------------------------------------");
		
		Season ss = Season.valueOf("봄");
		System.out.println("name "+ss.name());
		System.out.println("ordinal "+ss.ordinal());
		System.out.println("기간 "+ss.getSpan());
		System.out.println("평균온도 "+ss.getTemp());
		
		// values() 메소드 사용하기
		for(Color col : Color.values()) {
			System.out.print("values로 전체 출력: "+col+" ");
		}
		
		for(Season season : Season.values()) {
			System.out.println(season+", "+season.getSpan()+", "+season.getTemp());
		}
		
		// 열거형을 switch문에서 비교하기
		// ==> case문에는 '상수명'만 기술해야한다.
		switch(mycol) {
//			case Color.RED: // case 열거형이름.상수명: ==> 사용불가
			case RED:
				System.out.println("RED pepperoni");
				break;
			case GREEN:
				System.out.println("GREEN wich pizza");
				break;
			case BLUE:
				System.out.println("BLUE cheese bites");
				break;
			default:
		}
	}
}




























