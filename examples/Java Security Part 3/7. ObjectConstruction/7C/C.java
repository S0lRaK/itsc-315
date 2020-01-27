// https://stackoverflow.com/questions/5909818/java-exception-thrown-in-constructor-can-my-object-still-be-created

public class C {
	static C obj; // stores a "partially constructed" object
	
	int a = 6;
	
    public static void main(String[] args) {
        C obj = null;
        try {
            obj = new C();
        } catch (RuntimeException e) {
            /* ignore */
        }
        //obj.printSomething(); // null pointer exception
		System.out.println(C.obj);
		C.obj.printSomething();  // this works?
    }
    
    C() {
        C.obj = this;  // store a reference to this object globally
		int b = 1;
		if (b == 1)
			throw new RuntimeException();
		a = 5;
    }
	
	void printSomething() {
		System.out.println("hi");
		System.out.println(a);
	}
}
