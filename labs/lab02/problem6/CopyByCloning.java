public class CopyByCloning implements Cloneable
{
	StringBuffer sb = new StringBuffer();

	public CopyByCloning()
	{}

	public CopyByCloning(String theText)
	{
		sb.append(theText);
	}

	public void setText(String theText)
	{
		sb.setLength(0);
		sb.append(theText);
	}

	public String getText()
	{
		return sb.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}	
}
