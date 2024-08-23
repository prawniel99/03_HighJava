package kr.or.ddit.basic.sec01;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		
		// 리스트
		
		// ArrayList가 있고, LinkedList도 있다.
		// 벡터에서 배운거랑 똑같은거 가능.
		
		// ArrayList의 기본적인 사용법은 Vector와 같다.
		ArrayList<Object> list1 = new ArrayList<Object>();
		
		// add()메서드를 이용해서 데이터를 추가한다.
		list1.add("aaaa");
		list1.add("bbbb");
		list1.add(123);
		list1.add('b');
		list1.add(true);
		list1.add(123.45);
		list1.add(15.15f);
		
		System.out.println("list1 = "+list1.toString());
		System.out.println("list1 = "+list1);
		System.out.println("size  = "+list1.size());
		
		// get() 메소드로 데이터를 꺼내온다.
		System.out.println("3번째 자료: "+list1.get(3));
		a();
		
		
		
		list1.add(3, "<<4번째 자리에 a 추가하기>>");
		System.out.println("list1 = "+list1);
		
		// 데이터 변경하기
		String sTemp = (String)list1.set(3, "4번째 자리 YYYY로 변경하기");
		System.out.println("list1 = "+list1);
		System.out.println("변경 전 값은 "+sTemp);
		a();
		
		
		
		System.out.println("4번째 값 삭제하기");
//		String sTemp2 = (String)list1.remove(3);
		list1.remove(3);
		System.out.println("list1 = "+list1);
		
		list1.remove("bbbb");
		System.out.println("list1 = "+list1);
		a();
		
		
		
		System.out.println("제네릭");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		System.out.println("list2: "+list2);
		System.out.print("for문으로 출력: ");
		for(int i=0; i<list2.size(); i++) {
			System.out.print(list2.get(i)+"  ");
		}
		System.out.println();
		System.out.print("향상된for문으로 출력: ");
		for(String str : list2) {
			System.out.print(str+"  ");
		}
		System.out.println();
		a();
		
		
		
		// contains(비교객체)
		// ==> 리스트에 저장된 데이터 중, '비교객체'가 있으면 true, 없으면 false 반환
		System.out.println("contains 사용하기");
		System.out.println("\"빵\"이 없기 때문에 "+list2.contains("빵"));
		System.out.println("\"AAAA\"가 있기 때문에 "+list2.contains("AAAA"));
		a();
		
		
		
		// indexOf(비교객체)
		// lastIndexOf(비교객체)
		// ==> 리스트에 '비교객체'를 찾아서 해당 '비교객체'가 있으면,
		//     '비교객체'가 저장된 index값을 반환하고, 없으면 -1을 반환한다.
		// ==> indexOf() 메소드는 검색 방향이 앞에서 뒤쪽 방향으로 검색.
		// ==> lastIndexOf() 메소드는 뒤에서 앞쪽 방향으로 검색.
		// ==> '비교객체'가 많으면 검색해서 첫번째로 찾아진 데이터의 index값을 반환한다.
		System.out.println("인덱스 찾기");
		System.out.println(list2);
		System.out.println("DDDD의 인덱스는 "+list2.indexOf("DDDD"));
		System.out.println("list2.get(3) 명령으로 3번 인덱스 출력해보기. 결과: "+list2.get(3));
		System.out.println("DDDD의 last 인덱스는 "+list2.lastIndexOf("DDDD"));
		System.out.println("list2.get(3) 명령으로 3번 인덱스 출력해보기. 결과: "+list2.get(3));
		a();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		System.out.println("lastIndexOf는 뒤에서 앞으로가 아니라, 제일 마지막꺼를 선택하는거고");
		System.out.println("없으면 -1을 말해주는거다");
		System.out.println("아 인덱스를 뒤에서 매기는게 아니라, ㅋㅋㅋ 당연하네!");
		a();
		ArrayList<String> listTest = new ArrayList<String>();
		listTest.add("AAAA");
		System.out.println("list2에 listTest 값 다 있으면: "+list2.containsAll(listTest));
		System.out.println("\"QWER\" 추가하기 "+listTest.add("QWER"));
		System.out.println("list2에 listTest 값 다 있지 않으면: "+list2.containsAll(listTest));
		a();
		// 인덱스 여러개 찾기 해보기
		ArrayList<String> tt = new ArrayList<String>();
		tt.add("AAAA");
		tt.add("BBBB");
		tt.add("AAAA");
		tt.add("BBBB");
		tt.add("AAAA");
		tt.add("BBBB");
		tt.add("AAAA");
		tt.add("BBBB");
		tt.add("AAAA");
		tt.add("BBBB");
		for(int i=0; i<tt.size(); i++) {
			System.out.println((i)+"번 값: "+tt.get(i));
		}
		System.out.println("1번째 AAAA의 인덱스는 "+tt.indexOf("AAAA"));
		tt.remove("AAAA");
		System.out.println("2번째 AAAA의 인덱스는 "+(tt.indexOf("AAAA")+1));
		tt.remove("AAAA");
		System.out.println("3번째 AAAA의 인덱스는 "+(tt.indexOf("AAAA")+2));
		tt.remove("AAAA");
		System.out.println("4번째 AAAA의 인덱스는 "+(tt.indexOf("AAAA")+3));
		tt.remove("AAAA");
		System.out.println("5번째 AAAA의 인덱스는 "+(tt.indexOf("AAAA")+4));
		System.out.println("이런식의 연산을 for문이랑 if문 쓰면 인덱스 다 빼올 수 있겠다");
		a();
		ArrayList<Object> getIndex = new ArrayList<Object>();
		while(true) {
			try {
				for(int i=0; i<tt.size(); i++) {
					getIndex.add(tt.indexOf("AAAA"));
				}
			} catch(Exception e) {
				break;
			}
		}
		
		
		
		// toArray()
		// ==> 리스트 안의 데이터를 배열로 변환해서 반환한다.
		// ==> 기본적으로 Object형 배열로 반환한다.
		// toArray(new 제네릭타입[0])
		// ==> 제네릭타입의 0칸의 배열을 만든다.
		// ==> 이렇게 하면 알아서 크기를 정해서 만들어준다. 딱 맞게 만들겠지?
		System.out.println(list2);
		Object[] strArr = list2.toArray();
//		String[] strArr2 = list2.toArray(); // 둘 다 안됨.
//		String[] strArr2 = (String[])list2.toArray(); // 배열은 형변환 불가능.
		// 배열 자체를 형변환 할 수 없다.
		// list2 가 애초에 ArrayList<String> 으로 만들어졌는대도 그렇다.
		System.out.println("List의 개수: "+list2.size());
		System.out.println("배열의 개수: "+strArr.length);
		for(int i=0; i<strArr.length; i++) {
			System.out.println(i+"번 배열 데이터 "+strArr[i]+" // "+i+"번 리스트 데이터 "+list2.get(i));
		}
		a();
		String[] strArr2 = list2.toArray(new String[0]);
		for(String str : strArr2) {
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void a() {
		System.out.println("------------------------------------------");
	}

}
