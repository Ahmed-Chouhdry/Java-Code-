/**
 * @(#)ShowData.java
 *
 *
 * @author 
 * @version 1.00 2017/11/2
 */
 import javax.swing.*;
import java.util.*;
public class ShowData   {
 
    private personInformation obj;
    public ShowData() {
    }
    void showRecord(ArrayList<personInformation> list)
    {
    		  Iterator itr=list.iterator();  
               while(itr.hasNext())
               	{  
               System.out.println(itr.next());  
               }  
    }
    
}