package shapes;


public class Rectangle extends Shape implements HasAngles {
	private double length;
	private double width;
	
	public Rectangle(String colour, double length, double width) {
		super(colour);
		this.length = length;
		this.width = width;
	}
	
	public double getArea(){
		return length*width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidestAngle() {
		return Math.PI/2;
	}
	
	public double getNarrowestAngle() {
		return Math.PI/2;
	}
	
	
	//the same if the same colour and size
	/*public boolean equals (Object other) {
		if (! (other instanceof Rectangle) ) {
			return false;
		}
		Rectangle otherR = (Rectangle) other;
		
		return getColour().equals(otherR.getColour() )
				&& length == otherR.length
				&& width == otherR.width;

	}
	*/
	

	



}
