package m8.d06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
	문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고,
		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
		
		(Map의 구조 ==> key값으로는 '이름'을 사용하고,
					value값으로는 'Phone객체의 인스턴스'를 사용한다.)
					
		HashMap<String, Phone> 변수 ;			

		아래의 실행 예시의 메뉴를 모두 구현하시오.
		( 삭제, 검색 기능은 '이름'을 입력 받아서 처리한다.)
	
	- 추가 조건)
	1) '6. 전화번호 저장' 메뉴를 추가하고 기능을 구현한다.
		(저장 파일명 : 'phoneData.dat' )
	2) 프로그램이 시작될 때 저장된 파일이 있으면 그 데이터를 읽어와 Map에 셋팅한다.
		
	3) 프로그램을 종료할 때 Map의 데이터가 추가, 수정, 삭제와 같이 변경되었을 경우에는
	   	저장 후 종료되도록 한다. 	
		
	실행예시)
	------------------------
	 1. 전화번호 등록
	 2. 전화번호 수정
	 3. 전화번호 삭제
	 4. 전화번호 검색
	 5. 전화번호 전체 출력
	 0. 프로그램 종료
	------------------------
	번호 입력 >> 1
	
	새롭게 등록할 전화번호 정보를 입력하세요...
	이 름 >> 홍길동
	전화번호 >> 010-1111-1111
	주 소 >> 대전시 중구 오류동
	
	'홍길동' 전화번호 등록 완료!!!

	------------------------
	 1. 전화번호 등록
	 2. 전화번호 수정
	 3. 전화번호 삭제
	 4. 전화번호 검색
	 5. 전화번호 전체 출력
	 0. 프로그램 종료
	------------------------
	번호 입력 >> 1
		
	새롭게 등록할 전화번호 정보를 입력하세요...
	이 름 >> 홍길동 	

	'홍길동'은 이미 등록된 사람입니다...
		
	------------------------
	 1. 전화번호 등록
	 2. 전화번호 수정
	 3. 전화번호 삭제
	 4. 전화번호 검색
	 5. 전화번호 전체 출력
	 0. 프로그램 종료
	------------------------
	번호 입력 >> 5
	
	------------------------------------
	번호       이 름            전화번호           주소
	------------------------------------
	 1       홍길동     010-1111-1111   대전시 중구 오류동
	 ~~~
	 ~~~
	------------------------------------

	------------------------
	 1. 전화번호 등록
	 2. 전화번호 수정
	 3. 전화번호 삭제
	 4. 전화번호 검색
	 5. 전화번호 전체 출력
	 0. 프로그램 종료
	------------------------
	번호 입력 >> 0
	
	프로그램을 종료합니다...
		 
	 
	 
*/
public class N04_PhoneBookTest {
	
	private HashMap<String, Phone> phonebookMap; 
	private Scanner scan;
	private String fileName = "d:/d_other/phoneData.dat";
	private boolean dataChange; // 데이터가 변경되면 true로 바뀐다.
	
	
	// 생성자
	public N04_PhoneBookTest() {
		phonebookMap = load(); 
		if(phonebookMap==null) {		
			phonebookMap = new HashMap<String, Phone>();
		}
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new N04_PhoneBookTest().phoneStart();
	}
	
	// 시작 메서드
	public void phoneStart() {
		System.out.println();
		System.out.println("******************************");
		System.out.println("    전 화 번 호 관 리 프 로 그 램");
		System.out.println("******************************");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1 :			// 등록
					insert();	break;
				case 2 :			// 수정
					update();	break;
				case 3 :			// 삭제
					delete();	break;
				case 4 :			// 검색
					search();	break;
				case 5 :			// 전체 출력
					displayAll();	break;
				case 6 :			// 저장
					save();		break;
				case 0 :			// 종료

					if(dataChange==true) { // 데이터가 변경되었는지 여부 검사
						save();
					}
				
					System.out.println();
					System.out.println("프로그램을 종료합니다...");
					return;
				default :
					System.out.println();
					System.out.println("작업 번호를 잘못 입력했습니다.");
					System.out.println("다시 선택하세요...");
					
			}
		}
	}
	
	// 저장된 전화번호 정보를 읽어오는 메서드
	private HashMap<String, Phone> load(){
		HashMap<String, Phone> pMap = null; // 읽어온 데이터가 저장된 Map객체 선언
		
		File file = new File(fileName);
		if(!file.exists()) {  // 저장된 파일이 없으면...
			return null;
		}
		
		// 저장된 데이터 읽어오기
		ObjectInputStream oin = null;
		try {
			// 객체 입력용 스트림 객체 생성
			oin = new ObjectInputStream(new FileInputStream(file));
			
			// save()메서드에서 '방법1'로 저장했을 때 읽어오는 방법
			// pMap = (HashMap<String, Phone>) oin.readObject();
			// ------------------------------------------------

			// save() 메소드에서 '방법2'로 저장했을때 읽어오는 방법
			pMap = new HashMap<String, Phone>();
			Object obj = null;
			while((obj=oin.readObject())!=null) {
				Phone p = (Phone)obj;
				pMap.put(p.getName(), p);
			}
			
			// ------------------------------------------------
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(oin!=null) try { oin.close(); }catch(IOException e) {}
		}
		
		return pMap;
		
		
	}
	
	
	// 전화번호 정보를 저장하는 메서드
	private void save() {
		ObjectOutputStream oout = null;
		try {
			// 객체 출력용 스트림 객체 생성
			oout = new ObjectOutputStream(new FileOutputStream(fileName));
			
			// Map에 저장된 데이터를 파일에 출력한다.
			
			// 방법1) Map자체를 저장하는 방법
			// oout.writeObject(phonebookMap);
			
			// 방법2) Map의 value만 저장하는 방법
			for(String name : phonebookMap.keySet()) {
				Phone p = phonebookMap.get(name); // 하나의 Phone객체 구하기
				oout.writeObject(p);
			}
			oout.writeObject(null);
			dataChange = false;
			
			System.out.println("저장이 완료 되었습니다...");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oout!=null) try { oout.close(); } catch(IOException e) {}
		}
	}
	
	
	// 전화번호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요...");
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		Phone p = phonebookMap.get(name);
		
		if(p==null) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다...");
		}else {
			System.out.println(name + "씨의 전화번호 정보");
			System.out.println("=========================");
			System.out.println(" 이 름 : " + p.getName());
			System.out.println(" 전 화 : " + p.getTel());
			System.out.println(" 주 소 : " + p.getAddr());
			System.out.println("=========================");
		}
		
	}
	
	
	// 전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요...");
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 존재 여부 검사
		if(!phonebookMap.containsKey(name)) {
			System.out.println(name + "씨는 등록되지 않은 사람입니다...");
			return;
		}
		
		phonebookMap.remove(name);

		dataChange = true;
		
		System.out.println(name + "씨의 전화번호 정보를 삭제했습니다...");
	}
	
	
	// 전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력 하세요...");
		
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 해당 이름이 없으면 수정 작업을 못한다.
		if(!phonebookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다...");
			System.out.println("수정 작업을 마칩니다...");
			return;
		}
		
		System.out.print("새로운 전화번호 >> ");
		String newTel = scan.next();
		
		scan.nextLine(); // 버퍼 비우기
		
		System.out.print("새로운 주소 >> ");
//		String newAddr = scan.next();
		String newAddr = scan.nextLine();
		
		// 같은 key값에 새로운 전화번호 정보를 저장한다.  ==> 수정
		phonebookMap.put(name, new Phone(name, newTel, newAddr));

		dataChange = true;
		
		System.out.println(name + "씨의 전화번호 정보를 변경했습니다...");
	}
	
	// 전체 전화번호 정보를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println(" 번호     이  름      전 화 번 호         주      소");
		System.out.println("--------------------------------------");
		
		// key값들만 Set형식으로 구한다.
		Set<String> phoneKeySet = phonebookMap.keySet();
		
		if(phoneKeySet.size() == 0) {
			System.out.println("   등록된 전화번호 정보가 하나도 없습니다...");
		}else {
			int count = 0; 	// 번호 출력용
			for(String key : phoneKeySet) {
				count++;
				Phone p = phonebookMap.get(key);	// value값(Phone객체) 구하기
				
				System.out.println(count + "\t" + p.getName() + "\t" 
								+ p.getTel() + "\t" + p.getAddr());
			}
		}
		System.out.println("--------------------------------------");
		
		
	}
	
	
	// 전화번호 정보를 등록하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요...");
		
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 이미 등록된 사람인지 검사하기 (key값에 해당 이름이 있는지 검사)
		if(phonebookMap.containsKey(name)) {
			System.out.println(name + "씨는 이미 등록된 사람입니다...");
			return;
		}
		
		System.out.print("전화번호 >> ");
		String tel = scan.next();
		
		scan.nextLine();  // 입력 버퍼 비우기
		
		System.out.print("주 소 >> ");
		//String addr = scan.next();
		String addr = scan.nextLine();
		
		// 입력 받은 자료를 이용하여 Phone객체 생성
//		Phone p = new Phone(name, tel, addr);
//		// Map에 추가하기
//		phonebookMap.put(name, p);
		
		phonebookMap.put(name, new Phone(name, tel, addr));
		dataChange = true;
		System.out.println(name + "씨 전화번호 정보 등록 완료!!!");
	}
	
	
	// 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("------------------------");
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체 출력");
		System.out.println(" 6. 전화번호 저장");
		System.out.println(" 0. 프로그램 종료");
		System.out.println("------------------------");
		System.out.print(" 작업 번호 >> ");
		return scan.nextInt();
	}
	
	
	

}

// 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스
class Phone implements Serializable{
	private String name;
	private String tel;
	private String addr;
	
	// 생성자
	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	// getter, setter
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

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
	
}








