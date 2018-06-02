import java.io.*;
import java.util.*;

public class Q3
{
	public static void main (String[] args)
	{		
		// Reading from the file:
		Scanner inputStream = null;
		String file_name = "DATA.txt";
		
		int num_lines = 0;
		try 
		{
			num_lines = countLines(file_name);
		}
		catch (IOException e) 
		{
			System.out.println("IOException");
			System.exit(0);
		}
		
		String [] arr1 = new String [num_lines];
		
		File fileObject = new File(file_name);
		try
		{
			inputStream = new Scanner(fileObject);	// Scanner constructor takes a object of File class, instead of a String
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("Error opening the file " + file_name);
			System.exit(0);
		}
		
		int i = 0;
		while (inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			arr1 [i ++] = line;
		} inputStream.close();
			
		arr1 = mergeSort(arr1);
	}
	
	public static String[] mergeSort(String[] arr1)
	{
		if (arr1.length > 1)
		{
			int middle = arr1.length / 2;
			String[] first_half = new String [middle];
			String[] last_half = new String [arr1.length - (middle)];
			
			System.arraycopy(arr1, 0, first_half, 0, first_half.length);
			System.arraycopy(arr1, middle, last_half, 0, last_half.length);
			
			arr1 = mergeHelp (first_half, last_half, arr1);
		}
		
		return arr1;
	}
	
	/* String[] arr1 : first half of array that needs sorting.
	*  String[] arr2 : last half of array that needs sorting.
	*  String[] arr3 : the array that needs sorting.
	*/
	public static String[] mergeHelp(String[] arr1, String[] arr2, String[] arr3)
	{
		if (arr1.length == 1 && arr2.length == 1)
		{
			arr3 = merge(arr1, arr2);
		}
		else if (arr1.length == 1 && arr2.length == 2)
		{
			int middle2 = arr2.length / 2;
			String[] first_half2 = new String [middle2];
			String[] last_half2 = new String [arr2.length - (middle2)];
			System.arraycopy(arr2, 0, first_half2, 0, first_half2.length);
			System.arraycopy(arr2, middle2, last_half2, 0, last_half2.length);
			arr2 = mergeHelp (first_half2, last_half2, arr2);
			
			arr3 = merge(arr1, arr2);
		}
		else if (arr1.length > 1)
		{
			int middle1 = arr1.length / 2;
			String[] first_half1 = new String [middle1];
			String[] last_half1 = new String [arr1.length - (middle1)];
			System.arraycopy(arr1, 0, first_half1, 0, first_half1.length);
			System.arraycopy(arr1, middle1, last_half1, 0, last_half1.length);
			arr1 = mergeHelp (first_half1, last_half1, arr1);
			
			/*System.out.println("arr1: ");
			for (int k = 0; k < arr1.length; k++)
				System.out.println(arr1 [k]);*/
			
			int middle2 = arr2.length / 2;
			String[] first_half2 = new String [middle2];
			String[] last_half2 = new String [arr2.length - (middle2)];
			System.arraycopy(arr2, 0, first_half2, 0, first_half2.length);
			System.arraycopy(arr2, middle2, last_half2, 0, last_half2.length);
			arr2 = mergeHelp (first_half2, last_half2, arr2);
			
			/*System.out.println("\narr2: ");
			for (int k = 0; k < arr2.length; k++)
			{
				System.out.println(k);
				System.out.println(arr2 [k]);
			}*/
			
			arr3 = merge(arr1, arr2);
		}

		return arr3;	
	}
	
	static int comparisons = 0;
	public static String[] merge (String[] arr1, String[] arr2)
	{
		String[] arr3 = new String[arr1.length + arr2.length];
		int i = 0;
		int index1 = 0;
		int index2 = 0;
		while (index1 < arr1.length && index2 < arr2.length)
		{
			comparisons = comparisons + 1;
			System.out.println("Comparison #" + comparisons + " " + arr1 [index1] + " & " + arr2 [index2]);
			if (arr1 [index1].compareTo(arr2 [index2]) < 0)
			{
				arr3 [i ++] = arr1 [index1 ++];
			}
			else if (arr1 [index1].compareTo(arr2 [index2]) > 0)
			{
				arr3 [i ++] = arr2 [index2 ++];
			}
			else
			{
				arr3 [i ++] = arr1 [index1 ++];
				arr3 [i ++] = arr2 [index2 ++];
			}
		}
		
		if (index1 < arr1.length)
			while (index1 < arr1.length)
				arr3 [i ++] = arr1 [index1 ++];
		else if (index2 < arr2.length)
			while (index2 < arr2.length)
				arr3 [i ++] = arr2 [index2 ++];
	
		return arr3;
	}
	
	public static int countLines(String filename) throws IOException
	{
		LineNumberReader reader  = new LineNumberReader(new FileReader(filename));
		int count = 0;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {}

		count = reader.getLineNumber(); 
		reader.close();
		
		return count;
	}
}
