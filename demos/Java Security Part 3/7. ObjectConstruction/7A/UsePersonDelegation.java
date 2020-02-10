public class UsePersonDelegation
{
	public static void main(String args[])
	{
		PersonDelegation pd = PersonDelegation.getInstance("adam",21);
		
		System.out.println("Name: " + pd.getName() + " Age: " + pd.getAge());
		
		//PersonDelegation pd2 = PersonDelegation.getInstance(null,21); //Invalid name
		//PersonDelegation pd3 = PersonDelegation.getInstance("adam",-21); //Invalid age
		
	}
}