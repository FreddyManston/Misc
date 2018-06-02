import java.util.*;

public class BSTTest
{
	public static void main (String[] args)
	{
		Scanner Reddo = new Scanner (System.in);
		BST tree = new BST();
		boolean quit = false;
	
		while (!quit)
		{
			System.out.println("\nPlease pick an option from 1-13:\n\n1) Insert a node.\n2) Display tree.\n3) Count the nodes.\n4) Count the leaves.\n5) Count the special nodes.\n6) Get the height.\n7) Check if an item is in the tree.\n8) Display the tree with in-order traversal.\n9) Display the tree with pre-order traversal.\n10) Display the tree with post-order traversal.\n11) Find the smallest number in the tree.\n12) Find the largest number in the tree.\n13) Delete a node.\n14) Quit the program.");
			
			try
			{
				String answ = Reddo.next();
	
				switch (Integer.parseInt(answ))
				{
					case 1:
					
						System.out.print("\nType in the value you want to insert into the tree: ");
						int insert_me = Reddo.nextInt();
						
						tree.insert(insert_me);
						break;
						
					case 2:
					
						//tree.display();
						System.out.println("\nOperation under construction. Try again in a few minutes.");
						break;
						
					case 3:
					
						System.out.println("\n" + tree.countNodes(tree.getRoot()));
						break;
						
					case 4:
					
						if (tree.getRoot() == null)
							System.out.println("\n0");
						else	
							System.out.println("\n" + tree.countLeaves(tree.getRoot()));
							
						break;
						
					case 5:
						
						if (tree.getRoot() == null)
							System.out.println("\n0");
						else
							System.out.println("\n" + tree.countSpecialNodes(tree.getRoot()));
						
						break;
							
					case 6:
					
						if (tree.getRoot() == null)
							System.out.println("\n0");
						else
							System.out.println("\n" + tree.height(tree.getRoot()));
						
						break;
						
					case 7:
					
						System.out.print("\nType in the item you want to search for: ");
						int check_me = Reddo.nextInt();
						System.out.println(tree.contains(check_me));
						
						break;
						
					case 8:
					
						System.out.println("\n");
						
						if (tree.getRoot() == null)
							System.out.println(0);
						else
							tree.inOrder(tree.getRoot());
							
						break;
						
					case 9:
					
						System.out.println("\n");
						
						if (tree.getRoot() == null)
							System.out.println(0);
						else
							tree.preOrder(tree.getRoot());
							
						break;
						
					case 10:
					
						System.out.println("\n");
						
						if (tree.getRoot() == null)
							System.out.println(0);
						else
							tree.postOrder(tree.getRoot());
						
						break;
					
					case 11:
					
						System.out.println("\n" + tree.findMin());
						break;
						
					case 12:
					
						System.out.println("\n" + tree.findMax());
						break;
						
					case 13:
						
						System.out.print("\nType in the value you want to delete from the tree: ");
						int delete_me = Reddo.nextInt();
						
						tree.deleteRecursively(tree.getRoot(), delete_me);
						break;
					
					case 14:
					
						System.out.println("\nDone.");
						System.exit(0);
						
					case 15:
						
						int [] sort_me = new int [10];
						for (int i = 0; i < 10; i++)
							sort_me [i] = i + 1;
							
						int [] left_half = new int [5];
						int [] right_half = new int [4];
						
						System.arraycopy(sort_me, 0, left_half, 0, left_half.length);
						System.arraycopy(sort_me, 5 + 1, right_half, 0, right_half.length);
						
						for (int i = 0; i < left_half.length; i++)
							System.out.println(left_half [i]);
						for (int i = 0; i < right_half.length; i++)
							System.out.println(right_half [i]);
						
						break;
						
					default:
					
						System.out.println("\nType a number from 1-14.");					
				}
			}
			catch (Exception e)
			{
				System.out.println("\nAn error has occured. Please check your input and try again.");
				continue;
			}
		}
	}
}
