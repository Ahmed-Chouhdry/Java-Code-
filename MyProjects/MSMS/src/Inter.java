
public class Inter {

    private   String ItemName;
    private  String ItemId;
    private String Quentity;
    private String TotalItems;
    private  String CusName;
    private String UnitPrice;
    private String BillID;
    private  String date1;
    public  void setDate(String Item)
    {
    	this.date1=Item;
    }
    public void setBillId(String item)
    {
    	this.BillID=item;
    }
    public void setCusName(String item)
    {
    	this.CusName=item;
    }
    public void setUnitPrice(String item)
    {
    	this.UnitPrice=item;
    }
    public void setItemId(String item)
    {
    	this.ItemId=item;
    }
     public void setItemName(String item)
    {
    	
    	this.ItemName=item;
    }
     public void setQuentity(String item)
    {
    	
    	this.Quentity=item;
    }
     public void setTotalPrice(String item)
    {
    	this.TotalItems=item;
    }
    // Getter motheds
    public String getItemID()
    {
    	return this.ItemId;
    }
     public String getItemName()
    {
    	return this.ItemName;
    }
     public String getQuentity()
    {
    	return this.Quentity;
    }
     public String getTotalPrice()
    {
    	return this.TotalItems;
    }
    public  String getCusName()
    {
    	return this.CusName;
    }
    public String getUnitPrice()
    {
    	return this.UnitPrice;
    }
    public String getBillID()
    {
    	return this.BillID;
    }
    public  String getDate()
    {
    	return  this.date1;
    }
  
    
}