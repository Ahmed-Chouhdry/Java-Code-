/**
 * @(#)Clock.java
 *
 * Clock application
 *
 * @author 
 * @version 1.00 2017/10/12
 */
 import javax.swing.*;
 import java.awt.Font;
 import java.awt.Color;
 import javax.swing.Timer;
 import java.awt.GridLayout;
 import java.text.SimpleDateFormat;
 import java.lang.*;

import java.util.Calendar;


public class Clock {
    
    public static void main(String[] args) {
    	JFrame fram=new JFrame("Clock");
    	fram.setBounds(800,100,500,500);
    		fram.setVisible(true);
    		fram.getContentPane().setBackground(Color.black);
    		JPanel pane=new JPanel();
    		pane.setLayout(null);
    		fram.add(pane);
    		JLabel lab=new JLabel("Digital Clock");
    		lab.setBounds(100,10,300,50);
    	     lab.setFont(new Font("Courier New", Font.BOLD, 35));
    	     lab.setForeground(Color.BLUE);
    		pane.add(lab);
    		JTextField hour = new JTextField();
    		hour.setBounds(150,100,200,50);
    		hour.setVisible(true);
    		pane.add(hour);
    		// Timer t = new Timer(1000);
    		 // Timer t = new Timer(1000, this);
    		// Calendar cal = Calendar.getInstance();
    		 Calendar cal = Calendar.getInstance();
    		 char ch='y';
    		 Thread t = Thread.currentThread();
    		 	do
    		 	{
    		 	
             // SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
             // String a= format.format(cal.getTime());
              SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
              String a= format.format(cal.getTime());
                //System.out.println(a);
                 hour.setText(a);
                 //Thread.sleep(1000);
    		 	}while(ch=='y');
               //Calender cal=new GregorianCalendar();
              // int min=cal.get(Calendar.DATE);
              // System.out.print(min);
    		 // Date date = new Date();
    		 // hour.setText(date);
             //System.out.println((t));
            // SimpleDateFormat sdf=new  SimpleDateFormat("MMMM dd yyyy");
             //	setText(sdf.format(date));
             //hour.setText(dateFormat.format(date));
    		 
    	//	hour=t;
    		
    
    }
}
