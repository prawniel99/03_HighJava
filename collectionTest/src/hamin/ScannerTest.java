package hamin;

import java.util.Scanner;

public class ScannerTest {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		new ScannerTest().a();
	}
	
	public void a() {
		System.out.println("uses next only");
		System.out.print("insert a: ");
		String a = sc.next();
		System.out.print("insert b: ");
		String b = sc.next();
		System.out.print("insert c: ");
		String c = sc.next();
		System.out.println(a+b+c);
		
		sc.nextLine();
		System.out.println("uses nextLine only");
		System.out.print("insert aa: ");
		String aa = sc.nextLine();
		System.out.print("insert bb: ");
		String bb = sc.nextLine();
		System.out.print("insert cc: ");
		String cc = sc.nextLine();
		System.out.println(aa+bb+cc);
		
		System.out.println("prediction.");
		System.out.println("aaa alone, bbb alone, ccc and ddd together, eee alone");
		System.out.println("mix");
		System.out.println("next");
		System.out.println("aaa");
		String aaa = sc.next();
		System.out.println("bbb");
		String bbb = sc.next();
		System.out.println("ccc");
		String ccc = sc.nextLine();
		System.out.println("ddd");
		String ddd = sc.next();
		System.out.println("eee");
		String eee = sc.nextLine();
		System.out.println(aaa+bbb+ccc+ddd+eee);
	}
}
