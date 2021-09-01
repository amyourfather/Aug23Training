package basics;

public class Vehicle {
	protected int odometer;
	
	public void Drive(int distance) {
		odometer += distance;
	}
	
	public int GetOdometer() {
		return odometer;
	}
}
