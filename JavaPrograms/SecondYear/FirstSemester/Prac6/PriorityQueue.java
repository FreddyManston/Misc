public class PriorityQueue
{
	private PriorityNode head = null;
	private int count = 0;
	
	public PriorityQueue()
	{
		
	}
	
	public void enqueue(QueueElement q)
	{
		PriorityNode new_node = new PriorityNode(q, null);
		
		if (count == 0)
		{
			head = new_node;
		}
		else if (count == 1)
		{
			if (head.getElement().getPriority() > q.getPriority())
			{
				new_node.setNext(head);
				head = new_node;
			}
			else
			{
				head.setNext(new_node);
			}
		}
		else
		{
			PriorityNode shifter1 = head;
			
			while (shifter1.getNext() != null || shifter1.getNext().getElement().getPriority() < q.getPriority())
			{
				shifter1 = shifter1.getNext();
			}
			new_node.setNext(shifter1.getNext());
			shifter1.setNext(new_node);
		}
		count++;
	}
	
	public QueueElement dequeue()
	{
		if (count == 0)
		{
			System.out.println("Queue is empty exception thrown.");
			return (new QueueElement(0, "No task"));
		}
		else if (count == 1)
		{
			QueueElement take_me_away = head.getElement();
			head = null;
			
			count --;
			return take_me_away;
		}
		else
		{
			QueueElement take_me_away = head.getElement();
			head = head.getNext();
			
			count --;
			return take_me_away;
		}
	}
	
	public boolean isEmpty()
	{
		return (count == 0);
	}
	
	public int getSize()
	{
		return count;
	}
	
	public QueueElement front()
	{
		if (count == 0)
		{
			System.out.println("Queue is empty exception thrown.");
			return (new QueueElement(0, "No task"));
		}
		else
		{
			return (head.getElement());
		}
	}
}
