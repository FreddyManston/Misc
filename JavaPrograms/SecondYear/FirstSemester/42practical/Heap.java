public class Heap 
{
	private int [] heap;
	private int size;
	
	private void heapify(int i, int start)
	{
		int marker = 2 * start;

		while (marker <= size)
		{
			if (marker < size && heap [marker] < heap [marker + 1]) // Works with index out of range, just returns false.
				marker++;
				
			if (i >= heap [marker])
				break;
			else
			{
				heap [start] = heap [marker];
				start = marker;
				marker = 2 * start;
			}
		}
		heap [start] = i;		
	}
	
	public void buildHeapTopDown(int list [])
	{
		
	}
	
	public int[] buildHeapBottomUp(int list [])
	{
		size = list.length;
		heap = new int [size + 1];
		
		for (int i = 0; i < size; i ++)
			heap [i + 1] = list [i];
			
		for (int i = size/2; i >= 1; --i)
			heapify(heap[i], i);
			
		return (heap);
	}
	
	public boolean isHeap(int start)
	{
		
		if (heap [0] >= heap [1] && heap [0] >= heap [2])
		{
			isHeap(1);
			isHeap(2);
		}
		else
			return false;
			
		return true;
	}
	
	public int [] sort(int list [], int size)
	{
		buildHeapBottomUp(list);
		
		for (int i = size; i > 1; i --)
		{
			int temp = heap [1];
			heap [1] = heap [i];
			heap [i] = temp;
			
			size --;
			heapify(1, 1);
		}
		
		size = list.length;
		return heap;
	}
}
