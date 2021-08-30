package basics;

public class Bicycle {
	private int odometer;
	private boolean driveable;
	
	public Bicycle() {
		this.odometer = 0;
		this.driveable = true;
	}
	
	public int GetOdometer() {
		return this.odometer;
	}
	
	public void Drive(int distance) {
		if (driveable) {
			odometer += distance;
		}
	}
	
	public void Start() {
		System.out.println("Start Driving!!!!");
	}
}