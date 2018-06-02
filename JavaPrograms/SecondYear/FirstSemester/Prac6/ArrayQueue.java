public class ArrayQueue
{
	Object [] array;
	int head = -1;
	int rear = 0;
	int count = 0;
	int N = 0;
	
	public ArrayQueue (int length)
	{
		array = new Object [length];
		N = length;
	}
	
	public void enqueue(Object element)
	{
		if (!isFull())
		{
			if (head == -1)
				head = 0;
				
			array [rear] = element;
			rear = (rear + 1) % N;
			
			count ++; 
		}
		else
			System.out.println("Queue is full exception thrown.");
	}
	
	public Object dequeue()
	{
		if (count == 0)
		{
			System.out.println("Queue is empty exception thrown.");
			return null;
		}
		else if (count == 1)
		{
			Object take_me_away = array [head];
			array [head] = null;
			head = -1;
			
			count --;
			return take_me_away;
		}
		else
		{
			Object take_me_away = array [head];
			array [head] = null;
			head = (head + 1) % N;
			
			count --;
			return take_me_away;
		}
	}
	
	public Object front()
	{
		if (count == 0)
		{
			System.out.println("Queue is empty exception thrown.");
			return null;
		}
		else
			return array[head];
	}
	
	public int size()
	{
		return count;
	}
	
	public boolean isEmpty()
	{
		return (count == 0);
	}
	
	public boolean isFull()
	{
		return (count == N);
	}
}
// 6 7 y u h j n m
//    Y U H J N M
