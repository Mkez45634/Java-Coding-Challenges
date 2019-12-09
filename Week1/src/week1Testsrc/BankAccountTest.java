package week1Testsrc;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import week1src.BankAccount;

class BankAccountTest {
	BankAccount me = new BankAccount(2000, "Mike's Account", 1);
	BankAccount blank = new BankAccount();

	@Test
	void testBankAccount() {
		assertEquals(me.getName(), "Mike's Account");
	}
	
	@Test
	void testDefaultConstructor() {
		assertEquals(blank.getName(), "");
	}

	@Test
	void testGetSetBalance() {
		me.setBalance(3000);
		assertEquals(me.getBalance(), 3000);
	}
	
	@Test
	void testGetSetName(){
		me.setName("Not Mike's");
		assertEquals(me.getName(), "Not Mike's");
	}
	
	@Test
	void testGetSetNumber() {
		me.setNumber(2);
		assertEquals(me.getNumber(), 2);
	}	

	@Test
	void testDeposit() {
		me.deposit(500);
		assertEquals(me.getBalance(), 2500);
	}

	@Test
	void testWithdraw() {
		me.withdraw(10);
		assertEquals(me.getBalance(), 1990);
	}

}
