package assignment1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends BasePerson implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Course course;
	private StudentMarks enrolledModules = new StudentMarks();
	private int level;
	
	public Student (String f, String m, String l, int i, Course c, int k) {
		setFirstName(f);
		setMiddleName(m);
		setLastName(l);
		int length = String.valueOf(i).length();
		if (length == 7) {
			setId(i);
		}else {
			System.out.println("Please enter a vaild student ID.");
		}
		setCourse(c);
		setLevel(k);		
	}


	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
		
	}

	public StudentMarks getEnrolledModules() {
		return enrolledModules;
	}

	public void setEnrolledModules(StudentMarks eM) {
		this.enrolledModules = eM;
		
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
		
	}
	
	 @Override
	 public String toString() {
		 return getFirstName() + " " + getMiddleName()  + " " + getLastName()  + " " + getId()  + " " + getCourse()  + " " + getEnrolledModules()  + " " + getLevel();
	 }
	
	public void chooseCourse(CourseManagementSystem m) {
		for (int x = 0; x < m.getCourses().size(); x++) {
			System.out.println(x + ". " + m.getCourses().get(x).getName());
		}
		System.out.println("Please enter the number to the associated course you wish to be on");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        course = m.getCourses().get(i);
        in.close();
        m.saveStudents();
	}
	
	public void enrollMandatoryModules() {
		//student auto enrolls on mandatory modules with a message that they have been enrolled on them.
		//lvl 6 students get a list of optional modules and can pick two of them.
		
		StudentMarks tempEnrolledModules = new StudentMarks();
		ArrayList<Module> tempModules =  new ArrayList<Module>();
		//go through all the modules on the course
		for (int i = 0; i < getCourse().getCourseModule().size(); i++) {
			//check if the module is the correct level and is mandatory
			if (getLevel() == getCourse().getCourseModule().get(i).getLevel() && false == getCourse().getCourseModule().get(i).getOptional()) {
				//use tempEnrolledModules to add the module to enrolledModules
				tempEnrolledModules = getEnrolledModules();
				tempModules = tempEnrolledModules.getModules();
				tempModules.add(getCourse().getCourseModule().get(i));
				tempEnrolledModules.setModules(tempModules);
				setEnrolledModules(tempEnrolledModules);
			}
		}
		
		
	}
	
	public void enrollOptionalModules(Module m1, Module m2) {
		StudentMarks tempEnrolledModules = new StudentMarks();
		ArrayList<Module> tempModules =  new ArrayList<Module>();
		
		tempEnrolledModules = getEnrolledModules();
		tempModules = tempEnrolledModules.getModules();
		
		tempModules.add(m1);
		tempModules.add(m2);
		
		tempEnrolledModules.setModules(tempModules);
		setEnrolledModules(tempEnrolledModules);
	}
}
