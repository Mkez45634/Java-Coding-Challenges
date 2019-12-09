package staffListTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import staffList.CharityStaff;
import staffList.Name;

class staffListTest {

	CharityStaff CS = new CharityStaff();
	
	@Test
	void getTotalHoursTest() {
		CS.populate();
		assertEquals(CS.getTotalHours(), 75);
	}
	
	@Test
	void findPersonTest() {
		CS.populate();
		assertEquals(CS.findPerson("Helen Scott").getName().getFullName(), "Helen Scott");
	}
	
	@Test
	void listAllVoulunteersTest() {
		CS.populate();
		assertEquals(CS.listAllVolunteers(), "ALL VOLUNTEERS\n" + 
				"Helen Scott\n" + 
				"James Jackson\n" + 
				"\n" + 
				"");
	}
	
	@Test
	void populateTest() {// must test all 5 of them
		CS.populate();
		assertEquals(CS.findPerson("Helen Scott").getName().getFullName(), "Helen Scott");
		assertEquals(CS.findPerson("James Jackson").getName().getFullName(), "James Jackson");
		assertEquals(CS.findPerson("Tim Moore").getName().getFullName(), "Tim Moore");
		assertEquals(CS.findPerson("Mary Munro").getName().getFullName(), "Mary Munro");
		assertEquals(CS.findPerson("Keith Clark").getName().getFullName(), "Keith Clark");
	}
	
	@Test
	void equalsTest() {
		CS.populate();
		assertTrue(CS.findPerson("Helen Scott").equals(CS.findPerson("Helen Scott")));
	}

}
