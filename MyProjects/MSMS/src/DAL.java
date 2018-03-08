import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.util.*; 
import javax.swing.*; 


 
public class DAL {
	private Connection con;
	private Statement st;
	DAL(String str)
	{
	try{
		
		   
		 // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  //con = DriverManager.getConnection("jdbc:odbc:MSMS","","");
            System.out.println("DriverLoaded");
            String url = "jdbc:odbc:; DRIVER = Microsoft Access Driver (*.mdb, *.accdb); DBQ =MSMS.accdb";
           con = DriverManager.getConnection(url);
          Statement st = con.createStatement();
     	  this.st=con.createStatement();
     	  JOptionPane.showMessageDialog(null,"DataBase Connected");
	}catch(Exception e)
	{
		System.out.println(e);
	}
     	   
	
	}
	public  DefaultTableModel  ItemInfo()
	{
		
		
		try
			{
    					
               Vector<Vector<String>> data=new Vector<Vector<String>>();
                Vector<String> da1=new Vector<String>();
		            da1.add(("ItemID"));
			    	da1.add(("ItemName")); 
			    	da1.add(("quentity"));
			    	
			    		data.add(da1);
	           ResultSet rs1=st.executeQuery("select * from Items where quentity<=20;");
		      while(rs1.next())
		         {
		            Vector<String> da=new Vector<String>();
		            da.add(rs1.getString("ItemID"));
			    	da.add(rs1.getString("ItemName")); 
			    	da.add(rs1.getString("quentity")); 
			    
   					data.add(da);
	             }
    		   Vector<String> columnNames = new Vector<String>();
               columnNames.add("Item ID");
               columnNames.add("Item Name");
               columnNames.add("Quantity");
               
               
               DefaultTableModel model = new DefaultTableModel(data,columnNames)
       			{
      	   
       			public boolean isCellEditable(int row, int column) 
        		 {
             		  return false;
           		 }
      	
                 };
                 model.setColumnIdentifiers(columnNames);
                 return model;
	
	}catch(Exception e){
		DefaultTableModel model = new DefaultTableModel();
		return model;
	}
	
}
public ArrayList<String> ItemCombox()
{
	 ArrayList<String> al=new ArrayList<String>();
	try {
		
     	  ResultSet rs1=st.executeQuery("select ItemName  from Items");
     	  //ArrayList<String> al=new ArrayList<String>();
     	   while(rs1.next())
     	   {
     	   
			  al.add(rs1.getString("ItemName")); 
			   
		   }
		   return al;
		
	}catch(Exception e)
	{
		System.out.println("Error in combox ");
		return (al);
	}
		
}
public  void UpdateItems(ArrayList<Inter> al)
{
	try{
		String cmd="insert into Bills"+
			"(BillID,BillDate,ItemName,Quentity,UnitPrince,TotalPrice)"+
				"values(?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(cmd);
	
	 for(Inter model : al) {
	     	
            pst.setString(3,model.getItemName().trim());
            pst.setString(4,model.getQuentity().trim());
            pst.setString(5,model.getUnitPrice().trim());
            pst.setString(6,model.getTotalPrice().trim());
            pst.setString(1,model.getBillID().trim());
            pst.setString(2,model.getDate().trim());
            
            int n=Integer.parseInt(model.getQuentity());
            st.executeUpdate("update Items set quentity-='"+n+"' where ItemName='"+model.getItemName()+"'");
            pst.executeUpdate();
		     
            
            
            
        }
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
	
}
public String  getBillID()
{
	int Billid=0;
	String str=null;
	try {
	
            st.execute("SELECT MAX(BillID) FROM Bills");    
            ResultSet rs2 = st.getResultSet(); // 
            while ( rs2.next() )
            {
                Billid = rs2.getInt(1);
               Billid=Billid+1;
               str=Integer.toString(Billid);
             }
     	  
		  return str;
		
	}catch(Exception e)
	{
		System.out.println(e);
		return (str);
	}
	
}
public  void insertItems(Inter obj)
{
	System.out.println(obj.getItemID());
	try{
	/*	String cmd="insert into Items"
			+"(ItemID,ItemName,quentity,TotalItem)"
				+"values(?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(cmd);
				pst.setString(1,obj.getItemID().trim());
				pst.setString(2,obj.getItemName().trim());
				pst.setString(3,obj.getQuentity().trim());
				pst.setString(4,"1234");
				pst.executeUpdate();*/
	
	st.executeUpdate("insert into Items(ItemID,ItemName,ItemPrice,quentity,TotalItem) values('"+obj.getItemID()+"','"+obj.getItemName()+"','"+obj.getUnitPrice()+"','"+obj.getQuentity()+"',50)");
	JOptionPane.showMessageDialog(null,"New Item inserted");
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
}
public  void UpdateEitem(Inter obj)
{
	try{
		int n=Integer.parseInt(obj.getQuentity());
		st.executeUpdate("update Items set quentity+='"+n+"' where ItemName='"+obj.getItemName()+"'");
	}catch(Exception ee){
		System.out.println(ee);
	}
	
}
public  ArrayList<Inter> saleItem(Inter obj)
{
	
	ArrayList<Inter> list=new ArrayList<Inter>();
	try{
		
	
    ResultSet rs1=st.executeQuery("select * from Bills where BillID='"+obj.getBillID()+"';");
		      while(rs1.next())
		         {
		         	
		            Inter da=new Inter();
		            da.setDate(rs1.getString("BillDate"));
		            da.setItemName(rs1.getString("ItemName"));
			    	da.setQuentity(rs1.getString("Quentity")); 
			    	da.setUnitPrice(rs1.getString("UnitPrince")); 
			    	da.setTotalPrice(rs1.getString("TotalPrice"));
			    	
			    	 
   					list.add(da);
	             }
	System.out.println(obj.getBillID());
	return list;
	}catch(Exception e1)
	{
		System.out.println(e1);
		return  list;
	}
	
}
public  ArrayList<Inter> StockItem()
{
	ArrayList<Inter> list=new ArrayList<Inter>();
	try{
		
	
    ResultSet rs1=st.executeQuery("select * from Items;");
		      while(rs1.next())
		         {
		         	
		            Inter da=new Inter();
		            da.setItemName(rs1.getString("ItemName"));
		            da.setUnitPrice(rs1.getString("ItemPrice"));
		            da.setQuentity(rs1.getString("quentity"));
		            
   					list.add(da);
	             }
	
	return list;
	}catch(Exception e1)
	{
		System.out.println(e1);
		return  list;
	}

	
}

public  void  deleteItem(Inter obj)
{
	
	try{
		st.executeUpdate("delete from Items where ItemName='"+obj.getItemName()+"'");
	}catch(Exception ee){
		System.out.println(ee);
	}
	
}


} 



