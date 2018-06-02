public class LinkedListInteger implements SLinkedListInteger
{
	SNodeInteger head;
	int count = 0;
	
	public void displayList()
	{
		SNodeInteger shifter = head;
		
		while (shifter.getNext() != null)
		{
			System.out.println(shifter.getElement() + ", ");
			shifter = shifter.getNext();
		} System.out.println(shifter.getElement() + ".");
	}
	
	public int length()
	{
		return count;
	}
	
	public void addANodeToStart(Integer itemToAdd)
	{
		SNodeInteger new_node = new SNodeInteger(itemToAdd, null);
		
		if (count == 0)
			head = new_node;
			
		else
		{
			SNodeInteger shifter = head;
			while (shifter != null)
			{
				shifter = shifter.getNext();
			} shifter.setNext(new_node);
		}
		
		count++;
	}
	
	public SNodeInteger deleteHeadNode()
	{
		if (count == 0)
		{	
			SNodeInteger temp = head;
			head = null;
			count--;
			return temp;
		}
			
		else
		{
			SNodeInteger shifter = head;
			while (shifter.getNext() != null)
			{
				shifter = shifter.getNext();
			} 
			
			SNodeInteger temp = shifter.getNext();
			shifter.setNext(null);
			count--;
			return temp;
		}
	}
	
	public boolean isOnList(Integer dataItem)
	{
		SNodeInteger shifter = head;
		boolean is_on_list = false; 
		
		while(shifter != null)
		{
			if (shifter.getElement() == dataItem)
			{
				is_on_list = true;
				break;
			}
		} return is_on_list;	
	}
}
