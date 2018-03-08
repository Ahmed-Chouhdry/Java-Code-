/**
 * @(#)Image.java
 *
 * Image application
 *
 * @author 
 * @version 1.00 2017/10/13
 */
 import javax.swing.*;
 import javax.imageio.ImageIO;
public class Image {
    
    public static void main(String[] args) {
    	
    	// TODO, add your application code
    	System.out.println("Hello World!");
    	JFrame fr= new JFrame("Image");
    	fr.setBounds(500,500,500,500);
    	fr.setVisible(true);
    	//fr.add(new JLabel(new ImageIcon("C://Users//AJ//Desktop//images.jpg")));
    	JPanel p=new JPanel();
      	//p.setLayout(null);
    	JLabel image=new JLabel(new ImageIcon("C://Users//AJ//Desktop//images.jpg"));
        image.setBounds(500,500,500,500);
    	p.add(image);
    //	p.add(new JLabel(new ImageIcon("C://Users//AJ//Desktop//images.jpg")));
    	fr.add(p);
    	//JImageComponent ic = new JImageComponent("C:\\Users\\AJ\\Desktop\\images.jpg");
      // fr.add(ic);
    }
}
