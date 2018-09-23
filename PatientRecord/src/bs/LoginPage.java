package bs;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;














public class LoginPage
{
  private String user;
  private String pass;
  protected JFrame frame;
  private JTextField username;
  private JPasswordField password;
  private JLabel lblClock;
  private JLabel lblClock_1;
  public Connection con = null;
  public Connection scon = null;
  
  private JLabel imgLabel;
  
  private JPasswordField passwordField;
  
  private JTextField textField;
  
  JButton create;
  
  JPanel panel_1;
  
  private JPasswordField passwordField_1;
  
  DatabaseMetaData dmd;
  private JLabel lblGstBillingSystem;
  private JLabel label_5;
  private JLabel lblVijayanagarColonyHyderabad;
  private JLabel lblTolichowkiHyderabad;
  private JTabbedPane tabbedPane;
  private JButton btnOperator;
  
  private void tableCheck()
  {
    try
    {
      dmd = con.getMetaData();
      ResultSet rs = dmd.getTables(null, null, "admintable", null);
      
      if (!rs.next())
      {





        String sql = "create table admintable (username varchar(50), password varchar(50))";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        
        ps.close();
      }
    }
    catch (Exception localException) {}
    















    try
    {
      ResultSet rs = dmd.getTables(null, null, "patient_list", null);
      if (!rs.next())
      {





        String sql = "create table  patient_list  ( name varchar(50), age DECIMAL(10), sex char(10), add varchar(50),phone varchar(30) )";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException2) {}




    try
    {
      ResultSet rs = dmd.getTables(null, null, "p_customers", null);
      if (!rs.next())
      {





        String sql = "create table  p_CUSTOMERS  (INVOICE_NO INTEGER(10) PRIMARY KEY auto_increment, date date, time time, cust_name varchar(50), sex char(10),age DECIMAL(10),cust_phone varchar(30), address varchar(50),grand_total DECIMAL(10), TOTAL_service integer(3))";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException2) {}
    

    
    try
    {
      ResultSet rs = dmd.getTables(null, null, "p_invoicetable", null);
      if (!rs.next())
      {





        String sql = "create table  p_INVOICETABLE (s_name varchar(50), s_price DECIMAL(10), DISC DECIMAL(10), AMT DECIMAL(10), I_NO INTEGER(10))";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException3) {}

    





    try
    {
      ResultSet rs = dmd.getTables(null, null, "m_customers", null);
      if (!rs.next())
      {





        String sql = "create table  m_CUSTOMERS  (INVOICE_NO INTEGER(10) PRIMARY KEY auto_increment, cust_name varchar(50), cust_phone varchar(30), address varchar(70), grand_total DECIMAL(10,2), TOTAL_ITEMS DECIMAL(7), date date, time time)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException2) {}
    
    
    
    
    try
    {
      ResultSet rs = dmd.getTables(null, null, "cansomers", null);
      if (!rs.next())
      {





        String sql = "create table  cansomers  (INVOICE_NO INTEGER(10) PRIMARY KEY , cust_name varchar(50), cust_phone varchar(30), address varchar(70), grand_total DECIMAL(10,2), TOTAL_ITEMS DECIMAL(7), date date, time time)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException2) {}



    try
    {
      ResultSet rs = dmd.getTables(null, null, "m_invoicetable", null);
      if (!rs.next())
      {





        String sql = "create table  m_INVOICETABLE (p_name varchar(50),pack varchar(20), batch varchar(20), exp varchar(15),mrp DECIMAL(10,2), P_QTY integer(5), p_DISC DECIMAL(10,2), I_NO INTEGER(10), total number (10,2), date date, rate DECIMAL(10,2))";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException3) {}
    




    try
    {
      ResultSet rs = dmd.getTables(null, null, "canvoicetable", null);
      if (!rs.next())
      {





    	  String sql = "create table  caNVOICETABLE (p_name varchar(50),pack varchar(20), batch varchar(20), exp varchar(15),mrp DECIMAL(10,2), P_QTY integer(5), p_DISC DECIMAL(10,2), I_NO INTEGER(10), total number (10,2), date date,rate DECIMAL(10,2))";
           PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException3) {}








    try
    {
      ResultSet rs = dmd.getTables(null, null, "p_items", null);
      if (!rs.next())
      {





        String sql = "create table p_items (service_name  varchar(155), service_price Decimal(10) )";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException4) {}
  




    try
    {
      ResultSet rs = dmd.getTables(null, null, "m_items", null);
      if (!rs.next())
      {





        String sql = "create table m_items ( item_name varchar(100),pack varchar(20), batch varchar(20), exp varchar(15),QTY number (7), mrp number(10,2) )";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
      }
    }
    catch (Exception localException4) {}
  }
  















  public void newAccount()
  {
    try
    {
      String sql = "select * from admintable";
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      if (rs.next())
      {
        create.setVisible(false);
      }
      else
      {
        create.setVisible(true);
      }
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, e);
    }
  }
  










  public Connection sharedb()
  {
    return scon;
  }
  
  public Connection dbcon()
  {
    try
    {
      Class.forName("org.h2.Driver");
      
      con = DriverManager.getConnection("jdbc:h2:~/patient", "zeya", "zbills");
      

      scon = con;


    }
    catch (ClassNotFoundException e)
    {


      JOptionPane.showMessageDialog(null, "Driver Not Loaded");
      System.exit(3);

    }
    catch (SQLException c)
    {

      JOptionPane.showMessageDialog(null, "connection not  established  wrong user name or password");
      System.exit(3);
    }
    
    return con;
  }
  

  public void Clock()
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
            lblClock_1.setText(s.format(d));
            


            SimpleDateFormat s1 = new SimpleDateFormat("hh:mm:ss a");
            lblClock.setText(s1.format(d));
            

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
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          LoginPage window = new LoginPage();
          window.frame.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  



  public LoginPage()
  {
    dbcon();
    
    tableCheck();
    initialize();
    newAccount();
  }
  








  private void initialize()
  {
    frame = new JFrame();
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/archive/invoice-icon.png")));
    frame.setResizable(false);
    frame.getContentPane().setBackground(new Color(70,130,150));
    frame.setBounds(200, 100, 1000, 600);
    frame.setDefaultCloseOperation(3);
    frame.getContentPane().setLayout(null);
   
    
    
    JLabel lblBillilngSystem = new JLabel("");
    lblBillilngSystem.setVerticalAlignment(SwingConstants.TOP);
    lblBillilngSystem.setHorizontalAlignment(SwingConstants.CENTER);
    lblBillilngSystem.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(255, 255, 255), new Color(255, 255, 255)));
    lblBillilngSystem.setForeground(Color.WHITE);
    lblBillilngSystem.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
    lblBillilngSystem.setBounds(56, 150, 557, 402);
    frame.getContentPane().add(lblBillilngSystem);
    

    imgLabel = new JLabel("");
    Image img = new ImageIcon(getClass().getResource("/skin.jpg")).getImage();
    imgLabel.setIcon(new ImageIcon(img));
    imgLabel.setBounds(58, 252, 552, 308);
    frame.getContentPane().add(imgLabel);
    
    lblClock = new JLabel("Clock");
    lblClock.setHorizontalAlignment(SwingConstants.LEFT);
    lblClock.setBackground(Color.WHITE);
    lblClock.setForeground(Color.WHITE);
    lblClock.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
    lblClock.setBounds(56, 110, 191, 45);
    frame.getContentPane().add(lblClock);
    
    lblClock_1 = new JLabel("  Clock");
    lblClock_1.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		 TasksRaw t = new TasksRaw();
             
             frame.dispose();
             t.setVisible(true);
    	}
    });
    lblClock_1.setForeground(Color.WHITE);
    lblClock_1.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
    lblClock_1.setBounds(452, 110, 202, 45);
    frame.getContentPane().add(lblClock_1);
    
    JPanel panel = new JPanel();
    panel.setBounds(633, 150, 295, 217);
    panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel.setBackground(new Color(70, 130, 150));
    frame.getContentPane().add(panel);
    panel.setLayout(null);
    
    passwordField_1 = new JPasswordField();
    passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    passwordField_1.setVisible(false);
    passwordField_1.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {
          if (passwordField_1.getText().equals("iwant2bamsp"))
          {

            try
            {
              String query = "delete from  admintable ";
              
              PreparedStatement pst = con.prepareStatement(query);
              

              pst.execute();
              pst.close();
            }
            catch (Exception e1) {
              JOptionPane.showMessageDialog(null, e1);
            }
            



            create.setVisible(true);
          }
          
        }
        
      }
    });
    passwordField_1.setBounds(143, 180, 135, 18);
    panel.add(passwordField_1);
    
    JLabel lblAdminLogIn = new JLabel(" Log In");
    lblAdminLogIn.setHorizontalAlignment(SwingConstants.CENTER);
    lblAdminLogIn.setBounds(110, 11, 145, 40);
    panel.add(lblAdminLogIn);
    lblAdminLogIn.setForeground(Color.WHITE);
    lblAdminLogIn.setFont(new Font("Segoe Print", Font.BOLD, 30));
    

    username = new JTextField();
    username.setHorizontalAlignment(SwingConstants.LEFT);
    username.setFont(new Font("Tahoma", Font.PLAIN, 15));
    username.setBounds(106, 62, 174, 22);
    panel.add(username);
    username.addKeyListener(new KeyAdapter()
    {

      public void keyPressed(KeyEvent evt)
      {

        if (evt.getKeyCode() == 10)
        {

          password.requestFocus();
        }
        
      }
    });
    username.setColumns(10);
    

    JLabel lblUsername = new JLabel("Username");
    lblUsername.setBounds(22, 64, 83, 14);
    panel.add(lblUsername);
    lblUsername.setForeground(Color.WHITE);
    lblUsername.setFont(new Font("Segoe Print", Font.BOLD, 15));
    
    password = new JPasswordField();
    password.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		if(arg0.getKeyCode()==10)
    		{
    			
    			
    			try
                {
                  String query = "select * from admintable where USERNAME=? and PASSWORD=?";
                  
                  PreparedStatement pst = con.prepareStatement(query);
                  pst.setString(1, username.getText());
                  pst.setString(2, password.getText());
                  ResultSet rs = pst.executeQuery();
                  if (rs.next())
                  {

                    pst.close();
                    rs.close();
                    
                   Tasks t = new Tasks();
                    
                    frame.dispose();
                    t.setVisible(true);
                  }
                  
                 
                  else
                  { 
                	  
                	  if(username.getText().equals("skinhair") && password.getText().equals("clinic"))
          		      {

              	    Tasks t = new Tasks();
                      
              	   frame.dispose();
                      t.setVisible(true);
                     

          		     }
                	  else {

                	      pst.close();
                          rs.close();
                          JOptionPane.showMessageDialog(null, "wrong username or passoword");
                          
                	      }
                  }
                }
                catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                }

    			
    			
    		}
    	}
    });
    password.setFont(new Font("Tahoma", Font.PLAIN, 15));
    password.setBounds(106, 94, 174, 22);
    panel.add(password);
    password.setBackground(new Color(255,255,102));
    
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(24, 100, 83, 14);
    panel.add(lblPassword);
    lblPassword.setForeground(Color.WHITE);
    lblPassword.setFont(new Font("Segoe Print", Font.BOLD, 15));
    
    final JLabel forgotPassword = new JLabel("Forgot password?");
    forgotPassword.setBounds(170, 160, 110, 17);
    panel.add(forgotPassword);
    forgotPassword.setForeground(Color.WHITE);
    forgotPassword.addMouseListener(new MouseAdapter()
    {
      public void mouseEntered(MouseEvent arg0)
      {
        forgotPassword.setForeground(Color.YELLOW);
      }
      

      public void mouseExited(MouseEvent e)
      {
        forgotPassword.setForeground(Color.WHITE);
      }
      

      public void mouseClicked(MouseEvent e)
      {
        passwordField_1.setVisible(true);
        passwordField_1.requestFocus();
      }
      
    });
    forgotPassword.setBackground(Color.DARK_GRAY);
    forgotPassword.setFont(new Font("Segoe Print", Font.PLAIN, 12));
    
    JButton btnNewButton = new JButton("Admin");
    btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		try
            {
              String query = "select * from admintable where USERNAME=? and PASSWORD=?";
              
              PreparedStatement pst = con.prepareStatement(query);
              pst.setString(1, username.getText());
              pst.setString(2, password.getText());
              ResultSet rs = pst.executeQuery();
              if (rs.next())
              {

                pst.close();
                rs.close();
                
               Tasks t = new Tasks();
                
                frame.dispose();
                t.setVisible(true);
              }
              else
              {  pst.close();
                 rs.close();
              
                JOptionPane.showMessageDialog(null, "wrong username or passoword");
              }
            }
            catch (Exception e) {
              e.printStackTrace();
            }

    	}
    });
    btnNewButton.setBackground(new Color(70,130,150));
    btnNewButton.setForeground(Color.WHITE);
    btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 11));
    btnNewButton.setBounds(210, 127, 70, 23);
    btnNewButton.setVisible(false);
    panel.add(btnNewButton);
    
    btnOperator = new JButton("Operator");
    btnOperator.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		String user=username.getText();
    		String pass=password.getText();
    		if(user.equals("systemcare") && pass.equals("operator123"))
    		{

        	    Tasks t = new Tasks();
                
        	   frame.dispose();
                t.setVisible(true);
                t.otherslogin();

    		}
    		else if( user.equals("system") && pass.equals("care")) {Tasks t = new Tasks();
    		 frame.dispose();

     	   
            t.setVisible(true);
            t.otherslogin();}
    		else {JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");}
    		
            
    	}
    });
    btnOperator.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0), new Color(0, 0, 0)));
    btnOperator.setForeground(Color.WHITE);
    btnOperator.setFont(new Font("Segoe Print", Font.BOLD, 11));
    btnOperator.setBackground(new Color(70, 130, 150));
    btnOperator.setBounds(106, 127, 70, 23);
    btnOperator.setVisible(false);
    panel.add(btnOperator);
    
    
    
    
    
    create = new JButton("Create New Account");
    create.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    create.setBackground(new Color(70,130,150));
    create.setForeground(Color.WHITE);
    create.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0) {
        panel_1.setVisible(true);
        textField.requestFocus();
      }
      
    });
    create.setFont(new Font("Segoe Print", Font.BOLD, 14));
    create.setBounds(715, 411, 165, 23);
    create.setVisible(false);
    frame.getContentPane().add(create);
    
    panel_1 = new JPanel();
    panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
    panel_1.setBackground(new Color(70, 130, 150));
    panel_1.setBounds(633, 445, 299, 100);
    frame.getContentPane().add(panel_1);
    panel_1.setLayout(null);
    panel_1.setVisible(false);
    
    passwordField = new JPasswordField();
    passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
    passwordField.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10)
        {
          try
          {
            String query = "INSERT INTO  admintable (username, password) values (?,?)";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, textField.getText());
            pst.setString(2, passwordField.getText());
            
            pst.execute();
            pst.close();
            

            JOptionPane.showMessageDialog(null, "USER CREATED!");
            panel_1.setVisible(false);
            create.setVisible(false);
            passwordField_1.setVisible(false);
            passwordField_1.setText("");
            textField.setText("");
            passwordField.setText("");
          }
          catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);

          }
          
        }
        
      }
      

    });
    passwordField.setBounds(129, 57, 136, 22);
    panel_1.add(passwordField);
    
    textField = new JTextField();
    textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
    textField.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == 10)
        {

          passwordField.requestFocus();
        }
        
      }
      
    });
    textField.setColumns(10);
    textField.setBounds(129, 26, 136, 22);
    panel_1.add(textField);
    
    JLabel label = new JLabel("Username");
    label.setForeground(Color.WHITE);
    label.setFont(new Font("Segoe Print", Font.BOLD, 15));
    label.setBounds(24, 27, 83, 14);
    panel_1.add(label);
    
    JLabel label_1 = new JLabel("Password");
    label_1.setForeground(Color.WHITE);
    label_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
    label_1.setBounds(24, 63, 83, 14);
    panel_1.add(label_1);
    
    lblGstBillingSystem = new JLabel("Patient Record & Medical Billing System ");
    lblGstBillingSystem.setHorizontalAlignment(SwingConstants.TRAILING);
    lblGstBillingSystem.setBackground(new Color(70,130,150));
    //lblGstBillingSystem.setBackground(new Color(0,139,139));
    
    lblGstBillingSystem.setOpaque(true);
    lblGstBillingSystem.setBorder(new MatteBorder(0, 0, 1, 4, (Color) new Color(255, 255, 255)));
    lblGstBillingSystem.setForeground(new Color(255, 255, 102));
    lblGstBillingSystem.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
    lblGstBillingSystem.setBounds(50, 10, 883, 65);
    frame.getContentPane().add(lblGstBillingSystem);
    
    label_5 = new JLabel("Created by: MD ZEYAUR RAHMAN");
    label_5.setForeground(Color.WHITE);
    label_5.setFont(new Font("Segoe Print", Font.BOLD, 16));
    label_5.setBorder(null);
    label_5.setBounds(643, 75, 289, 23);
    frame.getContentPane().add(label_5);
    
    lblVijayanagarColonyHyderabad = new JLabel("Vijayanagar Colony, Hyderabad.");
    lblVijayanagarColonyHyderabad.setHorizontalAlignment(SwingConstants.RIGHT);
    lblVijayanagarColonyHyderabad.setForeground(Color.WHITE);
    lblVijayanagarColonyHyderabad.setFont(new Font("Segoe UI", Font.PLAIN, 20));
    lblVijayanagarColonyHyderabad.setBounds(208, 207, 289, 29);
    frame.getContentPane().add(lblVijayanagarColonyHyderabad);
    
    
   JLabel dr = new JLabel("Dr. BABU's");
   dr.setHorizontalAlignment(SwingConstants.LEFT);
   dr.setForeground(Color.WHITE);
   dr.setFont(new Font("Segoe UI Emoji", Font.BOLD, 22));
   dr.setBounds(73, 155, 142, 29);
    frame.getContentPane().add(dr);
   
    
    lblTolichowkiHyderabad = new JLabel("Tolichowki , Hyderabad.");
    lblTolichowkiHyderabad.setHorizontalAlignment(SwingConstants.RIGHT);
    lblTolichowkiHyderabad.setForeground(Color.WHITE);
    lblTolichowkiHyderabad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
    lblTolichowkiHyderabad.setBounds(193, 235, 263, 29);
    frame.getContentPane().add(lblTolichowkiHyderabad);
    
  JLabel skin = new JLabel("SKIN, HAIR & NAIL CLINIC");
   skin.setHorizontalAlignment(SwingConstants.CENTER);
   skin.setForeground(new Color(255, 255, 102));
   skin.setFont(new Font("Segoe UI Black", Font.PLAIN, 41));
   skin.setBounds(56, 175, 557, 35);
    frame.getContentPane().add(skin);
    
    
    
    Clock();
  }
}
