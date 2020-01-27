public class CopyOutput
{
	public static void main(String args[])
	{
		OutputValue ov = new OutputValue();

		System.out.println("1: " + ov.getText());
		ov.getText().append("HACKED");
		System.out.println("2: " + ov.getText());
		
	}

	private static class OutputValue
	{
		StringBuffer sb = new StringBuffer("Hello");

		public OutputValue()
		{}

		public StringBuffer getText()
		{
			return sb;
		}
	}
}

