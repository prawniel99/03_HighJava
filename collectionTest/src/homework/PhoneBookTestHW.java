package homework;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTestHW {
	private HashMap<String, Phone> phonebookMap;
	private Scanner scan;
	
	// 생성자
	public PhoneBookTestHW() {
		phonebookMap = new HashMap<String, Phone>();
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new PhoneBookTestHW().phoneStart();
	}
	
	// 시작 메소드
	public void phoneStart() {
		System.out.println();
		System.out.println("전화번호 관리 프로그램");
		System.out.println();
		
		while(true) {
			int sel = displayMenu();
			switch(sel) {
				case 1:
					insert();
					break;
				case 2:
					update();
					break;
				case 3:
					delete();
					break;
				case 4:
					search();
					break;
				case 5:
					displayAll();
					break;
				case 0:
					System.exit(0);
					break;
				default:
					phoneStart();
			}
		}
	}
	
	private void search() {
		System.out.println();
		System.out.println("Search");
		
		System.out.println("Name");
		String name = scan.next();
		
//		if(!phonebookMap.containsKey(name)) {
//			System.out.println("No such name found");
//			return;
//		}
		
		Phone p = phonebookMap.get(name);
//		String s = phonebookMap.get(name);
		if(p==null) {
			System.out.println("No such name found");
			return;
		} else {
//			System.out.println(p);
			System.out.println("Name "+p.getName());
			System.out.println("Addr "+p.getAddr());
			System.out.println("Phone "+p.getTel());
		}
	}

	private void delete() {
		System.out.println();
		System.out.println("Delete Information");
		
		System.out.println("Name");
		String name = scan.next();
		
		if(!phonebookMap.containsKey(name)) {
			System.out.println("No such name found");
			return;
		}
		
		phonebookMap.remove(name);
		System.out.println("Deleted");
	}

	private void update() {
		System.out.println();
		System.out.println("Edit Information");
		
		System.out.print("Name ");
		String name = scan.next();
		
		// 해당 이름이 없으면 수정 작업을 못한다.
		if(!phonebookMap.containsKey(name)) {
			System.out.println("We don't have "+name+"'s information");
			System.out.println("Closing the request");
			return;
		}
		System.out.println("New Tel. No. >> ");
		String newTel = scan.next();
		
		System.out.println("New Address >> ");
		String newAddr = scan.next();
		
		// store a new information into the same key.  ==> update
		phonebookMap.put(name, new Phone(name, newTel, newAddr));
		
		System.out.println(name+"'s information updated");
	}

	// 전체 전화번호 정보를 출력하는 메소드
	private void displayAll() {
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("번호   이름    전화번호       주소");
		System.out.println("------------------------------------------------------------");
		
		// key 값들만 Set 형식으로 구현
		Set<String> phoneKeySet = phonebookMap.keySet();
		if(phoneKeySet.size()==0) {
			System.out.println("   정보 없음");
		} else {
			int count = 0;
			for(String key : phoneKeySet) {
				count++;
				Phone p = phonebookMap.get(key);
				
				System.out.println(count+"  "+p.getName()+"   "+p.getTel()+"   "+p.getAddr());
			}
		}
		System.out.println("------------------------------------------------------------");
	}

	private void insert() {
		System.out.println();
		System.out.println("Input New Information");
		
		System.out.println("Name ");
		String name = scan.next();
		
		if(phonebookMap.containsKey(name)) {
			System.out.println("Name already exists "+name);
			return;
		}
		
		System.out.println("Tel. ");
		String tel = scan.next();
		scan.nextLine();
		
		System.out.print("Addr. ");
		String addr = scan.nextLine();
		
//		// 입력 받은 자료를 이용하여 Phone객체 생성
//		Phone p = new Phone(name, tel, addr);
//		
//		// Map에 추가하기
//		phonebookMap.put(name, p);
		
		// 위 두개 간단하게 하기
		
		phonebookMap.put(name, new Phone(name, tel, addr));
		
		System.out.println(name+" Inserted");
		
	}

	// 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메소드
	private int displayMenu() {
		System.out.println();
		System.out.println("----------------------\r\n" + 
						   " 1. 전화번호 등록\r\n" + 
						   " 2. 전화번호 수정\r\n" + 
						   " 3. 전화번호 삭제\r\n" + 
						   " 4. 전화번호 검색\r\n" + 
						   " 5. 전화번호 전체 출력\r\n" + 
						   " 0. 프로그램 종료\r\n" + 
						   "-----------------------");
		return scan.nextInt();
	}
	
}

class Phone {
	private String name;
	private String tel;
	private String addr;
	
	public Phone(String name2, String tel2, String addr2) {
		this.name = name2;
		this.tel = tel2;
		this.addr = addr2;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}