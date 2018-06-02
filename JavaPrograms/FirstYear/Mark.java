/**
* <h1>Mark class</h1>
* This class deals with the different scores the student achieved.
* <p>
* <b>For users of the University of the Western Cape.</b>
* @param test1 A private double instance variable, for the student's first test.
* @param test2 A private double instance variable, for the student's second test.
* @param assignment1 A private double instance variable, for the student's first assignment.
* @param assignment2 A private double instance variable, for the student's second assignment.
* @param exam A private double instance variable, for the student's exam.
* @author Joshua Abraham
* @version 1.1
* @since Thu 14 Aug 2014 20:32:46 SAST 
*/
public class Mark
{
	private double test1;
	private double test2;
	private double assignment1;
	private double assignment2;
	private double exam;

	/**
	* This mutator method sets the users input in the Run class to the appropriate instance variable in this class.
	* @param test1 User input of the student's name.
	* @param test2 User input of the student's surname. 
	* @param assignment1 User input of the student's student ID. 
	* @param assignment2 User input of the student's name.
	* @param exam User input of the student's surname. 
	*/
	public void setMark (String newTest1, String newTest2, String newAssignment1, String newAssignment2, String newExam)
	{
		checkPositive(newTest1);
		test1 = Double.parseDouble(newTest1);
		
		checkForLettersAndDoubleDecimals(newTest2);
		checkPositive(newTest2);
		test2 = Double.parseDouble(newTest2);
		
		checkForLettersAndDoubleDecimals(newAssignment1);
		checkPositive(newAssignment1);
		assignment1 = Double.parseDouble(newAssignment1);
		
		checkForLettersAndDoubleDecimals(newAssignment2);
		checkPositive(newAssignment2);
		assignment2 = Double.parseDouble(newAssignment2);
		
		checkForLettersAndDoubleDecimals(newExam);
		checkPositive(newExam);
		exam = Double.parseDouble(newExam);
	}
	
	/**
	* An accesor method to allow access to the private 'test1' instance variable contained in this class.
	*/
	public double getTest1()
	{
		return (test1);
	}
	
	/**
	* An accesor method to allow access to the private 'test2' instance variable contained in this class.
	*/
	public double getTest2()
	{
		return (test2);
	}
	
	/**
	* An accesor method to allow access to the private 'assignment1' instance variable contained in this class.
	*/
	public double getAssignment1()
	{
		return (assignment1);
	}
	
	/**
	* An accesor method to allow access to the private 'assignment2' instance variable contained in this class.
	*/
	public double getAssignment2()
	{
		return (assignment2);
	}
	
	/**
	* An accesor method to allow access to the private 'exam' instance variable contained in this class.
	*/
	public double getExam()
	{
		return (exam);
	}
	
	/**
	* Checks whether 'variable' is less than zero or not (i.e. positive or negative. Prints an error message if it is the latter.
	* @param variable The formal parameter of this method, i.e. the double value that needs to be checked for negativity.
	* @param double_variable The value of variable, after double parsing.
	*/
	public void checkPositive (String variable)
	{
		double double_variable = Double.parseDouble(variable);
		if (double_variable < 0)
		{
			System.out.println("Invalid input");
			System.exit(0);
		}
	}
	
	public void checkForLettersAndDoubleDecimals (String variable)
	{
		String check_list = "0123456789.";	// A list of characters that are valid in the String 'variable'.
		int decimal_points = 0;			// A count of how many decimal points are in the String 'variable'.

		for (int i = 0; i < variable.length(); i++)
		{
			char character = variable.charAt(i);

			if (check_list.contains(String.valueOf(character)))
			{
				// Do nothing.
			}
			else
			{
				System.out.println("Invalid input");
				System.exit(0);
			}

			if (character == '.')
			{
				decimal_points ++;
			}
			else
			{
				// Do nothing.
			}

			if (decimal_points > 1)
			{
				System.out.println("Invalid input");
				System.exit(0);
			}
			else
			{
				// Do nothing.
			}
		
		}
		
	}
	
	/**
	* An accesor method to allow access to the final mark, after it is calculated using the instance variables of this class.
	*/
	public double getFinalMark()
	{
		double CEM = ((((test1 + test2)/2)/100)*60 + (((assignment1 + assignment2)/2)/100)*40);
		double final_mark = ((CEM/100)*60 + (exam/100)*40);
		return final_mark;
	}

	/**
	* An accesor method to allow access to the symbol, after it is calculated using the final mark.
	* @param variable The formal parameter of this method, i.e. the double value (final mark) that will be used to return the appropriate symbol.
	*/
	public char getSymbol (double variable)
	{
		char symbol = ' ';
		
		if (variable >= 75)
		{
			symbol = 'A';
			//status = "PASS";
		}
		else if (variable >= 70)
		{
			symbol = 'B';
			//status = "PASS";
		}
		else if (variable >= 60)
		{
			symbol = 'D';
			//status = "PASS";
		}
		else if (variable >= 50)
		{
			symbol = 'E';
			//status = "FAIL";
		}
		else if (variable >= 45)
		{
			symbol = 'F';
			//status = "FAIL";
		}
		else
		{
			symbol = 'G';
			//status = "FAIL";
		}
		
		return (symbol);
	}
	
	/**
	* An accesor method to allow access to the status, after it is calculated using the final mark.
	* @param variable The formal parameter of this method, i.e. the double value (final mark) that will be used to return the appropriate status.
	*/
	public String getStatus (double variable)
	{
		String status = "";
		
		if (variable >= 75)
		{
			status = "PASS";
		}
		else if (variable >= 70)
		{
			status = "PASS";
		}
		else if (variable >= 60)
		{
			status = "PASS";
		}
		else if (variable >= 50)
		{
			status = "FAIL";
		}
		else if (variable >= 45)
		{
			status = "FAIL";
		}
		else
		{
			status = "FAIL";
		}
		
		return (status);
	}
}
