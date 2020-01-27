public class InfiniteLoopProgressCheck
{
	public static void main(String args[])
	{
		int progressSoFar=0;
		boolean enough=false;
		
		for (;;) //That's all it takes... or "while (true)"...
		{
			System.out.println("Hello...");
			
			//Progress check here...
			progressSoFar++;
			if (progressSoFar>10000) //Taking longer than expected!
			{
				enough=true;
				break;
			}
		}
		
		if (enough)
			System.out.println("I had to stop the loop, it was taking too long!");
	}
}