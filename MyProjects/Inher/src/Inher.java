/**
 * @(#)Inher.java
 *
 * Inher application
 *
 * @author 
 * @version 1.00 2017/10/3
 */
 import java.util.Scanner;
 import javax.swing.JOptionPane;
 import javax.swing.*;
 import java.awt.event.*; 
 import java.awt.*;   
public class Inher {
    
    public static void main(String[] args) {
    	JFrame f=new JFrame();
    	f.setVisible(true);
    	f.setBounds(500,500,500,500);
    	JPanel p=new JPanel();
    	p.setLayout(null);
    	f.getContentPane().setBackground( Color.RED );
    	//setBackground(Color.red);
    	f.add(p);
        final JRadioButton radbntstu=new JRadioButton("Student");
    	final JRadioButton rbntEmp=new JRadioButton("Employee");
    	rbntEmp.setBounds(100,60,100,50);
    	radbntstu.setBounds(330,60,80,40);
    	JLabel lab1=new JLabel("Name");
    	JLabel lab2=new JLabel("Age");
    	JLabel lab3=new JLabel("ID");
    	JLabel lab4=new JLabel("GPA");
    	JLabel lab5=new JLabel("Salary");
    	lab1.setBounds(150,100,50,50);
    	lab2.setBounds(150,150,40,50);
    	lab3.setBounds(150,200,30,50);
    	lab4.setBounds(150,250,30,50);
    	lab5.setBounds(150,300,40,50);
    	p.add(lab1);
    	p.add(lab2);
    	p.add(lab3);
    	p.add(lab4);
    	p.add(lab5);
    	p.add(rbntEmp);
    	p.add(radbntstu);
    	final JTextField file1=new JTextField();
    	file1.setBounds(220,110,110,30);
    	final JTextField file2=new JTextField();
    	file2.setBounds(220,160,110,30);
    	final JTextField file3=new JTextField();
    	file3.setBounds(220,210,110,30);
    	final JTextField file4=new JTextField();
    	file4.setBounds(220,260,110,30);
    	final JTextField file5=new JTextField();
    	file5.setBounds(220,310,110,30);
    	p.add(file2);
    	p.add(file1);
    	p.add(file3);
    	p.add(file4);
    	p.add(file5);
    	Student stu=new Student();
    	
    	JButton okbnt=new JButton("OK");
    	okbnt.setBounds(220,400,100,50);
    	p.add(okbnt);
    	
    	okbnt.addActionListener(new ActionListener(){
    		
    		 public void actionPerformed(ActionEvent e)
  			{
  				if(radbntstu.isSelected())
  				{
  				
  					Student stu=new Student();
  						String name;
    				    String ID;
    				    String age;
    				    String gpa;
  		      	        name=file1.getText();
  		      	        age=file2.getText();
  		      	        ID=file3.getText();
  		      	        gpa=file4.getText();
  		      	        stu.getInfo(name,ID,age);
  		      	        stu.grtGpa(gpa);
  		      	        JOptionPane.showMessageDialog(null,"Student Data Have Been saved");  
    				  
  				}
  				else if(rbntEmp.isSelected())
  				{
  					
  					   Employee emp=new Employee();
  						String name;
    				    String ID;
    				    String age;
    				    String sal;
  		      	        name=file1.getText();
  		      	        age=file2.getText();
  		      	        ID=file3.getText();
  		      	        sal=file5.getText();
  		      	        emp.getInfo(name,ID,age);
  		      	        emp.getsalert(sal);
  		      	         JOptionPane.showMessageDialog(null,"Employee Data Have Been saved");  
    				  
  				}
  				else 
  					{
  			
  					JOptionPane.showMessageDialog(null,"Please select one and only one Radio Buttton");  
  			     	}
  				  
  			}
    		
    		});
    }
}
