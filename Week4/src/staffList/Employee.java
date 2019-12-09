package staffList;

public class Employee extends Person
{
    private String eID;
    private double monthlySalary;
    private static final int HOURS = 20;
    
    public Employee (String eID, Name n, String e, 
							String p, double s)
    {
    	super(n, e, p); 
    	this.eID = eID; 
    	monthlySalary = s;
    }
    
    public String getID() { return eID; }
    public double getMonthlySalary(){return monthlySalary; }
    public int getMonthlyHours()  {  return HOURS;  }
    
	//overrides toString methods higher up the hierarchy
    public String toString()  {
    	return eID + " " + super.toString() 
    	    + "\nSalary = £" + String.format("%.2f",monthlySalary);
    }
    
    //overrides equals methods higher up the hierarchy
    //first check that other object being compared IS an Employee
    //if so, cast to an Employee
    //return true if equal, false otherwise
    public boolean equals(Object other){
    	if (!(other instanceof Employee) )
    		return false;
    	Employee otherEmp = (Employee) other;
    	return (this.eID.equals(otherEmp.eID));
    }
    
}

