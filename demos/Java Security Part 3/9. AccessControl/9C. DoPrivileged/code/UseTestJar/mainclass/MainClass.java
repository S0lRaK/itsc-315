
package mainclass;

import privclass.PrivClass;

public class MainClass {
    public static void main(String args[])
    {
        try
        {
			//Try to access "secured" property without correct permissions being granted to this code.
			//(Unless you edit the security.policy file to allow this)
            //System.out.println("MainClass: " + System.getProperty("java.home"));
        }
        catch(Exception e)
        {
            System.out.println("--------------");
            System.out.println("ERROR IN MAINCLASS:");
            e.printStackTrace();
            System.out.println("--------------");
        }
        
        PrivClass pc = new PrivClass();
        pc.go();
    }
}
