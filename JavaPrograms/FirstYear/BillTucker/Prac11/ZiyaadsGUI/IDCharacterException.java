
/**
 * Write a description of class IDCharacterException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IDCharacterException extends Exception

{
	public  IDCharacterException()
	{
		super("Invalid ID: enter only deciaml digits.");
		
	}

	public IDCharacterException(String message, char s)
	{
		super((message) + "is an invalid ID #: it contains an illegal character: " + s);
	}
	
}


