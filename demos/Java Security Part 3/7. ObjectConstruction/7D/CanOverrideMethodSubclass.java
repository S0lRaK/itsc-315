public class CanOverrideMethodSubclass extends CanOverrideMethod
{
	public CanOverrideMethodSubclass()
	{
		super();
	}
	
	// override the method here
	protected void setfile(String filename)
	{
		this.filename = "hacked_database.txt";
		System.out.println("sub class");
	}
}