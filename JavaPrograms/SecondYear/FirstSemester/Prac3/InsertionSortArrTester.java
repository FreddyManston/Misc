public class InsertionSortArrTester
{	
	public static void main(String[] args)
	{
		Person a = new Person ("Greg", "Verm", 23);
		Person b = new Person ("Shante", "Liedman", 19);
		Person c = new Person ("Freddy", "Manston", 18);
		
		Person[] people = new Person [3];
		
		people [0] = a;
		people [1] = b;
		people [2] = c;
		System.out.println("UNSORTED LIST:");
		for (int i = 0; i < people.length; i ++)
			people [i].writeOutput();
		
		SortList(people);
		System.out.println("SORTED LIST:");
		for (int i = 0; i < people.length; i ++)
			people [i].writeOutput();
	}
	
	public static void SortList (Person[] person_list)
	{
		if (person_list.length != 1)
		{
			for (int index = 1; index < person_list.length; index ++)
			{	
				Person temp = person_list [index];
				
				int i = index;
				while (i > 0)
				{
					if (temp.getSurname().compareTo(person_list [i - 1].getSurname()) < 0)
					{
						person_list [i] = person_list [i - 1];
						person_list [i - 1] = temp;
						i --;
					}
					else
						break;
				}
			}
		}
	}
}
