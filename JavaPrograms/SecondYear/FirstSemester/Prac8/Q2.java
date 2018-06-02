import java.io.*;
import java.util.*;

public class Q2
{
	public static void main (String[] args) throws Exception
	{
		// Reading from the file:
		Scanner inputStream = null;
		String file_name = "DATA.txt";
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
		
		Heap heap = new Heap(arr1.length);
		heap.setElement(arr1);
		System.out.println("Heap size: " + heap.getHeapSize());
		//heap.display("Unsorted");
		heap.sort();
		//heap.display("Sorted");		
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
