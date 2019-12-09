package q3test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import q3.CarList;

class CarListTest {

	@Test
	void constructorTest() {
		CarList cl = new CarList();
		assertNotNull(cl);
	}
	
	@Test
	void populateTest() {
		CarList cl = new CarList();
		cl.populate();
		assertNotNull(cl.listAllCars());
	}
	
	@Test
	void sortByTest() {
		CarList cl = new CarList();
		cl.populate();
		String temp = cl.listAllCars();
		cl.sortByRegNum();
		assertNotEquals(temp, cl.listAllCars()); //the list in a different order now that it has been sorted.
		
		temp = cl.listAllCars();
		cl.sortByTank();
		assertNotEquals(temp, cl.listAllCars());
		
		temp = cl.listAllCars();
		cl.sortByName();
		assertNotEquals(temp, cl.listAllCars());
	}

}
