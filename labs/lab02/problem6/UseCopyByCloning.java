public class UseCopyByCloning
{
	public static void main(String args[]) throws CloneNotSupportedException
	{
		CopyByCloning cbc = new CopyByCloning("Hello!");

		CopyByCloning cbc2 = (CopyByCloning)cbc.clone();

		System.out.println("1: " + cbc.getText() + ", " + cbc2.getText());
		cbc2.setText("Bye!");
		System.out.println("2: " + cbc.getText() + ", " + cbc2.getText());
	}
}	
