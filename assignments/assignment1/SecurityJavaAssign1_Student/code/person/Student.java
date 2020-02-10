package person;

import java.io.Serializable;

public class Student extends Person implements Serializable
{
 	static final long serialVersionUID=1L; //Use for serialization.
    
 	private String id;
 	private String gpa;

	//Constuctors
 	public Student() 
 	{
 		super();
 		id="";
 		gpa="0.0";
 	}

	 public Student(String name, String age, String id, String gpa) 
	 {
		super(name,age);  
		
			checkID(id);
			checkGPA(gpa);
		
		this.id = id;
		this.gpa = gpa;
	 }

	//Setters
	public void setId(String id)
	{
		checkID(id);
		this.id=id;
	}
	
	public void setGpa(String gpa)
	{
		checkGPA(gpa);
		this.gpa=gpa;
	}
  
	 //Getters
	 public String getId() 
	{
		return id;
	 }

	 public String getGpa() 
	{
		return gpa;
	 }
	

	@Override
	public String toString() 
	{
		return "Student: " + name + "," + age + "," + id + "," + gpa;
	}
	
	//Rules for data
	private void checkID(String id)
	{
		if (id==null || id.length()!=9)
			throw new IllegalArgumentException("Invalid Student ID value");
	}
	
	private void checkGPA(String gpa)
	{
		float gpaValue=Float.parseFloat(gpa);
		
		if (gpa==null || gpa.length()==0 || gpaValue<0.0f || gpaValue>4.0f)
			throw new IllegalArgumentException("Invalid Student GPA value");
	}
    
}
