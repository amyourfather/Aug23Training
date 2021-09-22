package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import basics.LargeEngine;
import basics.SmallEngine;

public class EngineTest {

	@Test
	public void CanCreateLargeEngine() {
		LargeEngine TempLarge = new LargeEngine();
		
		assertEquals(TempLarge.getCylinderCount(), 8);
	}
	
	@Test
	public void CanCreateSmallEngine() {
		SmallEngine TempSmall = new SmallEngine();
		
		assertEquals(TempSmall.getCylinderCount(), 4);
	}
}