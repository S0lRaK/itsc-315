public class CorrectionAndValidation
{
	public static void main(String args[])
	{
		String username="adam";
		String password="password"; //Note: this is not the correct password (should be "pass")!
		
		System.out.println("Username: " + username + "\tPassword: " + password);
		
		//Correction: passwords can only be 4 characters long, so we helpfully "fix" the password
		if (password.length()>4)
			password = password.substring(0,4);
			
		//Validation
		if (username.equals("adam") && password.equals("pass")) //Note the valid user credentials vs. the provided ones!
			System.out.println("Valid user credentials");
		else
			System.out.println("Invalid user credentials!");
		
		
	}
}