package MyPackage;

import java.io.*;
import java.util.Scanner;

public class TestClass
{
	public void test() throws FileNotFoundException
	{

		File f = new File("../input.txt");
		String contents="";
		Scanner s = new Scanner(f);
		
		while (s.hasNext())
		{
			contents = contents + s.nextLine();
		}
		
		s.close();
		
		System.out.println("CONTENTS: " + contents);
		
	}
}
