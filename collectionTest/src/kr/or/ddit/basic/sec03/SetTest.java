package kr.or.ddit.basic.sec03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;

public class SetTest {
	
	public static void main(String[] args) {
		SetTest obj = new SetTest();
		obj.process();
	}
	
	public void process() {
//		listAndSet();
		setSample();
	}
	
	private void setSample() {
		expl("우리반 학생들의 번호를 이용하여 추첨하는 프로그램을 작성하기");
		// 번호는 1~29까지 있고, 추첨할 인원은 3명이다.
		// 당첨 번호를 출력해보시오.
		
		// HashSet 만들기
		HashSet<Integer> setSample = new HashSet<Integer>();
		
		// 최소값~최대값 사이의 정수형 난수 만들기
		// (int)(Math.random() * (최대값-최소값+1) + 최소값)
		
		while(setSample.size()<3) {
			setSample.add((int)(Math.random()*29-1+1)+1);
		}
		System.out.println("당첨자: "+setSample);
		
		// 중복값 없는 집합을 만들때는 Set이 좋지만, 만든 후 다룰때는 List를 사용하는것이 더 좋다.
		expl("Set을 List로 변경하기");
		ArrayList<Integer> testList = new ArrayList<Integer>(setSample); // 매개변수로 set을 넣어주면 데이터가 다 들어감. 오홍.
		for(int i=0; i<testList.size(); i++) {
			System.out.print(testList.get(i));
			if(testList.size()-i<=1) System.out.println();
			else System.out.print(" ");
		}
	}

	public void listAndSet() {
		/*
		 *  List와 Set의 차이점
		 *  1. List
		 *     - 데이터의 순서(index)가 있다.
		 *     - 중복되는 데이터를 저장할 수 있다.
		 *  
		 *  2. Set
		 *     - 데이터의 순서(index)가 없다.
		 *     - 중복되는 데이터를 저장할 수 없다. (핵심)
		 *     - 보통 HashSet 클래스 사용.
		 */
		
		HashSet<Object> hs1 = new HashSet<Object>();
		
		expl("add() 메소드 사용하여 Set에 데이터 추가하기");
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("hs1의 개수 "+hs1.size());
		System.out.println("hs1 출력 "+hs1.toString());
		// toString 생략 가능
		System.out.println("hs1 출력 "+hs1);
		
		expl("Set에 중복되는 데이터를 추가하면 false를 반환하고, 데이터는 추가되지 않는다.");
		System.out.println(hs1.add("FF"));
		System.out.println("hs1 출력 "+hs1);
		System.out.println(hs1.add("DD"));
		System.out.println("hs1 출력 "+hs1);
		
		// Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에
		// 해당 자료를 삭제한 후 추가해주는 방법으로 처리해야 한다.
		
		// 삭제하는 메소드: remove(삭제할 자료) ==> 반환값: 삭제성공(true), 실패(false)
		//                  clear() ==> 전체 삭제
		
		expl("FF 데이터를 EE로 변경하기");
		hs1.remove("FF");
		System.out.println(hs1);
		hs1.add("EE");
		System.out.println(hs1);
		
//		hs1.clear();
//		System.out.println(hs1);
		
		expl("iterator 메소드로 Set 데이터 불러오기");
		/*
		 *  Set의 데이터는 순서(index)가 없기 때문에,
		 *  List처럼 index로 데이터를 하나씩 불러올 수 없다.
		 *  그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해야 한다.
		 *  
		 *  Set형의 데이터들을 Iterator형 객체로 변환하는 메소드
		 *  ==> iterator()
		 */
		Iterator<Object> it = hs1.iterator(); // Set 데이터인 hs1을 Iterator로 변환하기
		
		// Iterator의 hasNext() 메소드
		// ==> Iterator의 포인터가 가리키는 곳의 다음번째 위치에 데이터가 있는지 검사한다.
		//     있으면 true, 없으면 false 반환.
		// Iterator의 next() 메소드
		// ==> Iterator의 포인터를 다음번째 위치로 이동 시킨 후,
		//     이동한 위치에 있는 데이터를 반환한다.
		while(it.hasNext()) {
			System.out.print(it.next()+"  ");
		}
		
		expl("iterator 대신 향상된 for문 사용하기");
		for(Object obj : hs1) {
			System.out.print(obj+"  ");
		}
		
		
	}
	
	public void expl(String s) {
		System.out.println("\n---------------------------------------------------\n"+s+"\n");
	}
}
