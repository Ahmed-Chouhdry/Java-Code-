/**
 * @(#)Screen.java
 *
 * Screen application
 *
 * @author 
 * @version 1.00 2017/12/22
 */
 import javax.swing.*;
 import java.awt.BorderLayout;
 import java.awt.Dimension;
 import  java.awt.Toolkit;
public class Screen extends JWindow{
	public  Screen(JFrame n)
	{
		 super(n);
        JLabel l = new JLabel(new ImageIcon("F:\\Projects\\JAVA\\MyProjects\\MSMS\\1.PNG"));
        getContentPane().add(l, BorderLayout.CENTER);
        pack();
        Dimension screenSize =
          Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2),
                    screenSize.height/2 - (labelSize.height/2));
        setVisible(true);
        screenSize = null;
        labelSize = null;
	}
    
    public static void main(String[] args) {
    	JFrame f=new JFrame("nice");
    	Screen obj=new Screen(f);
    	System.out.println("Hello World!");
    }
}
