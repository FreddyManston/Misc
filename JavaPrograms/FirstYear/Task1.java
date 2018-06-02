//Author: Joshua Abraham - 3475896
//Name: Task 1

import java.util.Scanner;

public class Task1
{
	public static void main (String[] args)
	{
		
		Scanner Ask = new Scanner(System.in);
		
		String do_loop = "Y";
		
		// While loop to continue asking user for input, until user says no more.
		while (do_loop.equalsIgnoreCase("Y"))
		{
			System.out.println("How old are you?");
			int age = Ask.nextInt();
			
			System.out.println("Was the car manufactured in South Africa? (Y/N)");
			String inSA = Ask.next();
		
			System.out.println("Does the driver have a good or bad record? (G/B)");
			String record = Ask.next();
			
			// If statement to compute whether user is older than 25.
			if (age >= 25)
			{
				// If statement to compute whether car is South African.
				if (inSA.equalsIgnoreCase("Y"))
				{
					// If statement to compute whether record is bad.
					if (record.equalsIgnoreCase("B"))
					{
						System.out.println("Your premium will be 7% of the car's book value.");
					}
					// Else record is bad.
					else
					{
						System.out.println("Your premium will be 6% of the car's book value.");
					}	
				}
				// Else car is foreign.
				else
				{
					// If statement to compute whether record is bad.
					if (record.equalsIgnoreCase("B"))
					{
						System.out.println("Your premium will be 7.5% of the car's book value.");
					}
					// Else record is bad.
					else
					{
						System.out.println("Your premium will be 6.5% of the car's book value.");
					}
				}
			}
			//else user is younger than 25.
			else
			{
				// If record bad, no policy.
				if (record.equalsIgnoreCase("B"))
				{
					System.out.println("We can issue you no policy. Have a nice day.");
				}
				// Else record is good
				else
				{
					// If statement to compute whether car is South African.
					if (inSA.equalsIgnoreCase("Y"))
					{
						System.out.println("Your premium will be 7.25% of the car's book value.");
					}
					// Else car is foreign.
					else
					{
						System.out.println("Your premium will be 8% of the car's book value.");
					}
				}	
			}
			
			// Ask user if s/he will go again.
			System.out.println("Would you like another quote?");
			do_loop = Ask.next();
		}
	}
}
