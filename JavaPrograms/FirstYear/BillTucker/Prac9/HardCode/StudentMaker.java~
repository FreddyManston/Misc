import java.util.Scanner;
import java.util.Arrays;

public class StudentMaker
{
	public static void main (String[] args)
	{
		Scanner Reddo = new Scanner(System.in);
		
		System.out.print("How many students in the list: ");
		int num_students = Reddo.nextInt();
		
		Student [] student_list = new Student [num_students];
		
		for (int i = 0; i < student_list.length; i++)
		{
			System.out.println("Name: ");
			String name = Reddo.next();
			System.out.print("Student Number: ");
			int number = Reddo.nextInt();
			
			student_list [i] = new Student(name, number);
		}
		
		Arrays.sort(student_list);
		
		for (int i = 0; i < student_list.length; i++)
		{
			student_list [i].writeOutput();
		}
	}
}
