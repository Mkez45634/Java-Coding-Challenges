package demo;

public class MainApp {

	public static void main(String[] args) {
		Course c = new Course("Comp Scie", "CS");
		Module m = new Module("OOP", "5CS019");
		Module m2 = new Module("Maths", "5CS021");
		
		c.addModule(m);
		c.addModule(m2);
		System.out.println(c.getModulesCount());
		c.getModuleAt(0).setId("Crazy");
		System.out.println(c.getModuleAt(0).getId());
		//System.out.println(c.getName());
		//System.out.println(c.getId());
		
		

	}

}
