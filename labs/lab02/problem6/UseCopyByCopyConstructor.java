public class UseCopyByCopyConstructor
{
	public static void main(String args[]) throws CloneNotSupportedException
	{

		CopyByCopyConstructor cbcc = new CopyByCopyConstructor("Hello!");
		CopyByCopyConstructor cbcc2 = new CopyByCopyConstructor(cbcc);

		System.out.println("1: " + cbcc.getText() + ", " + cbcc2.getText());
		cbcc2.setText("Bye!");
		System.out.println("2: " + cbcc.getText() + ", " + cbcc2.getText());
	}
}	
