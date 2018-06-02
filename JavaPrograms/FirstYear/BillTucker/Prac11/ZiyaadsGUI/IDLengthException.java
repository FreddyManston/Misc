
/**
 * Write a description of class IDLengthException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IDLengthException extends Exception

{
	public  IDLengthException()
	{
		super("ID Length too long!");
		
	}

	public IDLengthException(String message)
	{
		super(message);
	}
	

}
