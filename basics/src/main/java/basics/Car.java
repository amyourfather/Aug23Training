package basics;

public class Car extends Vehicle{
	public String model;
	public IEngine engine;
	
	public Car() {
		this.model = null;
		this.odometer = 0;
		engine = new LargeEngine();
	}
	
	public Car(String model) {
		this.model = model;
		this.odometer = 0;
		engine = new LargeEngine();
	}
	
	public void Start() {
		engine.Start();
	}
	
}