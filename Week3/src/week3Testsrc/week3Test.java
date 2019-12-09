package week3Testsrc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import week3src.Car;
import week3src.Name;

class week3Test {
	
	Name me = new Name ("Mike", "", "Lloyd");
	Car mycar = new Car ("Ford", 2, 20.2, me);
	Car mySecondCar = new Car ("Volvo", 3, 16.7, me);
	Car myThirdCar = new Car ("Ferrari", 6, 14.3, me);
	
	
	@Test
	void estimateDistanceTest() {
		assertEquals(mycar.estimateDistance(), 2 * 20.2 * 0.22);	
	}
	
	@Test
	void tankBiggerTest() {
		assertTrue(mycar.tankBigger(30));
	}
	
	@Test
	void getLastCommaFirstTest() {
		assertEquals("Lloyd, Mike", me.getLastCommaFirst());
	}
	
	@Test
	void thirdCarNameTest() {
		assertTrue(me.getOwnedCars().contains(myThirdCar));
	}

}
