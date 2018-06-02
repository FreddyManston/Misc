import java.io.*;
import java.util.*;

public class Q1
{
	static String [] sorted_arr;
	static int crrnt_index = 0;
	
	public static void main (String[] args)
	{
		// Reading from the file:
		Scanner inputStream = null;
		String file_name = "DATA.txt";
		File fileObject = new File(file_name);
		
		try
		{
			inputStream = new Scanner(fileObject);	// Scanner constructor takes a object of File class, instead of a String.
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("Error opening the file " + file_name);
			System.exit(0);
		}
		
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
		int index = 0;
		while (inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			arr1 [index ++] = line;
		} inputStream.close();
		
		String[] arr2 = new String [arr1.length];
		for (int i = 0; i < num_lines; i++)
			arr2 [i] = arr1 [i];
			
		Arrays.sort(arr1);
		sorted_arr = new String [num_lines];
		balanceSort(arr1);
		
		BST tree = new BST();
		for (int i = 0; i < num_lines; i++)
			tree.insert(sorted_arr [i]);
		
		System.out.println("\n#Nodes: " + tree.countNodes(tree.getRoot()));
		System.out.println("Height: " + tree.height(tree.getRoot()));
		
		for (int i = 0; i < num_lines; i++)
			tree.delete(arr2 [i]);
		
		System.out.println("\n#Nodes: " + tree.countNodes(tree.getRoot()));
		System.out.println("Height: " + tree.height(tree.getRoot()));
		
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
	
	public static void balanceSort (String [] sort_me)
	{		
		if (sort_me.length == 1)
		{
			sorted_arr [crrnt_index] = sort_me [0];
			crrnt_index ++;
		}
		else if (sort_me.length == 2)
		{
			sorted_arr [crrnt_index] = sort_me [1];
			crrnt_index ++;
			sorted_arr [crrnt_index] = sort_me [0];
			crrnt_index ++;
		}
		else
		{
			int middle_index = sort_me.length / 2;
			sorted_arr [crrnt_index] = sort_me [middle_index];
			crrnt_index ++;
		
			String [] left_half;
			String [] right_half;
			
			if (sort_me.length % 2 == 0)
			{
				left_half = new String [sort_me.length - middle_index];			
				right_half = new String [sort_me.length - middle_index - 1];
			}
			else
			{
				left_half = new String [sort_me.length - middle_index - 1];
				right_half = new String [sort_me.length - middle_index - 1];
			}
			
			System.arraycopy(sort_me, 0, left_half, 0, left_half.length);
			System.arraycopy(sort_me, middle_index + 1, right_half, 0, right_half.length);
				
			balanceSort(left_half);
			balanceSort(right_half);
		}
	}
}
