package person;

import java.io.Serializable;

public class Person implements Serializable
{
	static final long serialVersionUID=1L; //Use for serialization.
    
	protected String name;
	protected String age;
    
	//Constuctors
	public Person()
	{
		name="";
		age="0";
	}
    
	public Person(String name, String age) 
	{
		//Check provided argument values are correct.
		checkName(name);	
		checkAge(age);

		this.name=name;
		this.age=age; 
	}
    
	//Setters
	public void setName(String name)
	{
		checkName(name);
		
		this.name=name;
	}
    
	public void setAge(String age)
	{
		checkAge(age);
		
		this.age=age;
	}
	
	//Getters
	public String getName()
	{
		return name;
	}

	public String getAge() 
	{
		return age;
	}


	@Override
	public String toString() 
	{
		return "Person: " + name + "," + age;
	}
    
	//Rules for data
	private void checkName(String name)
	{	
		if (name==null || name.length()==0)
			throw new IllegalArgumentException("Missing Person name");
	}
	
	private void checkAge(String age)
	{
		if (age==null || age.length()==0)
			throw new IllegalArgumentException("Missing Person age");
		
		int ageValue=Integer.parseInt(age);
	
		if (ageValue<0 || ageValue>125)
			throw new IllegalArgumentException("Person age value out of range");
	}
    
} 
