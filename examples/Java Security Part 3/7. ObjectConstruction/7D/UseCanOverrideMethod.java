public class UseCanOverrideMethod
{
	public static void main(String args[])
	{
		CanOverrideMethod com = new CanOverrideMethod();
		com.readfile();
		
		CanOverrideMethod coms = new CanOverrideMethodSubclass();
		coms.readfile();
	}
}