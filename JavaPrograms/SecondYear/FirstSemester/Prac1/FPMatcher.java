import java.util.*;
import java.io.*;

public class FPMatcher
{
	public static Coordinate tf1_coord[] = new Coordinate [30];
	static Scanner inputStream = null;
	
	public static void main (String[] args)
	{	
		inputStream = new Scanner(new File("TestFile1.csv"));
		
		int index = 0;
		while (inputStream.hasNextLine())
		{
			String coordinates = inputStream.nextLine().useDelimiter(",");
			int x = coordinates.nextLine();
			int y = coordinates.next();
			tf1_coord [index] = Coordinate(x, y);
			
		}inputStream.close();
		
	}
	
	public static void ReadData (String file_name)
	{
		try
		{
			File new_file = new File(file_name);
			inputStream = new Scanner(new_file);
		}
		catch(FileNotFoundException exception)
		{
			System.out.println("Error opening the file " + file_name);
			System.exit(0);
		}
		
		while(inputStream.hasNextLine())
		{
			String coordinates =  inputStream.nextLine();
		} inputStream.close();
	}
	
	public static double distanceBetween(Coordinate c1, Coordinate c2)
	{
		int x1 = c1.getXCoordinate();
		int y1 = c1.getYCoordinate();
		int x2 = c2.getXCoordinate();
		int y2 = c2.getYCoordinate();
		
		double dist_betwn = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		return (dist_betwn);
	}	
}
