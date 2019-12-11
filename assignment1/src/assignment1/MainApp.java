package assignment1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class MainApp {
	//read all the files from the stored files, set everything up.
	//then make a user interface
	//but every time the user changes a variable, call a store function, giving it parameters of class and the variable that got changed, to write to file the new variable	
	public static void main(String[] args) {	
		//loading students from file
		CourseManagementSystem CMS = new CourseManagementSystem();
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
			CMS.setStudents(tempStudents);			
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
				
				CMS.setStudents(tempStudents);
				for(int x = 0; x < CMS.getStudents().size(); x++) {
					oosStudents.writeObject(CMS.getStudents().get(x));
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
			CMS.setCourses(tempCourses);
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
				CMS.setCourses(tempCourse);
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
			
			CMS.setInstructors(tempInstructors);
			
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
				CMS.setInstructors(tempInstructor);
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
					CMS.setCourseAdmins(tempCourseAdmins);
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
						CMS.setCourseAdmins(tempCourseAdmin);
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
		 System.out.println("Hello world");	 
		 
		 Scanner s = new Scanner(System.in);
		 System.out.println("log in as:\n1. Course Admin\n2. Instructor\n3. Student");
		 int menuChoice = -1;
		 if(s.hasNextLine()) {
			 menuChoice = (int) Integer.parseInt(s.nextLine());
		 }
		 while(menuChoice<1 || menuChoice>3) {
			System.out.println("log in as:\n1. Course Admin\n2. Instructor\n3. Student");
			if(s.hasNextLine()) {
				 menuChoice = (int) Integer.parseInt(s.nextLine());
			}	 	
		 }
		 if (menuChoice == 1) {
			 
			 //listing all course admins so that they can 'login' as one
			 System.out.println("Number | Id | Name");
			 if (CMS.getCourseAdmins().size() != 0) {
				 for(int x = 0; x < CMS.getCourseAdmins().size(); x++) {
					 System.out.println(x + ". " + CMS.getCourseAdmins().get(x).getId() + " " +CMS.getCourseAdmins().get(x).getName());				 
				 }
			 }else {
				 System.out.println("error no admins found!");
			 }		
			 System.out.println("Please choose a course admin from the above list.");
			 if(s.hasNextLine()) {
				 menuChoice = (int) Integer.parseInt(s.nextLine());
			 }
			 while(menuChoice<0 || menuChoice>CMS.getCourseAdmins().size()) {
				 System.out.println("Please choose a course admin from the above list.");
				 if(s.hasNextLine()) {
					 menuChoice = (int) Integer.parseInt(s.nextLine());
				 }				 
			 }
			 String CAId = "" + menuChoice; //could save CourseAdmin object here instead?
			 //now for the CA menu
				 
				 System.out.println("1. add new course\n2. add module to course\n3. cancel a course\n4. reactivate course\n5. delete course\n6. edit course name\n7. edit module name\n8. generate report slip\n9. assign instructior to module\n10. exit");
				 int caMenuChoice = -1;
				 if(s.hasNextLine()) {
					 caMenuChoice = (int) Integer.parseInt(s.nextLine());
				 }		 
				 while(caMenuChoice<1 || caMenuChoice>10) {					 
					 System.out.println("1. add new course\n2. add module to course\n3. cancel a course\n4. reactivate course\n5. delete course\n6. edit course name\n7. edit module name\n8. generate report slip\n9. assign instructior to module\n10. exit");
					if(s.hasNextLine()) {
						 caMenuChoice = (int) Integer.parseInt(s.nextLine());
					}	 	
				 }
				 if(caMenuChoice == 1) {
					 int cMenuChoice = 0;
					 boolean cHidden = true;
					 int cId = 0;
					 String cName = "";
					 System.out.println("Name of course:");
					 if (s.hasNextLine()) {
						 cName = (String) s.nextLine();
					 }
					 System.out.println("Hide the course?\n1. yes\n2. no");
					 if(s.hasNextLine()) {
						 cMenuChoice = (int) Integer.parseInt(s.nextLine());
					 }
					 while(cMenuChoice<1 || cMenuChoice>2) {
						 
						 System.out.println("Hide the course?\n1. yes\n2. no");
						 try {
							if(s.hasNextLine()) {
								cMenuChoice = (int) Integer.parseInt(s.nextLine());
							}
						 }catch (InputMismatchException e) {
							 s.hasNext();
						 }
					 }					
					 if (cMenuChoice == 1) {
						 cHidden = true;							
					 }else if(cMenuChoice == 2) {
						 cHidden = false;
					 }
					 System.out.println("course id");
					 if(s.hasNextLine()) {
						 cId = (int) Integer.parseInt(s.nextLine());
					 }
					 
					//make a new course
					CMS.getCourseAdmins().get(Integer.parseInt(CAId)).newCourse(""+cId, cName, cHidden, null, CMS);
					System.out.println("Added Course: id " + cId + " name " + cName + " hidden " + cHidden);
					CMS.saveCourses();
					
				}else if(caMenuChoice == 2) {

					 int mMenuChoice = 0;
					 
					 String mName = "";
					 String mId = "";
					 int semester = 0;
					 int level = 0;
					 boolean optional = false;
					 System.out.println("Name of module:");
					 if(s.hasNextLine()) {
						 mName = (String) s.nextLine();
					 }
					 System.out.println("Id of module:");
					 if(s.hasNextLine()) {
						 mId = (String) s.nextLine();
					 }
					 System.out.println("Semester of module: ");
					 if(s.hasNextLine()) {
						 semester = (int) Integer.parseInt(s.nextLine());
					 }
					 while(semester<1 || semester>3) {
						 System.out.println("Semester of module:  ");
						if(s.hasNextLine()) {
							semester = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }	
					 System.out.println("Level of module: ");
					 if(s.hasNextLine()) {
						 level = (int) Integer.parseInt(s.nextLine());
					 }
					 while(level<3 || level>7) {
						 System.out.println("Level of module:  ");
						if(s.hasNextLine()) {
							level = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 System.out.println("is the module optional?\n1. yes\n2.no ");
					 if(s.hasNextLine()) {
						 mMenuChoice = (int) Integer.parseInt(s.nextLine());
					 }
					 while(mMenuChoice<1 || mMenuChoice>2) {
						 System.out.println("is the module optional?\\n1. yes\\n2.no ");
						if(s.hasNextLine()) {
							mMenuChoice = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 if (mMenuChoice == 1) {optional = true;}
					 
					 System.out.println("Which course?");
					 for(int x = 0; x < CMS.getCourses().size(); x++) {
						 System.out.println(x + ". " + CMS.getCourses().get(x).getName());
					 }
 					 int mCourse = 0;
					 if(s.hasNextLine()) {
						 mCourse = (int) Integer.parseInt(s.nextLine());
					 }
					 while(mCourse<0 || mCourse>CMS.getCourses().size()) {
						System.out.println("Which course?");
						if(s.hasNextLine()) {
							mCourse = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 
					 ArrayList<Module> tempModules = new ArrayList<Module>();
					 tempModules = CMS.getCourses().get(mCourse).getCourseModule();
					 tempModules.add(new Module(mName, mId, semester, level, optional));
					 CMS.getCourses().get(mCourse).setCourseModule(tempModules);
					 CMS.saveCourses();					 
					 
					
				}else if(caMenuChoice == 3) {
					for(int x = 0; x < CMS.getCourses().size(); x++) {
						System.out.println(x + ". " + CMS.getCourses().get(x));
					}

					 int hMenuChoice = -1;
					 
					 System.out.println("Pick a course");
					 if(s.hasNextLine()) {
						 hMenuChoice = Integer.parseInt(s.nextLine());
					 }
					 while(hMenuChoice<0 || hMenuChoice>CMS.getCourses().size()) {
						 System.out.println("Pick a course");
						if(s.hasNextLine()) {
							hMenuChoice = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 
					 CMS.getCourses().get(hMenuChoice).setHidden(true);
					 CMS.saveCourses();
					 
					 
				}else if(caMenuChoice == 4) {
					
					for(int x = 0; x < CMS.getCourses().size(); x++) {
						System.out.println(x + ". " + CMS.getCourses().get(x));
					}
;
					 int rMenuChoice = 0;
					 
					 System.out.println("Pick a course");
					 if(s.hasNextLine()) {
						 rMenuChoice = Integer.parseInt(s.nextLine());
					 }
					 while(rMenuChoice<0 || rMenuChoice>CMS.getCourses().size()) {
						 System.out.println("Pick a course");
						if(s.hasNextLine()) {
							rMenuChoice = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 
					 CMS.getCourses().get(rMenuChoice).setHidden(false);
					 CMS.saveCourses();
					 
					 
					
				}else if(caMenuChoice == 5) {
					
					for(int x = 0; x < CMS.getCourses().size(); x++) {
						System.out.println(x + ". " + CMS.getCourses().get(x));
					}
					 int dMenuChoice = 0;
					 
					 System.out.println("Pick a course");
					 if(s.hasNextLine()) {
						 dMenuChoice = Integer.parseInt(s.nextLine());
					 }
					 while(dMenuChoice<0 || dMenuChoice>CMS.getCourses().size()) {
						 System.out.println("Pick a course");
						if(s.hasNextLine()) {
							dMenuChoice = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 
					 CMS.getCourses().remove(dMenuChoice);
					 CMS.saveCourses();
					 
					 
					
					
				}else if(caMenuChoice == 6) {
					
					for(int x = 0; x < CMS.getCourses().size(); x++) {
						System.out.println(x + ". " + CMS.getCourses().get(x).getName());
					}
					 int enMenuChoice = 0;
					 
					 System.out.println("Pick a course");
					 if(s.hasNextLine()) {
						 enMenuChoice = Integer.parseInt(s.nextLine());
					 }
					 while(enMenuChoice<0 || enMenuChoice>CMS.getCourses().size()) {
						 System.out.println("Pick a course");
						if(s.hasNextLine()) {
							enMenuChoice = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 String newName = "";
					 System.out.println("What should the new name be?");
					 if(s.hasNextLine()) {
						 newName = s.nextLine();
					 }
					 
					 CMS.getCourses().get(enMenuChoice).setName(newName);
					 CMS.saveCourses();
					 
					 
					
				}else if(caMenuChoice == 7) {
					int count = 0;
					for(int x = 0; x < CMS.getCourses().size(); x++) {
						for(int y = 0; y <  CMS.getCourses().get(x).getCourseModule().size(); y++) {
							count++;
							System.out.println(count + ". " + CMS.getCourses().get(x).getCourseModule().get(y).getName());
						}
					}

					 int enMenuChoice = 0;
					 
					 System.out.println("Pick a module");
					 if(s.hasNextLine()) {
						 enMenuChoice = Integer.parseInt(s.nextLine());
					 }
					 while(enMenuChoice<0 || enMenuChoice>count) {
						 System.out.println("Pick a module");
						if(s.hasNextLine()) {
							enMenuChoice = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 String newName = "";
					 System.out.println("What should the new name be?");
					 if(s.hasNextLine()) {
						 newName = s.nextLine();
					 }
					 count = 0;
					 for(int x = 0; x < CMS.getCourses().size(); x++) {
							for(int y = 0; y <  CMS.getCourses().get(x).getCourseModule().size(); y++) {
								count++;
								if (count == enMenuChoice) {
									CMS.getCourses().get(count).setName(newName);
								}
							}
					 }
					 CMS.saveCourses();
					 
					 
					
				}else if(caMenuChoice == 8) {
					
					 int sPick = 0;
					 
					 for(int x = 0; x < CMS.getStudents().size(); x++) {
						 System.out.println(x + ". " + CMS.getStudents().get(x));
					 }
					 
					 System.out.println("Pick a student");
					 if(s.hasNextLine()) {
						 sPick = Integer.parseInt(s.nextLine());
					 }
					 while(sPick<0 || sPick>CMS.getStudents().size()) {
						 System.out.println("Pick a student");
						if(s.hasNextLine()) {
							sPick = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 
					 int SorY = 0;
					 System.out.println("1. Semester 1\n2. Semester 2\n3. The whole year?");
					 if(s.hasNextLine()) {
						 SorY = Integer.parseInt(s.nextLine());
					 }
					 while(SorY<1 || SorY>3) {
						 System.out.println("1. Semester 1\\n2. Semester 2\\n3. The whole year?");
						if(s.hasNextLine()) {
							SorY = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 
					 for(int y = 0; y < CMS.getCourseAdmins().size(); y++) {
						 if (CMS.getCourseAdmins().get(y) == CMS.getCourseAdmins().get(Integer.parseInt(CAId))) {
							 if(SorY == 3) {
							 	CMS.getCourseAdmins().get(y).generateReport(CMS.getStudents().get(sPick), "year");
							 }else {
								 CMS.getCourseAdmins().get(y).generateReport(CMS.getStudents().get(sPick), "" + SorY);
							 }
						 }
						 
					 }
					 
					 CMS.saveStudents();
					
					 
				}else if (caMenuChoice == 9) {
					System.out.println("Number | Id | Name");
					 if (CMS.getInstructors().size() != 0) {
						 for(int x = 0; x < CMS.getInstructors().size(); x++) {
							 System.out.println(x + ". " + CMS.getInstructors().get(x).getId() + " " +CMS.getInstructors().get(x).getFirstName() + " " +CMS.getInstructors().get(x).getLastName());				 
						 }
					 }else {
						 System.out.println("error no instructors found!");
					 }		
					 System.out.println("Please choose a instructor from the above list.");
					 try {
						 if(s.hasNextLine()) {
							 menuChoice = (int) Integer.parseInt(s.nextLine());
						 }
					 }catch(InputMismatchException e) {
						 s.next();
					 }
					 while(menuChoice<0 || menuChoice>CMS.getInstructors().size()) {
						 System.out.println("Please choose a instructor from the above list.");
						 if(s.hasNextLine()) {
							 menuChoice = (int) Integer.parseInt(s.nextLine());
						 }				 
					 }
					 
					 int chosenInstructor = menuChoice;
					 int count = 0;
						for(int x = 0; x < CMS.getCourses().size(); x++) {
							for(int y = 0; y <  CMS.getCourses().get(x).getCourseModule().size(); y++) {
								count++;
								System.out.println(count + ". " + CMS.getCourses().get(x).getCourseModule().get(y).getName());
							}
						}
					 System.out.println("Pick a module");
					 if(s.hasNextLine()) {
						 menuChoice = Integer.parseInt(s.nextLine());
					 }
					 while(menuChoice<0 || menuChoice>count) {
						 System.out.println("Pick a module");
						if(s.hasNextLine()) {
							menuChoice = (int) Integer.parseInt(s.nextLine());
						}	 	
					 }
					 
					 
					 count = 0;
						for(int x = 0; x < CMS.getCourses().size(); x++) {
							for(int y = 0; y <  CMS.getCourses().get(x).getCourseModule().size(); y++) {
								count++;
								if(count == menuChoice) {
									CMS.getCourses().get(x).getCourseModule().get(y).setInstructor(CMS.getInstructors().get(chosenInstructor));
								}
							}
						}
						
					
				}else if(caMenuChoice == 10) {
					System.out.println("Logging you out...");
				}
				 
				 
			 
		 }else if (menuChoice == 2) {
			 System.out.println("Number | Id | Name");
			 if (CMS.getInstructors().size() != 0) {
				 for(int x = 0; x < CMS.getInstructors().size(); x++) {
					 System.out.println(x + ". " + CMS.getInstructors().get(x).getId() + " " +CMS.getInstructors().get(x).getFirstName() + " " +CMS.getInstructors().get(x).getLastName());				 
				 }
			 }else {
				 System.out.println("error no instructors found!");
			 }		
			 System.out.println("Please choose a instructor from the above list.");
			 if(s.hasNextLine()) {
				 menuChoice = (int) Integer.parseInt(s.nextLine());
			 }
			 while(menuChoice<0 || menuChoice>CMS.getInstructors().size()) {
				 System.out.println("Please choose a instructor from the above list.");
				 if(s.hasNextLine()) {
					 menuChoice = (int) Integer.parseInt(s.nextLine());
				 }				 
			 }
			 
			 String iId = "" + menuChoice; //could save instructor object here instead?
			 
			 //instructor menu
			 System.out.println("1. view assigned modules\n2. view student on a given module\n3. assign a student's marks");
			 if(s.hasNextLine()) {
				 menuChoice = (int) Integer.parseInt(s.nextLine());
			 }
			 while(menuChoice<1 || menuChoice>3) {
				 System.out.println("1. view assigned modules\\n2. view student on a given module\\n3. assign a student's marks");
				 if(s.hasNextLine()) {
					 menuChoice = (int) Integer.parseInt(s.nextLine());
				 }				 
			 }
			 
			 if(menuChoice == 1) {
				 for(int x = 0; x < CMS.getCourses().size(); x++) {
						for(int y = 0; y <  CMS.getCourses().get(x).getCourseModule().size(); y++) {
							if(("" + CMS.getCourses().get(x).getCourseModule().get(y).getInstructor().getId()).equals(iId)) {
								System.out.println(CMS.getCourses().get(x).getCourseModule().get(y).getName());
							}
						}
					}
				 
			 }else if(menuChoice == 2) {
				 ArrayList<Module> assignedModules = new ArrayList<Module>();
				 for(int x = 0; x < CMS.getCourses().size(); x++) {
						for(int y = 0; y <  CMS.getCourses().get(x).getCourseModule().size(); y++) {
							if(("" + CMS.getCourses().get(x).getCourseModule().get(y).getInstructor().getId()).equals(iId)) {
								assignedModules.add(CMS.getCourses().get(x).getCourseModule().get(y));
							}
						}
					}
				 for (int z = 0; z < assignedModules.size(); z++) {
					 System.out.println( assignedModules.get(z).getName());
				 }
				 
				 System.out.println("Pick a module");
				 if(s.hasNextLine()) {
					 menuChoice = Integer.parseInt(s.nextLine());
				 }
				 while(menuChoice<0 || menuChoice>assignedModules.size()) {
					 System.out.println("Pick a module");
					if(s.hasNextLine()) {
						menuChoice = (int) Integer.parseInt(s.nextLine());
					}	 	
				 }
				 
				 for (int i = 0; i < CMS.getStudents().size(); i++) {
					 for(int j = 0; j < CMS.getStudents().get(i).getEnrolledModules().getModules().size(); j++) {
						 if (("" + CMS.getStudents().get(i).getEnrolledModules().getModules().get(j).getInstructor().getId()).equals(iId)) {
							 System.out.println(CMS.getStudents().get(i).getId() + " " + CMS.getStudents().get(i).getLastName() + ", " + CMS.getStudents().get(i).getFirstName());
						 }
					 }
					 
				 }
				 
			 }else if(menuChoice == 3)	{
				 ArrayList<Module> assignedModules = new ArrayList<Module>();
				 for(int x = 0; x < CMS.getCourses().size(); x++) {
						for(int y = 0; y <  CMS.getCourses().get(x).getCourseModule().size(); y++) {
							if(("" + CMS.getCourses().get(x).getCourseModule().get(y).getInstructor().getId()).equals(iId)) {
								assignedModules.add(CMS.getCourses().get(x).getCourseModule().get(y));
							}
						}
					}
				 for (int z = 0; z < assignedModules.size(); z++) {
					 System.out.println( assignedModules.get(z).getName());
				 }
				 
				 System.out.println("Pick a module");
				 if(s.hasNextLine()) {
					 menuChoice = Integer.parseInt(s.nextLine());
				 }
				 while(menuChoice<0 || menuChoice>assignedModules.size()) {
					 System.out.println("Pick a module");
					if(s.hasNextLine()) {
						menuChoice = (int) Integer.parseInt(s.nextLine());
					}	 	
				 }
				 
				 int moduleChoice = menuChoice;
				 
				 int count = 0;
				 for (int i = 0; i < CMS.getStudents().size(); i++) {
					 for(int j = 0; j < CMS.getStudents().get(i).getEnrolledModules().getModules().size(); j++) {
						 if (("" + CMS.getStudents().get(i).getEnrolledModules().getModules().get(j).getInstructor().getId()).equals(iId)) {
							 System.out.println(CMS.getStudents().get(i).getId() + " " + CMS.getStudents().get(i).getLastName() + ", " + CMS.getStudents().get(i).getFirstName());
							 count++;							 
						 }
					 }
					 
				 }
				 System.out.println("Pick a student");
				 if(s.hasNextLine()) {
					 menuChoice = Integer.parseInt(s.nextLine());
				 }
				 while(menuChoice<0 || menuChoice>count) {
					 System.out.println("Pick a student");
					if(s.hasNextLine()) {
						menuChoice = (int) Integer.parseInt(s.nextLine());
					}	 	
				 }
				 
				 int chosenStudent = menuChoice;
				 
				 System.out.println("give them a mark");
				 if(s.hasNextLine()) {
					 menuChoice = Integer.parseInt(s.nextLine());
				 }
				 count = 0;
				 for (int i = 0; i < CMS.getStudents().size(); i++) {
					 for(int j = 0; j < CMS.getStudents().get(i).getEnrolledModules().getModules().size(); j++) {
						 if (("" + CMS.getStudents().get(i).getEnrolledModules().getModules().get(j).getInstructor().getId()).equals(iId)) {
							 count++;
							 if (count == chosenStudent) {
								 for(int k = 0; k < CMS.getStudents().get(i).getEnrolledModules().getModules().size(); k++) {
									 if (CMS.getStudents().get(i).getEnrolledModules().getModules().get(k) == assignedModules.get(moduleChoice)) {
										 int[] tempMarks = new int[8];
										 tempMarks = CMS.getStudents().get(i).getEnrolledModules().getMarks();
										 tempMarks[k] = menuChoice;
										 CMS.getStudents().get(i).getEnrolledModules().setMarks(tempMarks);
										 CMS.saveStudents();
									 }
								 }
							 }
						 }
					 }
					 
				 }
				 
			 }
			 
			 
			 
		 }else if(menuChoice == 3) {
			 System.out.println("Number | Id | Name");
			 if (CMS.getStudents().size() != 0) {
				 for(int x = 0; x < CMS.getStudents().size(); x++) {
					 System.out.println(x + ". " + CMS.getStudents().get(x).getId() + " " +CMS.getStudents().get(x).getFirstName() + " " +CMS.getStudents().get(x).getLastName());				 
				 }
			 }else {
				 System.out.println("error no student found!");
			 }		
			 System.out.println("Please choose a student from the above list.");
			 if(s.hasNextLine()) {
				 menuChoice = (int) Integer.parseInt(s.nextLine());
			 }
			 while(menuChoice<0 || menuChoice>CMS.getStudents().size()) {
				 System.out.println("Please choose a student from the above list.");
				 if(s.hasNextLine()) {
					 menuChoice = (int) Integer.parseInt(s.nextLine());
				 }				 
			 }
			 
			 String sId = "" + menuChoice;	//could save student object here instead?
			 
			//student menu
			 System.out.println("1. choose a course to enroll on\n2. enroll of the mandatory modules for that course\n3. choose optional modules\n4. view modules and the teacher assigned to it");
			 if(s.hasNextLine()) {
				 menuChoice = (int) Integer.parseInt(s.nextLine());
			 }
			 while(menuChoice<1 || menuChoice>4) {
				 System.out.println("1. choose a course to enroll on\\n2. enroll of the mandatory modules for that course\\n3. choose optional modules\\n4. view modules and the teacher assigned to it");
				 if(s.hasNextLine()) {
					 menuChoice = (int) Integer.parseInt(s.nextLine());
				 }				 
			 }
			 
			 if(menuChoice == 1) {
				 for(int y = 0; y < CMS.getStudents().size(); y++) {
					 if (("" + CMS.getStudents().get(y).getId()).equals(sId)) {
						 CMS.getStudents().get(y).chooseCourse(CMS);
					 }
				 }
				 
			 }else if (menuChoice == 2) {
				 for(int y = 0; y < CMS.getStudents().size(); y++) {
					 if (("" + CMS.getStudents().get(y).getId()).equals(sId)) {
						 CMS.getStudents().get(y).enrollMandatoryModules();
					 }
				 }
				 				 
			 }else if (menuChoice == 3) {			 
				 ArrayList<Module> tempMod = new ArrayList<Module>();
				 for(int y = 0; y < CMS.getStudents().size(); y++) {
					 if (("" + CMS.getStudents().get(y).getId()).equals(sId)) {
						 for(int z = 0; z < CMS.getStudents().get(y).getCourse().getCourseModule().size(); z++) {
							 if(CMS.getStudents().get(y).getCourse().getCourseModule().get(z).getOptional() == true) {
								 tempMod.add(CMS.getStudents().get(y).getCourse().getCourseModule().get(z));
							 }
						 }
					 }
				 }
				 
				 for(int i = 0; i < tempMod.size(); i++) {
					 System.out.println(i + ". " + tempMod.get(i).getName());
				 }
				 
				 System.out.println("Please choose a module from the above list.");
				 if(s.hasNextLine()) {
					 menuChoice = (int) Integer.parseInt(s.nextLine());
				 }
				 while(menuChoice<0 || menuChoice>tempMod.size()) {
					 System.out.println("Please choose a module from the above list.");
					 if(s.hasNextLine()) {
						 menuChoice = (int) Integer.parseInt(s.nextLine());
					 }				 
				 }
				 
				 Module mod1 = tempMod.get(menuChoice);
				 
				 for(int i = 0; i < tempMod.size(); i++) {
					 System.out.println(i + ". " + tempMod.get(i).getName());
				 }
				 
				 System.out.println("Please choose a second module from the above list.");
				 if(s.hasNextLine()) {
					 menuChoice = (int) Integer.parseInt(s.nextLine());
				 }
				 while((menuChoice<0 || menuChoice>tempMod.size()) && tempMod.get(menuChoice) == mod1) {
					 System.out.println("Please choose a second module from the above list.");
					 if(s.hasNextLine()) {
						 menuChoice = (int) Integer.parseInt(s.nextLine());
					 }				 
				 }
				 for(int y = 0; y < CMS.getStudents().size(); y++) {
					 if (("" + CMS.getStudents().get(y).getId()).equals(sId)) {
						 CMS.getStudents().get(y).enrollOptionalModules(mod1, tempMod.get(menuChoice));
					 }
				 }
				 
			 }else if (menuChoice == 4) {
				 
				 for(int y = 0; y < CMS.getStudents().size(); y++) {
					 if (("" + CMS.getStudents().get(y).getId()).equals(sId)) {
						 for (int z = 0; z < CMS.getStudents().get(y).getEnrolledModules().getModules().size(); z++) {
							 System.out.println(CMS.getStudents().get(y).getEnrolledModules().getModules().get(z).getName() 
									 + " " + CMS.getStudents().get(y).getEnrolledModules().getModules().get(z).getInstructor().getLastName() 
									 + ", " + CMS.getStudents().get(y).getEnrolledModules().getModules().get(z).getInstructor().getFirstName());
						 }
					 }
				 }
				 
				 
			 }
			 
			 
		 }else {
			 System.out.println("Something is very wrong...");
			 
			 System.exit(1);
		 }
		 
		 s.close();
		 System.exit(0);
	}
}
