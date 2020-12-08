package ex04.quiz;

public class Car {

	private IBattery battery; //모든 건전지를 받을 수 있도록
	
	//생성자 주입
	public Car(IBattery battery) {
		this.battery = battery;
	}
	
	//getter
	public IBattery getBattery() {
		return battery;
	}
	
}
