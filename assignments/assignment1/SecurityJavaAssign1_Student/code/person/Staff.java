package person;

import java.io.Serializable;

public class Staff extends Person implements Serializable
	{
	static final long serialVersionUID=1L; //Use for serialization.
	    
	private String sid;
	private String salary;

	//Constuctors
	public Staff() 
	{
		super();
		sid="";
		salary="0.0";
	}

	public Staff(String name, String age, String sid, String salary) 
	{
		super(name,age); 
		
		checkSID(sid);
		checkSalary(salary);
		
		this.sid = sid;
		this.salary = salary;
	}

	//Setters
	public void setSid(String sid)
	{
		checkSID(sid);
		this.sid=sid;
	}
    
	public void setSalary(String salary)
	{
		checkSalary(salary);
		this.salary=salary;
	}

	//Getters
	public String getSid() 
	{
		return sid;
	}

	public String getSalary() 
	{
		return salary;
	}


	@Override
	public String toString() 
	{
		return "Staff: " + name + "," + age + "," + sid + "," + salary;
	}
	
	//Rules for data
	private void checkSID(String sid)
	{
		if (sid==null || sid.length()!=9)
			throw new IllegalArgumentException("Invalid Staff ID value");
	}
	
	private void checkSalary(String salary)
	{
		float salaryValue = Float.parseFloat(salary);
		
		if (salary==null || salary.length()==0 || salaryValue<0.0f || salaryValue>100000.0f)
			throw new IllegalArgumentException("Invalid Staff salary value");
	}

}
