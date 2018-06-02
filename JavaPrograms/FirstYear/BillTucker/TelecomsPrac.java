//Author: Joshua Abraham
//Name: Prepaid or contract.
//Description: Asks user how much smses, data and voice minutes they use every month. Using this information, the program tells the user whether it would be more affordable to buy the LG Nexus 5 on contract or prepaid, using contracts and rates offered by Cell C

import java.io.*;
import java.util.Scanner;
import javax.swing.JFrame;

public class TelecomsPrac
{
	public static void main (String[] args) throws IOException
	{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(in);
		
		Scanner key = new Scanner(System.in);

		System.out.print ("Which service provider are you with?: ");
		String provider = keyboard.readLine();


		String str_data = JOptionPane.showInputDialog("How much data do you spend per month? Please type your answer in MB's: ");
		int data = Integer.parseInt(str_data);
		System.out.print("Approximately how many voice minutes do you use per month?: ");
		int call = key.nextInt();
		System.out.print("On average, how many SMSes do you send each month?: ");	
		int sms = key.nextInt();

		System.out.print ("What is the prepaid sms rate offered by your service provider?: ");
		String smsrate = key.next();
		double sms_rate = Double.parseDouble (smsrate);
		System.out.println (smsrate + sms_rate); 
		System.out.print ("What is the prepaid data rate per MB offered by your service provider?: ");
		double data_rate = key.nextDouble();
		System.out.print ("What is the prepaid call rate per minute offered by your service provider?: ");
		double call_rate = key.nextDouble();

		System.out.print ("How much is the contract, which you are looking at, per month?: ");
		double contract_price = key.nextDouble();

		double total_prepaid = ((data*data_rate) + (sms*sms_rate) + (call*call_rate)) * 24;
		double total_contract = contract_price * 24;

		System.out.println("Thank you again for your utilising our services. We're now processing the information.");
		System.out.println(provider + " \nOn prepaid, it would cost: R" + total_prepaid + ". \nOn contract it would cost: R" + total_contract + ".");
		
	}
	
}


