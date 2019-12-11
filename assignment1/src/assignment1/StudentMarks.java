package assignment1;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentMarks implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Module> modules =  new ArrayList<Module>();
	private int[] marks = new int[8];
	
	
	
	public ArrayList<Module> getModules() {
		return modules;
	}
	public void setModules(ArrayList<Module> m) {
		this.modules = m;
	}
	
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	
	@Override
	 public String toString() {
		 return getModules()  + " " + getMarks();
	 }

}
