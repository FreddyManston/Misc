
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    
	private String name;
	public Person() {
	
		name = "Nothing";
	
	}
	
	public Person(String nam) {
	
		name = nam;
	
	}
	
	public void setName(String newName) {
	
		name = newName;
	
	}
	
	public String getName() {
	
	return name;
	}
	
	public void writeOutput() {
	
	System.out.println("Name: " + name);
	}

	public boolean hasSameName(Person otherPerson) {
	
		return this.name.equalsIgnoreCase(otherPerson.name);	
	}

}

