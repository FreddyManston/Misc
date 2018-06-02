import java.util.Scanner;

public class PositionDriver
{
	public static void main (String[] args)
	{
		Scanner Reddo = new Scanner(System.in);
		
		Position position = new Position(0, 0);
		System.out.println("\nWe start at position [0,0].");
		
		boolean keep_calm_and_carry_on = true;
		while (keep_calm_and_carry_on)
		{
			System.out.print("\nSelect an option from 1 - 4:\n1) Move in a particular direction.\n2) Check which position you are at.\n3) Check if a set of co_ordinates is equal to your position.\n\n4) Exit.");
			String answ = Reddo.next();
			
			switch(answ)
			{
				case "1":
					System.out.print("Type in the direction. Either north, west, south or east: ");
					String direction = Reddo.next();
					System.out.println();
					
					position = position.getNewPosition(direction);
					
					break;
				
				case "2":
					System.out.print("You are at position ");
					position.writeOutput();
					
					break;
				
				case "3":
					boolean valid_input = false;
					int int_row = 0;
					int int_column = 0;
					
					while (!valid_input)
					{
						try
						{
							System.out.print("Type in the row number of the co-ordinate: ");
							String str_row = Reddo.next();
							int_row = Integer.parseInt(str_row);
							
							System.out.print("\nType in the column number of the co-ordinate: ");
							String str_column = Reddo.next();				
							int_column = Integer.parseInt(str_column);
							
							valid_input = true;
						}
						catch (NumberFormatException e)
						{
							System.out.println("Invalid row/column number");
							continue;
						}
					}
						
					if (position.isEqual(new Position(int_row, int_column)))
					{
						System.out.println("\nThat is indeed equivalent to your current position.\n");
					}
					else
					{
						System.out.println("\nThat is in fact not equivalent to your current position.\n");
					}
		
					break;
				
				case "4":
					System.exit(0);
				
				default:
					System.out.println("Stop joshing around bro, pick an option.");
			}
		}
	}
}
