import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class EmployeeDemoGUI implements ActionListener
{
	private Employee employees[] = new Employee[10];
	private int employee_counter = 0;
	private double avg_salary = 0;
	
	private static JFrame frame;
	private static JButton addEmployee, printEmployees;
	private static JTextField nameField, salaryField, IDField;
	private static JTextArea textArea;
		
	/**
	* Main method of the EmployeeDemo class.
	* Creates a new EmployeeDemo object, then uses the run method on the object, to start the program.
	*/
	public static void main (String[] args)
	{
		// Setting up the frame:
		frame = new JFrame("Employee Name Sorter.");
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		// Setting up the frame's content pane:
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		// Setting up the name panel (label and text field):
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Name: ");
		nameField = new JTextField(20);
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		// Setting up the salary panel (label and text field):
		JPanel salaryPanel = new JPanel();
		JLabel salaryLabel = new JLabel("Salary: ");
		salaryField = new JTextField(20);
		salaryPanel.add(salaryLabel);
		salaryPanel.add(salaryField);
		
		// Setting up the ID # panel (label and text field):
		JPanel IDPanel = new JPanel();
		JLabel IDLabel = new JLabel("ID# (13 Digits): ");
		IDField = new JTextField(20);
		IDPanel.add(IDLabel);
		IDPanel.add(IDField);
		
		// Setting up the buttons panel:
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout(70, 15));
		addEmployee = new JButton("Add Employee");
		addEmployee.addActionListener(new EmployeeDemoGUI());
		printEmployees = new JButton("Display Employees");
		printEmployees.addActionListener(new EmployeeDemoGUI());
		buttonsPanel.add(addEmployee, BorderLayout.WEST);
		buttonsPanel.add(printEmployees, BorderLayout.EAST);
		
		// Setting up the text area:
		textArea = new JTextArea(15, 30);
		textArea.setEditable(false);
		
		// Add all the panels and the text area to the content pane:
		contentPane.add(namePanel);
		contentPane.add(salaryPanel);
		contentPane.add(IDPanel);
		contentPane.add(buttonsPanel);
		contentPane.add(textArea);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getActionCommand().equals("Add Employee"))
		{
			try
			{
				String text_in_name = nameField.getText();
				String text_in_salary = salaryField.getText().replace("R", "").replace(",", ".").replace("r", "");
				String text_in_ID = IDField.getText();
			
				for (int i = 0; i < text_in_salary.length(); i++)
				{
					if (!(text_in_salary.charAt(i) == '.'))
					{
						if(!Character.isDigit(text_in_salary.charAt(i)))
							throw new NumberFormatException("That was not a number.");
					}
				} double num_salary = Double.parseDouble(text_in_salary);
		
				if(text_in_ID.length() != 13)
					throw new IDLengthException(str_ID + "'s length of " + text_in_ID.length() + " is invalid: it must be 13 characters.");
					
				for (int i = 0; i < text_in_ID.length(); i++)
				{
					if(!Character.isDigit(text_in_ID.charAt(i)))
						throw new IDCharacterException(text_in_ID + " is an invalid ID #: it contains an illegal character: " + text_in_ID.charAt(i));
				}
							
				employees [employee_counter] = new Employee(text_in_name, num_salary, text_in_ID);
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
			
			catch(NumberFormatException e)
			{
				textArea.append(e.getMessage());
				
				nameField.setText("");
				salaryField.setText("");
				IDField.setText("");
			}
			
			catch(IDLengthException e)
			{
				textArea.append(e.getMessage());
				
				nameField.setText("");
				salaryField.setText("");
				IDField.setText("");
			}
			
			catch(IDCharacterException e)
			{
				textArea.append(e.getMessage());
				
				nameField.setText("");
				salaryField.setText("");
				IDField.setText("");
			}
			
			catch(ArrayFullException e)
			{
				textArea.append("Array is full.");
				
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
	}
	
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
	
	public void displayEmployees()
	{
		textArea.append("");
		
		for (int i = 0; i < employee_counter; i++)
		{
			textArea.append("Employee #" + (i + 1));
			textArea.append("Name: " + employees [i].getName());
			textArea.append("Salary: " + employees [i].getSalary());
			textArea.append("ID #: " + employees [i].getID());
			
			if (employees [i].getSalary() > avg_salary)
				textArea.append("  Above average");
				
			else if (employees [i].getSalary() < avg_salary)
				textArea.append("  Below average");
				
			else
				textArea.append("  Average");
		}
	}
}
