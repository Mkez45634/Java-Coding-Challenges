package assignment1;

import java.io.Serializable;


public class Module implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String id;
	private int semester;
	private int level;
	private boolean optional;
	private Instructor instructor;
	
	public Module(String n, String i, int s, int l, boolean o){
		setName(n);
		setId(i);
		if (s > 0 & s < 4) {
			setSemester(s);
		}else {System.out.println("Please give a valid semester");}
		if (l > 3 & l <8) {
			setLevel(l);
		}else {System.out.println("Please give a valid level");}
		setOptional(o);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean getOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	

}
