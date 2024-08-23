package kr.or.ddit.basic.sec01;

public class TestArgs {
	
	// 매개변수로 받은 정수들의 합계를 구하는 메소드를 작성하시오.
	// (이 정수들의 개수는 상황에 따라 다를 수 있다.)
	public int sumArr(int[] data) {
		int sum = 0;
		for(int x : data) {
			sum += x;
		}
		return sum;
	}
	
	public void ttt(int c) {
		
	}
	
	// 가변인수(가변인자) ==> 메소드를 호출할 때 인자의 개수가 다를 때 사용할 수 있다.
	// 가변인자는 메소드 안에서는 배열로 처리된다.
	// 가변인자는 하나의 메소드에서 한개만 사용할 수 있다.
	public int sumArg(int ...data) {
		int sum = 0;
		for(int x : data) {
			sum += x;
		}
		return sum;
	}
	
	// 가변인자와 일반적인 매개변수를 같이 사용하게 될 경우에는
	// 가변인자를 가장 뒤쪽에 배치해야한다.
	public String sumArg2(String name, int ...data) {
		int sum = 0;
		for(int x : data) {
			sum += x;
		}
		return name + "씨의 합계: " + sum;
	}
	
	public static void main(String[] args) {
		
		TestArgs test = new TestArgs();
		int[] nums = {100, 200, 300};
		System.out.println(test.sumArr(nums));
		System.out.println(test.sumArr(new int[] {1,2,3,4,5}));
		
		int k = 10;
		test.ttt(k);
		test.ttt(20);
		
		System.out.println(test.sumArg(100,200,300));
		System.out.println(test.sumArg(1,2,3,4,5));
		
		// sumArg2
		System.out.println(test.sumArg2("A", 1,2,3,4,5));
	}
}
