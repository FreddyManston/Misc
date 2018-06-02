public class GenericLinkedStack <E>
{
	SNode head, top;
	int counter = 0;
	
	public boolean isEmpty()
	{
		if (counter == 0)
			return (true);
		else
			return (false);
	}
	
	public boolean isFull()
	{
		if (counter > 0)
			return (true);
		else
			return (false);
	}
	
	public void push(E element)
	{
		SNode new_node = new SNode (element, null);
		
		if (counter == 0)
		{
			head = new_node;
			top = new_node;
		}
		else
		{
			top.setNext(new_node);
			top = new_node;
		}
		
		counter ++;
	}
	
	public Object pop()
	{			
		if (counter == 1)
		{	
			SNode new_node = head;
			
			head = null;
			top = null;
			
			counter  = 0;
			return (new_node.getElement());
		}
		
		else
		{
			SNode shifter = head;
			
			while (shifter.getNext() != top)
				shifter = shifter.getNext();
			
			SNode new_node = top;
			shifter.setNext(null);
			top = new_node;
			counter --;
			return (new_node.getElement());
		}
	}
	
	public Object head()
	{
		if (counter == 0)
		{
			System.out.println("There is no head in an empty stack.");
			return (null);
		}
			
		else	
			return (top.getElement());
		
	}
	
	public String toString()
	{
		SNode shifter = head;
		String stack_in_text = "[";
		
		if (counter > 0)
		{
			while (shifter.getNext() != null)
			{
				stack_in_text = stack_in_text + shifter.getElement() + ", ";
				shifter = shifter.getNext();
			} stack_in_text = stack_in_text + shifter.getElement() + "]";
		}
		else
			stack_in_text = stack_in_text + "]";
			
		return (stack_in_text);
	}
}
