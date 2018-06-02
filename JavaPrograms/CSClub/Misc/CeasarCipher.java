import java.util.Scanner;

public class CeasarCipher
{
	public static void main (String[] HayJoe) { run(); }
	
	public static void run()
	{
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("What shift are you going to use (in terms of up shift): ");
			int shift = input.nextInt();

			System.out.println("Type in the text you want to cipher: ");
			String text = input.nextLine();
			text = input.nextLine();
		
			char [] characters = new char [text.length()]; 
			for (int i = 0; i < text.length(); i++)
				characters [i] = text.charAt(i);

			for (int i = 0; i < characters.length; i++)
			{
				int ASCII_val = (int) characters [i];
				if (ASCII_val >= 65 && ASCII_val <= 90)
				{
					ASCII_val  = ASCII_val - 65;
					int new_ASCII = ((ASCII_val + shift) % 26) + 65;
					characters [i] = (char) new_ASCII;
				}
			
				else if (ASCII_val >= 97 && ASCII_val <= 122)
				{
					ASCII_val  = ASCII_val - 97;
					int new_ASCII = ((ASCII_val + shift) % 26) + 97;
					characters [i] = (char) new_ASCII;
				}
			}
		
			System.out.println("\nCeasar output: " + String.valueOf(characters) + "\n");
		}
		
		catch (Exception e) {
			System.out.println("Error from: " + e.getClass());
			System.out.println("Let's try that again.");
			run();
		}
	}
}
