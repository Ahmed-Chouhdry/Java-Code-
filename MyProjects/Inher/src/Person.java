/**
 * @(#)Person.java
 *
 *
 * @author 
 * @version 1.00 2017/10/3
 */


public class Person {

    public Person() {
    }
    private String name;
    private String age;
    private String ID;
    public void getInfo(String name, String id,String age)
    {
    	this.name=name;
    	this.ID=id;	
    	this.age=age;
    	System.out.println("\n Name, ID , Age Have BEEN SAVED");
    }
}