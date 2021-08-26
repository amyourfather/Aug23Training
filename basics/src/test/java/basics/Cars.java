package basics;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cars {
	@Test
	public void CanBuildCar() {
		Car TestCar = new Car("Corvette");
		
		TestCar.Start();
	}
}