import java.util.Scanner;

public class MultiplicationTest
{
	public static void main(String[] args)
	{
			
		System.out.println("Let's start the test.");
		boolean not_mastered = true;
		while (not_mastered)
		{
			not_mastered = mastered(10, 2, 5);
			if (not_mastered == true)
			{
				System.out.println("That's not good enough. You need at least 80% to pass this test.\nYou'll have to take it again.");
				System.out.println("Let's start.");
			}
			else 
				System.out.println("So congratulations! You've passed this level (:");
		}
	}
	
	public static boolean mastered(int num_questions, int lowest_num, int highest_num)
	{
		Scanner RedStreak = new Scanner(System.in);
		
		int incorrect = 0;
		for (int i = 0; i < num_questions; i++)
		{
			int random1 = (int)((Math.random()*(highest_num-1) + lowest_num));
			int random2 = (int)((Math.random()*(highest_num-1) + lowest_num));
			
			System.out.print((i+1) + ") " + random1 + " x " + random2 + " = ");
			int answer = RedStreak.nextInt();
			
			if (answer != random1*random2)
			{
				System.out.println("That's wrong, bruh.");
				incorrect++;
			}
			else
				System.out.println("That is correct.");
		}
				
		double percentage = (num_questions-incorrect)*100/num_questions;
		System.out.println("You got " + (num_questions-incorrect) + " right. That's " + percentage + "%.");
		
		if (percentage > 80.00)
			return (false);
		else
			return (true);
	}
}
