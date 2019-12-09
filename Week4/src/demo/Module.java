package demo;

public class Module {
	private String title, id;
	
	public Module(String t, String i)
	{
		title = t;
		id = i;
	}
	
	
	public Module()
	{
		id = "";
		title = "";
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
