public class HeldAsPublicStatic
{
	int i=0;

	public void method()
	{
		System.out.println("Method doing it's correct thing...");
	}
	
	public int increment()
	{
		return ++i;
	}
}