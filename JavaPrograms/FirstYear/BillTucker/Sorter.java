import java.util.Scanner;

/**
*@author Joshua Abraham - 347 5896
*/
public class Sorter
{
	private Person group[];
	public Scanner Reddo = new Scanner (System.in);
	
	/**
	* This method reads the data for 5 objects of type Person using the method readInput() in the Person class, and stores them in an array.
	*/
	public void readData()
	{
		Person person_list [] = new Person [5];
		
		System.out.println("Enter details.");
		for (int i = 0; i < 5; i++)
		{
			person_list [i] = new Person();
			person_list [i].readInput(Reddo);
			System.out.println();
		}
		
		group = person_list;
	}
	
	/**
	* Prints out the data of a single object in class Person, using the toString() method.
	*/
	public void displayData()
	{
		for (int i = 0; i < group.length; i++)
		{
			System.out.println(group [i]);	// Refers to toString() method. Putting '.toString()' is not neccessary.
		}
	}
	
	/**
	* Sorts an array of type Person in ascending order according to age, using the insertion sort method.
	* @param temp of type Person, will store the current Person object during the for loop, when swoping is needed.
	*/
	public void sequentialSortA()
	{
		Person temp;
		
		for (int i = 0; i < (group.length - 1); i++)	// Only goes to second last item (otherwise index out of range error occurs).
		{
			if (group [i].getAge() > group [i+1].getAge())
			{
				temp = group [i+1];		// Stores the smaller object into temp variable.
				group [i+1] = group [i];	// Moves the bigger object one index up.
				
				// If a swop must occur while i is still 0 (first run of loop) then just make the swop (otherwise index out of range error occurs).
				// Else, check if temp is smaller than all preceding objects in array as well. 
				if (i == 0)			
					group [i] = temp;
				else
				{
					int new_i = i; 
					do 
					{
						// If all preceding numbers have been checked (therefore new_i = 0) then make temp first item in array.
						if (new_i == 0)
							group [new_i] = temp;
						// All preceding numbers greater then temp are moved one index forward, one by one, with each run of the loop.
						else if (temp.getAge() < group [new_i-1].getAge())
							group [new_i] = group [new_i-1];						
						// If not all preceding numbers have been checked, but the directly preceding number (at current index new_i - 1) is smaller than temp, then can conclude that the rest of the preceding numbers are also smaller. Therefore put temp back in array (at current index new_i) and break from loop.
						else
						{
							group [new_i] = temp;
							break;
						}
						
						new_i--;
					}while (new_i > 0);
				}
			}
		}
		System.out.println("This is the list sorted in ascending order according to age: ");		
	}
	
	// Sorting method, in descending order. Sorts the array by finding the largest value in the array and puts it in the first position, then finds the second largest value and puts it in the second position, etc. Sorts an array of integers representing the indeces of the array that needs to be sorted, instead of the actual array itself.
	public void sequentialSortB()
	{
		// Creating an integer array of indices, with length equal to length of group.
		int indices[] = new int [group.length];
			
		int largest = 0;
		// For loop to find the first largest value in the array.
		for (int i = 0; i < group.length; i ++)
			{
				if (group [i].getAge() > largest)
					largest = group [i].getAge();
			}	
		
		//For loop to find the index of the largest value in the array and insert that index into the indeces array (first element).
		for (int i = 0, j = 0; i < group.length; i++)
		{
			if (group [i].getAge() == largest)
			{
				largest = group [i].getAge();
				indices [j] = i;
			}
		}
		
		int j = 1;
		
		while (j != indices.length)
		{
			int next_largest = 0;
			// For loop to find the rest of the largest values in the array.
			for (int i = 0; i < group.length; i++)
			{
				if (group [i].getAge() < largest)
				{
					if (group [i].getAge() > next_largest && group [i].getAge() != largest)
						next_largest = group [i].getAge();
				}
			}
			
			
			//For loop to find the index of the rest of the largest values in the array and insert that index into the indeces array.
			for (int i = 0; i < group.length; i++)
			{
				if (group [i].getAge() == next_largest)
				{
					indices [j] = i;
					j++;
				}
			}
			
			largest = next_largest;
		}
		
		System.out.println("Representation of the indices of the people, sorted in descending order according to age: ");
		for (int i = 0; i < indices.length; i++)
			System.out.print(indices [i] + "  ");
			
		System.out.println();
	}
	
	/**
	* Sorts an array of type Person in ascending order according to height, using the bubble sort method.
	*/
	public void bubbleSort()
	{
		for (int j = 0;  j < group.length; j++)
		{
			for (int i = 0; i < group.length; i++)
			{
				if ((i+1) == group.length)
				{
					// Do nothing.
				}
						
				else if (group [i].getHeight() > group [i+1].getHeight())
				{
					Person temp = group[i];
					group[i] = group[i+1];
					group[i+1] = temp;
				}		
			}
		}
		System.out.println("This is the list sorted in ascending order according to height: ");		
	}
	
	/**
	* Runs the whole program, by calling all neccessary methods.
	*/
	public static void run()
	{
		Sorter object = new Sorter();
		
		object.readData();
		object.displayData();
		System.out.println();
		object.sequentialSortB();	// Displays it's own data.
		System.out.println();
		object.sequentialSortA();
		object.displayData();
		System.out.println();
		object.bubbleSort();
		object.displayData();
	}
	
	/**
	* Main method of the Sorter class. Only used to call on run() method.
	*/
	public static void main (String[] args)
	{
		run();
	}
}

/**
*@param surname a private String variable that stores the surname of a Person object.
*@param firstname surname a private String variable that stores the firstname of a Person object.
*@param age surname a private integer variable that stores the age of a Person object.
*@param height  surname a private double variable that stores the height of a Person object.
*/
class Person 
{	
	private String surname, firstname;
	private int age;
	private double height;
	
	/**
	* Default constructor for the Person class.
	* Initialises surname and firstname to "No name.", as well as age and height to 0 and 0.0 respectively.
	*/	
	public Person ()
	{
		surname = "No name.";
		firstname = "No name.";
		age = 0;
		height = 0.0;
	}

	/**
	* Constructor method for the Person class.
	* @param new_surname String parameter for method containing the surname of the specific Person object.
	* @param new_firstname String parameter for method containing the firstname of the specific Person object.
	* @param new_age int parameter for method containing the age of the specific Person object.
	* @param new_height double parameter for method containing the height of the specific Person object.
	*/
	public Person (String new_surname, String new_firstname, int new_age, double new_height)
	{	
		surname = new_surname;
		firstname = new_firstname;
		age = new_age;
		height = new_height;
	}
	
	/**
	* Modifying method for an object of the Person class.
	* @param new_surname String parameter for method containing the surname of the specific Person object.
	* @param new_firstname String parameter for method containing the firstname of the specific Person object.
	* @param new_age int parameter for method containing the age of the specific Person object.
	* @param new_height double parameter for method containing the height of the specific Person object.
	*/
	public void set(String new_surname, String new_firstname, int new_age, double new_height)
	{
		surname = new_surname;
		firstname = new_firstname;
		age = new_age;
		height = new_height;
	}

	/**
	* Accessor method for the surname of a object in the Person class. Returns a String.
	*/
	public String getSurname()
	{
		return (surname);
	}
	
	/**
	* Accessor method for the firstname of a object in the Person class. Returns a String.
	*/
	public String getFirstname()
	{
		return (firstname);
	}
	
	/**
	* Accessor method for the age of a object in the Person class. Returns an integer.
	*/
	public int getAge()
	{
		return (age);
	}
	
	/**
	* Accessor method for the height of a object in the Person class. Returns a double.
	*/
	public double getHeight()
	{
		return (height);
	}
	
	/**
	* Reads in the input for each parameter of an object of the Person class, using the Scanner class.
	*/
	public void readInput(Scanner scan)
	{		
		System.out.println("Surname: ");
		surname = scan.nextLine();
		System.out.println("Firstname: ");
		firstname = scan.nextLine();
		System.out.println("Age: ");
		age = scan.nextInt();
		System.out.println();
		System.out.println("Height: ");
		height = scan.nextDouble();
		
		//Reddo.close();
	}
	
	/**
	* Prints out the details of an object of the Person class, using the toString() method.
	*/
	public void writeOutput()
	{
		System.out.println(toString());
	}
	
	/**
	* Checks whether one Person object is equal to another, by comparing the individual parameters of each object. Returns a boolean.
	* @param is_equal boolean variable. True if the two objects are equal, False if they are not. Initially assume is_equal to be true.
	*/
	public boolean equals(Person other_person)
	{
		boolean is_equal = true;
		
		if (!surname.equalsIgnoreCase(other_person.getSurname()))
			is_equal = false;
			
		if (!firstname.equalsIgnoreCase(other_person.getFirstname()))
			is_equal = false;
			
		if (age != other_person.getAge())
			is_equal = false;
			
		if (height != other_person.getHeight())
			is_equal = false;
		
		return (is_equal);
	}
	
	/**
	* Clones an object of the Person class and returns the clone.
	+ @param new_person clone of object of Person class. Of type Person as well.
	*/
	public Person myClone()
	{
		Person new_person = new Person(surname, firstname, age, height);
		return (new_person);
	}
	
	/**
	* Returns all the parameters of an object of type Person, line by line, in String form.
	*/
	public String toString()
	{	
		return ("Surname: " + surname + "\nFirstname: " + firstname + "\nAge: " + age + "\nHeight: " + height);
	}	
}

