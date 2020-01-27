import java.security.PermissionCollection;
import java.security.Policy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySecurityManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Security Manager: " + System.getSecurityManager());
        System.out.println("user.home: " + System.getProperty("user.home"));            
    }
    
}
