/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 



/*
*
* FlowLayoutDemo.java
*
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FlowLayoutDemo extends JFrame{
    int count = 0;
    String labelText1 = "Employee name: ", labelText2 = "SAID: " , labelText3 = "Salary: ";
    JRadioButton RtoLbutton;
    JRadioButton LtoRbutton;
    FlowLayout experimentLayout = new FlowLayout();
    final String RtoL = "Right to left";
    final String LtoR = "Left to right";
    JButton applyButton = new JButton("Add"), submitButton = new JButton("Submit");
    JLabel label1 = new JLabel(labelText1+(count+1) ),label2 = new JLabel(labelText2+ (count+1)), label3 = new JLabel(labelText3+ (count+1));
    JTextField textField1 = new JTextField(10), textField2 = new JTextField(10), textField3 = new JTextField(10);
    Employee objArray[] = new Employee[100];
    
    public FlowLayoutDemo(String name) {
        super(name);
    }
    
    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        experimentLayout.setAlignment(FlowLayout.TRAILING);
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());
        
        JPanel next = new JPanel();
        next.setLayout(new FlowLayout());
        
        LtoRbutton = new JRadioButton(LtoR);
        LtoRbutton.setActionCommand(LtoR);
        LtoRbutton.setSelected(true);
        RtoLbutton = new JRadioButton(RtoL);
        RtoLbutton.setActionCommand(RtoL);
        
        //Add buttons to the experiment layout
        compsToExperiment.add(textField1);
        compsToExperiment.add(label1);
        //Left to right component orientation is selected by default
        compsToExperiment.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        
        //Add controls to set up the component orientation in the experiment layout
        controls.add(label2);
        controls.add(textField2);
        controls.add(applyButton);
	controls.add(submitButton);
	
	next.add(label3);
	next.add(textField3);
        
        //Process the Apply component orientation button press
        applyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent y){
            try
            {
		if(count==10)
			throw new ArrayFullException("Array is full. Goodbye.");
		String name = textField1.getText().trim();
		if(name.length() == 0)
			throw new Exception("You have nothing in the name field");
		String salary = textField3.getText().trim().replace("R","");
		for(int j=0;j<salary.length();j++)
			if(!Character.isDigit(salary.charAt(j)) && salary.charAt(j) != '.')
				throw new IDCharacterException("That was not a number.");
		
		String SAID = textField2.getText().trim();
		
		if(SAID.length() != 13)
			throw new IDLengthException(SAID+"'s length of "+SAID.length()+ " is invalid: it must be 13 characters.");
		for(int j=0;j<SAID.length();j++)
			if(!Character.isDigit(SAID.charAt(j)))
				throw new IDCharacterException(SAID+ " is an invalid ID #: it contains an illegal character: "+SAID.charAt(j));

		
		double salaryNum = Double.parseDouble(salary);
                objArray[count] = new Employee(name,salaryNum,SAID);
                count++;
                
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                
                label1.setText(labelText1 + (count+1));
                label2.setText(labelText2 + (count+1));
                label3.setText(labelText3 + (count+1));
                
                }
                catch(IDLengthException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		catch(IDCharacterException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		catch(ArrayFullException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
            }
        });
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
		EmployeeDemo a = new EmployeeDemo(Arrays.copyOfRange(objArray,0,count));
		a.sort();
		Output output = new Output(a.getArray());
		output.setVisible(true);
            }
        });
        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(next, BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH); ;
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        FlowLayoutDemo frame = new FlowLayoutDemo("FlowLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for the event dispatchi thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
