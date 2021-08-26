package basics;

public class Car {
	private int odometer;
	public String model;
	public IEngine engine;
	
	public Car(String model) {
		this.model = model;
		odometer = 0;
		engine = new LargeEngine();
	}
	
	public void Drive(int distance) {
		odometer += distance;
	}
	
	public void Start() {
		engine.Start();
	}
	
	public int GetOdometer() {
		return odometer;
	}
}