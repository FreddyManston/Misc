import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
An applet that uses a label to display text.
*/
public class EventHandling
{
	public static void main (String[] args)
	{
		MakeLabel label_maker = new MakeLabel();
		label_maker.init();
	}
}

class MakeLabel extends JApplet implements ActionListener
{	
	public void init()
	{
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new FlowLayout());
		
		//Create labels:
		JLabel instructions = new JLabel("I will answer any question, but may need some advice from you.");
		
		//Add labels:
		contentPane.add(instructions);
		
		//Create buttons:
		JButton sunnyButton = new JButton("Sunny");
		JButton cloudyButton = new JButton("Cloudy");
		
		//Add buttons;
		contentPane.add(sunnyButton);
		contentPane.add(cloudyButton);
		
		contentPane.setVisible(true);
		//Adding action listener to buttons:
		sunnyButton.addActionListener(this);
		cloudyButton.addActionListener(this);
	}
}

public void actionPerformed(ActionEvent e)
{
	Container contentPane = getContentPane();

	if (e.getActionCommand().equals("Sunny"))
		contentPane.setBackground(Color.BLUE);
	else if (e.getActionCommand().equals("Cloudy"))
		contentPane.setBackground(Color.GRAY);
	else
		System.out.println("Error in button interface.");
}
