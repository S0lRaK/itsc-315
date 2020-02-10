public class FixCloneProblem //implements Cloneable
{
	StringBuffer sb = new StringBuffer(); //Mutable
	
	public FixCloneProblem(String initsb)
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
	
	//@Override 
    protected Object clone() //throws CloneNotSupportedException 
	{
		//"Deep copy"
        return new FixCloneProblem(sb.toString()); //super.clone(); 
    }
}