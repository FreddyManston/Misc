import java.util.Scanner;
public class RationalNumbers
{
	private int denominator, numerator;

	public static int cntr = 0;
	
	/**
	* Default constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public RationalNumbers()
	{
		numerator = 0;
		denominator = 1;
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public RationalNumbers(int a, int b)
	{
		numerator = a;
		denominator = b;
	}
	
	/**
	* Mutator method for the numerator variable.
	*/
	public void setNumerator(int a)
	{
		numerator = a;
	}
	
	/**
	* Mutator method for the denominator variable.
	*/
	public void setDenominator(int b)
	{
		denominator = b;
	}
	
	/**
	* Mutator method for both the numerator and the denominator variable.
	*/
	public void setDecimal(int a, int b)
	{
		numerator = a;
		denominator = b;
	}
	
	/**
	* Accessor method for the numerator variable.
	*/
	public int getNumerator()
	{
		return (numerator);
	}
	
	/**
	* Accessor method for the denominator variable.
	*/
	public int getDenominator()
	{
		return (denominator);
	}
	
	/**
	* Mutator method for the cntr variable.
	*/
	public void setCntr(int number)
	{
		cntr = number;
	}
	
	/**
	* Accessor method for the cntr variable.
	*/
	public int getCntr()
	{
		return (cntr);
	}
	
	/**
	* Simplify method. 
	*/
	private static String simplify(int a, int b)
	{
		int GCD = calcGCD(a, b);		
		int top = a/GCD;
		int bottom = b/GCD;
		return (top + "/" + bottom);
	}
	
	/**
	* Simplify method. 
	*/
	private static int calcGCD(int x, int y)
	{
		if (y == 0)
			return (x);
		else
			return(calcGCD(y, x%y));
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public String add(RationalNumbers r1)
	{
		int new_denominator = denominator * r1.getDenominator();
		int new_numerator = (numerator*r1.getDenominator()) + (r1.getNumerator()*denominator);
		return (simplify(new_numerator, new_denominator));
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public String subtract(RationalNumbers r1)
	{
		int new_denominator = denominator * r1.getDenominator();
		int new_numerator = (numerator*r1.getDenominator()) - (r1.getNumerator()*denominator);
		return (simplify(new_numerator, new_denominator));
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public String multiply(RationalNumbers r1)
	{
		int new_numerator = numerator * r1.getNumerator();
		int new_denominator = denominator * r1.getDenominator();
		return (simplify(new_numerator, new_denominator));
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public String divide(RationalNumbers r1)
	{
		int new_numerator = numerator * r1.getDenominator();
		int new_denominator = denominator * r1.getNumerator();
		return (simplify(new_numerator, new_denominator));
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/	
	public double getValue()
	{
		return ((double)numerator / (double)denominator);
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public RationalNumbers clone()
	{
		RationalNumbers the_clone = new RationalNumbers();
		the_clone.numerator = numerator;		// Copy directly.
		the_clone.setDenominator(getDenominator());	//Copy using set and get methods.
		return (the_clone);
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public static boolean isEqual(RationalNumbers r1, RationalNumbers r2)
	{
		if (r1.getNumerator() == r2.getNumerator() && r1.getDenominator() == r2.getDenominator())
			return (false);
		else
			return (true);
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public static boolean isGreaterThan(RationalNumbers r1, RationalNumbers r2)
	{
		int new_r1_numerator = r1.getNumerator() * r2.getDenominator();
		int new_r2_numerator = r2.getNumerator() * r1.getDenominator();
		
		if (new_r1_numerator > new_r2_numerator)
			return (true);
		else
			return (false);
	}
	
	/**
	*Check method to make sure that there are no divisions by zero, because of user input.
	*/
	public static int checkZero(int denominator)
	{
		if (denominator == 0)
		{
			Scanner Reddo = new Scanner (System.in); 
			
			boolean still_zero = true;
			while (still_zero)
			{
				System.out.print("You can't have a number divided by nothing, bruh. Type a different denominator: ");
				denominator = Reddo.nextInt();	
				
				if (denominator != 0)
					still_zero = false;
			}
			return(denominator);
		}	
		return(denominator);
	}
	
	/**
	* Constructor for the RationalNumbers class.
	* Sets the numerator of the object to 0 and the denominator to 1.
	*/
	public static void main (String[] args)
	{
		Scanner Reddo = new Scanner (System.in);
		System.out.print("First numerator: ");
		int r1_numerator = Reddo.nextInt();
		System.out.print("First denominator: ");
		int r1_denominator = Reddo.nextInt();
		r1_denominator = checkZero(r1_denominator);
		RationalNumbers rational1 = new RationalNumbers();
		rational1.setDecimal(r1_numerator, r1_denominator);
		
		System.out.print("Second numerator: ");
		int r2_numerator = Reddo.nextInt();
		System.out.print("Second denominator: ");
		int r2_denominator = Reddo.nextInt();
		r2_denominator = checkZero(r2_denominator);
		RationalNumbers rational2 = new RationalNumbers();
		rational2.setDecimal(r2_numerator, r2_denominator);
		
		System.out.println("The addition of " + simplify(r1_numerator, r1_denominator) + " and " + simplify(r2_numerator, r2_denominator) + " is: " + rational1.add(rational2));
		System.out.println("The subtraction of " + simplify(r1_numerator, r1_denominator) + " and " + simplify(r2_numerator, r2_denominator) + " is: " + rational1.subtract(rational2));
		System.out.println("The multiplication of " + simplify(r1_numerator, r1_denominator) + " and " + simplify(r2_numerator, r2_denominator) + " is: " + rational1.multiply(rational2));
		System.out.println("The division of " + simplify(r1_numerator, r1_denominator) + " and " + simplify(r2_numerator, r2_denominator) + " is: " + rational1.divide(rational2));
		System.out.println("Is " + simplify(r1_numerator, r1_denominator) + " greater than " + simplify(r2_numerator, r2_denominator) + " ?: " + isGreaterThan(rational1, rational2));
		System.out.println("Is " + simplify(r1_numerator, r1_denominator) + " greater than " + simplify(r2_numerator, r2_denominator) + " ?: " + isEqual(rational1, rational2));
		System.out.println("The decimal version of the first rational number is: " + rational1.getValue() + "\nThe decimal version of the second rational number is: " + rational2.getValue());
	}
}
