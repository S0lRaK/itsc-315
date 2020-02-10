
public class UseCloneMe {
    public static void main(String args[]) throws CloneNotSupportedException
    {
        CloneMe cm = new CloneMe("Hello world");
        
		// only use clone in very rare cases where you trust the mutable object
        CloneMe other = (CloneMe)cm.clone();
        
       System.out.println(cm.getMessage());
       System.out.println(other.getMessage());
    }
}
