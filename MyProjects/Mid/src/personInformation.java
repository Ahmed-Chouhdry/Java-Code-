/**
 * @(#)personInformation.java
 *
 *
 * @author 
 * @version 1.00 2017/11/1
 */


public class personInformation {

    public personInformation() {
    }
    private String Fname;
    private String Lname;
    private String Email;
    private String conNumber;
    private String depName;
    private String Desig;
    private String salary;
    private String rank;
    public void setFname(String data)
    {
    	Fname=data;
    }
    public  void setLname(String data)
    {
    	Lname=data;
    }
    public  void setEmail(String data)
    {
    	Email=data;
    }
    public  void setconNumber(String data)
    {
    	conNumber=data;
    }
    public  void setdepName(String data)
    {
    	depName=data;
    }
    public  void setDesig(String data)
    {
    	Desig=data;
    }
    public  void setSalary(String data)
    {
    	salary=data;
    }
    public  void setRank(String data)
    {
    	rank=data;
    }
    ////////
    //Getter Mothde
    /////////
    String getFname()
    {
    	return  Fname;
    }
    String GetLname()
    {
    	return Lname;
    }
    String getEmail()
    {
    	return Email;
    }
    String getconNumber()
    {
    	return conNumber;
    }
    String getDepName()
    {
    	return  depName;
    }
    String getDesig()
    {
    	return Desig;
    }
    String getSalary()
    {
    	return  salary;
    }
    String getRank()
    {
    	return  rank;
    }
    
}