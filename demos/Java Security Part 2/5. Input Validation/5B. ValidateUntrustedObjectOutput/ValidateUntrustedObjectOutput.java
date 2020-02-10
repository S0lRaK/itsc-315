import trustedPackage.Trusted;
import untrustedPackage.Untrusted;

public class ValidateUntrustedObjectOutput {

    public static void main(String[] args) {
        Untrusted untrusted = new Untrusted();
        Trusted trusted = new Trusted();
        
        System.out.println("The age is " + trusted.getAgeFromOtherClass(untrusted));
    }
    
}
