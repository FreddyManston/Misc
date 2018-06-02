public class SLinkedList 
{
	private Node head;

	public void SLinkedList () //Done
	{
	}
	
	public void SLinkedList (Node new_head) //Done
	{
		head = new_head;
	}
	
	public void setHead (Node new_head) //Done
	{
		head = new_head;
	}
	
	public Node getHead () //Done
	{
		return (head);
	}
	
	public  boolean isEmpty () //Done
	{
		if (head == null)
			return (true);
		else
			return (false);
	}
	
	public String toString () //Done
	{
		Node position = head;
		String string = "[";
		
		while (position.getNext() != null)
		{
			string = string + position.getData() + ",";
			position = position.getNext();
		}
		string = string + position.getData();
		return (string + "]");
	}
	
	public void insertInFront (int k, int d) //Done
	{
		Node new_head = new Node (k, d, head);
		setHead(new_head);
	}
	
	public void insertAtTail (int k, int d) //Done
	{
		Node new_tail = new Node(k, d, null);
		Node first = head;
		
		while (first.getNext() != null)
		{
			first = first.getNext();
		} first.setNext(new_tail);	
	}
	
	public Node deleteFirstOccurrence (int k) //Done
	{
		Node position = head;
		
		while (!(position.getNext().getKey() == (k)))
			position = position.getNext();
		
		Node deleting_this = position.getNext();
		position.setNext(deleting_this.getNext());

		return (deleting_this);
	}
	
	public void deleteLastOccurrence (int k)
	{
		Node position = head;
		int count = 0;
		int num_occurrences = this.noOfOccurrences(k);
		
		while (count < num_occurrences - 1)
		{
			if ((position.getNext()).getKey() == (k))
			{
				count ++;
			}
			position = position.getNext();
		}
		
		while (!(position.getNext().getKey() == (k)))
		{
			position = position.getNext();
		}
		
		position.setNext((position.getNext()).getNext());
	}
	
	public Node getFirstOccurrence (int k) //Done
	{
		Node position = head;

		if (containsItem(k))
			while (!(position.getKey() == k))
				position = position.getNext();
		else
			position = null;

		return (position);
	}

	public boolean containsItem (int k) //Done
	{
		Node position = head;
		boolean is_in_there = false;
		
		while (position.getNext() != null)
		{
			if (position.getKey() == (k))
			{
				is_in_there = true;
				break;
			}
			
			position = position.getNext();
		}
		
		return (is_in_there);
	}
	
	public int noOfOccurrences (int k) //Done
	{
		Node position = head;
		int counter = 0;
		
		while (position.getNext() != null)
		{
			if (position.getKey() == (k))
				counter ++;
				
			position = position.getNext();
		}
		
		if (position.getKey() == (k))
				counter ++;
				
		return (counter);
	}
	
	public int firstPositionOfItem (int k) //Done
	{
		int counter = 1;
		Node position = head;
		
		while (position.getNext() != null)
		{
			if (position.getKey() == (k))
				break;
				
			position = position.getNext();
			counter ++;
		}
		
		return (counter);
	}
	
	public int[] allPositionsOfItem (int k) //Done
	{
		int counter = 1;
		Node position = head;
		
		int[] position_list = new int [this.noOfOccurrences(k)];
		int index = 0;	
		
		while (position.getNext() != null)
		{
			if (position.getKey() == (k))
				position_list [index] = counter;
			
			position = position.getNext();
			counter ++;
		}
		return (position_list);
	}
}
