package kr.or.ddit.basic.sec04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/*
 *  문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone 클래스를 만들고
 *        Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 *        
 *        (Map의 구조 ==> key값으로는 '이름'을 사용하고,
 *                        value값으로는 'phone 객체의 인스턴스'를 사용한다.)
 *        
 *        HashMap<String, Phone> 변수; 이렇게 하면 됨
 *        
 *        아래의 실행 예시의 메뉴를 모두 구현하시오.
 *        (삭제, 검색 기능은 '이름'을 입력 받아서 처리한다.)
 *        
 *        실행예시)
 *        ----------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        -----------------------
 *        번호 입력 >> 1
 *        
 *        새롭게 등록할 전화번호 정보를 입력하세요.
 *        이름 >> 홍길동
 *        전화번호 >> 010-1111-1111
 *        주소 >> 시시시 구구구 동동동 11-11
 *        
 *        '홍길동' 전화번호 등록 완료.
 *        
 *        ----------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        -----------------------
 *        번호 입력 >> 1
 *        
 *        새롭게 등록할 전화번호 정보를 입력하세요.
 *        이름 >> 홍길동
 *        
 *        '홍길동'은 이미 등록된 사람입니다.
 *        
 *        ----------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        -----------------------
 *        번호 입력 >> 5
 *        
 *        -----------------------------------------------------------
 *        번호    이름     전화번호        주소
 *        -----------------------------------------------------------
 *        1       홍길동   010-1111-1111   시시시 구구구 동동동 11-11
 *        :
 *        :
 *        -----------------------------------------------------------
 *        
 *        ----------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        -----------------------
 *        번호 입력 >> 0
 *        
 *        프로그램을 종료합니다.
 *        
 */

public class PhoneBookTest {
	Scanner sc = new Scanner(System.in);
	Phone ph = new Phone();
	private HashMap<String, Phone> phoneBookMap;
	
	public static void main(String[] args) {
		new PhoneBookTest().start();
	}
	
	public void start() {
		while(true) {
//			int sel = sc.nextInt();
			int sel = 1;
			switch(sel) {
				case 1:
					noin();
					break;
				case 2:
					noed();
					break;
				case 3:
					nodl();
					break;
				case 4:
					nosr();
					break;
				case 5:
					nopr();
					break;
				case 0:
					System.exit(0);
					break;
				default:
					start();
			}
		}
	}
	
	public void noin() {
		// 이름, 주소, 번호 입력받기
		// <String, Phone> HashMap에 key를 이름, value에 이름,주소,번호 넣기
		// 만든 HashMap을 ph.setList 로 Phone 클래스 list에 담기?
		
		
		System.out.println("이름입력");
		String name = sc.next(); sc.nextLine();
//		String name = "홍길동";
		ph.setName(name);
		
		System.out.println("주소입력");
		String addr = sc.nextLine();
//		String addr = "시시시동동동";
		ph.setAddr(addr);
		
		System.out.println("번호입력");
		String tel = sc.nextLine();
//		String tel = "010-1111-1111";
		ph.setTel(tel);
		phoneBookMap = new HashMap<String, Phone>();
		phoneBookMap.put(name, ph);
		
		System.out.println("첫번째 사람 데려오기");
		System.out.println(ph.getName()+ph.getAddr()+ph.getTel());
		
		System.out.println("key 다 가져오기");
		System.out.println(phoneBookMap.keySet());
		
		System.out.println("이름입력");
		String name2 = sc.nextLine();
//		String name2 = "김유신";
		ph.setName(name2);
		
		System.out.println("주소입력");
		String addr2 = sc.nextLine();
//		String addr2 = "동시동시동시";
		ph.setAddr(addr2);
		
		System.out.println("번호입력");
		String tel2 = sc.nextLine();
//		String tel2 = "010-2222-2222";
		ph.setTel(tel2);
		
		phoneBookMap = new HashMap<String, Phone>();
//		phoneBookMap.put(name2, ph);
		
		System.out.println("두번째 사람 데려오기");
		System.out.println(ph.getName()+ph.getAddr()+ph.getTel());
		
		System.out.println("ph 바꾼 후 첫번째 사람 데려오기");
//		ph = phoneBookMap.get(name);
//		System.out.println(ph.getName()+ph.getAddr()+ph.getTel());
		
		System.out.println("key 다 가져오기");
		System.out.println(phoneBookMap.keySet());
		
		System.out.println(ph.getList());
		
		System.exit(0);
	}
	
	public void noed() {
		
	}
	
	public void nodl() {
		
	}
	
	public void nosr() {
		
	}
	
	public void nopr() {
		
	}
}

class Phone {
	private String name;
	private String addr;
	private String tel;
	private ArrayList<String> list = new ArrayList<String>();
	
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.list.add(name);
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
		this.list.add(addr);
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
		this.list.add(tel);
	}
	
	
}