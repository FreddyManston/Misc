public class QueueElement
{
	protected int priority = 0;
	protected String task = null;
	
	public QueueElement(int p, String t)
	{
		priority = p;
		task = t;
	}
	
	public void setPriority(int p)
	{
		priority = p;
	}
	
	public void setTask(String t)
	{
		task = t;
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	public String getTask()
	{
		return task;
	}	
}
