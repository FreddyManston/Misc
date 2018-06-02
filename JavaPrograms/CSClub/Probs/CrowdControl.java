//Problem 2 of 2014 SBITC competition at http://www.olympiad.org.za/olympiad/wp-content/uploads/2014/09/2014-SBITC-Complete-problem-set.pdf
import java.util.*;

public class CrowdControl
{
	public static void main (String[] args)
	{
		Scanner input = new Scanner (System.in);
		int cases = input.nextInt();
		int num_robos, count;
		int remove_position = 0, highest_count = 0;
		double stage_height, tallest;
		double [][] robots;
		
		for (int i = 0; i < cases; i ++)
		{
			stage_height = input.nextDouble();
			num_robos = input.nextInt();
			
			robots = new double [2][num_robos];
			for (int j = 0; j < num_robos; j ++)
			{
				robots [0][j] = input.nextDouble();
				robots [1][j] = input.nextDouble();
			}
			
			for (int j = 0; j < num_robos - 1; j ++)
			{
				tallest = 0.0;
				count = 0;
				
				for (int k = 0; k < num_robos; k ++)
				{
					if (k != j && robots [1][k] > tallest)
					{
						tallest = robots [1][k];
						count ++;
					}
				}
				
				if (count > highest_count)
				{
					remove_position = j;
					highest_count = count;
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + remove_position);
		}
	}
}
