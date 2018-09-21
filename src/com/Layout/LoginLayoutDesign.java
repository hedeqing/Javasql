package com.Layout;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.IDN;
import java.sql.*;

import static com.Layout.LoginLayout.run;


public class LoginLayoutDesign extends JFrame {
    private    static  final  long serialVersionUID = 1L;
    private  JLabel adminjlabel,passwordjlabel,jLabel1,iconimagellabel,welcomeText;
    private  JFrame jFrame;
    private   JPasswordField passwordField;
    private    JTextField admintext;
    private JButton loginButton,registerButton;
    private  Font  font;
    public  int i=0;
    public LoginLayoutDesign(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container c  = getContentPane();
        c.setLayout(null);


        font = new Font("黑体",Font.PLAIN,15);

        ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\MSI-PC\\Desktop\\界面图片\\7.jpg");
        iconimagellabel = new JLabel(imageIcon1);
        iconimagellabel.setBounds(0, 0, 500,500);
        iconimagellabel.setOpaque(true);

        welcomeText = new JLabel();
        welcomeText.setFont(new Font("宋体",Font.PLAIN,25));
        welcomeText.setText("欢迎进入物流集散中心信息管理系统" );
        welcomeText.setBounds(50,30,400,80);

        adminjlabel = new JLabel("ID");
        adminjlabel.setBounds(40,120,60,50);
        adminjlabel.setFont(font);
        admintext = new JTextField();
        admintext.setBounds(110,130,250,40);

        passwordjlabel = new JLabel("密码");
        passwordjlabel.setFont(font);
        passwordjlabel.setBounds(40,200,60,50);
        passwordField = new JPasswordField();
        passwordField.setBounds(110,210,250,40);

        registerButton = new JButton("注册");
        registerButton.setBounds(110,300,90,40);
        registerButton.setFont(font);

        loginButton = new JButton("登录");
        loginButton.setFont(font);
        loginButton.setBounds(270,300,90,40);

        c.add(welcomeText);
        c.add(adminjlabel);
        c.add(admintext);
        c.add(passwordjlabel);
        c.add(passwordField);
        c.add(loginButton);
        c.add(registerButton);
        c.add(iconimagellabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String admin;
                char[] password;
                Connection conn = new DBC().connect();

                String id = admintext.getText();
                password = passwordField.getPassword();
               String Name;
                String Pwd = String.valueOf(password);
                try {
                    String sql1 = "select * from UserCol where UID = '" +id+
                            "' and Upassword = " +Pwd;
                    String sql2 = "select * from Administrator where AID = '" +id+
                            "' and Apassword = " +Pwd;
                    PreparedStatement psmt1 = conn.prepareStatement(sql1);
                    PreparedStatement psmt2 = conn.prepareStatement(sql2);
                    ResultSet resultSet1 = psmt1.executeQuery();
                    ResultSet resultSet2 = psmt2.executeQuery();
                   if(resultSet1.next()){
                       Name = resultSet1.getString(1);
                       System.out.println("用户登录成功");
                       System.out.println("name "+Name+"Pwd "+Pwd);
                       new UserLoginNew(Name,Pwd,id).setVisible(true);
                   }
                   else if(resultSet2.next()){
                       System.out.println("管理员登录成功");
                       run(new Adminlogin(),800,800);
                    }
                    else {
                       JOptionPane.showMessageDialog(null, "登录失败", "提示", JOptionPane.ERROR_MESSAGE);
                   }

                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println("连接失败");
                    JOptionPane.showMessageDialog(null, "登录失败", "提示", JOptionPane.ERROR_MESSAGE);
                }

            }
        });//

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run( new RegisterLayout(),400,600);
            }
        });
    }
    public static void main(String args[]){

        run(new LoginLayoutDesign(),500,500);
    }
}
