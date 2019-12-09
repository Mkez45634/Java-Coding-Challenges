package staffList;

abstract public class Person
{
    private Name name;
    private String phone;
    private String email;

    public Person (Name n, String e, String p)
    {
    	name = n;   
    	phone = p;    
    	email = e;
    }
    
    public Name getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail()  {  return email;  }
    
    public void setName(Name name) {this.name = name;}
    public void setPhone(String phone){this.phone = phone; }
    public void setEmail(String email) {this.email = email; }
    
    public String toString() {
    	return name.getFullName() + ",  " + phone + ",  "  + email;
    }
    
    public abstract int getMonthlyHours();
    
}
