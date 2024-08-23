package kr.or.ddit.basic.sec01;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// 객체 생성
		Vector<Object> v1 = new Vector<Object>();
		
		
		
		// 크기 출력
		System.out.println("v1의 크기: "+v1.size());
		
		
		
		// 데이터 추가하기: add(추가할 데이터)
		// 반환값: 추가 성공하면(true), 추가 실패하면(false)
		v1.add("AAAA");
		System.out.println("v1.add(\"AAAA\"); 명령으로 값 추가");
		a();
		v1.add(new Integer(111)); // *a 옛날에는 전부 이렇게 객체화 시켜 만들었어야 함.
		System.out.println("v1.add(111); 명령으로 값 추가");
		System.out.println("v1의 크기: "+v1.size());
		System.out.println("v1 전체: "+v1);
		a();
		v1.add(123); // *a 지금은 그냥 이렇게 하면 기본타입 알아서 객체화 시켜줌.
		// 이걸 auto-boxing 기능이라고 함. Integer 라는 wrapper 클래스. Integer 인데 int 자동으로.
		// 자동으로 꺼내주는건 auto-unboxing 기능.
		v1.add('a');
		v1.add(true);
		v1.add(2.5534);
		boolean r = v1.add(3.14);
		System.out.println("v1의 크기: "+v1.size());
		System.out.println("v1 전체: "+v1);
		System.out.println("반환값: "+r); // 값이 넣어졌으니, true
		a();
		
		
		
		// 데이터 추가하기2: addElement(추가할데이터)
		// add랑 기능이 똑같은데, 사실 addElement가 먼저 만들어짐.
		// collection이 체계화 되어있지 않던 시절, 얘가 한 축 담당.
		// 이전 버전의 프로그램과의 호환성을 위해 남아있음
		v1.addElement("CCC");
		System.out.println("v1==> "+v1.toString()); // toString 하면 안에 있는거 전체.
		// toString 생략 가능. 위에 +v1으로 출력한거랑 동일함. 휴. 타입 다른 줄 ㅋㅋ.
		a();
		
		
		
		// 데이터 추가하기3: add(index, 데이터)
		// ==> 'index'번째에 '데이터를' 기워넣어라
		// ==> 'index'는 0부터 시작한다.
		// ==> 반환값이 없다.
		System.out.println("v1 끼워넣기 전 전체: "+v1);
		v1.add(1, "KKKK"); // 2번째에 끼워넣기
		System.out.println("v1 끼워넣은 후 전체: "+v1);
		a();
		
		
		
		// 데이터 꺼내오기: get(index)
		// ==> 'index'번째 데이터를 꺼내서 반환한다.
		System.out.println("0번째 데이터: "+v1.get(0));
		// 주의사항. 컬렉션 안에 index 2가 int여도 int에 못담음.
//		int iTemp = v1.get(2);
//		Integer iTemp = v1.get(2);
		// 왜? 타입이 기본 Object이기 때문.
		int temp = (int)v1.get(2);
		int iTemp = (Integer)v1.get(2);
		Integer tempI = (Integer)v1.get(2);
		Integer pemtI = (int)v1.get(2); // 다 가능
		// 부모에는 자식을 넣을 수 있다.
		// vector는 여러값을 담는 것.
		// 근데 뭘 담을 줄 모르지.
		// 그렇기 때문에, 가장 상위 객체인 Object로 만들고,
		// 아무거나 담을 수 있게 하는 것.
		// 부모에 자식을 넣을때는 '자동형변환' 발생. int 넣어도 char 넣어도 Object로 바뀜.
		// 자식에 부모를 넣을때는 '명시적형변환'을 해줘야 함. 직접 바꾸는거, '강제형변환'.
		System.out.println(temp);
		System.out.println(iTemp);
		System.out.println(tempI);
		System.out.println(pemtI);
		System.out.println(temp+iTemp+tempI+pemtI);
		System.out.println(""+temp+iTemp+tempI+pemtI);
		a();
		
		
		
		// 데이터 수정하기: set(index, 새로운데이터)
		// ==> 'index'번째의 데이터를 '새로운 데이터'로 변경한다.
		// ==> 반환값: 원래의 데이터
		System.out.println("v1: "+v1);
//		String sTemp = v1.set(0, "zzzz");
		String sTemp = (String)v1.set(0, "zzzz");
		System.out.println("v1: "+v1);
		System.out.println("반환값: "+sTemp); // 오옹? sTemp는 여전히 AAAA네? 오홍.
		// 반환값이 원래의 데이터라는 말이 저런거구나. 오홍
		a();
		
		
		
		// 데이터 삭제하기: remove(index)
		// ==> 'index'번째의 데이터를 삭제한다.
		// ==> 반환값: 삭제된 데이터
		System.out.println("v1(before remove): "+v1);
		v1.remove(0);
		System.out.println("v1(after remove):        "+v1);
		sTemp = (String)v1.remove(0);
		System.out.println("v1(after another remove):      "+v1);
		System.out.println("원래의 데이터: "+sTemp);
		// 그냥 remove 하면 바로 사라져버리는거고, 변수지정해서 remove하면 그 값을 담네?
		// 이거 잘 쓰면 괜찮을 듯.
		a();
		
		
		
		// 데이터 삭제하기2: remove(삭제할 데이터)
		// ==> '삭제할 데이터'를 찾아서 삭제한다.
		// ==> '삭제할 데이터'가 여러개면 이들 중 첫번째 데이터를 삭제한다.
		// ==> 반환값: 삭제성공=true, 삭제실패=false
		// 값 없이 삭제랑 반환값이 다르다. 중요.
		// ==> '삭제할 데이터'가 '정수형' 이거나 'char형'일 경우에는 반드시 객체로 반환해서 사용해야 한다.
		System.out.println("v1(before remove: "+v1);
		v1.remove("CCC");
//		v1.remove(123); // 이렇게 하면 overloading 이 발생, 오류가 됨.
		// overriding은 재정의, overloading은 복제. 
		// 복제 overloading을 방지하기위해, 매개변수를 가지고 구분을 한다.
//		v1.remove((int)123); // 이것도 똑같이 오류나네.
		v1.remove(new Integer(123)); // 자바 1.8 까지는 이렇게 쓰면 되는데, 1.9부터는 지양 권고.
		v1.add(556);
		System.out.println("v1(after add): "+v1);
		v1.remove(Integer.valueOf(556)); // 자바 1.9 부터는 이렇게 쓰라고 함.
		System.out.println("v1(after remove): "+v1);
		// char형도 문제
//		v1.remove('a'); // character a 는 숫자 97 이기 때문에, 이것도 97번 인덱스를 뜻하게 됨.
		System.out.println("v1(after remove): "+v1);
		// 모두 숫자로 변경되어서 컴퓨터 내부로 넘어감.
//		v1.remove(new Character ('a')); // 이것도 동일하게 '지양'. 
		v1.remove(Character.valueOf('a'));
		System.out.println("v1(after remove): "+v1);
		v1.remove(3.14); // 이거는 실수라 자동으로 가능
		System.out.println("v1(after remove): "+v1);
		v1.remove(true); // boolean 타입도 가능. 이걸 뭐라 하지. 논리타입?
		System.out.println("v1(after remove): "+v1);
		a();

		
		
		// 전체 데이터  삭제하기: clear();
		for(int i=0; i<10; i++) {
			v1.add(i);
			System.out.println(v1);
		}
		v1.clear();
		System.out.println("v1.clear() 실행으로 모두 삭제");
		System.out.println("v1 크기: "+v1.size());
		System.out.println(v1);
		a();
		char a = 52488;
		System.out.println(a);
//		System.out.println(Character.valueOf(a+1));
//		for(int i=0; i<100; i++) {
//			char aa = 52488;
//			aa+=i;
//			System.out.print(aa);
//		}
		a();
		
		
		
		/*
		 *  제네릭 타입(Generic Type)
		 *  vectore에 다양한 타입을 넣는 경우는 사실 굉장히 드문 경우다.
		 *  컬렉션에는 같은 타입을 사용하는게 일반적.
		 *  ==> 클래스 내부에서 사용할 데이터의 타입을 객체를 생성할 때 외부에서
		 *      지정해주는 기법으로, 객체를 선언할 때 < > 괄호 안에 그 객체의
		 *      내부에서 사용할 데이터의 타입을 지정해주는 것을 말한다.
		 *      
		 *      - 이런 방법으로 선언하게 되면, 지정한 데이터 타입 이외
		 *        다른 종류의 데이터를 저장할 수 없다.
		 *      - 데이터를 꺼내올 때 별도의 형변환이 필요 없다.
		 *      - 제네릭으로 선언될 수 있는 타입은 '클래스형'이어야 한다.
		 *        그래서 int는 Integer, boolean은 Boolean,
		 *        char은 Character 이런 식.
		 */
		Vector<Integer> v2 = new Vector<>();	// int형 자료만 저장할 수 있는 벡터
		Vector<String> v3 = new Vector<String>(); // String형만 저장할 수 있는 벡터
		System.out.println(v2);
		
		v3.add("안녕하세요");
		v3.add("들어가세요");
//		v3.add(100); int 타입이기 때문에 오류남.
		System.out.println(v3);
		System.out.println(v3.get(0)+v3.get(1));
		
		String sTemp2 = v3.get(0); // 형변환 없이 사용 가능. 스트링 타입이니까.
		System.out.println(sTemp2);
		
		// 벡터안에 벡터
		Vector<Vector<Integer>> vv = new Vector<Vector<Integer>>(); // 2차원배열과 비슷한것.
		Vector<Vector<Vector<String>>> vvv = new Vector<Vector<Vector<String>>>(); // 이것도 가능.
		System.out.println(vv);
		System.out.println(vvv);
		// 근데 안 씀.
		v3.clear();
		a();
		
		v3.add("AAAA");
		v3.add("BBBB");
		v3.add("CCCC");
		v3.add("DDDD");
		v3.add("EEEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBBB");
		v4.add("EEEE");
		
		System.out.println("v3: "+v3);
		System.out.println("v4: "+v4);
		a();
		
		
		
		// 데이터 삭제하기3: removeAll(Collection객체)
		// ==> 벡터의 데이터 중에서 'Collection객체'가 가지고 있는 모든 데이터를 삭제한다.
		//     clear은 그냥 전부 삭제. 뭐가 차이인지 아직 모름.
		// ==> 반환값: 삭제성공(true), 삭제실패(false)
		System.out.println("v3 values: "+v3);
		System.out.println("v4 values: "+v4);
		v3.removeAll(v4); // 오호. v3 안에서 v4 collection 객체 값 모두를 삭제.
		boolean bTest = v3.removeAll(v4);
		System.out.println("이미 지워졌으니 "+bTest);
		System.out.println("v3 values: "+v3);
		System.out.println("v4 values: "+v4);
		v3.clear();
		a();
		
		
		
		v3.add("AAAA");
		v3.add("BBBB");
		v3.add("CCCC");
		v3.add("DDDD");
		v3.add("EEEE");
		// 벡터의 전체 데이터를 순서대로 가져와 사용하고 싶으면 반복문 사용
		// 주로 for문 사용
		for(int i=0; i<v3.size(); i++) {
			System.out.println(i+"번째 데이터: "+v3.get(i));
		}
		a();
		
		// 향상된 for문 유용함.
		for(String str : v3) {
			System.out.println("for문을 사용해서 v3 출력: "+str);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void a() {
		System.out.println("---------------------------------------------");
	}
	
}