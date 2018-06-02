// package pracs;


public class DLinkedListTest 
{	
	public DLinkedListTest()
	{
		DNode a = new DNode();
        	a.setElement("A");
        	b.setElement("B");
        	c.setElement("C");
        	d.setElement("D");
        	e.setElement("E");
        	g.setElement("G");
        	a.setNext(b);
        	b.setNext(c);
        	c.setNext(d);
        	d.setNext(null);
        	a.setPrev(null);
        	b.setPrev(a);
        	c.setPrev(b);
        	d.setPrev(c);
        	DLinkedList list = new DLinkedList(a, d);
  
        	System.out.println(list);
        	System.out.println("Check if \"C\" is contained in the list:");
        	System.out.println(list.containsItem("C"));
        	System.out.println("Insert \"B\" at tail:");
        	list.insertAtTail("B");
        	System.out.println(list);
        	System.out.println("Find first position of \"B\":");
        	System.out.println(list.firstPositionOfItem("B"));
        	System.out.println("Check if list is empty:");
        	System.out.println(list.isEmpty());
        	System.out.println("Insert \"B\" at tail:");
        	list.insertAtTail("B");
        	System.out.println(list);
        	System.out.println("Insert \"B\" at tail:");
        	list.insertAtTail("B");
        	System.out.println(list);
        	System.out.println("Insert \"B\" at tail:");
        	list.insertAtTail("B");
        	System.out.println(list);
        	System.out.println("Insert \"B\" at tail:");
        	list.insertAtTail("B");
        	System.out.println(list);
        	System.out.println("Check number of Occurrences of \"B\":");
        	System.out.println(list.noOfOccurrences("B"));
        	System.out.println("Delete last Occurrence of \"B\":");
        	list.deleteLastOccurrence("B");
        	System.out.println(list);
        	System.out.println("Find all Occurrences of \"B\":");
        	int [] where_b_occurs = list.allPositionsOfItem("B");
        	for (int i = 0; i < where_b_occurs.length - 1; i++)
        		System.out.print(where_b_occurs [i] + ",");
        	System.out.println(where_b_occurs [where_b_occurs.length - 1]);
        	System.out.println("Delete first Occurrence of \"B\"");
        	list.deleteFirstOccurrence("B");
        	System.out.println(list);
		System.out.println("Delete all Occurrences of \"B\":");
	        list.deleteAllOccurrences("B");
 	        System.out.println(list);
 	        System.out.println("Insert \"F\" at index 1:");
 	        list.insertAtIndex(1, "F");
 	        System.out.println(list);
 	        System.out.println("Insert \"X\" at index 3:");
 	        list.insertAtIndex(3, "X");
 	        System.out.println(list);
 	        System.out.println("Insert \"Z\" at index 4:");
 	        list.insertAtIndex(4, "Z");
 	        System.out.println(list);
 	        System.out.println("Insert \"W\" at index 6:");
 	        list.insertAtIndex(6, "W");
 	        System.out.println(list);
 	        System.out.println("Replace index 3 with \"Y\":");
 	        list.replaceAtIndex(3, "Y");
 	        System.out.println(list);
 	        System.out.println("Insert \"3\" at front:");
 	        list.insertInFront("3");
 	        System.out.println(list);
  	        System.out.println("Insert \"1\" at front:");
  	        list.insertInFront("1");
  	        System.out.println(list);
  	        System.out.println("Insert \"2\" at front:");
  	        list.insertInFront("2");
  	        System.out.println(list);
  	        System.out.println("Remove node a:");
  	        list.remove(a);
  	        System.out.println(list);
  	        System.out.println("Add node e before node d:");
  	        list.addBefore(d, e);
  	        System.out.println(list);
  	        System.out.println("Add node g after node e:");
  	        list.addAfter(e, g);
  	        System.out.println(list);
  	        
	}
	
	public static void main(String[] args)
	{
		new DLinkedListTest();
	}
}
