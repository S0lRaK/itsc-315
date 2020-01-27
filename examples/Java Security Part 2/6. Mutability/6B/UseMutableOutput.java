
public class UseMutableOutput
{
	public static void main(String args[])
	{
		MutableOutput mo = new MutableOutput("apples");
		
		System.out.println("1 mo:\t\t" + mo.getText()); //See original value of StringBuffer
		
		StringBuffer inMain = mo.getText();
		inMain.append(" CHANGED"); //Update available StringBuffer here
		
		System.out.println("2 inMain:\t" + inMain.toString()); //See updated inMain StringBuffer here
		
		System.out.println("3 mo:\t\t" + mo.getText()); //See value of "original" StringBuffer (might be changed!)
		
	}

}