package basics;

public class ConvertibleCar extends Car {
	
	private boolean TopMotor;
	
	public ConvertibleCar() {
		this.model = null;
		this.odometer = 0;
		engine = new SmallEngine();
		TopMotor = false;
	}
	
	public ConvertibleCar(String model) {
		this.model = model;
		this.odometer = 0;
		engine = new SmallEngine();
		TopMotor = false;
	}
	
	public void SetTopMotor(String Requirement) {
		if (Requirement == "Raise") {
			TopMotor = true;
		} else if (Requirement == "Lower") {
			TopMotor = false;
		}
	}
	
	public String GetTopMotor() {
		if (TopMotor) {
			return "Up";
		}
		return "Down";
	}
}
