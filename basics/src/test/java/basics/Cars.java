package basics;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cars {
	@Test
	public void CanBuildCar() {
		Car TestCar = new Car("Corvette");
		
		TestCar.Start();
	}
	
	@Test
	public void CarOdometerTest() {
		int DriveDistanceOne = 100;
		int DriveDistanceTwo = 150;
		int TempPointOne = 100;
		int TempPointTwo = 250;
		
		Car TestCar = new Car("Toyota");
		
		TestCar.Start();
		TestCar.Drive(DriveDistanceOne);
		assertEquals(TestCar.GetOdometer(), TempPointOne);
		
		TestCar.Drive(DriveDistanceTwo);
		assertEquals(TestCar.GetOdometer(), TempPointTwo);
	}
	
	@Test
	public void CanBuildConvertibleCar() {
		ConvertibleCar TestCar = new ConvertibleCar("Venza");
		
		TestCar.Start();
	}
	
	@Test
	public void ConvertibleCarTopMotorTest() {
		ConvertibleCar TestCar = new ConvertibleCar("Venza");
		
		TestCar.SetTopMotor("Raise");
		
		assertEquals(TestCar.GetTopMotor(), "Up");
		
		TestCar.SetTopMotor("Lower");
		
		assertEquals(TestCar.GetTopMotor(), "Down");
	}
}