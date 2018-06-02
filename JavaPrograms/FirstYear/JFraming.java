import javax.swing.*;
import javax.awt.BorderLayout;
import javax.awt.event.ActionListener;
import javax.awt.event.ActionEvent;

public class JFraming
{
	public static void main (String[] args)
	{
		new GuiApp1();
	}
	
	public GuiApp1()
	{
		JFrame theFrame = new JFrame();
		
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
