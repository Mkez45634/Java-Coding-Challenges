package q2;

import java.util.TreeMap;

public class PageSixteen {
	public static void main(String args[]) {
		//get a value (phone) for a given key (name)
		System.out.println("Jack's number is "+ phoneBook1().get("Jack"));
		//use the TreeMap toString method to print the entries


		System.out.println("The phone book size: " + phoneBook1().size()); //2.a

		TreeMap <String, String> phoneBookTemp = new TreeMap <String, String>(); //2.b
		phoneBookTemp = phoneBook1();
		phoneBookTemp.remove("Jack");
		if(phoneBookTemp.get("Jack") == null) {
			System.out.println("Jack not found");
		}

		phoneBookTemp = phoneBook1();//2.c
		phoneBookTemp.clear();
		System.out.println("The phone book contains: " + phoneBookTemp);

		phoneBookTemp = phoneBook1();//2.d
		for(String i : phoneBookTemp.values()) {
			if (i == "011-9999") {
				System.out.println("Found it!"); //this will never run
			}
		}

		
		
		// The above but with phoneBook2!
		
		//get a value (phone) for a given key (name)
		System.out.println("Jack's number is "+ phoneBook2().get("Jack").getHomeNumber());
		//use the TreeMap toString method to print the entries


		System.out.println("The phone book size: " + phoneBook2().size()); //2.a

		TreeMap <String, PersonTel> phoneBookTemp2 = new TreeMap <String, PersonTel>(); //2.b
		phoneBookTemp2 = phoneBook2();
		phoneBookTemp2.remove("Jack");
		if(phoneBookTemp2.get("Jack") == null) {
			System.out.println("Jack not found");
		}

		phoneBookTemp2 = phoneBook2();//2.c
		phoneBookTemp2.clear();
		System.out.println("The phone book contains: " + phoneBookTemp2);
		
		phoneBookTemp2 = phoneBook2();//2.d
		for(PersonTel t : phoneBookTemp2.values()) {
			if (t.getHomeNumber() == "011-9999") {
				System.out.println("Found it!"); //this will never run
			}
		}
	}
	public static TreeMap<String, String> phoneBook1() {
		//create a treemap with key = name (String) 
		//and value = phone (String)
		TreeMap <String, String> phoneBook1 = new TreeMap <String, String>();
		//add a few key/value pairs
		phoneBook1.put("Tim", "411-0914");
		phoneBook1.put("Jo", "411-0210");
		phoneBook1.put("Jack", "131-9873");
		phoneBook1.put("Ann", "411-0210");  //jo and ann share a phone 
		return phoneBook1;
	}

	public static TreeMap<String, PersonTel> phoneBook2() {
		//create a treemap with key = name (String) 
		//and value = phone (String)
		TreeMap <String, PersonTel> phoneBook2 = new TreeMap <String, PersonTel>();
		//add a few key/value pairs
		phoneBook2.put("Tim Smith", new PersonTel("Tim", "411-0914", "077871234"));
		phoneBook2.put("Jo", new PersonTel("Jo", "411-0210", "077871234"));
		phoneBook2.put("Jack", new PersonTel("Jack", "131-9873", "077871234"));
		phoneBook2.put("Ann", new PersonTel("Ann", "411-0210", "077871234"));  //jo and ann share phones 
		return phoneBook2;
	}
}
