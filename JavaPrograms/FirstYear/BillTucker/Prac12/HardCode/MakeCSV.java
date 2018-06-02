import java.io.*;
import java.util.*;

/**
* MakeCSV program transfers the objects (of type Employee) from a binary file (.dat) to a text file (.csv).
* @author Joshua Abraham - 3475896
* @param Raddo Scanner object to ask the user for input
* @param inputStream ObjectInputStream object to open the binary file (.dat)
* @param outputStream ObjectOutputStream object to open the text file (.csv)
* @param employees[] a list of Employee objects, of size 10
* @param datFile a String for the name of the binary file
* @param CSVFile a String for the name of the text file
* @param index an integer to keep track of how many employees are read from the binary file
*/
public class MakeCSV
{
	private static Scanner Reddo = new Scanner(System.in);
	private static ObjectInputStream inputStream = null;
	private static PrintWriter outputStream = null;
	private static Employee employees[] = new Employee [10];
	private static String datFile, CSVFile;
	private static int index = 0;
	
	/**
	* The main method of the MakeCSV class. Asks the user for the names of the binary and text files respectively.
	* Uses the names of the files to call on the ReadData method and then the WriteData method after sorting the list of employees.
	*/
	public static void main (String[] args)
	{
		System.out.print("Input file: ");
		datFile = Reddo.next();
		
		System.out.println("Output file: ");
		CSVFile = Reddo.next();
		
		ReadData(datFile);
		
		Arrays.sort(employees);
		WriteData(CSVFile);
	}
	
	/**
	* ReadData method opens the binary file (using inputStream) and reads Employee objects from the file.
	* Appends the objects, one by one, to employees[]. Closes the stream once it's done.
	* Throws and catches ArrayFullException, along with the Exceptions related with the ObjectInputStream class.
	* @param fileName parameter of the method, which is the name of the binary file which the Employee objects will be read from.
	* @param keep_calm_and_carry_on a boolean variable (default set to true) that keeps track of whether or not another Employee object can be read from the binary file.
	*/
	public static void ReadData(String fileName)
	{
		try
		{
			if (! new File(fileName).exists())
				throw new FileNotFoundException();
			if (! new File(fileName).canRead())
			{	
				System.out.println("can not read the file " + fileName);
				System.exit(0);
			}
			inputStream = new ObjectInputStream(new FileInputStream(fileName));
			
			boolean keep_calm_and_carry_on = true;
			// While loop to keep reading objects from the binary file until the list is full or there are no more objects to read.
			while (keep_calm_and_carry_on)
			{
				if (index >= 10)
					throw new ArrayFullException();
					
				employees [index] = (Employee) inputStream.readObject();
				index++;
			}
			inputStream.close();
			Arrays.sort(employees, 0, index);
			WriteData(CSVFile);
		}
		
		// FIleNotFoundException catch block asks for a new binary file name and calls the ReadData method again with the new name
		catch (FileNotFoundException e)
		{
			System.out.println("Input file " + fileName + " does not exist.");
			System.exit(0);
		}
		// EOFException catch block sorts current employee list and proceeds to call the WriteData method
		catch (EOFException e)
		{			
			Arrays.sort(employees, 0, index);
			WriteData(CSVFile);
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException");
			System.exit(0);
		}
		catch (InvalidClassException e)
		{
			System.out.println("InvalidClassException");
			System.exit(0);
		}
		catch (OptionalDataException e)
		{
			System.out.println("OptionalDataException");
			System.exit(0);
		}
		catch (IOException e)
		{
			System.out.println("IOException");
			System.exit(0);
		}
		// ArrayFullException catch block sorts current employee list and proceeds to call the WriteData method
		catch (ArrayFullException e)
		{
			Arrays.sort(employees, 0, index);
			WriteData(CSVFile);
		}
	}
	
	/**
	* WriteData method opens the text file (using outputStream) and writes Employee objects to the file. Closes the stream once the operation is concludes.
	* Throws and catches Exceptions related with the ObjectOutputStream class.
	* @param fileName parameter of the method, which is the name of the text file which the Employee objects will be written to.
	*/
	public static void WriteData(String fileName)
	{
		try
		{
			if (! new File(fileName).exists())
				throw new FileNotFoundException();
			if (! new File(fileName).canWrite())
			{	
				System.out.println("can not write to the file " + fileName);
				System.exit(0);
			}
			
			outputStream = new PrintWriter(fileName);
			
			int i = index;
			outputStream.println("Name,Salary,ID Number");
			System.out.println("Name,Salary,ID Number");
			while (i <= index)
			{
				outputStream.println(employees[i].getName() + "," + employees[i].getSalary() + "," + employees[i].getID());
				System.out.println(employees[i].getName() + "," + employees[i].getSalary() + "," + employees[i].getID());
				i++;
			}
			outputStream.close();
			System.out.println("End of program.");
			System.exit(0);
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("Output file " + fileName + " does not exist.");
			System.exit(0);
		}
		/*catch (IOException e)
		{
			System.out.println("IOException");
			System.exit(0);
		}*/
		catch(Exception e)
		{
		}
	}
}

