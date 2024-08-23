package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTeacher {
	private Map<Integer, Room> hotelMap;
	private Scanner scan;
	
	public HotelTeacher() {
		hotelMap = new HashMap<Integer, Room>();
		scan = new Scanner(System.in);
		
//		hotelMap.put(201, new Room(201, "싱글룸");
		
		// 객실 초기화
		for(int i=2; i<=4; i++) {
			String roomType = null; // 방 종류가 저장될 변수 선언
			switch(i) {
				case 2:
					roomType = "싱글룸";
					break;
				case 3:
					roomType = "더블룸";
					break;
				case 4:
					roomType = "스위트룸";
					break;
				default:
					roomType = "예비룸";
			}
			for(int j=1; j<=9; j++) {
				int roomNumber = i*100+j;
				Room room = new Room(roomNumber, roomType);
				hotelMap.put(roomNumber, room);
			}
		}
	}
	
	public static void main(String[] args) {
		new HotelTeacher().hotelStart();
	}
	
	public void hotelStart() {
		System.out.println("*********************************************\n" +
	                       "       호텔문을 열었습니다. 어서오십시요.\r\n" + 
	                       "*********************************************\r\n");
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				displayAllRoom();
				break;
			case 4:
				System.out.println("*******************************");
				System.out.println(" 호텔 문을 닫습니다.");
				System.out.println("*******************************");
				System.exit(0);
				break;
			default:
				choice = displayMenu();
				System.out.println("다시 입력");
			}
		}			
	}
	
	private void checkOut() {
		System.out.println("----------------------------------------------\r\n" + 
				   		   "   체크아웃 작업\r\n" + 
				   		   "----------------------------------------------\r\n" + 
				   		   "방 번호 입력 >> ");
		int roomNum = scan.nextInt();
		
		// 입력한 방 번호가 없는지 확인
		if(!hotelMap.containsKey(roomNum)) {
			System.out.println(roomNum+"호 객실은 존재하지 않습니다.");
			return;
		}
		
		// 해당 객실의 손님 이름을 구해온다.
		String guestName = hotelMap.get(roomNum).getGuestName(); // hotelMap.get(roomNum) 이렇게 하면 이미 Room 객체가 됨. 오홍.
		
		// 해당 객실에 손님이 없는지 검사.
		if(guestName==null) {
			System.out.println(roomNum+"호 객실에는 체크인한 사람이 없습니다.");
			return;
		}
		
		// 체크아웃 처리
		hotelMap.get(roomNum).setGuestName(null);
		
		System.out.println(roomNum+"호 객실의 "+guestName+"님이 체크아웃 처리를 완료하였습니다.");
	}
	
	private void displayAllRoom() {
		System.out.println("----------------------------------------------\r\n" + 
						   "		현재 객실 상태\r\n" + 
						   "----------------------------------------------\r\n" + 
						   "방 번호	 방 종류	 투숙객 이름\r\n" + 
						   "----------------------------------------------\r\n" + 
						   "");
		
		Set<Integer> roomNumSet = hotelMap.keySet();
		List<Integer> roomNumList = new ArrayList<Integer>(roomNumSet);
		Collections.sort(roomNumList);
		
		for(int roomNum : roomNumList) {
			Room r = hotelMap.get(roomNum);
			System.out.print(r.getNum()+"\t");
			System.out.print(r.getType()+"\t");
			System.out.println(r.getGuestName()==null ? "-" : r.getGuestName()); // null이면 "-", 아니면 게스트명
		}
	}
	
	private void checkIn() {
		System.out.println("----------------------------------------------\r\n" + 
						   "   체크인 작업\r\n" + 
						   "----------------------------------------------\r\n" + 
						   " * 201~209 : 싱글룸\r\n" + 
						   " * 301~309 : 더블룸\r\n" + 
						   " * 401~409 : 스위트룸\r\n" + 
						   "----------------------------------------------\r\n" + 
						   "방 번호 입력 >> ");
		
		int num = scan.nextInt();
		
		// 입력한 방 번호가 없는지 확인
		if(!hotelMap.containsKey(num)) {
			System.out.println(num+"호 객실은 존재하지 않습니다.");
			return;
		}
		
		// 해당 객실에 다른 투숙객이 있는지 검사
		if(hotelMap.get(num).getGuestName()!=null) {
			System.out.println(num+"호 객실에는 이미 손님이 있습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름을 입력 >> ");
		String name = scan.next();
		
		// 입력 받은 이름을 해당 객실의 투숙객 이름에 저장한다
		hotelMap.get(num).setGuestName(name); // 이렇게도 되네..
		
		System.out.println(num+"호 객실에 "+name+"님이 체크인을 완료하였습니다.");
	}
	
	private int displayMenu() {
		System.out.print("-----------------------------------------------------------\n" +
					       "어떤 업무를 하시겠습니까?\n" +
						   "1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료\n" +
						   "-----------------------------------------------------------\n" +
						   "선택 >> ");
		return scan.nextInt();
	}
}

class Room {
	private int num;
	private String type;
	private String guestName;
	
	// 기본생성자
	public Room() { }
	
	// 생성자
	public Room(int num, String type) {
		this.num = num;
		this.type = type;
	}
	
	// getter, setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	
	
}