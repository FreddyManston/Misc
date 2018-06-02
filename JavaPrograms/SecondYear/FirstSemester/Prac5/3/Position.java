public class Position
{
	private int row, column;
	
	public Position()
	{
	}
	
	public Position(int new_row, int new_column)
	{
		row = new_row;
		column = new_column;
	}
	
	public int getRow()
	{
		return (row);
	}
	
	public int getColumn()
	{
		return (column);
	}
	
	public void setRow(int new_row)
	{
		row = new_row;
	}
	
	public void setColumn(int new_column)
	{
		column = new_column;
	}
	
	public Position getNewPosition(String direction)
	{
		if (direction.equalsIgnoreCase("North"))
		{
			Position new_position = new Position(row - 1, column);
			return (new_position);
		}
		
		else if (direction.equalsIgnoreCase("West"))
		{
			Position new_position = new Position(row, column - 1);
			return (new_position);
		}
		
		else if (direction.equalsIgnoreCase("South"))
		{
			Position new_position = new Position(row + 1, column);
			return (new_position);
		}
		
		else if (direction.equalsIgnoreCase("East"))
		{
			Position new_position = new Position(row, column + 1);
			return (new_position);
		}
		
		else
		{
			System.out.println("Do you need a GPS? Because your directions suck.");
			return (this);
		}
	}
	public boolean isEqual(Position position)
	{
		if (row == position.getRow() && column == position.getColumn())
			return (true);
		else
			return (false);
	}
	
	public void writeOutput()
	{
		System.out.println("[" + row + ", " + column + "]");
	}
}
