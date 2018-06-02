
/**
 * Write a description of class ArrayFullException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayFullException extends Exception

{
	public  ArrayFullException()
	{
		super("Array full!");
		
	}

	public ArrayFullException(String message)
	{
		super(message);
	}
	

}
