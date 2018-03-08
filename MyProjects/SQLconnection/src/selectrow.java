import MyPackage.mydbcon;
import java.sql.*;
public class selectrow {
	public static void all(){
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://local//MyShop");
			String qurry="select * fr0m ShopUser";
			stmt=con.createStatement();
			rs=stmt.executeQuery(qurry);
			while(rs.next())
			{
				String name=rs.getString("UserId");
				String pin=rs.getString("Pin");
				System.out.println("name"+name);
				System.out.println("Pin"+pin);
			}
			rs.close();
			stmt.close();
			con.close();
			
		}catch(Exception e){
			System.out.print(""+e);
		}
	}
}
