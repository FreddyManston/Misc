import java.util.Arrays;
import java.util.Scanner;
public class StudentDemo
{
  /**
   * In the studentDemo class I created an array of student objects, 
   * sorted them, and output the studens.
   * The students are listed by ascending student name. 
   * */
  static Scanner scanner = new Scanner(System.in);
  private static int NUMBER_OF_STUDENTS;
  static Student[] students;
  
  /**
   * main method uses a scanner to ask for the number of students,
   *      then loop that list many times collecting values, one value per line.
   * */
 public static void main(String[] args)
 {
   System.out.print("How many students ? ");
   NUMBER_OF_STUDENTS = Integer.parseInt(scanner.next().trim());
   System.out.println();
   students = new Student[NUMBER_OF_STUDENTS];
   for (int i = 0; i < NUMBER_OF_STUDENTS;i++){
     students[i] = new Student();
     System.out.print("Student " + (i+1) +" name : ");
     students[i].setName(scanner.next());
     System.out.println();
     System.out.print("Student " + (i+1) + " number : ");
     students[i].setStudentNumber(scanner.nextInt());
     System.out.println();
     
     }
   

   Arrays.sort(students);

  // Output the sorted array of fruits
  for (Student f : students)
  {
    f.writeOutput();
  }
 }// end main()
} 