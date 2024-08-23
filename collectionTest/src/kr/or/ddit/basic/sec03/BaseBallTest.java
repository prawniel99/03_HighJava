package kr.or.ddit.basic.sec03;

/*
 *  Set을 이용하여 숫자 야구 게임 프로그램 만들기
 *  1~9 3개를 선택한다
 *  서로 숫자 맞추기
 *  
 *     숫자 3개를 정한다.
 *     위치가 똑같고 숫자가 똑같다 = 스트라이크 S
 *     위치가 다르고 숫자가 똑같다 = 볼 B
 *  
 *  이런 방식으로 최종 숫자 맞추기
 *  
 *  컴퓨터가 숫자 3개를 만들고,
 *  플레이어가 맞추기
 */

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseBallTest {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		BaseBallTest obj = new BaseBallTest();
		obj.process();
	}
	
	public void process() {
		gameMain();
	}

	public void gameMain() {
		while(true) {
			for(int i=0; i<20; i++) System.out.println();
			System.out.println("--------------------------------------");
			System.out.println("            플레이볼");
			System.out.println("--------------------------------------");
			
			// 1. 3개 번호 만들기
			HashSet<Integer> baseball = new HashSet<Integer>();
			while(baseball.size()<3) {
				baseball.add((int)(Math.random()*9)+1);
			}
//			System.out.println(baseball);
			ArrayList<Integer> list = new ArrayList<Integer>(baseball);
			
			// 2. 번호 섞기
			for(int i=0; i<33; i++) {
				int ran = (int)(Math.random()*3);
				int temp = list.get(0);
				list.set(0, list.get(ran));
				list.set(ran, temp);
			}
			
			int cnt = 0;
			int gcnt = 0;
			while(true) {
				// 3. 플레이어 선택
				ArrayList<Integer> player = new ArrayList<Integer>();
				System.out.println("1~9 번호 3개 입력. 횟수"+cnt);
				while(player.size()<3) {
					try {
						int pIn = sc.nextInt();
						if(pIn<=9 && pIn>=1) {
							player.add(sc.nextInt());
						}
					} catch(Exception e) {
						System.out.println("오류");
					}
				}
				
				// 번호출력
//			System.out.println("컴퓨터 "+list.get(0)+list.get(1)+list.get(2));
//			System.out.println("플레이어 "+player.get(0)+player.get(1)+player.get(2));
				
				// 4. 컴퓨터 번호와 플레이어 번호 비교하기
				int strike = 0;
				int ball = 0;
				if(list.get(0)==player.get(0)) strike++;
				if(list.get(1)==player.get(1)) strike++;
				if(list.get(2)==player.get(2)) strike++;
				System.out.println("--------------------------------------");
				System.out.print(player+"  결과 : "+strike+"S");
				System.out.print("  ");
				if(list.get(0)==player.get(1)) ball++;
				if(list.get(0)==player.get(2)) ball++;
				if(list.get(1)==player.get(0)) ball++;
				if(list.get(1)==player.get(2)) ball++;
				if(list.get(2)==player.get(0)) ball++;
				if(list.get(2)==player.get(1)) ball++;
				System.out.println(ball+"B");
				System.out.println("--------------------------------------");
				cnt++;
				if(strike==3) {
					System.out.println("\n--------------------------------------");
					System.out.println("승리!");
					System.out.println("--------------------------------------");
					System.out.println("컴퓨터 번호 "+baseball);
					System.out.println("--------------------------------------");
					System.out.println("총 도전횟수 "+cnt);
					System.out.println("--------------------------------------");
					break;
				}
			}
			System.out.println("\n한번 더 하시겠습니까? 플레이횟수"+ ++gcnt);
			System.out.println("1. 플레이볼 2.종료");
			int sel = sc.nextInt();
			switch(sel) {
				case 1:
					continue;
				case 2:
					System.exit(0);
					break;
				default:
					continue;
			}
		}
	}
}
