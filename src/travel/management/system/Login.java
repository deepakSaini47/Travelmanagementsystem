package travel.management.system;

import javax.swing.*;
//import java.awt.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, password;
    JTextField tfpassword, tfusername;
    
    Login(){
        setSize(800, 400);
        setLocation(250, 150);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
//        p1.setBackground(Color.RED);
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
//        add(image);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 350, 300);
        add(p2);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 200, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60, 140, 200, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60, 180, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(200, 180, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forget password");
        password.setBounds(90, 220, 130, 30);
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(230, 220, 130, 30);
        text.setForeground(Color.RED);
        p2.add(text);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfusername.getText();
                String pass = tfpassword.getText();
                
                String query = "select *from account where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();
        } else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
