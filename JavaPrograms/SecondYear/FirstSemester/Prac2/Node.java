public class Node 
{
	private String element; //assume elements are strings
	private Node next;

	// Creates a node with null references to its element and next node.
	public Node() 
	{
		this(null, null);
	}

	// Creates a node with the given element and next node.
	public Node(String s, Node n) 
	{
 		element = s;
 		next = n;
	}

	// Accessor methods:
	public String getElement() 
 	{
		return element;
	}

	public Node getNext() 
	{
		return next;
	}

	// Modifier methods:
	public void setElement(String s) 
	{
		element = s;
	}

	public void setNext(Node n) 
	{
		next = n;
	}
}
