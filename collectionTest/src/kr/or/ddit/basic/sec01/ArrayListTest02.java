package kr.or.ddit.basic.sec01;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayListTest02 obj = new ArrayListTest02();
		obj.works();
		/*
		 * 문제
		 * 
		 * 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에
		 * 이들 중에 '김'씨 성의 이름을 모두 출력하시오
		 * (단, 입력은 Scanner 객체를 이용한다.)
		 * 
		 */
		
//		ArrayList<String> nameList = new ArrayList<String>();
//		System.out.println("이름을 입력하세요");
//		for(int i=0; i<5; i++) {
//			System.out.print((i+1)+"번 이름: ");
//			String inp = sc.next();
//			nameList.add(inp);
//		}
//		System.out.println();
//		System.out.println("입력한 이름: "+nameList);
//		System.out.println();
//		System.out.println("'김'씨 출력하기");
//		for(String str : nameList) {
//			if(str.indexOf("김")==0) {
//				System.out.println(str);
//			}
//		}
//		q1();
//		q2();
//		q3();
//		qTeacher();
		
//		System.out.println("\n메소드1 진입\n");
//		method1();
//		System.out.println("\n메소드2 진입\n");
//		method2();
		
	}
	
	private void works() {
		q1();
		q2();
		q3();
		qTeacher();
	}
	
	private void qTeacher() {
		ArrayList<String> nameList = new ArrayList<String>();
		
		System.out.println("5명의 이름을 입력하세요...");
		for(int i=1; i<=5; i++) {
			System.out.println(i+"번째 이름>> ");
			String name = sc.next();
			nameList.add(name);
		}
		
		System.out.println();
		System.out.println("김씨 성을 가진 사람들...");
		// 1번 방법
		for(int i=0; i<nameList.size(); i++) {
			if(nameList.get(i).substring(0,1).equals("김")) {
				System.out.println(nameList.get(i));
			}
		}
		// 2번 방법
		for(int i=0; i<nameList.size(); i++) {
			String name = nameList.get(i);
			if(name.charAt(0)=='김') {
				System.out.println(name);
			}
		}
		// 3번 방법
		for(int i=0; i<nameList.size(); i++) {
			if(nameList.get(i).indexOf("김")==0) {
				System.out.println(nameList.get(i));
			}
		}
		// 4번 방법
		for(int i=0; i<nameList.size(); i++) {
			if(nameList.get(i).startsWith("김")/*==true*/) {
				System.out.println(nameList.get(i));
			}
		}
	}

	private void q3() {
		System.out.println("문제");
		System.out.println("5명의 별명을 입력 받아 ArrayList에 저장한 후\n"
				+ "이들 중에서 별명의 길이가 가장 긴 별명을 출력하시오.\n"
				+ "(단, 별명의 길이는 중복될 수 있다. => ArrayListText04.java");
		System.out.println();
		System.out.println();
		ArrayList<String> arr = new ArrayList<String>();
		System.out.println("5개의 별명 입력하기");
		for(int i=0; i<5; i++) arr.add(sc.nextLine());
		String str = "";
		ArrayList<String> answer = new ArrayList<String>();
		for(String test : arr) {
			if(str.length()<=test.length()) {
				str = test;
			}
		}
		for(String test : arr) {
			if(test.length()==str.length()) {
				answer.add(test);
			}
		}
		System.out.println("가장 긴 길이: "+str.length());
		System.out.println("같은 길이 단어 개수: "+answer.size());
//		System.out.println("길이가 같은 별명: "+answer.toString());
		System.out.print("길이 긴 별명: ");
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i));
			if(i==answer.size()-1) break;
			System.out.print(", ");
		}
	}

	private void q2() {
		System.out.println("문제2");
		System.out.println("5명의 별명을 입력 받아 ArrayList에 저장한 후\n"
				+ "이들 중에서 별명의 길이가 가장 긴 별명을 출력하시오.\n"
				+ "(단, 별명의 길이는 모두 다르게 입력한다. => ArrayListText03.java");
		System.out.println();
		System.out.println();
		ArrayList<String> arr = new ArrayList<String>();
		System.out.println("5개의 별명 입력하기");
		for(int i=0; i<5; i++) arr.add(sc.next());
		String answer = "";
		for(String test : arr) {
			if(answer.length()<test.length()) {
				answer = test;
			}
		}
		System.out.println("가장 길이가 긴 별명: "+answer);
		System.out.println("길이: "+answer.length());
	}

	private void q1() {
		System.out.println("문제1");
		System.out.println("5명의 사람 이름을 입력 받아 ArrayList에 저장한 후\n"
				+ "이들 중에서 '김'씨 성의 이름을 모두 출력하시오.\n"
				+ "(단, 입력은 Scanner 객체를 이용한다. => 4가지 이상의 방법");
		System.out.println();
		System.out.println();
		ArrayList<String> nameList = new ArrayList<String>();
		System.out.println("이름 입력");
		System.out.println();
		for(int i=0; i<5; i++) {
			System.out.print((i+1)+"번 이름: ");
			String inp = sc.next();
			nameList.add(inp);
		}
		System.out.println();
		System.out.println("입력한 이름: "+nameList);
		System.out.println();
		System.out.println("'김'씨 출력하기");
		for(String str : nameList) {
			if(str.indexOf("김")==0) {
				int idx = nameList.indexOf(str);
				System.out.println("인덱스 번호: "+idx+" 이름: "+str);
			}
		}
	}

	public void method1() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		System.out.println("이름 입력");
		System.out.println();
		for(int i=0; i<5; i++) {
			System.out.print((i+1)+"번 이름: ");
			String inp = sc.next();
			nameList.add(inp);
		}
		sc.close();
		System.out.println();
		System.out.println("입력한 이름: "+nameList);
		System.out.println();
		System.out.println("'김'씨 출력하기");
		for(String str : nameList) {
			if(str.indexOf("김")==0) {
				int idx = nameList.indexOf(str);
				System.out.println("인덱스 번호: "+idx+" 이름: "+str);
			}
		}
	}
	
	public void method2() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		System.out.println("이름 입력");
		System.out.println();
		for(int i=0; i<20; i++) {
			System.out.print((i+1)+"번 이름: ");
			String inp = sc.next();
			nameList.add(inp);
		}
		sc.close();
		System.out.println();
		System.out.println("입력한 이름: "+nameList);
		System.out.println();
		System.out.println("'김'씨 출력하기");
		System.out.println();
		for(String str : nameList) {
			if(str.indexOf("김")==0) {
				System.out.print("----------------");
			}
		}
		System.out.println();
		for(String str : nameList) {
			if(str.indexOf("김")==0) {
				int idx = nameList.indexOf(str);
				System.out.print("인덱스 "+idx+"\t");
//				System.out.println("인덱스 번호: "+idx+" 이름: "+str);
			}
		}
		System.out.println();
		for(String str : nameList) {
			if(str.indexOf("김")==0) {
				System.out.print("----------------");
			}
		}
		System.out.println();
		for(String str : nameList) {
			if(str.indexOf("김")==0) {
				System.out.print(str+"   \t");
			}
		}
	}
	
}

