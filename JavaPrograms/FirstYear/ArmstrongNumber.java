import java.util.Scanner;

public class ArmstrongNumber
{
	public static void main (String[] args)
	{
		Scanner Redhead = new Scanner(System.in);
		System.out.println("What is your armstrong number?");
		String armstrong = Redhead.next();
		int int_armstong = Integer.parseInt(armstrong);
		
		int length = armstrong.length();
		System.out.println(length);
		double number = 0;
		for (int i = 0; i < length; i++)
		{
			System.out.println(Math.pow((double)armstrong.charAt(i), length));
			
			number = Math.pow((double)armstrong.charAt(i), length) + number;
		}
		
		System.out.println("The value of your armstrong number is: " + number);
		System.out.println(Math.pow(2,3));
	}
}
