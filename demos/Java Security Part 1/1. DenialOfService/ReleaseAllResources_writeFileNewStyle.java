import java.io.*;

public class ReleaseAllResources_writeFileNewStyle
{

	public static void main(String args[])
	{

		try (PrintWriter p = new PrintWriter(new File("output.txt"))) //try-with-resources (JDK 7+)
		{
			p.println("one\r\ntwo\r\nthree\r\n");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

	}
}