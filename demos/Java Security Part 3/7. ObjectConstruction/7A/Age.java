public class Age
{
	int age=0;
	
	public Age()
	{
	}
	
	public Age(int initAge)
	{
		checkAge(initAge); //Error checking
		
		age=initAge;
	}
	
	public void setAge(int newAge)
	{
		checkAge(newAge); //Error checking
		
		age=newAge;
	}
	
	public int getAge()
	{
		return age;
	}
	
	private void checkAge(int age)
	{
		//Valid age range between 0 and 125 inclusive...
		if (age<0 || age>125)
			throw new IllegalArgumentException("Age not in valid range!");
	}
	
}