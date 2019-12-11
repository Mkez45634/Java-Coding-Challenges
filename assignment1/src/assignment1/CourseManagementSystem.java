package assignment1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CourseManagementSystem {
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<Instructor> instructors = new ArrayList<Instructor>();
	private ArrayList<CourseAdmin> courseAdmins = new ArrayList<CourseAdmin>();
	
	
	
	public  ArrayList<Student> getStudents() {
		return students;
	}

	public  void setStudents(ArrayList<Student> s) {
		students = s;
	}

	public  ArrayList<Course> getCourses() {
		return courses;
	}

	public  void setCourses(ArrayList<Course> c) {
		courses = c;
	}

	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(ArrayList<Instructor> i) {
		instructors = i;
	}

	public ArrayList<CourseAdmin> getCourseAdmins() {
		return courseAdmins;
	}

	public void setCourseAdmins(ArrayList<CourseAdmin> courseAdmins) {
		this.courseAdmins = courseAdmins;
	}
	
	public void saveStudents() {
		try {
			String fileNameStudent = "students.txt";		
			FileOutputStream fosStudents = new FileOutputStream(fileNameStudent);
			ObjectOutputStream oosStudents = new ObjectOutputStream(fosStudents);
			for(int x = 0; x < getStudents().size(); x++) {
				oosStudents.writeObject(getStudents().get(x));
			}
			oosStudents.close();
		}
		catch(IOException e) {
			System.out.println("error 4.0");
			System.exit(1);
		}
	}
	
	public void saveCourses() {
		try {
			String fileNameCourse = "courses.txt";		
			FileOutputStream fosCourses = new FileOutputStream(fileNameCourse);
			ObjectOutputStream oosCourses= new ObjectOutputStream(fosCourses);
			
			for(int x = 0; x < getCourses().size(); x++) {
				oosCourses.writeObject(getCourses().get(x));
			}
			oosCourses.close();	
		}
		catch(IOException e) {
			System.out.println("error 5.0");
			System.exit(1);
		}
	}
	
	public void saveInstructors() {
		try {
			String fileNameInstructor = "instructors.txt";		
			FileOutputStream fosInstructors = new FileOutputStream(fileNameInstructor);
			ObjectOutputStream oosInstructors= new ObjectOutputStream(fosInstructors);
			for (int x = 0; x < getInstructors().size(); x++) {
				oosInstructors.writeObject(getInstructors().get(x));
			}
			oosInstructors.close();	
		}
		catch(IOException e) {
			System.out.println("error 6.0");
			System.exit(1);
		}
	}
	
	public void saveCourseAdmins() {
		try {
			String fileNameCourseAdmin = "courseadmins.txt";		
			FileOutputStream fosCourseAdmins = new FileOutputStream(fileNameCourseAdmin);
			ObjectOutputStream oosCourseAdmins= new ObjectOutputStream(fosCourseAdmins);
			
			for(int x = 0; x < courseAdmins.size(); x++) {
				oosCourseAdmins.writeObject(courseAdmins.get(x));
			}
			oosCourseAdmins.close();	
		}
		catch(IOException e) {
			System.out.println("error 7.0");
			System.exit(1);
		}
	}
	public void loadFromFile() {
		try {
			String fileNameStudent = "students.txt";		

			FileInputStream fisStudents = new FileInputStream(fileNameStudent);
			ObjectInputStream oisStudents = new ObjectInputStream(fisStudents);

			ArrayList<Student> tempStudents = new ArrayList<Student>();
			try {
				for(;;) {
					tempStudents.add((Student) oisStudents.readObject());
				}
			}
			catch(EOFException eof) {

			}
			this.setStudents(tempStudents);			
			oisStudents.close();
		}
		catch(FileNotFoundException fnf) {
			System.out.println("no Students found");
			//need to create file
			try {
				String fileNameStudent = "students.txt";		
				FileOutputStream fosStudents = new FileOutputStream(fileNameStudent);
				ObjectOutputStream oosStudents = new ObjectOutputStream(fosStudents);

				Student me = new Student("Mike", "H", "Lloyd", 1802066, null, 5);
				ArrayList<Student> tempStudents = new ArrayList<Student>();
				tempStudents.add(me);

				this.setStudents(tempStudents);
				for(int x = 0; x < this.getStudents().size(); x++) {
					oosStudents.writeObject(this.getStudents().get(x));
				}
				oosStudents.close();	
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		catch(IOException e) {
			System.out.println("error 0.1");
			System.exit(1);
		}
		catch(ClassNotFoundException cnf) {
			System.out.println("error 0.2");
			System.exit(1);
		}
		//loading courses from file
		try {
			String fileNameCourse = "courses.txt";
			ArrayList<Course> tempCourses = new ArrayList<Course>();
			FileInputStream fisCourses = new FileInputStream(fileNameCourse);
			ObjectInputStream oisCourses = new ObjectInputStream(fisCourses);

			try {
				for(;;) {

					tempCourses.add((Course) oisCourses.readObject());
				}
			}
			catch(EOFException eof) {

			}
			this.setCourses(tempCourses);
			oisCourses.close();
		}
		catch(FileNotFoundException fnf) {
			System.out.println("no Courses found");
			//need to create file
			try {
				String fileNameCourse = "courses.txt";		
				FileOutputStream fosCourses = new FileOutputStream(fileNameCourse);
				ObjectOutputStream oosCourses= new ObjectOutputStream(fosCourses);

				ArrayList<Course> tempCourse = new ArrayList<Course>();
				tempCourse.add(new Course("0", "Test", true, null));

				for (int x = 0; x < tempCourse.size(); x++) {
					oosCourses.writeObject(tempCourse.get(x));
				}
				this.setCourses(tempCourse);
				oosCourses.close();							
			}
			catch(IOException e) {
				System.out.println("error 1.0");
				System.exit(1);
			}
		}
		catch(IOException e) {
			System.out.println("error 1.1");
			System.exit(1);
		}
		catch(ClassNotFoundException cnf) {
			System.out.println("error 1.2");
			System.exit(1);
		}
		//loading instructors from file
		try {
			String fileNameInstructor = "instructors.txt";		
			ArrayList<Instructor> tempInstructors = new ArrayList<Instructor>();

			FileInputStream fisInstructors = new FileInputStream(fileNameInstructor);
			ObjectInputStream oisInstructors = new ObjectInputStream(fisInstructors);

			try {
				for(;;) {

					tempInstructors.add((Instructor) oisInstructors.readObject());
				}
			}
			catch(EOFException eof) {

			}

			this.setInstructors(tempInstructors);

			oisInstructors.close();
		}
		catch(FileNotFoundException fnf) {
			System.out.println("no Instructors found");
			//need to create file
			try {
				String fileNameInstructor = "instructors.txt";		
				FileOutputStream fosInstructors = new FileOutputStream(fileNameInstructor);
				ObjectOutputStream oosInstructors= new ObjectOutputStream(fosInstructors);

				ArrayList<Instructor> tempInstructor = new ArrayList<Instructor>();
				tempInstructor.add(new Instructor("Test", "Test", "Test", 9999999));
				for (int x = 0; x < tempInstructor.size(); x++) {
					oosInstructors.writeObject(tempInstructor.get(x));
				}
				this.setInstructors(tempInstructor);
				oosInstructors.close();
			}
			catch(IOException e) {
				System.out.println("error 2.0");
				System.exit(1);
			}
		}
		catch(IOException e) {
			System.out.println("error 2.1");
			System.exit(1);
		}
		catch(ClassNotFoundException cnf) {
			System.out.println("error 2.2");
			System.exit(1);
		}
		//loading course admins from file
		try {
			String fileNameCourseAdmin = "courseadmins.txt";		
			ArrayList<CourseAdmin> tempCourseAdmins = new ArrayList<CourseAdmin>();

			FileInputStream fisCourseAdmins = new FileInputStream(fileNameCourseAdmin);
			ObjectInputStream oisCourseAdmins = new ObjectInputStream(fisCourseAdmins);

			try {
				for(;;) {

					tempCourseAdmins.add((CourseAdmin) oisCourseAdmins.readObject());
				}
			}
			catch(EOFException eof) {

			}
			this.setCourseAdmins(tempCourseAdmins);
			oisCourseAdmins.close();
		}
		catch(FileNotFoundException fnf) {
			System.out.println("no CourseAdmins found");
			//need to create file
			try {
				String fileNameCourseAdmin = "courseadmins.txt";		
				FileOutputStream fosCourseAdmins = new FileOutputStream(fileNameCourseAdmin);
				ObjectOutputStream oosCourseAdmins= new ObjectOutputStream(fosCourseAdmins);

				ArrayList<CourseAdmin> tempCourseAdmin = new ArrayList<CourseAdmin>();
				tempCourseAdmin.add(new CourseAdmin("Admin", "0"));

				for(int x = 0; x < tempCourseAdmin.size(); x++) {
					oosCourseAdmins.writeObject(tempCourseAdmin.get(x));
				}
				this.setCourseAdmins(tempCourseAdmin);
				oosCourseAdmins.close();
			}
			catch(IOException e) {
				System.out.println("error 3.0");
				e.printStackTrace();
				System.exit(1);
			}
		}
		catch(IOException e) {
			System.out.println("error 3.1");
			System.exit(1);
		}
		catch(ClassNotFoundException cnf) {
			System.out.println("error 3.2");
			System.exit(1);
		}
	}
}
