package shapes;


abstract public class Shape {
	private String colour;

	public Shape(String colour) {
		this.colour = colour;
	}
	
	public String toString() {
		return colour;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public abstract double getArea();
	

}
