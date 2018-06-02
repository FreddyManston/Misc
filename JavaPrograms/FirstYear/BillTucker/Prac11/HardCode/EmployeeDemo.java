import java.util.Scanner;
import java.util.Arrays;

public class EmployeeDemo
{
	private Scanner Reddo = new Scanner(System.in);
	private Employee employees[] = new Employee[10];
	private int employee_counter = 0;
	private double avg_salary = 0;
	
	/**
	* Main method of the EmployeeDemo class.
	* Creates a new EmployeeDemo object, then uses the run method on the object, to start the program.
	*/
	public static void main (String[] args)
	{
		EmployeeDemo object = new EmployeeDemo();
		object.run();
	}
	
	/**
	* run method
	* Used to run the program.
	*/
	public void run()
	{	
		try
		{
			boolean carry_on = true;
			
			// While loop to loop input till user says no and while valid input is entered.
			while (carry_on)
			{
				System.out.print("Enter employee #" + (employee_counter + 1) + "'s name: ");
				String name = Reddo.next();
			
				System.out.print("Enter employee #" + (employee_counter + 1) + "'s salary: ");
				String str_salary = Reddo.next().replace("R", "").replace(",", ".").replace("r", "");
			
				for (int i = 0; i < str_salary.length(); i++)
					if (!str_salary.charAt(i) == '.')
						if(!Character.isDigit(str_salary.charAt(i)))
							throw new NumberFormatException("That was not a number.");
				
				double num_salary = Double.parseDouble(str_salary);
				
				System.out.print("Enter employee #" + (employee_counter + 1) + "'s ID (13 digits): ");
				String str_ID = Reddo.next();
		
				if(str_ID.length() != 13)
					throw new IDLengthException(str_ID + "'s length of " + str_ID.length() + " is invalid: it must be 13 characters.");
					
				for (int i = 0; i < str_ID.length(); i++)
					if(!Character.isDigit(str_ID.charAt(i)))
						throw new IDCharacterException(str_ID + " is an invalid ID #: it contains an illegal character: " + str_ID.charAt(i));
							
				employees [employee_counter] = new Employee(name, num_salary, str_ID);
				employee_counter ++;

				if(employee_counter < 10)
				{
					System.out.print("Continue entering employees? (Y for Yes) ");
					String answer = Reddo.next();
					
					if(!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("Y"))
						carry_on = false;
				}
				else
				{
					throw new ArrayFullException();
				}
			}
			
			Arrays.sort(employees, 0, employee_counter);
			getAverageSalary();
			displayEmployees();
			System.out.println("No more employees.");
		}
		
		catch(IDLengthException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Re-enter data for employee #" + (employee_counter + 1));
			
			System.out.print("Continue entering employees? (Y for Yes) ");
			String answer = Reddo.next();
			
			if(answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y"))
			{
				run();
			}
			
			else
			{
				if(employee_counter > 0)
				{
					Arrays.sort(employees, 0, employee_counter);
					getAverageSalary();
					displayEmployees();
					System.out.println("No more employees.");
				}
				
				else
				{
					System.out.println("No more employees.");
					System.exit(0);
				}
			}
		}
		
		catch(IDCharacterException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Re-enter data for employee #" + (employee_counter + 1));
			
			System.out.print("Continue entering employees? (Y for Yes) ");
			String answer = Reddo.next();
			
			if(answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y"))
			{
				run();
			}
			
			else
			{
				if(employee_counter > 0)
				{
					Arrays.sort(employees, 0, employee_counter);
					getAverageSalary();
					displayEmployees();
					System.out.println("No more employees.");
				}
				
				else
				{
					System.out.println("No more employees.");
					System.exit(0);
				}
			}
		}
		
		catch(NumberFormatException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Re-enter data for employee #" + (employee_counter + 1));
			
			System.out.println("Continue entering employees? (Y for Yes) ");
			String answer = Reddo.next();
			
			if(answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y"))
			{
				run();
			}
			
			else
			{
				if(employee_counter > 0)
				{
					Arrays.sort(employees, 0, employee_counter);
					getAverageSalary();
					displayEmployees();
					System.out.println("No more employees.");
				}
				
				else
				{
					System.out.println("No more employees.");
					System.exit(0);
				}
			}
		}
		
		catch(ArrayFullException e)
		{
			System.out.println("Array is full.");
			Arrays.sort(employees, 0, employee_counter);
			getAverageSalary();
			displayEmployees();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("An exception has occurred.");
		}
	}
	
	/**
	* getAverageSalary method
	* Used to calculate the average salary of all Employee objects in the employees array and then sets the avg_salary instance variable appropriately.
	*/
	public void getAverageSalary()
	{
		int i = 0;
		double total_salary = 0;
		
		// While loop to run through all current Employees in the employees array and sum their salaries, to get a total salary.
		while (i < employee_counter)
		{
			total_salary = total_salary + employees [i].getSalary();
			i++;
		}
		
		avg_salary = total_salary / employee_counter;
	}
	
	/**
	* displayEmployees method
	* Used to display the details of all Employee objects, as well as how they're salary compares with the averag salary, in the employees array.
	* Uses the writeOutput method of the Employee class to display each Employees details.
	*/
	public void displayEmployees()
	{
		System.out.println();
		
		for (int i = 0; i < employee_counter; i++)
		{
			System.out.println("Employee #" + (i + 1));
			employees [i].writeOutput();
			
			if (employees [i].getSalary() > avg_salary)
				System.out.println("  Above average");
				
			else if (employees [i].getSalary() < avg_salary)
				System.out.println("  Below average");
				
			else
				System.out.println("  Average");
		}
	}
}
