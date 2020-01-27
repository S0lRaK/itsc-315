import java.util.logging.*;
import java.io.*;

public class SimpleLogger
{
	private static Logger logger = Logger.getLogger("myLogger");
	
	public static void main(String args[]) throws IOException
	{
		FileHandler fh=new FileHandler("myLogger.txt",true);
		logger.addHandler(fh);
		fh.setFormatter(new SimpleFormatter());
	
		logger.log(Level.SEVERE, "Hello myLogger!"); //To console by default
		logger.log(Level.SEVERE, "Hello logging: {0}","Parameterized log message here");
		
		myMethod();
	}
	
	private static void myMethod()
	{
		logger.log(Level.SEVERE,"Logging from a method call...");
	}
}