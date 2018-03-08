 
import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Test {
	
    static  final int interval=1000;
    int i;
    Timer t;
    JButton bnt;
    JProgressBar bar;
    public  Test()
    {
    	JFrame Frame=new JFrame("Screen");
    	Frame.setLayout(new FlowLayout());
    	bnt=new JButton("enter");
    
    	bnt.addActionListener(new ActionListener(){
    		public  void actionPerformed(ActionEvent e)
    		{
    		i=0;
    		t.start();
    		
    		System.out.println("Oooo");
    		}
    		
    		
    		});
    		bar =new JProgressBar(0,20);
    		bar.setValue(0);
    		bar.setStringPainted(true);
    		
    		Frame.add(bar);
    		Frame.add(bnt);
    		
    		
    		
    	t=new Timer(interval ,new ActionListener(){
    		public  void actionPerformed(ActionEvent e)
    		{
    			if(i==20)
    			{
    				t.stop();
    				
    			}
    			else{
    				i++;
    				bar.setValue(i);
    			}
    		}
    		});	
    	Frame.setVisible(true);
    	Frame.setSize(300,300);
    }
    public static void main(String[] args) {
    
    Test obj=new Test();

        
     
     
     
     
     
     
    
     
     
    }
}
