import java.io.*;
import java.util.*;

public class FileIOBasics
{
	public static void main (String[] args)
	{
		Scanner Reddo = new Scanner (System.in);
		
		String file_name = "zout.txt";
		
		// Writing to the file:
		PrintWriter outputStream = null;	// outputStream declared here, so that it can be called on through out the code...
		
		// ...but created in a try block so that the FileNotFoundException can be thrown.
		try
		{
			outputStream = new PrintWriter (file_name);
		}
		
		catch (FileNotFoundException exception)
		{
			System.out.println("No such file.");
			System.exit(0);
		}
		
		System.out.println("Type in 3 lines of text to put in the " + file_name + " file:");
		
		for (int i = 0; i < 3; i++)
		{
			String text = Reddo.nextLine();
			outputStream.println(text);
		}System.out.println("\n");
		
		outputStream.close();	// Make sure to close the stream, otherwise output might not get printed to the file.
		
		// Reading from the file:
		Scanner inputStream = null;
		
		System.out.print("Type in the file name/path that you want to read from: ");
		String fileName = Reddo.next();
		File fileObject = new File(fileName);

		boolean fileOK = false;
		
		while (!fileOK)
		{
			if (!fileObject.exists())	// Mehtod to check if the file exists
				System.out.println("No such file");
			else if (!fileObject.canRead())	// Method to check if the file is readable
				System.out.println("That file is not readable.");
			else
				fileOK = true;

			if (!fileOK)
			{
				System.out.println("Enter file name again:");
				fileName = Reddo.next();
				fileObject = new File(fileName);
			}
		}
		
		try
		{
			inputStream = new Scanner(fileObject);	// Scanner constructor takes a object of File class, instead of a String
		}
		
		catch (FileNotFoundException exception)
		{
			System.out.println("Error opening the file " + file_name);
			System.exit(0);
		}
		
		while (inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			System.out.println(line);
		}
		System.out.println("\nThe path name of the file is: " + fileObject.getPath());
		System.out.println("Do you want delete the file? Yes (Y) or No (N)");
		String del = Reddo.next();
		
		if (del.equalsIgnoreCase("Y") || del.equalsIgnoreCase("Yes"));
		{
			System.out.println("Are you sure? Yes (Y) or No (N)");
			String ans = Reddo.next();
			
			if (ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("Yes"));
			{
				boolean deleted = fileObject.delete();
				
				if (deleted)
					System.out.println("It has been done.");
				else
					System.out.println("I can't bring myself to do it... Delete it yourself, you monster.");
			}
		}
		
		inputStream.close();
	}
}
