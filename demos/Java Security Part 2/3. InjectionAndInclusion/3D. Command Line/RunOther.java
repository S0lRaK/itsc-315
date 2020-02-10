// use windows for this example

import java.util.Scanner;
import java.io.*;

public class RunOther
{
	public static void main(String args[])
	{
		try
		{
			Scanner s = new Scanner(System.in);
			String filename=null;
			Runtime rt = Runtime.getRuntime();
			
			System.out.println("Enter name of file to view: ");
			filename=s.nextLine();
			
			//First run: enter a text file name to validly list the contents of that file.
			//Second run:  enter something in the following format: <text file name> && <other DOS command>
			Process pr = rt.exec("cmd /c type " + filename);
			
			pr.waitFor(); 
			BufferedReader reader=new BufferedReader(new InputStreamReader(pr.getInputStream())); 
			String line=null; 
			while((line = reader.readLine()) != null) 
			{ 
				System.out.println(line);
			} 
			
			s.close();
		}
		catch (IOException|InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
}