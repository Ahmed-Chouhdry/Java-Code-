
 import javax.swing.*;
 import java.awt.BorderLayout;
 import java.awt.Dimension;
 import  java.awt.Toolkit;
 import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
 import  java.awt.Rectangle;
public class Second extends  JWindow  {
	public  Second(JFrame f, int waitTime)
	{
		super(f);
        JLabel l = new JLabel(new ImageIcon("C:\\Users\\Ahmed Jutt\\Desktop\\last.png"));
      //  setBorder(JLabel.NO_BORDER);
        
       // l.setBounds(new Rectangle(10,600,200,110));
       // setLayout(new BorderLayout(null));
       // setVisible(false);
        getContentPane().add(l);
        pack();
        //setUndecorated(true);
        Dimension screenSize =
          Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2),
                    screenSize.height/2 - (labelSize.height/2));
     
        final int pause = waitTime;
        final Runnable closerRunner = new Runnable()
            {
                public void run()
                {
                    setVisible(false);
                    dispose();
                    System.exit(0);
                }
            };
        Runnable waitRunner = new Runnable()
            {
                public void run()
                {
                    try
                        {
                            Thread.sleep(pause);
                            SwingUtilities.invokeAndWait(closerRunner);
                            
                        }
                    catch(Exception e)
                        {
                            e.printStackTrace();
                            
                        }
                }
            };
        setVisible(true);
        Thread splashThread = new Thread(waitRunner, "SplashThread");
        splashThread.start();
        
        
		
	}
    
    public static void main(String[] args) {
    	int i=2000;
    	JFrame f=new JFrame("nice");
    	Second obj=new Second(f,i);
    	
    	
    	
    }
}
