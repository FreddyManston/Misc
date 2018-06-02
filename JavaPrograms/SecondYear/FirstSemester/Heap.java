public class Heap 
{ 
	private int [] Element;
	private int HeapSize;

	Heap(int heapsize)
	{
		HeapSize = heapsize;
		Element = new int [heapsize + 1]; // NOT using zero indexing !!!
	}

	private void MakeRandomHeap(int upperLimit)
	{
		int index;
		for (index = 1; index <= HeapSize; index++)
			Element [index] = (int)(upperLimit * Math.random());
	}

	private void MakeHeap() throws Exception //Heapify
	{
	 	for (int index = HeapSize/2; index >= 1; --index)
			Insert(Element [index], index, HeapSize);
	}

	private void Insert(int newElement, int start, int maxheap) throws Exception
	{
		int marker = 2 * start;
		display("Fo'");
		while (marker <= maxheap)
		{
			//System.out.println(marker < maxheap && Element [marker] < Element [marker + 1]);
			if (marker < maxheap && Element [marker] < Element [marker + 1]) // Works with index out of range, just returns false.
				marker++;

			if (newElement >= Element [marker])
				break;
			else
			{
				Element [start] = Element [marker];
				start = marker;
				marker = 2 * start;
			}
		}
		Element [start] = newElement;
		display("Afto'");
	}

	public void Sort() throws Exception
	{
		int tempItem;
		int maxheap = HeapSize;
		while (maxheap > 0)
		{
			tempItem = Element [maxheap];
			Element [maxheap] = Element [1];
			Insert(tempItem, 1, --maxheap);
	 	}
	}

	public void display(String heading) throws Exception
	{
		System.out.println(" "+heading);
		for(int index = 1; index <= HeapSize; index++)
			System.out.print(getElement(index)+" ");
		System.out.println();
	}

	public int getElement(int index)
	{
		return Element[index];
	}

	public int getHeapSize()
	{
		return HeapSize;
	}

	public static void main(String[] args) throws Exception
	{
		Heap hp = new Heap(6);
		hp.MakeRandomHeap(10);
		hp.MakeHeap();
		hp.display("Unsorted");
		hp.Sort();
		hp.display("Sorted");
	}
}
