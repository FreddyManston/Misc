public class RosalindProblemsFib
{

	public static int FibonacciRabbits (int months, int offspring)
	{
		return (NumOfPairs(1, 0, months - 1, offspring));
	}
	
	public static int NumOfPairs (int immatures, int matures, int months_left, int births)
	{
		if (months_left <= 1)
		{
			int new_matures = matures + immatures;
			int new_immatures = births * matures;
			
			return (new_immatures + new_matures);
		}
			
		else
			return(NumOfPairs(births*matures, matures + immatures, months_left - 1, births));
	}
	
	public static void main (String[] args)
	{
		System.out.println(FibonacciRabbits(5, 3));
	}
}



