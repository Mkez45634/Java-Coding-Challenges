package staffList;

public class Volunteer extends Person
{
    private int vID;
    private int monthlyHours;

    public Volunteer (int vID, Name n, String e, 
							String p, int h)
    {
    	super(n, e, p);   
    	this.vID = vID;
    	monthlyHours = h;
    }
    
    public int getID() { return vID; }
    public int getMonthlyHours(){return monthlyHours; }
    
    public String toString()  {
    	return vID + " " + super.toString() + "\nHours worked = " 
                                 + monthlyHours;
    }
    
    public boolean equals(Object other){
    	if (! (other instanceof Volunteer ))
    		return false;
    	Volunteer otherVol = (Volunteer)other;
    	return this.vID == otherVol.vID;
    }
}
