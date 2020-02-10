import java.util.logging.*;
import java.io.*;

public class LogPerson
{
	public static void main(String args[]) throws IOException
	{
		Logger logger = Logger.getLogger("LogPerson");
		
		Person p=new Person("adam","adampass");
		
		FileHandler fh=new FileHandler("LogPerson.txt",true);
		logger.addHandler(fh);
		fh.setFormatter(new SimpleFormatter());
		
		try
		{
			String name=p.getUsername();
			
			throw new RuntimeException(); //Force an exception...
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			logger.log(Level.SEVERE,"Error with Person: {0}",p.toString());
		}
		
	}
}
