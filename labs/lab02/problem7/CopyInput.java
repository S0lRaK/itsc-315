public class CopyInput
{
	public static void main(String args[])
	{
		StringBuffer sb = new StringBuffer("hello");

		printValue(sb); 
		printValue(sb); 
	}

	private static void printValue(StringBuffer sb)
	{
		System.out.println(sb);
		sb.append("HACKED");
	}
}
