package hamin;

import java.util.HashMap;

public class ClassPractice {
	HashMap<String, Car> car = new HashMap<String, Car>();
	HashMap<String, Elec> elec = new HashMap<String, Elec>();
	
	public static void main(String[] args) {
		new ClassPractice().start();
	}
	
	public void start() {
		
	}
}

class Car {
	private String carbrand;
	private String carname;
	private int carprice;
	
	private Car(String carbrand, String carname, int carprice) {
		
	}
	
	public String getCarbrand() {
		return carbrand;
	}
	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public int getCarprice() {
		return carprice;
	}
	public void setCarprice(int carprice) {
		this.carprice = carprice;
	}
	
}

class Elec {
	private String elecbrand;
	private String elecname;
	private int elecprice;
	
	public String getElecbrand() {
		return elecbrand;
	}
	public void setElecbrand(String elecbrand) {
		this.elecbrand = elecbrand;
	}
	public String getElecname() {
		return elecname;
	}
	public void setElecname(String elecname) {
		this.elecname = elecname;
	}
	public int getElecprice() {
		return elecprice;
	}
	public void setElecprice(int elecprice) {
		this.elecprice = elecprice;
	}
	
}
