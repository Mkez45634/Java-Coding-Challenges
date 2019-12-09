package week1src;

import java.util.Scanner;

public class BankAccount {
	private double balance;
	private String accountName;
	private int accountNumber;
	public BankAccount(double balance, String name, int number) { //the constructor with parameters
		this.balance = balance;
		accountName = name;
		accountNumber = number;
	}
	public BankAccount() { // the constructor without parameters
		this.balance = 0;
		accountName = "";
	}
	public double getBalance() { //gets the balance
		return balance;
	}
	public void setBalance(double depo) { //sets the balance to the given double
		balance = depo;
	}
	public String getName() { //gets the name of the account
		return accountName;
	}
	public void setName(String name) { //set the name to the account to the given string
		accountName = name;
	}
	public int getNumber() { //gets the account number
		return accountNumber;
	}
	public void setNumber(int num) { //sets the account number to the given int
		accountNumber = num;
	}
	public void deposit(int depo) { // adds the given in to the balance
		//Scanner input = new Scanner(System.in);
		//System.out.print("How much would you like to deposit? ");
		//int depo = input.nextInt();
		balance += depo;		
	}
	public void withdraw(int with) { // takes the given int off the balance, but if the given int is too big it asks the user to withdraw less or add more money to the balance
		Scanner input = new Scanner(System.in);
		System.out.print("Your balance is " + balance);
		while (with > balance){
			System.out.print("Your bank account balance is too low, press d to deposit or b to check your balance. ");
			String choice = input.next();
			if (choice == "d") {
				System.out.print("How much do you want to deposit? ");
				int depo = input.nextInt();
				deposit(depo);					
			}else if (choice == "b") {
				getBalance();
			}else {
				System.out.print("Please pick a valid option! ");
			}
		}
		input.close();
		setBalance(balance-with);
	}

}
