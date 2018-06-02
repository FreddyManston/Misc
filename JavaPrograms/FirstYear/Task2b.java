import java.util.Scanner;

public class Task2b
{
	public static void main (String[] args)
	{
	
		Scanner Ask = new Scanner(System.in);
			
		double[] array_of_ages = new double [100]; // Declaring an array of ages, initially empty.
		int index = 0;	// Running variable used in while loop.
		
		/*
			While loop to ask user for 100 ages and 
			appends each age to 'array_of_ages'.
		*/
		while (index < 100)
		{
			System.out.println("How old are you?");
			double age = Ask.nextDouble();
			
			array_of_ages[index] = age;
			
			index++;
		}
		
		double sum_of_ages = 0;
		/*
			For loop to run through each age in 'array_of_ages',
			to calculate the sum of all ages.
		*/
		for (double element: array_of_ages)
		{
			sum_of_ages = element + sum_of_ages;
		}
		
		double average = sum_of_ages / 100;
		
		int younger = 0;
		int older = 0;
		
		for (double element: array_of_ages)
		{
			if (element > average)
				older++;
			else if (element < average)
				younger++;
		}
		
		System.out.println ("The amount of people who are older than the average age is: " + older);
		System.out.println ("The amount of people who are younger than the average age is: " + younger);
	}			
}
