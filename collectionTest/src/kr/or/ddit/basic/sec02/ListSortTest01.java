package kr.or.ddit.basic.sec02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 *  
 *  정렬과 관련된 interface는 Comparable, Comparator 이렇게 두가지가 있다.
 *  
 *  Comparable은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때 구현하는 인터페이스
 *  (이것을 내부 정렬 기준이라 한다.)
 *  
 *  Comparator은 외부에 별도로 정렬 기준을 구현하고 싶을 때 구현하는 인터페이스이다.
 *  (이것은 외부 정렬 기준이라 한다.)
 *  
 *  Comparable에서는 compareTo() 메소드를 재정의 하고,
 *  Comparator에서는 compare() 메소드를 재정의 해야 한다.
 *  
 *  String 클래스, Wrapper 클래스, Date 클래스, File 클래스에는 내부정렬 기준이 정해져있다.
 *  (구현된 내부정렬 기준은 오름차순으로 처리되도록 구현되어 있다.)
 *  
 */

public class ListSortTest01 {
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		System.out.println("정렬 전: "+list);
		
		// 정렬은 Collection.sort() 메소드를 이용하여 정렬한다.
		// Collections.sort() 메소드는 기본적으로 내부 정렬 기준으로 정렬한다.
		Collections.sort(list);
		System.out.println("정렬 후: "+list);
		
		Collections.shuffle(list);
		System.out.println("섞기: "+list);
		
		//-----------------------------------
		// 외부정렬 기준 클래스를 이용하여 정렬하기
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬 후: "+list);
	}
}

// 정렬 방식을 정해주는 class를 만든다. (외부 정렬 기준 클래스라고 한다.)
// ==> Comparator 인터페이스를 구현해서 작성한다.
class Desc implements Comparator<String> {
	// compare() 메소드를 이용해서 정렬하고자 하는 기준을 정해준다.
	
	// compare() 메소드의 반환값의 의미
	// 반환값이 0이면 두 값이 같다.
	// 반환값이 양수이면 두 값의 순서를 바꾼다.
	// 반환값이 음수이면 두 값의 순서를 바꾸지 않는다.
	// 예) 오름차순일 경우 ==> 앞의 값이 크면 양수,
	//						   같으면 0,
	//						   앞의 값이 작으면 음수,
	//                         를 반환하도록 구현하면 된다.
	
	@Override
	public int compare(String str1, String str2) {
		// 내림차순으로 구현하려고 한다.
		/*
		if(str1.compareTo(str2)>0) {
			return -1;
		} else if(str1.compareTo(str2)<0) {
			return 1;
		} else {
			return 0;
		}
		*/
		return str1.compareTo(str2)*-1; // 간단하게 만들기
	}
}


