import java.io.*;
import java.util.Scanner;
import javax.swing.*;

/**
* <h1>Financial Practical.</h1>
* The aim of this program is to help the user decide whether or not it is wise for him/her to make a specific purchase on credit. Computations are made using input asked for from the user.
* <p>
* <b>For users of all ages.</b>
* @author Joshua Abraham
* @version Financial Practical 1.1
* @since 01/08/2014
*/
public class FinancePrac
{

	/**
	* The future balance is computed, using the users inputs.
	* If the balance is negative the user will lose money equal to the absolute value of the balance.
	* If the balance is positive the user will save money equal to the value of the balance.
	* @param amount_to_pay The credit amount that the user will have to pay off.
	* @param compound_rate The annual compound rate charged, on the credit agreement.
	* @param users_monthly_installment The monthly installment that the user is going to pay for the entirety of 'years_to_pay'.
	* @param years_to_pay The total amount of years for which the user will have to pay their monthly installments.
	* @param num_variable_name These are the parseDouble versions of their string counterparts 
	* @param interest The amount of interest for the month; dependent on the remaining balance (changes after every month).
	* @param balance The balance that is remaining, after computing it with the previous months interest and the monthly installments.
	* @throws IOException
	* @see IOException
	*/
	public static void main (String[] args) throws IOException
	{

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(in);
		
		Scanner key = new Scanner(System.in);

		System.out.println ("What is the amount that you have to pay off?");			
		String amount_to_pay = keyboard.readLine().replace("R","").replace(",",".");
		System.out.println ("What is your bank's daily compound rate?");	
		String compound_rate = keyboard.readLine().replace("%","");
		System.out.println ("What are your monthly installments?");
		String users_monthly_installment = keyboard.readLine().replace("R","").replace(",",".");
		System.out.println ("How many years will it take you to pay of the amount off?");
		String years_to_pay = keyboard.readLine().replace(",",".");

		double num_amount_to_pay = Double.parseDouble(amount_to_pay);
		double num_compound_rate = Double.parseDouble(compound_rate);
		double num_users_monthly_installment = Double.parseDouble(users_monthly_installment);
		double num_years_to_pay = Double.parseDouble(years_to_pay);

		double months_to_pay = num_years_to_pay * 12; // Converts years to months.

		double interest = num_amount_to_pay * ((num_compound_rate / 100) / 365) * 31; // Computes the interest on the payment, which will be taken every day, for 31 days (approximation for 1 month).
		double balance = num_amount_to_pay + interest - num_users_monthly_installment; // Computes the remaining balance that will be brought to the following month.

		/* Do-while loop to recur the previous 2 equations for the remaining amount of months (i.e. total amount of months
		*  minus 1, because first month was already done in the previous two calculations.) 
		*  @param tracker is used to keep count of amount of months computed each time, using incrementation.
		*/
		int tracker = 1; //Running variable
		do
		{
			interest = balance * ((num_compound_rate / 100) / 365) * 31;
			balance = balance + interest - num_users_monthly_installment;
			tracker++;
		}while (tracker <= (months_to_pay - 1));
			
		balance = Math.round(balance*100)/100.0d; // Sets balance to two decimal places.
		System.out.println ("The balance is: R" + balance);
			
	}
}
