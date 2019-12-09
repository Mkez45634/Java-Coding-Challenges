package q2;

public class PersonTel {
	private String name;
	private String homeNumber;
	private String mobileNumber;

	public PersonTel(String n, String h, String m) {
		this.setName(n);
		setHomeNumber(h);
		setMobileNumber(m);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


}
