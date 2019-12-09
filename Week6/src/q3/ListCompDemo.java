package q3;

//sorting cars using various comparable and comparator interfaces
public class ListCompDemo {

	public static void main(String[] args) {
		CarList cars = new CarList();
		cars.populate();
		System.out.println("In populate order\n" + cars.listAllCars() );
		
		cars.sortByRegNum();
		System.out.println("In regnum order\n" + cars.listAllCars() );
		
		cars.sortByTank();
		System.out.println("In tank size order\n" + cars.listAllCars() );
		
		cars.sortByName();
		System.out.println("In owner order\n" + cars.listAllCars() );

	}
}
