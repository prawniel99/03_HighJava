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

public class ThreadTest07 {
	public static void main(String[] args) {
		// 1가위 2바위 3보
		comRSP th1 = new comRSP();
		countDownFive th2 = new countDownFive();
		th1.start();
		th2.start();
	}
}

class countDownFive extends Thread {
	
	@Override
	public void run() {
		System.out.println("카운트다운");
		for(int i=5; i>=2; i--) {
			System.out.println(i);
			if(i==2) {
				try {
					Thread.sleep(1000);
					System.out.println(i-1);
					Thread.sleep(100);
				} catch (Exception e) {

				}
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
			}
			if(DataInput.inputCheck==true) {
				return; // run() 메소드가 종료되면 해당 쓰레드도 종료된다.
			}
		}
		for(int j=9; j>=0; j--) {
			System.out.println("0."+j);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
			if(DataInput.inputCheck==true) {
				return; // run() 메소드가 종료되면 해당 쓰레드도 종료된다.
			}
		}
		

		System.out.println("땡 시간초과");
		System.exit(0);
	}
}

class comRSP extends Thread {
	public static boolean inputCheck = false;
	private String player;
	private String com;
	
	@Override
	public void run() {
		player = JOptionPane.showInputDialog("가위 바위 보");
		inputCheck = true;
		int comChoice = (int)(Math.random()*3)+1;
		if(comChoice==1) com="가위";
		if(comChoice==2) com="바위";
		if(comChoice==3) com="보";
		System.out.println("컴퓨터 "+com+" vs "+player+" 플레이어");
		
		int playerChoice = 0;
		if(player.equals("가위")) playerChoice = 1;
		else if(player.equals("바위")) playerChoice = 2;
		else if(player.equals("보")) playerChoice = 3;
		System.out.println();
		
		if(playerChoice==0) {
			System.out.println("잘못내서 졌습니다");
			System.exit(0);
		}
		if(comChoice==playerChoice) System.out.println("비겼습니다");
		else if(comChoice-playerChoice==-1 || comChoice-playerChoice==2) System.out.println("승리했습니다");
		else if(comChoice-playerChoice==-2 || comChoice-playerChoice==1) System.out.println("패배했습니다");
		
		System.exit(0);
	}
}