import java.awt.BorderLayout;  
import java.awt.Container;  
import java.awt.Dimension;  
import java.awt.FlowLayout;  
   
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
   
public class FlowLayout1  
{  
   
    public static void main(String[] args)  
    {  
        JFrame frame = new JFrame("FlowLayout");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Container contentPane = frame.getContentPane();  
   
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));  
   
        JButton button = new JButton("Button 1");  
        panel.add(button);  
        panel.add(new JButton("Button 2"));  
        panel.add(new JButton("Button 3"));  
        panel.add(new JButton("Button 4"));  
        panel.add(new JButton("Button 5"));  
        panel.setPreferredSize(new Dimension(100, 200));  
        contentPane.add(panel, BorderLayout.LINE_START);  
        contentPane.add(panel, BorderLayout.CENTER);  
        frame.pack();  
        frame.setVisible(true);  
    }  
} 
