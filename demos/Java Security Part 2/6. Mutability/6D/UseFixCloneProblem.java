public class UseFixCloneProblem
{
	public static void main(String args[]) throws CloneNotSupportedException
	{
		//Create FixCloneProblem object
		FixCloneProblem fcp = new FixCloneProblem("apples");
		
		//Clone it, use a different reference to access the clone/copy
		FixCloneProblem fcp2 = (FixCloneProblem)fcp.clone(); //"Deep copy"
		
		System.out.println("1: " + fcp.getText() + ", " + fcp2.getText());
		
		//Change the text in the original FixCloneProblem object
		fcp.setText("oranges");
		
		System.out.println("2: " + fcp.getText() + ", " + fcp2.getText());
		
		//Change the text in the cloned copy of the FixCloneProblem object
		fcp2.setText("bananas");
		
		System.out.println("3: " + fcp.getText() + ", " + fcp2.getText());
	}
}