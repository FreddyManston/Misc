public class LinkedStackInteger
{
	private SNodeInteger top, head;
	private int counter = 0;
	
	public int getHeight()
	{
		return (counter);
	}
	
	public boolean isEmpty()
	{
		if (counter == 0)
			return (true);
		else
			return (false);
	}
	
	public void push(Integer element)
	{
		SNodeInteger SNI = new SNodeInteger(element, null);
		
		if (counter != 0)
		{
			top.setNext(SNI);
			top = SNI;
		}
		else
		{
			head = SNI;
			top = SNI;
		}
		counter ++;
	}
	
	public Integer pop()
	{
		SNodeInteger shifter = head;
		
		if (counter != 0)
		{
			if (counter == 1)
			{
				head.setNext(null);
				counter --;
				return (shifter.getElement());
			}
			else
			{
				for (int i = 1; i < counter - 1; i++)
					shifter = shifter.getNext();
					
				SNodeInteger temp = shifter.getNext();
				shifter.setNext(null);
				top = shifter;
				counter --;
				return (temp.getElement());
			}
		}
		else
		{
			System.out.println("The stack is empty");
			return (null);
		}
	}
	
	public Integer head()
	{
		SNodeInteger shifter = head;
		
		if (counter != 0)
		{
			if (counter == 1)
			{
				return (shifter.getElement());
			}
			else
			{
				for (int i = 1; i < counter - 1; i++)
					shifter = shifter.getNext();
					
				SNodeInteger temp = shifter.getNext();
				return (temp.getElement());
			}
		}
		else
		{
			System.out.println("The stack is empty");
			return (null);
		}
	}
	
	public void display()
	{
		if (counter != 0)
		{
			SNodeInteger shifter = head;
			
			while (shifter.getNext() != null)
			{
				System.out.print(shifter.getElement() + ", ");
				shifter = shifter.getNext();
			} System.out.print(shifter.getElement());
		}
		else
			System.out.println("The list is empty.");
	}
}
