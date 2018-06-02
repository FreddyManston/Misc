import java.util.*;

public class PriorityQueueTest
{
	public static void main (String[] args) throws Exception
	{
		Scanner Reddo = new Scanner (System.in);
		PriorityQueue the_queue = new PriorityQueue();
		boolean keep_calm_and_carry_on = true;
		
		while (keep_calm_and_carry_on)
		{
			System.out.print("\nType an option:\n1: Enqueue\n2:Dequeue\n3:Check the head\n4:Check the size\n5:Is it empty?\nType anything else to quit.");
			String answ = Reddo.next();
			
			if (answ.equals("1"))
			{	
				try
				{	
					System.out.print("\nType in the task to enqueue: ");
					String task = Reddo.next();
					System.out.print("Type in the priority of the task: ");
					int priority = Reddo.nextInt();
					
					QueueElement element = new QueueElement(priority, task);
					the_queue.enqueue(element);
				}
				catch (Exception e)
				{
					System.out.println("\nClass exception thrown. Try again.");
					continue;
				}
			}
			else if (answ.equals("2"))
			{
				String task = the_queue.dequeue().getTask();
				System.out.println(task);
			}
			else if (answ.equals("3"))
			{
				String task = the_queue.front().getTask();
				System.out.println(task);
			}
			else if (answ.equals("4"))
			{
				System.out.println(the_queue.getSize());
			}
			else if (answ.equals("5"))
			{
				System.out.println(the_queue.isEmpty());
			}
			else
			{
				System.out.println("\nDone.");
				keep_calm_and_carry_on = false;
			}
		}
	}
}
