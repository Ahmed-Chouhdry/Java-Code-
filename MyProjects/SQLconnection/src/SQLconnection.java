/**
 * @(#)SQLconnection.java
 *
 * SQLconnection application
 *
 * @author 
 * @version 1.00 2017/10/20
 */
import java.sql.*;
//import sun.jdbc.odbc.JdbcOdbcDriver;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTable;
 import javax.swing.table.DefaultTableModel;
 import  javax.swing.*;
 import java.awt.Color;
 import java.util.Vector;
public class SQLconnection extends JFrame{
    
    public static void main(String[] args) {
    	JFrame fr=new JFrame("MSMS");
    	
    	fr.setBounds(600,50,700,350);
    	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	fr.setResizable(false);
    	JPanel p=new JPanel();
    	fr.add(p);
       // p.setBackground(Color.GRAY);
    	Vector<String> columnNames = new Vector<String>();
        columnNames.add("User Name");
        columnNames.add("Pin");
       Vector<Vector<String>> data = new Vector<Vector<String>>();	
       	Vector<String> vstring;		     
     try{
     	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     	Connection con=DriverManager.getConnection("jdbc:odbc:MyShop");
     	Statement st=con.createStatement();
     	ResultSet rs=st.executeQuery("select * from ShopUser");
     	while(rs.next())
     	{
     		vstring=new Vector<String>();
     		vstring.add(rs.getString("UserId"));
     		vstring.add(rs.getString("Pin"));
     		data.add(vstring);
     	}	
     	JOptionPane.showMessageDialog(null,"Connected");
     }catch(Exception e){
     	JOptionPane.showMessageDialog(null,"Sorry");
     }
      DefaultTableModel model = new DefaultTableModel(data, columnNames)
      {
      	 @Override
         public boolean isCellEditable(int row, int column) 
         {
            return false;
         }
      	
      };
        JTable table=new JTable(model);
        table.addMouseListener(null);
    	table.setBounds(15,150,200,250);
    	p.setLayout(null);
    	JScrollPane scroll = new JScrollPane(table);
        p.add(table);
        
        fr.setVisible(true);
    }
}
