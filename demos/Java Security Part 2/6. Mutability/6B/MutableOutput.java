
public class MutableOutput
{
	StringBuffer bf=new StringBuffer();
	
	public MutableOutput(String initValue)
	{
		bf.append(initValue);
	}
	
	public StringBuffer getText()
	{
		//Good: make copy, return reference to copy of bf
		StringBuffer output = new StringBuffer(bf.toString());
		
		//Bad: return reference to original StringBuffer
		//StringBuffer output = bf;
		
		return output;
	}
	

}