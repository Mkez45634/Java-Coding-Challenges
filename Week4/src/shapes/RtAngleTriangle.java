package shapes;


public class RtAngleTriangle  extends Shape implements HasAngles {

	private double height;
	private double base; 
	
	
	public RtAngleTriangle(String color, double height, double base) {
		super(color);
		this.height = height;
		this.base = base;
	}
	
	public double getArea() {
		return 0.5 * height * base;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	
	public double getWidestAngle() {
		return Math.PI/2;
	}
	//you are NOT expected to know this maths!
	public double getNarrowestAngle() {
		double a1 = Math.atan (base/height);
		double a2 = Math.atan(height/base);
		//System.out.println(a1);
		//System.out.println(a2);
		if (a1 < a2) {
			return a1;
		}
		else return a2;
	}
	

}
