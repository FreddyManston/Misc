public class DLinkedList
{
	DNode head, tail;
	int size = 0;
	
	public DLinkedList ()
	{
	}
	
	public DLinkedList (DNode new_head, DNode new_tail)
	{
		head = new_head;
		tail = new_tail;
		size = 2;
	}
	
	public void setHead (DNode new_head)
	{
		head = new_head;
	}
	
	public void setTail (DNode new_tail)
	{
		tail = new_tail;
	}
	
	public DNode getHead()
	{
		return head;
	}
	
	public DNode getTail()
	{
		return tail;
	}
	
	public DNode getFirst()
	{
		return head;
	}
	
	public DNode getLast()
	{
		return tail;
	}
	
	public void addBefore(DNode v, DNode z)
	{
		z.setPrev(v.getPrev());
		z.setNext(v);
		(v.getPrev()).setNext(z);
		v.setPrev(z);
		
		size++;
	}
	
	public void addAfter(DNode v, DNode z)
	{
		z.setPrev(v);
		z.setNext(v.getNext());
		(v.getNext()).setPrev(z);
		v.setNext(z);
		
		size++;
	}
	
	public void addFirst(DNode v)	// Check.
	{
		v.setNext(head);
		v.setPrev(null);
		head.setPrev(v);
		head = v;
		
		size++;
	}
	
	public void addLast (DNode v)
	{
		DNode shifter = head;
		
		while (shifter.getNext() != null)
			shifter = shifter.getNext();
		
		shifter.setNext(v);
		v.setNext(null);
		v.setPrev(shifter);
		tail = v;
		
		size++;
	}
	
	public void remove (DNode v)
	{
		if (hasPrev(v) && hasNext(v))
		{
			(v.getPrev()).setNext(v.getNext());
			(v.getNext()).setPrev(v.getPrev());
			v.setNext(null);
			v.setPrev(null);
		}
		else if (!hasPrev(v) && hasNext(v))
		{
			head = v.getNext();
			head.setPrev(null);
			v.setNext(null);
		}
		else if (hasPrev(v) && !hasNext(v))
		{
			tail = v.getPrev();
			tail.setNext(null);
			v.setPrev(null);
		}
		size--;
	}
	
	public boolean hasPrev (DNode v)
	{
		if (v.getPrev() != null)
			return true;
		else
			return false;
	}
	
	public boolean hasNext (DNode v)
	{
		if (v.getNext() != null)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty()
	{
		if (size == 0)
			return true;
		else
			return false;
	}
	
	public void insertInFront (String item)
	{
		DNode new_head = new DNode(item, null, null);
		addFirst(new_head); // Size incremented in addFirst method.
	}
	
	public void insertAtTail (String item)
	{
		DNode new_tail = new DNode(item, null, null);
		addLast(new_tail);
		
		size++;
	}
	
	public void insertAtIndex (int index, String item)
	{
		if (index == 1)
		{
			DNode new_node = new DNode(item, null, null);
			addFirst(new_node);
		}
		
		else
		{
			DNode new_node = new DNode(item, null, null);
			DNode shifter = head;
			int i = 1;
			
			while (i != index - 1)
			{
				shifter = shifter.getNext();
				i++;
			}
			
			new_node.setNext(shifter.getNext());
			new_node.setPrev(shifter);
			(shifter.getNext()).setPrev(new_node);
			shifter.setNext(new_node);
		}
		
		size++;
	}
	
	public void replaceAtIndex (int index, String item)
	{
		DNode shifter = head;
		int i = 1;
		
		while (i != index)
		{
			shifter = shifter.getNext();
			i++;
		}
		shifter.setElement(item);
	}
	
	public void deleteFirstOccurrence (String item)	//Check
	{
		DNode shifter = head;
		
		while (!(shifter.getNext()).getElement().equals(item))
		{
			shifter = shifter.getNext();
		}
		
		if (hasNext(shifter.getNext()))
		{
			shifter.setNext((shifter.getNext()).getNext());
			(shifter.getNext().getPrev()).setNext(null);
			(shifter.getNext().getPrev()).setPrev(null);
			(shifter.getNext()).setPrev(shifter);
			
		}
		else
		{
			(shifter.getNext()).setPrev(null);
			shifter.setNext(null);
		}

		size--;
	}
	
	public void deleteLastOccurrence (String item)
	{
		DNode shifter = head;
		int count = 0;
		int num_occurrences = this.noOfOccurrences(item);
		
		while (count < num_occurrences - 1)
		{
			if ((shifter.getNext()).getElement().equals(item))
				count ++;
				
			shifter = shifter.getNext();
		}
		
		while (!(shifter.getNext()).getElement().equals(item))
		{
			shifter = shifter.getNext();
		}
		
		if (shifter.getNext() != tail)
		{
			shifter.setNext((shifter.getNext()).getNext());
			(shifter.getNext().getPrev()).setNext(null);
			(shifter.getNext().getPrev()).setPrev(null);
			(shifter.getNext()).setPrev(shifter);
			
		}
		else
		{
			(shifter.getNext()).setPrev(null);
			shifter.setNext(null);
		}
		
		size--;
	}
	
	public void deleteAllOccurrences (String item)	//Check
	{	
		int no_of_occurrs = this.noOfOccurrences(item);
		
		for (int i = 0; i < no_of_occurrs; i++)
			this.deleteFirstOccurrence(item);	
		
		size = size - this.noOfOccurrences(item);
	}
	
	public int noOfOccurrences (String item)
	{
		DNode shifter = head;
		int counter = 0;
		
		while (shifter.getNext() != null)
		{
			if (shifter.getElement().equals(item))
				counter++;
			shifter = shifter.getNext();
		} 
		if (shifter.getElement().equals(item))
			counter++;
		
		return counter;
	}
	
	public boolean containsItem (String item)
	{
		if (this.noOfOccurrences(item) > 0)
			return true;
		else
			return false;
	}
	
	public int firstPositionOfItem (String item)
	{
		if (this.containsItem(item))
		{
			DNode shifter = head;
			int index = 1;
			
			while (shifter.getNext() != null)
			{
				if (shifter.getElement().equals(item))
					break;
					
				shifter = shifter.getNext();
				index++;
			}return index;
		}
		else
			return -1; 
	}
	
	public int[] allPositionsOfItem (String item)
	{
		int counter = 1;
		DNode shifter = head;
	
		int[] position_list = new int [this.noOfOccurrences(item)];
		int index = 0;	
	
		while (shifter != null)
		{
			if (shifter.getElement().equals(item))
			{
				position_list [index] = counter;
				index++;
			}
			
			shifter = shifter.getNext();
			counter ++;
		} return (position_list);
	}
	
	public String toString()	//Done
	{
		DNode shifter = head;
		String answer = "[";
		
		while (shifter.getNext() != null)
		{
			answer = answer + shifter.getElement() + ",";
			shifter = shifter.getNext();
		}
		answer = answer + shifter.getElement();
		return (answer + "]");
	}
}
