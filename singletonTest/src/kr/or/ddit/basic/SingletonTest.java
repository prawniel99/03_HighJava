package kr.or.ddit.basic;

public class SingletonTest {
	
	public static void main(String[] args) {
//		MySingleton test1 = new MySingleton(); // private 이라서 외부에서 new 명령어로 생성 불가능
		
		MySingleton test2 = MySingleton.getInstance(); // 아하 이거였구나
		MySingleton test3 = MySingleton.getInstance(); // 객체 변수는 2가지지만, test2와 test3의 참조값이 같음.
		// new가 아니라, 그냥 참조하는거 두가지를 만들었을 뿐임.
		
		System.out.println("test2 ==> "+test2.toString());
		System.out.println("test3 ==> "+test3.toString());
		// new는 새로 만들기, getInstance는 그 해당 메소드 하나만 가져오기
		
		// 처음 test2를 toString으로 실행하면,
		// MySingleton.java 로 이동해서 3번의 getInstance로 감.
		// single이 아직 값이 없으니 null이고, 그럼 if문이 true가 되어서 실행.
		// 그럼 single 에 MySingleton 객체를 new로 새로 생성함.
		// 기본 생성자는 생성자 메소드 입니다 라고 print 하는거니까 한번 출력되고,
		// 생성된 MySingleton 객체의 주소가 single 변수에 저장됨.
		// 그 후 test3가 또 getInstance로 가는데,
		// 이때는 single이 이미 값이 있기 때문에 null 이 아니라서,
		// 바로 single을 반환하면, test2의 주소값과 같은 값이 return되게 되고,
		// 생성이 된게 아니기 때문에 print는 없이, test2와 같은 주소값을 출력하게 됨.
	}
}
