/**
* <h1>Student class</h1>
* This class deals with the personal details of the student.
* <p>
* <b>For users of the University of the Western Cape.</b>
* @param name A private String instance variable, for the name of the student.
* @param surname A private String instance variable, for the surname of the student.
* @param student_num A private integer instance variable, for the student's student ID.
* @author Joshua Abraham
* @version 1.1
* @since Thu 14 Aug 2014 20:32:30 SAST 
*/
public class Student
{
	private String name;
	private String surname;
	private int student_num;
	
	/**
	* This mutator method sets the users input in the Run class to the appropriate instance variable in this class.
	* @param new_name User input of the student's name.
	* @param new_surname User input of the student's surname. 
	* @param new_student_num User input of the student's student ID. 
	*/
	public void setStudent (String new_name, String new_surname, String new_student_num)
	{
		name = new_name;
		surname = new_surname;
		
		if (new_student_num.length() != 7)
		{
			System.out.println("Invalid input");
			System.exit(0);
		}
		//System.out.println(new_student_num.charAt(0) != 2);
		if (new_student_num.charAt(0) != '2' && new_student_num.charAt(0) != '3')
		{
			System.out.println("Invalid input");
			System.exit(0);
		}
		
		student_num = Integer.parseInt(new_student_num);
	}
	
	/**
	* An accesor method to allow access to the private 'name' instance variable contained in this class.
	*/
	public String getName()
	{
		return (name);
	}
	
	/**
	* An accesor method to allow access to the private 'surname' instance variable contained in this class.
	*/
	public String getSurname()
	{
		return (surname);
	}
	/**
	* An accesor method to allow access to the private 'student_num' instance variable contained in this class.
	*/	
	public int getStudentNum()
	{
		return (student_num);
	}
	
}
