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
		String answer = "[";
		
		while (position.getNext() != null)
		{
			answer = answer + position.getElement() + ",";
			position = position.getNext();
		}
		answer = answer + position.getElement();
		return (answer + "]");
	}
	
	public void insertInFront (String item) //Done
	{
		Node new_head = new Node (item, head);
		setHead(new_head);
	}
	
	public void insertAtTail (String item) //Done
	{
		Node new_tail = new Node(item, null);
		Node first = head;
		//Node second = null;
		
		while (first.getNext() != null)
		{
			first = first.getNext();
		} first.setNext(new_tail);	
	}
	
	public void insertAtIndex (int index, String item) //Done
	{
		Node new_node = new Node (item, null);
		
		if (index == 1)
			this.insertInFront(item);	
		else
		{
			int counter = 1;
			
			Node position = head;
			Node previous = null;
	
			while (counter != index)
			{
				previous = position;
				position = position.getNext();
				counter ++;
			}
		
			new_node.setNext(position);
			previous.setNext(new_node);
		}
	}
	
	public void replaceAtIndex (int index, String item) //Done
	{
		Node new_node = new Node (item, null);
		int counter = 1;
		Node position = head;
		
		while (counter != index - 1)
		{
			position = position.getNext();
			counter ++;
		}
		
		new_node.setNext((position.getNext()).getNext());
		position.setNext(new_node);
	}
	
	public void deleteFirstOccurrence (String item) //Done
	{
		Node position = head;
		
		while (!(position.getNext()).getElement().equals(item))
		{
			position = position.getNext();
		}
		
		position.setNext((position.getNext()).getNext());
	}
	
	public void deleteAllOccurrences (String item) //Done
	{
		int num_occurrences = this.noOfOccurrences(item);
		
		for (int i = 0; i < num_occurrences; i++)
		{
			this.deleteFirstOccurrence(item);
		} 
	}
	
	public void deleteLastOccurrence (String item)
	{
		Node position = head;
		int count = 0;
		int num_occurrences = this.noOfOccurrences(item);
		
		while (count < num_occurrences - 1)
		{
			if ((position.getNext()).getElement().equals(item))
			{
				count ++;
			}
			position = position.getNext();
		}
		
		while (!(position.getNext()).getElement().equals(item))
		{
			position = position.getNext();
		}
		
		position.setNext((position.getNext()).getNext());
	}
	
	public boolean containsItem (String item) //Done
	{
		Node position = head;
		boolean is_in_there = false;
		
		while (position.getNext() != null)
		{
			if (position.getElement().equals(item))
			{
				is_in_there = true;
				break;
			}
			
			position = position.getNext();
		}
		
		return (is_in_there);
	}
	
	public int noOfOccurrences (String item) //Done
	{
		Node position = head;
		int counter = 0;
		
		while (position.getNext() != null)
		{
			if (position.getElement().equals(item))
				counter ++;
				
			position = position.getNext();
		}
		
		if (position.getElement().equals(item))
				counter ++;
				
		return (counter);
	}
	
	public int firstPositionOfItem (String item) //Done
	{
		int counter = 1;
		Node position = head;
		
		while (position.getNext() != null)
		{
			if (position.getElement().equals(item))
				break;
				
			position = position.getNext();
			counter ++;
		}
		
		return (counter);
	}
	
	public int[] allPositionsOfItem (String item) //Done
	{
		int counter = 1;
		Node position = head;
		
		int[] position_list = new int [this.noOfOccurrences(item)];
		int index = 0;	
		
		while (position.getNext() != null)
		{
			if (position.getElement().equals(item))
				position_list [index] = counter;
			
			position = position.getNext();
			counter ++;
		}
		
		return (position_list);
	}
}
