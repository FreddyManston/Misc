import java.io.*;

public class PathFinder2
{
	public static void main (String[] args) throws FileNotFoundException
	{
		Maze labyrinth = new Maze("MazeInitialiser.txt");
		//System.out.println(labyrinth);
		
		GenericLinkedStack2 pos_stack = new GenericLinkedStack2();
		
		Position current = null;
		pos_stack.push(labyrinth.getStart());

		while (!pos_stack.isEmpty())
		{	
			System.out.println("\n" + pos_stack);
			System.out.println((Position) pos_stack.head());
			current = (Position) pos_stack.pop();
			System.out.println("Current position is " + current);
			
			if (!labyrinth.wasVisited(current))
			{ 
				labyrinth.visit(current);
			}
			
			if (current.isEqual(labyrinth.getFinish()))
			{
				System.out.println(labyrinth);
				System.exit(0);
			}
				
			if (labyrinth.isClear(current.getNewPosition("NORTH")))
			{
				pos_stack.push(current.getNewPosition("NORTH"));
				//System.out.println("\n" + pos_stack);
				//System.out.println((Position) pos_stack.head());
			}
				
			if (labyrinth.isClear(current.getNewPosition("WEST")))
			{
				pos_stack.push(current.getNewPosition("WEST"));
				//System.out.println("\n" + pos_stack);
				//System.out.println((Position) pos_stack.head());
			}
				
			if (labyrinth.isClear(current.getNewPosition("SOUTH")))
			{
				pos_stack.push(current.getNewPosition("SOUTH"));
				//System.out.println("\n" + pos_stack);
				//System.out.println((Position) pos_stack.head());
			}
				
			if (labyrinth.isClear(current.getNewPosition("EAST")))
			{
				pos_stack.push(current.getNewPosition("EAST"));
				//System.out.println("\n" + pos_stack);
				//System.out.println((Position) pos_stack.head());
			}	
		} //System.out.println("The cheese is at position " + current);
		
		/*int randome = (int) Math.round(Math.random() * 3);
		System.out.println(randome);*/
	}
}
