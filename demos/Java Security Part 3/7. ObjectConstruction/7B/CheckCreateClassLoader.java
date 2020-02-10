import java.security.AccessControlContext;
import java.security.AccessController;

public class CheckCreateClassLoader {

    public static void main(String[] args) throws Exception {
		// enforce a security manager
		SecurityManager security = System.getSecurityManager();
		if (security == null) {
			throw new SecurityException("No security manager");
		}
   
      //Set the policy file as the system securuty policy
      System.setProperty("java.security.policy", "security.policy");

      //Create a security manager
      SecurityManager sm = new SecurityManager();

      //Set the system security manager
      System.setSecurityManager(sm);

      //Perform the check: will fail if security.policy file doesn't allow for creation of new class loaders...
      sm.checkCreateClassLoader();

      // print a message if we passed the check
      System.out.println("Allowed!");
   }
}