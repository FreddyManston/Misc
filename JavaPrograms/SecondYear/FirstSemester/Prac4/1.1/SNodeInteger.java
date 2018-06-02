public class SNodeInteger
{
	private SNodeInteger next;
	private Integer element;
	
	// Creates a node with null references to its element and next node.
	public SNodeInteger()
	{
		this(null, null);
	}
	
	// Creates a node with the given element and next node.
	public SNodeInteger(Integer s, SNodeInteger n) 
	{
 		element = s;
 		next = n;
	}

	// Accessor methods:
	public Integer getElement() 
 	{
		return element;
	}

	public SNodeInteger getNext() 
	{
		return next;
	}

	// Modifier methods:
	public void setElement(Integer s) 
	{
		element = s;
	}

	public void setNext(SNodeInteger n) 
	{
		next = n;
	}
	
}
