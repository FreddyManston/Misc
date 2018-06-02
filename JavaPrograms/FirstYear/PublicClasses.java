/*
* Dog class that is used in class PublicClasses.
* This class can also be saved in a seperate file called 'Dog.java' AND IT WILL STILL WORK! WHAT??
*/
class Dog
{
	public String name;	// Instance variable 'name' of Dog class.
	public String breed;	// Instance variable 'breed' of Dog class.
	public int age;		// Instance variable 'age' of Dog class.
	
	public void writeOutput()
	{
		System.out.println("Name: " + name);
		System.out.println("Breed: " + breed);
		System.out.println("Age in calendar years: " + age);
		System.out.println("Age in human years: " + getAgeInHumanYears());
		System.out.println();
	}

	public int getAgeInHumanYears()
	{
		int humanAge = 0;
		if (age <= 2)
		{
			humanAge = age * 11;
		}
		else
		{
			humanAge = 22 + ((age-2) * 5);
		}
		return humanAge;
	}
}

public class PublicClasses
{
	/*
	* Main method of class PublicClasses.
	*/
	public static void main(String[] args)
	{
		Dog balto = new Dog();	// Creates a new object 'balto' using the Dog class.
		
		balto.name = "Balto";	
		balto.age = 8;
		balto.breed = "Siberian Husky";
		balto.writeOutput();	// Prints balto's deets, using .writeOutput() method in the Dog class.
		
		Dog scooby = new Dog();	// Creates a new object 'scooby' using the Dog class.
		
		scooby.name = "Scooby";
		scooby.age = 42;
		scooby.breed = "Great Dane";
		
		// Manually prints scooby's deets.
		System.out.println(scooby.name + " is a " +scooby.breed + ".");
		System.out.print("He is " + scooby.age + " years old, or ");
		int humanYears = scooby.getAgeInHumanYears();
		System.out.println(humanYears + " in human years.");
	}
}
