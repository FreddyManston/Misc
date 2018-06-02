/**
 * @description Creates a database for Employees
 * 
 * @authors Ziyaad Jaffer, Nuraan Khan 
 * @version Awesomeness
 * 
 * @methods getInput(): asks input from the users such as their names, salaray and ID number, 
 *          Average(): calculates the average for the user based on their salary
 *          Display(): displays the sorted list (based on the name of the employees)to the users as well as
 *                     whether their salary is above or below the average
 * @exceptions IDCharacterException: catches if the user typed in an illegal character in their ID number
 *             IDLengthException: catches if the user typed in more than 13 characters for their ID Number
 *             ArrayFullException: catches if the user typed in more than 10 employees in the list
 *             NumberFormatException: catches if the user typed in a non integer for the salary
 * @inputs ID number(String), name(String), salary(Double)
 * @outputs Displays a sorted list(based on the employees name) along with their details
 * @classes Scanner(),ArrayList(),Collections()
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeDemo {
    public static ArrayList<Employee> group = new ArrayList<Employee>();
    private static String id,nm,sala;
    private static double sal,sum,Average,count;
    //private static Employee[] group;
    private static int i;
    public Scanner in = new Scanner(System.in);
    public void getInput(){
        try{
        String cont = "Y";
        
        
        // goes through the following set of statements if the user continuously types in "y"
        while(cont.equalsIgnoreCase("y")){
            if(i == 10)
                throw new ArrayFullException();
            //Scanner in = new Scanner(System.in);
            System.out.print("Enter Employee #" +(i + 1) + "'s name: ");
            nm = in.next();
            
            System.out.print("Enter Employee #" +(i + 1) + "'s salary: ");
            sala = in.next(); 
            sal = Double.parseDouble(sala);
            for(int x = 0; x < sala.length();x++){
                if(Character.isLetter(sala.charAt(x)))
                    throw new NumberFormatException();
            }
            System.out.print("Enter Employee #" +(i + 1) + "'s ID (13 digits): ");
            id  = in.next();
            for(int x = 0; x < id.length(); x++){
                if(Character.isLetter(id.charAt(x)))
                    throw new IDCharacterException(id,id.charAt(x));
                if(id.length() != 13)
                    throw new IDLengthException();
            }
            group.add(new Employee(nm,id,sal));
            //group[i] = new Employee();
            //group[i].Employee(nm,sal,id);
            System.out.print("Continue entering employees? (Y for Yes) ");
            cont = in.next();
            i++;
            count++;
        }
        }
        //the Catch Block with the following exceptions for the Try Block
        catch(IDCharacterException e){
                System.out.println(e.getMessage());
                System.out.println("Re-enter data for employee #" + (i+1));
                System.out.print("Continue entering employees? (Y for Yes) ");
                String cont = in.next();
                if(cont.equalsIgnoreCase("y")){
                    getInput();
                }
                else{
                  //Average();  
                  //Display();
                }  
            }
        catch(IDLengthException e){
            System.out.println(id+ "'s length of " +id.length()+ " is invalid: it must be 13 characters.");
            System.out.println("Re-enter data for employee #" +(i+1));
            System.out.print("Continue entering employees? (Y for Yes) ");
                String cont = in.next();
                if(cont.equalsIgnoreCase("y")){
                    getInput();
                }
                else{
                  //Average();  
                  //Display();
                }  
        }
        catch(ArrayFullException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        catch(NumberFormatException e){
            System.out.println("That was not a number.");
            System.out.println("Re-enter data for employee #" +(i+1));
            System.out.print("Continue entering employees? (Y for Yes) ");
                String cont = in.next();
                if(cont.equalsIgnoreCase("y")){
                    getInput();
                }
                else{
                  //Average();  
                  //Display();
                }  
        }
        }
    //Calculates the average salary of all the employees in the list 
    public void Average(){
        for(int x = 0; x < i;x++){
            sum = sum + group.get(x).getSalary();
            //sum = sum + group[x].getSalary();
        }
        Average = (sum/count);
    }
    //method displays to the user the sorted list of employee names
    //and checks whether the employee salary is below or above average
    public void Display(){
        System.out.println(" ");
        Collections.sort(group);
        Average();
        for(int j = 0; j < i; j++){
            System.out.println("Employee #" + (j+1));
            System.out.println("Name: " + group.get(j).getName());
            System.out.println("Salary: R" + group.get(j).getSalary());
            System.out.println("ID #: " + group.get(j).getStudentID());
            //System.out.println("index" + j);
            if(group.get(j).getSalary() > Average){
                System.out.println(" Above Average");
            }
            else if(group.get(j).getSalary() < Average){
                System.out.println(" Below Average");
            }
            else{
                System.out.println(" Average");
            }
        }
        System.out.println("No more employees.");
    } 
    //Using the main method to run the program
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        EmployeeDemo obj = new EmployeeDemo();
        obj.getInput();
        //obj.Average();
        obj.Display();
        
    }

}