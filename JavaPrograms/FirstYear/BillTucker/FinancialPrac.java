import java.util.Scanner;

public class FinancialPrac {

    public static void main(String[] args) 
    {

        Scanner keyboard = new Scanner(System.in);
        
	//Amount to pay
        System.out.print("Amount to Pay: ");
        String principal = keyboard.next();
	double new_principal = 0;
        
	switch (principal.charAt(0))
	{
		case 'R':
        	int len=principal.length();
        	principal=principal.substring(1,len);
        	new_principal = Double.parseDouble(principal); 
		break;
		
		default:
		new_principal = Double.parseDouble(principal);
		break;
	}

	//Monthly installment
        System.out.print("Monthly instalment: ");
        String installment = keyboard.next();
        double new_installment = 0;

        switch (installment.charAt(0))
        {
		case 'R':
		int len = installment.length();
		installment = installment.substring(1,len);
		new_installment = Double.parseDouble(installment);
		break;

		default:
		new_installment = Double.parseDouble(installment);   
		break;   
        }
 
	//Interest rate
        System.out.println("Interest per annum: ");
        String rate = keyboard.next();
	double new_rate;
        
        switch (rate.charAt(0))
        {
		case '%':
		int len = rate.length();
		rate=rate.substring(1,len);
		new_rate = Double.parseDouble(rate);
        	break;
		
		default:
		new_rate = Double.parseDouble(rate);
		break;          
	}

	//Years to pay
        System.out.println("Number of years to pay: ");
        double time = keyboard.nextDouble();
        double new_time = time*12;

        double interest = 0;
	double balance = new_principal;

        int track = 1; //Running variable

        while (track <= new_time)
        {   
		interest = (balance*((new_rate/100)/365)*31);
		balance = (balance+interest-new_installment);
		track ++;
        }
        
        balance=Math.round(balance*100)/100.0d;
        System.out.println("Balance = R"+balance);
    }
    
}
