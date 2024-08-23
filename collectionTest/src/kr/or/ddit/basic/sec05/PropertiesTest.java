package kr.or.ddit.basic.sec05;

import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		/*
		 *  Properties는 Map보다 축소된 기능의 객체라고 할 수 있다.
		 *  
		 *  Map은 key값과 value값에 모든 종류의 자료들을 사용할 수 있지만,
		 *  Properties는 key값과 value값에 String만 사용할 수 있다.
		 *  
		 *  Map은 put(), get() 메소드를 이용하여 데이터를 입출력하고,
		 *  Properties는 setProperty(), getProperty() 메소드를 이용한다.
		 *  
		 *  Properties는 데이터를 파일로 입출력할 수 있다.
		 *  
		 */
		
		Properties prop = new Properties();
		
		// 데이터 추가 ==> setProperty() 메소드 이용
		prop.setProperty("name", "홍길동");
		prop.setProperty("tel", "010-1234-5678");
		prop.setProperty("addr", "대전");
		prop.setProperty("age", "20");
		prop.setProperty("age2", String.valueOf(20));
		prop.setProperty("age3", 20+"");
		
		// 데이터 가져오기 ==> getProperty() 메소드 이용
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		int age = Integer.parseInt(prop.getProperty("age"));
		System.out.println("name "+name);
		System.out.println("test "+tel);
		System.out.println("addr "+addr);
		System.out.println("age "+age);
	}
}
