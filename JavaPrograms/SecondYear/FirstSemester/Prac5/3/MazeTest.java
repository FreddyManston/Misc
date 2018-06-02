import java.io.*;
import java.util.Scanner;

public class MazeTest
{
	public static void main (String[] args) throws FileNotFoundException
	{
		Scanner Reddo = new Scanner(System.in);
		Maze labyrinth = new Maze();
		
		System.out.println("\nThe starting position in the maze is at [" + labyrinth.getStart().getRow() + ", " + labyrinth.getStart().getColumn() + "]");
		System.out.println("The end position in the maze is at [" + labyrinth.getFinish().getRow() + ", " + labyrinth.getFinish().getColumn() + "]\n");
		
		boolean keep_visiting = true;
		while (keep_visiting)
		{
			System.out.println("Type in a position you want to visit-");
			try
			{
				System.out.print("#Row: ");
				String str_row = Reddo.next();
				int row = Integer.parseInt(str_row);
				if (row < 0 || row >= 10)
					throw new NumberFormatException();
				
				System.out.print("#Col.: ");
				String str_column = Reddo.next();
				int column = Integer.parseInt(str_column);
				if (column < 0 || column >= 20)
					throw new NumberFormatException();
					
				Position visit_here = new Position(row, column);
				labyrinth.visit(visit_here);
				
				System.out.println("Do you want to visit another place? [Y/N]");
				String reply = Reddo.next();
				
				if (reply.contains("Y") || reply.contains("y"))
				{
					continue;
				}
				else
				{
					System.out.println("I assume that's a no.");
					keep_visiting = false;
				}
			} 
			catch (NumberFormatException e)
			{
				System.out.println("Invalid row/column number");
				continue;
			}
		}
		
		boolean keep_checking = true;
		while (keep_checking)
		{
			System.out.println("Type in a position you want to check for clearance-");
			try
			{
				System.out.print("#Row: ");
				String str_row = Reddo.next();
				int row = Integer.parseInt(str_row);
				if (row < 0 || row >= 10)
					throw new NumberFormatException();
				
				System.out.print("#Col.: ");
				String str_column = Reddo.next();
				int column = Integer.parseInt(str_column);
				if (column < 0 || column >= 20)
					throw new NumberFormatException();
					
				Position check_here = new Position(row, column);
				if (labyrinth.isClear(check_here))
					System.out.println("It's clear.");
				else
					System.out.println("Either you've already visited there or there's a wall, but that position is not clear.");
				
				System.out.println("Do you want to check another place? [Y/N]");
				String reply = Reddo.next();
				
				if (reply.contains("Y") || reply.contains("y"))
				{
					continue;
				}
				else
				{
					System.out.println("I assume that's a no.");
					keep_checking = false;
				}
			} 
			catch (NumberFormatException e)
			{
				System.out.println("Invalid row/column number");
				continue;
			}
		}
		
		System.out.println("\nTHE MAZE:\n");
		labyrinth.printMaze();
	}
}
