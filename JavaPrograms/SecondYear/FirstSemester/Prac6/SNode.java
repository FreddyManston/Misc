public class SNode <E>
{
	private SNode next;
	private E element;
	
	// Creates a node with null references to its element and next node.
	public SNode()
	{
		this(null, null);
	}
	
	// Creates a node with the given element and next node.
	public SNode(E s, SNode n) 
	{
 		element = s;
 		next = n;
	}

	// Accessor methods:
	public E getElement() 
 	{
		return element;
	}

	public SNode getNext() 
	{
		return next;
	}

	// Modifier methods:
	public void setElement(E s) 
	{
		element = s;
	}

	public void setNext(SNode n) 
	{
		next = n;
	}
	
}
