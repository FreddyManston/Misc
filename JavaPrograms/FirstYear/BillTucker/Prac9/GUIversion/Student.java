public class Student extends Person implements Comparable

{
	private int student_number;
	
	public Student()
	{
		super();
		student_number = 0;	//Indicating no number yet
	}
	
	public Student(String initial_name, int initial_number)
	{
		super(initial_name);
		student_number = initial_number;
	}
	
	public void reset(String new_name, int new_number)
	{
		setName(new_name);
		student_number = new_number;
	}

	public int getStudentNumber()
	{
		return student_number;
	}
	
	public void setStudentNumber(int new_number)
	{
		student_number = new_number;
	}
	
	public void writeOutput()
	{
		System.out.println("Name: " + getName());
		System.out.println("Student Number: " + student_number);
	}
	
	public boolean equals(Student other_student)
	{
		return this.hasSameName(other_student) && (this.student_number == other_student.student_number);
	}
	
	public boolean equals(Object other_object)
	{
		boolean is_equal = false;

		if ((other_object != null) && (other_object instanceof Student))
		{
			Student other_student = (Student)other_object;
			is_equal = this.hasSameName(other_student) && (this.student_number == other_student.student_number);
		}

		return is_equal;
	}	
	
	public int compareTo(Object an_object)
	{
		if ((an_object != null) && (an_object instanceof Student))
		{
			Student otherStudent = (Student) an_object;
			return (getName().compareTo(otherStudent.getName()));
		}
		
		return -1;	// Default if other object is not a Student.
	}
}
