class Strings
{
	public static void main (String[] args)
	{
		String fruit = "banana";

		char letter = fruit.charAt(1);	//char object can contain only one character, apposed to String object which can contain multiple.	
						// charAt method copies the character at specified index.

		int position = fruit.indexOf("a", 2);	//Gets the index where a is found in the string, starting from index 2, i.e. the first 'n'.

		int length = fruit.length();

		System.out.println(position);


		//Comparing Strings:


		String name1 = "Alan Turing";
		String name2 = "Ada Lovelace";

		if (name1.equals (name2)) 				//}
		{							//} Checks if two Strings contain the same characters or not.
			System.out.println("The names are the same.");	//}
		}							//}

		int flag = name1.compareTo (name2);			//}
									//}
		if (flag == 0) 						//}
		{							//}
			System.out.print("The names are the same.");    //}
		}							//} Checks if two strings are identical and if not,
 									//} states which one comes first alphabetically.
		else if (flag < 0) 					//} Here, variable 'flag' will equal positive 8,
		{							//} because the 2nd letter of 'Ada' comes before the 2nd letter
			System.out.print("name1 comes before name2.");  //} of 'Alan' by 8 letters, i.e. name2 is alphabetically first.
		} 							//}
									//}
		else if (flag > 0)					//}
		{							//}
			System.out.print("name2 comes before name1.");  //}
		}							//}
		
		System.out.println (" It comes before the other by " + flag);
	}
}
