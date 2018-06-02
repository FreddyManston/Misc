import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MakingAGui extends JFrame implements ActionListener
{
	// Let the textField, textArea and trippyButtons be global variables so that they're accessible in the actionPerformed class.
	private static JTextField textField;	
	private static JTextArea textArea;		
	private static JButton trippyButton1, trippyButton2;
	
	public static void main (String[] args)
	{
		// Creating the JFrame
		JFrame frame = new JFrame("How to make a simple GUI with java.");
		frame.setSize(800, 610);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Setting up the JFrame's ContentPane. 
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEADING));	//Different layouts, with different specs are available in java. Read up at http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		contentPane.setBackground(Color.blue);
		
		// Creating a simple button
		JButton simpleButton = new JButton("Push Me.");
		simpleButton.addActionListener(new MakingAGui());
		
		// Creating a more complex button
		JButton complexButton = new JButton("Or Push Me.");
		complexButton.setBackground(Color.black);	// See Color Class: http://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
		complexButton.setForeground(Color.white);
		complexButton.setToolTipText("I'll print out your sentence. You can also press alt+s.");
		complexButton.setMnemonic('s');
		complexButton.addActionListener(new MakingAGui());
		
		//Creating an even more complex button (set of buttons)
		trippyButton1 = new JButton("No, Push Me.");
		trippyButton1.setBackground(Color.black);
		trippyButton1.setForeground(Color.green);
		trippyButton1.setFont(new Font("Text", Font.ITALIC, 12));	// See Font Class: http://docs.oracle.com/javase/7/docs/api/java/awt/Font.html
		trippyButton1.setToolTipText("I'll print out your sentence. You can also press alt+x.");
		trippyButton1.setMnemonic('x');
		trippyButton1.setVisible(true);
		trippyButton1.addActionListener(new MakingAGui());
		
		trippyButton2 = new JButton("Nein, Push Me.");
		trippyButton2.setBackground(Color.white);
		trippyButton2.setForeground(Color.orange);
		trippyButton1.setFont(new Font("Text", Font.BOLD, 12));
		trippyButton2.setToolTipText("I'll print out your sentence. You can also press alt+x.");
		trippyButton2.setMnemonic('x');
		trippyButton2.setVisible(false);
		trippyButton2.addActionListener(new MakingAGui());
		
		// Creating a JTextField
		textField = new JTextField("Type something", 20);
		// MouseListener event to clear the text in the text field when user clicks on the field:
		textField.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent event)
			{
				textField.setText("");
			}
		});
		
		// Creating a JTextArea
		textArea = new JTextArea("", 10, 40);
		JScrollPane scrollPane = new JScrollPane();	// Provides a scroll function to textArea
		textArea.add(scrollPane);
		textArea.setEditable(false);	// Prevents user from editing data inside textArea
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.orange);
		textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);	// Allows for text wrapping in textArea.
		textArea.setWrapStyleWord(true);	// Wraps text by word, instead of by character.
		
		// Adding all the components to the JFrame's contentPane. Order matters.
		contentPane.add(simpleButton);
		contentPane.add(textField);
		contentPane.add(complexButton);
		contentPane.add(textArea);
		contentPane.add(trippyButton1);
		contentPane.add(trippyButton2);
	}
			
	public void actionPerformed(ActionEvent event)
	{
		if (event.getActionCommand().equals("Push Me."))
			textArea.append("Simple has been pushed.\n");
		
		else if (event.getActionCommand().equals("Or Push Me."))
		{
			String text_in_field = textField.getText();
			textArea.append(text_in_field + "\n");
			textField.setText("Type something else.");
		}
		
		else if (event.getActionCommand().equals("No, Push Me."))
		{
			
			trippyButton1.setVisible(false);
			trippyButton2.setVisible(true);
		}
			
		else if (event.getActionCommand().equals("Nein, Push Me."))
		{
			trippyButton2.setVisible(false);
			trippyButton1.setVisible(true);
		}
		
		else
			System.out.println("Wrong button.");
	}
}
