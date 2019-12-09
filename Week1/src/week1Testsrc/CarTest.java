package week1Testsrc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import week1src.Car;

class CarTest {
	Car mycar = new Car("Volvo", 2, 20.2);
	@Test
	void testCar() {
		//Car mycar = new Car("Volvo", 2, 20.2);
		assertEquals("Volvo", mycar.getModel());	
	}

	@Test
	void testSetModel() {
		mycar.setModel("Ford");
		assertEquals("Ford", mycar.getModel());
	}

	@Test
	void testSetTankSize() {
		mycar.setTankSize(3);
		assertEquals(3, mycar.getTankSize());
	}

}
