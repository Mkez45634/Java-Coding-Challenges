package students;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// using an ArrayList collect many students
public class StudentList {

	private ArrayList<Student> studentList;

	// create an empty arraylist
	public StudentList() {
		// your code goes here
		studentList = new ArrayList<Student>();
	}

	// add a student s to the collection
	public void add(Student s) {
		// your code goes here
		if (s == null) {
			return;
		}
		for (int x = 0; x < studentList.size(); x++) {
			if (studentList.get(x).getId() == s.getId()) {
				return;
			}
		}

		studentList.add(s);
	}

	// returns a report with one line per person
	// traverses the array list,
	// getting one element at a time
	public String getAllStudents() {
		// your code goes here
		// use for each loop
		String report = "";
		for (Student s : studentList) {
			report += s.getId() + " " + s.getName().getFirstAndLastName() + " " + s.getQualDetails() + " " + s.getYear() + ".\n";
		}
		return report;
	}

	// returns the number of elements in the list
	public int getSize() {
		// your code goes here
		return studentList.size();
	}

	// returns the Student object at specified index position
	public Student getAtIndex(int index) {

		return studentList.get(index);// your code goes here
	}

	// returns the Student object with a specified id
	// searches through the array
	// and stopping by returning when a match is found
	public Student findById(String id) {
		// your code goes here
		for (Student s : studentList) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}

	// counts the number of people in a specified year
	// demonstrates making a count with arraylists
	public int getCountOfPeopleAtYear(int year) {
		// your code goes here
		int count = 0;
		for (Student s : studentList) {
			if (s.getYear() == year) {
				count++;
			}
		}
		return count;
	}

	// works out how many people in each year,
	// then creates and returns a report
	//
	// demonstrates calculating a frequency report
	// i.e. how often each year occurs
	// it uses the value of the year as an index
	public String getYearsFrequencyReport() {
		// work out max year
		int maxYear = getMaxYear();
		// work out how many people at each year
		// your code goes here
		String report = "";
		int[] frequency = new int[maxYear];
		// for each student in the array
		for (Student s : studentList) {
			// get their year and increase the the frequency
			frequency[s.getYear()-1]++; //zero indexed
		}
		
		for(int i = 0; i < maxYear; i++) {
			report += "Year " + (i+1) + ": " + frequency[i] + " Students Registered. \n";
		}
		return report;
	}

	// calculates the maximum year that anyone is in
	// demonstrates finding a max with array lists
	public int getMaxYear() {
		// your code here
		int maxYear = 0;
		for (Student s : studentList) {
			if (s.getYear() > maxYear) {
				maxYear = s.getYear();
			}
		}

		return maxYear;
	}

	/**
	 * writes supplied text to file
	 * 
	 * @param filename the name of the file to be written to
	 * @param report   the text to be written to the file
	 */
	public void writeToFile(String filename, String report) {

		FileWriter fw;
		// your code here
		// catch the following exceptions FileNotFound, and IOException
		BufferedWriter bw;

		try {
			fw = new FileWriter(filename, false);
			bw = new BufferedWriter(fw);

			bw.write(report);

			bw.close();
			fw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//make a new file called StudentOut.txt aka filename
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * reads file with given name, extracting student data, creating student objects
	 * and adding them to the list of students Blank lines are skipped 
	 * Validation for integer year, missing items
	 * 
	 * @param filename the name of the input file
	 * @throws Exception
	 */
	public void readFile(String filename) throws Exception {
		String line;
		//String[] values;
		//String[] quals;

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			while ((line = br.readLine()) != null) {
				if (line != "") {
					processLine(line);
//					values = line.split(",");
//					// 0 is ID, 1 is name, 2 is year, 3+ is quals
//					try {
//						Integer.parseInt(values[2]);
//						// 2 is a year
//					} catch (NumberFormatException e) {
//						// 2 is a qual, not a year
//						throw new Exception("missing year");
//					}
//
//					if (values[3] == "") {
//						throw new Exception("missing quals");
//					}
//
//					if (values.length > 3) {
//						quals = new String[values.length];
//						for (int x = 0; x < values.length; x++) {
//							quals[x] = values[x + 4];
//						}
//						add(new Student(values[0], new Name(values[1]), quals, Integer.parseInt(values[2])));
//					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Processes line, extracts data, creates Student object and adds to list Checks
	 * for non-numeric year and missing items Will still crash if name entered
	 * without a space
	 * 
	 * @param line - the line to be processed
	 */
	private void processLine(String line) {
		try {
			String parts[] = line.split(",");
			Name name = new Name(parts[1]);
			String id = parts[0];
			String yearNum = parts[2];
			yearNum = yearNum.trim(); // remove any spaces
			int year = Integer.parseInt(yearNum);

			// the qualifications are at the end of the line
			int qualLength = parts.length - 3;
			String quals[] = new String[qualLength];
			System.arraycopy(parts, 3, quals, 0, qualLength);

			// create Student object and add to the list
			Student s = new Student(id, name, quals, year);
			this.add(s);
		}

	// for these two formatting errors, ignore lines in error and try and carry on

		// this catches trying to convert a String to an integer
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '" + line + "'                 - " + nfe.getMessage();
			System.out.println(error);
		}
		// this catches missing items if only one or two items
		// other omissions will result in other errors
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in  : '" + line + "' index position : " + air.getMessage();
			System.out.println(error);
		}
	
	}
}
