package kr.or.ddit.basic.sec03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentTest {
	
	// 등수 구하는 메소드
	public void createRank(ArrayList<Student> stdList) {
		for(Student std1 : stdList) { // 기준 데이터를 구하기 위한 반복문.
			int rank = 1; // 처음에는 1등으로 설정하고 시작.
			for(Student std2 : stdList) {
				if(std1.getTotal() < std2.getTotal()) { // 비교 대상을 나타내는 반복문.
					rank++;
				}
			}
			std1.setRank(rank); // 최종 등수를 Student 객체의 rank 변수에 저장.
		}
	}
	// 인스턴스 메소드(static 없는거)는 개체를 생성해야 사용할 수 있음.
	// 정적 메소드(static)는 객체 생성 없이도 클래스만 부르면 사용 가능.
	
	public static void main(String[] args) {
		StudentTest stdTest = new StudentTest();
		ArrayList<Student> stdList = new ArrayList<Student>();
		stdList.add(new Student(1, "홍길동", 90, 95, 80));
		stdList.add(new Student(3, "성춘양", 90, 75, 70));
		stdList.add(new Student(7, "강감찬", 95, 95, 80));
		stdList.add(new Student(5, "변학도", 90, 95, 80));
		stdList.add(new Student(2, "일지매", 100, 85, 80));
		stdList.add(new Student(4, "이순신", 70, 75, 70));
		stdList.add(new Student(6, "이몽룡", 90, 100, 90));
		stdTest.createRank(stdList); // 등수 구하는 메소드 호출
		
		System.out.println("정렬 전");
		for(Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("------------------------------------------");
		
//		Collections.sort(stdList); // 내부 정렬 기준으로 정렬하기(학번 오름차순)
		
		System.out.println("학번 오름차순 정렬");
		for(Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("------------------------------------------");

		// 외부정렬 총점순 내림차순
		System.out.println("총점 내림차순 정렬");
		Collections.sort(stdList, new SortByTotal());
		for(Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("------------------------------------------");
	}
}

class Student {
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int total;
	private int rank;
	
	public Student(int num, String name, int kor, int eng, int mat) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		total = kor + eng + mat;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "번호:" + num + "  이름:" + name + "  국어:" + kor +
				"  영어:" + eng + "  수학:" + mat + "  총점:" + total +
				"  등수:" + rank;
	}

//	class SortByNum implements Comparable<Student> {
//		
//		@Override
//		public int compareTo(Student std) {
//			return Integer.compare(num, std.getNum());
//		}
//	}
	
//	@Override
//	public int compareTo(Student std) {
//		return Integer.compare(this.num, std.getNum());
//	}
	
}


// 총점의 역순(내림차순)으로 정렬 하는데 총점이 같으면 이름의 오름차순으로 정렬
class SortByTotal implements Comparator<Student> {

	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getTotal()==std2.getTotal()) {
			return std1.getName().compareTo(std2.getName());
		} else {
			return Integer.compare(std1.getTotal(), std2.getTotal()) * -1;
		}
	}
}