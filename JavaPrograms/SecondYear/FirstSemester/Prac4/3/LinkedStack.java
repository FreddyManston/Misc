public class LinkedStack <E>
{
	private SNode top, head;
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
	
	public void push(E element)
	{
		SNode SNI = new SNode(element, null);
		
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
	
	public Object pop()
	{
		SNode shifter = head;
		
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
					
				SNode temp = shifter.getNext();
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
	
	public Object head()
	{
		SNode shifter = head;
		
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
					
				SNode temp = shifter.getNext();
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
			SNode shifter = head;
			
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
