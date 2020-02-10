public class CanOverrideMethod
{
	String filename;
	
	public CanOverrideMethod()
	{
		setfile("secure_database.txt");
		System.out.println("do more super class stuff");
	}
	
	// this method can be overridden
	protected void setfile(String filename)
	{
		this.filename = filename;
	}

	public void readfile()
	{
		System.out.println("Reading file: " + filename);
	}
}