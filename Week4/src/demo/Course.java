package demo;

import java.util.ArrayList;

public class Course {

	private String name, id;
	private ArrayList<Module>mlist;
	
	public Course(String n, String i)
	{
		name = n;
		id = i;
		mlist = new ArrayList();
	}

	public Course()
	{
		name = "";
		id = "";
		mlist = new ArrayList();
	}
	
	public void addModule(Module m)
	{
		mlist.add(m);
	}
	
	public int getModulesCount()
	{
		return mlist.size();
	}
	
	public Module getModuleAt(int i)
	{
		return mlist.get(i);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
