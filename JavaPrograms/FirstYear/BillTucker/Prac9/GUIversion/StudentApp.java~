import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * @author Oyama Caldwell Plati , 3442181
 * Created 2014 October 2
 * 
 * (1) In the program I use anonymous classes to Handle events from 
 *     the program. The 'windowDestroyer' is used in as an anonymous class.
 * (2) The program has main method, therefore it can be run as a Stand-Alone program
 * 
 * In this applet, the user can type in the name and number of a student object.
 * The user can click on buttons labeled ADD, DISPLAY to sort the Student object 
 * list. The applet is resizable.
 * */

public class StudentApp extends JFrame{
  
  Student[] students = new Student[10]; // A student list designed to Store 
                                        // any number of objects
  int count = 0; // A counter to keep track of the current number of 
                 // student objects in the List .
  JTextField name , number; // JTextfields for the user to enter the name 
                            // and number of each student object.
  JTextArea show = new JTextArea(); // JTextArea to show the the sorted List 
  
  public StudentApp(){
    
    /**
     * In the contructor I created a container to store the JPanels.
     * Create the name and number JTextAreas and then add them to the 
     * name , number JPanel respecitvely. Create the button JPanel then add the 
     * ADD and DISPLAY JButton which will be registered to an actionListener.
     * Set the size of the Container to 500 by 500 pixels. Use show method to
     * set the window visible.
     * */
    Container content = getContentPane(); // getContentPane() creates the container 
                                          // for the applet.
    
    name = new JTextField();
    name.setBackground(Color.white); // set the color of the JTextField to white
                                     // ( this is likely to be white by Defualt).
    number = new JTextField();
    number.setBackground(Color.white);
    
    /**
     * Create the name, number JPanel. Created with Layout style
     * BorderLayout.WEST and the 
     * JTextField components shown at their 
     * preferred widths. Created with Layout style BorderLayout.CENTER
     * JLabels 'Student Name', 'Student Number' set to occupy the rest of
     * the space left.
     **/
    JPanel namePanel = new JPanel();
    namePanel.setLayout(new BorderLayout());
    namePanel.add(new JLabel("Student Name") , BorderLayout.WEST);
    namePanel.add(name , BorderLayout.CENTER);
    
    JPanel numberPanel = new JPanel();
    numberPanel.setLayout(new BorderLayout());
    numberPanel.add(new JLabel("Student Number") , BorderLayout.WEST);
    numberPanel.add(number , BorderLayout.CENTER);
    
    /**
     * Create a panel to hold the two buttons for the ADD and DISPLAY 
     * operations. A GridLayout is used so that the buttons will all have
     * the same size and will fill the panel. The button Listen for events on 
     * themselves.
     **/
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(2,1));
    
    JButton add = new JButton("ADD >>>");
    add.addActionListener(
                          new ActionListener(){
      public void actionPerformed(ActionEvent evt){
       
        /*When the use clicks on the ADD button 
         * a new Student object is created, the attributes for the 
         * student object are extracted from the JTextField using accessor
         * method getText() which returns strings.
         */
        String op = evt.getActionCommand();
        if(op.equals("ADD >>>")){
          students[count] = new Student();
          students[count].setName(name.getText());
          students[count].setStudentNumber(Integer.parseInt(number.getText().trim()));
          count++;
        }
      }// end actionPerformed()
    }
    );
    buttonPanel.add(add);
    
    JButton display = new JButton("DISPLAY >>>");
    display.addActionListener(
                              new ActionListener(){
      public void actionPerformed(ActionEvent evt){
       
        /*When the user clicks on the DISPLAY button 
         * it is assumed that the student array is already filled, then 
         * the contents of the array are sorted using 
         * the sort method from the Arrays class into ascending order by name.
         * The contents of the array are shown to the user via a JtextArea.
         */
        String op = evt.getActionCommand();
        if(op.equals("DISPLAY >>>")){
          Arrays.sort(students, 0 ,count);                                          
          for(int i = 0 ; i < count ; i++){
             show.append(students[i].toString()+"\n"); 
          }
        }
      }// end actionPerformed()
    }
    );
    buttonPanel.add(display); 
    
    JPanel sortedPanel = new JPanel();
    sortedPanel.setLayout(new GridLayout(count,1));
    sortedPanel.add(show);
     
    /* Set up the layout for the applet, using a GridLayout,
     * and add all the components that have been created.
     */
    content.setLayout(new GridLayout(4,1,10,2));
    content.add(namePanel);
    content.add(numberPanel);
    content.add(buttonPanel);
    content.add(sortedPanel);
    setSize(500,500);
    show();
  }// end StudentApp
  
  /**
   * getInsets Leave some space around the borders of the applet.
   * @return Insets to be implemented in the content Pane
   * */
  public Insets getInsets(){
    return new Insets(40,10,10,10);
  }// end Insets()
  
    /**
     * Main program opens a window whose content can be 'destroyed'
     * (i.e program terminated) by using a windowClosing method from windowAdapter
     */
  public static void main(String[] args){
    StudentApp app = new StudentApp();
    app.addWindowListener(
                          new WindowAdapter(){
      public void windowClosing( WindowEvent evt )
      {
        System.exit(0);
      }
    }
    );
  }// end main 
}// end StudentApp class 
