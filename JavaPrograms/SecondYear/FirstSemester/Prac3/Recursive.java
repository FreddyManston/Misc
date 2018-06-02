import java.util.Arrays;

public class Recursive
{
	public static void main (String[] args)
	{
		Recursive object = new Recursive();
		object.run();	
	}
	
	public void Seperator (int [] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			if ((array [i] % 2) != 0 && (array [i - 1] % 2) == 0)
			{
				int temp = array [i];
				array [i] = array [i - 1];
				array [i - 1] = temp;
			}	
		}
		
		for (int i = 1; i < array.length; i++)
		{
			if ((array [i] % 2) != 0 && (array [i - 1] % 2) == 0)
				this.Seperator(array);
		}
	}
	
	public void sortEvenSection (int [] array)
	{
		int first_occurence = 0;
		while (first_occurence < array.length)
		{
			if (array [first_occurence] % 2 == 0)
				break;
				
			first_occurence++;
		}
		
		int [] even_part = Arrays.copyOfRange(array, first_occurence, (array.length));
		
		if (even_part.length != 1)
		{
			for (int index = 1; index < even_part.length; index ++)
			{	
				int i = index;
				int temp = even_part [index];
				
				while (i > 0)
				{
					if (temp < even_part [i - 1])
					{
						even_part [i] = even_part [i - 1];
						even_part [i - 1] = temp;
						i --;
					}
					else
						break;
				}
			}
		}
		
		for (int i = 0; i < even_part.length; i++)
		{
			array [first_occurence + i] = even_part [i];
		}
	}
	
	public void sortOddSection (int [] array)
	{
		int last_occurence = 0;
		while (last_occurence < array.length)
		{
			if (array [last_occurence] % 2 == 0)
				break;	
			last_occurence++;
		}
		
		int [] odd_part = Arrays.copyOfRange(array, 0, (last_occurence));
		if (odd_part.length != 1)
		{
			for (int index = 1; index < odd_part.length; index ++)
			{	
				int i = index;
				int temp = odd_part [index];
				
				while (i > 0)
				{
					if (temp < odd_part [i - 1])
					{
						odd_part [i] = odd_part [i - 1];
						odd_part [i - 1] = temp;
						i --;
					}
					else
						break;
				}
			}
		}
		
		for (int i = 0; i < odd_part.length; i++)
		{
			array [i] = odd_part [i];
		}
	}
	
	public void run ()
	{
		int [] array = {70, 13, 48, 19, 24, 5, 7, 10};
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array [i] + " ");
		} System.out.println();

		Seperator(array);
		//sortOddSection(array);
		//sortEvenSection(array);
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array [i] + " ");
		} System.out.println();
	}
}
