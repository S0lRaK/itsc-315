import java.util.Scanner;
import java.io.*;

public class ReadFile
{
	public static void main(String args[]) 
	{
		File f=null;
		Scanner s=null;
		try
		{
			f = new File("missingInputFile.txt"); //No such input file...
			s = new Scanner(f);
			
			while (s.hasNext())
			{
				String line = s.nextLine();
				System.out.println(line);
			}
		}
		catch (FileNotFoundException e)
		{
			// e.printStackTrace();
			System.out.println("Error");
		}
		finally
		{	
			try
			{
				s.close();
			}
			catch(NullPointerException e)
			{
				// e.printStackTrace();
				System.out.println("Error");
			}
		}
		
	}
}