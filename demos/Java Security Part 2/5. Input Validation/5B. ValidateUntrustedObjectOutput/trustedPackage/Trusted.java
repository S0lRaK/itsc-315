package trustedPackage;

import untrustedPackage.Untrusted;

public class Trusted {
    
    //Parameter is "some object", it's not to be trusted to give us good data!
    public int getAgeFromOtherClass(Untrusted otherClass)
    {
        //Get data from the untrusted object...
        int age = otherClass.getAge();
        
        //Check the value output from the provided (untrusted) object.
        //Rule: valid ages are between 0 and 125 inclusive.
        if (age<0 || age>125)
            throw new IllegalArgumentException();
        
        return age;
    }
}
