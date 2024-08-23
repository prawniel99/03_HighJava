package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

public class BoardController {
	private IBoardService service;		// Service객체가 저장될 변수 선언
	private Scanner scan;
	
	// 생성자
	public BoardController() {
		service = BoardServiceImpl.getInstance();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new BoardController().boardStart();
	}
	
	public void boardStart() {
		String title = null;
		int choice = -1;
		while(true) {
			if(choice!=3) title = null;
			
			choice = displayMenu(title);
			
			switch(choice) {
				case 1: 		// 새글작성
					insertBoard(); break;
				case 2: 		// 게시글 보기
					viewBoard(); break;
				case 3: 		// 검색
					title = searchBoard(); break;
				case 0: 		// 작업 끝.
					System.out.println("게시판 프로그램 종료....");
					return;
				default : System.out.println("작업 번호를 잘못 입력했습니다. 다시 입력하세요...");
			}
		}
		
	}
	
	// 검색할 단어 입력하여 반환하는 메서드
	private String searchBoard() {
		scan.nextLine();  // 입력 버퍼 비우기
		System.out.println();
		System.out.println("검색 작업");
		System.out.println("--------------------------------------------");
		System.out.print("- 검색할 제목 입력 : ");
		return scan.nextLine();
	}
	
	
	// 게시글 보기
	private void viewBoard() {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력 >> ");
		int num = scan.nextInt();
		
		BoardVO boardVo = service.getBoard(num);
		
		// 입력한 게시글 번호에 자료가 없을 때... 
		if(boardVo==null) {
			System.out.println(num + "번의 게시글은 존재하지 않습니다...");
			return;
		}
		
		System.out.println();
		System.out.println(num + "번 게시글");
		System.out.println("-----------------------------------------------------");
		System.out.println("- 제 목 : " + boardVo.getBoard_title());
		System.out.println("- 작성자 : " + boardVo.getBoard_writer());
		System.out.println("- 내 용 : " + boardVo.getBoard_content());
		System.out.println("- 작성일 : " + boardVo.getBoard_date());
		System.out.println("- 조회수 : " + boardVo.getBoard_cnt());
		System.out.println("-----------------------------------------------------");
		System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		System.out.print("작업 선택 >> ");
		int choice = scan.nextInt();
		
		switch(choice) {
			case 1:			// 수정
				updateBoard(num); break;
			case 2:			// 삭제
				deleteBoard(num); break;
			case 3:			// 리스트로 가기
				return;
			
		}
		
	}
	
	// 삭제 작업
	private void deleteBoard(int boardNo) {
		int cnt = service.deleteBoard(boardNo);
		
		if(cnt>0) {
			System.out.println(boardNo + "번 글이 삭제되었습니다...");
		}else {
			System.out.println(boardNo + "번 글의 삭제 작업 실패!!!");
		}
		
	}
	
	// 수정 작업
	private void updateBoard(int boardNo) {
		System.out.println();
		scan.nextLine(); // 입력 버퍼 비우기
		
		System.out.println("수정 작업하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제 목 : ");
		String title = scan.nextLine();
		
		System.out.print("- 내 용 : ");
		String content = scan.nextLine();
		
		// 수정할 자료를 VO객체에 저장한다.
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_content(content);
		bvo.setBoard_no(boardNo);
		
		int cnt = service.updateBoard(bvo);
		
		if(cnt>0) {
			System.out.println(boardNo + "번 글이 수정되었습니다...");
		}else {
			System.out.println(boardNo + "번 글 수정 작업 실패!!!");
		}
				
	}
	
	
	
	// 새 글 작성
	private void insertBoard() {
		System.out.println();
		System.out.println("새글 작성하기"); 
		System.out.println("-----------------------------------");
		
		scan.nextLine(); // 입력 버퍼 비우기
		
		System.out.print("- 제 목 >> ");
		String title = scan.nextLine();
		
		System.out.print("- 작성자 >> ");
		String name = scan.nextLine();
		
		System.out.print("- 내 용 >> ");
		String content = scan.nextLine();
		
		// 입력 받은 자료를 VO객체에 저장한다.
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_writer(name);
		bvo.setBoard_content(content);
		
		int cnt = service.insertBoard(bvo);
		
		if(cnt>0) {
			System.out.println("새 글이 추가되었습니다.");
		}else {
			System.out.println("새 글 추가 실패!!!");
		}
		
		
	}
	
	
	private int displayMenu(String title) {
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println(" No	        제 목                 작성자       	     조회수 ");
		System.out.println("--------------------------------------------------");
		
		List<BoardVO> boardList = null;
		if(title==null) {
			boardList =	service.getAllBoard();
		}else {
			boardList = service.getSearchBoard(title);
		}
		
		if(boardList==null || boardList.size()==0) {
			System.out.println("\t출력할 게시글이 하나도 없습니다...");
		}else {
			for(BoardVO bvo : boardList) {
				System.out.println(bvo.getBoard_no() + "\t" + bvo.getBoard_title() + "\t"
						+ bvo.getBoard_writer() + "\t" + bvo.getBoard_cnt());
			}
		}
		System.out.println("--------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업 선택 >> ");
		return scan.nextInt();
	}
	
	
	

}
