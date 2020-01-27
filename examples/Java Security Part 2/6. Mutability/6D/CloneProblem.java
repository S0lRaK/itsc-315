public class CloneProblem implements Cloneable
{
	StringBuffer sb = new StringBuffer(); //Mutable
	
	public CloneProblem(String initsb)
	{
		sb.append(initsb);
	}
	
	public String getText()
	{
		return sb.toString();
	}
	
	public void setText(String newText)
	{
		sb.setLength(0); //Clear out buffer first
		sb.append(newText); 
	}
	
	@Override 
    protected Object clone() throws CloneNotSupportedException {
		//"Shallow copy"
        return super.clone(); 
    }
}