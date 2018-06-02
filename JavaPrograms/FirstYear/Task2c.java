//Author: Joshua Abraham - 3475896
//Name: Try

import java.util.Scanner;

public class Try
{	
	private int count=0;
	private double age=0,sum=0;
	public static void main (String[] args)
	{
		double age = 0, sum = 0;
		int count = 0;
		System.out.println(get_age(age, sum, count));
	}
	
	public static String get_age(double age, double sum, int count)
	{
		String the_return = "";
		if (count < 6)
		{
			Scanner Ask = new Scanner(System.in);
			
			System.out.println("How old are you?");
			this.age = Ask.nextDouble();
			
			this.count++;
			this.sum = add_age(this.age, sum, count);
			//System.out.println(count);
			//System.out.println(sum);
			
			String eventual_average = get_age(this.age, this.sum, count);
			System.out.print(eventual_average+" ");
			//System.out.println(String.valueOf(age).compareTo(eventual_average));
			if (String.valueOf(this.age).compareTo(eventual_average) < 0)
				return ("1");
			if (String.valueOf(this.age).compareTo(eventual_average) > 0)
				return ("2");
		}
		
		else
		{	
			/* Supposed to return a concatenation of a 1 to the average, if current age is lower and
			 * a 2 if it's lower.
			 * Then when recursion gets back to the first occurence, it will have the average concatenated
			 * with all the lower than averages (in the form of # of 1's) and all the higher than averages
			 * (in the form of # of 2's).
			*/
			if (this.age < this.sum)
			{
				the_return = (String.valueOf(sum) + " 1");
				return ("TheReturn Value: " + the_return);
			}
			if (this.age > this.sum)
			{
				the_return = (String.valueOf(sum) + " 2");
				return ("TheReturn Value: " + the_return);
			}
		}
		
		return (the_return);	
	}
	
	/** 
	* Calculates and returns the sum of all previous ages, until the 100th age.
	* At the 100th age it calculates the sum, but now returns the average of all ages, instead of the sum.
	*/
	public static double add_age(double age, double sum, int count)
	{
		if (count < 5)
		{
			sum = age + sum;
			return (sum);
		}
		else
		{
			sum = age + sum;
			double average = sum/count;
			System.out.println("final average" + average);
			return (average);
		}
	}
}












