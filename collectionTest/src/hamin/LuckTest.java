package hamin;

import java.util.ArrayList;
import java.util.HashSet;

public class LuckTest {
	private int cnt;
	private int wins;
	private HashSet<Integer> luckNo;
	private HashSet<Integer> myNo;
	private ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
	
	public static void main(String[] args) {
		new LuckTest().start();
	}
	
	public void start() {
		sixNo();
		oneNo();
		threeNo();
	}
	
	private void oneNo() {
		while(true) {
			cnt++;
			luckNo = new HashSet<Integer>();
			myNo = new HashSet<Integer>();
			luckNo.add((int)(Math.random()*10)+1);
			myNo.add((int)(Math.random()*10)+1);
			System.out.println("luckNo "+luckNo+"  myNo "+myNo);
			if(luckNo.containsAll(myNo)) win();
		}
	}
	
	private void threeNo() {
		while(true) {
			cnt++;
			luckNo = new HashSet<Integer>();
			myNo = new HashSet<Integer>();
			while(luckNo.size()<3) luckNo.add((int)(Math.random()*45)+1);
			while(myNo.size()<3) myNo.add((int)(Math.random()*45)+1);
			System.out.println("luckNo "+luckNo+"  myNo "+myNo);
			if(luckNo.containsAll(myNo)) win();
		}
	}

	private void sixNo() {
		while(true) {
			cnt++;
			luckNo = new HashSet<Integer>();
			myNo = new HashSet<Integer>();
			while(luckNo.size()<6) luckNo.add((int)(Math.random()*45)+1);
			while(myNo.size()<6) myNo.add((int)(Math.random()*45)+1);
//			System.out.println("luckNo "+luckNo+"  myNo "+myNo);
			if(luckNo.containsAll(myNo)) win();
		}
	}
	
	private void win() {
		numPrint(cnt);
		System.out.println(cnt+"번");
		cnt*=0;
		System.out.println("myNo 출력 "+myNo);
		list.add(myNo);
		wins++;
		if(wins==10) {
			System.out.println(list);
			System.exit(0);
		}
		start();
	}

	private String numPrint(int no) {
		if(cnt>=1000000000) System.out.println((cnt/1000000000)+",");
		return null;
	}
}
