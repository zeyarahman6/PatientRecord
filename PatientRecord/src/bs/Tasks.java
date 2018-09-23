package bs;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
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
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import javax.swing.JPasswordField;



























public class Tasks
  extends JFrame
{  
	
	 int stock;	
	    int bill;
  protected JPanel contentPane;
  private JTextField pName;
  //private JTextField P;
  private JFormattedTextField Q;
  private JFormattedTextField D;
  private JTextField E;
  private JTable table;
  JComboBox comboBox;
  Robot robot = null;
  JInternalFrame internalFrame;
  Connection con = null; Connection com = null;
  String cid = null;
  String zid = null;
  JDateChooser dateChooser;
  private JTextField textField;
  private JTextField invoice_no;
  private JTextField c_name;
  private JTextField c_contact;
  private JTextField TA;
  private JTextField TI;
  private int ti = 0;
  private double ta = 0.0D;
  int count = 1;
  private JTable table_1;
  private JTextField date;
  private JTable table_2;
  JButton btnNewButton_2;
  private JTextField time;
  double disc = 0.0D;
  private JTextField textField_2;
  private JTextField timepmam;
  JTextPane textPane;
  int sno = 0;
  public String tempdate;
  public String temptime;
  private JTable table_3;
  private JTextField textField_8;
  private JTextField textField_9;
  private JTextField textField_10;
  private JFormattedTextField textField_11;
  private JTextField textField_12;
  private JTextField textField_13;
  private JTable table_4;
  private JTextField pack;
  private JTextField batch;
  private JTextField mrp;
  private JTextField textField_18;
  private JTextField textField_20;
  private JTextField textField_21;
  private JTextField textField_22;
  private JTextField amount;
  private JTextField M;
  private JTextField R;
  private JTextField c_address;
  private JTextField B;
  private JTextField textField_28;
  private JTextField textField_29;
  private JTextField textField_31;
  private JTextField tempqty;
  private JLabel enterpass;
  private JPasswordField textpass;
  private JPasswordField passwordField;
  private JLabel lblNewLabel_4;
  protected JTabbedPane tabbedPane;
  protected JPanel panel;
  private JButton button_4;
  private JLabel lblNewLabel_6;
  private JTextField textField_5;
  private JTextField tempquantity;
  private JButton btnUpdate;
  JTextComponent editor;
  private JPasswordField passwordField_delete;
  private JTextField textField_3;
  private JPasswordField textField_4;
  private JLabel lblEnterPassword;
  private JTextField qty;
  private JDateChooser dateChooser_3;
  private JTextField textField_1;
  private JComboBox P;
  
 
  public void otherslogin()
  {
	  tabbedPane.setEnabled(false);
	  button_4.setEnabled(false);
	  button_4.setVisible(false);
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
 //   paper.setImageableArea(fromCMTToPPI(2.0), fromCMTToPPI(0.01), fromCMTToPPI(21.0), fromCMTToPPI(29.7));
    paper.setImageableArea(fromCMTToPPI(0.3), fromCMTToPPI(0.0), fromCMTToPPI(21.0)-fromCMTToPPI(0.1), fromCMTToPPI(29.7)-fromCMTToPPI(1.3));
    
    PageFormat pageFormat=new PageFormat();
    
    pageFormat.setPaper(paper);
    PrinterJob pj= PrinterJob.getPrinterJob();
    pageFormat.setOrientation(PageFormat.LANDSCAPE);
    pj.setPrintable(textPane.getPrintable(null, null), pageFormat);
    pj.setCopies(1);
    
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
  

  public void product(String ino)
  {
	  SimpleAttributeSet sas = new SimpleAttributeSet();
	    StyleConstants.setBold(sas, true);
	    
	  
	  String tempta = null;
  
    try {
      String sql = "select  grand_total from m_customers where invoice_no='" + ino + "'";
      
      PreparedStatement pst = com.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      
      while (rs.next())
      {
        
        
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
    



    

    
    
    
    Document doc = textPane.getDocument();
  
    try {
    	
    	int len;
   int rlen;
       String header="S.No  P_Name\t\tPack\tBatch\tExp\tM.R.P\tDisc\tRate\tQty\tAmount";
       rlen=header.length();
      doc.insertString(len=doc.getLength(), header, null);
      textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
      
      doc.insertString(doc.getLength(), "\n_____________________________________________________________________________________________________________________\n", null);
       
      
    }
    catch (BadLocationException e) {
      e.printStackTrace();
    }
    


    StyledDocument doc2 = (StyledDocument)textPane.getDocument();
    MutableAttributeSet style2 = doc2.addStyle("Courier New", null);
    StyleConstants.setFontSize(style2, 10);
   
  
    StyledDocument doc3 = (StyledDocument)textPane.getDocument();
    MutableAttributeSet stylexp = doc2.addStyle("Courier New", null);
    StyleConstants.setFontSize(stylexp, 8);
  
    try
    {
      String sql = "select  P_name, pack ,batch ,exp ,mrp, p_disc,rate,p_qty,total from m_INVOICETABLE where I_no='" + ino + "'";
      PreparedStatement pst = com.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      

     int totalItems=0;
      while (rs.next())
      {

       double t_q=0;

        String name = rs.getString("P_NAME");
        String pack = rs.getString("pack");
        String batch=rs.getString("batch");
        String exp=rs.getString("exp");
        String mrp=rs.getString("mrp");
        String dis=rs.getString("p_disc");
        String rate=rs.getString("rate");
        String qty = rs.getString("P_QTY");
        String amt = rs.getString("total");
        
        
        totalItems+=Integer.parseInt(qty);
       /* t_q=Double.parseDouble(amt)/Integer.parseInt(qty);
        double dgst=Double.parseDouble(cgst);
               dgst=dgst+dgst;
               dgst=Math.round(dgst * 100.0D) / 100.0D;
        t_q=Math.round(t_q * 100.0D) / 100.0D; */
        int n = name.length();
        
        if ((n < 4))
        {
          sno += 1;
          
          try
          {
            doc.insertString(doc.getLength(), "  " + sno + "   ", null);
            int len=doc.getLength();
            int rlen=name.length();
            doc.insertString(doc.getLength(),name, null);
          
            doc.insertString(doc.getLength(), "\t\t\t" + pack + "\t" ,null);
            doc.insertString(doc.getLength(),batch, stylexp);
            doc.insertString(doc.getLength(),"\t",null);
          
            doc.insertString(doc.getLength(),exp, stylexp);
            doc.insertString(doc.getLength(), "\t" + mrp + "\t" +dis+ "\t" +rate+ "\t" +qty+ "\t" +amt+"\n", null);
          
            
            textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
            
          }
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        }
        


    /*      if ((n < 4) && (sno > 9))
        {
          sno += 1;
          try
          {
        	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
        	  int len=doc.getLength();
              int rlen=name.length();
              
              doc.insertString(doc.getLength(),name, null);
              doc.insertString(doc.getLength(), "\t\t\t" + hsn + "\t " + qty + "\t" + t_q + "\t" + amt + "\n", null);
            doc.insertString(doc.getLength(), "\t\tCGST\t\t\t\t" + cgst+"\n", null);
            doc.insertString(doc.getLength(), "\t\tSGST\t\t\t\t" + cgst+"\n", null);
            textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
            
          }
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        } */
        



        else  if (n > 15)
        {
          sno += 1;
          
          try
          {
        	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
        	  int len=doc.getLength();
              int rlen=name.length();
              
              doc.insertString(doc.getLength(),name, null);
              doc.insertString(doc.getLength(), "\t" + pack + "\t",null); 
              doc.insertString(doc.getLength(),batch, stylexp);
              doc.insertString(doc.getLength(),"\t",null);
            	
              doc.insertString(doc.getLength(),exp, stylexp);
            		   doc.insertString(doc.getLength(),"\t" + mrp + "\t" +dis+ "\t" +rate+ "\t" +qty+ "\t" +amt+"\n", null);
              
             textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
            
          }
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        }
        



        else   if ((n > 4) && (n < 16))
        {
          sno += 1;
          
          try
          {
        	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
        	  int len=doc.getLength();
              int rlen=name.length();
              
              doc.insertString(doc.getLength(),name, null);
              doc.insertString(doc.getLength(), "\t\t" + pack +"\t",null);
              doc.insertString(doc.getLength(),batch, stylexp);
              doc.insertString(doc.getLength(),"\t",null);
            
              doc.insertString(doc.getLength(),exp, stylexp);
              doc.insertString(doc.getLength(), "\t" + mrp + "\t" +dis+ "\t" +rate+ "\t" +qty+ "\t" +amt+"\n", null);
             textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
            
          }
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        }
        

        else  if ((n == 4) && (sno < 9))
          {
            sno += 1;
            try
            {
          	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
              int len=doc.getLength();
              int rlen=name.length();
              doc.insertString(doc.getLength(),name, null);
              doc.insertString(doc.getLength(), "\t\t\t" + pack + "\t",null);
              doc.insertString(doc.getLength(),batch, stylexp);
              doc.insertString(doc.getLength(),"\t",null);
            
              doc.insertString(doc.getLength(),exp, stylexp);
              doc.insertString(doc.getLength(), "\t" + mrp + "\t" +dis+ "\t" +rate+ "\t" +qty+ "\t" +amt+"\n", null);
              textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
              
            }
            
            
            
            
            
            catch (Exception exc) {
              JOptionPane.showMessageDialog(null, exc);
            }
          }
       


        else   if ((n == 4) && (sno >= 9))
        {
          sno += 1;
          try
          {
        	  doc.insertString(doc.getLength(), "  " + sno + "   ", null);
            int len=doc.getLength();
            int rlen=name.length();
            doc.insertString(doc.getLength(),name, null);
            doc.insertString(doc.getLength(), "\t\t" + pack + "\t" ,null);
            doc.insertString(doc.getLength(),batch, stylexp);
            doc.insertString(doc.getLength(),"\t",null);
          
            doc.insertString(doc.getLength(),exp, stylexp);
            doc.insertString(doc.getLength(), "\t" + mrp + "\t" +dis+ "\t" +rate+ "\t" +qty+ "\t" +amt+"\n", null);
           textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
            
          }
          
          
          
          
          
          catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
          }
        } 
      }
      
 if(sno==1) {  try {
	doc.insertString(doc.getLength(),"\n\n\n\n\n\n\n\n", null);
} catch (BadLocationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}    }

else if(sno==2) {  try {
	doc.insertString(doc.getLength(),"\n\n\n\n\n\n", null);
} catch (BadLocationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}    }


else if(sno==3) {  try {
	doc.insertString(doc.getLength(),"\n\n\n\n", null);
} catch (BadLocationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}    }

else if(sno==4) {  try {
	doc.insertString(doc.getLength(),"\n\n", null);
} catch (BadLocationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}    }



      pst.close();
      rs.close();
      try
      {    int len;
           int rlen;;
    	  double roundoff=Double.parseDouble(tempta);
    	         roundoff=Math.round(roundoff);
    	         double roundoffvalue=roundoff-Double.parseDouble(tempta);
    	         roundoffvalue=Math.round(roundoffvalue * 100.0D) / 100.0D;
    	         doc.insertString(doc.getLength(), "_____________________________________________________________________________________________________________________\n", null);
    	         doc.insertString(len=doc.getLength(), "Rounded Off: "+roundoffvalue,null);
        		 doc.insertString(doc.getLength(),"                                                                               Total Amount=\u20B9", null);
        		   textPane.getStyledDocument().setCharacterAttributes(len, 18, sas, false);
        		     
        		rlen=tempta.length();
                doc.insertString(len=doc.getLength(),  roundoff + "\n", null);
    doc.insertString(doc.getLength(), "                                                                                               Total Items=" + totalItems + "\n", null);
        textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
        
        doc.insertString(doc.getLength(), "Amount Chargeable(in words)\n", null);
         len=doc.getLength();
         
        String inr=Rupees.convertToIndianCurrency(Double.toString(roundoff));
         rlen=inr.length();
        doc.insertString(doc.getLength(), inr+"\n", null);
        
        textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
        doc.insertString(doc.getLength(), "_____________________________________________________________________________________________________________________\n", null);
          
        
        /*if(sno>=9) { doc.insertString(doc.getLength(), "\n\n\n\n\n\n\n\n", null);
        } 
       String header="  HSN/SAC\t\tTaxable Value\tCGST(9%)\tSGST(9%)\tTax Amt";
       rlen=header.length();
        doc.insertString(len=doc.getLength(), "  HSN/SAC\t\tTaxable Value\tCGST(9%)\tSGST(9%)\tTax Amt\n", null);
        textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
        
        String sqltax = "select  hsn ,p_amt ,cgst from INVOICETABLE where I_no='" + ino + "'";
        PreparedStatement psttax = com.prepareStatement(sqltax);
        ResultSet rstax = psttax.executeQuery();
        
        double taxablevalue=0;
        double totaltax=0;
        double gst=0;
        while (rstax.next())
        {



          String hsn = rstax.getString("HSN");
          String amt = rstax.getString("P_AMT");
          String cgst=rstax.getString("CGST");
          
          double tax=2*(Double.parseDouble(cgst));
          tax = (Math.round((tax) * 100.0D) / 100.0D);
           gst+=(Double.parseDouble(cgst));
          gst = (Math.round((gst) * 100.0D) / 100.0D);
        
          
           taxablevalue+=(Double.parseDouble(amt));
          taxablevalue = (Math.round((taxablevalue) * 100.0D) / 100.0D);
        
          totaltax+=tax;
         
        
          doc.insertString(doc.getLength(), "  "+hsn+"\t\t"+amt+"\t\t"+cgst+"\t"+cgst+"\t"+tax+"\n", null);
          

        }
        
        doc.insertString(doc.getLength(), "__________________________________________________________________________\n", null);
        
        doc.insertString(len=doc.getLength(), "  Total\t\t"+taxablevalue+"\t\t"+gst+"\t"+gst+"\t", null);
        textPane.getStyledDocument().setCharacterAttributes(len, 7, sas, false);
        
         len=doc.getLength();
         totaltax=Math.round(totaltax * 100.0D) / 100.0D;
         String str=Double.toString(totaltax);
          rlen=str.length();
        doc.insertString(doc.getLength(), str, null);
        textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
        
        doc.insertString(doc.getLength(),"\n", null);
        
       
        
        
        doc.insertString(doc.getLength(), "Tax Amount (in words)\n", null);
         inr=Rupees.convertToIndianCurrency(str);
         rlen=inr.length();
         len=doc.getLength();
         doc.insertString(doc.getLength(), inr+"\n", null);
         textPane.getStyledDocument().setCharacterAttributes(len, rlen, sas, false);
         
        doc.insertString(doc.getLength(), "__________________________________________________________________________\n", null);
        doc.insertString(doc.getLength(), "                                                           ",null);
        
        StyledDocument doc1 = (StyledDocument)textPane.getDocument();
        MutableAttributeSet style = doc1.addStyle("Courier New", null);
        StyleConstants.setFontSize(style, 8);
       
        
        doc.insertString(len=doc.getLength(),"for SYSTEM CARE\n", null);
        textPane.getStyledDocument().setCharacterAttributes(len, 15, sas, false);
        
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

       */
       
       // doc.insertString(doc.getLength(), "_______________________________________________________________________________________________________________\n", null);
        
        doc.insertString(doc.getLength(), "                                                                                          ",null);
          
                                                                                           doc.insertString(len=doc.getLength(),"for SKIN, HAIR & CLINIC\n", null);
        textPane.getStyledDocument().setCharacterAttributes(len, 25, sas, false);
        
        StyledDocument doc1 = (StyledDocument)textPane.getDocument();
        MutableAttributeSet style = doc1.addStyle("Courier New", null);
        StyleConstants.setFontSize(style, 8);
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

        
        doc.insertString(doc.getLength(),"Declaration\nWe declare that this invoice shows the actual price of the goods described \nand that all particulars are true and correct.", style);
        
        
        
        doc.insertString(doc.getLength(),"\t\t\t\t\t   Authorised Signatory", null);
        doc.insertString(doc.getLength(), "\n_____________________________________________________________________________________________________________________\n", null);
        
        
        	
    
    
        doc.insertString(doc.getLength(), "                                          SUBJECT TO HYDERABAD JURISDICTION\n",null);
        doc.insertString(doc.getLength(), "                                              ",null);  
                                                  doc.insertString(doc.getLength(),"This is a Computer Generated Invoice", style);
    

          
       // doc.insertString(doc.getLength(), "\tThank You! For shopping with us. Please! visit again.", null);
        sno = 0;
      }
      catch (BadLocationException e) {
        e.printStackTrace();
      }
      
      return;
    }
    catch (SQLException e1)
    {
      e1.printStackTrace();
      JOptionPane.showMessageDialog(null, e1);
    }
  }
  





  public void company(String ino)
  {
    SimpleAttributeSet sas = new SimpleAttributeSet();
    StyleConstants.setBold(sas, true);
    
    
    
    


    StyledDocument doc1 = (StyledDocument)textPane.getDocument();
    MutableAttributeSet style = doc1.addStyle("Courier New", null);
    StyleConstants.setFontSize(style, 24);
    MutableAttributeSet styli = doc1.addStyle("Courier New", null);
    MutableAttributeSet zyl = doc1.addStyle("Courier New", null);
    StyleConstants.setFontSize(styli, 18);
    StyleConstants.setFontSize(zyl, 8);
   
   
  /*  SimpleAttributeSet und = new SimpleAttributeSet();
    und.addAttribute(StyleConstants.CharacterConstants.Underline, Boolean.TRUE);
    und.addAttributes(styli);
  */






    try
    {
    	String sql = "select to_char(date,'DD-MM-YYYY') , time from m_customers where invoice_no='" + ino + "'";
         
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
     
      

	    String cname=null,phone=null,address=null;
	  
	      String sql1 = "select  cust_name,cust_phone,address from m_customers where invoice_no='" + ino + "'";
	      
	      PreparedStatement pst1 = com.prepareStatement(sql1);
	      ResultSet rs1 = pst1.executeQuery();
	      
	      while (rs1.next())
	      {
	        cname=rs1.getString("cust_name");
	        phone=rs1.getString("cust_phone");
	        address=rs1.getString("address");
	        
	        
	       
	      }  
	  
        pst1.close();
        rs1.close();
        
        
      Document doc = textPane.getDocument();
      int blen=0;
      doc.insertString(doc.getLength(), "\t\t\t\t     ",null);
      doc.insertString(blen=doc.getLength(),"INVOICE RECIEPT", styli);
      textPane.getStyledDocument().setCharacterAttributes(blen, 15, sas, false);

  //    doc.insertString(doc.getLength(), "\t  Composition Taxable Person, not eligible to Collect Tax on Supplies\n", zyl);
      doc.insertString(doc.getLength(), "\n_____________________________________________________________________________________________________________________\n", null);
                                         
      doc.insertString(doc.getLength(), "DR. BABU'S\n", null);
      doc.insertString(blen=doc.getLength(), "SKIN, HAIR & NAIL CLINIC", style);
      textPane.getStyledDocument().setCharacterAttributes(blen, 24, sas, false);
      doc.insertString(doc.getLength(), "\n" + "TOLICHOWKI:Above Axis Bank,Near Azaan Internation School,7 Tombs Road\t\t" ,zyl);//+"\t\t\t",null);
      doc.insertString(blen=doc.getLength(),"INVOICE No:"+ino+"\t\t",zyl);
      textPane.getStyledDocument().setCharacterAttributes(blen, 11, sas, false);
      doc.insertString(blen=doc.getLength(), "BUYER:"+cname,zyl);
      textPane.getStyledDocument().setCharacterAttributes(blen, 5, sas, false);
      
     
      
      doc.insertString(doc.getLength(), "\nVIJAYANAGAR COLONY: Opposite To Andhra Bank\t\t\t\t",zyl);
      doc.insertString(blen=doc.getLength(),"DATE:"+tempdate+"\t\t",zyl);
      textPane.getStyledDocument().setCharacterAttributes(blen, 5, sas, false);
      
        
      doc.insertString(blen=doc.getLength(),"PHONE:" + phone +"\n",zyl); textPane.getStyledDocument().setCharacterAttributes(blen, 6, sas, false);
      doc.insertString(blen=doc.getLength(),"PHONE:" + "9640812934" +"\t\t\t\t\t",zyl); textPane.getStyledDocument().setCharacterAttributes(blen, 6, sas, false);
      
      doc.insertString(blen=doc.getLength(),"TIME:"+temptime+"\t\t",zyl); textPane.getStyledDocument().setCharacterAttributes(blen, 5, sas, false);
      textPane.getStyledDocument().setCharacterAttributes(blen, 5, sas, false);
      doc.insertString(blen=doc.getLength(), "Address:"+address+"\n", zyl);
      textPane.getStyledDocument().setCharacterAttributes(blen, 7, sas, false);
      
      
     
      doc.insertString(doc.getLength(), "_____________________________________________________________________________________________________________________\n", null);
          
        } catch (Exception exc) {
          exc.printStackTrace();
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
            


            SimpleDateFormat s1 = new SimpleDateFormat("HH:mm:ss");
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
  








    

 


  public void combobox_items()
  {
    LoginPage c = new LoginPage();
    
    com = c.dbcon();
    

    comboBox.removeAllItems();
    try {
      String sql = "select DISTINCT item_name from m_items order by item_name asc";
      PreparedStatement pst = com.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      
      while (rs.next())
      {

        String id = rs.getString("item_name");
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
  

  protected void comboboxPack()
  {
//    LoginPage c = new LoginPage();
    
  //  com = c.dbcon();
    

    P.removeAllItems();
    try {
      String sql = "select  pack from m_items where item_name='"+(String)comboBox.getSelectedItem()+"'";
      PreparedStatement pst = com.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      
      while (rs.next())
      {

        String id = rs.getString("pack");
        P.addItem(id);
      }
      pst.close();
      rs.close();
      
      AutoCompleteDecorator.decorate(P);
    }
    catch (SQLException e1)
    {
      e1.printStackTrace();
      JOptionPane.showMessageDialog(null, e1);
    }
  }







  public Tasks()
  {
  	setIconImage(Toolkit.getDefaultToolkit().getImage(Tasks.class.getResource("/archive/invoice-icon.png")));
  	setBackground(new Color(70,130,150));
    setDefaultCloseOperation(0);
    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    LoginPage c = new LoginPage();
    
    con = c.sharedb();
    




    setBounds(100, 100, 1388, 710);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(70, 130, 150));
    
    contentPane.setBorder(null);
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    tabbedPane = new JTabbedPane(1);
    tabbedPane.setForeground(new Color(0, 0, 0));
    tabbedPane.setBorder(null);
    tabbedPane.setAlignmentY(Component.TOP_ALIGNMENT);
    tabbedPane.setAlignmentX(Component.LEFT_ALIGNMENT);
    tabbedPane.setBackground(new Color(255, 255, 255));
    tabbedPane.setBounds(10, 11, 1355, 605);
    
    contentPane.add(tabbedPane);
    tabbedPane.setFont(new Font("Tahoma", 1, 12));
    



    Image imgadd = new ImageIcon(getClass().getResource("/add-item-icon74.png")).getImage();
    


    Image imggg = new ImageIcon(getClass().getResource("/submit32.png")).getImage();
    

    Image i = new ImageIcon(getClass().getResource("/add48.png")).getImage();
    

    Image i2 = new ImageIcon(getClass().getResource("/delete-1-icon.png")).getImage();
    







    panel = new JPanel();
    panel.setBorder(null);
    panel.setAlignmentY(0.0f);
    panel.setAlignmentX(0.0f);
    
    panel.setBackground(new Color(70, 130, 150));
    tabbedPane.addTab("BILLING       ", null, panel, null);
    panel.setLayout(null);
    
   
    
    
    JLabel lblProductprice_1 = new JLabel("BATCH");
    lblProductprice_1.setForeground(new Color(255, 255, 255));
    lblProductprice_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblProductprice_1.setBorder(null);
    lblProductprice_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblProductprice_1.setBounds(490, 172, 120, 20);
    panel.add(lblProductprice_1);
    
    JLabel lblProductquantity_1 = new JLabel("QTY");
    lblProductquantity_1.setForeground(new Color(255, 255, 255));
    lblProductquantity_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblProductquantity_1.setBorder(null);
    lblProductquantity_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblProductquantity_1.setBounds(1014, 172, 50, 20);
    panel.add(lblProductquantity_1);
    
    JLabel lblProductdate = new JLabel("Date");
    lblProductdate.setForeground(Color.WHITE);
    lblProductdate.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblProductdate.setBounds(1184, 11, 36, 20);
    panel.add(lblProductdate);
    
    JLabel lblDiscount = new JLabel("DISC");
    lblDiscount.setForeground(new Color(255, 255, 255));
    lblDiscount.setBorder(null);
    lblDiscount.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblDiscount.setBounds(838, 172, 46, 20);
    panel.add(lblDiscount);
    
  /*  P = new JTextField();
    P.setEditable(false);
    P.setBackground(new Color(255, 255, 102));
    P.setHorizontalAlignment(4);
    P.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 38)
        {
          Q.requestFocus();
        }
        



              



        if (e.getKeyCode() == 10)
        {
          D.setEnabled(true);
          D.requestFocus();
        }
        
      }
    });
    P.setFont(new Font("Tahoma", 0, 18));
    P.setColumns(10);
    P.setBounds(380, 196, 100, 20);
    panel.add(P);
    */
    Q = new JFormattedTextField();
   // Q.setValue("1");
    Q.setHorizontalAlignment(4);
    
    Q.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent e)
      {
        
        bill=0;
        stock=0;

        if (e.getKeyCode() == 10)
        {
           try {
          String sql="select qty from m_items where  item_name='"+(String)comboBox.getSelectedItem()+"' and pack='"+(String)P.getSelectedItem()+"' and batch='"+B.getText()+"'";
          PreparedStatement pst = com.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
          
          while (rs.next())
          {
        	  stock=Integer.parseInt(rs.getString("qty"));
          }
          pst.close();
          rs.close();
       bill=Integer.parseInt(Q.getText());
       
       if(bill<=stock && stock != 0)
       {
    	    
    		   
    		   double r =Double.parseDouble(R.getText());
          
           
                  
           
          double newsum;
          
           newsum=r*bill;
    	   newsum=Math.round(newsum * 100.0D) / 100.0D;
           amount.setText(Double.toString(newsum));
    	   
           amount.requestFocus();



       }
        
       else { JOptionPane.showMessageDialog(null, "OUT OF STOCK!");}
    		   
        	} catch(Exception e1) { JOptionPane.showMessageDialog(null, "Enter QTY Properly!");}
        }
        




        


      }
      


    });
    Q.setFont(new Font("Tahoma", 0, 18));
    Q.setColumns(10);
    Q.setBounds(1016, 196, 45, 20);
    panel.add(Q);
    
    
    
    DefaultFormatter format=new DefaultFormatter();
    D = new JFormattedTextField(format);
    D.setBackground(new Color(255, 255, 255));
    D.setHorizontalAlignment(SwingConstants.RIGHT);
   
   D.setValue("0");
    D.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {




        if (e.getKeyCode() == 10)
        {
        	
        	  double p =Double.parseDouble(M.getText());
              
              double d = Double.parseDouble(D.getText());
                     p=p-d;
              
                     
             double rate = Math.round(p * 100.0D) / 100.0D;
              R.setText(Double.toString(rate));
        	
        	 
             Q.requestFocus();
      	  
                  }
        
      }
      

    });
    D.setFont(new Font("Tahoma", 0, 18));
    D.setColumns(10);
    D.setBounds(835, 196, 63, 20);
    panel.add(D);
    
    E = new JTextField();
    E.setBackground(new Color(255, 255, 255));
   
    E.setHorizontalAlignment(4);
    
    E.setFont(new Font("Tahoma", 0, 18));
    E.setColumns(10);
    E.setBounds(621, 196, 100, 20);
    panel.add(E);
    



    comboBox = new JComboBox();
    comboBox.setFont(new Font("Tahoma", 0, 17));

    comboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e) {
        
        if (e.getKeyChar() == 10)
        {
        	comboboxPack();
        	
        	P.requestFocus();
          

        }
        


      }
      



    });
     editor = (JTextComponent)comboBox.getEditor().getEditorComponent();

    comboBox.setBounds(30, 196, 299, 20);
    panel.add(comboBox);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(30, 218, 1299, 264);
    panel.add(scrollPane);
    
    table = new JTable();
    table.setSelectionBackground(new Color(255,255,102));
   
    table.setFont(new Font("Tahoma", Font.PLAIN, 16));
    table.setModel(new DefaultTableModel(
      new Object[0][], 
      
      new String[] {
      "Name","PACK", "BATCH",  "EXP", "MRP","DISC","RATE","QTY","Amount" })
      {





        Class[] columnTypes = {
          String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class  };
        
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
    table.getColumnModel().getColumn(4).setMinWidth(20);
    table.getColumnModel().getColumn(5).setMinWidth(20);
    table.getColumnModel().getColumn(6).setMinWidth(20);
    table.getColumnModel().getColumn(7).setMinWidth(20);
    table.getColumnModel().getColumn(8).setMinWidth(20);
   
    scrollPane.setViewportView(table);
    


    JLabel lblCategoryname = new JLabel("Product_Name");
    lblCategoryname.setForeground(new Color(255, 255, 255));
    lblCategoryname.setHorizontalAlignment(SwingConstants.CENTER);
    lblCategoryname.setBorder(null);
    lblCategoryname.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblCategoryname.setBounds(30, 172, 299, 20);
    panel.add(lblCategoryname);
    btnNewButton_2 = new JButton("");
    btnNewButton_2.setBackground(new Color(70, 130, 150));
    btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnNewButton_2.setVisible(false);
    btnNewButton_2.setFont(new Font("Dialog", 1, 15));
    btnNewButton_2.setIcon(new ImageIcon(imggg));
    

    btnNewButton_2.setBounds(380, 11, 50, 33);
    panel.add(btnNewButton_2);
    
    JLabel lblCustomerName = new JLabel("Customer Name");
    lblCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
    lblCustomerName.setForeground(Color.WHITE);
    lblCustomerName.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblCustomerName.setBounds(20, 65, 132, 20);
    panel.add(lblCustomerName);
    
    JLabel lblInvoiceNo = new JLabel("Invoice No.");
    lblInvoiceNo.setHorizontalAlignment(SwingConstants.CENTER);
    lblInvoiceNo.setForeground(Color.WHITE);
    lblInvoiceNo.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblInvoiceNo.setBounds(10, 11, 120, 20);
    panel.add(lblInvoiceNo);
    
    invoice_no = new JTextField();
    invoice_no.setEditable(false);
    invoice_no.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		invoice_no.setEditable(true);
    		
    	}
    });
    invoice_no.setBackground(new Color(255, 255, 102));
    invoice_no.setFont(new Font("Tahoma", 0, 17));
    invoice_no.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent e)
      {

        if (e.getKeyCode() == 10)
        {
        	  if (invoice_no.getText().length() != 0)
              {
                try
                {
                  String query = "INSERT INTO m_customers (invoice_no,date, time) VALUES (?,parsedatetime(?, 'dd-MM-yyyy'),parsedatetime(?, 'HH:mm'))";
                  
                  PreparedStatement pst = con.prepareStatement(query);
                  



                  pst.setString(1, invoice_no.getText());
                  pst.setString(2, date.getText());
                  pst.setString(3, time.getText());
                  


                  pst.execute();
                  
                  pst.close();
                  
                  btnNewButton_2.setVisible(true);
                 
                  c_contact.requestFocus();
                }
                catch (Exception e1)
                { //JOptionPane.showMessageDialog(null, e1);
                
                  JOptionPane.showMessageDialog(null, "Invoice no.='" + invoice_no.getText() + "' Already Exist");
                  invoice_no.setText("");

                }
                


              }

        	
        	
        	  else
        	  {
            try
            {

              String query = "INSERT INTO m_customers (date, time) VALUES (parsedatetime(?, 'dd-MM-yyyy'),parsedatetime(?, 'HH:mm:ss'))";
              
              PreparedStatement ps = con.prepareStatement(query);

              ps.setString(1, date.getText());
              ps.setString(2, time.getText());

              ps.execute();
              ps.close();
              
              
              
              String sql = "select top 1 invoice_no from m_customers order by date desc, time desc";
              
              PreparedStatement pst = com.prepareStatement(sql);
              ResultSet rs = pst.executeQuery();
              
              while (rs.next())
              {
                invoice_no.setText(rs.getString("invoice_no"));
              }
              pst.close();
              rs.close();
              btnNewButton_2.setVisible(true);
              
              c_contact.requestFocus();
              invoice_no.setEditable(false);
            }
            catch (SQLException e1)
            {
              JOptionPane.showMessageDialog(null, "unexpected error");
              invoice_no.setText("");
            }
            
        	  }

          
          


        }
        

      }
      


    });
    invoice_no.setBounds(175, 11, 179, 20);
    panel.add(invoice_no);
    invoice_no.setColumns(10);
    
    JLabel lblCustomerContact = new JLabel("Customer Contact");
    lblCustomerContact.setForeground(Color.WHITE);
    lblCustomerContact.setHorizontalAlignment(SwingConstants.CENTER);
    lblCustomerContact.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblCustomerContact.setBounds(10, 40, 165, 20);
    panel.add(lblCustomerContact);
    
    c_name = new JTextField();
    c_name.setFont(new Font("Tahoma", 0, 17));
    


    c_name.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {




        if (e.getKeyCode() == 10)
        {
          
          c_address.requestFocus();

        }
        
      }
      

    });
    c_name.setColumns(10);
    c_name.setBounds(175, 65, 179, 20);
    panel.add(c_name);
    
    c_contact = new JTextField();
    c_contact.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        



      

          if (e.getKeyCode() == 10)
          {
        	  String check=c_contact.getText();
        	     String flag=c_name.getText();
        	     Boolean z;
        	        	  if(z=check.equals(flag))
        	        	  {
        	  
        	          		//  JOptionPane.showMessageDialog(null,z);
        	        		 // JOptionPane.showMessageDialog(null,"empty entry");
              	            
        			            c_name.requestFocus(); 
        	      
        	        	  }
        	        	  
        	        	  
        	        	  else {
        	        		  
        	        		  
        	        		  try {
        	        				
        	    				  
        	  					  String query = "select name from   patient_list where phone='"+c_contact.getText()+"'";
        	  					  PreparedStatement pst = con.prepareStatement(query);
        	  					  PreparedStatement pst1 = con.prepareStatement(query);
        	  						 
        	  					  ResultSet rst = pst.executeQuery();
        	  					  ResultSet rs=pst1.executeQuery();
        	  					  if(rst.next())
        	  					  {
        	  			    		  String sqlfinal = "select * from   patient_list where phone='"+c_contact.getText()+"' ";
        	  			    		  PreparedStatement psfinal = con.prepareStatement(sqlfinal);
        	  						  ResultSet rsfinal = psfinal.executeQuery();
        	  						  while(rsfinal.next())
        	  						  { 
        	  				    	  c_name.setText(rsfinal.getString("name"));

        	  				    	 

        	  				    	  c_address.setText(rsfinal.getString("add"));
        	  							  }
        	  				      
        	  				      psfinal.close();
        	  				      rsfinal.close();
        	  				      c_address.requestFocus(); 
        	  				     

        	  					  }
        	  					  else {
        	  			            c_name.requestFocus(); }

        	  						  
        	  					  
        	  					  
        	  				  

        	  			} catch (SQLException e1) {
        	  				// TODO Auto-generated catch block
        	  				JOptionPane.showMessageDialog(null, e1);
        	  				e1.printStackTrace();
        	  			}

        	        		     
        	        	       }

        	                 	  
        	  
        	  

          }



        
      }
      

    });
    c_contact.setFont(new Font("Tahoma", 0, 17));
    c_contact.setColumns(10);
    c_contact.setBounds(175, 40, 179, 20);
    panel.add(c_contact);
    







    JLabel lblTotalAmount_1 = new JLabel("Total Amount");
    lblTotalAmount_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblTotalAmount_1.setForeground(new Color(255, 255, 255));
    lblTotalAmount_1.setBorder(null);
    lblTotalAmount_1.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblTotalAmount_1.setBounds(1053, 486, 132, 23);
    panel.add(lblTotalAmount_1);
    
    TA = new JTextField();
    TA.setBackground(new Color(255, 204, 204));
    TA.setFont(new Font("Tahoma", 0, 17));
    TA.setColumns(10);
    TA.setBounds(1190, 486, 139, 23);
    panel.add(TA);
    
    JLabel lblTotalItems = new JLabel("Total Items");
    lblTotalItems.setHorizontalAlignment(SwingConstants.CENTER);
    lblTotalItems.setForeground(new Color(255, 255, 255));
    lblTotalItems.setBorder(null);
    lblTotalItems.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblTotalItems.setBounds(1076, 518, 109, 23);
    panel.add(lblTotalItems);
    
    TI = new JTextField();
    TI.setBackground(new Color(255, 204, 204));
    TI.setFont(new Font("Tahoma", 0, 17));
    TI.setColumns(10);
    TI.setBounds(1190, 518, 139, 23);
    panel.add(TI);
    





    date = new JTextField();
    date.setEditable(false);
    date.setBackground(Color.WHITE);
    date.setDisabledTextColor(Color.BLACK);
    date.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {










          time.requestFocus();
        }
        
      }
      
    });
    date.setFont(new Font("Tahoma", Font.PLAIN, 17));
    date.setBounds(1230, 11, 99, 20);
    panel.add(date);
    date.setColumns(10);
    
    time = new JTextField();
    time.setEditable(false);
    time.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() == 10)
        {










          invoice_no.requestFocus();

        }
        
      }
      

    });
    time.setBackground(Color.WHITE);
    time.setDisabledTextColor(Color.BLACK);
    
    time.setFont(new Font("Tahoma", Font.PLAIN, 17));
    time.setColumns(10);
    time.setBounds(1230, 40, 99, 20);
    panel.add(time);
    


    JLabel lblTime = new JLabel("Time");
    lblTime.setForeground(Color.WHITE);
    lblTime.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblTime.setBounds(1184, 40, 49, 20);
    panel.add(lblTime);
    
    timepmam = new JTextField();
    timepmam.setEditable(false);
    timepmam.setBackground(Color.WHITE);
    timepmam.setFont(new Font("Tahoma", Font.PLAIN, 17));
    timepmam.setColumns(10);
    timepmam.setBounds(1230, 65, 99, 20);
    panel.add(timepmam);
    
    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setBounds(24, 116, 78, 82);
    panel.add(lblNewLabel_1);
    lblNewLabel_1.setIcon(new ImageIcon(imgadd));
    


    JPanel panel_1 = new JPanel();
    panel_1.setBorder(new EtchedBorder(0, null, null));
    panel_1.setBackground(new Color(70, 130, 150));
    tabbedPane.addTab("ADD & DELETE PRODUCTS  ", null, panel_1, null);
    panel_1.setLayout(null);
    
    JLabel lblProductname = new JLabel("Product_Name");
    lblProductname.setHorizontalAlignment(SwingConstants.CENTER);
    lblProductname.setBorder(null);
    lblProductname.setForeground(new Color(255, 255, 255));
    lblProductname.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblProductname.setBounds(24, 197, 131, 20);
    panel_1.add(lblProductname);
    
    pName = new JTextField();
    pName.setFont(new Font("Tahoma", Font.PLAIN, 17));
    pName.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
    	  if (e.getKeyCode() == 10)
	        { pack.requestFocus();
	        }
    	  
              }
    });
    pName.setColumns(10);
    pName.setBounds(165, 197, 214, 20);
    panel_1.add(pName);
    

    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(new ImageIcon(i));
    lblNewLabel.setBounds(328, 56, 58, 88);
    panel_1.add(lblNewLabel);
    
   



    
    JScrollPane scrollPane_2 = new JScrollPane();
    scrollPane_2.setBounds(420, 56, 539, 461);
    panel_1.add(scrollPane_2);
    
    table_2 = new JTable();
    table_2.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) { try
        {
            int row = table_2.getSelectedRow();
        
           
            textField_28.setText(table_2.getModel().getValueAt(row, 0).toString());
            textField_1.setText(table_2.getModel().getValueAt(row, 1).toString());
            textField_29.setText(table_2.getModel().getValueAt(row, 2).toString());
            textField_31.setText(table_2.getModel().getValueAt(row, 5).toString());
            textField_31.requestFocus();
          }
          catch (Exception e)
          {
            JOptionPane.showMessageDialog(null, e);
          }
        
    		
    		
    		
    		
    	}
    });
    table_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
    table_2.setSelectionBackground(new Color(255,255,102));
    scrollPane_2.setViewportView(table_2);
    
    JButton btnNewButton_3 = new JButton("STOCK");
    btnNewButton_3.setBackground(new Color(70,130,150));
    btnNewButton_3.setForeground(new Color(255, 255, 255));
    Image stok = new ImageIcon(getClass().getResource("/productSmall.png")).getImage();
    btnNewButton_3.setIcon(new ImageIcon(stok));
   
    btnNewButton_3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    btnNewButton_3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        try {
          String sql = "select  * from m_items ORDER BY item_name ASC";
          
          PreparedStatement pst = com.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
          table_2.setModel(DbUtils.resultSetToTableModel(rs));
          
          pst.close();
          rs.close();
         combobox_items();

        }
        catch (SQLException e1)
        {

          e1.printStackTrace();
          JOptionPane.showMessageDialog(null, e1);
        }
        
      }
    });
    btnNewButton_3.setFont(new Font("Segoe Print", Font.BOLD, 16));
    btnNewButton_3.setBounds(653, 15, 107, 33);
    panel_1.add(btnNewButton_3);
    
    pack = new JTextField();
    pack.setFont(new Font("Tahoma", Font.PLAIN, 17));
    pack.setBackground(new Color(255,255,102));
    pack.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		if (arg0.getKeyCode() == 10)
	        { batch.requestFocus();
	        }
    	}
    });
    pack.setColumns(10);
    pack.setBounds(165, 235, 214, 20);
    panel_1.add(pack);
    
    batch = new JTextField();
    batch.setFont(new Font("Tahoma", Font.PLAIN, 17));
    batch.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		
    		if (arg0.getKeyCode() == 10)
	        { dateChooser_3.requestFocus();
	        }
    	}
    });
    batch.setColumns(10);
    batch.setBounds(165, 273, 214, 20);
    panel_1.add(batch);
    
    mrp = new JTextField();
    mrp.setFont(new Font("Tahoma", Font.PLAIN, 17));
    mrp.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent e) {
    		
    		if (e.getKeyCode() == 10)
            {
                    qty.requestFocus();        
            }

    		
    	}
    });
    mrp.setColumns(10);
    mrp.setBounds(165, 355, 214, 20);
    panel_1.add(mrp);
    
    JLabel lblHsnsac = new JLabel("PACK");
    lblHsnsac.setBorder(null);
    lblHsnsac.setForeground(new Color(255, 255, 255));
    lblHsnsac.setHorizontalAlignment(SwingConstants.CENTER);
    lblHsnsac.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblHsnsac.setBounds(63, 233, 92, 20);
    panel_1.add(lblHsnsac);
    
    JLabel lblQty = new JLabel("BATCH");
    lblQty.setBorder(null);
    lblQty.setForeground(new Color(255, 255, 255));
    lblQty.setHorizontalAlignment(SwingConstants.CENTER);
    lblQty.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblQty.setBounds(73, 273, 82, 20);
    panel_1.add(lblQty);
    
    JLabel lblRate = new JLabel("EXP DATE");
    lblRate.setBorder(null);
    lblRate.setForeground(new Color(255, 255, 255));
    lblRate.setHorizontalAlignment(SwingConstants.CENTER);
    lblRate.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblRate.setBounds(63, 314, 92, 20);
    panel_1.add(lblRate);
    
    JLabel label = new JLabel("Product_Name");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setForeground(Color.WHITE);
    label.setFont(new Font("Segoe Print", Font.BOLD, 16));
    label.setBorder(null);
    label.setBounds(985, 197, 131, 20);
    panel_1.add(label);
    
    textField_28 = new JTextField();
    textField_28.setEditable(false);
    textField_28.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_28.setColumns(10);
    textField_28.setBounds(1116, 197, 187, 20);
    panel_1.add(textField_28);
    
    JLabel lblBatch = new JLabel("BATCH");
    lblBatch.setHorizontalAlignment(SwingConstants.CENTER);
    lblBatch.setForeground(Color.WHITE);
    lblBatch.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblBatch.setBorder(null);
    lblBatch.setBounds(1025, 272, 92, 20);
    panel_1.add(lblBatch);
    
    textField_29 = new JTextField();
    textField_29.setEditable(false);
    textField_29.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_29.setColumns(10);
    textField_29.setBackground(new Color(255,255,102));
    textField_29.setBounds(1116, 274, 187, 20);
    panel_1.add(textField_29);
    
    JLabel lblMrp_1 = new JLabel("MRP");
    lblMrp_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblMrp_1.setForeground(Color.WHITE);
    lblMrp_1.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblMrp_1.setBorder(null);
    lblMrp_1.setBounds(1042, 314, 66, 20);
    panel_1.add(lblMrp_1);
    
    textField_31 = new JTextField();
    textField_31.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_31.setColumns(10);
    textField_31.setBounds(1116, 314, 187, 20);
    panel_1.add(textField_31);
    
    JButton button_5 = new JButton("Update");
    button_5.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		try
            {
    			
    			
              String query = "update m_items set mrp='"+textField_31.getText()+"'   where  item_name='"+textField_28.getText()+"' and pack='"+textField_1.getText()+"' and batch='"+textField_29.getText()+"' ";
              
              PreparedStatement pst = con.prepareStatement(query);
              

            
          
              

              

              pst.execute();
              
              pst.close();
             
             
              textField_28.setText("");   textField_29.setText(""); 
              textField_31.setText(""); 
              textField_1.setText(""); 
              
             
            }
            catch (Exception e1) {
            //.printStackTrace();
              JOptionPane.showMessageDialog(null, "Something Wrong !");
            }
            
            try
            {
              String sql = "select *  from m_items ORDER BY item_name ASC";
              
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
    button_5.setHorizontalAlignment(SwingConstants.LEFT);
    button_5.setForeground(Color.WHITE);
    button_5.setFont(new Font("Segoe Print", Font.BOLD, 14));
    button_5.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    button_5.setBackground(new Color(70, 130, 150));
    Image updateimg = new ImageIcon(getClass().getResource("/edit-icon.png")).getImage();
    button_5.setIcon(new ImageIcon(updateimg));
   
    button_5.setBounds(1211, 356, 95, 33);
    panel_1.add(button_5);
    
    JButton btnDelete = new JButton(" Delete");
    btnDelete.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		passwordField_delete.setVisible(true); lblNewLabel_6.setVisible(true);    passwordField_delete.requestFocus();
    		}
    });
    btnDelete.setForeground(Color.WHITE);
    btnDelete.setFont(new Font("Segoe Print", Font.BOLD, 14));
    Image removeimg = new ImageIcon(getClass().getResource("/remove.png")).getImage();
    btnDelete.setIcon(new ImageIcon(removeimg));
    btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    btnDelete.setBackground(new Color(70, 130, 150));
    btnDelete.setBounds(1211, 473, 95, 33);
    panel_1.add(btnDelete);
    
    JLabel lblAddNewProduct = new JLabel("Add New Product");
    lblAddNewProduct.setHorizontalAlignment(SwingConstants.CENTER);
    lblAddNewProduct.setForeground(Color.WHITE);
    lblAddNewProduct.setFont(new Font("Segoe Print", Font.BOLD, 30));
    lblAddNewProduct.setBorder(null);
    lblAddNewProduct.setBounds(35, 75, 295, 56);
    panel_1.add(lblAddNewProduct);
    
    JLabel lblUpdateStock = new JLabel("Update Stock");
    lblUpdateStock.setHorizontalAlignment(SwingConstants.LEFT);
    lblUpdateStock.setForeground(Color.WHITE);
    lblUpdateStock.setFont(new Font("Segoe Print", Font.BOLD, 30));
    lblUpdateStock.setBorder(null);
    lblUpdateStock.setBounds(1050, 75, 214, 56);
    panel_1.add(lblUpdateStock);
    
  /*  JPanel panel_3 = new JPanel();
    panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_3.setBounds(10, 56, 393, 461);
    panel_3.setBackground(new Color(70,130,150));
    panel_1.add(panel_3);
    */
    JLabel stock1 = new JLabel("");
    stock1.setBounds(1255, 65, 58, 70);
    Image stockimg = new ImageIcon(getClass().getResource("/edit item.png")).getImage();
    stock1.setIcon(new ImageIcon(stockimg));
   
    panel_1.add(stock1);
    
    lblNewLabel_6 = new JLabel("Enter Password!");
    lblNewLabel_6.setForeground(Color.WHITE);
    lblNewLabel_6.setFont(new Font("Segoe Print", Font.BOLD, 14));
    lblNewLabel_6.setVisible(false);
    lblNewLabel_6.setBounds(1087, 470, 119, 14);
    
    panel_1.add(lblNewLabel_6);
    
    passwordField_delete = new JPasswordField();
    passwordField_delete.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		
    		if(arg0.getKeyCode()==10)
    		{
    		 int action = JOptionPane.showConfirmDialog(null, "Delete item from STOCK?", textField_28.getText(), 0);
    		 
    		 if(action !=0) { 
    			 textField_28.setText("");   textField_29.setText(""); 
	              textField_31.setText(""); 
	            
	              passwordField_delete.setText(""); passwordField_delete.setVisible(false); lblNewLabel_6.setVisible(false); }
    		 
    		 
    		 
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
		                
		             String query = "Delete from m_items where item_name='"+textField_28.getText()+"' and pack='"+textField_1.getText()+"' and batch='"+textField_29.getText()+"'";
           
           PreparedStatement pst = con.prepareStatement(query);
           pst.execute();
           pst.close();
        	
           String sql = "select  * from m_items ORDER BY item_name ASC";
           
           PreparedStatement pt1 = com.prepareStatement(sql);
           ResultSet rs = pt1.executeQuery();
           table_2.setModel(DbUtils.resultSetToTableModel(rs));
           
           pt1.close();
           rs.close();

             textField_28.setText("");   textField_29.setText("");
             textField_31.setText(""); 
             textField_1.setText(""); 
             
             passwordField_delete.setText(""); passwordField_delete.setVisible(false); lblNewLabel_6.setVisible(false); 

             combobox_items();
		              }
  	        		
             else
             {
               JOptionPane.showMessageDialog(null, "Incorrect passoword!");
             }

  	        	 }catch(Exception e) {JOptionPane.showMessageDialog(null, "No item Selected!"); passwordField_delete.setText(""); passwordField_delete.setVisible(false); lblNewLabel_6.setVisible(false); 
  }
  	        	
  	        	
  	        	}

    		}

    		
    		
    	}
    });
    passwordField_delete.setBounds(1089, 487, 114, 18);
    passwordField_delete.setVisible(false);
    panel_1.add(passwordField_delete);
    
  /* JPanel panel_4 = new JPanel();
    panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    panel_4.setBounds(975, 56, 350, 461);
    panel_4.setBackground(new Color(70,130,150));
    panel_1.add(panel_4);
    */
    JLabel lblMrp = new JLabel("MRP");
    lblMrp.setHorizontalAlignment(SwingConstants.CENTER);
    lblMrp.setForeground(Color.WHITE);
    lblMrp.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblMrp.setBorder(null);
    lblMrp.setBounds(89, 356, 66, 20);
    panel_1.add(lblMrp);
    
    qty = new JTextField();
    qty.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		if(arg0.getKeyCode()==10)
    		{
    			
    			 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    		        String s = df.format(dateChooser_3.getDate());
    		       
    			try
                {
                  String query = "INSERT INTO m_items (item_NAME,pack,batch,exp,mrp,qty) VALUES (?,?,?,?,?,?)";
                  
                  PreparedStatement pst = con.prepareStatement(query);
                  

                  String uppercase = pName.getText().toUpperCase();
                  
                  pst.setString(1, uppercase);
                  
                  pst.setString(2, pack.getText());
                  pst.setString(3, batch.getText());
                  pst.setString(4, s);
                  pst.setString(5, mrp.getText());
                  pst.setString(6, qty.getText());
                  


                  pst.execute();
                  
                  pst.close();
                  combobox_items();

                  pName.setText("");   pack.setText(""); batch.setText(""); 
                  mrp.setText(""); qty.setText(""); pName.requestFocus();
                JTextComponent  editor_date = (JTextComponent)dateChooser_3.getDateEditor().getUiComponent();
                editor_date.setText("");
                }
                catch (SQLException e1) {
                  e1.printStackTrace();
                  JOptionPane.showMessageDialog(null, e1);
                }
                
                try
                {
                  String sql = "select  * from m_items ORDER BY item_name ASC";
                  
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
    	}
    });
    qty.setFont(new Font("Tahoma", Font.PLAIN, 17));
    qty.setColumns(10);
    qty.setBounds(165, 397, 214, 20);
    panel_1.add(qty);
    
    JLabel lblQty_1 = new JLabel("QTY");
    lblQty_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblQty_1.setForeground(Color.WHITE);
    lblQty_1.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblQty_1.setBorder(null);
    lblQty_1.setBounds(89, 397, 66, 20);
    panel_1.add(lblQty_1);
    
    dateChooser_3 = new JDateChooser();
    dateChooser_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
    dateChooser_3.setDateFormatString("dd-MM-yyy");
    dateChooser_3.setBounds(165, 314, 214, 20);
    panel_1.add(dateChooser_3);
    
    textField_1 = new JTextField();
    textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_1.setEditable(false);
    textField_1.setColumns(10);
    textField_1.setBounds(1116, 235, 187, 20);
    panel_1.add(textField_1);
    
    JLabel lblPack = new JLabel("PACK");
    lblPack.setHorizontalAlignment(SwingConstants.CENTER);
    lblPack.setForeground(Color.WHITE);
    lblPack.setFont(new Font("Segoe Print", Font.BOLD, 16));
    lblPack.setBorder(null);
    lblPack.setBounds(1035, 235, 95, 20);
    panel_1.add(lblPack);
    
   
    Image da = new ImageIcon(getClass().getResource("/deleteall.png")).getImage();
    Image dab = new ImageIcon(getClass().getResource("/deletebills.png")).getImage();
    
    Image dai = new ImageIcon(getClass().getResource("/deleteitems.png")).getImage();
    







    Image imglogout = new ImageIcon(getClass().getResource("/Logout24.png")).getImage();
    

    Image imgchangepass = new ImageIcon(getClass().getResource("/changeDetails.png")).getImage();
    
    textPane = new JTextPane();
    textPane.setBorder(null);
    textPane.setForeground(Color.BLACK);
    textPane.setFont(new Font("Courier New", Font.PLAIN, 11));
    textPane.setBounds(981, 532, 36, 23);
    panel.add(textPane);
    
    JLabel lblHsn = new JLabel("PACK");
    lblHsn.setForeground(new Color(255, 255, 255));
    lblHsn.setHorizontalAlignment(SwingConstants.CENTER);
    lblHsn.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblHsn.setBorder(null);
    lblHsn.setBounds(358, 172, 151, 20);
    panel.add(lblHsn);
    
    JLabel lblGst_1 = new JLabel("EXP DATE");
    lblGst_1.setForeground(new Color(255, 255, 255));
    lblGst_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblGst_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblGst_1.setBorder(null);
    lblGst_1.setBounds(594, 172, 157, 20);
    panel.add(lblGst_1);
    
    JLabel lblCgst_1 = new JLabel("MRP");
    lblCgst_1.setForeground(new Color(255, 255, 255));
    lblCgst_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblCgst_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblCgst_1.setBorder(null);
    lblCgst_1.setBounds(741, 172, 75, 20);
    panel.add(lblCgst_1);
    
    JLabel lblSgst_1 = new JLabel("RATE");
    lblSgst_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblSgst_1.setForeground(new Color(255, 255, 255));
    lblSgst_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblSgst_1.setBorder(null);
    lblSgst_1.setBounds(917, 172, 75, 20);
    panel.add(lblSgst_1);
    
    amount = new JTextField();
    amount.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		
    		
    		if(arg0.getKeyCode()== 10)
    		{
    			 
    			 
    	    	 try {      	                
    	    	 
    	                String query = "insert into m_invoicetable (p_name,pack,batch,exp,mrp,p_disc,p_qty,total,date,rate,i_no) values (?,?,?,?,?,?,?,?,parsedatetime(?, 'dd-MM-yyyy'),?,?)";
    	                
    	                
    	                
    	                PreparedStatement pst = con.prepareStatement(query);

    	                pst.setString(1, (String)comboBox.getSelectedItem());
    	                pst.setString(2, (String)P.getSelectedItem());
    	                pst.setString(3, B.getText());
    	                pst.setString(4, E.getText());
    	                pst.setString(5, M.getText());
    	                pst.setString(6, D.getText());
    	                pst.setString(7, Q.getText());
    	                pst.setString(8, amount.getText());
    	                pst.setString(9, date.getText());
    	                pst.setString(10, R.getText());
    	                pst.setString(11, invoice_no.getText());
    	                




    	                pst.execute();
    	                
    	                pst.close();
    	                




    	                DefaultTableModel model = (DefaultTableModel)table.getModel();
    	               model.addRow(new String[] { comboBox.getSelectedItem().toString(),(String)P.getSelectedItem(),B.getText(),E.getText(),M.getText(),D.getText(),R.getText(),Q.getText(), amount.getText()  });
    	                                                                         

    	                double d = Double.parseDouble(amount.getText());
    	                ta = (Math.round((ta + d) * 100.0D) / 100.0D);
    	                
    	                ti += 1;
    	                TI.setText(Integer.toString(ti));
    	                TA.setText(Double.toString(ta));
    	                




    	                stock=stock-bill;       
    	                String sql = "update m_items set qty = '"+stock+"'  where  item_name='"+(String)comboBox.getSelectedItem()+"' and pack='"+(String)P.getSelectedItem()+"' and batch='"+B.getText()+"' ";
    	                
    	                PreparedStatement ps = con.prepareStatement(sql);
    	               
    	                ps.execute();
    	                ps.close();
    	                
    	                P.removeAllItems();
    	                Q.setText("");
    	                D.setText("0");
    	                E.setText("");
    	                B.setText("");
    	                R.setText("");
    	                M.setText("");
    	                amount.setText("");

                       
    	              }


    	    	 
    	    	     
    	    	 catch(Exception e) {
    	    		 //JOptionPane.showMessageDialog(null, e);
    	    		 comboBox.requestFocus();
    	    		 }

    		}
    	}
    });
    amount.setBackground(new Color(255, 204, 204));
    amount.setHorizontalAlignment(SwingConstants.RIGHT);
    amount.setFont(new Font("Tahoma", Font.PLAIN, 18));
    amount.setColumns(10);
    amount.setBounds(1230, 196, 99, 20);
    panel.add(amount);
    
    JLabel lblTotalAmt = new JLabel("Amount");
    lblTotalAmt.setHorizontalAlignment(SwingConstants.CENTER);
    lblTotalAmt.setForeground(new Color(255, 255, 255));
    lblTotalAmt.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblTotalAmt.setBorder(null);
    lblTotalAmt.setBounds(1230, 172, 99, 20);
    panel.add(lblTotalAmt);
    
    M = new JTextField();
    M.setHorizontalAlignment(SwingConstants.RIGHT);
    M.setFont(new Font("Tahoma", Font.PLAIN, 18));
    M.setColumns(10);
    M.setBounds(740, 196, 75, 20);
    panel.add(M);
    
    R = new JTextField();
    R.setHorizontalAlignment(SwingConstants.RIGHT);
    R.setFont(new Font("Tahoma", Font.PLAIN, 18));
    R.setColumns(10);
    R.setBounds(917, 196, 75, 20);
    panel.add(R);
    

    JButton btnRemove = new JButton("REMOVE");
    
    btnRemove.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		 int action = JOptionPane.showConfirmDialog(null, "Remove item?", "Remove", 0);
    	        if (action == 0)
    	        {
    	            try {
    	            	int tempstock=0;
    	            	int tempbill=0;
    	            	int row = table.getSelectedRow();
    	        	 String qsql="select qty from m_items where pack ='"+table.getModel().getValueAt(row, 1).toString()+"' and item_name='"+table.getModel().getValueAt(row, 0).toString()+"' and batch='"+table.getModel().getValueAt(row, 2).toString()+"'";
    	             PreparedStatement qpst = com.prepareStatement(qsql);
    	             ResultSet qrs = qpst.executeQuery();
    	             
    	             while (qrs.next())
    	             {
    	           	  tempstock=Integer.parseInt(qrs.getString("qty"));
    	             }
    	             qpst.close();
    	             qrs.close();
    	             
    	             String s;
    	             
    	            s=  table.getModel().getValueAt(row, 7).toString();
    	            tempbill=Integer.parseInt(s);
    	            tempstock=tempstock+tempbill;
    	          
    	            String sql = "update m_items set qty = '"+tempstock+"'   where pack ='"+table.getModel().getValueAt(row, 1).toString()+"' and item_name='"+table.getModel().getValueAt(row, 0).toString()+"' and batch='"+table.getModel().getValueAt(row, 2).toString()+"'";
    	            PreparedStatement ps = con.prepareStatement(sql);
    	            ps.execute();
    	            ps.close();
    	            
    	            
    	        	
    	        	
    	        	
    	            
    	            
    	            String query = "Delete from m_invoicetable where i_no='" + invoice_no.getText() + "' and pack ='"+table.getModel().getValueAt(row, 1).toString()+"' and p_name='"+table.getModel().getValueAt(row, 0).toString()+"' and batch='"+table.getModel().getValueAt(row, 2).toString()+"'";
    	            
    	            PreparedStatement pst = con.prepareStatement(query);
    	            pst.execute();
    	            ti -= 1;
    	            TI.setText(Integer.toString(ti));

    	          
    	          


    	          DefaultTableModel model = (DefaultTableModel)table.getModel();
    	          

    	          
    	          //  int SelectedRowIndex = table.getSelectedRow();
    	            
    	            double d = Double.parseDouble(TA.getText());
    	            double tempamt = Double.parseDouble(table.getModel().getValueAt(row, 8).toString());
    	            

    	            ta = (Math.round((d - tempamt) * 100.0D) / 100.0D);
    	            

    	            TA.setText(Double.toString(ta));
    	            
    	            model.removeRow(row);
    	            comboBox.requestFocus();
    	          }
    	          catch (Exception ex) { JOptionPane.showMessageDialog(null, ex);
    	            JOptionPane.showMessageDialog(null, "No Item selected!");
    	          }
    	          
    	        }
    		
    	}
    });
    btnRemove.setForeground(new Color(255, 255, 255));
    btnRemove.setFont(new Font("Segoe Print", Font.BOLD, 16));
    btnRemove.setBackground(new Color(70, 130, 150));
    btnRemove.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    btnRemove.setBounds(30, 486, 114, 33);

    Image removimg = new ImageIcon(getClass().getResource("/remove.png")).getImage();
    btnRemove.setIcon(new ImageIcon(removimg));
   
    panel.add(btnRemove);
    
    JButton btnPrintInvoice = new JButton("Print Invoice");
    btnPrintInvoice.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		try
            {

              double gt = Double.parseDouble(TA.getText());
              ti = Integer.parseInt(TI.getText());
              String in = invoice_no.getText();
              

              String query = " update m_customers set grand_total = '" + gt + "' , total_items='" + ti + "' where invoice_no='" + in + "'";
              
              PreparedStatement pst = con.prepareStatement(query);
              

              pst.execute();  
              pst.close();
              printinvoice(in);
              textPane.setText("");
              btnNewButton_2.setVisible(false);
              
              ti = 0;
              ta = 0.0D;
              
              TI.setText("");
              TA.setText("");
              invoice_no.setText("");
              c_name.setText("");
              c_contact.setText("");
              c_address.setText("");
             
              invoice_no.requestFocus();
              table.setModel(new DefaultTableModel(null, new String[] {
            		  "Name","PACK", "BATCH",  "EXP", "MRP","DISC","RATE","QTY","Amount" }));
            }
            catch (Exception e2)
            {
              JOptionPane.showMessageDialog(null, "Invoice number missing");


            }
            

    		
    		
    	}
    });
    btnPrintInvoice.setForeground(Color.WHITE);
    btnPrintInvoice.setFont(new Font("Segoe Print", Font.BOLD, 16));
    btnPrintInvoice.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    btnPrintInvoice.setBackground(new Color(70, 130, 150));
    btnPrintInvoice.setBounds(584, 486, 150, 33);
    Image printimg = new ImageIcon(getClass().getResource("/printSmall.png")).getImage();
    btnPrintInvoice.setIcon(new ImageIcon(printimg));
   
    panel.add(btnPrintInvoice);
    
    JLabel lblCustomerAddress = new JLabel("Customer Address");
    lblCustomerAddress.setHorizontalAlignment(SwingConstants.CENTER);
    lblCustomerAddress.setForeground(Color.WHITE);
    lblCustomerAddress.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblCustomerAddress.setBounds(14, 90, 155, 20);
    panel.add(lblCustomerAddress);
    
    c_address = new JTextField();
    c_address.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent e) {
    		
    		
            if (e.getKeyCode() == 10)
            {


              try
              {


                String query = "update m_customers set cust_name = ?  , cust_phone= ? , address=? where invoice_no= '"+invoice_no.getText()+"' ";
                

               

                PreparedStatement pst = con.prepareStatement(query);
                




                pst.setString(1, c_name.getText());
                pst.setString(2, c_contact.getText());
                pst.setString(3, c_address.getText());
                


                pst.execute();
                
                pst.close();
                
                comboBox.requestFocus();

              }
              catch (SQLException e1)
              {
                JOptionPane.showMessageDialog(null, e1);

              }
              

            }

    	}
    });
    c_address.setFont(new Font("Tahoma", Font.PLAIN, 17));
    c_address.setColumns(10);
    c_address.setBounds(175, 93, 289, 20);
    panel.add(c_address);
    
    B = new JTextField();
    B.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent e) {
    		

            if (e.getKeyCode() == 10)
            {
            	 
                 Q.requestFocus();
          	  
                      }

    		
    		
    	}
    });
    B.setFont(new Font("Tahoma", Font.PLAIN, 16));
    B.setHorizontalAlignment(SwingConstants.RIGHT);
    B.setBounds(502, 197, 100, 20);
    B.setBackground(new Color(255, 255, 102));
    panel.add(B);
    B.setColumns(10);
    
    JLabel lblNewLabel_2 = new JLabel("SKIN, HAIR & NAIL CLINIC");
    lblNewLabel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
    lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
    lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
    lblNewLabel_2.setForeground(new Color(255, 255, 102));
    lblNewLabel_2.setBounds(518, 15, 565, 47);
    panel.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("MEDICAL BILLING PAGE");
    lblNewLabel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
    lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
    lblNewLabel_3.setForeground(Color.WHITE);
    lblNewLabel_3.setBounds(700, 60, 230, 29);
    panel.add(lblNewLabel_3);
    
    JLabel lblNewLabel_5 = new JLabel("(\u20B9)");
    lblNewLabel_5.setForeground(Color.WHITE);
    lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    lblNewLabel_5.setBounds(878, 169, 36, 25);
    panel.add(lblNewLabel_5);
    
    JButton btnSave = new JButton("Save Invoice");
    btnSave.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		try
            {

              double gt = Double.parseDouble(TA.getText());
              ti = Integer.parseInt(TI.getText());
              String in = invoice_no.getText();
              

              String query = " update m_customers set grand_total = '" + gt + "' , total_items='" + ti + "' where invoice_no='" + in + "'";
              
              PreparedStatement pst = con.prepareStatement(query);
              

              pst.execute();  
              pst.close();
             
              btnNewButton_2.setVisible(false);
              
              ti = 0;
              ta = 0.0D;
              
              TI.setText("");
              TA.setText("");
              invoice_no.setText("");
              c_name.setText("");
              c_contact.setText("");
              c_address.setText("");
            
              invoice_no.requestFocus();
              table.setModel(new DefaultTableModel(null, new String[] {
            		  "Name","PACK", "BATCH",  "EXP", "MRP","DISC","RATE","QTY","Amount" }));
            }
            catch (Exception e2)
            {
              JOptionPane.showMessageDialog(null, "Invoice number missing");


            }

    		
    		
    	}
    });
    btnSave.setForeground(Color.WHITE);
    btnSave.setFont(new Font("Segoe Print", Font.BOLD, 16));
    btnSave.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    btnSave.setBackground(new Color(70, 130, 150));
    Image saveimg = new ImageIcon(getClass().getResource("/save.png")).getImage();
    btnSave.setIcon(new ImageIcon(saveimg));
   
    btnSave.setBounds(787, 486, 150, 33);
    panel.add(btnSave);
    
    P = new JComboBox();
    P.setFont(new Font("Tahoma", Font.PLAIN, 17));
    P.setBounds(368, 196, 114, 20);  
    P.getEditor().getEditorComponent().addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e) {
        
        if (e.getKeyChar() == 10)
        {
        	try
        	{
        		
        		String sql="Select batch,exp,mrp from m_items where item_name='"+(String)comboBox.getSelectedItem()+"' and pack='"+(String)P.getSelectedItem()+"'";
         	   
 				PreparedStatement pst = con.prepareStatement(sql);
 				ResultSet rs=pst.executeQuery();
 				while(rs.next())
 				{
 		
 					B.setText(rs.getString("batch"));
 					E.setText(rs.getString("exp"));
 					M.setText(rs.getString("mrp"));
 					
 					
 					
 					
 					
 				}
 			
        	
        	D.requestFocus();
          
        	}
        	catch(Exception ex)
        	{ JOptionPane.showMessageDialog(null, ex);}


        }
        


      }
      



    });

  
    panel.add(P);
    
    JLabel label_2 = new JLabel("Dr. BABU's");
    label_2.setHorizontalAlignment(SwingConstants.LEFT);
    label_2.setForeground(Color.WHITE);
    label_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
    label_2.setBounds(520, 1, 142, 29);
    panel.add(label_2);
    
    
    
    JPanel panel_2 = new JPanel();
    panel_2.setBackground(new Color(70,130,150));
    tabbedPane.addTab("BILLS HISTORY ", null, panel_2, null);
    panel_2.setLayout(null);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(0, 108, 581, 396);
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
          String sql = "select i_no ,p_name,pack, batch,exp,mrp,p_disc,rate,p_qty,total  from m_invoicetable where i_no='" + sid + "'";
          
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
    	new Object[][] {
    	},
    	new String[] {
    	}
    ));
    scrollPane_1.setViewportView(table_1);
    
    JButton btnLoadDetaila = new JButton("Load Details");
    btnLoadDetaila.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnLoadDetaila.setForeground(Color.WHITE);
    btnLoadDetaila.setBackground(new Color(70, 130, 150));
    btnLoadDetaila.setFont(new Font("Segoe Print", Font.BOLD, 15));
    btnLoadDetaila.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        try {
          String sql = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name , CUST_phone,address,total_items,grand_total from m_customers order by date desc, time desc";
          
          PreparedStatement pst = com.prepareStatement(sql);
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
        		  "I_NO", "P_Name","PACK","BATCH", "EXP", "MRP", "P_Disc","RATE", "P_QTY" ,  "TOTAL"})); 



      }
      



    });
    btnLoadDetaila.setBounds(10, 64, 132, 33);
    Image loadimg = new ImageIcon(getClass().getResource("/folder-invoices.png")).getImage();
    btnLoadDetaila.setIcon(new ImageIcon(loadimg));
  
    panel_2.add(btnLoadDetaila);
    
    dateChooser = new JDateChooser();
    dateChooser.getCalendarButton().addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {}

    });
    dateChooser.setBounds(586, 35, 113, 20);
    panel_2.add(dateChooser);
    
    dateChooser.setDateFormatString("dd-MM-yyy");
    dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 14));
    
    JLabel searchby = new JLabel("Search By Invoice:");
    searchby.setForeground(Color.WHITE);
    searchby.setFont(new Font("Segoe Print", Font.BOLD, 15));
    searchby.setBounds(167, 31, 147, 27);
    panel_2.add(searchby);
    
    textField_2 = new JTextField();
    textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_2.setBackground(new Color(255, 255, 102));
    textField_2.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {
          try
          {
            int i = Integer.parseInt(textField_2.getText());
            String sql = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name , CUST_phone,address,total_items,grand_total from  M_customers  where INvoice_no='" + i + "'  order by date desc,time desc";
            
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
            		  "I_NO", "P_Name","PACK","BATCH", "EXP", "MRP", "P_Disc","RATE", "P_QTY" ,  "TOTAL"}));

        }
        

      }
      


    });
    textField_2.setBounds(315, 35, 94, 20);
    panel_2.add(textField_2);
    textField_2.setColumns(10);
    
    JLabel lblSearchByDate = new JLabel("Search By Date:");
    lblSearchByDate.setForeground(Color.WHITE);
    lblSearchByDate.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblSearchByDate.setBounds(449, 31, 132, 27);
    panel_2.add(lblSearchByDate);
    
    JButton button = new JButton("Load");
    button.setForeground(Color.WHITE);
    button.setFont(new Font("Segoe Print", Font.BOLD, 12));
    button.setBackground(new Color(70, 130, 150));
    button.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    button.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String s = df.format(dateChooser.getDate());
        

        try
        {
          String sql = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name , CUST_phone,address,total_items,grand_total  from  M_customers   where date=parsedatetime(?, 'dd-MM-yyyy') order by date asc,time desc";
          
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
        		  "I_NO", "P_Name","PACK","BATCH", "EXP", "MRP", "P_Disc","RATE", "P_QTY" ,  "TOTAL"}));


      }
      



    });
    button.setBounds(635, 70, 64, 20);
    panel_2.add(button);
    
    final JDateChooser dateChooser_1 = new JDateChooser();
    dateChooser_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    dateChooser_1.setDateFormatString("dd-MM-yyy");
    dateChooser_1.setBounds(895, 35, 102, 20);
    panel_2.add(dateChooser_1);
    
    final JDateChooser dateChooser_2 = new JDateChooser();
    dateChooser_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    dateChooser_2.setDateFormatString("dd-MM-yyy");
    dateChooser_2.setBounds(1062, 35, 139, 20);
    panel_2.add(dateChooser_2);
    
    JButton button_2 = new JButton("Load");
    button_2.setForeground(Color.WHITE);
    button_2.setFont(new Font("Segoe Print", Font.BOLD, 12));
    button_2.setBackground(new Color(70, 130, 150));
    button_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    button_2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String s1 = df.format(dateChooser_1.getDate());
        String s2 = df.format(dateChooser_2.getDate());
        


        try
        {
          String sql = "select INVOICe_no,TO_CHAR(date,'DD-MM-YYYY'),time,cUST_name , CUST_phone,address,total_items,grand_total  from  M_customers where   date  between parsedatetime(?, 'dd-MM-yyyy') and parsedatetime(?, 'dd-MM-yyyy') order by date desc,time desc";
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
        		  "I_NO", "P_Name","PACK","BATCH", "EXP", "MRP", "P_Disc","RATE", "P_QTY" ,  "TOTAL"}));

      }
      


    });
    button_2.setBounds(1137, 70, 64, 20);
    panel_2.add(button_2);
    
    JLabel lblSearchBwDate = new JLabel("Search B/W Date:");
    lblSearchBwDate.setForeground(Color.WHITE);
    lblSearchBwDate.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblSearchBwDate.setBounds(738, 31, 147, 27);
    panel_2.add(lblSearchBwDate);
    
    JLabel lblAnd = new JLabel("AND");
    lblAnd.setForeground(Color.WHITE);
    lblAnd.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblAnd.setBounds(1007, 31, 45, 27);
    panel_2.add(lblAnd);
    
    JPanel panel_7 = new JPanel();
    panel_7.setBackground(new Color(70, 130, 150));
    panel_7.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_7.setBounds(152, 11, 268, 87);
    panel_2.add(panel_7);
    
    JPanel panel_8 = new JPanel();
    panel_8.setBackground(new Color(70, 130, 150));
    panel_8.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_8.setBounds(430, 11, 284, 87);
    panel_2.add(panel_8);
    
    JPanel panel_9 = new JPanel();
    panel_9.setBackground(new Color(70, 130, 150));
    panel_9.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_9.setBounds(724, 11, 511, 87);
    panel_2.add(panel_9);
    
    JScrollPane scrollPane_3 = new JScrollPane();
    scrollPane_3.setBounds(591, 108, 653, 396);
    panel_2.add(scrollPane_3);
    
    table_3 = new JTable();
    table_3.setSelectionBackground(new Color(255,255,102));
    table_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
    table_3.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent me)
      {
        try
        {
          int row = table_3.getSelectedRow();
        
          textField_5.setText(table_3.getModel().getValueAt(row, 0).toString());
          textField_8.setText(table_3.getModel().getValueAt(row, 1).toString());
          textField_22.setText(table_3.getModel().getValueAt(row, 2).toString());
          textField_10.setText(table_3.getModel().getValueAt(row, 3).toString());
          textField_11.setText(table_3.getModel().getValueAt(row, 4).toString());
          textField_20.setText(table_3.getModel().getValueAt(row, 5).toString());
          textField_12.setText(table_3.getModel().getValueAt(row, 6).toString());
          textField_18.setText(table_3.getModel().getValueAt(row, 7).toString());
          tempquantity.setText(table_3.getModel().getValueAt(row, 8).toString());
          
               
          
          textField_9.requestFocus();
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
        
      }
      
    });
    table_3.setModel(new DefaultTableModel(
      new Object[0][], 
      
      new String[] {
    		  "I_NO", "P_Name","PACK","BATCH", "EXP", "MRP", "P_Disc","RATE", "P_QTY" ,  "TOTAL"}));
    

    scrollPane_3.setViewportView(table_3);
    
    textField_8 = new JTextField();
    textField_8.setEditable(false);
    textField_8.setBackground(Color.WHITE);
    textField_8.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {



          textField_9.requestFocus();
        }
        
      }
      

    });
    textField_8.setBounds(1254, 167, 80, 20);
    panel_2.add(textField_8);
    textField_8.setColumns(10);
    
    textField_9 = new JTextField();
    textField_9.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_9.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent e)
      {
                
    	  if (e.getKeyCode() == 10)
          {
    	    	
    	    		bill=0;
    	        stock=0;

    		  
             try {
            	 
            	 
            	
            	   String sql="select qty from m_items where item_name='"+textField_8.getText()+"' and pack='"+textField_22.getText()+"' and batch='"+textField_10.getText()+"'";
                   PreparedStatement ps= com.prepareStatement(sql);   
                   
                   ResultSet rs=ps.executeQuery();
                   
            if (rs.next())
            {
          	  stock=Integer.parseInt(rs.getString("qty"));
            
            ps.close();
            rs.close();
            stock=stock+Integer.parseInt(textField_9.getText());//adding return quantity to stock
            bill=Integer.parseInt(tempquantity.getText())-Integer.parseInt(textField_9.getText());
         
         if(bill<=stock )
         {
      	  
        	 try
             {

               double rate = Double.parseDouble(textField_18.getText());
               
              
               double sum=0;
                      sum =rate*bill;
                      sum = Math.round(sum * 100.0D) / 100.0D;
              
               textField_21.setText(Double.toString(sum));
               btnUpdate.requestFocus();
              

             }
             catch (Exception e2)
             {

               JOptionPane.showMessageDialog(null, "Enter valid number");
               textField_9.requestFocus();

             }

        	 
        	 
        	 
           
      	   
         }
          
         else { JOptionPane.showMessageDialog(null, "OUT OF STOCK!");}
         
            
            } 
            
            
            
            else { throw new Exception();}
      		   
          	} catch(Exception e1) {
          		
          		
          	//	JOptionPane.showMessageDialog(null, "ITEM NOT FOUND IN STOCK!");
          		try
                {
          			String query = "INSERT INTO m_items (item_NAME,pack,batch,exp,mrp,qty) VALUES (?,?,?,?,?,?)";
                    
                    PreparedStatement pst = con.prepareStatement(query);
                    

                    String qtyzero="0";
                    
                    pst.setString(1, textField_8.getText());
                    
                    pst.setString(2,  textField_22.getText());
                    pst.setString(3,  textField_10.getText());
                    pst.setString(4,  textField_11.getText());
                    pst.setString(5,  textField_20.getText());
                    pst.setString(6,  qtyzero);
                    


                    pst.execute();
                    
                    pst.close();
                    combobox_items();

          			
          			
          			
          			
          			
          		                  
                  bill=Integer.parseInt(tempquantity.getText())-Integer.parseInt(textField_9.getText());
                  stock=stock+Integer.parseInt(textField_9.getText());
                  double rate = Double.parseDouble(textField_18.getText());
                  
                  
                  double sum=0;
                         sum =rate*bill;
                         sum = Math.round(sum * 100.0D) / 100.0D;
                 
                  textField_21.setText(Double.toString(sum));
                  btnUpdate.requestFocus();
                 
                  
                }
                catch (Exception x) {
                  x.printStackTrace();
                  JOptionPane.showMessageDialog(null, x);
                }

          	
          	
          	
          	
          	
          	
          	
          	
          	}
          
    	    	
             
             
             
             
             
             
             
             
    	    	}
          


      }
      

    });
    textField_9.setColumns(10);
    textField_9.setBounds(1254, 413, 80, 20);
    panel_2.add(textField_9);
    
    textField_10 = new JTextField();
    textField_10.setBackground(new Color(255,255,102));
    textField_10.setEditable(false);
    textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_10.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_10.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent e)
      {

        if (e.getKeyCode() == 10)
        {



          textField_11.requestFocus();
        }
        

               

      }
      

    });
    textField_10.setColumns(10);
    textField_10.setBounds(1254, 236, 80, 20);
    panel_2.add(textField_10);
    
    

   
    textField_11 = new JFormattedTextField();
    textField_11.setEditable(false);
    textField_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_11.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {
        	
        textField_9.requestFocus();
        }
        








        
      }
      

    });
    textField_11.setColumns(10);
    textField_11.setBounds(1254, 271, 80, 20);
    panel_2.add(textField_11);
    
    textField_12 = new JTextField();
    textField_12.setEditable(false);
    textField_12.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_12.setFont(new Font("Tahoma", Font.PLAIN, 17));
       textField_12.setColumns(10);
    textField_12.setBounds(1254, 340, 80, 20);
    panel_2.add(textField_12);
    
    JLabel lblPname = new JLabel("P_NAME");
    lblPname.setHorizontalAlignment(SwingConstants.CENTER);
    lblPname.setForeground(Color.WHITE);
    lblPname.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblPname.setBounds(1254, 152, 80, 14);
    panel_2.add(lblPname);
    
    JLabel lblP = new JLabel("EXP");
    lblP.setHorizontalAlignment(SwingConstants.CENTER);
    lblP.setForeground(Color.WHITE);
    lblP.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblP.setBounds(1250, 256, 70, 14);
    panel_2.add(lblP);
    
    JLabel lblPprice = new JLabel("BATCH");
    lblPprice.setHorizontalAlignment(SwingConstants.CENTER);
    lblPprice.setForeground(Color.WHITE);
    lblPprice.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblPprice.setBounds(1254, 222, 74, 14);
    panel_2.add(lblPprice);
    
    JLabel lblPdisc = new JLabel("MRP");
    lblPdisc.setHorizontalAlignment(SwingConstants.CENTER);
    lblPdisc.setForeground(Color.WHITE);
    lblPdisc.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblPdisc.setBounds(1254, 291, 80, 14);
    panel_2.add(lblPdisc);
    
    
    
    
    
    
    btnUpdate = new JButton("UPDATE");
    btnUpdate.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnUpdate.setForeground(Color.WHITE);
    btnUpdate.setBackground(new Color(70, 130, 150));
    btnUpdate.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0) {
        int row = table_3.getSelectedRow();
       
        double total = Double.parseDouble(table_3.getModel().getValueAt(row, 9).toString());
        
        
        if( bill==0) {   
        	
        	double gt = 0.0D;
            int ti=0;
   try { String query = "update m_invoicetable set P_Qty='" + bill + "', total='"+textField_21.getText()+"' where i_no ='" + textField_5.getText() + "' and p_name='"+textField_8.getText()+"' and pack='"+textField_22.getText()+"' and batch='"+textField_10.getText()+"'";
	          PreparedStatement pst = con.prepareStatement(query);
	          pst.execute();
	          pst.close();
	          

	   
	   
String qy = "update m_items set qty='"+stock+"' where item_name='"+textField_8.getText()+"' and pack='"+textField_22.getText()+"' and batch='"+textField_10.getText()+"' ";
              
              PreparedStatement p = con.prepareStatement(qy);

              p.execute();
              p.close();
     
	   
	     
	   
	   
	   
            String query1 = "select  grand_total ,total_items from m_customers where invoice_no='" + textField_5.getText() + "' ";
            PreparedStatement pst1 = con.prepareStatement(query1);
            ResultSet rs = pst1.executeQuery();
            while (rs.next())
            {

              gt = Double.parseDouble(rs.getString("GRAND_TOTAL"));
              ti=Integer.parseInt(rs.getString("total_items"));
            }
            
            pst1.close();
            rs.close();
            



            gt -= total;
            ti -=1;
            
            gt = Math.round((gt) * 100.0D) / 100.0D;
            





            String sql = "update m_customers set grand_total='" + gt + "' , total_items ='"+ti+"' where invoice_no='" + textField_5.getText() + "'";
            
            PreparedStatement pst2 = com.prepareStatement(sql);
            pst2.execute();
            pst2.close();
            
            String mzr="Delete from m_invoicetable  where  i_no='"+textField_5.getText()+"'  and p_qty='"+0+"'";
            PreparedStatement zr = com.prepareStatement(mzr);
            zr.execute();
            zr.close();
          
            
            
            
            

            String sql1 = " select i_no ,p_name,pack, batch,exp,mrp,p_disc,rate,p_qty,total from m_invoicetable where i_no='" + textField_5.getText() + "'";
            
            PreparedStatement pst3 = com.prepareStatement(sql1);
            ResultSet rs1 = pst3.executeQuery();
            table_3.setModel(DbUtils.resultSetToTableModel(rs1));
            
            pst3.close();
            rs1.close();
            


         

            String sql2 = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name , CUST_phone,address,total_items,grand_total from m_customers where invoice_no='" + textField_5.getText() + "'";
            
            PreparedStatement pt = com.prepareStatement(sql2);
            ResultSet r = pt.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(r));
            
            pt.close();
            r.close();
            textField_8.setText("");
            textField_9.setText("");
            textField_10.setText("");
            textField_11.setText("");
            textField_12.setText("");
            textField_22.setText("");
            
            textField_20.setText("");
            textField_21.setText("");
            textField_8.setText("");
            textField_18.setText("");
            
   } catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
        	
        	
        }
        
        else {   
        
        try
        {
        	
  String qy = "update m_items set qty='"+stock+"' where item_name='"+textField_8.getText()+"' and pack='"+textField_22.getText()+"' and batch='"+textField_10.getText()+"' ";
              
              PreparedStatement p = con.prepareStatement(qy);

              p.execute();
              p.close();

        	
        	
        	
 String query = "update m_invoicetable set P_Qty='" + bill + "', total='"+textField_21.getText()+"' where i_no ='" + textField_5.getText() + "' and p_name='"+textField_8.getText()+"' and pack='"+textField_22.getText()+"' and batch='"+textField_10.getText()+"' ";
 		
 PreparedStatement pst = con.prepareStatement(query);
          pst.execute();
          pst.close();
          



          double gt = 0.0D;
          

          String query1 = "select  grand_total from m_customers where invoice_no='" + textField_5.getText() + "' ";
          PreparedStatement pst1 = con.prepareStatement(query1);
          ResultSet rs = pst1.executeQuery();
          while (rs.next())
          {

            gt = Double.parseDouble(rs.getString("GRAND_TOTAL"));
          }
          
          pst1.close();
          rs.close();
          



          gt -= total;
          double amt = Double.parseDouble(textField_21.getText());
          gt = Math.round((gt + amt) * 100.0D) / 100.0D;
          





          String sql = "update m_customers set grand_total='" + gt + "' where invoice_no='" + textField_5.getText() + "'";
          
          PreparedStatement pst2 = com.prepareStatement(sql);
          pst2.execute();
          pst2.close();
          






          String sql1 = " select i_no ,p_name,pack, batch,exp,mrp,p_disc,rate,p_qty,total from m_invoicetable where i_no='" + textField_5.getText() + "'";
          
          PreparedStatement pst3 = com.prepareStatement(sql1);
          ResultSet rs1 = pst3.executeQuery();
          table_3.setModel(DbUtils.resultSetToTableModel(rs1));
          
          pst3.close();
          rs1.close();
          


       

          String sql2 = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name , CUST_phone,address,total_items,grand_total from m_customers where invoice_no='" + textField_5.getText() + "'";
          
          PreparedStatement pt = com.prepareStatement(sql2);
          ResultSet r = pt.executeQuery();
          table_1.setModel(DbUtils.resultSetToTableModel(r));
          
          pt.close();
          r.close();
          textField_8.setText("");
          textField_9.setText("");
          textField_10.setText("");
          textField_11.setText("");
          textField_12.setText("");
          textField_22.setText("");
          
          textField_20.setText("");
          textField_21.setText("");
          textField_8.setText("");
          textField_18.setText("");



        }
        catch (Exception e1)
        {

  //        e1.printStackTrace();
          JOptionPane.showMessageDialog(null, "Error something wrong");

        }
        }

      }
      


    });
    btnUpdate.setFont(new Font("Segoe Print", Font.BOLD, 11));
    btnUpdate.setBounds(1254, 493, 80, 20);
    panel_2.add(btnUpdate);
    
    JLabel lblReturnnbox = new JLabel("RETURN");
    lblReturnnbox.setHorizontalAlignment(SwingConstants.LEFT);
    lblReturnnbox.setForeground(Color.WHITE);
    lblReturnnbox.setBounds(1254, 533, 80, 20);
    lblReturnnbox.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 16));
    panel_2.add(lblReturnnbox);
    
    JLabel lblReturnnbox_1 = new JLabel("BOX");
    lblReturnnbox_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblReturnnbox_1.setForeground(Color.WHITE);
    lblReturnnbox_1.setBounds(1254, 547, 80, 20);
    lblReturnnbox_1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 14));
    panel_2.add(lblReturnnbox_1);
  
    
    JButton cancelInvoice = new JButton("Cancel Invoice");
    cancelInvoice.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		CancelInvoice cp = new CancelInvoice();
            cp.setVisible(true);

    	}
    });
    cancelInvoice.setBackground(new Color(70, 130, 150));
    cancelInvoice.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    cancelInvoice.setForeground(Color.WHITE);
    Image returnimg = new ImageIcon(getClass().getResource("/back.png")).getImage();
    cancelInvoice.setIcon(new ImageIcon(returnimg));
   

    cancelInvoice.setFont(new Font("Segoe Print", Font.BOLD, 15));
    cancelInvoice.setBounds(972, 512, 140, 33);
    panel_2.add(cancelInvoice);
    
    JButton btnAdd = new JButton("Add");
    btnAdd.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnAdd.setForeground(Color.WHITE);
    btnAdd.setBackground(new Color(70,130,150));
    btnAdd.setEnabled(false);
    btnAdd.setVisible(false);
    btnAdd.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String sid;
        try {
          sid = table_3.getModel().getValueAt(0, 0).toString();
        }
        catch (Exception e1) {
          try {
            
            int row = table_1.getSelectedRow();
            sid = table_1.getModel().getValueAt(row, 0).toString();
          } catch (Exception l) { 
            sid = table_1.getModel().getValueAt(0, 0).toString();
          }
        }
        try {
          String query = "insert into invoicetable (p_name,p_price,p_qty,p_disc,p_amt , i_no) values (?,?,?,?,?,?)";
          
          PreparedStatement pst = con.prepareStatement(query);
          



          pst.setString(1, textField_8.getText());
          pst.setString(2, textField_10.getText());
          pst.setString(3, textField_9.getText());
          pst.setString(4, textField_11.getText());
          pst.setString(5, textField_12.getText());
          pst.setString(6, sid);
          




          pst.execute();
          
          pst.close();
          

          double gt = 0.0D;
          int t = 0;
          
          String query1 = "select  grand_total , total_items from customers where invoice_no='" + sid + "' ";
          PreparedStatement pst1 = con.prepareStatement(query1);
          ResultSet rs1 = pst1.executeQuery();
          while (rs1.next())
          {

            gt = Double.parseDouble(rs1.getString("GRAND_TOTAL"));
            t = Integer.parseInt(rs1.getString("TOTAL_ITEMS"));
          }
          
          pst1.close();
          rs1.close();
          




          double amt = Double.parseDouble(textField_12.getText());
          gt = Math.round((gt + amt) * 100.0D) / 100.0D;
          
          t++;
          




          String sql = "update customers set grand_total='" + gt + "' ,  total_items='" + t + "'where invoice_no='" + sid + "'";
          
          PreparedStatement pst2 = com.prepareStatement(sql);
          pst2.execute();
          pst2.close();
          



          String sql2 = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name , CUST_phone,total_items,grand_total from customers where invoice_no='" + sid + "'";
          
          PreparedStatement pt = com.prepareStatement(sql2);
          ResultSet r = pt.executeQuery();
          table_1.setModel(DbUtils.resultSetToTableModel(r));
          
          pt.close();
          r.close();
          


          String sql1 = "select i_no ,p_name,p_qty,p_price,p_disc ,p_amt from invoicetable where i_no='" + sid + "'";
          
          PreparedStatement pst3 = com.prepareStatement(sql1);
          ResultSet rs2 = pst3.executeQuery();
          table_3.setModel(DbUtils.resultSetToTableModel(rs2));
          
          pst3.close();
          rs2.close();
          

          textField_8.setText("");
          textField_9.setText("");
          textField_10.setText("");
          textField_11.setText("");
          textField_12.setText("");


        }
        catch (SQLException e1)
        {


          JOptionPane.showMessageDialog(null, "Enter Data carefully");

        }
        

      }
      


    });
    btnAdd.setFont(new Font("Segoe Print", Font.BOLD, 11));
    btnAdd.setBounds(826, 556, 80, 20);
    panel_2.add(btnAdd);
    
    JLabel lblPamt_1 = new JLabel("P_DISC");
    lblPamt_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblPamt_1.setForeground(Color.WHITE);
    lblPamt_1.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblPamt_1.setBounds(1254, 327, 64, 14);
    panel_2.add(lblPamt_1);
    



    JLabel lblPrintInvoice = new JLabel("Print Invoice:");
    lblPrintInvoice.setForeground(Color.WHITE);
    lblPrintInvoice.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblPrintInvoice.setBounds(601, 512, 119, 27);
    panel_2.add(lblPrintInvoice);
    
    textField_13 = new JTextField();
    textField_13.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_13.setBackground(new Color(255,255,102));
    textField_13.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent arg0)
      {
        if (arg0.getKeyCode() == 10)
        {
          String ino = textField_13.getText();
          printinvoice(ino);
          textPane.setText("");
          
          textField_13.setText("");
        }
        
      }
      

    });
    textField_13.setColumns(10);
    textField_13.setBounds(711, 517, 94, 20);
    panel_2.add(textField_13);
    
    JLabel lblGst = new JLabel("RATE");
    lblGst.setHorizontalAlignment(SwingConstants.CENTER);
    lblGst.setForeground(Color.WHITE);
    lblGst.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblGst.setBounds(1254, 361, 70, 14);
    panel_2.add(lblGst);
    
    JLabel lblCgst = new JLabel("RETURN_QTY");
    lblCgst.setHorizontalAlignment(SwingConstants.LEFT);
    lblCgst.setForeground(Color.WHITE);
    lblCgst.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblCgst.setBounds(1254, 398, 91, 14);
    panel_2.add(lblCgst);
    
    JLabel lblTotal = new JLabel("TOTAL");
    lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
    lblTotal.setForeground(Color.WHITE);
    lblTotal.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblTotal.setBounds(1255, 435, 54, 14);
    panel_2.add(lblTotal);
    
    textField_18 = new JTextField();
    textField_18.setEditable(false);
    textField_18.setForeground(Color.BLACK);
    textField_18.setBackground(new Color(255,255,102));
    textField_18.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_18.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_18.setColumns(10);
    textField_18.setBounds(1254, 376, 80, 20);
    panel_2.add(textField_18);
    
    textField_20 = new JTextField();
    textField_20.setEditable(false);
    textField_20.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_20.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_20.setColumns(10);
    textField_20.setBounds(1254, 306, 80, 20);
    panel_2.add(textField_20);
    
    textField_21 = new JTextField();
    textField_21.setEditable(false);
    textField_21.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_21.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_21.setColumns(10);
    textField_21.setBounds(1254, 450, 80, 20);
    panel_2.add(textField_21);
    
    JLabel lblHsnsac_1 = new JLabel("PACK");
    lblHsnsac_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblHsnsac_1.setForeground(Color.WHITE);
    lblHsnsac_1.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblHsnsac_1.setBounds(1254, 188, 80, 14);
    panel_2.add(lblHsnsac_1);
    
    textField_22 = new JTextField();
    textField_22.setEditable(false);
    textField_22.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_22.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_22.setColumns(10);
    textField_22.setBounds(1254, 203, 80, 20);
    textField_22.setBackground(Color.WHITE);
    panel_2.add(textField_22);
    
    textField_5 = new JTextField();
    textField_5.setEditable(false);
    textField_5.setBackground(Color.WHITE);
    textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_5.setColumns(10);
    textField_5.setBounds(1254, 132, 80, 20);
    panel_2.add(textField_5);
    
    JLabel lblInvoice = new JLabel("INVOICE_NO");
    lblInvoice.setForeground(Color.WHITE);
    lblInvoice.setFont(new Font("Segoe Print", Font.BOLD, 11));
    lblInvoice.setBounds(1254, 115, 80, 14);
    panel_2.add(lblInvoice);
    

    JPanel panel_11 = new JPanel();
    panel_11.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    panel_11.setBackground(new Color(70, 130, 150));
    panel_11.setBounds(1247, 107, 98, 462);
    panel_2.add(panel_11); 
    
    
    
    tempquantity = new JTextField();
    tempquantity.setBorder(null);
    tempquantity.setBackground(new Color(70,130,150));
    tempquantity.setBounds(1289, 57, 6, 20);
    panel_2.add(tempquantity);
    tempquantity.setColumns(10);
    
    JLabel lblDeleteInvoice = new JLabel("Delete Invoice:");
    lblDeleteInvoice.setForeground(Color.WHITE);
    lblDeleteInvoice.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblDeleteInvoice.setBounds(10, 512, 119, 27);
    panel_2.add(lblDeleteInvoice);
    
    textField_3 = new JTextField();
    textField_3.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent e) {
    		if(e.getKeyCode()==10)
    		{
    		lblEnterPassword.setVisible(true);
    		textField_4.setVisible(true); textField_4.requestFocus();
    		    	}}
    });
    textField_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_3.setColumns(10);
    textField_3.setBackground(new Color(255, 255, 102));
    textField_3.setBounds(120, 517, 94, 20);
    panel_2.add(textField_3);
    
    textField_4 = new JPasswordField();
    textField_4.setVisible(false);
    textField_4.addKeyListener(new KeyAdapter() {
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
		              pt.setString(1, textField_4.getText());
		             
		              ResultSet r = pt.executeQuery();
		              if (r.next())
		              {
                       pt.close();
		                r.close();
		            
                	
                  String query = "delete from customers where invoice_no=?";
                  
                  PreparedStatement pst = con.prepareStatement(query);
                  



                  pst.setString(1, textField_3.getText());
                  


                  pst.execute();
                  
                  pst.close();
                
                   query = "delete from invoicetable where i_no=?";
                  
                   pst = con.prepareStatement(query);
                  



                  pst.setString(1, textField_3.getText());
                  


                  pst.execute();
                  
                  pst.close();
                


                  String sql = "select INVOICe_no,to_char(date,'DD-MM-YYYY'),time,cUST_name ,CUST_phone,total_items,grand_total from  customers   order by date desc,time desc";
                  
                   pst = com.prepareStatement(sql);
                  ResultSet rs = pst.executeQuery();
                  table_1.setModel(DbUtils.resultSetToTableModel(rs));
                  
                  pst.close();
                  rs.close();


                  textField_3.setText(""); 
                  textField_4.setVisible(false);
                  textField_4.setText("");
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
    textField_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_4.setColumns(10);
    textField_4.setBackground(new Color(255, 255, 102));
    textField_4.setBounds(141, 545, 94, 20);
    panel_2.add(textField_4);
    
    lblEnterPassword = new JLabel("Enter Password");
    lblEnterPassword.setForeground(Color.WHITE);
    lblEnterPassword.setVisible(false);
    lblEnterPassword.setFont(new Font("Segoe Print", Font.BOLD, 15));
    lblEnterPassword.setBounds(10, 538, 132, 27);
    panel_2.add(lblEnterPassword);
    

    
    JPanel panel_report = new JPanel();
    tabbedPane.addTab(" REPORTS ", null, panel_report, null);
    panel_report.setBackground(new Color(70,130,150));
    
    panel_report.setLayout(null);
    
    JScrollPane scrollPane_5 = new JScrollPane();
    scrollPane_5.setBounds(44, 90, 1114, 396);
    panel_report.add(scrollPane_5);
    
    JTable table_6 = new JTable();
    scrollPane_5.setViewportView(table_6);
    
    JLabel lblSeeReportBw = new JLabel("See Report B/W Date:");
    lblSeeReportBw.setForeground(Color.WHITE);
    lblSeeReportBw.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblSeeReportBw.setBounds(328, 25, 165, 27);
    panel_report.add(lblSeeReportBw);
    
    JDateChooser dateChooser_3_1 = new JDateChooser();
    dateChooser_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
    dateChooser_3_1.setDateFormatString("dd-MM-yyy");
    dateChooser_3_1.setBounds(499, 29, 100, 20);
    panel_report.add(dateChooser_3_1);
    
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
    
    
    JTextField t_amount = new JTextField();
    t_amount.setFont(new Font("Tahoma", Font.PLAIN, 18));
    t_amount.setEditable(false);
    t_amount.setColumns(10);
    t_amount.setBounds(851, 512, 86, 20);
    panel_report.add(t_amount);
    
      
      JTextField t_services = new JTextField();
      t_services.setFont(new Font("Tahoma", Font.PLAIN, 18));
      t_services.setEditable(false);
      t_services.setBounds(372, 512, 86, 20);
      panel_report.add(t_services);
      t_services.setColumns(10);
      
        
        
        JButton button_report = new JButton("Load");
        button_report.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        	        String s1 = df.format(dateChooser_3_1.getDate());
        	        String s2 = df.format(dateChooser_4.getDate());
        	        
                   int ts=0;
                   double ta=0;

        	        try
        	        {
        	          String sql = "select i_no ,p_name, pack, total  from m_invoicetable where   date  between parsedatetime(?, 'dd-MM-yyyy') and parsedatetime(?, 'dd-MM-yyyy') order by p_name";
        	          String sql1 = "select i_no ,p_name, pack, total  from m_invoicetable where   date  between parsedatetime(?, 'dd-MM-yyyy') and parsedatetime(?, 'dd-MM-yyyy') order by p_name";
         	         
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
        	        	  
        	        			tamt=rs1.getString("total");
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
        button_report.setForeground(Color.WHITE);
        button_report.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
        button_report.setBackground(new Color(70,130,150));
        button_report.setBounds(692, 64, 64, 20);
        panel_report.add(button_report);
        
        JLabel lblTotalNoOf = new JLabel("     Total No. of Items:");
        lblTotalNoOf.setForeground(Color.WHITE);
        lblTotalNoOf.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTotalNoOf.setBounds(203, 507, 170, 27);
        panel_report.add(lblTotalNoOf);
        
        JLabel lblTotalAmount_2 = new JLabel("Total Amount:");
        lblTotalAmount_2.setForeground(Color.WHITE);
        lblTotalAmount_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTotalAmount_2.setBounds(721, 507, 109, 27);
        panel_report.add(lblTotalAmount_2);
        
        JLabel lblNewLabel_4_1 = new JLabel("(\u20B9)");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1.setForeground(Color.WHITE);
        lblNewLabel_4_1.setBounds(825, 510, 46, 20);
        panel_report.add(lblNewLabel_4_1);
    

    JPanel panel_6 = new JPanel();
    tabbedPane.addTab("Reset Data Factory", null, panel_6, null);
    panel_6.setBackground(new Color(70, 130, 150));
    panel_6.setLayout(null);
    





    JButton btnDeleteAllItems = new JButton("Delete All Bills");
    btnDeleteAllItems.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnDeleteAllItems.setBackground(new Color(70,130,150));
    btnDeleteAllItems.setForeground(Color.WHITE);
    btnDeleteAllItems.setIcon(new ImageIcon(dab));
    btnDeleteAllItems.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
    	  
    		enterpass.setVisible(true);
        	textpass.setVisible(true);
               textpass.requestFocus();
      }
      

    });
    btnDeleteAllItems.setFont(new Font("Segoe Print", Font.BOLD, 17));
    btnDeleteAllItems.setBounds(138, 111, 226, 60);
    panel_6.add(btnDeleteAllItems);
    
    JButton button_1 = new JButton("Delete All Items");
    button_1.setBackground(new Color(70, 130, 150));
    button_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    button_1.setForeground(Color.WHITE);
    button_1.setIcon(new ImageIcon(dai));
    button_1.addActionListener(new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
    	  
    	  passwordField.setVisible(true);
    	  lblNewLabel_4.setVisible(true);
    	  
    	  passwordField.requestFocus();

        
      }
      

    });
    button_1.setFont(new Font("Segoe Print", Font.BOLD, 17));
    button_1.setBounds(490, 111, 208, 60);
    panel_6.add(button_1);
    
    enterpass = new JLabel("Enter your Password!");
    enterpass.setForeground(Color.WHITE);
    enterpass.setFont(new Font("Segoe Print", Font.BOLD, 17));
    enterpass.setBounds(138, 180, 226, 23);
    enterpass.setVisible(false);
    panel_6.add(enterpass);
    
    textpass = new JPasswordField();
    textpass.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		
    		if(arg0.getKeyCode()==10)
    		{ 
    			 int action = JOptionPane.showConfirmDialog(null, "All Billing History will be Deleted!", "Delete All?", 0);
    		       
    			 if(action !=0) { textpass.setText("");
		            enterpass.setVisible(false);
		            textpass.setVisible(false); }
    			 
    			 
    			 if (action == 0)
    		        {

    		          try
    		          {
    		        	  String query = "select * from admintable where  PASSWORD=?";
    		              
    		              PreparedStatement pst = con.prepareStatement(query);
    		              pst.setString(1, textpass.getText());
    		             
    		              ResultSet rs = pst.executeQuery();
    		              if (rs.next())
    		              {
                            pst.close();
    		                rs.close();
    		                
    		                
    		                String sql = " DELETE FROM m_customers ";
        		            PreparedStatement pt = con.prepareStatement(sql);
        		            pt.execute();
        		            pt.close();
        		            
        		            
        		            String sql1 = " DELETE FROM m_invoicetable";
        		            PreparedStatement pt1 = con.prepareStatement(sql1);
        		            pt1.execute();
        		            pt1.close();
        		            
        		            
        		            textpass.setText("");
        		            enterpass.setVisible(false);
        		            textpass.setVisible(false);
        		           
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
    textpass.setBounds(138, 207, 226, 20);
    textpass.setVisible(false);
    panel_6.add(textpass);
    
    lblNewLabel_4 = new JLabel("Enter your Password!");
    lblNewLabel_4.setForeground(Color.WHITE);
    lblNewLabel_4.setFont(new Font("Segoe Print", Font.BOLD, 17));
    lblNewLabel_4.setBounds(490, 182, 226, 23);
    lblNewLabel_4.setVisible(false);
    panel_6.add(lblNewLabel_4);
    
    passwordField = new JPasswordField();
    passwordField.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    	
    		
    		if(arg0.getKeyCode()==10)
    		{
            int action = JOptionPane.showConfirmDialog(null, "All Items will be erased", "Delete All Data?", 0);
            
            
            if(action !=0) { 
            	
            	 passwordField.setText("");
		            lblNewLabel_4.setVisible(false);
		            passwordField.setVisible(false);
		           
            }
            
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
		                
		                
		                String sql = " DELETE FROM m_items";
		                
		                PreparedStatement pt = con.prepareStatement(sql);
		                
		                pt.execute();
		                
		                pt.close();
		                
		                
		                combobox_items();
		                        
    		            passwordField.setText("");
    		            lblNewLabel_4.setVisible(false);
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
    passwordField.setBounds(490, 207, 208, 20);
    passwordField.setVisible(false);
    panel_6.add(passwordField);
    
      
    table_4 = new JTable();
    table_4.setModel(new DefaultTableModel(
    	new Object[][] {
    	},
    	new String[] {
    	}
    ));
    

    table_4.setBounds(75, 42, 1, 1);
    contentPane.add(table_4);
    
    
    
    button_4 = new JButton("Change Password");
    button_4.setForeground(new Color(255, 255, 255));
    button_4.setBackground(new Color(70, 130, 150));
    button_4.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    button_4.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		ChangePassword cp = new ChangePassword();
            cp.setVisible(true);

    	}
    });
    button_4.setIcon(new ImageIcon(imgchangepass));
    button_4.setFont(new Font("Segoe Print", Font.BOLD, 15));
    button_4.setBounds(30, 632, 192, 33);
    contentPane.add(button_4);
    
    
    JButton btnPatientEntry = new JButton("PATIENT ENTRY");
    btnPatientEntry.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		
 TasksRaw t = new TasksRaw();
             
           dispose();
             t.setVisible(true);
    	}
    });
    btnPatientEntry.setForeground(new Color(255, 255, 255));
    btnPatientEntry.setFont(new Font("Segoe Print", Font.BOLD, 15));
    btnPatientEntry.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    btnPatientEntry.setBounds(680, 630, 192, 36);
    btnPatientEntry.setBackground(new Color(70,130,150));
    contentPane.add(btnPatientEntry);
    Image picon = new ImageIcon(getClass().getResource("/pficon.png")).getImage();
    btnPatientEntry.setIcon(new ImageIcon(picon));
   
    
    
    JButton button_3 = new JButton("Logout");
    button_3.setForeground(new Color(255, 255, 255));
    button_3.setIcon(new ImageIcon(imglogout));
    button_3.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		dispose();
            new LoginPage().frame.setVisible(true);
    		
    	}
    });
    button_3.setBackground(new Color(70, 130, 150));
    button_3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    button_3.setFont(new Font("Segoe Print", Font.BOLD, 15));
    button_3.setBounds(1210, 632, 131, 33);
    contentPane.add(button_3);
    
    JPanel panel_12 = new JPanel();
    panel_12.setBackground(new Color(70, 130, 150));
    panel_12.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), null, null));
    panel_12.setBounds(12, 625, 1342, 45);
    contentPane.add(panel_12);
    
    
 /*  JTextField t_services = new JTextField();
    t_services.setFont(new Font("Tahoma", Font.PLAIN, 18));
    t_services.setEditable(false);
    t_services.setBounds(372, 512, 86, 20);
    panel_report.add(t_services);
    t_services.setColumns(10); */
    
  /*  JTextField t_amount = new JTextField();
    t_amount.setFont(new Font("Tahoma", Font.PLAIN, 18));
    t_amount.setEditable(false);
    t_amount.setColumns(10);
    t_amount.setBounds(851, 512, 86, 20);
    panel_report.add(t_amount); */

    
    combobox_items();
    currentdate();
 
  }
}
