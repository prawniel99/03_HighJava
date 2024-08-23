package kr.or.ddit.basic.sec04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
	
	public static void main(String[] args) {
		/*
		 *  Map ==> key 값과 value 값을 한 쌍으로 관리하는 객체
		 *  - key 값은 중복을 허용하지 않고 순서(index)가 없다. (Set의 특징을 갖는다)
		 *  - value 값은 중복을 허용한다.
		 */
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 ==> put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전시");
		map.put("tel", "010-1234-5678");
		
		// 순서가 없어서 막 들어갔는데, 뭐 부터 나오는걸까? 기준은 있을텐데 말야.
		System.out.println("map => "+map);
		
		// 자료 수정 ==> 데이터를 추가할 때 'key값'이 같으면 나중에 추가한 값이 저장된다.
		map.put("addr", "서울시");
		System.out.println("map => "+map);
		System.out.println();
		
		// 자료 삭제 ==> remove(key값) ==> 'key값'이 같은 자료를 찾아서 삭제한다.
		//                 ==> 반환값: 삭제된 자료의 'value'값'이 반환된다.
//		System.out.println(map.remove("tel")+" 삭제");
//		System.out.println("map => "+map);
//		
//		String removeaddr = map.remove("addr");
//		System.out.println(removeaddr);
//		System.out.println(map);
		
		// 자료 읽기 ==> get(key값) ==> 'key값'과 짝이되는 'value값'을 반환한다.
		System.out.println("이름 "+map.get("name"));
		System.out.println("번호 "+map.get("tel"));
		System.out.println("주소 "+map.get("addr"));
		System.out.println();
		
		// containsKey(key값) ==> key값이 존재하는지 여부를 나타내는 메소드
		//        ==> 해당 'key'값'이 있으면 true, 없으면 false 반환.
		System.out.println("tel 키값의 존재 여부: "+map.containsKey("tel"));
		System.out.println("tel 키값의 존재 여부: "+map.containsKey("age"));
		System.out.println();
		
		// Map에 저장된 모든 자료들을 차례로 사용하는 방법
		
		// 방법1) 모든 key값을 읽어와 처리하기 ==> keySet() 메소드 이용
		
		// keySet() 메소드 ==> Map의 모든 key값들을 읽어와 Set형으로 반환한다.
		Set<String> keySet = map.keySet();
		
		// 방법1-1) Iterator 이용하기
		System.out.println("print using Iterator");
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key+" : "+value);
		}
		System.out.println("-------------------------------");
		
		// 방법1-2) 향상된 for문 이용하기
		System.out.println("print using for");
		for(String key : keySet) {
			String value = map.get(key);
			System.out.println(key+" : "+value);
		}
		System.out.println("-------------------------------");
		
		// 방법2) value값만 읽어와서 처리하기
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("-------------------------------");
		
		/*
		 * 방법3) Map에는 Entry라는 내부 class가 만들어져 있다.
		 *        이 Entry class는 key와 value라는 멤버변수로 구성되어 있다.
		 *        Map에서는 이 Entry 클래스들을 Set 형식으로 저장하여 관리한다.
		 *        
		 * entrySet() 메소드 ==> Map에 저장된 Entry 객체 전체를 가져와 처리하기.
		 * ==> 가져온 Entry 객체들은 Set에 저장되어 반환된다.
		 */
		Set<Map.Entry<String, String>> mapEntrySet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> entryIt = mapEntrySet.iterator();
		
		while(entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next(); // Entry객체 한 개 가져오기
			System.out.println("key값: "+entry.getKey());
			System.out.println("value값: "+entry.getValue());
		}
		
		System.out.println(Map.Entry.comparingByKey());
		
		
		
		
		
		
		
		
		
		
		
		
		// 테스트
		System.out.println("테스트");
		test(map);
	}
	
	private static HashMap<String, String> test(HashMap<String, String> map) {
		System.out.println("\nkeySet으로 key 목록 출력");
		System.out.println(map.keySet());
		System.out.println();
		return map;
	}
}





















