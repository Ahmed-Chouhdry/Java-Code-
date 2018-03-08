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
 import java.awt.event.*;
public class NoteBook {
    
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
    	final  JTextField InsertNode=new JTextField();
    	InsertNode.setBounds(100,150,130,28);
    	p.add(InsertNode);
    	final  JTextField totelNode=new JTextField();
    	totelNode.setBounds(300,150,130,28);
    	p.add(totelNode);
    	//final  JTextField noEle=new JTextField();
    	//noEle.setBounds(300,200,130,28);
    	//p.add(noEle);
    	final DefaultListModel<String> l1 = new DefaultListModel<>();  
         
            JList<String> list = new JList<>(l1);  
          list.setBounds(250,300, 100,100);  
    	//final JList list=new JList();
    	//list.setBounds(200,300,100,100);
    	p.add(list);
    			/////
    	final ArrayList al = new ArrayList(); 
    		/////
    	JButton add=new JButton("ADD");
    	add.setBounds(100,300,80,50);
    	p.add(add);
    	add.addActionListener(new ActionListener(){
    		public  void actionPerformed(ActionEvent e)
    		{
    			JList<String> list = new JList<>(l1);  
                list.setBounds(250,300, 100,100); 
    			l1.addElement(InsertNode.getText());
    			list=null;
    			list=new JList<>(l1);
    			al.add(InsertNode.getText());
    			
    			JOptionPane.showMessageDialog(null,"Date Saved");
    			InsertNode.setText("");
    		//	JOptionPane.showMessageDialog(null,"data Filed IS empty");
    			
    			
    		}
    		
    		});
    
    	JButton delete=new JButton("Delete");
    	delete.setBounds(100,370,80,50);
    	p.add(delete);
    	delete.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e)
    		{
    			    Iterator ite= al.iterator();
    				 JList<String> list = new JList<>(l1);  
                     list.setBounds(250,300, 100,100); 
    			     list=null;
    			     l1.removeAllElements();
    			     
    			
    			while(ite.hasNext())
    			{
    			
    				////////
    				String x=(String)ite.next();
    				if(x.equals(totelNode.getText()))
    				{
    	              ite.remove();
    				  JOptionPane.showMessageDialog(null,"Data Delete");
    				  totelNode.setText("");
    				}
    				else
    				{
    				l1.addElement(x);	
    				}
    			}
    				list=new JList<>(l1);
    		  
    		}    	
    		
    		});
    	
    	
       
    }
    	  
    }

