package kr.or.ddit.basic.sec02;

import java.util.Stack;

public class StackTest {
	
	public static void main(String[] args) {
		StackTest obj = new StackTest();
		obj.process();
	}
	
	private void process() {
		Browser b = new Browser();
		
		b.history();
		
		b.goURL("1.네이버");
		b.history();
		
		b.goURL("2.야후");
		b.history();
		
		b.goURL("3.구글");
		b.history();
		
		b.goURL("4.다음");
		b.history();
		
		System.out.println("뒤로가기");
		b.goBack();
		b.history();

		System.out.println("뒤로가기");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기");
		b.goBack();
		b.history();
		
		System.out.println("앞으로 가기");
		b.goForward();
		b.history();
		
		System.out.println("앞으로 가기");
		b.goForward();
		b.history();
		
		System.out.println("앞으로 가기");
		b.goForward();
		b.history();
		
		System.out.println("새로운 사이트 가기");
		b.goURL("5.네이트");
		b.history();
		
		System.out.println("뒤로가기");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기");
		b.goBack();
		b.history();
		
		System.out.println("새로운 사이트 가기");
		b.goURL("6.퀘이사존");
		b.history();
		
		System.out.println("뒤로가기");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기");
		b.goBack();
		b.history();
		
		System.out.println("앞으로 가기");
		b.goForward();
		b.history();
		
		System.out.println("앞으로 가기");
		b.goForward();
		b.history();
		
	}
}

// 웹브라우저의 뒤로가기, 앞으로가기 구현 (Stack 이용)
class Browser {
	
	private Stack<String> back;		// 이전 방문 내역이 저장될 스택
	private Stack<String> forward;	// 다음 방문 내역이 저장될 스택
	private String currentURL;		// 현재 페이지
	
	// 생성자
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL = "";
	}
	
	// 사이트를 방문하는 메소드 ==> 매개변수에는 방문할 URL이 저장되어 호출된다.
	public void goURL(String url) {
		System.out.println(url+"사이트에 접속합니다");
		if(currentURL!=null && !"".equals(currentURL)) { // 현재 페이지가 있으면,
			back.push(currentURL); // 현재 페이지를 back 스택에 추가한다.
		}
		currentURL = url; // 현재 페이지를 변경한다.
		forward.clear();
	}
	
	// 뒤로가기
	public void goBack() {
		// isEmpty() ==> Collection이 비어 있으면 true를 반환한다.
		if(!back.isEmpty()) {
			forward.push(currentURL);	// 현재 페이지를 forward 스택에 추가한다.
			currentURL = back.pop();	// back에서 1개의 요소를 꺼내와 현재 페이지로 한다.
		}
	}
	
	// 앞으로가기
	public void goForward() {
		if(!forward.isEmpty()) {
			back.push(currentURL);
			currentURL = forward.pop();
		}
	}
	
	// 방문 기록 확인하기
	public void history() {
		System.out.println("------------------");
		System.out.println("  방 문 기 록  ");
		System.out.println("------------------");
		System.out.println("back ==> "+back);
		System.out.println("현재 ==> "+currentURL);
		System.out.println("forward ==> "+forward);
		System.out.println("------------------");
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
}