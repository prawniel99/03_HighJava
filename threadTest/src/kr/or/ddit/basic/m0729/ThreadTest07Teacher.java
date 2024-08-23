package kr.or.ddit.basic.m0729;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 * 
 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
 * 사용자의 가위 바위 보는 showInputDiaolg()를 이용하여 입력받는다.
 * 
 * 입력 시간 5초로 제한하고, 카운트 다운을 진행한다.
 * 5초 안에 입력이 없으면 게임에 진것으로 처리.
 * 
 * 5초 안에 입력이 완료되면 컴퓨터와 사용자 사이의 승패를 구해서 출력한다.
 * 
 * 결과 예시)
 * 1) 5초 안에 입력 실패시
 *    -- 결 과 --
 *    시간초과로 당신이 졌습니다
 *    
 * 2) 
 */
public class ThreadTest07Teacher {
	public static boolean inputCheck;

	public static void main(String[] args) {
		GameCountDown gc = new GameCountDown();
		
		// 난수를 이용해서 컴퓨터의 가위 바위 보 정하기
		String[] data = {"가위", "바위", "보"};
		int index = (int)(Math.random()*3); // 0~2 사이의 난수 만들기
		String com = data[index];
		
		// 사용자의 가위 바위 보 입력 받기
//		gc.start();
//		String man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요");
//		inputCheck = true;
		gc.start();
		String man = null;
		do {
			man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요");
		} while(!("가위".equals(man) || "바위".equals(man) || "보".equals(man)));
		
		inputCheck = true;
		
		
		// 결과 판정하기
		String result = ""; // 판정 결과가 저장될 변수 선언
		
		if(com.equals(man)) {
			result = "비겼습니다";
		} else if(com.equals("가위") && man.equals("바위") ||
		          com.equals("바위") && man.equals("보") ||
				  com.equals("보") && man.equals("가위")) {
			result = "당신이 이겼습니다";
		} else {
			result = "당신이 졌습니다";
		}
		// 결과 출력
		System.out.println("  - - 결과 - -");
		System.out.println("컴퓨터: "+com);
		System.out.println("사용자: "+man);
		System.out.println("결과: "+result);
		
	}
}


class GameCountDown extends Thread {
	@Override
	public void run() {
		System.out.println("카운트 다운 시작");

		for (int i=5; i>=1; i--) {

			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if(ThreadTest07Teacher.inputCheck==true) {
				return;
			}
		}
		System.out.println("  - - 결과 - -");
		System.out.println("시간 초과로 당신이 졌습니다");
		System.exit(0);
	}
}
