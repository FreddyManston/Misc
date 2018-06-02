import java.util.*;
public class MyHeap
{
	private ArrayList	<String> Elements;
	private int Heapsize;
	
	public MyHeap()
	{
		Elements = new ArrayList <String> ();
		Heapsize = 0;
	}
	
	public MyHeap(String [] items)
	{
		Elements = new ArrayList <String> (items.length + 1);	// Leave first element null to bypass zero indexing
		Heapsize = items.length;
		
		for (int i = 0; i < items.length; i ++)
		{
			Elements [i + 1] = items [i];
		}
		
		SetHeap();
	}

	public ArrangeHeap (String item, int start_index, int last_index)
	{
		int child_index = 2 * start_index;
		
		while (child_index <= last_index)
		{
			if (child_index < last_index && Element [child_index] < Element [child_index + 1])
			{
				child_index ++;
			}
			
			if (item >= Element [child_index])
			{
				break;
			}
			else
			{
				Element [start_index] = Element [child_index];
				start_index = child_index;
				child_index = 2 * start_index;	
			}
		}
		
		Element [start_index] = item;
	}
	
	public Insert (String item, int start_index, int last_index)
	{
		int child_index = 2 * start_index;
		
		while (child_index <= last_index)
		{
			if (child_index > start_index)
			{
				
			}
		}
		
		if (child_index == (last_index + 1))
		{
			Element [start_index] = item;
		}
	}

	public int getHeapSize() 
	{
		return Heapsize;
	}

	public int getElement(int index) 
	{
		return Element [index];
	}

	public void display(String heading) throws Exception
	{
		System.out.println(" "+heading);
		for(int index = 1; index <= HeapSize; index++)
			System.out.print(getElement(index)+" ");
		System.out.println();
	}
}
