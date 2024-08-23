package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/*
 *  호텔 객실 관리 프로그램
 *  
 *  문제) 호텔 객실을 관리하는 프로그램을 작성하시오.

   조건1)  호텔 객식을 나타내는 Room클래스는 방번호(int), 방종류, 투숙객이름 필드로 구성되어 있고			     
           방번호와 방종류는 다음과 같다.
           - 201~209 : 싱글룸
           - 301~309 : 더블룸
           - 401~409 : 스위트룸

   조건2) 전체 객실 관리는 Map을 이용한다.
          (Map의 key값은 방번호로 하고 value값은 Room의 인스턴스로 한다.)
          생성자에서는 방번호와 방종류를 초기화한다.
 */

public class Hotel {
	HashMap<Integer, Rooms> hotel = new HashMap<Integer, Rooms>();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Hotel().start();
	}
	
	public void start() {
		hotelInitial();
		hotelMenu();
	}

	private void hotelMenu() {
		System.out.println("1. 체크인\t2. 체크아웃\t3. 객실상태\t4. 업무종료");
		int sel = sc.nextInt();
		switch(sel) {
			case 1:
				hotelCheckin();
				break;
			case 2:
				hotelCheckout();
				break;
			case 3:
				hotelList();
				break;
			case 4:
				hotelExit();
				break;
			default:
				hotelMenu();
		}
	}

	private void hotelExit() {
		for(int i=0; i<5; i++) System.out.println();
		System.out.println("프로그램 종료");
		System.exit(0);
	}

	private void hotelCheckout() {
		System.out.println("체크아웃 방번호 선택");
		int getRoom = sc.nextInt();
		sc.nextLine();
		if(getRoom>200 && getRoom<210) {
			hotel.replace(getRoom, new Rooms(getRoom, "싱글", "-"));
		} else if(getRoom>300 && getRoom<310) {
			hotel.replace(getRoom, new Rooms(getRoom, "더블", "-"));
		} else if(getRoom>400 && getRoom<410) {
			hotel.replace(getRoom, new Rooms(getRoom, "스위트", "-"));
		}
		System.out.println("체크아웃 완료");
		hotelMenu();
	}

	private void hotelCheckin() {
		System.out.println("201~209 싱글\n301~309 더블\n401~409 스위트");
		System.out.println("방번호 선택");
		int getRoom = sc.nextInt();
		if(getRoom<201 || getRoom>209 && getRoom<301 || getRoom>309 && getRoom<401 || getRoom>409) {
			System.out.println(getRoom+"은 없는 번호입니다");
			hotelCheckin();
		}
		Rooms r = hotel.get(getRoom);
		if(!r.getGuestName().equals("-")) {
			System.out.println(getRoom+"호는 이미 사용중입니다");
			hotelCheckin();
		}
		sc.nextLine();
		System.out.println("이름 입력");
		String guestName = sc.nextLine();
		if(getRoom>200 && getRoom<210) {
			hotel.replace(getRoom, new Rooms(getRoom, "싱글", guestName));
		} else if(getRoom>300 && getRoom<310) {
			hotel.replace(getRoom, new Rooms(getRoom, "더블", guestName));
		} else if(getRoom>400 && getRoom<410) {
			hotel.replace(getRoom, new Rooms(getRoom, "스위트", guestName));
		}
		System.out.println("체크인 완료");
		hotelMenu();
	}

	private void hotelInitial() {
		for(int i=0; i<9; i++) {
			hotel.put(201+i, new Rooms((201+i), "싱글", "-"));
			hotel.put(301+i, new Rooms((301+i), "더블", "-"));
			hotel.put(401+i, new Rooms((401+i), "스위트", "-"));
		}
	}
	
	private void hotelList() {
		System.out.println("-------------------------");
		System.out.println("     현재 객실 상태      ");
		System.out.println("-------------------------");
		System.out.println("방번호\t방종류\t투숙객이름");
		ArrayList<Integer> roomno = new ArrayList<Integer>(hotel.keySet());
		Collections.sort(roomno);
		for(int room : roomno) {
			Rooms r = hotel.get(room);
			if(room-(room/100)*100==1) System.out.println("-------------------------");
			System.out.println(r.getRno()+"\t"+r.getRtype()+"\t"+r.getGuestName());
		}
		hotelMenu();
	}
}

class Rooms {
	private int rno;
	private String rtype;
	private String guestName;
	
	public Rooms(int rno, String rtype, String rguest) {
		this.rno = rno;
		this.rtype = rtype;
		this.guestName = rguest;
	}
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String rcust) {
		this.guestName = rcust;
	}
	
}