public final class PersonDelegation //Class is FINAL, can't be subclassed
{
	String name;
	Age age = new Age(); //Delegate handling age to separate Age class
	
	//Factory method...
	public static PersonDelegation getInstance(String initName, int initAge)
	{
		return new PersonDelegation(initName, initAge);
	}
	
	private PersonDelegation(String initName, int initAge) //NOTE: PRIVATE not public
	{
		//Can't have a null name...
		if (initName==null)
			throw new IllegalArgumentException("Person name missing!");
			
		name=initName;
		age.setAge(initAge);
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age.getAge(); //Pass-through method call to delegated Age class...
	}
	
}