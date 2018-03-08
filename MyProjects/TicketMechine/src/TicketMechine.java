/**
 * @(#)TicketMechine.java
 *
 * TicketMechine application
 *
 * @author 
 * @version 1.00 2017/10/5
 */
 import javax.swing.*;
 import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
public class TicketMechine
 {
    
    public static void main(String[] args) 
    	{
		JFrame frame=new JFrame();
		frame.setBounds(800,100,500,500);
		frame.setVisible(true);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		frame.add(panel);
	    JLabel lab=new JLabel("Ticket Mechine");
	    lab.setBounds(80,0,400,100);
	    lab.setFont(new Font("Serif", Font.BOLD, 48));
	    lab.setForeground(Color.BLUE);
	    panel.add(lab);
	    JRadioButton cus=new JRadioButton("Customer");
	    cus.setBounds(80,100,100,50);
	    cus.setForeground(Color.RED);
	    panel.add(cus);
	    JRadioButton emp=new JRadioButton("Employee");
	    emp.setBounds(350,100,250,50);
	    emp.setForeground(Color.RED);
	    ButtonGroup buttonGroup = new ButtonGroup();
	    cus.setSelected(true);
	    buttonGroup.add(cus);
	    buttonGroup.add(emp);
	    panel.add(emp);
	    String from="ahmed";
	    JComboBox fr=new JComboBox();
	    fr.setBounds(200,150,100,50);
	    panel.add(fr);
	    	
	    
	    
	    
	    
	    
	    
	    
	    
	    JButton cencel=new JButton("Cencel");
	    cencel.setBounds(300,400,100,30);
	    panel.add(cencel);
	    cencel.addActionListener(new ActionListener()
	    {
	    
	    	public void actionPerformed(ActionEvent e)
    		{
    			 System.exit(0);
    		}	
	        
	    } );
    		
    
    }
}

