package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import basics.Bicycle;

public class BicycleTest {
	
	@Test
	public void CanDriveBicycle() {
		int DriveDistanceOne = 100;
		int DriveDistanceTwo = 150;
		int TempPointOne = 100;
		int TempPointTwo = 250;
		
		Bicycle TestB = new Bicycle();
		
		TestB.Drive(DriveDistanceOne);
		assertEquals(TestB.GetOdometer(), TempPointOne);
		
		TestB.Drive(DriveDistanceTwo);
		assertEquals(TestB.GetOdometer(), TempPointTwo);
	}
}