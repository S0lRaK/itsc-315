package privclass;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class PrivClass {
    public void go()
    {
		//Can I access the property without permission escalation? Depends on the security.policy file settings.
		//System.out.println("PrivClass (not privileged): " + System.getProperty("java.home"));
		
		//Escalate permissions *temporarily* to access property access.
        AccessController.doPrivileged( 
		
            new PrivilegedAction<Boolean>()
            {
                public Boolean run()
                {
                    try
                    {
						//security.policy file settings determine whether or not we can access "java.home" property.
                        System.out.println("PrivClass: " + System.getProperty("java.home"));
                    }
                    catch(Exception e)
                    {
                        System.out.println("--------------");
                        System.out.println("ERROR IN PRIVCLASS:");
                        e.printStackTrace();
                        System.out.println("--------------");
                    }
                    return Boolean.TRUE;
                }
            } //End of PrivilegedAction declaration

        ); //End of AccessController.doPriviliged
    }
}
