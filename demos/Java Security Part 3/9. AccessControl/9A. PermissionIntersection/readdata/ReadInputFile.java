package readdata;

import java.io.*;
import java.util.Scanner;

public class ReadInputFile 
{
	public String readFile() throws FileNotFoundException
	{
		File f = new File("../input.txt");
		Scanner s = new Scanner(f);
		String result="";
		
		while (s.hasNext())
		{
			result = result + s.nextLine();
		}
		
		s.close();
		
		return result;
	}
}