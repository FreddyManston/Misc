/**
* IDLengthException Class
* @author Joshua Abraham
* This is the class for an incorrect ID length exception, which extends the exception base class.
*/

public class IDLengthException extends Exception
{
	/**
	* IDLengthException()
	* Default constructor for the IDLengthExcerption class.
	*/
	IDLengthException()
	{
		super("An ID number must contain exactly 13 numbers.");
	}
	
	/**
	* IDLengthException()
	* Default constructor for the IDLengthExcerption class..
	* @param message A string that will be used to set the exception message.
	*/
	IDLengthException(String message)
	{
		super(message);
	}
}

