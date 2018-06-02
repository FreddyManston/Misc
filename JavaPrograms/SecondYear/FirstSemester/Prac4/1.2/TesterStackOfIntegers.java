import java.util.*;
import java.lang.*;
public class TesterStackOfIntegers
{
	public static void main (String[] args)
	{
		LinkedStackInteger IntegerStack = new LinkedStackInteger();
		Scanner Reddo = new Scanner (System.in);
		boolean keep_calm_and_carry_on = true;
		
		while (keep_calm_and_carry_on)
		{
			System.out.println("\nSelect an option from 1 - 6:\n\n1) Check if the stack is empty.\n2) Check the number of elements that are stacked up.\n3) Place an item on top of the stack.\n4) Take an item off the top of the stack.\n5) Check what the top item in the stack is.\n6) Display the contents of the stack.\n7) Exit.");
			String answ = Reddo.next();
		
			if (answ.equals("1"))
			{
				if (IntegerStack.isEmpty())
				{
					System.out.println("\nStack is empty.");
				}
				
				else
				{
					System.out.println("\nStack is not empty.");
				}
			}
			
			else if (answ.equals("2"))
			{
				System.out.println("\n" + IntegerStack.getHeight());
			}
			
			else if (answ.equals("3"))
			{
				System.out.print("\nType your input: ");
				int input = Reddo.nextInt();
				Integer new_input = new Integer (input);
	
				IntegerStack.push(new_input);
			}
		
			else if (answ.equals("4"))
			{
				Integer item = IntegerStack.pop();
			}
			
			else if (answ.equals("5"))
			{
				Integer item = IntegerStack.head();
				System.out.println("\n" + item);
			}
			
			else if (answ.equals("6"))
			{
				IntegerStack.display();
			}
			
			else if (answ.equals("7"))
			{
				keep_calm_and_carry_on = false;
			}
			
			else
				System.out.println("Invalid input, bro, try again.");
		}
	}
}
