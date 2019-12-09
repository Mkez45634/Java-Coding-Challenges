package week3src;

public class Car {
	//instance variables
	private String model;  
	private int tankSize;
	private	double manfMPG;
	private Name name;
	//constructor
	public Car(String model, int tank, double mpg, Name ownerName){                          
		this.model = model;
		tankSize = tank;
		manfMPG = mpg;
		name = ownerName;
		name.addCar(this);
	}
	//set value of model
	public void setModel(String model) {
		this.model = model;
	}
	//Return model
	public String getModel() {
		return model;
	}
	//set value of model
	public void setTankSize(int tank) {
	  tankSize = tank;
	}
	//Return tankSize
	public int getTankSize() {
		return tankSize;
	}
	//estimate distance car can travel
	public double estimateDistance(){
	//there are 0.22 gallons per litre
		return tankSize * manfMPG * 0.22;
	}
	
	//set the owner name
	public void setOwner(Name ownerName) {
		name = ownerName;
	}
	
	//Return the ownerName
	public Name getOwner() {
		return name;
	}
	
	//tankBigger returns weather the fuel consumption is efficient, normal or below average depending upon tankSize
	public boolean tankBigger(int size) {
		if (tankSize > size) {
			System.out.println("inefficient fuel useage");
			
		}else if (tankSize < size ) {
			System.out.println("good fuel consumption");
			return true;
		}else {
			System.out.println("average consumer");
		}
		return false;
	}
}
