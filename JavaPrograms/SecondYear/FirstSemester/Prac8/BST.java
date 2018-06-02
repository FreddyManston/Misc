//3463541
public class BST
{
	BSTNode root;
	
	public BST ()
	{
		root = null;
	}

	public BST (BSTNode new_root)
	{
		root = new_root;
	}
		
	public BSTNode getRoot()
	{
		return root;
	}

	public void insert(String item)
	{
		if (root == null)
		{
			BSTNode put_me_in = new BSTNode (item, null, null);
			root = put_me_in;
		}
		else if (contains(item))
		{
			System.out.println("\n" + item + " is already in the tree.");
		}
		else
		{	
			BSTNode put_me_in = new BSTNode (item, null, null);
			BSTNode parent = root;
			BSTNode child = new BSTNode ();
			
			while (parent != null)
			{
				if (item.compareTo(parent.getData()) > 0)
				{
					child = parent;
					parent = parent.getRight();
				}
				else
				{
					child = parent;
					parent = parent.getLeft();
				}
			}
			
			if (item.compareTo(child.getData()) > 0)
			{
				child.setRight(put_me_in);
			}
			else
			{
				child.setLeft(put_me_in);	
			}
		}	
	}
	
	public void delete(String item)
	{
		BSTNode marker = root, parent = null, child = root;
		BSTNode temp;
		
		// find node to be deleted
		while ((marker != null) && !(marker.getData().equals(item)))
		{
			parent = marker;
			if (item.compareTo(marker.getData()) < 0)
				marker = marker.left;
			else
				marker = marker.right;
		}
		
		if (marker == null)
			System.out.println("Cannot delete: item does not occur in binary tree");
		else
		{
			// checking now whether the root node has to be deleted
			if (parent == null) // deleting the root node
			{
				if (marker.right == null)// root with one child
					root = marker.left;
				else if (marker.left == null) // root with one child
					root = marker.right;
				else // delete a root node with two children 
				{
					for (temp = marker, child = marker.left; child.right != null; temp = child, child = child.right); // move down tree if right subtree is non-null
						if (child != marker.left) //i.e. right subtree does exist
						{
							temp.right = child.left;
							child.left = root.left;
						}
						child.right = root.right;
						root = child;
				}
			}
			else if (marker.right == null) // deleting of an internal node with no right
			{ 
				if (parent.left == marker) // with one child
					parent.left = marker.left;
				else
					parent.right = marker.left;
			}
			else if (marker.left == null) // deleting of an internal node with no left
			{
				if (parent.left == marker) // with one child
					parent.left = marker.right;
				else
					parent.right = marker.right;
			}
			else // deleting of an internal node with 2 children
			{
				for (temp = marker, child = marker.left; child.right != null; temp = child, child = child.right);
					if (child != marker.left)
					{
						temp.right = child.left;
						child.left = marker.left;
					}
					child.right = marker.right;
					
					if (parent.left == marker)
						parent.left = child;
					else
						parent.right = child;
			}
		}
	}
	
	public int countNodes(BSTNode root_node)
	{
		if (root_node == null)
			return 0;

		int left_set = countNodes(root_node.getLeft()) + 1;
		int right_set = countNodes(root_node.getRight()) + 0;

		return (left_set + right_set);
	}

	public int countLeaves(BSTNode root_node)
	{
		if (root_node.getLeft() == null && root_node.getRight() == null)
		{
			return 1;
		}
		
		else if (root.getLeft() == null)
		{
			return (countLeaves(root_node.getLeft()) + 0);
		}

		else if (root_node.getRight() == null)
		{
			return (countLeaves(root_node.getLeft()) + 0);
		}

		else
		{
			int left_set = countLeaves(root_node.getLeft()) + 0;
			int right_set = countLeaves(root_node.getLeft()) + 0;
			
			return (left_set + right_set);
		}
	}

	public int countSpecialNodes(BSTNode root_node)
	{
		if (root_node == null)
			return 0;
			
		else if (root_node.getLeft() == null && root_node.getRight() == null)
		{
			return 0;
		}
		
		else if (root.getLeft() == null && root_node.getRight() != null)
		{
			return (countLeaves(root_node.getRight()) + 1);
		}

		else if (root_node.getRight() == null && root.getLeft() != null)
		{
			return (countLeaves(root_node.getLeft()) + 1);
		}

		else
		{
			int left_set = countLeaves(root_node.getLeft()) + 0;
			int right_set = countLeaves(root_node.getLeft()) + 0;
			
			return (left_set + right_set);
		}
	}
	
	public int height(BSTNode root_node)
	{
		if (root_node == null)
		{
			return 0;
		}
		else
		{
			int left_height = 1 + height(root_node.getLeft());
			int right_height = 1 + height(root_node.getRight());
			
			if (left_height > right_height)
				return left_height;
			else
				return right_height;
		}
	}

	public boolean contains (String item)
	{		
		if (root == null)
		{
			return false;
		}
		else if (root.getData().equals(item))
		{
			return true;
		}
		else
		{
			String true_false = containsHelper(root, "", item);
			if (true_false.contains("T"))
				return true;
			else
				return false;
		}
	}
	
	public String containsHelper (BSTNode root_node, String str, String item)
	{
		BSTNode shifter = root_node;
	
		if (root_node == null)
		{
			return "F";
		}
		else if (root_node.getData().equals(item))
		{
			return "T";
		}
		else
		{
			if (item.compareTo(shifter.getData()) > 0)
				str = str + containsHelper(shifter.getRight(), "", item);
			else
				str = str + containsHelper(shifter.getLeft(), "", item);			
		}
		
		return str;
	}

	public void inOrder(BSTNode root_node)
	{		
		if (root_node.getLeft() != null)
		{
			inOrder(root_node.getLeft());
		}

		System.out.println(root_node.getData());

		if (root_node.getRight() != null)
		{
			inOrder(root_node.getRight());
		}
	}
	
	public void preOrder(BSTNode root_node)
	{
		System.out.println(root_node.getData());
		
		if (root_node.getLeft() != null)
		{
			inOrder(root_node.getLeft());
		}

		if (root_node.getRight() != null)
		{
			inOrder(root_node.getRight());
		}
	}

	public void postOrder(BSTNode root_node)
	{
		if (root_node.getLeft() != null)
		{
			inOrder(root_node.getLeft());
		}

		if (root_node.getRight() != null)
		{
			inOrder(root_node.getRight());
		}

		System.out.println(root_node.getData());
	}
}
