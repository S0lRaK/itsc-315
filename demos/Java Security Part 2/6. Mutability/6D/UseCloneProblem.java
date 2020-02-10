public class UseCloneProblem
{
	public static void main(String args[]) throws CloneNotSupportedException
	{
		//Create CloneProblem object
		CloneProblem cp = new CloneProblem("apples");
		
		//Clone it, use a different reference to access the clone/copy
		CloneProblem cp2 = (CloneProblem)cp.clone(); //"Shallow copy"
		
		System.out.println("1: " + cp.getText() + ", " + cp2.getText());
		
		//Change the text in the original CloneProblem object
		cp.setText("oranges");
		
		System.out.println("2: " + cp.getText() + ", " + cp2.getText());
		
		//Change the text in the cloned copy of the CloneProblem object
		cp2.setText("bananas");
		
		System.out.println("3: " + cp.getText() + ", " + cp2.getText());
	}
}