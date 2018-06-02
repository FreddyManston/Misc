
/**
 * Write a description of class Employee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    // instance variables - replace the example below with your own
   public class Employee extends Person implements Comparable {

	//private int studentNumber;
    	private String studentID;
    	private double salary;
    	
    	public Employee ()
    {
        super ();
        //studentNumber = 0;
        studentID = "0";
        salary = 0; 
    }


    public Employee (String initialName, String studID, double sal)
    {
        super (initialName);
        studentID = studID;
        salary = sal;
    }


    public void reset (String newName, String newStud, double newSal)
    {
        setName (newName);
        studentID = newStud;
        salary = newSal;
        
    }
	//Obtaining all variables
    public String getStudentID ()
    {
        return studentID;
    }
    public double getSalary() {
    
    	return salary;
    }
      
    
    

    public int compareTo(Object obj)
    {
        Employee studentname = (Employee) obj;
        return getName().compareTo(studentname.getName());
        
    }

    public void setStudentID (String newStudID)
    {
        studentID = newStudID;
    }

    public void writeOutput ()
    {
        System.out.println ("Name: " + getName ());
        System.out.println ("Student ID: " + studentID);
        
        }


    public boolean equals (Employee otherStudent)
    {
        return this.hasSameName (otherStudent) &&
            (this.studentID == otherStudent.studentID);
    }

}
