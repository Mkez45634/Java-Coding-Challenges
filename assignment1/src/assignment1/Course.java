package assignment1;
import java.io.Serializable;
import java.util.ArrayList;


public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private boolean hidden = false;
	
	private ArrayList<Module> courseModules= new ArrayList<Module>(); 
	
	private float passMark;

	public Course(String i, String n, boolean h, ArrayList<Module> m) {
		setId(i);
		setName(n);
		setHidden(h);
		setCourseModule(m);		
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public ArrayList<Module> getCourseModule() {
		return courseModules;
	}
	
	public void setCourseModule(ArrayList<Module> m) {
		this.courseModules = m;
	}

	public void addCourseModule(Module m) {
		this.courseModules.add(m);
	}
	
	public void removeCourseModule(Module m) {
		this.courseModules.remove(m);
	}
	
	public void clearCourseModule() {
		this.courseModules.clear();
	}

	public float getPassMark() {
		return passMark;
	}

	public void setPassMark(float passMark) {
		this.passMark = passMark;
	}

}
