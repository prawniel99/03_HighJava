package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Jul23BaseballTeacher {
	private ArrayList<Integer> numList;
	private ArrayList<Integer> userList;
	private Scanner sc = new Scanner(System.in);
	private int strike, ball;
	
	public static void main(String[] args) {
		new Jul23BaseballTeacher().gameStart();
	}		
		
	public void gameStart() {
		// 난수 생성 메소드 호출
		getNum();
		
		// 확인용 난수 출력
		System.out.println("난수값>> "+numList);
		
		int cnt = 0;
		do {
			cnt++;
			
			// 사용자 입력 메소드 호출
			inputData();
			
			// 볼카운트
			ballCount();
		} while(strike!=3);
		
		System.out.println("");
		System.out.println("축하합니다");
		System.out.println("당신은 "+cnt+"번째 만에 맞췄습니다...");
	}
	
	// 1~9 사이의 서로 다른 난수 3개 만들어서 List에 넣기
	private void getNum() {
		Set<Integer> numSet = new HashSet<Integer>();
		
		// Set 사용해서 난수 3개 만들기
		while(numSet.size()<3) {
			numSet.add((int)(Math.random()*9)+1);
		}
		
		// 만든 난수 List에 저장하기
		numList = new ArrayList<Integer>(numSet);
		
		// 숫자 섞기
		Collections.shuffle(numList);
	}
	
	// 사용자로부터 3개의 정수를 입력 받아 List에 저장하는 메소드
	private void inputData() {
		int num1, num2, num3;		// 입력값 저장 변수 선언
		
		do {
			System.out.print("숫자 입력>> ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			num3 = sc.nextInt();
			
			if(num1==num2 || num1==num3 || num2==num3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시 입력하세요...");
			}
		} while(num1==num2 || num1==num3 || num2==num3);
		
		// 입력한 데이터를 List에 저장한다.
		userList = new ArrayList<Integer>();
		userList.add(num1);
		userList.add(num2);
		userList.add(num3);
	}
	
	// 스트라이크와 볼을 판정하고, 결과를 출력하는 메소드
	private void ballCount() {
		strike = 0;
		ball = 0;
		
		for(int i=0; i<numList.size(); i++) {
			for(int j=0; j<userList.size(); i++) {
				if(numList.get(i)==userList.get(j)) {
					if(i==j) {
						strike++;
					} else {
						ball++;
					}
					break; // 완료되면 추가 작업 안하게 설정하여 시간 줄이기.
				}
			}
		}
		
		// 판정 결과 출력
		System.out.println(userList.get(0)+" "+userList.get(1)+" "+userList.get(2)+
						   " ==> "+strike+"S"+ball+"B");
	}
}
