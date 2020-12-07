package ex04.quiz;

public class Airplane {
	
	private IBattery battery; //모든 건전지를 받을 수 잇도록
	
	public IBattery getBattery() {
		return battery;
	}

	//세터주입
	public void setBattery(IBattery battery) {
		this.battery = battery;
	}
	
	
	
	

}
