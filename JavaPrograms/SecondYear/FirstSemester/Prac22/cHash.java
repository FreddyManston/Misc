public class cHash
{
	private int m;
	private SLinkedList [] head_nodes;

	public cHash (int num_chairs)
	{
		m = num_chairs;
		head_nodes = new SLinkedList [m + 1];

		for (int i = 1; i < m + 1; i ++)
		{
			head_nodes [i] = new SLinkedList ();
		}
	}
	

	public int hash (int key)
	{
		return (((key * 3) % m) + 1);
	}

	public void insert (int key, int data)
	{
		int index = hash (key);

		if (head_nodes [index].getHead() == null)
		{
			head_nodes [index].setHead(new Node(key, data, null));
		}

		else
		{
			if (!isInTable(key))
				head_nodes [index].insertAtTail(key, data);
			else
				System.out.println("In table already.");
		}
	}

	public int lookup (int key)
	{
		int index = hash(key);

		return (head_nodes [index].getFirstOccurrence(key).getData());
	}

	public int remove (int key)
	{
		int index = hash(key);

		return (head_nodes [index].deleteFirstOccurrence(key).getData());
	}

	public boolean isInTable (int key)
	{
		int index = hash(key);

		return head_nodes [index].containsItem(key);
	}

	/*public boolean isFull ()
	{

	}

	public boolean isEmpty ()
	{

	}*/
}