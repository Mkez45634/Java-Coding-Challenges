package students;

public class MainApp {
	public static void main(String[] args) throws Exception {
		StudentList sl = new StudentList();
		sl.readFile("StudentList.csv");
		System.out.println(sl.getYearsFrequencyReport() + sl.getAllStudents());
		sl.writeToFile("StudentOut.txt", sl.getYearsFrequencyReport() + sl.getAllStudents());
	}
}
