ViewPaymentStatus.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 class ViewPaymentStatus extends JFrame implements ActionListener 
 { 
 JLabel l1,l2,l3,l4,l5;
 JTextField tf1;
 JButton btn1, btn2;
 ViewPaymentStatus()
 { 
 setLayout(null);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setTitle("VIEW ");
 l1 = new JLabel("Name:");
 l2=new JLabel("CustomerID:");
 l3=new JLabel("MeterReading:");
 l4=new JLabel("Amount:");
 l5=new JLabel("Paymentstatus:");
 l1.setForeground(Color.blue);
 l1.setFont(new Font("Serif", Font.BOLD, 20));
 tf1 = new JTextField();
 btn1 = new JButton("Submit");
 btn2 = new JButton("Back");
 btn1.addActionListener(this);
 btn2.addActionListener(this);
 l1.setBounds(100, 30, 400, 30);
 tf1.setBounds(100, 70, 200, 30);
 l2.setBounds(100,110,400,60);
 l3.setBounds(100,150,400,60);
 l4.setBounds(100,190,400,60); 
 l5.setBounds(100,230,400,60);
 btn1.setBounds(50, 350, 100, 30);
 btn2.setBounds(170, 350, 100, 30);
 add(l1);
 add(tf1);
 add(l2);
 add(l3);
 add(l4);
 add(l5);
 add(btn1);
 add(btn2);
 setVisible(true);
 setSize(700, 700);
 }
 public void actionPerformed(ActionEvent e) 
 {
 if (e.getSource() == btn1)
 {
 String regno=tf1.getText(); 
 String connectionUrl = "jdbc:mysql://localhost:3306/?user=kavi";
String dbUser = "kavi";
 String dbPwd = "kaviya1712";
 Connection conn;
 ResultSet rs;
String queryString =" select * from CustomerDetails where CustomerID= 'CustomerID' ";
try
{
 conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
Statement stmt = conn.createStatement();
rs = stmt.executeQuery(queryString);
 while(rs.next())
{
 l2.setText("Name="+rs.getString("Name"));
 l3.setText("MeterReading="+rs.getInt("MeterReading"));
 l4.setText("Amount="+rs.getInt("Amount"));
 l5.setText("Paymentstatus="+rs.getString("Paymentstatus"));
 }
if (conn != null)
{
 conn.close();
 conn = null;
 }
 }
 catch (SQLException sqle) 
 {
 System.out.println("SQL Exception thrown: " + sqle);
 }
 } 
 else
 {
 new HomePage1();
 } 
}
}
