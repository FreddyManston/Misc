public class GenericLinkedStack2 <E>
{
	SNode<E> head;
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
		head = new SNode<E>(element,head);
		counter ++;
	}
	
	public E pop()
	{		
		E temp = null;	
		if(head != null)
		{
			temp = head.getElement();
			head = head.getNext();
			counter --;
			return temp;
		}
		return null;
		
	}
	
	public Object head()
	{
		if (counter == 0)
		{
			System.out.println("There is no head in an empty stack.");
			return (null);
		}
			
		else	
			return (head.getElement());
		
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
