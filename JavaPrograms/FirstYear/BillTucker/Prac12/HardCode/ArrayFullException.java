/**
* ArrayFullException Class
* @author Joshua Abraham
* This is the exception class for an array which is in the process of exceeding it's limit, which extends the exception base class.
*/
public class ArrayFullException extends Exception
{
	/**
	* ArrayFullException()
	* Default constructor for the ArrayFullException class.
	*/
	ArrayFullException()
	{
		super("The array is full. No more entries are allowed.");
	}
	
	/**
	* ArrayFullException()
	* Default constructor for the ArrayFullException class.
	* @param message a string which will be used to set the message of the exception.
	*/
	ArrayFullException(String message)
	{
		super(message);
	}
}
