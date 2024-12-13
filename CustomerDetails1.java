CustomerDetails1.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDetails1 extends JFrame implements ActionListener 
{
    JLabel l1, l2, Name, CustomerID, MeterReading, Amount, Paymentstatus;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    JButton submit, btn2;

    CustomerDetails1() 
{
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Customer details in Java");
        l1 = new JLabel("Customer Details in Windows Form:");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Name:");
        CustomerID = new JLabel("CustomerID:");
        MeterReading = new JLabel("MeterReading:");
        Amount = new JLabel("Amount:");
        Paymentstatus = new JLabel("Paymentstatus:");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField(); // Initialize tf6
        submit = new JButton("Submit");
        btn2 = new JButton("Back");
        submit.addActionListener(this);
        btn2.addActionListener(this);
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        CustomerID.setBounds(80, 110, 200, 30);
        MeterReading.setBounds(80, 150, 200, 30);
        Amount.setBounds(80, 190, 200, 30);
        Paymentstatus.setBounds(80, 230, 200, 30);
        tf1.setBounds(300, 70, 270, 30);
        tf2.setBounds(300, 110, 270, 30);
        tf3.setBounds(300, 150, 270, 30);
        tf4.setBounds(300, 190, 270, 30);
        tf5.setBounds(300, 230, 270, 30);
        tf6.setBounds(300, 270, 270, 30); // Set bounds for tf6
        submit.setBounds(50, 350, 100, 30);
        btn2.setBounds(170, 350, 100, 30);
        add(l1);
        add(l2);
        add(tf1);
        add(CustomerID);
        add(tf2);
        add(MeterReading);
        add(tf3);
        add(Amount);
        add(tf4);
        add(Paymentstatus);
        add(tf5);
        add(tf6); // Add tf6 to the frame
        add(submit);
        add(btn2);
        setVisible(true);
        setSize(700, 700);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = tf1.getText(); // Change variable names to lowercase
            int customerID = Integer.parseInt(tf2.getText());
            int meterReading = Integer.parseInt(tf3.getText());
            int amount = Integer.parseInt(tf4.getText());
            String paymentStatus = tf5.getText(); // Change variable name to lowercase

            String connectionUrl = "jdbc:mysql://localhost:3306/?user=kavi";
            String dbUser = "kavi";
            String dbPwd = "kaviya1712";
            Connection conn;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
                PreparedStatement st = conn.prepareStatement("INSERT INTO CustomerDetails
                (Name,CustomerID,MeterReading,Amount,PaymentStatus) VALUES(?,?,?,?,?)");
                st.setString(1, name);
                st.setInt(2, customerID);
                st.setInt(3, meterReading);
                st.setInt(4, amount);
                st.setString(5, paymentStatus);
                st.executeUpdate();
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
                System.out.println("CustomerDetails Entered successfully");
            } catch (SQLException sqle) {
                System.out.println("SQL Exception thrown: " + sqle);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            new HomePage1();
        }
    }

    public static void main(String[] args) {
        new CustomerDetails();
    }
}