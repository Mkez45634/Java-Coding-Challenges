package q3;

//same as earlier Car versions plus Comparable interface and compareTo method
public class Car implements Comparable<Car>{
	//instance variables
	private String model;	 	
	private int tankSize;
	private double manfMPG;
	private String regNum;
	private Name owner;
	private static final double GPL= 0.22;
	//constructor
	public Car(String regNum,String model, int tank, double mpg, String ownerName)
	{ 
		this.regNum = regNum;
		this.model = model;
		tankSize = tank;
		manfMPG = mpg;
		owner = new Name(ownerName);
	}

	//return regNum
	public String getRegNum() {
		return regNum;
	}
	
	//return tankSize
	public int getTankSize() {
		return tankSize;
	}

	//Return model
	public String getModel() {
		return model;
	}

	public Name getOwner() {
		return owner;
	}

	//estimate distance car can travel
	public double estimateDistance()
	{
		//there are 0.22 gallons per litre
		return tankSize * manfMPG * GPL;
	}	

	public int compareTo(Car other){
		return regNum.compareTo(other.getRegNum());
	}


} 
