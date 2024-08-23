package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jul23Lotto {
	Scanner sc = new Scanner(System.in);
	int globalCount;
	
	public static void main(String[] args) {
		Jul23Lotto ham = new Jul23Lotto();
		ham.portal();
	}
	
	public void portal() {
		lottoMain();
	}
	
	public void lottoMain() {
		while(true) {
			np();
			System.out.print("======================\n"
						   + "   Lotto 프로그램     \n"
						   + "----------------------\n"
						   + "   1. Lotto 구입      \n"
						   + "   2. 프로그램 종료   \n"
						   + "======================\n"
						   + "   메뉴선택: ");
			try {
				String choose = sc.next();
				if(Integer.valueOf(choose)==1) {
					lottoPlay();
				} else if(Integer.valueOf(choose)==2) { 
					System.out.println("감사합니다");
					System.exit(0);
				} else continue;
			} catch(Exception e) {
				tooManyTries();
				continue;
			}
		}
	}
	
	public void lottoPlay() {
		// 돈 지불
		System.out.println("\nLotto 구입 시작\n로또 한게임에 1000원입니다\n\n");
		int pay;
		int games;
		int change;
		while(true) {
			System.out.print("금액 입력: ");
			int playerInput = sc.nextInt();
			if(playerInput > 100000) {
				System.out.println("\n입력 금액이 너무 많습니다. 로또번호 구입 실패!!!\n");
				tooManyTries();
				continue;
			} else if(playerInput < 1000) {
				System.out.println("\n입력 금액이 너무 적습니다. 로또번호 구입 실패!!!\n");
				tooManyTries();
				continue;
			} else {
				pay = playerInput;
				games = pay/1000;
				change = pay%1000;
				break;
			}
		}
		System.out.println("\n행운의 로또번호는 아래와 같습니다.\n"); // 로또 시작
		HashSet<Integer> hs = new HashSet<Integer>(); // 로또 1게임 set
		for(int i=0; i<games; i++) { // 로또 n게임 생성
			while(hs.size()<6) {
				hs.add((int)(Math.random()*45)+1);
			}
			ArrayList<Integer> lotto = new ArrayList<Integer>(hs); // set을 list로 변경
			Collections.sort(lotto); // 오름차순 정렬
			
			System.out.print("로또번호"+(i+1)+" : "); // 로또 출력
			for(int j=0; j<6; j++) {
				System.out.print(lotto.get(j));
				if(j<5) System.out.print(", ");
				else System.out.println();
			}
			hs.clear();
		}
		System.out.println("\n지불한 금액은 "+pay+"원이고 거스름돈은 "+change+"원 입니다.");
		System.out.println("감사합니다");
		System.exit(0);
	}
	
	public void np() {
		for(int i=0; i<50; i++) System.out.println();
	}
	
	public void tooManyTries() {
		globalCount++;
		if(globalCount>=10) {
			np();
			try {
				for(int i=0; i<20; i++) {
					TimeUnit.MILLISECONDS.sleep(100);
					System.out.println("실패 한도를 초과하였습니다");
				}
				TimeUnit.MILLISECONDS.sleep(100);
				np();
				System.out.println("프로그램을 종료합니다");
				for(int i=0; i<13; i++) {
					TimeUnit.MILLISECONDS.sleep(88);
					System.out.println();
				}
				TimeUnit.MILLISECONDS.sleep(444);
				np();
				System.exit(0);
			} catch(Exception e) {
				System.exit(0);
			}
		}
	}
}
