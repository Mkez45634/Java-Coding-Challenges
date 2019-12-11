package assignment1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUIApp {

	public static void main(String[] args) {
		//loading students from file
		CourseManagementSystem CMS = new CourseManagementSystem();
		CMS.loadFromFile();
		System.out.println("Hello world");	 
		//code goes here
		
		JFrame f = new JFrame("Course Management System");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		DefaultListModel<String> cal1 = new DefaultListModel<>();
		for(CourseAdmin ca : CMS.getCourseAdmins()) {
			cal1.addElement(ca.getName());
		}
		JList<String> calist = new JList<>(cal1);
		calist.setBounds(240, 130, 150, (20*CMS.getCourseAdmins().size()));
		calist.setVisible(false);
		
		DefaultListModel<String> sl1 = new DefaultListModel<>();
		for(Student s : CMS.getStudents()) {
			sl1.addElement(s.getFirstName()+" "+s.getLastName());
		}
		JList<String> slist = new JList<>(cal1);
		slist.setBounds(240, 130, 150, (20*CMS.getStudents().size()));
		slist.setVisible(false);
		
		DefaultListModel<String> il1 = new DefaultListModel<>();
		for(Instructor i : CMS.getInstructors()) {
			il1.addElement(i.getFirstName()+" "+i.getLastName());
		}
		JList<String> ilist = new JList<>(cal1);
		ilist.setBounds(240, 130, 150, (20*CMS.getInstructors().size()));
		ilist.setVisible(false);
		
		DefaultListModel<String> sll1 = new DefaultListModel<>();
		JList<String> selectlist = new JList<>(sll1);
		selectlist.setVisible(false);
		
		JLabel login = new JLabel ("Please pick user type to login as.");
		login.setBounds(20,20, 200, 40);
		
		JTextArea menuDisplay = new JTextArea("");
		menuDisplay.setBounds(240, 160, 250, 40);
		menuDisplay.setVisible(false);
		
		JButton menuButton = new JButton("Next");
		
		String camenu1 = "Add new course";
		String newCourse[] = new String[3];
		for(int x = 0; x < 3; x++) {
			newCourse[x] = "";
		}
		ArrayList<Course> tempCourseList = new ArrayList<>();
		String camenu2 = "Add module to a course";
		String newModule[] = new String[6];
		for(int x = 0; x < 3; x++) {
			newModule[x] = "";
		}
		ArrayList<Module> tempModuleList = new ArrayList<>();
		DefaultListModel<String> sll2 = new DefaultListModel<>();
		JList<String> selectlist2 = new JList<>(sll2);
		selectlist2.setVisible(false);
		String camenu3 = "Cancel a course";
		String camenu4 = "Reactivate a course";
		String camenu5 = "Delete a course";
		String camenu6 = "Edit course name";
		String camenu7 = "Edit module name";
		String camenu8 = "Generate report slip";
		String camenu9 = "Assign instuctor to module";
		
		ActionListener buttonPressedList = new ActionListener() {public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Course Admin") {
				//set calist to visible
				calist.setVisible(true);
			}else if (e.getActionCommand() == "Student") {
				slist.setVisible(true);
			}else if (e.getActionCommand() == "Instructor") {
				ilist.setVisible(true);
			}else if (e.getActionCommand() == "Confirm") {
				if (calist.isVisible()) {
					calist.setVisible(false);
					sll1.addElement(camenu1);
					sll1.addElement(camenu2);
					sll1.addElement(camenu3);
					sll1.addElement(camenu4);
					sll1.addElement(camenu5);
					sll1.addElement(camenu6);
					sll1.addElement(camenu7);
					sll1.addElement(camenu8);
					sll1.addElement(camenu9);
					selectlist.setBounds(240, 130, 180, (20*9));
					selectlist.setVisible(true);
				}else if (slist.isVisible()) {
					slist.setVisible(false);
				}else if (ilist.isVisible()) {
					ilist.setVisible(false);
				}else if(selectlist.isVisible()) {
					//means we need to look at what is highlighted and do something based on that
					selectlist.setVisible(false);
					if (selectlist.getSelectedValue() == camenu1) {
						//name course, hide it and id
						menuButton.setVisible(true);
						menuDisplay.setVisible(true);
						menuDisplay.setText("What do you wish to name the course?");					
					}else if(selectlist.getSelectedValue() == camenu2) {
						//list all courses, then make a new module to add to it
						int options;
						if (CMS.getCourses().size() != 0) {
							options = 0;
							for (Course c : CMS.getCourses()) {
								sll2.addElement(c.getName());
								options++;
							} 
						}else {
							sll2.addElement("No courses found!");
							options = 1;
						}
						selectlist2.setBounds(240, 130, 180, (20*options));
						selectlist2.setVisible(true);
					}else if (selectlist.getSelectedValue() == camenu3) {
						
					}else if (selectlist.getSelectedValue() == camenu4) {
						
					}else if (selectlist.getSelectedValue() == camenu5) {
						
					}else if (selectlist.getSelectedValue() == camenu6) {
						
					}else if (selectlist.getSelectedValue() == camenu7) {
						
					}else if (selectlist.getSelectedValue() == camenu8) {
						
					}else if (selectlist.getSelectedValue() == camenu9){
						
					}
				}else if (selectlist2.isVisible()) {
					for(Course c: CMS.getCourses()){
						if (selectlist2.getSelectedValue() == c.getName()) {
							newModule[5] = c.getId();
						}
					}
					menuButton.setVisible(true);
					menuDisplay.setVisible(true);
					menuDisplay.setText("What do you wish to name the module?");
					
				}		
			}else if(e.getActionCommand() == "Next"){
				if (selectlist.getSelectedValue() == camenu1) {
					if (newCourse[0] == "") {
						newCourse[0] = menuDisplay.getText();
						menuDisplay.setText("Should the course be hidden (true/false)");
					}else if (newCourse[1] == "") {
						newCourse[1] = menuDisplay.getText();
						menuDisplay.setText("What is the id of the course?");
					}else if (newCourse[2] == "") {
						newCourse[2] = menuDisplay.getText();
						menuButton.setVisible(false);
						menuDisplay.setVisible(false);
						for(Course c : CMS.getCourses()) {
							tempCourseList.add(c);
						}
						if (newCourse[2] == "true") {
							tempCourseList.add(new Course(newCourse[0], newCourse[1], true, null));
						}else {
							tempCourseList.add(new Course(newCourse[0], newCourse[1], false, null));
						}
						CMS.setCourses(tempCourseList);
						CMS.saveCourses();
						menuButton.setVisible(false);
						menuDisplay.setVisible(false);
						calist.setVisible(true);
						for(int x = 0; x < 3; x++) {
							newCourse[x] = "";
						}
					}
				}else if(selectlist.getSelectedValue() == camenu2) {
					if(newModule[0] == "") {
						newModule[0] = menuDisplay.getText();
						menuDisplay.setText("what is the id of the module?");
					}else if (newModule[1] == "") {
						
					}
					
				}
			}
		}
		};
		
		
		JButton cab = new JButton("Course Admin");
		cab.setBounds(20, 80, 150, 40);
		cab.addActionListener(buttonPressedList);
		
		JButton sb = new JButton("Student");
		sb.setBounds(20, 120, 150, 40);
		sb.addActionListener(buttonPressedList);	
		
		JButton ib = new JButton("Instructor");
		ib.setBounds(20, 160, 150, 40);
		ib.addActionListener(buttonPressedList);	
		
		JButton selectLogin = new JButton("Confirm");
		selectLogin.setBounds(240, 80, 150, 40);
		selectLogin.addActionListener(buttonPressedList);	
		
		menuButton.setBounds(240, 120, 150, 40);
		menuButton.addActionListener(buttonPressedList);
		menuButton.setVisible(false);
		
		f.add(login); f.add(cab); f.add(sb); f.add(ib); f.add(selectLogin); f.add(calist); f.add(selectlist); f.add(menuButton); f.add(menuDisplay); f.add(selectlist2);
		
		f.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
		f.setLayout(null);
		f.setVisible(true);
				
		

	}

}
