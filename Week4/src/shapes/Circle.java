package shapes;


public class Circle extends Shape{
	private double radius;

	public Circle(String colour, double radius) {
		super(colour);
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public String toString() {
		return super.toString() + " R= " + radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	


}
