public class UseUserStaticConstructor {
	public static void main(String args[]) {
    
    UserStaticConstructor u1 = UserStaticConstructor.getInstance("adam", "pass");
    System.out.println("1: Name: " + u1.getUsername() + ", Password: " + u1.getPassword());

    UserStaticConstructor u2 = UserStaticConstructor.getInstance("bill", null);
    System.out.println("2: Name: " + u2.getUsername() + ", Password: " + u2.getPassword());

    UserStaticConstructor u3 = UserStaticConstructor.getInstance(null, null);
		System.out.println("3: Name: " + u3.getUsername() + ", Password: " + u3.getPassword());
	}
}
