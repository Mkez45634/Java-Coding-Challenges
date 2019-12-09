package q3;


//same as before plus implementing Comparable interface
public class Name implements Comparable<Name>
{
  private String firstName;
  private String middleName;
  private String lastName;
  
  public Name(String fName, String lName) {
		firstName = fName;
		middleName = "";
		lastName = lName;
  }
  
  public Name(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
}
  
  public Name (String fullName) {
	  int spacePos1 = fullName.indexOf(' ');
	  if (spacePos1 == -1) {
		  firstName = fullName;
		  middleName = "";
		  lastName = "";
	  }
	  else {
		  firstName = fullName.substring(0, spacePos1);
		  int spacePos2 = fullName.lastIndexOf(' ');
		  if (spacePos1 == spacePos2)
			  middleName = "";
		  else 
			  middleName = fullName.substring(spacePos1+1, spacePos2);
		  lastName = fullName.substring(spacePos2 + 1);
	  }
  }
  
  public String getFirstName() {return firstName; }
  public String getLastName() {return lastName; }
  
  public String getFullName() {
	  String middle = "";
	  if (middleName.length() != 0)
		  middle  = middleName + " ";
	  return firstName + " " +middle + lastName;
  }

  
  public String getFullNameUpper() {
	  return getFullName().toUpperCase();
  }
  
  public String getSortName() {
	  String middle = "";
	  if (middleName.length() != 0)
		  middle  = " " + middleName;
	  return lastName + ", " + firstName + middle ; 
  }
  
  public int compareTo(Name other)
  {
	  return getSortName().compareTo(other.getSortName());
  }
}

