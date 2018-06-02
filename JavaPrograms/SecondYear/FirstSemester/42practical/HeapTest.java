public class HeapTest
{
	public static void main (String[] args)
	{
		Heap heap1 = new Heap();
		Heap heap2 = new Heap();
		Heap heap3 = new Heap();
		Heap heap4 = new Heap();
		int [] list1 = {12, 3, 5, 7, 10, 11, 23};
		int [] list2 = {6, 18, 17, 2, 1, 9, 14, 12, 3, 5, 7, 10, 11, 23, 15};
		int [] list3 = new int [20];
		int [] list4 = new int [29];
		
		for (int i = 1; i <= list4.length; i ++)
		{
			if (i <= 20)
			{
				list3 [i - 1] = i;
				list4 [i - 1] = i;
			}
			else
				list4 [i - 1] = i;
		}
			
		list1 = heap1.buildHeapBottomUp(list1);
		list2 = heap2.buildHeapBottomUp(list2);
		list3 = heap3.buildHeapBottomUp(list3);
		list4 = heap4.buildHeapBottomUp(list4);
		
		for (int i = 1; i < list1.length - 1; i ++)
		{
			System.out.print(list1 [i] + ", ");
		} System.out.println(list1 [list1.length - 1]);
		for (int i = 1; i < list2.length - 1; i ++)
		{
			System.out.print(list2 [i] + ", ");
		} System.out.println(list2 [list2.length - 1]);
		for (int i = 1; i < list3.length - 1; i ++)
		{
			System.out.print(list3 [i] + ", ");
		} System.out.println(list3 [list3.length - 1]);
		for (int i = 1; i < list4.length - 1; i ++)
		{
			System.out.print(list4 [i] + ", ");
		} System.out.println(list4 [list4.length - 1]);
	}
}
