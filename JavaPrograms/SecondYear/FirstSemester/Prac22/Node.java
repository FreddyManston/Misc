public class Node 
{
	private int key;
	private int data; //assume elements are strings
	private Node next;

	// Creates a node with the given element and next node.
	public Node(int k, int d, Node n) 
	{
 		key = k;
 		data = d;
 		next = n;
	}

	// Accessor methods:
	public int getKey() 
 	{
		return key;
	}

	public int getData()
	{
		return data;
	}

	public Node getNext() 
	{
		return next;
	}

	// Modifier methods:
	public void setKey(int k) 
	{
		key = k;
	}

	public void setData (int d)
	{
		data = d;
	}

	public void setNext(Node n) 
	{
		next = n;
	}
}
