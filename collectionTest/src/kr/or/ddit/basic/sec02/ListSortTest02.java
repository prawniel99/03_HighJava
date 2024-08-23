package kr.or.ddit.basic.sec02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {
	
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-2222"));
		memList.add(new Member(9, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "강감찬", "010-4444-4444"));
		memList.add(new Member(6, "일지매", "010-5555-5555"));
		memList.add(new Member(2, "변학도", "010-6666-6666"));
		
		System.out.println("정렬 전");
		for(Member mem : memList) System.out.println(mem);
		System.out.println("------------------------------------------------");
		
		System.out.println("번호 오름차순 정렬");
		Collections.sort(memList);
		for(Member mem : memList) System.out.println(mem);
		System.out.println("------------------------------------------------");
		
		System.out.println("회원번호 내림차순 정렬");
		Collections.sort(memList, new SortNumDesc()); // 리스트 + 외부정렬 생성 객체
		for(Member mem : memList) {
			System.out.println("회원번호="+mem.getNum()+", 이름="+mem.getName()+", 전화번호="+mem.getTel());
//			System.out.println(mem);
		}
	}
}

//Member의 회원번호(변수 num)의 내림차순으로 정렬하는 외부 정렬 기준 클래스를 작성하시오.
//클래스명: SortNumDesc

class SortNumDesc implements Comparator<Member> {
//	private int num;
//	private String name;
//	private String tel;
//	
//	SortNumDesc(int num, String name, String tel) {
//		this.num = num;
//		this.name = name;
//		this.tel = tel;
//	}
	
//	public SortNumDesc() {
//		
//	}

	@Override
	public int compare(Member num1, Member num2) {
//		if(num1.getNum() > num2.getNum()) {
//			return -1;
//		} else if(num1.getNum() < num2.getNum()) {
//			return 1;
//		} else {
//			return 0;
//		}
		// Wrapper 클래스를 이용하는 내림차순 방법
//		return new Integer(num1.getNum()).compareTo(num2.getNum()) * -1;
		// 이건 오름차순
//		return new Integer(num1.getNum()).compareTo(num2.getNum());
		
		// Wrapper 클래스를 이용하는 내림차순 방법
//		return Integer.compare(num1.getNum(), num2.getNum()) * -1;
		// 이건 오름차순
		return Integer.compare(num1.getNum(), num2.getNum());
	}
	
}

// Member 클래스의 회원이름을 기준으로 오름차순이 되도록 내부 정렬 기준 추가하기
// ==> Comparable 인터페이스를 구현한다.
class Member implements Comparable<Member> {
	private int num;
	private String name;
	private String tel;
	
	// 생성자
	public Member(int num, String name, String tel) {
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	// getter, setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member " + num + ", name " + name + ", tel " + tel;
	}
	
	// 회원이름을 기준으로 오름차순
	@Override
	public int compareTo(Member mem) { // 자기자신과 매개변수를 비교하기 때문에 매개변수가 1개.
		// 이름 오름차순 01
//		if(this.getName().compareTo(mem.getName())>0) {
//			return 1;
//		} else if(this.getName().compareTo(mem.getName())<0 ) {
//			return -1;
//		} else {
//			return 0;
//		}
		
		// 이름 오름차순 02
//		return this.getName().compareTo(mem.getName()); // 간단하게 만들기
		
		// 회원번호 오름차순 01
//		if(this.getNum() > mem.getNum()) {
//			return 1;
//		} else if(this.getNum() < mem.getNum()) {
//			return -1;
//		} else {
//			return 0;
//		}
		
		// 회원번호 오름차순 02
		return this.getNum() - mem.getNum(); // 간단하게 만들기
	}
}


