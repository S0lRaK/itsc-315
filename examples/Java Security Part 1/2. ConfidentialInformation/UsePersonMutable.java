public class UsePersonMutable
{
	public static void main(String args[])
	{
		PersonMutable pm = new PersonMutable("adam","adampass");
		
		System.out.println("Usename: " + pm.getUsername());
		System.out.println("Password: " + pm.getPassword());
		
		//Finished with pm now, so clear the contents immediately (don't wait for garbage collection)
		pm.clear();
		
		System.out.println("Usename: " + pm.getUsername());
		System.out.println("Password: " + pm.getPassword());
		
	}
}