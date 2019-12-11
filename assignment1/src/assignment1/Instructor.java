package assignment1;

import java.io.Serializable;
import java.util.ArrayList;


public class Instructor extends BasePerson implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Instructor(String f, String m, String l, int i) {
		setFirstName(f);
		setMiddleName(m);
		setLastName(l);
		int length = String.valueOf(i).length();
		if (length == 7) {
			setId(i);
		}else {
			System.out.println("Please enter a vaild Instructor ID.");
		}
	}
	
	public ArrayList<Student> getStudentsOnModule(CourseManagementSystem main, Module m) {
		if (m.getInstructor() == this) {
			//get list of students from courseAdmin
			//for each student in that array, use get enrolled modules
			//for each module in that second array, check if it == this
			//if true, add student name to an ArrayList, if false move to next module/student
			ArrayList<Student> studentsOnModule = new ArrayList<Student>();
			
			for (int i = 0; i < main.getStudents().size(); i++) {
				for (int x = 0; x < main.getStudents().get(i).getEnrolledModules().getModules().size(); x++) {
					if (main.getStudents().get(i).getEnrolledModules().getModules().get(x).getId() == m.getId()) {
						//need to check if the student is already on the array
						boolean flag = false;
						for (int y = 0; y < studentsOnModule.size(); y++) {
							if (studentsOnModule.get(y).getId() == main.getStudents().get(i).getId()) {
								flag = true;
							}
						}
						if (flag == false) {
							studentsOnModule.add(main.getStudents().get(i));
						}
					}
				}
			}
			//stretch goal: sort the array into alphabetical order by lastName then firstName.
			return studentsOnModule; //can be a list of 0
		}else{
			return null;
		}
	}
	
	public ArrayList<Module> assignedModules(CourseManagementSystem main) {
		//need to search the courseAdmin arrayList of courses to then search the courseModule arrayList for the instuctor's name
		ArrayList<Module> assignedModules = new ArrayList<Module>();
		for (int i = 0; i< main.getCourses().size(); i++) {
			for (int x = 0; x<main.getCourses().get(i).getCourseModule().size(); x++) {
				if (getId() == main.getCourses().get(i).getCourseModule().get(x).getInstructor().getId()) {
					//this instructor is teaching course i, on module x
					assignedModules.add(main.getCourses().get(i).getCourseModule().get(x));
				}
			}
		}
		return assignedModules;	//can be a list of 0			
	}
	
	public void addMarks(Student s, Module m, int mark) {
		ArrayList<Module> studentModules = s.getEnrolledModules().getModules();
		int[] studentMarks = s.getEnrolledModules().getMarks();
		
		for (int i = 0; i < studentModules.size(); i++) {
			if (studentModules.get(i).getId() == m.getId()) {
				studentMarks[i] = mark;
				s.getEnrolledModules().setMarks(studentMarks);
			}
		}
	}
	

}
