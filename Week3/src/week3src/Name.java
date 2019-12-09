package week3src;

import java.util.ArrayList;
import java.util.List;

public class Name {
	
	private String firstName;
	private String middleName;
	private String surname;
	private List<Car> carsOwned;
	
	
	public Name(String fname, String mname, String sname) {
		this.firstName = fname;
		middleName = mname;
		surname = sname;
		carsOwned = new ArrayList<Car>();
	}
	public Name (String fullname) {
		String[] nameSplit = fullname.split(" ");
		this.firstName = nameSplit[0];
		middleName = nameSplit[1];
		surname = nameSplit[2];
	}
	
	public String getFirstAndLastName() {
		return firstName + " " + surname;
	}
	
	public String getLastCommaFirst() {
		return surname + ", " + firstName;
	}
	
	public String getFullName() {
		if (middleName != "") {
			return firstName + " " + middleName + " " + surname;
		}else {
			return firstName + " " + surname;
		}
	}
	
	public void addCar(Car car) {
		this.carsOwned.add(car);
	}
	
	public void removeCar(Car car) {
		this.carsOwned.remove(car);
	}
	
	public List<Car> getOwnedCars() {
		return carsOwned;
	}

}
