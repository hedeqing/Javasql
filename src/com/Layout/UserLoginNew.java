package com.Layout;

import com.Table.UserCol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.Flow;

public class UserLoginNew  extends JFrame {
    private  JLabel iconLabel,iconLabel2;
    private JButton jButton,jButton3;
    private  JLabel jLabel,jLabel2,jLabel3,textLabel,addLabel,telLabel,textLabel2,IDLabel;
    private  JTextField jTextField,jTextField2,jTextField3,addText,telText,IDtext;
    private  Font font;
    private  JTextArea jTextArea;
    private static   String name,Pwd,ID,name2,ID2,name3,ID3,passworld,tel,address,Pwd2,number;
    private  Connection conn;
    private  PreparedStatement psmt;
    private  ResultSet rs;
    private  JPanel jPanel2;
    private  ResultSet rs3,rs4;
    Vector rowData,columnNames;
    JTable jt=null;
    JScrollPane jsp=null;
    private  JTable jTable;
//        public static  void main(String[] args){
//        UserLoginNew userLoginNew = null;
//        try {
//            userLoginNew = new UserLoginNew("何德庆","123456","440982199605214930");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        userLoginNew.setVisible(true);
//    }
    public UserLoginNew(String name,String Pwd,String ID) throws SQLException {

        this.name = name;
        this.Pwd = Pwd;
        this.ID = ID;
        setTitle("用户界面");
        setBounds(100,100,800,800);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        font = new Font("黑体",Font.PLAIN,20);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        ImageIcon bgim = new ImageIcon("C:\\Users\\MSI-PC\\Desktop\\界面图片\\9.jpg");
        bgim.setImage(bgim.getImage().
                getScaledInstance(ConstansUtils.LONG_WIDTH,ConstansUtils.LONG_HEIGH,
                        Image.SCALE_DEFAULT));
        iconLabel = new JLabel(bgim);
        iconLabel.setBounds(0, 0, ConstansUtils.LONG_WIDTH, ConstansUtils.LONG_HEIGH);
        iconLabel2 = new JLabel(bgim);
        iconLabel2.setBounds(0, 0, ConstansUtils.LONG_WIDTH, ConstansUtils.LONG_HEIGH);
        jButton = new JButton("更新");
        jButton.setBounds(170,650,100,60);
        jButton.setFont(font);

        jLabel = new JLabel("姓名:");
        jLabel.setBounds(100,120,100,40);
        jLabel.setFont(font);
        jLabel2 = new JLabel("ID");
        jLabel2.setFont(font);
        jLabel2.setBounds(100,220,100,40);
        jLabel3 = new JLabel("密码");
        jLabel3.setFont(font);
        jLabel3.setBounds(100,320,100,40);

        telLabel = new JLabel("号码");
        telLabel.setFont(font);
        telLabel.setBounds(100,420,100,40);
        telText = new JTextField();
        telText.setBounds(180,420,200,40);

        addLabel = new JLabel("地址");
        addLabel.setFont(font);
        addLabel.setBounds(110,520,100,40);
        addText = new JTextField();
        addText.setBounds(180,520,200,40);

        textLabel = new JLabel("个人信息");
        textLabel.setFont(new Font("黑体",Font.PLAIN,30));
        textLabel.setBounds(180,0,200,100);
        jTextField = new JTextField();
        jTextField.setBounds(180,120,200,40);
        jTextField.setEditable(false);
        jTextField2 = new JTextField();
        jTextField2.setBounds(180,220,200,40);
        jTextField2.setEditable(false);
        jTextField3 = new JTextField();
        jTextField3.setBounds(180,320,200,40);

        jTextArea = new JTextArea();

        JSplitPane jSplitPane = new JSplitPane();
        c.add(jSplitPane);
        jSplitPane.setLeftComponent(jButton);

        Panel panel = new Panel();
        panel.setLayout(null);
        //连接数据库
        Connection conn = new DBC().connect();
        ResultSet rs1 = new DBC().reaseach(name,Pwd);
        while(rs1.next()){
            jTextField.setText(rs1.getString(1));
            jTextField2.setText(rs1.getString(2));
            jTextField3.setText(rs1.getString(3));
            addText.setText(rs1.getString(4));
            telText.setText(rs1.getString(5));
        }
        panel.add(textLabel);
        panel.add(jLabel);
        panel.add(jTextField);
        panel.add(jLabel2);
        panel.add(jTextField2);
        panel.add(jLabel3);
        panel.add(jTextField3);
        panel.add(telLabel);
        panel.add(telText);
        panel.add(addLabel);
        panel.add(addText);
        panel.add(jButton);
        panel.add(iconLabel2);


        jSplitPane.setLeftComponent(panel);




        JSplitPane jSplitPane2 = new JSplitPane(jSplitPane.VERTICAL_SPLIT);
        //jSplitPane.setLayout(null);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name3 = jTextField.getText();
                ID3  = jTextField2.getText();
                passworld = jTextField3.getText();
                tel = telText.getText();
                address = addText.getText();

                System.out.println(name3+" "+ID3+ " "+passworld+" "+tel+" "+address+" ");

                Connection conn = new DBC().connect();
                int i = new DBC().update(name3,ID3,passworld,tel,address);
                if(i==1) {
                    System.out.println("更新成功");
                    JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.CLOSED_OPTION);
                }
                else {
                    System.out.println("更新失败");
                    JOptionPane.showMessageDialog(null, "登录失败", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
            });

        //右上
        columnNames = new Vector();
        columnNames.add("收件人姓名");
        columnNames.add("收件人ID");
        columnNames.add("收件人电话");
        columnNames.add("收件人地址");
        columnNames.add("寄件人姓名");
        columnNames.add("寄件人电话");
        columnNames.add("寄件人地址");
        columnNames.add("快件单号");
        columnNames.add("快件仓库");
        columnNames.add("快件状态");

        ResultSet rs4 = new DBC().reaseach(name,Pwd,ID);
        try {
            Vector rowData = new Vector();
            while (rs4.next()){
                Vector hang = new Vector();
                for(int i=1;i<=rs4.getMetaData().getColumnCount();i++)
                {
                    hang.add(rs4.getString(i));
                }
                rowData.add(hang);
            }
            jTable = new JTable(rowData, columnNames){
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }


        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setLayout(new ScrollPaneLayout());

        jSplitPane2.setLeftComponent(jScrollPane);
        jSplitPane.setRightComponent(jSplitPane2);

        jSplitPane2.setDividerSize(10);
        jSplitPane.setDividerSize(10);
        jSplitPane2.setContinuousLayout(true);
        jSplitPane.setContinuousLayout(true);
        jSplitPane2.setOneTouchExpandable(true);
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane2.setDividerLocation(400);
        jSplitPane.setDividerLocation(400);

        textLabel2 = new JLabel("快速查询");
        textLabel2.setFont(new Font("黑体",Font.PLAIN,15));
        textLabel2.setBounds(180,40,100,60);
        IDLabel = new JLabel("快递单号");
        IDLabel.setFont(new Font("黑体",Font.PLAIN,13));
        IDLabel.setBounds(70,180,60,40);


        IDtext = new JTextField();
        IDtext.setBounds(150,180,200,50);

        jButton3 = new JButton("确认");
        jButton3.setFont(font);
        jButton3.setBounds(145,280,100,40);
        jPanel2 = new JPanel();
        jPanel2.setLayout(null);
        jPanel2.add(textLabel2);
//        jPanel2.add(nameLabel4);
//        jPanel2.add(nameText);
        jPanel2.add(IDLabel);
        jPanel2.add(IDtext);
        jPanel2.add(jButton3);
        jSplitPane2.setRightComponent(jPanel2);
        //查询按钮
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = new DBC().connect();
//                name2 = nameText.getText();
                number = IDtext.getText();

                System.out.println(number+" ");
                ResultSet rs3 = new DBC().reaseach(number);
                try {
                    Vector rowData = new Vector();
                    while (rs3.next()){
                        Vector hang = new Vector();
                        for(int i=1;i<=rs3.getMetaData().getColumnCount();i++) {
                                hang.add(rs3.getString(i));
                            }
                            rowData.add(hang);
                        }
                    jTable = new JTable(rowData, columnNames){
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                JScrollPane jScrollPane = new JScrollPane(jTable);
                jScrollPane.setLayout(new ScrollPaneLayout());

                jSplitPane2.setLeftComponent(jScrollPane);
            }
        });
        //jSplitPane2.setLeftComponent(jTable);
    }
}
