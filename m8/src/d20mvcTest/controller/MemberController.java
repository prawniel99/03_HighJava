package d20mvcTest.controller;

import java.util.Scanner;

import d20mvcTest.service.IMemberService;
import d20mvcTest.service.MemberServiceImpl;
import d20mvcTest.vo.MemberVO;

public class MemberController {
    private IMemberService service; // Service 객체가 저장될 변수 선언
    private Scanner scan;

    public MemberController() {
//        service = new MemberServiceImpl();
    	service = MemberServiceImpl.getInstance();
        scan = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new MemberController().startMember();
    }

    // 시작 메서드
	public void startMember() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1 :			// 자료 추가
					insertMember(); break;
				case 2 :			// 자료 삭제
					// deleteMember();
                    System.out.println("삭제 미구현");
                    break;
				case 3 :			// 자료 수정 ==> 전체 항목 수정
					// updateMember();
                    System.out.println("수정 미구현");
                    break;
				case 4 :			// 전체 출력
					// displayAllMember();
                    System.out.println("전체 자료 출력 미구현");
                    break;
				case 5 :			// 자료 수정2 ==> 원하는 항목 1개만 수정
					// updateMember2();
                    System.out.println("수정2 미구현");
                    break;
				case 0 :	// 작업 끝...
					System.out.println("작업을 마칩니다...");
					return;
				default :
					System.out.println("작업 번호를 잘못 입력 했습니다.");
					System.out.println("다시 입력하세요...");
			}
		}
	}

    // insert 메소드
    private void insertMember() {
        System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요...");
		
		String memId = null;		// 회원ID가 저장될 변수
		int count = 0;

		do {
			
			System.out.print("회원ID 입력 >> ");
			memId = scan.next();
			
			count = service.getMemberIdCount(memId);
			
			if(count>0) {
				System.out.println(memId + "는(은) 이미 등록된 회원ID 입니다. ");
				System.out.println("다른 회원ID를 입력하세요...");
				System.out.println();
			}
			
		} while(count>0);
		
		System.out.print("비밀번호 입력 >> ");
		String memPass = scan.next();
		
		System.out.print("회원이름 입력 >> ");
		String memName = scan.next();
		
		System.out.print("전화번호 입력 >> ");
		String memTel = scan.next();
		
		scan.nextLine();   // 입력 버퍼 비우기
		System.out.print("회원주소 입력 >> ");
		String memAddr = scan.nextLine();
		
        // 입력받은 데이터들을 MemberVO객체에 저장한다.
        MemberVO memVo = new MemberVO();
        memVo.setMem_id(memId);
        memVo.setMem_pass(memPass);
        memVo.setMem_name(memName);
        memVo.setMem_tel(memTel);
        memVo.setMem_addr(memAddr);

        // Service의 insert하는 메소드를 호출한다.
        // 이 때 insert할 데이터가 저장된 MemberVO객체를 인수값으로 보내준다.
        int cnt = service.insertMember(memVo);

        if(cnt>0) {
            System.out.println("insert 작업 성공!!");
        } else {
            System.out.println("insert 작업 실패~~");
        }
    }

    // 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println(" == 작업 선택 ==");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("0. 작업 끝...");
		System.out.println("================");
		System.out.print("작업 선택 >> ");
		return scan.nextInt();
	}
}
