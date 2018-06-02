public class Coordinate implements Comparable
{
	private int x;
	private int y;
	
	public Coordinate()
	{
	}
	
	public Coordinate(int new_x, int new_y)
	{
		x = new_x;
		y = new_y;
	}
	
	public int getXCoordinate()
	{
		return (x);
	}
	
	public int getYCoordinate()
	{
		return (y);
	}
	
	public void setXCoordinate(int new_x)
	{
		x = new_x;
	}
	
	public void setYCoordinate(int new_y)
	{
		y = new_y;
	}
	
	public String toString()
	{
		System.out.println(x + "," + y);
	}
	
	public int compareTo(Object an_object)
	{
	}
}
