/**
 * @(#)NoteBook.java
 *
 * NoteBook application
 *
 * @author 
 * @version 1.00 2017/10/18
 */
 import javax.swing.*;
 import java.awt.Color;
 import java.awt.Font;
 import java.util.*;
 import javax.swing.JButton;
 
 import  javax.swing.*;
 import java.awt.Window.*;
 import java.awt.Container;
 import javax.swing.ImageIcon;
 import java.awt.Color;
 import java.awt.*;
 
 
 
 
public class action {
    
    public static void main(String[] args) {
    	JFrame gui=new JFrame("NoteBook");
    	gui.setVisible(true);
    	gui.setBounds(600,30,500,500);
    	gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        gui.setResizable(false);
    	JPanel p=new JPanel();
        p.setLayout(null);
        gui.add(p);
        JLabel lab= new JLabel("Notebook");
        lab.setFont(new Font("Serif", Font.BOLD, 25));
        lab.setBounds(180,20,130,70);
        lab.setForeground(Color.BLUE);
        lab.setBackground(Color.BLACK);
        p.add(lab);
    	JTextField InsertNode=new JTextField();
    	InsertNode.setBounds(100,150,130,28);
    	p.add(InsertNode);
    	JTextField totelNode=new JTextField();
    	totelNode.setBounds(300,150,130,28);
    	p.add(totelNode);
    	JTextField noEle=new JTextField();
    	noEle.setBounds(300,200,130,28);
    	p.add(noEle);
    		
    	JButton add=new JButton("ADD");
    	add.setBounds(100,300,80,50);
    	p.add(add);
    
    	JButton delete=new JButton("Delete");
    	delete.setBounds(100,370,80,50);
    	p.add(delete);
    	delete.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e)
    		{
    		  System.exit(1);
    		}    	
    		
    		});
    	
    	final ArrayList al = new ArrayList(); 
       
    }
    	  
    }

