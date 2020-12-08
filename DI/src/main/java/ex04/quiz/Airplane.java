package ex04.quiz;

public class Airplane {

	private IBattery battery;

	public IBattery getBattery() {
		return battery;
	}
	
	//세터 주입
	public void setBattery(IBattery battery) {
		this.battery = battery;
	}

	
}
