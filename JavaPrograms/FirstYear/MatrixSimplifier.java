import java.util.Scanner;

class MatrixSimplifier
{
	static Scanner Redhead = new Scanner(System.in);
	double matrix [][];
	
	public void makeMatrix(int num_rows, int num_col)
	{
		matrix = new double [num_rows][num_col];
		
		for (int i = 0; i < num_rows; i++)
		{
			System.out.println("\nROW NUMBER " + (i+1) + "\n");
			for (int j = 0; j < num_col; j++)
			{
				System.out.print("X" + (j+1) + ": ");
				matrix[i][j] = Redhead.nextDouble();
			}
		}
	}
	
	public void displayMatrix()
	{	
		for (int i = 0; i < matrix.length; i++)
		{
			System.out.println();
			for (int j = 0; j < matrix [i].length; j++)
			{
				System.out.print(matrix [i][j] + "\t");
			}
		}
		System.out.println();
	}
	
	public void toRowEchelonForm()
	{
		int i = 0;
		int j = 0;
		
		// While loop to make matrix into row echelon form.
		while (i < matrix.length && j < matrix [i].length)
		{
			// Moves to the next column, if current column is zero. Breaks out of main loop if the last column is zero.
			while (checkIfColumnIsZero(i, j))
			{
				if (j < (matrix [i].length))
					j++;
				else
					break;
			}
			
			double lead_num = 0;
				
			// For loop to find the first non-zero element in the specific column (the leading number).
			for (int m = i; m < matrix.length; m++)		
			{
				if (matrix [m][j] != 0)
				{
					lead_num = matrix [m][j];
					System.out.println(lead_num);
					if (m != i)
					{
						switchRows(i, m);
					}
					break;
				}
			}
			
			// For loop to reduce leading number to one, if it is not one already.
			if (lead_num != 1)
			{
				for (int n = j; n < matrix [i].length; n++)
				{
					matrix [i][n] = ((matrix [i][n] / lead_num)*100)/100;
				}
			}
			
			if (i < matrix.length - 1)
			{
				// For loop to make all numbers beneath leading number zero.
				for (int m = i + 1; m < matrix.length; m++)
				{
					if (matrix [m][j] != 0)
					{
						double reducer = matrix [m][j];
						
						for (int n = j; n < matrix [m].length; n++)
						{
							matrix [m][n] = ((matrix [m][n] - (reducer * matrix [i][n]))*100)/100;
						}
					}
				}
				displayMatrix();
			}
			
			i++;
			j++;
		}
		
		// While loop to make matrix into reduced row echelon form.
		while (i != 0 && j != 0)
		{
			//fahmiyah walters.
	
	public boolean checkIfColumnIsZero(int row, int col)
	{
		boolean is_zero = true;
		
		for (int i = row; i < matrix.length; i++)
		{
			if (matrix [i][col] != 0)
			{
				is_zero = false;
				break;
			}
		}
		
		return (is_zero);
	}
	
	public void switchRows(int row1, int row2)
	{
		double temp[] = matrix [row1];
		matrix [row2] = matrix [row1];
		matrix [row1] = temp;
	}
	
	public static void main (String[] args)
	{
		MatrixSimplifier object = new MatrixSimplifier();
		
		System.out.print("Number of rows (i.e. number of equations): ");
		int rows = Redhead.nextInt();
		System.out.print("Number of columns (i.e. number of variables): ");
		int columns = Redhead.nextInt();
		
		object.makeMatrix(rows, columns);
		object.displayMatrix();
		object.toRowEchelonForm();
		object.displayMatrix();	
	}
	
}
