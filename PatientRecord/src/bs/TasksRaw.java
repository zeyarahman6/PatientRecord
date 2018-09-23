package bs;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Robot;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.border.SoftBevelBorder;



























public class TasksRaw
  extends JFrame
{
  private JPanel contentPane;
  private JTextField P;
  private JFormattedTextField D;
  private JTextField A;
  private JTable table;
  Robot robot = null;
  Connection con = null; Connection com = null;
  String cid = null;
  String zid = null;
  JDateChooser dateChooser;
  private JTextField record_no;
  private JTextField p_phone;
  private JTextField TA;
  private JTextField TI;
  private int ti = 0;
  private double ta = 0.0D;
  int count = 1;
  private JTable table_1;
  private JTextField date;
  JButton btnNewButton_2;
  private JTextField time;
  double disc = 0.0D;
  private JTextField textField_2;
  private JTextField textField_3;
  private JTextField timepmam;
  JTextPane textPane;
  int sno = 0;
  public String tempdate;
  public String temptime;
  private JTable table_3;
  private JTextField textField_13;
  private JTable table_4;
  private JTextField p_name;
  private JLabel lblCustomer;
  
  private JTable table_2;
  private JComboBox comboBox;
  private JTextField p_sex;
  private JTextField p_add;
  private JTextField p_age;
  private JTextField text_price;
  private JTextField textField_4;
  private JTextField textField_5;
  private JPasswordField passwordField_delete;
  private JLabel lblNewLabel_2;
  private JTextField text_name;
  int p_flag=0;
  private JTable table_5;
  private JPasswordField textField_4_pass;
  private JLabel lblEnterPassword;
  private JPasswordField passwordField;
  private JLabel lblNewLabel_3;
  private JTable table_6;
  private JTextField t_services;
  private JTextField t_amount;
  private JTextField textField;
  private JLabel lblInvoiceNo;
  private JLabel lblCustomerName;
  private JLabel lblPatientSex;
  private JLabel lblPatientAddress;
  private JLabel lblPatientage;
  private JLabel lblProductdate;
  private JLabel lblTime;
  private JTextField p_r_no;
    
  protected void combobox_items()
  {
    LoginPage c = new LoginPage();
    
    com = c.dbcon();
    

    comboBox.removeAllItems();
    try {
      String sql = "select DISTINCT service_name from p_items order by service_name asc";
      PreparedStatement pst = com.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      
      while (rs.next())
      {

        String id = rs.getString("service_name");
        comboBox.addItem(id);
       
      }
      pst.close();
      rs.close();
      AutoCompleteDecorator.decorate(comboBox);
    }
    catch (SQLException e1)
    {
      e1.printStackTrace();
      JOptionPane.showMessageDialog(null, e1);
    }
  }

  protected static double fromCMTToPPI(double cm)
  {
 	 return toPPI(cm * 0.393700787);
 	 
  }
  protected static double toPPI(double inch)
  {
 	 
 	 return inch * 72d;
  }
   

  public void printinvoice(String ino)
  {
    company(ino);
    product(ino);
    Paper paper=new Paper();
    paper.setSize(fromCMTToPPI(21.0),fromCMTToPPI(29.7));
    paper.setImageableArea(fromCMTToPPI(2.0), fromCMTToPPI(0.01), fromCMTToPPI(21.0), fromCMTToPPI(29.7));
     
    PageFormat pageFormat=new PageFormat();
    
    pageFormat.setPaper(paper);
    PrinterJob pj= PrinterJob.getPrinterJob();
    
    pj.setPrintable(textPane.getPrintable(null, null), pageFormat);
    
    PageFormat pf= pj.pageDialog(pageFormat);
    if(pj.printDialog())
    {
    	try {
    		pj.print();
    	} catch (PrinterException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

  }
  
  public void printpress(String ino)
  {
    press(ino);
    
    Paper paper=new Paper();
    paper.setSize(fromCMTToPPI(21.0),fromCMTToPPI(29.7));
    paper.setImageableArea(fromCMTToPPI(2.0), fromCMTToPPI(0.1), fromCMTToPPI(21.0)-fromCMTToPPI(0.5), fromCMTToPPI(29.7)-fromCMTToPPI(0.1));
    
    PageFormat pageFormat=new PageFormat();
    
    pageFormat.setPaper(paper);
    PrinterJob pj= PrinterJob.getPrinterJob();
    pj.setPrintable(textPane.getPrintable(null, null), pageFormat);
    
    PageFormat pf= pj.pageDialog(pageFormat);
    if(pj.printDialog())
    {
    	try {
    		pj.print();
    	} catch (PrinterException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

  }

  
  public void press(String ino)
  {
	  String sex = null;
	  String name=null,age=null,address=null;
	  try {
	    String sql = "select  cust_name,age,address,sex from p_customers where invoice_no='" + ino + "'";
	    
	    PreparedStatement pst = com.prepareStatement(sql);
	    ResultSet rs = pst.executeQuery();
	    
	    while (rs.next())
	    {
	      name=rs.getString("cust_name");
	      age=rs.getString("age");
	      address=rs.getString("address");
	      sex=rs.getString("sex");
	     
	    }  
	    String sql1 = "select to_char(date,'DD-MM-YYYY') from p_customers where invoice_no='" + ino + "'";
	    
	    PreparedStatement pst1 = com.prepareStatement(sql1);
	    ResultSet rs1 = pst1.executeQuery();
	   JTable table_7 = new JTable();
	    table_7.setBounds(595, 176, 17, 10);
	  
	    table_7.setModel(DbUtils.resultSetToTableModel(rs1));
        
	    String sid = table_7.getModel().getValueAt(0, 0).toString();
	    
	   
	    pst1.close();
	    rs1.close();
	  
	   
	    pst.close();
	    rs.close();
	    
	    Document doc = textPane.getDocument();
	    
	    
	       
	   for(int i=0;i<14;i++)
	   {
	      doc.insertString(doc.getLength(), "\n",null);
	   }
	      
	   doc.insertString(doc.getLength(), "\t"+name,null);
	   
	   int n = name.length();
       
       if ((n < 4))
       {
         
         
           
         
           doc.insertString(doc.getLength(), "\t\t\t      " + age + "\t" + sex + "\n", null);
           
       
       }

         



       else  if (n > 15)
       {
        
           
             doc.insertString(doc.getLength(), "\t      " + age + "\t" + sex + "\n", null);
       
       }


       else   if ((n > 4) && (n < 16))
       {
         
         
       	     doc.insertString(doc.getLength(), "\t\t      "  + age + "\t" + sex + "\n", null);
           
       }
       else  if ((n == 4) )
         {
            
         	   doc.insertString(doc.getLength(), "\t\t      "  + age + "\t" + sex + "\n", null);
             
           }
           
           
           
           
           
           
      


      
       }
       
	    
	  	 
	  catch (Exception e1)
	  {

	    e1.printStackTrace();
	    JOptionPane.showMessageDialog(null, e1);
	  }
	  
  
	  
  }

  
  
  public void product(String ino)
  {
	  
	  
	  SimpleAttributeSet sas = new SimpleAttributeSet();
	    StyleConstants.setBold(sas, true);
	    
	  
	    String tempta = null;
	    String cname=null,phone=null,address=null;
	    try {
	      String sql = "select  cust_name,cust_phone,address,grand_total from p_customers where invoice_no='" + ino + "'";
	      
	      PreparedStatement pst = com.prepareStatement(sql);
	      ResultSet rs = pst.executeQuery();
	      
	      while (rs.next())
	      {
	        cname=rs.getString("cust_name");
	        phone=rs.getString("cust_phone");
	        address=rs.getString("address");
	        
	        
	        tempta =rs.getString("grand_total");
	      }  
	      
	     
	      pst.close();
	      rs.close();
	         
  	   

  }
  catch (Exception e1)
  {

    e1.printStackTrace();
    JOptionPane.showMessageDialog(null, e1);
  }
  

  
  StyledDocument doc2 = (StyledDocument)textPane.getDocument();
  MutableAttributeSet style2 = doc2.addStyle("Courier New", null);
  StyleConstants.setFontSize(style2, 10);
  
  Document doc = textPane.getDocument();

  try {
  	
  	int len;
      int rlen;
      rlen=cname.length();
     
 
    doc.insertString(doc.getLength(), "Patient:",null);
    doc.insertString( len=doc.getLength(), cname,null);
    textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
    
    doc.insertString(doc.getLength(),"\nPhone:" + phone + "\n", null);
    doc.insertString(doc.getLength(), "Address:"+address+"\n", null);
    doc.insertString(doc.getLength(), "__________________________________________________________________________\n", null);

    //  String str="S.No  Service_Name\t\t\tS_Price\tS_Disc(\u20B9)\tS_Amt\n";
      String str="S.No  Service_Name\t\t\tS_Price\tS_Disc(\u20B9)\tS_Amt\n";
      
      rlen=str.length();
      doc.insertString(len=doc.getLength(), str, null);
      textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
      
      doc.insertString(doc.getLength(), "__________________________________________________________________________\n", null);
    }
    catch (BadLocationException e) {
      e.printStackTrace(); JOptionPane.showMessageDialog(null, e);
    }
    




    try
    {
      String sql = "select  s_name, s_price ,qty ,disc ,amt  from p_INVOICETABLE where I_no='" + ino + "'";
      PreparedStatement pst = com.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      

    int totalItems=0;
      while (rs.next())
      {



        String name = rs.getString("s_NAME");
        String price = rs.getString("s_PRICE");
        
        String disc = rs.getString("DISC");
        String amt = rs.getString("AMT");
      
       
        
        int n = name.length();
        
        if ((n <= 4) && (sno < 9))
        {
          sno += 1;
          
          try
          {
        	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
              int len=doc.getLength();
              int rlen=name.length();
              doc.insertString(doc.getLength(),name, null);
              
              textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
              doc.insertString(doc.getLength(), "\t\t\t\t " + price + "\t" + disc + "\t" + amt + "\n\n", null);
           //   doc.insertString(doc.getLength(), "         S No-" + serial+"\n", style2);
              
          }
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        }
        


        else if ((n < 4) && (sno > 9))
        {
          sno += 1;
          try
          {
        	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
              int len=doc.getLength();
              int rlen=name.length();
              doc.insertString(doc.getLength(),name, null);
              textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
              doc.insertString(doc.getLength(), "\t\t\t\t " + price + "\t" + disc + "\t" + amt + "\n\n", null);
             // doc.insertString(doc.getLength(), "         S No-" + serial+"\n", style2);
              
          }
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        }
        



        else if (n > 15)
        {
          sno += 1;
          
          try
          {
        	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
              int len=doc.getLength();
              int rlen=name.length();
              doc.insertString(doc.getLength(),name, null);
              textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
              doc.insertString(doc.getLength(), "\t\t " + price + "\t" + disc + "\t" + amt + "\n\n", null);
            //  doc.insertString(doc.getLength(), "         S No-" + serial+"\n", style2);
              
          }
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        }
        



        else if ((n > 4) && (n < 16))
        {
          sno += 1;
          
          try
          {
        	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
              int len=doc.getLength();
              int rlen=name.length();
              doc.insertString(doc.getLength(),name, null);
              textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
              doc.insertString(doc.getLength(), "\t\t\t " + price + "\t" + disc + "\t" + amt + "\n\n", null);
            //  doc.insertString(doc.getLength(), "         S No-" + serial+"\n", style2);
              
          }
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        }
        




        else if ((n == 4) && (sno >= 9))
        {
          sno += 1;
          try
          {
        	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
              int len=doc.getLength();
              int rlen=name.length();
              doc.insertString(doc.getLength(),name, null);
              textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
              doc.insertString(doc.getLength(), "\t\t\t " + price + "\t" + disc + "\t" + amt + "\n\n", null);
            //  doc.insertString(doc.getLength(), "         S No-" + serial+"\n", style2);
              
          }
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        }
      }
      

      if(sno==1) {  try {
    		doc.insertString(doc.getLength(),"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", null);
    	

    	} catch (BadLocationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}    }

    	else if(sno==2) {  try {
    		doc.insertString(doc.getLength(),"\n\n\n\n\n\n\n\n\n\n\n\n\n\n", null);
    	} catch (BadLocationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}    }


    	else if(sno==3) {  try {
    		doc.insertString(doc.getLength(),"\n\n\n\n\n\n\n\n\n\n\n\n\n", null);
    	} catch (BadLocationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}    }

    	else if(sno==4) {  try {
    		doc.insertString(doc.getLength(),"\n\n\n\n\n\n\n\n\n\n\n\n", null);
    	} catch (BadLocationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}    }

    	else if(sno==5) {  try {
    		doc.insertString(doc.getLength(),"\n\n\n\n\n\n\n\n\n\n\n", null);
    	} catch (BadLocationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}    }

    	else if(sno==6) {  try {
    		doc.insertString(doc.getLength(),"\n\n\n\n\n\n\n\n\n\n", null);
    	} catch (BadLocationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}    }

    	else if(sno==7) {  try {
    		doc.insertString(doc.getLength(),"\n\n\n\n\n\n\n", null);
    	} catch (BadLocationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}    }

    	else if(sno==8) {  try {
    		doc.insertString(doc.getLength(),"\n\n\n\n\n", null);
    	} catch (BadLocationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}    }
    	else if(sno==9) {  try {
    		doc.insertString(doc.getLength(),"\n\n\n", null);
    	} catch (BadLocationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}    }



      pst.close();
      rs.close();
      try
      {  int len;
      int rlen;;
	  double roundoff=Double.parseDouble(tempta);
	         roundoff=Math.round(roundoff);
	         double roundoffvalue=roundoff-Double.parseDouble(tempta);
	         roundoffvalue=Math.round(roundoffvalue * 100.0D) / 100.0D;
   doc.insertString(doc.getLength(), "__________________________________________________________________________\n", null);
   doc.insertString(len=doc.getLength(), "Rounded Off: "+roundoffvalue,null);
   		doc.insertString(doc.getLength(),"\t\t\t       Total Amount=\u20B9", null);
   		   textPane.getStyledDocument().setCharacterAttributes(len, 18, sas, false);
   		     
   		rlen=tempta.length();
   doc.insertString(len=doc.getLength(),  roundoff + "\n", null);
   doc.insertString(doc.getLength(), "\t\t\t\t       Total Services=" + sno + "\n", null);
   textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
   doc.insertString(doc.getLength(), "Amount Chargeable(in words)\n", null);
        
       String inr=Rupees.convertToIndianCurrency(Double.toString(roundoff));
        rlen=inr.length();
       doc.insertString(len=doc.getLength(), inr+"\n", null);
       textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
       
        doc.insertString(doc.getLength(), "__________________________________________________________________________\n", null);
        StyledDocument doc1 = (StyledDocument)textPane.getDocument();
        MutableAttributeSet style = doc1.addStyle("Courier New", null);
        StyleConstants.setFontSize(style, 8);
       
        doc.insertString(doc.getLength(),"                                               ",null);
                                                    doc.insertString(len=doc.getLength(),"for SKIN,HAIR & NAIL CLINIC\n\n\n", null);

        textPane.getStyledDocument().setCharacterAttributes(len, 30, sas, false);
        
        if(sno==1) {  try {
        	doc.insertString(doc.getLength(),"\n\n\n", null);
        } catch (BadLocationException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }    }

          if(sno==2) {  try {
        	doc.insertString(doc.getLength(),"\n\n", null);
        } catch (BadLocationException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }    }

         if(sno==3 || sno==4) {  try {
        	doc.insertString(doc.getLength(),"\n", null);
        } catch (BadLocationException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }    }

        
        
        doc.insertString(doc.getLength(),"Declaration\nWe declare that this reciept shows the actual price of the service \ndescribed and that all particulars are true and correct.", style);
        
        
        
        doc.insertString(doc.getLength(),"\t\tAuthorised Signatory\n", null);
        doc.insertString(doc.getLength(), "__________________________________________________________________________\n", null);
        
    doc.insertString(len=doc.getLength(), "ELECTRO CAUTERY SURGERIES | RADIO FREQUENCY ABLATION | VITILIGO SURGERIES\n", null);
        doc.insertString(doc.getLength(), "ACNE SURGERIES | INTRALESIONAL THERAPIES | NAIL SURGERIES | TATOO REMOVAL\n",null);
        doc.insertString(doc.getLength(), "  CRYOTHERAPY | EAR PIERCING | DERMOSCOPE | HAIR CARE| CHEMICAL PEELS\n", null);
    
        textPane.getStyledDocument().setCharacterAttributes(len, doc.getLength()-len, sas, false);
        
        doc.insertString(doc.getLength(), "__________________________________________________________________________\n", null);
        doc.insertString(doc.getLength(), "                      SUBJECT TO HYDERABAD JURISDICTION\n",null);
        
        
        doc.insertString(doc.getLength(), "                         ",null);  
        doc.insertString(doc.getLength(),"This is a Computer Generated Reciept", style);

       
        sno = 0;
      }
      catch (Exception e) {
        e.printStackTrace(); JOptionPane.showMessageDialog(null, e);
      }
      
      return;
    }
    catch (Exception e1)
    {
      e1.printStackTrace();
      JOptionPane.showMessageDialog(null, e1);
    }
  }
  





  public void company(String ino)
  {
	   SimpleAttributeSet sas = new SimpleAttributeSet();
	    StyleConstants.setBold(sas, true);
	    
	    
	    //StyleConstants.setUnderline(und, true);
	    


	    StyledDocument doc1 = (StyledDocument)textPane.getDocument();
	    MutableAttributeSet style = doc1.addStyle("Courier New", null);
	    StyleConstants.setFontSize(style, 24);
	    MutableAttributeSet styli = doc1.addStyle("Courier New", null);
	    MutableAttributeSet zyl = doc1.addStyle("Courier New", null);
	    StyleConstants.setFontSize(styli, 16);
	    StyleConstants.setFontSize(zyl, 20);
	   
	   
	    SimpleAttributeSet und = new SimpleAttributeSet();
	    und.addAttribute(StyleConstants.CharacterConstants.Underline, Boolean.TRUE);
	    und.addAttributes(styli);
	  





	        try
	        {
	        	String sql = "select to_char(date,'DD-MM-YYYY') , time from p_customers where invoice_no='" + ino + "'";
	             
	            PreparedStatement pst = com.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();
	             table_4.setModel(DbUtils.resultSetToTableModel(rs));
	            tempdate = table_4.getModel().getValueAt(0, 0).toString();
	            temptime= table_4.getModel().getValueAt(0, 1).toString();
	            pst.close();
	            rs.close();
	           
	            

	            table_4.setModel(new DefaultTableModel(
	          	    	new Object[][] {
	          	    	},
	          	    	new String[] {
	          	    	}
	          	    ));
	         
	          
	          Document doc = textPane.getDocument();
	          int blen=0;
	          doc.insertString(doc.getLength(), "\t\t     ",null);
	          doc.insertString(blen=doc.getLength(),"INVOICE RECIEPT\n", styli);
	          textPane.getStyledDocument().setCharacterAttributes(blen, 15, sas, false);

	      //    doc.insertString(doc.getLength(), "\t  Composition Taxable Person, not eligible to Collect Tax on Supplies\n", zyl);
	          doc.insertString(doc.getLength(), "__________________________________________________________________________\n", null);
	                                             
	          doc.insertString(doc.getLength(), "DR. BABU'S\n", zyl);
	          doc.insertString(blen=doc.getLength(), "SKIN, HAIR & NAIL CLINIC", style);
	          textPane.getStyledDocument().setCharacterAttributes(blen, 24, sas, false);
	          doc.insertString(doc.getLength(), "\n" + "TOLICHOWKI:Above Axis Bank,Near Azaan Internation School,7 Tombs Road" ,null);//+"\t\t\t",null);
	          doc.insertString(doc.getLength(), "\nVIJAYANAGAR COLONY: Opposite To Andhra Bank\n",null);
	            
	          doc.insertString(blen=doc.getLength(),"Phone:" + "9640812934" +"\n\t\t\t\t\t",null);textPane.getStyledDocument().setCharacterAttributes(blen, 6, sas, false);
	          doc.insertString(blen=doc.getLength(),"INVOICE No:"+ino+"\n\t\t\t\t\t",null); textPane.getStyledDocument().setCharacterAttributes(blen, 11, sas, false); 
			    
	          doc.insertString(blen=doc.getLength(),"Date:"+tempdate+"\n\t\t\t\t\t",null);textPane.getStyledDocument().setCharacterAttributes(blen, 5, sas, false);
		      
	          doc.insertString(blen=doc.getLength(),	"Time:",null);textPane.getStyledDocument().setCharacterAttributes(blen, 5, sas, false);
	          doc.insertString(doc.getLength(),temptime + "\n", null);
	          doc.insertString(doc.getLength(), "__________________________________________________________________________\n\n", null);
       
      


    }
    catch (Exception e1)
    {

      e1.printStackTrace();
      JOptionPane.showMessageDialog(null, e1);
    }
  }
  
  public void run()
  {
    try
    {
      Tasks frame = new Tasks();
      frame.setVisible(true);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  

  protected void currentdate()
  {
    Thread Clock = new Thread()
    {

      public void run()
      {

        try
        {

          for (;;)
          {
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
            date.setText(s.format(d));
            


            SimpleDateFormat s1 = new SimpleDateFormat("HH:mm:ss ");
            SimpleDateFormat s2 = new SimpleDateFormat("hh:mm:ss a");
            time.setText(s1.format(d));
            timepmam.setText(s2.format(d));
            

            sleep(1000L);
          }
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
        
      }
      
    };
    Clock.start();
  }
  








   




   








  public TasksRaw()
  {
  	setIconImage(Toolkit.getDefaultToolkit().getImage(TasksRaw.class.getResource("/archive/invoice-icon.png")));
    setDefaultCloseOperation(0);
  
    LoginPage c = new LoginPage();
    
    con = c.sharedb();
    com=con;



    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    setBounds(100, 100, 1374, 710);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(0,139,139));
    
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JTabbedPane tabbedPane = new JTabbedPane(1);
    tabbedPane.setBounds(10, 0, 1338, 594);
    contentPane.add(tabbedPane);
    tabbedPane.setFont(new Font("Tahoma", 1, 12));
    



   // Image imgadd = new ImageIcon(getClass().getResource("/aala.png")).getImage();
    Image imgadd = new ImageIcon(getClass().getResource("/sicon.png")).getImage();
    


    Image imggg = new ImageIcon(getClass().getResource("/submit32.png")).getImage();
    

    Image i = new ImageIcon(getClass().getResource("/sicon.png")).getImage();
    

    Image i2 = new ImageIcon(getClass().getResource("/edit item.png")).getImage();
    







    JPanel panel = new JPanel();
    panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel.setBackground(new Color(0, 139, 139));
    tabbedPane.addTab("BILLING       ", null, panel, null);
    panel.setLayout(null);
    
    
    
   /* JPanel panel_5 = new JPanel();
    panel_5.setBackground(new Color(0,0,0,0));
    panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_5.setBounds(22, 21, 1124, 127);
    panel.add(panel_5);
  */
    
    JLabel labelBabu = new JLabel("Dr. BABU's");
    labelBabu.setHorizontalAlignment(SwingConstants.LEFT);
    labelBabu.setForeground(Color.WHITE);
    labelBabu.setFont(new Font("Segoe UI", Font.BOLD, 15));
    labelBabu.setBounds(355, 0, 109, 29);
    panel.add(labelBabu);
   



 JLabel labelskin = new JLabel("SKIN, HAIR & NAIL CLINIC");
 labelskin.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
 labelskin.setVerticalAlignment(SwingConstants.TOP);
 labelskin.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
 labelskin.setForeground(new Color(255, 255, 102));
 labelskin.setBounds(355, 13, 432, 37);
    panel.add(labelskin);
    
    JLabel labelpentry = new JLabel("PATIENT ENTRY PAGE");
    labelpentry.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
    labelpentry.setFont(new Font("Segoe UI", Font.BOLD, 15));
    labelpentry.setForeground(Color.WHITE);
    labelpentry.setBounds(630, 45, 158, 29);
    panel.add(labelpentry);
   
    
    JLabel lblProductprice_1 = new JLabel("Service_Price");
    lblProductprice_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblProductprice_1.setForeground(Color.WHITE);
    lblProductprice_1.setFont(new Font("Tahoma", 1, 14));
    lblProductprice_1.setBounds(476, 250, 109, 20);
    panel.add(lblProductprice_1);
    
    lblProductdate = new JLabel("Date");
    lblProductdate.setForeground(Color.WHITE);
    lblProductdate.setFont(new Font("Tahoma", 0, 15));
    lblProductdate.setBounds(991, 90, 36, 20);
    panel.add(lblProductdate);
    
    JLabel lblTotalAmount = new JLabel("Total ");
    lblTotalAmount.setForeground(Color.WHITE);
    lblTotalAmount.setFont(new Font("Tahoma", 1, 15));
    lblTotalAmount.setBounds(747, 255, 42, 20);
    panel.add(lblTotalAmount);
    
    JLabel lblDiscount = new JLabel("Disc");
    lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
    lblDiscount.setForeground(Color.WHITE);
    lblDiscount.setFont(new Font("Tahoma", 1, 15));
    lblDiscount.setBounds(614, 253, 62, 20);
    panel.add(lblDiscount);
    
    P = new JTextField();
    P.setBackground(new Color(255,255,102));
    P.setHorizontalAlignment(4);
    P.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        



                



        if (e.getKeyCode() == 10)
        {
          D.setEnabled(true);
          D.requestFocus();
        }
        
      }
    });
    P.setFont(new Font("Tahoma", 0, 18));
    P.setColumns(10);
    P.setBounds(476, 275, 121, 26);
    panel.add(P);
    
    DefaultFormatter format=new DefaultFormatter();
    D = new JFormattedTextField(format);
    D.setBackground(new Color(255, 255, 255));
    D.setHorizontalAlignment(4);
   
    D.setValue("0");
    D.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 38)
        {
        
        	
        	
        	
        	
        	
        	P.requestFocus();
        }
        
        if (e.getKeyCode() == 10)
        {
          
        	
        	
        	 double p = Double.parseDouble(P.getText());
           //  double q = Double.parseDouble(Q.getText());
             double d = Double.parseDouble(D.getText());
             
             double sum = (p - d);
             double newsum = Math.round(sum * 100.0D) / 100.0D;
             A.setText(Double.toString(newsum));
             

             A.setEnabled(true);
             A.requestFocus();

        }
        

        


        
      }
      

    });
    D.setFont(new Font("Tahoma", 0, 18));
    D.setColumns(10);
    D.setBounds(620, 275, 62, 26);
    panel.add(D);
    
    A = new JTextField();
   
    A.setHorizontalAlignment(4);
    A.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        

        
        









        if (e.getKeyCode() == 10)
        {
          try
          {
            String query = "insert into p_invoicetable (s_name,s_price,disc,amt , i_no,date) values (?,?,?,?,?,parsedatetime(?, 'dd-MM-yyyy'))";
            
            PreparedStatement pst = con.prepareStatement(query);
            
  String combname=(String)comboBox.getSelectedItem();


            pst.setString(1, combname);
            pst.setString(2, P.getText());
          //  pst.setString(3, Q.getText());
            pst.setString(3, D.getText());
            pst.setString(4, A.getText());
            pst.setString(5, record_no.getText());
            pst.setString(6, date.getText());
            
            




            pst.execute();
            
            pst.close();
            




            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.addRow(new String[] { combname, P.getText(), D.getText(), A.getText() });
            

            double d = Double.parseDouble(A.getText());
            ta = (Math.round((ta + d) * 100.0D) / 100.0D);
            
            ti += 1;
            TI.setText(Integer.toString(ti));
            TA.setText(Double.toString(ta));
            




            P.setText("");
          //  Q.setText("1");
            D.setText("0");
            A.setText("");
      
            
            

          }
          catch (Exception e1)
          {


        	  P.setText("");
             // Q.setText("1");
              D.setText("0");
              A.setText("");

              
            comboBox.requestFocus();
          }
        }
        








        

      }
      


    });
    A.setFont(new Font("Tahoma", 0, 18));
    A.setColumns(10);
    A.setBounds(698, 275, 91, 26);
    panel.add(A);
       
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(30, 304, 759, 193);
    panel.add(scrollPane);
    
    table = new JTable();

    table.setSelectionBackground(new Color(255,255,102));
    table.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent ej) {

      }
    });
    table.setFont(new Font("Tahoma", 0, 16));
    table.setModel(new DefaultTableModel(
      new Object[0][], 
      
      new String[] {
      "          S_Name", "          S_Price", "          Discount", "          Amount" })
      {





        Class[] columnTypes = {
          String.class, String.class, String.class, String.class, String.class};
        
        public Class getColumnClass(int columnIndex) {
          return columnTypes[columnIndex];
        }
      });
    table.getColumnModel().getColumn(0).setPreferredWidth(87);
    table.getColumnModel().getColumn(0).setMinWidth(20);
    table.getColumnModel().getColumn(1).setPreferredWidth(109);
    table.getColumnModel().getColumn(1).setMinWidth(20);
    table.getColumnModel().getColumn(2).setPreferredWidth(86);
    table.getColumnModel().getColumn(2).setMinWidth(20);
    table.getColumnModel().getColumn(3).setPreferredWidth(93);
    table.getColumnModel().getColumn(3).setMinWidth(20);
    
   
    scrollPane.setViewportView(table);
    

   comboBox = new JComboBox();
    comboBox.setFont(new Font("Tahoma", 0, 17));

    comboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent e) {
        int keyChar = e.getKeyChar();
        if (keyChar == 10)
        {
        	
        	String sql="Select service_price from p_items where service_name='"+(String)comboBox.getSelectedItem()+"'";
        	   try {
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					P.setText(rs.getString("service_price"));
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	   
               
        	
          D.requestFocus();
         



        }
        


      }
      



    });
   // JTextComponent editor = (JTextComponent)comboBox.getEditor().getEditorComponent();

    comboBox.setBounds(30, 276, 408, 26);
    panel.add(comboBox);

    JLabel lblCategoryname = new JLabel("Service_Name");
    lblCategoryname.setHorizontalAlignment(SwingConstants.CENTER);
    lblCategoryname.setForeground(Color.WHITE);
    lblCategoryname.setFont(new Font("Tahoma", 1, 15));
    lblCategoryname.setBounds(191, 250, 132, 20);
    panel.add(lblCategoryname);
    
    
     
    
    btnNewButton_2 = new JButton("");
    btnNewButton_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE));
    btnNewButton_2.setVisible(false);
    btnNewButton_2.setBackground(new Color(0,139,139));
    //btnNewButton_2.setFont(new Font("Dialog", 1, 15));
    btnNewButton_2.setIcon(new ImageIcon(imggg));
    btnNewButton_2.setBounds(330, 91, 50, 35);
    panel.add(btnNewButton_2);
    
    lblCustomerName = new JLabel("Patient Phone");
    lblCustomerName.setForeground(Color.WHITE);
    lblCustomerName.setFont(new Font("Tahoma", 0, 15));
    lblCustomerName.setBounds(30, 115, 121, 20);
    panel.add(lblCustomerName);
    
    lblInvoiceNo = new JLabel("Record no.");
    lblInvoiceNo.setForeground(Color.WHITE);
    lblInvoiceNo.setFont(new Font("Tahoma", 0, 15));
    lblInvoiceNo.setBounds(30, 91, 121, 20);
    panel.add(lblInvoiceNo);
    
    record_no = new JTextField();
    record_no.setBackground(new Color(255,255,102));
    record_no.setFont(new Font("Tahoma", 0, 17));
    record_no.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent e)
      {

        if (e.getKeyCode() == 10)
        {

          if (record_no.getText().length() != 0)
          {
            try
            {
              String query = "INSERT INTO p_customers (invoice_no,date, time) VALUES (?,parsedatetime(?, 'dd-MM-yyyy'),parsedatetime(?, 'HH:mm'))";
              
              PreparedStatement pst = con.prepareStatement(query);
              



              pst.setString(1, record_no.getText());
              pst.setString(2, date.getText());
              pst.setString(3, time.getText());
              


              pst.execute();
              
              pst.close();
              
            btnNewButton_2.setVisible(true);
             
              p_phone.requestFocus();
            }
            catch (Exception e1)
            { JOptionPane.showMessageDialog(null, e1);
            
              JOptionPane.showMessageDialog(null, "Record no.='" + record_no.getText() + "' Already Exist");
              record_no.setText("");

            }
            


          }
          else
          {

            try
            {

              String query = "INSERT INTO p_customers (date, time) VALUES (parsedatetime(?, 'dd-MM-yyyy'),parsedatetime(?, 'HH:mm:ss'))";
              
              PreparedStatement pst = con.prepareStatement(query);
              




              pst.setString(1, date.getText());
              pst.setString(2, time.getText());
              


              pst.execute();
              
              pst.close();
              
              btnNewButton_2.setVisible(true);
             
              p_phone.requestFocus();
            }
            catch (Exception e1)
            { e1.printStackTrace();
              JOptionPane.showMessageDialog(null, e1);
              record_no.setText("");
            }
            
            try
            {
              String sql = "select top 1 invoice_no  from p_customers order by date desc, time desc";
              
              PreparedStatement pst = com.prepareStatement(sql);
              ResultSet rs = pst.executeQuery();
              
              while (rs.next())
              {
                record_no.setText(rs.getString("invoice_no"));
              }
              pst.close();
              rs.close();

            }
            catch (Exception e1)
            {

              e1.printStackTrace();
              JOptionPane.showMessageDialog(null, e1);


            }
            


          }
          


        }
        

      }
      


    });
    record_no.setBounds(151, 91, 139, 20);
    panel.add(record_no);
    record_no.setColumns(10);
    
    p_phone = new JTextField();
    p_phone.setFont(new Font("Tahoma", 0, 17));
    
    p_phone.setBackground(new Color(255,204,204));
    

    p_phone.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
                
        




        






        if (e.getKeyCode() == 10)
        {
            
     String check=p_phone.getText();
     String flag=p_r_no.getText();
        /*  char[] ch=new char[15];
          ch=check.toCharArray(); Character.isLetterOrDigit(ch[0])*/
     Boolean z;
     
        	  if(z=check.equals(flag))
        	  {
        		 
        		//  JOptionPane.showMessageDialog(null,z);
        		  //JOptionPane.showMessageDialog(null,"empty entry");
    	              p_name.requestFocus();
       
        	  }
        	  else {       
        		  try {
      				
    				  
      				/*     String[] nam=new String[10];
      				      int i=0; */
      					  String query = "select name from   patient_list where phone='"+p_phone.getText()+"'";
      					  PreparedStatement pst = con.prepareStatement(query);
      					  PreparedStatement pst1 = con.prepareStatement(query);
      						 
      					  ResultSet rst = pst.executeQuery();
      					  ResultSet rs=pst1.executeQuery();
      					  if(rst.next())
      					  {
      				/*	  while (rs.next()) { 
      						  
      						  nam[i]=rs.getString("name");
                                i++;
      						  
      					  }
      					  JOptionPane x=new JOptionPane();
      			    		JList jl;
      			    		x.setMessage(jl=new JList(nam));
      			    	
      			    		
      			    		x.setMessageType(JOptionPane.INFORMATION_MESSAGE);
      			    		JDialog dl=x.createDialog(null, "Patient Names with this contact!");
      			    		dl.setVisible(true); 
      			    	
      			    		 String myString =   (String) jl.getSelectedValue();
      			    	*/	
      			    		  String sqlfinal = "select * from   patient_list where phone='"+p_phone.getText()+"' ";//and name='"+myString+"'";
      			    		  PreparedStatement psfinal = con.prepareStatement(sqlfinal);
      						  ResultSet rsfinal = psfinal.executeQuery();
      						  while(rsfinal.next())
      						  { // p_r_no.setText(rsfinal.getString("r_no"));
      				    	  p_name.setText(rsfinal.getString("name"));

      				    	  p_sex.setText(rsfinal.getString("sex"));

      				    	  p_add.setText(rsfinal.getString("add"));}
      				      
      				      psfinal.close();
      				      rsfinal.close();
      				      p_age.requestFocus(); 
      				      p_flag++;

      					  }
      					  else {
      						  
      												     
      						  p_name.requestFocus();
      						//  p_r_no.requestFocus();
      						  
      					  }
      					  
      				  

      			} catch (SQLException e1) {
      				// TODO Auto-generated catch block
      				JOptionPane.showMessageDialog(null, e1);
      			}

        	       }
        } 
        
      }
      

    });
    p_phone.setColumns(10);
    p_phone.setBounds(151, 115, 139, 20);
    panel.add(p_phone);
    
    p_name = new JTextField();
    p_name.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		if(arg0.getKeyCode()==10)
    			
    		{
                      p_sex.requestFocus();      
    			
    		}
    	}
    });
    p_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
    p_name.setColumns(10);
    p_name.setBounds(151, 139, 139, 20);
    panel.add(p_name);
    
    lblCustomer = new JLabel("Patient_Name");
    lblCustomer.setForeground(Color.WHITE);
    lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblCustomer.setBounds(30, 139, 121, 20);
    panel.add(lblCustomer);
    lblPatientSex = new JLabel("Patient Sex");
    lblPatientSex.setForeground(Color.WHITE);
    lblPatientSex.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblPatientSex.setBounds(529, 90, 121, 20);
    panel.add(lblPatientSex);
    
    p_sex = new JTextField();
    p_sex.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		
    		
    		if(arg0.getKeyCode()==10)
    		{
    			p_add.requestFocus();
    			
    		}
    		
    	}
    });
    p_sex.setFont(new Font("Tahoma", Font.PLAIN, 17));
    p_sex.setColumns(10);
    p_sex.setBounds(650, 90, 139, 20);
    panel.add(p_sex);
    
    lblPatientAddress = new JLabel("Patient Address");
    lblPatientAddress.setForeground(Color.WHITE);
    lblPatientAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblPatientAddress.setBounds(529, 115, 121, 20);
    panel.add(lblPatientAddress);
    
    p_add = new JTextField();
    p_add.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		
    		if(arg0.getKeyCode()==10)
    		{
    			p_age.requestFocus();
    			
    		}
    		
    		
    		
    	}
    });
    p_add.setFont(new Font("Tahoma", Font.PLAIN, 17));
    p_add.setColumns(10);
    p_add.setBounds(650, 115, 139, 20);
    panel.add(p_add);
    
    lblPatientage = new JLabel("Patient_Age");
    lblPatientage.setForeground(Color.WHITE);
    lblPatientage.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblPatientage.setBounds(529, 139, 121, 20);
    panel.add(lblPatientage);
    
    p_age = new JTextField();
    p_age.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		if(arg0.getKeyCode()==10)
    		{
    			

try {

                  String query = "update p_customers set cust_name = ?  , cust_phone= ? , address=? , age=? , sex=?   where invoice_no= '"+record_no.getText()+"' ";

                  PreparedStatement pst = con.prepareStatement(query);
                  
                  pst.setString(1, p_name.getText().toUpperCase());
                  pst.setString(2, p_phone.getText());
                  pst.setString(3, p_add.getText());

                  pst.setString(4, p_age.getText());
                  pst.setString(5, p_sex.getText());
               //   pst.setString(6, p_r_no.getText());
                  pst.execute();

                  if(p_flag==0)
                  {
                  query = "insert into patient_list  (name , phone, add, age, sex)values( ?,?,?,?,?) ";
                  pst = con.prepareStatement(query);
                  pst.setString(1, p_name.getText().toUpperCase());
                  pst.setString(2, p_phone.getText());
                  pst.setString(3, p_add.getText());

                  pst.setString(4, p_age.getText());
                  pst.setString(5, p_sex.getText());
                 // pst.setString(6, p_r_no.getText());

                  
                  }
                  if(p_flag==1)
                  {
                  query = "update patient_list set age=? where name=? and phone=? and add=? and sex=? ";
                  pst = con.prepareStatement(query);

                  pst.setString(1, p_age.getText());
                  pst.setString(2, p_name.getText());
                  pst.setString(3, p_phone.getText());
                  pst.setString(4, p_add.getText());

                  pst.setString(5, p_sex.getText());
                 // pst.setString(6, p_r_no.getText());

                  
                  }

                  
                  
                  
                  
                  pst.execute();
                  pst.close();

    			
    			
    			
    			
    			
    			comboBox.requestFocus();
}
catch (Exception e1) { JOptionPane.showMessageDialog(null, e1);}
    			
    		}
    		
    		
    	}
    });
    p_age.setFont(new Font("Tahoma", Font.PLAIN, 17));
    p_age.setColumns(10);
    p_age.setBounds(650, 139, 139, 20);
    panel.add(p_age);
   






    JLabel lblTotalAmount_1 = new JLabel("Total Amount");
    lblTotalAmount_1.setForeground(Color.WHITE);
    lblTotalAmount_1.setFont(new Font("Tahoma", 0, 15));
    lblTotalAmount_1.setBounds(879, 486, 91, 19);
    panel.add(lblTotalAmount_1);
    
    TA = new JTextField();
    TA.setBackground(new Color(255,204,204));
    TA.setFont(new Font("Tahoma", 0, 17));
    TA.setColumns(10);
    TA.setBounds(980, 487, 139, 20);
    panel.add(TA);
    
    JLabel lblTotalItems = new JLabel("Total Service");
    lblTotalItems.setForeground(Color.WHITE);
    lblTotalItems.setFont(new Font("Tahoma", 0, 15));
    lblTotalItems.setBounds(879, 516, 91, 20);
    panel.add(lblTotalItems);
    
    TI = new JTextField();
    TI.setFont(new Font("Tahoma", 0, 17));
    TI.setBackground(new Color(255,204,204));
    TI.setColumns(10);
    TI.setBounds(980, 518, 139, 20);
    panel.add(TI);
    





    date = new JTextField();
    date.setEditable(false);
    date.setBackground(Color.WHITE);
    date.setDisabledTextColor(Color.BLACK);
    date.setFont(new Font("Tahoma", 0, 14));
    date.setBounds(1028, 90, 91, 20);
    panel.add(date);
    date.setColumns(10);
    
    time = new JTextField();
    time.setEditable(false);
      time.setBackground(Color.WHITE);
    time.setDisabledTextColor(Color.BLACK);
    
    time.setFont(new Font("Tahoma", 0, 14));
    time.setColumns(10);
    time.setBounds(1028, 115, 91, 20);
    panel.add(time);
    


    lblTime = new JLabel("Time");
    lblTime.setForeground(Color.WHITE);
    lblTime.setFont(new Font("Tahoma", 0, 15));
    lblTime.setBounds(991, 114, 36, 20);
    panel.add(lblTime);
    
    timepmam = new JTextField();
    timepmam.setEditable(false);
    timepmam.setBackground(Color.WHITE);
    timepmam.setFont(new Font("Tahoma", 0, 14));
    timepmam.setColumns(10);
    timepmam.setBounds(1028, 139, 91, 20);
    panel.add(timepmam);
    
    
    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_1.setBounds(30, 156, 151, 117);
    panel.add(lblNewLabel_1);
    lblNewLabel_1.setIcon(new ImageIcon(imgadd));
    
   
   
    
    
    
    
    JPanel panel_1 = new JPanel();
    panel_1.setBorder(new EtchedBorder(0, null, null));
    panel_1.setBackground(new Color(0,139,139));
    tabbedPane.addTab("ADD & DELETE SERVICE  ", null, panel_1, null);
    panel_1.setLayout(null);
    
    text_price = new JTextField();
    text_price.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		
    		if(arg0.getKeyCode()==10)
    		{
    		try
            {
              String query = "INSERT INTO p_items (service_NAME, service_price) VALUES (?,?)";
              
              PreparedStatement pst = con.prepareStatement(query);
              

              String uppercase = text_name.getText().toUpperCase();

              
              pst.setString(1, uppercase);
              pst.setString(2, text_price.getText());
              


              pst.execute();
              
              pst.close();
             combobox_items();
             
            }
            catch (SQLException e1) {
              e1.printStackTrace();
              JOptionPane.showMessageDialog(null, e1);
            }
            
            try
            {
              String sql = "select * from p_items ORDER BY service_name ASC;";
              
              PreparedStatement pst = com.prepareStatement(sql);
              ResultSet rs = pst.executeQuery();
             table_2.setModel(DbUtils.resultSetToTableModel(rs));
              
              pst.close();
              rs.close();

            }
            catch (SQLException e1)
            {

              e1.printStackTrace();
              JOptionPane.showMessageDialog(null, e1);
            }
            
            text_name.setText("");

            text_price.setText("");
            text_name.requestFocus();
    		
    		
    		}
    		
    	}
    });
    text_price.setColumns(10);
    text_price.setBounds(165, 241, 214, 20);

    text_price.setBackground(new Color(255,255,102));
    panel_1.add(text_price);
    
    JLabel lblServiceprice = new JLabel("Service_Price");
    lblServiceprice.setForeground(Color.WHITE);
    lblServiceprice.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblServiceprice.setBounds(35, 239, 120, 20);
    panel_1.add(lblServiceprice);

    
    
    JLabel lblProductname = new JLabel("Service_Name");
    lblProductname.setForeground(Color.WHITE);
    lblProductname.setFont(new Font("Tahoma", 1, 16));
    lblProductname.setBounds(35, 195, 120, 20);
    panel_1.add(lblProductname);
    
    text_name = new JTextField();
    text_name.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {
         text_price.requestFocus();     
        
        }
      }
    });
    text_name.setColumns(10);
    text_name.setBounds(165, 197, 214, 20);
    panel_1.add(text_name);
    

    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    lblNewLabel.setIcon(new ImageIcon(i));
    lblNewLabel.setBounds(255, 70, 138, 116);
    panel_1.add(lblNewLabel);
    




    JLabel lblDelete = new JLabel("");
    lblDelete.setIcon(new ImageIcon(i2));
    lblDelete.setBounds(1101, 70, 59, 83);
    panel_1.add(lblDelete);
    JLabel lblServicename_1 = new JLabel("Service_Name");
    lblServicename_1.setForeground(Color.WHITE);
    lblServicename_1.setFont(new Font("Tahoma", 1, 16));
    lblServicename_1.setBounds(819, 195, 127, 20);
    panel_1.add(lblServicename_1);
    
    textField_4 = new JTextField();
    textField_4.setEditable(false);
    textField_4.setColumns(10);
    textField_4.setBounds(946, 195, 214, 20);
    panel_1.add(textField_4);
    
    textField_5 = new JTextField();
    textField_5.setColumns(10);
    textField_5.setBackground(new Color(255, 255, 102));
    textField_5.setBounds(946, 239, 214, 20);
    panel_1.add(textField_5);
    
    JLabel lblServicename = new JLabel("Service_Price");
    lblServicename.setForeground(Color.WHITE);
    lblServicename.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblServicename.setBounds(819, 239, 127, 20);
    panel_1.add(lblServicename);
    
    JButton btnUpdate = new JButton("Update");
    btnUpdate.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
    		
    		try
            {
              String query = "update p_items set  service_price=? where service_name='"+textField_4.getText()+"'";
            //  String query = "update items set item_NAME=?,rate='"+textField_31.getText()+"'  where hsn='"+textField_29.getText()+"' ";
              
              
              PreparedStatement pst = con.prepareStatement(query);
              

              String uppercase = text_name.getText();
              
              pst.setString(1, uppercase);
              


              pst.execute();
              
              pst.close();
             
             
            }
            catch (SQLException e1) {
              e1.printStackTrace();
              JOptionPane.showMessageDialog(null, e1);
            }

    		
    		
    	}
    });
    btnUpdate.setForeground(Color.WHITE);
    btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnUpdate.setBackground(new Color(0,139,139));
    btnUpdate.setBounds(1071, 270, 89, 23);
    panel_1.add(btnUpdate);
    
    JButton btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		passwordField_delete.setVisible(true); lblNewLabel_2.setVisible(true);    passwordField_delete.requestFocus();
    	}
    });
    btnDelete.setForeground(Color.WHITE);
    btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnDelete.setBackground(new Color(0,139,139));
    btnDelete.setBounds(1071, 353, 89, 23);
    panel_1.add(btnDelete);
    
    lblNewLabel_2 = new JLabel("Admin Password!");
    lblNewLabel_2.setForeground(Color.WHITE);
    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblNewLabel_2.setBounds(958, 363, 127, 20);
    lblNewLabel_2.setVisible(false);
    panel_1.add(lblNewLabel_2);
    
    passwordField_delete = new JPasswordField();
    passwordField_delete.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		
    		
    		if(arg0.getKeyCode()==10)
    		{
    			int action = JOptionPane.showConfirmDialog(null, "Delete Service from STOCK?", textField_4.getText(), 0);
       		 
       		 if(action !=0) { 
       			 textField_4.setText("");   textField_5.setText(""); 
   	              
   	            
   	              passwordField_delete.setText(""); passwordField_delete.setVisible(false); lblNewLabel_2.setVisible(false); }
       		 
       		 
       		 
     	        if (action == 0)
     	        {   
     	        	try {
     	        		String sql1 = "select * from admintable where  PASSWORD=?";
   		              
   		              PreparedStatement pt = con.prepareStatement(sql1);
   		              pt.setString(1, passwordField_delete.getText());
   		             
   		              ResultSet r = pt.executeQuery();
   		              if (r.next())
   		              {
                            pt.close();
   		                r.close();
   		                
   		             String query = "Delete from p_items where service_name='" + textField_4.getText() + "'  and service_price ='"+textField_5.getText()+"'";
              
              PreparedStatement pst = con.prepareStatement(query);
              pst.execute();
              pst.close();
           	
              String sql = "select  *  from p_items ORDER BY service_name ASC;";
              
              PreparedStatement pt1 = com.prepareStatement(sql);
              ResultSet rs = pt1.executeQuery();
              table_2.setModel(DbUtils.resultSetToTableModel(rs));
              
              pt1.close();
              rs.close();

                textField_5.setText("");   textField_4.setText("");
                 
                
                passwordField_delete.setText(""); passwordField_delete.setVisible(false); lblNewLabel_2.setVisible(false); 

                combobox_items();
   		              }
     	        		
                else
                {
                  JOptionPane.showMessageDialog(null, "Incorrect passoword!");
                }

     	        	 }catch(Exception e) {JOptionPane.showMessageDialog(null, "No item Selected!"); passwordField_delete.setText(""); passwordField_delete.setVisible(false); lblNewLabel_2.setVisible(false); 
     }
     	        	
     	        	
     	        	}


    			
    			
    			
    			
    			
    			
    		}
    	}
    });
    passwordField_delete.setBounds(958, 382, 104, 20);
    passwordField_delete.setVisible(false);
    panel_1.add(passwordField_delete);
  
    
    JPanel panel_3 = new JPanel();
    panel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
    panel_3.setBackground(new Color(0,139,139));
    panel_3.setForeground(SystemColor.desktop);
    panel_3.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)), "Add Services", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(255, 255, 255)));
    panel_3.setBounds(10, 56, 390, 269);
    panel_1.add(panel_3);
    
    JPanel panel_4 = new JPanel();
    panel_4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)), "Edit Services  ", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(255, 255, 255)));
    panel_4.setBounds(800, 56, 385, 400);
    panel_4.setBackground(new Color(0,139,139));
    panel_1.add(panel_4); 
    
    JScrollPane scrollPane_2 = new JScrollPane();
    scrollPane_2.setBounds(433, 56, 330, 474);
    panel_1.add(scrollPane_2);
    
    table_2 = new JTable();
    scrollPane_2.setViewportView(table_2);
    
    JButton btnNewButton = new JButton("Service List");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		 try {
    	          String sql = "select * from p_items ORDER BY service_name ASC;";
    	          
    	          PreparedStatement pst = com.prepareStatement(sql);
    	          ResultSet rs = pst.executeQuery();
    	          table_2.setModel(DbUtils.resultSetToTableModel(rs));
    	          
    	          pst.close();
    	          rs.close();

    	        }
    	        catch (SQLException e1)
    	        {

    	          e1.printStackTrace();
    	          JOptionPane.showMessageDialog(null, e1);
    	        }

    		
    		
    	}
    });
    btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnNewButton.setBackground(new Color(0,139,139));
    btnNewButton.setForeground(Color.WHITE);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
    btnNewButton.setBounds(537, 26, 89, 23);
    panel_1.add(btnNewButton);
    
    
  
    
    JPanel panel_2 = new JPanel();
    tabbedPane.addTab("RECORDS' HISTORY ", null, panel_2, null);
    panel_2.setBackground(new Color(0,139,139));
    
    panel_2.setLayout(null);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(0, 110, 755, 365);
    panel_2.add(scrollPane_1);
    
    table_1 = new JTable();
    table_1.setSelectionBackground(new Color(255,255,102));
    table_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
    table_1.addMouseListener(new MouseAdapter()
    {

      public void mouseClicked(MouseEvent e)
      {
        int row = table_1.getSelectedRow();
        String sid = table_1.getModel().getValueAt(row, 0).toString();
    
        try
        {
          String sql = "select i_no ,s_name,s_price,disc,amt from p_invoicetable where i_no='" + sid + "'";
          
          PreparedStatement pst = com.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
          table_3.setModel(DbUtils.resultSetToTableModel(rs));
          
          pst.close();
          rs.close();

        }
        catch (SQLException e1)
        {

          e1.printStackTrace();
          JOptionPane.showMessageDialog(null, e1);

        }
        

      }
      

    });
    table_1.setModel(new DefaultTableModel(
      new Object[0][], 
      
      new String[] {
      "Invoice_no", "Date", "Time","R_No", "Cust_Name","Sex","Age" ,"Cust_Phone","Cust_Add", "Total_Service", "Grand_Total" }));
    

    table_1.getColumnModel().getColumn(1).setPreferredWidth(92);
    scrollPane_1.setViewportView(table_1);
    
    JButton btnLoadDetaila = new JButton("Load Details");
    btnLoadDetaila.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnLoadDetaila.setBackground(new Color(0,139,139));
   
    btnLoadDetaila.setForeground(Color.WHITE);
    btnLoadDetaila.setFont(new Font("Tahoma", 0, 15));
    btnLoadDetaila.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        try {
          String sql = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name ,sex,age, CUST_phone, address, total_service,grand_total from p_customers order by date desc, time desc";
          
          PreparedStatement pst = com.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
          table_1.setModel(DbUtils.resultSetToTableModel(rs));
          
          pst.close();
          rs.close();
          
          table_3.setModel(new DefaultTableModel(
                  new Object[0][], 
                  
                  new String[] {
                  		 "I_no","S_Name", "S_Price", "Disc", "Amount" }));


        }
        catch (Exception e1)
        {

          e1.printStackTrace();
          JOptionPane.showMessageDialog(null, e1);
        }
        





      }
      



    });
    btnLoadDetaila.setBounds(10, 31, 113, 59);
    panel_2.add(btnLoadDetaila);
    
    dateChooser = new JDateChooser();
    dateChooser.getCalendarButton().addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {}

    });
    dateChooser.setBounds(533, 35, 128, 20);
    panel_2.add(dateChooser);
    
    dateChooser.setDateFormatString("dd-MM-yyy");
    dateChooser.setFont(new Font("Tahoma", 0, 13));
    
    JLabel searchby = new JLabel("Search By Record_no:");
    searchby.setForeground(Color.WHITE);
    searchby.setFont(new Font("Tahoma", 0, 15));
    searchby.setBounds(145, 31, 153, 27);
    panel_2.add(searchby);
    
    textField_2 = new JTextField();
    textField_2.setBackground(new Color(255,255,102));
    
    textField_2.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {
          try
          {
            int i = Integer.parseInt(textField_2.getText());
            String sql = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name ,sex,age, CUST_phone, address, total_service,grand_total from p_customers   where INvoice_no='" + i + "'  order by date desc,time desc";
            
            PreparedStatement pst = com.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            
            textField_2.setText("");
          }
          catch (SQLException e1)
          {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, e1);
          }
          



          table_3.setModel(new DefaultTableModel(
            new Object[0][], 
            
            new String[] {
            		 "I_no","S_Name", "S_Price", "Disc","Qty", "Amount" }));

        }
        

      }
      


    });
    textField_2.setBounds(296, 35, 94, 20);
    panel_2.add(textField_2);
    textField_2.setColumns(10);
    
    JLabel lblSearchByDate = new JLabel("Search By Date:");
    lblSearchByDate.setForeground(Color.WHITE);
    lblSearchByDate.setFont(new Font("Tahoma", 0, 15));
    lblSearchByDate.setBounds(419, 31, 118, 27);
    panel_2.add(lblSearchByDate);
    
    JButton button = new JButton("Load");
    button.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    button.setBackground(new Color(0,139,139));
    button.setForeground(Color.WHITE);
 
    
    button.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String s = df.format(dateChooser.getDate());
        

        try
        {
          String sql = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name ,sex,age, CUST_phone, address, total_service,grand_total from p_customers   where date=parsedatetime(?, 'dd-MM-yyyy') order by date asc,time desc";
          
          PreparedStatement pst = com.prepareStatement(sql);
          
          pst.setString(1, s);
          ResultSet rs = pst.executeQuery();
          table_1.setModel(DbUtils.resultSetToTableModel(rs));
          
          pst.close();
          rs.close();

        }
        catch (SQLException e1)
        {

          e1.printStackTrace();
          JOptionPane.showMessageDialog(null, e1);
        }
        



        table_3.setModel(new DefaultTableModel(
          new Object[0][], 
          
          new String[] {
          		 "I_no","S_Name", "S_Price", "Disc","Qty", "Amount" }));


      }
      



    });
    button.setBounds(597, 70, 64, 20);
    panel_2.add(button);
    
    final JDateChooser dateChooser_1 = new JDateChooser();
    dateChooser_1.setFont(new Font("Tahoma", 0, 13));
    dateChooser_1.setDateFormatString("dd-MM-yyy");
    dateChooser_1.setBounds(846, 35, 100, 20);
    panel_2.add(dateChooser_1);
    
    final JDateChooser dateChooser_2 = new JDateChooser();
    dateChooser_2.setFont(new Font("Tahoma", 0, 13));
    dateChooser_2.setDateFormatString("dd-MM-yyy");
    dateChooser_2.setBounds(1003, 35, 100, 20);
    panel_2.add(dateChooser_2);
    
    JButton button_2 = new JButton("Load");
    button_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    button_2.setBackground(new Color(0,139,139));
    button_2.setForeground(Color.WHITE);
    button_2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String s1 = df.format(dateChooser_1.getDate());
        String s2 = df.format(dateChooser_2.getDate());
        


        try
        {
          String sql = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name ,sex,age, CUST_phone, address, total_service,grand_total from p_customers where   date  between parsedatetime(?, 'dd-MM-yyyy') and parsedatetime(?, 'dd-MM-yyyy') order by date desc,time desc";
          PreparedStatement pst = com.prepareStatement(sql);
          
          pst.setString(1, s1);
          pst.setString(2, s2);
          ResultSet rs = pst.executeQuery();
          table_1.setModel(DbUtils.resultSetToTableModel(rs));
          
          pst.close();
          rs.close();

        }
        catch (SQLException e1)
        {

          e1.printStackTrace();
          JOptionPane.showMessageDialog(null, e1);
        }
        




        table_3.setModel(new DefaultTableModel(
          new Object[0][], 
          
          new String[] {
          		 "I_no","S_Name", "S_Price", "Disc","Qty", "Amount" }));

      }
      


    });
    button_2.setBounds(1039, 70, 64, 20);
    panel_2.add(button_2);
    
    JLabel lblSearchBwDate = new JLabel("Search B/W Date:");
    lblSearchBwDate.setForeground(Color.WHITE);
    lblSearchBwDate.setFont(new Font("Tahoma", 0, 15));
    lblSearchBwDate.setBounds(714, 31, 126, 27);
    panel_2.add(lblSearchBwDate);
    
    JLabel lblAnd = new JLabel("AND");
    lblAnd.setForeground(Color.WHITE);
    lblAnd.setFont(new Font("Tahoma", 0, 15));
    lblAnd.setBounds(956, 31, 37, 27);
    panel_2.add(lblAnd);
    
    JLabel lblDeleteInvoice = new JLabel("Delete Record no:");
    lblDeleteInvoice.setForeground(Color.WHITE);
    lblDeleteInvoice.setFont(new Font("Tahoma", 0, 15));
    lblDeleteInvoice.setBounds(10, 486, 120, 27);
    panel_2.add(lblDeleteInvoice);
    
    textField_3 = new JTextField();
    textField_3.setBackground(new Color(255,255,102));
    
    textField_3.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {
        	lblEnterPassword.setVisible(true);
    		textField_4_pass.setVisible(true); textField_4_pass.requestFocus();
        	
        	
        }
        
      }
      

    });
    textField_3.setColumns(10);
    textField_3.setBounds(130, 491, 94, 20);
    panel_2.add(textField_3);
    
    JPanel panel_7 = new JPanel();
    panel_7.setForeground(Color.WHITE);
    panel_7.setBackground(new Color(0,139,139));
    panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_7.setBounds(134, 11, 264, 87);
    panel_2.add(panel_7);
    
    JPanel panel_8 = new JPanel();
    panel_8.setBackground(new Color(0,139,139));
    panel_8.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_8.setBounds(408, 11, 265, 87);
    panel_2.add(panel_8);
    
    JPanel panel_9 = new JPanel();
    panel_9.setBackground(new Color(0,139,139));
    panel_9.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_9.setBounds(683, 11, 488, 87);
    panel_2.add(panel_9);
    
    JScrollPane scrollPane_3 = new JScrollPane();
    scrollPane_3.setBounds(760, 110, 568, 365);
    panel_2.add(scrollPane_3);
    
    table_3 = new JTable();
    table_3.setFont(new Font("Tahoma", 0, 15));
    table_3.setModel(new DefaultTableModel(
      new Object[0][], 
      
      new String[] {
      "Invoice", "P_Name",  "P_Price", "P_Disc", "P_Amt" }));
    

    scrollPane_3.setViewportView(table_3);
    



    JLabel lblPrintInvoice = new JLabel("Print Reciept no:");
    lblPrintInvoice.setForeground(Color.WHITE);
    lblPrintInvoice.setFont(new Font("Tahoma", 0, 15));
    lblPrintInvoice.setBounds(663, 486, 113, 27);
    panel_2.add(lblPrintInvoice);
    
    textField_13 = new JTextField();
    textField_13.setBackground(new Color(255,255,102));
    
    textField_13.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent arg0)
      {
        if (arg0.getKeyCode() == 10)
        {
        	  
        	
        	printinvoice(textField_13.getText());
        	textPane.setText("");
        	textField_13.setText("");
        }
        
      }
      

    });
    textField_13.setColumns(10);
    textField_13.setBounds(770, 491, 94, 20);
    panel_2.add(textField_13);
    
    lblEnterPassword = new JLabel("Admin Password:");
    lblEnterPassword.setForeground(Color.WHITE);
    lblEnterPassword.setVisible(false);
    lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblEnterPassword.setBounds(28, 525, 113, 27);
    panel_2.add(lblEnterPassword);
    
    textField_4_pass = new JPasswordField();
    textField_4_pass.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent e) {
    		
    		if (e.getKeyCode() == 10)
            {
              String s = textField_3.getText();
              int action = JOptionPane.showConfirmDialog(null, s, "Delete", 0);
              if (action == 0)
              {

                try
                {
                	
                	String sql1 = "select * from admintable where  PASSWORD=?";
		              
		              PreparedStatement pt = con.prepareStatement(sql1);
		              pt.setString(1, textField_4_pass.getText());
		             
		              ResultSet r = pt.executeQuery();
		              if (r.next())
		              {
                       pt.close();
		                r.close();
		            
                	
                  String query = "delete from p_customers where invoice_no=?";
                  
                  PreparedStatement pst = con.prepareStatement(query);
                  



                  pst.setString(1, textField_3.getText());
                  


                  pst.execute();
                  
                  pst.close();
                
                   query = "delete from p_invoicetable where i_no=?";
                  
                   pst = con.prepareStatement(query);
                  



                  pst.setString(1, textField_3.getText());
                  


                  pst.execute();
                  
                  pst.close();
                


                  String sql =  "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name ,sex,age, CUST_phone, address, total_service,grand_total from p_customers order by date desc, time desc";
                  
                   pst = com.prepareStatement(sql);
                  ResultSet rs = pst.executeQuery();
                  table_1.setModel(DbUtils.resultSetToTableModel(rs));
                  
                  pst.close();
                  rs.close();


                  textField_3.setText(""); 
                  textField_4_pass.setVisible(false);
                  textField_4_pass.setText("");
                  lblEnterPassword.setVisible(false);
                  } else {JOptionPane.showMessageDialog(null,"Wrong Password!"); }
		              
		              }
                catch (SQLException e1)
                {

                  e1.printStackTrace();
                  JOptionPane.showMessageDialog(null, e1);
                }
              
              

		              
                
                }
            }

    		
    	}
    });
    textField_4_pass.setVisible(false);
    textField_4_pass.setBounds(140, 529, 126, 20);
    panel_2.add(textField_4_pass);
    
 /*   JLabel lblPrintPrescriptionNo = new JLabel("Print Prescription no:");
    lblPrintPrescriptionNo.setForeground(Color.WHITE);
    lblPrintPrescriptionNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblPrintPrescriptionNo.setBounds(635, 524, 146, 27);
    panel_2.add(lblPrintPrescriptionNo);
    
    textField = new JTextField();
    textField.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		
    		 if (arg0.getKeyCode() == 10)
    	        {
    	        	  
    	        	
    			 printpress(textField.getText());
    	        	textField.setText("");
    	        }
    	}
    });
    textField.setColumns(10);
    textField.setBackground(new Color(255, 255, 102));
    textField.setBounds(770, 529, 94, 20);
    panel_2.add(textField);
    
*/
    JPanel panel_6 = new JPanel();
    tabbedPane.addTab("PATIENT LIST", null, panel_6, null);
    panel_6.setBackground(new Color(0,139,139));
    
    panel_6.setLayout(null);
    Image da = new ImageIcon(getClass().getResource("/deleteall.png")).getImage();
    





    JButton btnDeleteAllItems = new JButton("Delete All Bills");
    Image dab = new ImageIcon(getClass().getResource("/deletebills.png")).getImage();
    btnDeleteAllItems.setIcon(new ImageIcon(dab));
    btnDeleteAllItems.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnDeleteAllItems.setBackground(new Color(0,139,139));
   
    btnDeleteAllItems.setForeground(Color.WHITE);
   
   
    btnDeleteAllItems.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
               
    	  lblNewLabel_3.setVisible(true);
  		passwordField.setVisible(true); passwordField.requestFocus();
      	
      }
      

    });
    btnDeleteAllItems.setFont(new Font("Tahoma", 0, 17));
    btnDeleteAllItems.setBounds(980, 350, 205, 60);
    panel_6.add(btnDeleteAllItems);
    
    JScrollPane scrollPane_4 = new JScrollPane();
    scrollPane_4.setBounds(55, 85, 900, 470);
    panel_6.add(scrollPane_4);
    
    table_5 = new JTable();
    scrollPane_4.setViewportView(table_5);
    
    JButton btnPatientList = new JButton("PATIENT LIST");
    btnPatientList.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		try {
    	          String sql = "Select * from patient_list order by name";
    	          PreparedStatement pst = com.prepareStatement(sql);
    	          ResultSet rs = pst.executeQuery();
    	          table_5.setModel(DbUtils.resultSetToTableModel(rs));
    	          
    	          pst.close();
    	          rs.close();
    	          
    		}    	        catch (Exception e1)
    	        {

    	          e1.printStackTrace();
    	          JOptionPane.showMessageDialog(null, e1);
    	        }

    	}
    });
    btnPatientList.setForeground(Color.WHITE);
    btnPatientList.setFont(new Font("Tahoma", Font.BOLD, 17));
    Image people = new ImageIcon(getClass().getResource("/people.png")).getImage();
    btnPatientList.setIcon(new ImageIcon(people));
  
    btnPatientList.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnPatientList.setBackground(new Color(0,139,139));
    btnPatientList.setBounds(377, 14, 205, 60);
    panel_6.add(btnPatientList);
    
    passwordField = new JPasswordField();
    passwordField.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		if(arg0.getKeyCode()==10)
    		{ 
    			 int action = JOptionPane.showConfirmDialog(null, "All Billing History will be Deleted!", "Delete All?", 0);
    		       
    			 if(action !=0) { passwordField.setText("");
    			 lblNewLabel_3.setVisible(false);
		            passwordField.setVisible(false); }
    			 
    			 
    			 if (action == 0)
    		        {

    		          try
    		          {
    		        	  String query = "select * from admintable where  PASSWORD=?";
    		              
    		              PreparedStatement pst = con.prepareStatement(query);
    		              pst.setString(1, passwordField.getText());
    		             
    		              ResultSet rs = pst.executeQuery();
    		              if (rs.next())
    		              {
                            pst.close();
    		                rs.close();
    		                
    		                
    		                String sql = " DELETE FROM p_customers ";
        		            PreparedStatement pt = con.prepareStatement(sql);
        		            pt.execute();
        		            pt.close();
        		            
        		            
        		            String sql1 = " DELETE FROM p_invoicetable";
        		            PreparedStatement pt1 = con.prepareStatement(sql1);
        		            pt1.execute();
        		            pt1.close();
        		            
        		            
        		            passwordField.setText("");
        		   		 lblNewLabel_3.setVisible(false);
        		            passwordField.setVisible(false);
        		           
    		              }
    		              else
    		              {
    		                JOptionPane.showMessageDialog(null, "Incorrect passoword!");
    		              }

    		          }catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
    		        
    		        
    		        }
    		        
    		        	  
    		        	  
    		        	  
    		        	  
    		        	  
    		            
    		            

    		        }

    		
    		
    	}
    });
    passwordField.setBounds(990, 453, 150, 20);
    passwordField.setVisible(false);
    panel_6.add(passwordField);
    
    lblNewLabel_3 = new JLabel("Admin Password!");
    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblNewLabel_3.setForeground(Color.WHITE);
    lblNewLabel_3.setVisible(false);
    lblNewLabel_3.setBounds(990, 428, 145, 30);
    panel_6.add(lblNewLabel_3);
    
    Image dai = new ImageIcon(getClass().getResource("/deleteitems.png")).getImage();
    







    Image imglogout = new ImageIcon(getClass().getResource("/Logout24.png")).getImage();
    

    Image imgchangepass = new ImageIcon(getClass().getResource("/changeDetails.png")).getImage();
    JButton logout = new JButton("Logout");
    logout.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    logout.setBackground(new Color(0,139,139));
    logout.setForeground(Color.WHITE);
    logout.setIcon(new ImageIcon(imglogout));
    logout.setFont(new Font("Tahoma", 0, 12));
    logout.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
       
        Tasks t = new Tasks();
        
        dispose();
        t.setVisible(true);
      }
    });
    logout.setBounds(1225, 600, 119, 32);
    contentPane.add(logout);
    
   /* JScrollPane scrollPane_6 = new JScrollPane();
    scrollPane_6.setBounds(812, 275, 309, 200);
    panel.add(scrollPane_6);
    */
    textPane = new JTextPane();
    textPane.setEditable(false);
   // scrollPane_6.setViewportView(textPane);
    textPane.setBounds(812, 275, 309, 200);
    panel.add(textPane);
    textPane.setFont(new Font("Courier New", Font.PLAIN, 11));
    
    JButton btnPrintInvoice = new JButton("Print Reciept");
    btnPrintInvoice.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
            
              try
              {

                double gt = Double.parseDouble(TA.getText());
                ti = Integer.parseInt(TI.getText());
                String in = record_no.getText();
                

                String query = " update p_customers set grand_total = '" + gt + "' , total_service='" + ti + "' where invoice_no='" + in + "'";
                
                PreparedStatement pst = con.prepareStatement(query);
                







                pst.execute();
                
                pst.close();
                printinvoice(in);
                textPane.setText("");
                btnNewButton_2.setVisible(false);
                record_no.requestFocus();
                ti = 0;
                ta = 0.0D;
                
                TI.setText("");
                TA.setText("");
               record_no.setText("");
                p_phone.setText("");
                p_r_no.setText("");
                p_name.setText("");
                P.setText("");
             //   Q.setText("1");
                D.setText("0");
                A.setText("");
                p_age.setText("");

                p_sex.setText("");

                p_add.setText("");
               
                table.setModel(new DefaultTableModel(null, new String[] {
                		  "          S_Name", "          S_Price", "          Discount", "          Amount" }));
                p_flag=0;
              }
              catch (Exception e2)
              {
                JOptionPane.showMessageDialog(null, e2);


              }
              


            
    		
    		
    	}
    });
    btnPrintInvoice.setForeground(Color.WHITE);
    btnPrintInvoice.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnPrintInvoice.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnPrintInvoice.setBackground(new Color(0,139,139));
    btnPrintInvoice.setBounds(670, 504, 119, 32);
    Image printimg = new ImageIcon(getClass().getResource("/printSmall.png")).getImage();
    btnPrintInvoice.setIcon(new ImageIcon(printimg));
  
    panel.add(btnPrintInvoice);
    
    JButton btnRemove = new JButton("Remove Item");
    btnRemove.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
            int action = JOptionPane.showConfirmDialog(null, "Remove item?", "Remove", 0);
            if (action == 0)
            {

              try
              {
                int row = table.getSelectedRow();
                
                String name = table.getModel().getValueAt(row, 0).toString();
                String query = "Delete from p_invoicetable where i_no='" + record_no.getText() + "' and s_name='" + name + "'";
                
                PreparedStatement pst = con.prepareStatement(query);
                pst.execute();
                ti -= 1;
                TI.setText(Integer.toString(ti));

              }
              catch (Exception e)
              {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
              }
              


              DefaultTableModel model = (DefaultTableModel)table.getModel();
              

              try
              {
                int SelectedRowIndex = table.getSelectedRow();
                
                double d = Double.parseDouble(TA.getText());
                double tempamt = Double.parseDouble(table.getModel().getValueAt(SelectedRowIndex, 3).toString());
                

                ta = (Math.round((d - tempamt) * 100.0D) / 100.0D);
                

                TA.setText(Double.toString(ta));
                
                model.removeRow(SelectedRowIndex);
               
                comboBox.requestFocus();
              }
              catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
              }
              
            }
    		
    	}
    });
    btnRemove.setForeground(Color.WHITE);
    btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 12));
    btnRemove.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnRemove.setBackground(new Color(0,139,139));
    Image removimg = new ImageIcon(getClass().getResource("/remove.png")).getImage();
    btnRemove.setIcon(new ImageIcon(removimg));
   
    btnRemove.setBounds(30, 508, 119, 32);
    panel.add(btnRemove);
    
   /* JButton btnCancelInvoice = new JButton("Cancel Invoice");
    btnCancelInvoice.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		int action = JOptionPane.showConfirmDialog(null, "Cancel Invoice?", "Cancel", 0);
            if (action == 0)
            {
              try {
                String query = "delete from p_customers where invoice_no=?";
                
                PreparedStatement pst = con.prepareStatement(query);
                



                pst.setString(1, record_no.getText());
                


                pst.execute();
                
                pst.close();
              }
              catch (SQLException e1)
              {
                JOptionPane.showMessageDialog(null, e1);
              }
              
              try
              {
                String query = "delete from p_invoicetable where i_no=?";
                
                PreparedStatement pst = con.prepareStatement(query);
                



                pst.setString(1, record_no.getText());
                


                pst.execute();
                
                pst.close();
              }
              catch (SQLException e1)
              {
                JOptionPane.showMessageDialog(null, e1);
              }
              





              btnNewButton_2.setVisible(false);
              record_no.requestFocus();
              ti = 0;
              ta = 0.0D;
              
              TI.setText("");
              TA.setText("");
              record_no.setText("");
              p_phone.setText("");
              p_r_no.setText("");
              p_name.setText("");
              P.setText("");
              Q.setText("1");
              D.setText("0");
              A.setText("");
              p_age.setText("");

              p_sex.setText("");

              p_add.setText("");

              
             
              table.setModel(new DefaultTableModel(null, new String[] {
            		  "          S_Name", "          S_Price", "          Discount","          Qty", "          Amount" }));
            }

    		
    		
    	}
    });
    btnCancelInvoice.setForeground(Color.WHITE);
    btnCancelInvoice.setFont(new Font("Tahoma", Font.PLAIN, 12));
    btnCancelInvoice.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnCancelInvoice.setBackground(new Color(0,139,139));
    Image returnimg = new ImageIcon(getClass().getResource("/back.png")).getImage();
    btnCancelInvoice.setIcon(new ImageIcon(returnimg));
   
    btnCancelInvoice.setBounds(670, 508, 119, 32);
    panel.add(btnCancelInvoice);
    */
    JButton btnPrintPrescription = new JButton("Print Prescription");
    btnPrintPrescription.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		  
    		  String in = record_no.getText();
              
    		  printpress(in);
    		  textPane.setText("");
              
    		/* btnNewButton_2.setVisible(false);
             record_no.requestFocus();
             ti = 0;
             ta = 0.0D;
             
             TI.setText("");
             TA.setText("");
             record_no.setText("");
             p_phone.setText("");
             p_r_no.setText("");
             p_name.setText("");
             P.setText("");
             Q.setText("1");
             D.setText("0");
             A.setText("");
             p_age.setText("");

             p_sex.setText("");

             p_add.setText("");
            
             table.setModel(new DefaultTableModel(null, new String[] {
             		  "          S_Name", "          S_Price", "          Discount","          Qty", "          Amount" })); */

    	}
    });
    btnPrintPrescription.setForeground(Color.WHITE);
    btnPrintPrescription.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnPrintPrescription.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnPrintPrescription.setBackground(new Color(0,139,139));
    btnPrintPrescription.setBounds(493, 508, 119, 32);
    btnPrintPrescription.setVisible(false);
    panel.add(btnPrintPrescription);
    
    p_r_no = new JTextField();
    p_r_no.setFont(new Font("Tahoma", Font.PLAIN, 17));
    p_r_no.setColumns(10);
    p_r_no.setBounds(30, 25, 139, 20);
    p_r_no.setVisible(false);
    panel.add(p_r_no);
    
    
    
    table_4 = new JTable();
    table_4.setModel(new DefaultTableModel(
      new Object[0][], 
      
      new String[] {
      "d", "time" }));
    

    table_4.setBounds(75, 42, 1, 1);
    contentPane.add(table_4);
    
    JPanel panel_report = new JPanel();
    tabbedPane.addTab(" REPORTS ", null, panel_report, null);
    panel_report.setBackground(new Color(0,139,139));
    
    panel_report.setLayout(null);
    
    JScrollPane scrollPane_5 = new JScrollPane();
    scrollPane_5.setBounds(44, 90, 1114, 396);
    panel_report.add(scrollPane_5);
    
    table_6 = new JTable();
    scrollPane_5.setViewportView(table_6);
    
    JLabel lblSeeReportBw = new JLabel("See Report B/W Date:");
    lblSeeReportBw.setForeground(Color.WHITE);
    lblSeeReportBw.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblSeeReportBw.setBounds(328, 25, 165, 27);
    panel_report.add(lblSeeReportBw);
    
    JDateChooser dateChooser_3 = new JDateChooser();
    dateChooser_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
    dateChooser_3.setDateFormatString("dd-MM-yyy");
    dateChooser_3.setBounds(499, 29, 100, 20);
    panel_report.add(dateChooser_3);
    
    JLabel label_1 = new JLabel("AND");
    label_1.setForeground(Color.WHITE);
    label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    label_1.setBounds(609, 25, 37, 27);
    panel_report.add(label_1);
    
    JDateChooser dateChooser_4 = new JDateChooser();
    dateChooser_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
    dateChooser_4.setDateFormatString("dd-MM-yyy");
    dateChooser_4.setBounds(656, 29, 100, 20);
    panel_report.add(dateChooser_4);
    
    JButton button_1 = new JButton("Load");
    button_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    	        String s1 = df.format(dateChooser_3.getDate());
    	        String s2 = df.format(dateChooser_4.getDate());
    	        
               int ts=0;
               double ta=0;

    	        try
    	        {
    	          String sql = "select i_no ,s_name, amt  from p_invoicetable where   date  between parsedatetime(?, 'dd-MM-yyyy') and parsedatetime(?, 'dd-MM-yyyy') order by s_name";
    	          String sql1 = "select i_no ,s_name, amt  from p_invoicetable where   date  between parsedatetime(?, 'dd-MM-yyyy') and parsedatetime(?, 'dd-MM-yyyy') order by s_name";
     	         
    	          PreparedStatement pst = com.prepareStatement(sql);
                  PreparedStatement pst1=com.prepareStatement(sql1);
    	          pst.setString(1, s1);
    	          pst.setString(2, s2);
    	          
    	          pst1.setString(1, s1);
    	          pst1.setString(2, s2);
    	          ResultSet rs = pst.executeQuery();
    	          ResultSet rs1 = pst1.executeQuery();
    	          table_6.setModel(DbUtils.resultSetToTableModel(rs));
    	          String tamt;
    	          while(rs1.next())
    	          {
    	        	  ts++;
    	        	  
    	        			tamt=rs1.getString("amt");
    	        			ta=ta+Double.parseDouble(tamt);
    	          }
    	          pst.close();

    	          pst1.close();
    	          rs.close();

    	          rs1.close();
    t_services.setText(Integer.toString(ts));
    ta = (Math.round(ta  * 100.0D) / 100.0D);
    
    t_amount.setText(Double.toString(ta));
    	        }
    	        catch (Exception e1)
    	        {

    	          e1.printStackTrace();
    	          JOptionPane.showMessageDialog(null, e1);
    	        }
    	        




    		
    	}
    });
    button_1.setForeground(Color.WHITE);
    button_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    button_1.setBackground(new Color(0,139,139));
    button_1.setBounds(692, 64, 64, 20);
    panel_report.add(button_1);
    
    JLabel lblTotalNoOf = new JLabel("Total No. of Services:");
    lblTotalNoOf.setForeground(Color.WHITE);
    lblTotalNoOf.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblTotalNoOf.setBounds(203, 507, 170, 27);
    panel_report.add(lblTotalNoOf);
    
    t_services = new JTextField();
    t_services.setFont(new Font("Tahoma", Font.PLAIN, 18));
    t_services.setEditable(false);
    t_services.setBounds(372, 512, 86, 20);
    panel_report.add(t_services);
    t_services.setColumns(10);
    
    JLabel lblTotalAmount_2 = new JLabel("Total Amount:");
    lblTotalAmount_2.setForeground(Color.WHITE);
    lblTotalAmount_2.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblTotalAmount_2.setBounds(721, 507, 109, 27);
    panel_report.add(lblTotalAmount_2);
    
    t_amount = new JTextField();
    t_amount.setFont(new Font("Tahoma", Font.PLAIN, 18));
    t_amount.setEditable(false);
    t_amount.setColumns(10);
    t_amount.setBounds(851, 512, 86, 20);
    panel_report.add(t_amount);
    
    JLabel lblNewLabel_4 = new JLabel("(\u20B9)");
    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_4.setForeground(Color.WHITE);
    lblNewLabel_4.setBounds(825, 510, 46, 20);
    panel_report.add(lblNewLabel_4);
   
    
    combobox_items();
    currentdate();
    
  }

private void initComponent() {
	// TODO Auto-generated method stub
	
}
}
