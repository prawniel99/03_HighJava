package kr.or.ddit.basic.sec01;

// 제네릭을 사용하지 않을 경우
class NonGeneric {
	private Object value; // 아무거나 저장할 수 있도록
	
	// 데이터 사용하려면 getter setter 필요
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
}

// 제네릭 사용하기
/*
 * 제네릭 클래스를 만드는 방법
 * 형식) class 클래스명<제네릭문자> {
 *           제네릭문자 변수명;    ==> 멤버 변수를 선언할 때 제네릭을 사용할 경우
 *           ...
 *           
 *           제네릭문자 메소드명(매개변수들...) {    ==> 메소드의 반환값에 제네릭을 사용할 경우
 *               ...
 *               return 값;
 *           }
 *           
 *           반환값타입 메소드명(제네릭문자 변수명, ...) {    ==> 매개변수를 지정할 때 제네릭을 사용할 경우
 *               ...
 *               return 값;
 *           }
 *       }
 * 제네릭문자(영어대문자 1글자를 사용한다)
 * T ==> Type
 * K ==> Key
 * V ==> Value
 * E ==> Element
 */
class MyGeneric<T> {
	private T value;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
}

public class GenericTest {
	public static void main(String[] args) {
		// 제네릭을 사용하지 않을 경우		
		NonGeneric non1 = new NonGeneric();
		non1.setValue("안녕");
		System.out.println(non1.getValue());
		
		NonGeneric non2 = new NonGeneric();
		non2.setValue(123);
		System.out.println(non1.getValue());
		System.out.println(non2.getValue());
		
		// Object니까 형변환 필수
//		String rtn1 = non1.getValue();
		String rtn1 = (String)non1.getValue();
		System.out.println("문자열 반환값: "+rtn1);
		
		int rtn2 = (int)non2.getValue();
		System.out.println("정수 반환값: "+rtn2);
		
		// 이 경우 문제. Object니까 일단 오류 안뜨는데, 실행해보면 문자열을 인트로 형변환 하는 오류가 됨.
//		int rtn3 = (int)non1.getValue(); // 문법적으로 오류가 없기 때문.
//		System.out.println("rtn3 = "+rtn3); // 제네릭이 생기기 전에는 Object로 많이 썼다는데,
		// 만들땐 모르다 나중에 실수가 많이 발생했음.
		// 그걸 해결하려고 미리 정해놓을 수 있도록 만든게 generic
		
		// 제네릭 사용하기
		MyGeneric<String> my1 = new MyGeneric<>(); // 이렇게 하면 T 자리에 String이 들어가는 것.
		my1.setValue("gentest");
//		my1.setValue(55);
		System.out.println(my1.getValue());
		
		MyGeneric<Integer> my2 = new MyGeneric<>();
		my2.setValue(55);
//		my2.setValue("문자");
		System.out.println(my2.getValue());
		
		String myRtn1 = my1.getValue();
		System.out.println("제네릭 문자열 반환값: "+myRtn1);
		
		int myRtn2 = my2.getValue();
		System.out.println("제네릭 정수 반환값: "+myRtn2);
		
	}
}
