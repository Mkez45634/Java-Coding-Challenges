package assignment1;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseAdmin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String Id;
	
	public CourseAdmin (String n, String i) {
		setName(n);
		setId(i);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
	
	public void newCourse(String id, String name, boolean hidden, ArrayList<Module> modules, CourseManagementSystem main) {
		ArrayList<Course> tempCourses = new ArrayList<Course>();
		tempCourses = main.getCourses();
		tempCourses.add(new Course(id, name, hidden, modules));
		main.setCourses(tempCourses);
	}

	
	public void addModuleToCourse(Course c, Module m) {
		c.addCourseModule(m);
		
	}
	
	public void cancelCourse(Course c) {
		c.setHidden(true);
		
	}
	
	public void reactivateCourse(Course c) {
		c.setHidden(false);
		
	}
	
	public void deleteCourse(Course c, CourseManagementSystem main) {
		for (int i = 0; i< main.getCourses().size(); i++) {
			if (main.getCourses().get(i) == c) {
				main.getCourses().remove(i);
			}
		}
	}
	
	public void editCourseName(Course c, String newName) {
		c.setName(newName);
		
	}
	
	public void editModuleName(Module m, String newName) {
		m.setName(newName);
		
	}
	
	public void generateReport(Student s, String yearOrSemester) {
		//so if yearOrSemester = "year" give all 8 modules, else if yearOrSemester = "1" or "2" give the 4 modules associated to that semester
		ArrayList<Module> studentsModules = s.getEnrolledModules().getModules();
		int[] studentMarks = s.getEnrolledModules().getMarks();
		boolean flag = true;
		
		if (yearOrSemester == "year") {
			for (int x = 0; x < studentMarks.length; x++) {
				System.out.print(studentsModules.get(x).getName() + " " + studentMarks[x]);
				if (studentMarks[x] <40) {flag = false; System.out.print(" failed\n");
				}else {
					System.out.print(" passed\n");
				}
			}
			if (flag == true) {
				s.setLevel(s.getLevel()+1);
				System.out.println("Advancing Student");
				
			}
			
		}else if (yearOrSemester.contentEquals("1")) {
			for (int x = 0; x < (studentMarks.length/2); x++) {
				System.out.println(studentsModules.get(x).getName() + " " + studentMarks[x]);
			}
		}else if (yearOrSemester.contentEquals("2")) {
			for (int x = (studentMarks.length/2); x < studentMarks.length; x++) {
				System.out.println(studentsModules.get(x).getName() + " " + studentMarks[x]);
			}
		}
	}
	
	public void assignInstructor(Instructor i, Module m, CourseManagementSystem main) {
		int instructorAssigned = 0;
		for (int y = 0; y < main.getCourses().size(); y++) {
			for (int z = 0; z< main.getCourses().get(y).getCourseModule().size(); z++) {
				if (i == main.getCourses().get(y).getCourseModule().get(z).getInstructor()) {
					instructorAssigned++;
				}
			}
		}
		
		if (instructorAssigned < 4) {
			m.setInstructor(i);
			
		}else {
			System.out.println("Instructor has maximum assigned modules");
		}
		
	}
}
