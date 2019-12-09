package q3;

//Lecture Comparisons
// various sort methods
import java.util.ArrayList;
import java.util.Collections;

public class CarList {
	private ArrayList<Car> carList;

	public CarList() {
		carList = new ArrayList<Car>  ();
	}

	public void populate() {
		Car c1 = new Car("V468 HGB","Ford Ka", 40, 33.6, "Monica Farrow");
		carList.add(c1);
		Car c2 = new Car("SH05 TRE", "Mercedes Benz E280", 80,22, "Gerry Walker");
		carList.add(c2);
		Car c3 = new Car("N315 JNS", "VW Sharan", 60, 29, "Colin Farrow");
		carList.add(c3);
	}
	
	public String listAllCars()
	{
		String list = "";
		for (Car c : carList)
		{
			list += c.getRegNum() + " has tank size " + c.getTankSize() + "\n";
			list += "    owned by " + c.getOwner().getSortName() + "\n";
		}
		return list + "\n";
	}
	
	public void sortByRegNum() {
		Collections.sort(carList);
	}
	
	public void sortByTank() {	
		TankComparator tankComparator = new TankComparator();
		Collections.sort(carList, tankComparator);
	}
	
	//notice alternative way of declaring the comparator
	//this is 'anonymous' - it's not given a name
	//we only use it once, here
	public void sortByName() {
		Collections.sort(carList, new OwnerComparator());
	}



}
