/**
 * @(#)GUI.java
 *
 * GUI application
 *
 * @author 
 * @version 1.00 2017/9/28
 */
 import javax.swing.*;
public class GUI {
    
    public static void main(String[] args) {
    	
    	
    	JFrame f =new JFrame("GUI");
    	f.setVisible(true);
    	f.setBounds(500,500,500,500);
    	JPanel p=new JPanel();
    	p.setLayout(null);
    	f.add(p);
    	JButton b=new JButton("ok");
    	b.setBounds(50,50,100,100);
    	p.add(b);
    	b.addActionListener(new Action()
    		{
    		public void actionPerformed(ActionEvent e)
    		{
    			System.out.println("Ahmed");
    		}	
    		
    	});
    }
}
