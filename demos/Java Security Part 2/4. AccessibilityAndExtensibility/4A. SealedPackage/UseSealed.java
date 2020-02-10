import sealedpackage.Class1;
import sealedpackage.Class2;

public class UseSealed {
    public static void main(String args[])
    {
        Class1 c1 = new Class1();
        Class2 c2 = new Class2();
        
        c1.test();
        c2.test();
    }
}
