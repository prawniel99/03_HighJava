package m8.d06;

import java.io.Serializable;

// 직렬화 ==> 메모리 상의 객체를 저장 또는 전송하기 위해서 다른 형태로 변환하는 작업을 말한다.

// 직렬화가 가능하게 하려면 Serializable 인터페이스를 구현해야 한다.
public class N01_Member implements Serializable {
	// 멤버 중에 직렬화 대상에서 빼고 싶은 멤버에 transient를 지정한다.
	private String name;
	private transient int age;
	private transient String addr;
	
	public N01_Member(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	  
	public void setName(String name) {
		this.name = name;
	}
	  
	public int getAge() {
		return age;
	}
	  
	public void setAge(int age) {
		this.age = age;
	}
	  
	public String getAddr() {
		return addr;
	}
	  
	public void setAddr(String addr) {
		this.addr = addr;
	}
}