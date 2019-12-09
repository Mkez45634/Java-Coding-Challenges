package q3test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import q3.Car;

class CarTest {
	//7 tests
	@Test
	void constructorTest() {
		Car carNormal = new Car("012345", "SuperMarine", 30, 2.2, "Me");
		assertNotNull(carNormal);
	}
	
	@Test
	void getRegNumTest() {
		Car carNormal = new Car("012345", "SuperMarine", 30, 2.2, "Me");
		assertEquals(carNormal.getRegNum(), "012345");
	}
	
	@Test
	void getTankSizeTest() {
		Car carNormal = new Car("012345", "SuperMarine", 30, 2.2, "Me");
		assertEquals(carNormal.getTankSize(), 30);
	}
	
	@Test
	void getModelTest() {
		Car carNormal = new Car("012345", "SuperMarine", 30, 2.2, "Me");
		assertEquals(carNormal.getModel(), "SuperMarine");
	}
	
	@Test
	void getOwnerTest() {
		Car carNormal = new Car("012345", "SuperMarine", 30, 2.2, "Me");
		assertEquals(carNormal.getOwner().getFullName(), "Me ");
	}
	
	@Test
	void estimateDistanceTest() {
		Car carNormal = new Car("012345", "SuperMarine", 30, 2.2, "Me");
		assertEquals(carNormal.estimateDistance(), 30*2.2*0.22);
	}
	
	@Test
	void compareToTest() {
		Car carNormal = new Car("012345", "SuperMarine", 30, 2.2, "Me");
		equals(carNormal.compareTo(carNormal)); //it's the same car
		Car car2 = new Car("9876", "Spitfire", 40, 1.9, "NotMe");
		assertNotEquals(carNormal.compareTo(car2), car2.compareTo(carNormal)); 
	}
}
