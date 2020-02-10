import java.io.*;

public class ReleaseAllResources_writeFileOldStyle
{

	public static void main(String args[])
	{
		File f = null;
		PrintWriter p = null;
			
		try
		{
			f = new File("output.txt");
			p = new PrintWriter(f);

			p.println("one\r\ntwo\r\nthree\r\n");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			p.close();
		}
	}
}