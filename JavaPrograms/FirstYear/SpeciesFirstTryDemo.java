import java.util.Scanner;

class SpeciesFirstTry
{
	public String name;
	public int population;
	public double growthRate;
	
	public void readInput()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the species' name?");
		name = keyboard.nextLine();
		System.out.println("What is the population of the " + "species?");
		population = keyboard.nextInt();
		System.out.println("Enter growth rate " + "(% increase per year):");
		growthRate = keyboard.nextDouble();
	}
	
	public void writeOutput()
	{
		System.out.println("Name = " + name);
		System.out.println("Population = " + population);
		System.out.println("Growth rate = " + growthRate + "%");
	}

	public int getPopulationIn10Years()
	{
		int result = 0;
		double populationAmount = population;
		int count = 10;
		
		while ((count > 0) && (populationAmount > 0))
		{
			populationAmount = populationAmount + (growthRate / 100) * populationAmount;
			count--;
		}
		if (populationAmount > 0)
			result = (int)populationAmount;

		return result;
	}
}

public class SpeciesFirstTryDemo
{
	public static void main(String[] args)
	{
		SpeciesFirstTry speciesOfTheMonth = new SpeciesFirstTry();
		System.out.println("Enter data on the Species of " + "the Month:");
		speciesOfTheMonth.readInput();
		speciesOfTheMonth.writeOutput();
		int futurePopulation = speciesOfTheMonth.getPopulationIn10Years();
		System.out.println("In ten years the population will be " + futurePopulation);

		//Change the species to show how to change the values of instance variables:
		speciesOfTheMonth.name = "Klingon ox";
		speciesOfTheMonth.population = 10;
		speciesOfTheMonth.growthRate = 15;
		System.out.println("The new Species of the Month:");
		speciesOfTheMonth.writeOutput();
		System.out.println("In ten years the population will be " + speciesOfTheMonth.getPopulationIn10Years());
	}
}
	
	
	
	
	
