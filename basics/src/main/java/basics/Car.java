package basics;

public class Car extends Vehicle{
	public String model;
	public IEngine engine;
	
	public Car() {
		this.model = null;
		this.odometer = 0;
	}
	
	public Car(String model, IEngine engine) {
		this.model = model;
		this.odometer = 0;
		this.engine = engine;
	}
	
	public void Start() {
		engine.Start();
	}
	
}