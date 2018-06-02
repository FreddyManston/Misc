import java.util.*;
public class MatchParanthesis1
{
	public static void main (String[] args)
	{
		LinkedStack Stack = new LinkedStack();
		Scanner Reddo = new Scanner(System.in);
		
		System.out.print("Key in your paranthesis string: ");
		String str = Reddo.next();
		
		for (int i = 0; i < str.length() - 1; i++)
		{
			char karakter = str.charAt(i);
			
			if(karakter == '(')
			{
				Stack.push(i);	
			}
			else
			{
				if(karakter == ')')
				{
					if(!Stack.isEmpty())
						Stack.pop();
					else
						System.out.println("Unmatched ) at position: " + i);
				}
			}
		}
		
		while(!Stack.isEmpty())
		{
			System.out.println("Unmatched ( at position: " + Stack.pop());
		}
	}
}
