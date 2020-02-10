import java.io.*;
import readdata.ReadInputFile;

public class UseReadInputFile
{
	public static void main(String args[]) throws FileNotFoundException
	{
		ReadInputFile rif = new ReadInputFile();
		
		String fileData = rif.readFile();
		
		System.out.println(fileData);
		
	}
}