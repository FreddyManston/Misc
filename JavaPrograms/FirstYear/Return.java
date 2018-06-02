// Not Running Properly. Buggy.

class TheReturn
{
	public static void main (String[] args)
	{	
		printLogarithm (6);
		System.out.println("6 to the power of 3 is: " + returnCube(6) + " and the cube root of 6 is: " + returnCubeRoot(6.0) + ".");
	}
	
	public static void printLogarithm(double x)
	{
		if (x < 0.0)	//Checks if inputted number is smaller than 0, i.e. a negative number.
		{
			System.out.println("Positive numbers only, please.");
			return;		//Ends the printLogarithm method if number is a negative and moves along with the rest of the program.
		}
	
		double result = Math.log(x);
		System.out.println("The log of " + x + " is " + result);
	}

	public static double returnCubeRoot (double x) //public static double (instead of void) because a double is being returned instead of nothing.
	{
		if (x < 0.0)	//Checks if inputted number is smaller than 0, i.e. a negative number.
		{
			System.out.println("Positive numbers only, please.");
			return (Math.pow(x, 1/3));//Ends the printLogarithm method if number is a negative and moves along with the rest of the program.
		}

		else
		{
			return (Math.pow(x, 1/3));  //Returns cube root of x in place of method.
		}
	}

	public static double returnCube (double x)
	{
		return (Math.pow(x, 3)); //Returns the cube of x in place of method.
	}	
}
