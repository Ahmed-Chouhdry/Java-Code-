/**
 * @(#)Mid.java
 *
 * Mid application
 *
 * @author 
 * @version 1.00 2017/11/1
 */
 import java.util.Scanner;
 import java.util.*;
public class Mid  {
    
    public static void main(String[] args) {
    	ArrayList<personInformation> list=new ArrayList<personInformation>();
    	Scanner input =new Scanner(System.in);
    	personInformation obj=new personInformation();
    	String data;
    	System.out.println("Enter The First Name");
    	data=input.nextLine();
    	obj.setFname(data);
    	System.out.println("Enter The last Name");
    	data=input.nextLine();
    	obj.setLname(data);
    	System.out.println("Enter The Email Name");
    	data=input.nextLine();
    	obj.setEmail(data);
    	System.out.println("Enter The ConNumber");
    	data=input.nextLine();
    	obj.setconNumber(data);
    	System.out.println("Enter The DepName");
    	data=input.nextLine();
    	obj.setdepName(data);
    	System.out.println("Enter The Desig");
    	data=input.nextLine();
    	obj.setDesig(data);
    	System.out.println("Enter The last Salary");
    	data=input.nextLine();
    	obj.setSalary(data);
    	System.out.println("Enter The last Rank");
    	data=input.nextLine();
    	obj.setRank(data);
    	ShowData showdata=new ShowData();
    	list.add(obj);
    	showdata.showRecord(list);
    	
    	
    }
}
