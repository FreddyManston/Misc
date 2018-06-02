/**
* Employee class
* Extends the Person class. Implements Java's Comparable class.
* @param salary a private double that holds the salary value of an object of this class.
* @param ID a private string that holds the ID number of an object of this class.
*/
public class Employee extends Person implements Comparable
{
	private double salary;
	private String ID;
	
	/**
	* Employee constructor - no parameter.
	* Default constructor for the Employee class.
	* Uses super for the name of an employee, sets salary to 0.00 and ID to 0000000000000.
	*/
	public Employee()
	{
		super();
		salary = 0.00;
		ID = "0000000000000";
	}
	
	/**
	* Employee constructor - with parameters
	* Default constructor for the Employee class.
	* @param new_name a string used to set the name of the object (using super)
	* @param new_salary a double used to set the salary of the object.
	* @param new_ID a string used to set the ID of the object.
	*/
	public Employee(String new_name, double new_salary, String new_ID)
	{
		super(new_name);
		salary = new_salary;
		ID = new_ID;
	}
	
	/**
	* getSalary method
	* Retunrs a double value of the object's salary.
	*/
	public double getSalary()
	{
		return (salary);
	}
	
	/**
	* getID method
	* Retunrs a string value of the object's ID.
	*/
	public String getID()
	{
		return (ID);
	}
	
	/**
	* setSalary method
	* A method used to change the value of the object's salary.
	* @param new_salary a double used to set the value of the object's salary.
	*/
	public void setSalary(double new_salary)
	{
		salary = new_salary;
	}
	
	/**
	* setID method
	* A method used to change the value of the object's ID.
	* @param new_ID a string used to set the value of the object's ID.
	*/
	public void setID(String new_ID)
	{
		ID = new_ID;
	}
	
	/**
	* writeOutput method
	* Prints out the name, salary and ID # of the object, in that order, one underneath the other.
	*/
	public void writeOutput()
	{
		System.out.println("Name: " + getName());
		System.out.println("Salary: " + salary);
		System.out.println("ID #: " + ID);
	}
	
	/**
	* equals method - for Employee objects
	* Checks whether one Employee object has the same entries for all attributes (i.e. name, salary, ID) as another Employee object.
	* Returns a boolean; true if the objects are identical and false if they aren't.
	* @param other_employee an Employee object that will be compared with the Employee object which the method is being called on.
	*/
	public boolean equals(Employee other_employee)
	{
		return (hasSameName(other_employee) && ID.equalsIgnoreCase(other_employee.getID()) && salary == other_employee.getSalary());
	}
	
	/**
	* equals method - for all objects. Used by the comparable class.
	* Checks whether an object is not empty, is an instance of the Employee class and whether it is identical to the Employee object which the method is being called on.
	* Returns true if all conditions are met and false if even one isn't.
	* @param other_object an object that will be compared with the Employee object which the method is being called on.
	*/
	public boolean equals(Object other_object)
	{
		boolean is_equal = false;

		if ((other_object != null) && (other_object instanceof Employee))
		{
			Employee other_employee = (Employee)other_object;
			is_equal = hasSameName(other_employee) && ID.equalsIgnoreCase(other_employee.getID()) && salary == other_employee.getSalary();
		}

		return is_equal;
	}	
	
	/**
	* compareTo method - from the comparable class
	* Compares the names of two Employee objects. Used to sort Employee objects, by name, in ascending order.
	* For more detail, see the compareTo method in Java's comparable class.
	* @param an_object an object that will be checked for emptyness, whether it is an instance of the Employee class and then compares it's name with the Employee object's name which the method is being called on.
	*/
	public int compareTo(Object an_object)
	{
		if ((an_object != null) && (an_object instanceof Employee))
		{
			Employee other_employee = (Employee) an_object;
			return (getName().compareTo(other_employee.getName()));
		}
		
		return -1;	// Default if other object is not an Employee
	}
}
