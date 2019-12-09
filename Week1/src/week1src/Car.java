package week1src;

public class Car {
	//instance variables
	private String model;  
	private int tankSize;
	private	double manfMPG;
	//constructor
	public Car(String model, int tank, double mpg){                          
		this.model = model;
		tankSize = tank;
		manfMPG = mpg;
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
}
