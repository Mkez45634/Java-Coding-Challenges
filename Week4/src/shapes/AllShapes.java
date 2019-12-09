package shapes;


import java.util.ArrayList;
public class AllShapes {
	private ArrayList<Shape> allShapes;

	public AllShapes() {
		allShapes = new ArrayList<Shape> ();
	}
	
	public void add(Shape s) {
		allShapes.add(s);

	}
	
	public String getDetails() {
		String details = "";
		for (Shape s : allShapes) {
			details += s.toString() + "\n";
		}
		return details;	
	}
	
	public Shape getShape(int index) {
		return allShapes.get(index);
	
	}
}
