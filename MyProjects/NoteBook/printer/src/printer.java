/**
 * @(#)printer.java
 *
 * printer application
 *
 * @author 
 * @version 1.00 2017/11/19
 */
 import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.FontMetrics;
public class printer {
    
    public static void main(String[] args) {
    	PrinterJob job = PrinterJob.getPrinterJob();
    	 PageFormat pf = job.defaultPage();
         Paper paper = pf.getPaper(); 
    //	PrinterJob job = PrinterJob.getPrinterJob();
    	 double middleHeight =8.0;  
        double headerHeight = 2.0;                  
         double footerHeight = 2.0;                  
         double width = (8);      //printer know only point per inch.default value is 72ppi
          double height = (headerHeight+middleHeight+footerHeight); 
          paper.setSize(width, height);
          pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
          pf.setPaper(paper);    
         //Graphics g;
    	Graphics2D g2d = (Graphics2D)Graphics g
    	g2d.translate((int)pf.getImageableX(), (int)pf.getImageableY());
    	g2d.setFont(new Font("Aharoni",Font.PLAIN,10));
    	g2d.drawString("I am printer",12,12);
    	System.out.println("Hello World!");
    }
}
