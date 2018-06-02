import java.util.Scanner;

public class Question3
{
	int[] numbers;
	
	public void storeValues(int amount)
	{
		numbers = new int [amount];
		for (int i = 0; i < numbers.length; i ++)
			numbers [i] = i + 2;
	}
	
	public void replaceMultiplesWithZeros(int start, int jump)
	{
		int index = start + jump;
		
		while (index < numbers.length)
		{
			if ((numbers [index] % jump) == 0)
				numbers [index] = 0;
				
			index = index + jump;		
		}
		
	}
	
	public void performSiftingProcess()
	{
		for (int i = 0; i < numbers.length; i ++)
		{
			if (numbers [i] != 0)
			{
				replaceMultiplesWithZeros(i, numbers [i]);
			}
		}
	}
	
	public void displayArray(int[] numbr_list)
	{
		for (int i = 0, j = 1; i < numbr_list.length; i ++)
		{
			if(numbr_list[i] != 0)
			{
				System.out.print(j + ") " + numbr_list[i] + "\t\t");
				j++;
			}
		}
		System.out.println();
	}
	
	public void run(int num)
	{
		storeValues(num);
		performSiftingProcess();
		displayArray(numbers);
	}
	
	public static void main (String[] args)
	{
		Question3 object = new Question3();
		object.run(1000);
	}
}

