/**
* IDCharacterException Class
* @author Joshua Abraham
* This is the class for an incorrect ID character exception, which extends the exception base class.
*/
public class IDCharacterException extends Exception
{
	/**
	* IDCharacterException()
	* Default constructor for the IDCharacterException class.
	*/
	IDCharacterException()
	{
		super("Only numbers are allowed in an ID number.");
	}
	
	/**
	* IDCharacterException()
	* Default constructor for the IDCharacterException class.
	* @param message a string that will be used to set the message of the exception.
	*/
	IDCharacterException(String message)
	{
		super(message);
	}
}
