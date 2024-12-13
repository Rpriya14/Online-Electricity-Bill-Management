HomePage1.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class HomePage1 extends JFrame implements ActionListener
{
JButton reg, view;
HomePage1()
{
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("HomePage ");
reg = new JButton("CustomerDetails1");
view = new JButton("ViewPaymentStatus");
reg.addActionListener(this);
view.addActionListener(this);
reg.setBounds(100, 30, 200, 30);
view.setBounds(100, 70, 200, 30);
add(reg);
add(view);
setVisible(true);
setSize(400, 400);
}
public void actionPerformed(ActionEvent e)
{
if (e.getSource() == reg)
{
new CustomerDetails1();
}
else
{
new ViewPaymentStatus();
}
}
public static void main(String args[])
{
new HomePage1();
}
}