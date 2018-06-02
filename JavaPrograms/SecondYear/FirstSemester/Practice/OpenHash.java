public class OpenHash
{
	private int[][] table; // Key value in coloumn 1 (j = 0) and data value in coloumn 2 (j = 1) 
	private int size;
	
	public OpenHash (int num_chairs)
	{
		size = num_chairs;
		table = new int[size + 1][2]; // Get rid of zero indexing for key slots.
	}
	
	private int hash (int data)
	{
		return(((data * 3) % size) + 1); // Returns specific hash value within range of (0, size]
	}
	
	public void insert (int key, int data)
	{
		if (!isFull && !isInTable(key)) // No duplicate keys allowed
		{
			int index = hash(
		}
	}
	
	public int lookup (int key)
	{
		boolean is_in = false;
		int data;
		
		for (int i = 1; i < size + 1; i ++)
			if (table [i][0] == key)
			{
				data = table[i][1];
				is_in = true;
			}
		if (is_in)
			return data;
		else
		{
			System.out.println(key + " is not in the table");
			return -1;
		}
	}
	
	public int remove (int key)
	{
		
	}
	
	public boolean isInTable (int key)
	{
		for (int i = 1; i < size + 1; i ++)
			if (table [i][0] == key)
				return false;
		return true;
	}
	
	public boolean isFull ()
	{
		for (int i = 1; i < size + 1; i ++)
			if (table [i][0] == 0)
				return false;
		return true;
		
	}
	
	public boolean isEmpty()
	{
		for (int i = 1; i < size + 1; i ++)
			if (table [i][0] != 0)
				return false;
		return true;
	}
}
