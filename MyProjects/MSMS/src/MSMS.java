
 import  javax.swing.*;
 import java.awt.Window.*;
 import java.awt.Container;
 import javax.swing.ImageIcon;
 import java.awt.Color;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.JOptionPane;
 import javax.swing.border.EmptyBorder;
 import javax.swing.JTable;
 import java.util.Vector;
 import javax.swing.table.DefaultTableModel;
 import java.sql.*;
 import java.util.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 import java.awt.List;
 
 
public class MSMS extends  JWindow{
	
    MSMS(JFrame f, int waitTime)
    {
    		super(f);
        JLabel l = new JLabel(new ImageIcon("Screen.png"));
        getContentPane().add(l);
        pack();
        Dimension screenSize =
          Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2),
                    screenSize.height/2 - (labelSize.height/2));
     
        final int pause = waitTime;
        final Runnable closerRunner = new Runnable()
            {
                public void run()
                {
                    setVisible(false);
                    dispose();
                    
                }
            };
        Runnable waitRunner = new Runnable()
            {
                public void run()
                {
                    try
                        {
                            Thread.sleep(pause);
                            SwingUtilities.invokeAndWait(closerRunner);
                            
                        }
                    catch(Exception e)
                        {
                            e.printStackTrace();
                            
                        }
                }
            };
        setVisible(true);
        Thread splashThread = new Thread(waitRunner, "SplashThread");
        splashThread.start();
    
    }
    public static void main(String[] args) {
    	
        int i=2000;
    	JFrame f=new JFrame("nice");
    	MSMS obj=new MSMS(f,i);
    	final DAL ObjDal=new DAL("nice");
    	final Inter objInter=new Inter(); 
     	final  JFrame fr=new JFrame("MSMS");
    	
    	fr.setBounds(600,50,700,350);
    	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	fr.setResizable(false);
    
        Container c =fr.getContentPane();
        c.setBackground(Color.GRAY);
        c.setLayout(null);
       
        JLabel lab=new JLabel(" Username");
        lab.setForeground(Color.RED);
        lab.setFont(new Font("Serif", Font.BOLD, 14));
        lab.setBounds(370,70,80,50);
        c.add(lab);
        JLabel lab1=new JLabel("Passcode");
        lab1.setForeground(Color.RED);
        lab1.setFont(new Font("Serif", Font.BOLD, 14));
        lab1.setBounds(375,105,80,50);
        c.add(lab1);
        final  JTextField tf=new JTextField();
        tf.setBounds(450,88,160,18);
        c.add(tf);
        final  JPasswordField pf=new JPasswordField();
        pf.setBounds(450,122,160,18);
        c.add(pf); 
      	ImageIcon icon=new ImageIcon("1.PNG");
       	JButton image=new JButton(icon);
       	image.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        c.add(image);
    	JButton logIn=new JButton("LogIn");
    	logIn.setBounds(510,160,100,30);
    	logIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	c.add(logIn);
    	logIn.addActionListener(new ActionListener()	{
    		
    		public  void actionPerformed(ActionEvent e)
    		{
    			String name=null,pass=null;
    			name=tf.getText();
    			pass=pf.getText();
    			
    			if((name.trim()).equals("Admin")&&(pass.trim()).equals("2552"))
    			{
    				
    					fr.setVisible(false);
    					final  JFrame mainFrame=new JFrame("MSMS");
    					mainFrame.setUndecorated(true);
    					mainFrame.setVisible(true);
    					final  JPanel p=new JPanel();
    					mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    					mainFrame.setBounds(500,10,800,600);
    					p.setBackground(Color.GRAY);
    					p.setLayout(null);
    					JLabel labItem= new JLabel("MSMS");
    					labItem.setFont(new Font("Serif", Font.BOLD, 100));
    					labItem.setBounds(50,30,300,100);
    					p.add(labItem);
    					JButton exit =new JButton("x");
    				    mainFrame.add(p);
    					exit.setBounds(750,20,50,40);
    					exit.setVisible(true);
    					exit.setBackground(Color.RED);
    					p.add(exit);
    					exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
    					exit.addActionListener(new ActionListener(){
    						public void actionPerformed(ActionEvent e)
    						{
    						    System.exit(1);
    						}    						
    						});
    					JButton stock=new JButton("Stock");
    					stock.setVisible(true);
    					stock.setBounds(400,250,120,50);
    					stock.setCursor(new Cursor(Cursor.HAND_CURSOR));
    					stock.setForeground(Color.BLUE);
    					p.add(stock);
    					JButton sale=new JButton("Sale");
    					sale.setVisible(true);
    					sale.setBounds(580,250,120,50);
    					sale.setCursor(new Cursor(Cursor.HAND_CURSOR));
    					sale.setForeground(Color.BLUE);
    					p.add(sale);
    					JButton gb=new JButton("<html>Generate<br>&ensp;&ensp;Bill</html>");
    					gb.setVisible(true);
    					gb.setBounds(400,380,120,50);
    					gb.setCursor(new Cursor(Cursor.HAND_CURSOR));
    					gb.setForeground(Color.BLUE);
    					p.add(gb);
    					JButton pur=new JButton("Purchase");
    					pur.setVisible(true);
    					pur.setBounds(580,380,120,50);
    					pur.setCursor(new Cursor(Cursor.HAND_CURSOR));
    					pur.setForeground(Color.BLUE);
    					p.add(pur);
    					
                        final DefaultTableModel ItemModel = ObjDal.ItemInfo();
                        
                       
    				     final  JTable table = new JTable(ItemModel);
    				    table.setFont(new Font("Serif", Font.BOLD, 14));
    				    table.setRowHeight(20);
    				    String col [] = {"Name","Course","Year"};
    				     JTableHeader header = table.getTableHeader();
    				     header.setBackground(Color.yellow);
    				    
    					table.setBounds(15,250,300,250);
    					p.add(table);
    					stock.addActionListener(new ActionListener(){
    						public  void actionPerformed(ActionEvent e)
    						{
    							ArrayList<Inter> list=new ArrayList<Inter>();
    							list=ObjDal.StockItem();
    						     mainFrame.dispose();
    							final JFrame stframe=new JFrame("Strock");
    							stframe.setBounds(200,100,800,600);
    							JPanel stpanel=new JPanel();
    							stpanel.setLayout(null);
    							stframe.add(stpanel);
    							
    							
    							JLabel Items=new JLabel("Stock");
    							Items.setFont(new Font("Serif", Font.BOLD, 50));
    							Items.setBounds(100,50,300,50);
    						    Items.setForeground(Color.BLUE);
    						    stpanel.add(Items);
    						    
    						    JLabel labSel=new JLabel("Select");	
    							labSel.setBounds(480,160,100,50);
    						    stpanel.add(labSel);

    							 final JComboBox comItem=new JComboBox(ObjDal.ItemCombox().toArray());
    							 comItem.setBounds(480,200,150,30);
    							 stpanel.add(comItem);
    							 
    							 JButton bntdelte=new JButton("Delete");
    							 bntdelte.setBounds(480,250,100,50);
    							 stpanel.add(bntdelte);
    							 bntdelte.addActionListener(new ActionListener(){
    							 	public  void actionPerformed(ActionEvent e)
    							 	{
    							 		objInter.setItemName(comItem.getItemAt(comItem.getSelectedIndex()).toString());
    							 		ObjDal.deleteItem(objInter);
    							 	}
    							 	
    							 	
    							 	
    							 	});
    							 
    							 
    							 
    							 
    						   String columns[] = {"","",""};
    				           	Object data[][] = {{"ItemName","Quentity","Price"}};
    				           	
    				     	   final  DefaultTableModel model = new DefaultTableModel(data, columns)
    				     	   {
    				     		public boolean isCellEditable(int row, int column) 
        		                {
             		                return false;
           	                    }
    				     	   };
    				     	   
    				     	   for(Inter del:list)
    				     	   	{
    				     	    		
    				     	     	model.addRow(new Object[] {  
                                             del.getItemName(),
                                             del.getQuentity(),
                                             del.getUnitPrice()
                                              
    
                                       });
    				     	   	}
    				     	     final 	JTable stockTable=new JTable(model);
    							stockTable.setBounds(10,150,400,400);
    							stpanel.add(stockTable);
    				     	   stockTable.setFont(new Font("Serif", Font.BOLD, 14));
    				     	   stockTable.setRowHeight(25);
    							stframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    							JButton back=new JButton("Back");
    							back.setBounds(700,10,100,30);
    							stpanel.add(back);
    							back.addActionListener(new ActionListener(){
    								public  void actionPerformed(ActionEvent e)
    								{
    								stframe.setVisible(false);
    								mainFrame.setVisible(true);
    								}
    								});
    								
    							stframe.setVisible(true);
    							
    						}
    						
    						});
    					pur.addActionListener(new ActionListener()
    					{
    						public void actionPerformed(ActionEvent e)
    						{
    							
    							mainFrame.dispose();
    							final JFrame purframe=new JFrame("PUR");
    							purframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    							purframe.setBounds(400,30,800,600);
    							purframe.setResizable(false);
    							JPanel purPanel=new JPanel();
    							purPanel.setLayout(null);
    							purframe.add(purPanel);
    							JLabel Items=new JLabel("Insert Items");
    							Items.setFont(new Font("Serif", Font.BOLD, 50));
    							Items.setBounds(100,50,300,50);
    						    Items.setForeground(Color.BLUE);
    							purPanel.add(Items);
    							
    							JLabel update=new JLabel("UpDate Items");
    							update.setFont(new Font("Serif", Font.BOLD, 20));
    							update.setBounds(30,200,120,30);
    							purPanel.add(update);
    							
    							JLabel newItems=new JLabel("New Items");
    							newItems.setFont(new Font("Serif", Font.BOLD, 20));
    							newItems.setBounds(430,200,120,30);
    							purPanel.add(newItems);
    							JLabel selectitem=new JLabel("Select Item");
    							selectitem.setBounds(100,220,100,30);
    							purPanel.add(selectitem);
    							final JComboBox comItem=new JComboBox((ObjDal.ItemCombox().toArray()));
    							comItem.setBounds(100,250,150,30);
    							purPanel.add(comItem);
    							JLabel labQuan=new JLabel("Quantity");
    							labQuan.setBounds(100,320,100,30);
    							purPanel.add(labQuan);
    	
    						
    							
    							final JTextField txtQuan=new JTextField();
    							txtQuan.setBounds(100,350,150,30);
    							purPanel.add(txtQuan);
    							JButton bntUpdate=new JButton("Update Item");
    							bntUpdate.setBounds(100,450,130,50);
    							purPanel.add(bntUpdate);
    							
    							JLabel labItemId=new JLabel("Items ID");
    							labItemId.setBounds(440,230,100,30);
    							purPanel.add(labItemId);
    							final JTextField txtItemId=new JTextField();
    							txtItemId.setBounds(440,260,150,30);
    							purPanel.add(txtItemId);
    							///////
    							JLabel labItemName=new JLabel("Items Name");
    							labItemName.setBounds(440,290,130,50);
    							purPanel.add(labItemName);
    							final JTextField txtItemName=new JTextField();
    							txtItemName.setBounds(440,330,150,30);
    							purPanel.add(txtItemName);
    							/////
    							JLabel labItemQuentity=new JLabel("Quentity");
    							labItemQuentity.setBounds(440,360,100,30);
    							purPanel.add(labItemQuentity);
    							final JTextField txtItemQuentity=new JTextField();
    							txtItemQuentity.setBounds(440,390,150,30);
    							purPanel.add(txtItemQuentity);
    							////////////////
    							JLabel labPrice=new JLabel("Price");
    							labPrice.setBounds(600,360,100,30);
    							purPanel.add(labPrice);
    							///////////
    							final JTextField txtPrice=new JTextField("0");
    							txtPrice.setBounds(600,390,100,30);
    							purPanel.add(txtPrice);
    							
    							
    							
    							
    							
    							
    							////////////
    							bntUpdate.addActionListener(new ActionListener(){
    								public  void actionPerformed(ActionEvent e)
    								{
    									objInter.setItemName(comItem.getItemAt(comItem.getSelectedIndex()).toString());
    									objInter.setQuentity(txtQuan.getText().trim());
    									ObjDal.UpdateEitem(objInter);
    									
    								}
    								});
    							//////
    							JButton bntnewItem=new JButton("New Item");
    							bntnewItem.addActionListener(new ActionListener(){
    								public  void actionPerformed(ActionEvent e)
    								{
    									
    									objInter.setItemId(txtItemId.getText().trim());
    									objInter.setItemName(txtItemName.getText().trim());
    									objInter.setQuentity(txtItemQuentity.getText().trim());
    									objInter.setUnitPrice(txtPrice.getText().trim());
    									ObjDal.insertItems(objInter);
    									txtItemId.setText(null);
    									txtItemName.setText(null);
    									txtItemQuentity.setText(null);
    									txtPrice.setText("0");
    								
    							
    								}
    								
    								});
    								JButton back=new JButton("Back");
    								back.setBounds(700,10,100,30);
    								purPanel.add(back);
    								bntnewItem.setBounds(440,450,130,50);
    								purPanel.add(bntnewItem);
    							    back.addActionListener(new ActionListener(){
    								public  void actionPerformed(ActionEvent e)
    								{
    									purframe.setVisible(false);
    									SwingUtilities.updateComponentTreeUI(p);
    									p.invalidate();
                                        p.validate();
                                        p.repaint();
                                        mainFrame.repaint(); 
                                      
                                        DefaultTableModel ItemModel = ObjDal.ItemInfo();
                                        
                                       final ArrayList<String> list1=new ArrayList<String>(ItemModel.getDataVector());
                                         for (int i=1; i<list1.size(); i++)
                                         {
                                             
                                         	 ArrayList<String> al2 = new ArrayList<String>(list1.subList(1, 2).subList(0,	1));
                                         	 Vector v=new Vector(al2);
                                         	for(int j=0; j< v.size(); j++){
                                         	//	System.out.println(v.get(0));
                                         	

                                               }
 
                                         }
                                       
                                        table.setAutoCreateRowSorter(true);
    									mainFrame.setVisible(true);
    									
    								}
    							});
    							
    							System.out.println("Pur");
    							purframe.setVisible(true);
    						}
    					});
    				
    						
    						sale.addActionListener(new ActionListener(){
    							public  void actionPerformed(ActionEvent e)
    							{
    							  final JFrame saleFrame=new JFrame("Sale");
    							 saleFrame.setBounds(200,10,800,700);
    							 JPanel salePanel=new JPanel();
    							 salePanel.setLayout(null);
    							 saleFrame.add(salePanel);
    							 
    							 
    							 JLabel Items=new JLabel("Bill Infor.");
    							Items.setFont(new Font("Serif", Font.BOLD, 50));
    							Items.setBounds(100,50,300,50);
    						    Items.setForeground(Color.BLUE);
    						    salePanel.add(Items);
    							 
    							 
    							 String columns[] = {"","","",""};
    				           	Object data[][] = {{"ItemName","Unit","UnitPrice","Totalprice"}};
    				     	   final  DefaultTableModel model = new DefaultTableModel(data, columns)
    				     	   {
    				     		public boolean isCellEditable(int row, int column) 
        		                {
             		                return false;
           	                    }
    				     	   };
    				     	   JLabel labdata=new JLabel("Date");
    				     	   labdata.setBounds(600,350,70,30);
    				     	   salePanel.add(labdata);
    				     	    final JTextField date=new JTextField();
    				     	   date.setBounds(600,400,100,30);
    				     	   salePanel.add(date);
    				     	   final JTable ItemTable=new JTable(model);
    				     	    ItemTable.setBounds(10,180,520,300);
    				     	    ItemTable.setFont(new Font("Serif", Font.BOLD, 14));
    				            ItemTable.setRowHeight(20);
    				     	    salePanel.add(ItemTable);
    				     	    JLabel labBillID=new JLabel("Bill ID");
    				     	    labBillID .setBounds(600,200,100,30);
    				     	    salePanel.add(labBillID);
    				     	    final JTextField txtBillId=new JTextField();
    				     	    txtBillId.setBounds(600,240,100,30);
    				     	    salePanel.add(txtBillId);
    				     	    JButton bntBillId=new JButton("Enter");
    				     	    bntBillId.setBounds(600,300,100,30);
    				     	    salePanel.add(bntBillId);
    				     	    bntBillId.addActionListener(new ActionListener(){
    				     	    	public  void actionPerformed(ActionEvent e)
    				     	    	{ 
    				     	    		ArrayList<Inter> list=new ArrayList<Inter>(); 
    				     	    		objInter.setBillId(txtBillId.getText());
    				     	    		list=ObjDal.saleItem(objInter);
    				     	    		for(Inter mod : list)
    				     	    		{
    				     	    			date.setText(mod.getDate());
    				     	    			model.addRow(new Object[] {  
                                             mod.getItemName(),
                                             mod.getQuentity(),
                                              mod.getUnitPrice(),
                                               mod.getTotalPrice()
                               	              
    
                                       });
    				     	    			
    				     	    			
    				     	    		}
    				     	    		
    				     	    	}
    				     	    	
    				     	    	});
    							 JButton back= new JButton("Back");
    							 back.setBounds(700,10,70,30);
    							 salePanel.add(back);
    							 	back.addActionListener(new ActionListener(){
    								public  void actionPerformed(ActionEvent e)
    								{
    									saleFrame.setVisible(false);
    									SwingUtilities.updateComponentTreeUI(p);
    									p.invalidate();
                                        p.validate();
                                        p.repaint();
                                        
    									mainFrame.setVisible(true);
    									
    								}
    							 	});
    							 
    							 saleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    							 mainFrame.setVisible(false);
    							 saleFrame.setVisible(true);
    							}
    							});
    						
    						
    						
    				    gb.addActionListener(new ActionListener(){
    				         	
    				     public  void actionPerformed(ActionEvent e)	
    				     {
    				     	mainFrame.setVisible(false);
    				        final JFrame frameGB=new JFrame("GB");
    				     	frameGB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    				     	frameGB.setBounds(150,30,900,700);
    				     	final  JPanel panelGB=new JPanel();
    				     	panelGB.setLayout(null);
    				     	frameGB.add(panelGB);
    				        JLabel labItem= new JLabel("<html>Generate Bill</html>");
    					    labItem.setFont(new Font("Serif", Font.BOLD, 50));
    					    labItem.setBounds(50,30,300,100);
    					    labItem.setBackground(Color.BLACK);
    					    labItem.setForeground(Color.BLUE);
    					    panelGB.add(labItem);
    				        final	Calendar cal = Calendar.getInstance();
    				     	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            final String  date= format.format(cal.getTime());
                            SimpleDateFormat format1 = new SimpleDateFormat("hh:mm:ss");
                            final  String time= format1.format(cal.getTime());
                            JLabel labTime=new JLabel("Logged In As : Admin on "+date+" at "+time);
                            labTime.setBounds(615,0,300,30);
                            panelGB.add(labTime);
    				     	JLabel labCusName=new JLabel("Bill ID");
    				     	JLabel labItems=new JLabel("Items");
    				     	JLabel labUnit=new JLabel("Price");
    				     	JLabel labNumber=new JLabel("Quantity");
    				     	JLabel labTotal=new JLabel("Amount");
    				     	JLabel labDiscount=new JLabel("Discount");
    				        
    				     	final  JTextField txtCusName=new JTextField(ObjDal.getBillID());
    				     	final  JComboBox txtItems=new JComboBox((ObjDal.ItemCombox().toArray()));
    				     	final  JTextField txtUnit=new JTextField();
    				     	final JTextField txtNumber=new JTextField();
    				     	final JTextField txtTotal=new JTextField();
    				     	txtTotal.setText("0");
    				     	txtTotal.setAlignmentX(JTextField.CENTER);
    				     	txtTotal.setAlignmentY(JTextField.CENTER);
    				     	
    				     	final JTextField txtDiscount=new JTextField();
    				     	txtDiscount.setText("0");
    				        labCusName.setBounds(550,180,120,30);
    				        labCusName.setFont(new Font("Serif", Font.BOLD, 20));
    				        txtCusName.setBounds(550,210,130,30);
    				        txtCusName.setFont(new Font("Serif", Font.BOLD, 11));
    				        panelGB.add(labCusName);
    				        panelGB.add(txtCusName);
    				        labItems.setBounds(700,180,120,30);
    				        labItems.setFont(new Font("Serif", Font.BOLD, 20));
    				        txtItems.setBounds(700,210,130,30);
    				        txtItems.setFont(new Font("Serif", Font.BOLD, 11));
    				        panelGB.add(labItems);
    				        panelGB.add(txtItems);
    				        labUnit.setBounds(550,250,120,30);
    				        labUnit.setFont(new Font("Serif", Font.BOLD, 20));
    				        txtUnit.setBounds(550,280,130,30);
    				        txtUnit.setFont(new Font("Serif", Font.BOLD, 11));
    				        panelGB.add(labUnit);
    				        panelGB.add(txtUnit);
    				        labNumber.setBounds(700,250,120,30);
    				        labNumber.setFont(new Font("Serif", Font.BOLD, 20));
    				        txtNumber.setBounds(700,280,130,30);
    				        txtNumber.setFont(new Font("Serif", Font.BOLD, 11));
    				        panelGB.add(labNumber);
    				        panelGB.add(txtNumber);
    				     	labTotal.setBounds(550,400,100,30);
    				     	labTotal.setFont(new Font("Serif", Font.BOLD, 20));
    				     	txtTotal.setBounds(550,430,130,30);
    				     	txtTotal.setFont(new Font("Serif", Font.BOLD, 11));
    				     	panelGB.add(labTotal);
    				     	panelGB.add(txtTotal);
    				     	labDiscount.setBounds(700,400,100,30);
    				     	labDiscount.setFont(new Font("Serif", Font.BOLD, 20));
    				     	txtDiscount.setBounds(700,430,130,30);
    				     	txtDiscount.setFont(new Font("Serif", Font.BOLD, 11));
    				     	panelGB.add(labDiscount);
    				     	panelGB.add(txtDiscount);
    				     	JButton bntAdd=new JButton("Add to Cart");
    				     	bntAdd.setBounds(550,340,130,50);
    				     	bntAdd.setFont(new Font("Serif", Font.BOLD, 16));
    				     	bntAdd.setBackground(Color.GRAY);
    				     	bntAdd.setForeground(Color.WHITE);
    				     	panelGB.add(bntAdd);
    				     	JButton bntdeleteSelectedRow=new JButton("DEL");
    				     	bntdeleteSelectedRow.setBounds(700,340,130,50);
    				     	bntdeleteSelectedRow.setFont(new Font("Serif", Font.BOLD, 16));
    				     	bntdeleteSelectedRow.setBackground(Color.GRAY);
    				     	bntdeleteSelectedRow.setForeground(Color.WHITE);
    				     	panelGB.add(bntdeleteSelectedRow);
    				     	JButton Print=new JButton("PRINT");
    				     	Print.setBounds(700,580,80,50);
    				     	panelGB.add(Print);
    				     	String columns[] = {"","","",""};
    				     	Object data[][] = {{"ItemName","Unit","UnitPrice","Totalprice"}};
    				     	final  DefaultTableModel model = new DefaultTableModel(data, columns)
    				     	{
    				     		public boolean isCellEditable(int row, int column) 
        		                {
             		                return false;
           	                    }
    				     	};
    				     	final JTable ItemTable=new JTable(model);
    				     	ItemTable.setBounds(10,180,520,300);
    				     	ItemTable.setFont(new Font("Serif", Font.BOLD, 14));
    				        ItemTable.setRowHeight(20);
    				     	panelGB.add(ItemTable);
    				     	bntAdd.addActionListener(new ActionListener(){
    				     	public  void actionPerformed(ActionEvent e)
    				     	{
    				     		int amount=Integer.parseInt(txtTotal.getText());
    				     		int unit=Integer.parseInt(txtUnit.getText());
    				     		int tot;
    				     		int number=Integer.parseInt(txtNumber.getText());
    				     	   //String nextRowId = Integer.toString(model.getRowCount());
                               model.addRow(new Object[] {  
                               txtItems.getItemAt(txtItems.getSelectedIndex()),
                               txtNumber.getText(),
                               txtUnit.getText(),
                               tot = unit*number
                               	
                               	
                                       });
    				     	    	amount=amount+tot;
                                  String str = Integer.toString(amount);
                               	  txtTotal.setText(str);
                                  txtNumber.setText("");
                                  txtUnit.setText("");     
    				     	
    				     	}
    				     		
    				     	});
    				     	
    				     	bntdeleteSelectedRow.addActionListener(new ActionListener(){
    				     		public  void actionPerformed(ActionEvent e)
    				     		{
    				     			if (ItemTable.getSelectedRow() > 0) {
                                      int selectedRow=ItemTable.getSelectedRow();
                                     String n=(model.getValueAt(selectedRow,3).toString());
                                     int am=Integer.parseInt(n);
                                     n=txtTotal.getText();
                                     int to=Integer.parseInt(n);
                                     to=to-am;
                                     n=Integer.toString(to);
                                     txtTotal.setText(n);
                                    model.removeRow(ItemTable.getSelectedRow());
    				     	
    				     			}
    				     		}
    				     		
    				     		
    				     		
    				     		});
    				     		
    				     		Print.addActionListener(new ActionListener(){
    				     			
    				     			public void actionPerformed(ActionEvent e)
    				     			{
    				     				
    				     		     	
    				     				ArrayList<Inter> al=new ArrayList<Inter>(); 
    				     		        
    				     		         for(int count=1; count<=model.getRowCount()-1; count++)
    				     		        	{
    				     		                Inter obj1=new Inter();
    				     		        		obj1.setItemName(model.getValueAt(count,0).toString());
    				     		        		obj1.setQuentity(model.getValueAt(count,1).toString());
    				     		        		obj1.setUnitPrice(model.getValueAt(count,2).toString());
    				     		        		obj1.setTotalPrice(model.getValueAt(count,3).toString());
    				     		        		obj1.setDate(date.toString());
    				     		        		obj1.setBillId(txtCusName.getText());
    				     		        		
    				     		        		al.add(obj1);
    				     			    	   
    				     		        	}
    				     		        	ObjDal.UpdateItems(al);
    				     		        	model.setRowCount(1);
    				     		        	txtTotal.setText("0");
    				     		        	txtDiscount.setText("0");
    				     		        	txtCusName.setText(ObjDal.getBillID());
    				     		        	frameGB.setVisible(false);
    				     		        	mainFrame.setVisible(true);
    				     		        	
    				     		            
    				     		        	
    				     		        
    				     			
    				     			}
    				     		});
    				     			
    				     		
    				     	frameGB.setVisible(true);
    				     	
    				     	
    				     }   		
    				      });
    				         
    			} 
    			
    			else 
    			{
    				JOptionPane.showMessageDialog(null,"Sorry");
    			}
    		}
    		});
    		
    	fr.setVisible(true);
    }
}
