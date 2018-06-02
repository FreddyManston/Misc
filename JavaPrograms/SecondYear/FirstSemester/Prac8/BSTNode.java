public class BSTNode
{
	protected String data;
	BSTNode left, right;

	public BSTNode()
	{	
		data = null;
		left = null;
		right = null;
	}
	
	public BSTNode(String new_data, BSTNode new_left, BSTNode new_right)
	{
		data = new_data;
		left = new_left;
		right = new_right;
	}

	public String getData()
	{
		return data;
	}

	public BSTNode getLeft()
	{
		return left;
	}

	public BSTNode getRight()
	{
		return right;
	}

	public void setData(String new_data)
	{
		data = new_data;
	}

	public void setLeft(BSTNode new_left)
	{
		left = new_left;
	}

	public void setRight(BSTNode new_right)
	{
		right = new_right;
	}

	public String toString()
	{
		return (data);
	}
}
