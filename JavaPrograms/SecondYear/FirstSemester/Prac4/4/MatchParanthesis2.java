import java.util.*;
public class MatchParanthesis2
{
	public static void main (String[] args)
	{
		LinkedStack Stack = new LinkedStack();
		Scanner Reddo = new Scanner(System.in);
		
		System.out.print("Key in your paranthesis string: ");
		String str = Reddo.next();
		String [] croc_array = new String [str.length()];
		
		for (int i = 0; i < str.length() - 1; i++)
		{
			char karakter = str.charAt(i);
			
			if(karakter == '(')
			{
				Stack.push(i);
				croc_array [i] = " ";	
			}
			else
			{
				if(karakter == ')')
				{
					if(!Stack.isEmpty())
					{
						Stack.pop();
						croc_array [i] = " ";
					}
					else
					{
						croc_array [i] = "<";
					}
				}
				else
					croc_array [i] = " ";
			}
		}
		
		while(!Stack.isEmpty())
			croc_array [(int) Stack.pop()] = ">";
		
		System.out.println("\nThere are unmatched parantheses at the following positions in your input:\n");
		System.out.println(str);
		for (int i = 0; i < croc_array.length - 1; i++)
		{	
			System.out.print(croc_array [i]);
		}System.out.println("\n");
	}
}
