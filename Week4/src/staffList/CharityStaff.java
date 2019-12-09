package staffList;
import java.util.ArrayList;
public class CharityStaff {

	private ArrayList<Person> staffList;
	
	public CharityStaff() {
		staffList = new ArrayList<Person> ();
	}
	
	//adding both employees and volunteers to the staff list
	public void populate() {
		Volunteer v1 = new Volunteer (21,new Name("Helen Scott"), "helen@hotmail.com", "0131 123 1234", 5);
		staffList.add(v1);
		Volunteer v2 = new Volunteer(22, new Name("James Jackson"), "james@hotmail.com", "0131 333 3232", 10);
		staffList.add(v2);
		Employee e1 = new Employee ("TM3", new Name("Tim Moore"), "tim@hotmail.com", "0131 321 3212", 1500);
		staffList.add(e1);

		Employee e2 = new Employee ("MM4", new Name("Mary Munro"), "mary@hotmail.com", "0131 111 1818", 1600);
		staffList.add(e2);

		Employee e3 = new Employee ("KC5", new Name("Keith Clark"), "keith@hotmail.com", "0131 989 9898", 2700);
		staffList.add(e3);
	}
	
	//returns a text list of details for everyone in the staff list
	//uses toString method defined in subclass
	public String listDetails()
	{
		String list = "ALL STAFF DETAILS\n";
		for (Person p : staffList){	
			list += p.toString() + "\n\n";	
		}
		return list;
	}

	//returns a text list of all names for everyone in the staff list
	//names are defined in the Person superclass
	public String listAllNames()
	{
		String list = "ALL STAFF\n";
		for (Person p : staffList){
			String fullName =  p.getName().getFullName(); 	
			list += fullName + "\n";	
		}
		list += "\n";
		return list;
	}

	//returns text listing of names of all volunteers,
    // by checking the class using 'instanceof'
	//and using methods defined in the Person superclass 
	public String  listAllVolunteers()
	{
		String list = "ALL VOLUNTEERS\n";
		for (Person p : staffList){
			if (p instanceof Volunteer) {
				String fullName =  p.getName().getFullName();
				list += fullName + "\n"; 	
			}
		}
		list += "\n";
		return list;
	}	
	
	

	//returns text listing all volunteer ids,by checking the class
	//using 'instanceof' and casting to a Volunteer object
	//This enables us to use methods defined in the Volunteer class                     
	public String listVolunteerIDs()
	{
		String list = "VOLUNTEER IDs\n";
		for (Person p : staffList){
			if (p instanceof Volunteer) {
				Volunteer v = (Volunteer) p;
				list += v.getID()+ "\n";  	
			}
		}
		list += "\n";
		return list;
	}

    //search for Person info
    public Person findPerson(String name)
    {
        //for each person in the list
        for (Person p : staffList) {
          //check to see if same name
          if (p.getName().getFullName().equals(name))
            //if same name, return object
        	  return p;
        }
        //get here if end of list and name not found
        return null;
    }
    

	
	//totalling hours, using an abstract method 
    //specified in Person superclass
	//and implemented in both subclasses
	public int getTotalHours() {
		int total = 0;
		for (Person p : staffList) {
			total += p.getMonthlyHours();
		}
		return total;
	}
}

