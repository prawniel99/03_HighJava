package kr.or.ddit.basic.sec02;

import java.util.Scanner;

public class HaminTry {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		HaminTry ht = new HaminTry();
		ht.process();
	}
	
	public void process() {
		int choose = sc.nextInt();
		while(true) {
			switch(choose) {
			case 1:
				m1();
				break;
			case 2:
				m2();
				break;
			default:
			}
			
		}
	}
	
	public void m2() {
		
	}
	
	public void m1() {
		int a = 1;
		int b = 5;
		int c = 10;
		System.out.println(a+b+c);
		System.out.println(""+a+b+c);
		
		NumCble cble = new NumCble();
		cble.setNum(5);
		cble.compareTo(a);
		cble.compareTo(b);
		cble.compareTo(c);
		process();
	}
}

class NumCble implements Comparable<Integer> {
	private int num;

	@Override
	public int compareTo(Integer num) {
		if(this.num > num) {
			System.out.println("Cble이 더 큽니다");
			return 1;
		} else if(this.num < num) {
			System.out.println("Cble이 더 작습니다");
			return -1;
		} else {
			System.out.println("값이 똑같습니다");
			return 0;
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}

class NumCtor {
	
}