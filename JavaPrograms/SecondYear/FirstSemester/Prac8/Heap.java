public class Heap
{
	private String[] Element;
	private int HeapSize;

	Heap (int heapsize)
	{
		HeapSize = heapsize;
		Element = new String [heapsize + 1]; // NOT using zero indexing !!!
	}
	
	public String getElement(int index)
	{
		return Element[index];
	}

	public int getHeapSize()
	{
		return HeapSize;
	}
	
	public void setElement(String[] arr1)
	{
		for (int index = 1; index <= arr1.length; index ++)
			Element [index] = arr1 [index - 1];
			
		MakeHeap();
	}

	private void MakeHeap()
	{
		int index;
		for (index = HeapSize/2; index >= 1; --index)
			Insert(Element [index], index, HeapSize);
	}

	private void Insert(String newElement, int start, int maxheap)
	{
		int marker = 2 * start;
		while (marker <= maxheap)
		{
			if (marker < maxheap && (Element [marker].compareTo(Element [marker + 1])) < 0)
				marker++;
			
			if (newElement.compareTo(Element [marker]) >= 0)
				break;
			else
			{
				//String temp = Element [start];
				Element [start] = Element [marker];
				//Element [marker] = temp;
				start = marker;
				marker = 2 * start;
			}
		}
		Element [start] = newElement;
	}
	
	
	public void sort()
	{
		String tempItem;
		int maxheap = HeapSize;
		while (maxheap > 0)
		{
			tempItem = Element [maxheap];
			Element [maxheap] = Element [1];
			InsertCompare(tempItem, 1, --maxheap);
		}
			
		String[] Reverse = new String [Element.length];
		Reverse [0] = null;
		int index = 1;
		for (int i = Element.length - 1; i > 0; i --)
			Reverse [index ++] = Element [i];
		Element = Reverse;
	}

	int compares = 0;
	private void InsertCompare(String newElement, int start, int maxheap)
	{
		int marker = 2 * start;
		while (marker <= maxheap)
		{
			compares ++;
			System.out.println("Comparison #" + compares + " " + Element [marker] + " & " + Element [marker + 1]);
			if (marker < maxheap && (Element [marker].compareTo(Element [marker + 1])) < 0)
				marker++;
			
			compares ++;
			System.out.println("Comparison #" + compares + " " + newElement + " & " + Element [marker]);
			if (newElement.compareTo(Element [marker]) >= 0)
				break;
			else
			{
				Element [start] = Element [marker];
				start = marker;
				marker = 2 * start;
			}
		}
		Element [start] = newElement;
	}
	public void display(String heading) throws Exception	
	{
		System.out.println(" " + heading);		
		for (int index = 1; index <= HeapSize; index++)
			System.out.println(getElement(index) + " ");
		System.out.println();
	}
}
