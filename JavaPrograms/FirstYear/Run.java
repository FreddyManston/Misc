import java.util.Scanner;

/**
* <h1>Run class</h1>
* This is the main class of all three classes Run, Student and Mark), where the main method is contained.
* <p>
* <b>For users of the University of the Western Cape.</b>
* @author Joshua Abraham
* @version 1.1
* @since Thu 14 Aug 2014 20:40:23 SAST  
*/
public class Run
{
	/**
	* The main method of all three classes, where the new objects are created, the input is acquired, the output is...outputted, etc..
	* @param ThisGuy An object of the Student class.
	* @param TheScores An object of the Mark class.
	* @param get_name A String of the student's name, acquired from the user.
	* @param get_surname A String of the student's surname, acquired from the user.
	* @param get_student_num An int of the student's student ID, acquired from the user.
	* @param get_test1 A double of the student's mark for thefirst test, acquired from the user.
	* @param get_test2 A double of the student's mark for the second test, acquired from the user.
	* @param get_assignment1 A double of the student's mark for the first assignment, acquired from the user.
	* @param get_assignment2 A double of the student's mark for the second assignment, acquired from the user.
	* @param get_exam A double of the student's exam mark, acquired from the user.
	* @param final_mark A double of the student's final mark, acquired from the getFinalMark in the Mark class.
	* @param symbol A character that corresponds to the final mark, e.g. A for 75% and above, etc.
	* @param status A String that corresponds to the final mark, e.g. Pass if it is above 50%, etc.
	*/
	public static void main (String[] args)
	{
		Scanner key = new Scanner(System.in);
		
		Student ThisGuy = new Student();
			
		System.out.print("Name : ");
		String get_name = key.next();
		System.out.print("Surname : ");
		String get_surname = key.next();
		System.out.print("Student ID : ");
		String get_student_num = key.next();
		ThisGuy.setStudent(get_name, get_surname, get_student_num);
		
		Mark TheScores = new Mark();
		
		System.out.print("Test 1 : ");
		String get_test1 = key.next().replace("%", "");
		System.out.print("Test 2 : ");
		String get_test2 = key.next().replace("%", "");
		System.out.print("Assignment 1 : ");
		String get_assignment1 = key.next().replace("%", "");
		System.out.print("Assignment 2 : ");
		String get_assignment2 = key.next().replace("%", "");
		System.out.print("Exam Mark : ");
		String get_exam = key.next().replace("%", "");
		TheScores.setMark(get_test1, get_test2, get_assignment1, get_assignment2, get_exam);
		
		double final_mark = TheScores.getFinalMark();
		
		System.out.println(ThisGuy.getName() + "\t" + ThisGuy.getSurname() + "\t" + ThisGuy.getStudentNum() + "\t" + final_mark + "%\t" + TheScores.getSymbol(final_mark) + "\t" + TheScores.getStatus(final_mark));
		
	}
}
