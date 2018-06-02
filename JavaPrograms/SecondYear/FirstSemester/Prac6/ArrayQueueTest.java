import java.util.*;

public class ArrayQueueTest
{
	public static void main (String[] args)
	{
		Scanner Reddo = new Scanner (System.in);
		System.out.print("Type in the length of the queue array: ");
		int length = Reddo.nextInt();
		ArrayQueue the_queue = new ArrayQueue(length);
		boolean keep_calm_and_carry_on = true;
		
		while (keep_calm_and_carry_on)
		{
			System.out.print("\nType an option:\n1: Enqueue\n2:Dequeue\n3:Check the head\n4:Check the size\n5:Is it empty?\n6:Is it full?\nType anything else to exit");
			String answ = Reddo.next();
			
			if (answ.equals("1"))
			{	
				try
				{	
					System.out.print("\nType in the value to enqueue: ");
					String object = Reddo.next();
					
					the_queue.enqueue(object);
				}
				catch (Exception e)
				{
					System.out.println("Class exception thrown. Try again.");
				}
			}
			else if (answ.equals("2"))
			{
				System.out.println("\n" + the_queue.dequeue());
			}
			else if (answ.equals("3"))
			{
				System.out.println("\n" + the_queue.front());
			}
			else if (answ.equals("4"))
			{
				System.out.println("\n" + the_queue.size());
			}
			else if (answ.equals("5"))
			{
				System.out.println("\n" + the_queue.isEmpty());
			}
			else if (answ.equals("6"))
			{
				System.out.println("\n" + the_queue.isFull());
			}
			else
			{
				System.out.println("\nDone");
				keep_calm_and_carry_on = false;
			}
		}
	}
}
