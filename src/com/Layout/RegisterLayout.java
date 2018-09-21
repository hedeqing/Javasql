package com.Layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static com.Layout.LoginLayout.run;

public class RegisterLayout extends JFrame {
    private    static  final  long serialVersionUID = 1L;
    private  static  String admin;
    private  static  String ID;
    private  static  char[]  password;
    private  JLabel adminjlabel,passwordjlabel,idlabel,telLabel,addLabel,icomLabel;
    private   JPasswordField passwordField;
    private    JTextField admintext,idtext,telText,addText;
    private JButton registerButton;
    private  int i=0;
    private  String address,tel;

    private  Font font;
    public  RegisterLayout(){
        Container c  = getContentPane();
        c.setLayout(null);

        font = new Font("黑体",Font.PLAIN,15);

        ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\MSI-PC\\Desktop\\界面图片\\7.jpg");
        icomLabel = new JLabel(imageIcon1);
        icomLabel.setBounds(0, 0, 500,800);
        icomLabel.setOpaque(true);


        adminjlabel = new JLabel("姓名");
        adminjlabel.setBounds(40,90,60,50);
        adminjlabel.setFont(font);
        admintext = new JTextField();
        admintext.setBounds(110,100,200,30);

        idlabel = new JLabel("ID");
        idlabel.setBounds(40,160,60,50);
        idlabel.setFont(font);
        idtext = new JTextField();
        idtext.setBounds(110,170,200,30);

        passwordjlabel = new JLabel("密码");
        passwordjlabel.setFont(font);
        passwordjlabel.setBounds(40,230,60,50);
        passwordField = new JPasswordField();
        passwordField.setBounds(110,240,200,30);

        //添加号码地址
        telLabel = new JLabel("号码");
        telLabel.setFont(font);
        telLabel.setBounds(40,300,60,50);
        telText = new JTextField();
        telText.setBounds(110,310,200,30);

        addLabel = new JLabel("地址");
        addLabel.setFont(font);
        addLabel.setBounds(40,370,60,50);
        addText = new JTextField();
        addText.setBounds(110,380,200,30);


        registerButton = new JButton("注册");
        registerButton.setBounds(150,450,100,40);
        registerButton.setFont(font);

        c.add(adminjlabel);
        c.add(admintext);
        c.add(idlabel);
        c.add(idtext);
        c.add(passwordjlabel);
        c.add(passwordField);
        c.add(telLabel);
        c.add(telText);
        c.add(addLabel);
        c.add(addText);
        c.add(registerButton);
        c.add(icomLabel);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin = admintext.getText();
                ID = idtext.getText();
                address = addText.getText();
                tel = telText.getText();
                password = passwordField.getPassword();
                System.out.print("账号: "+admin+"ID:"+ID+"  密码"+String.valueOf(password)+" add "+address+" tel "+tel);
                Connection conn = new DBC().connect();

                String Name = admin;
                String Pwd = String.valueOf(password);
                String sql = "create login " +Name+
                        " with password='" +Pwd+
                        "', default_database=Logistic";
                String sql2 = "create user "+Name+
                        " for login " +Name+
                        " with default_schema=dbo";
                String sql3 = "insert into UserCol values('" +Name+
                        "','" +ID+
                        "','" +Pwd+
                         "','" +address+
                        "','" +tel+
                        "')";
                try {
                    System.out.println("连接数据库成功");
                    PreparedStatement psmt1 = conn.prepareStatement(sql);
                    PreparedStatement psmt2 = conn.prepareStatement(sql2);
                    PreparedStatement psmt3 = conn.prepareStatement(sql3);
                    psmt1.execute();
                    psmt2.execute();
                    psmt3.execute();
                    JOptionPane.showMessageDialog(null, "注册成功", "提示", JOptionPane.CLOSED_OPTION);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println("连接失败");
                    JOptionPane.showMessageDialog(null, "注册失败", "提示", JOptionPane.ERROR_MESSAGE);
                }



            }
        });
    }
}
