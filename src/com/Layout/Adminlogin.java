
package com.Layout;

import javax.management.JMException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.Layout.LoginLayout.run;


class Adminlogin extends JFrame
{
    private JLabel contactKF,oldUserNameLabel,oldUserIDLabel,trackInformation,sNameLabel,sIdLabel,sTelLabel,sAddLabel,rNameLabel
            ,rTelLabel,rAddLabel,rNumberLabel,rWarehouseLabel,rStateLabel,goodsNameLabel,goodsSpeLabel,goodsQuLabel,goodsWeightLabel
            ,companyNameLabel,courierNameLabel,courierTelLabel,timeLabel;
    private  JTextField  oldUserNameText,oldUserIDText,sNameText,sIdText,sTelText,sAddText,rNameText
            ,rTelText,rAddText,rNumberText,rWarehouseText,rStateText,goodsNameText,goodsSpeText,goodsQuText
            ,companyNameText,courierNameText,courierTelText,timeText,goodsWeightText;
    private Font font;
    private  JButton jButton;
    private  JFrame myFrame;
    private  JLabel userImformation,userNameLabel,userIDLabel;
    private  JTextField userNameText,userIDText;
    private  JButton jButton2,jButton3,jButton4,jButton42,jButton5,jButton6;
    private  String  name,ID,number;
    private  ResultSet rs3;
    private  String  newSname,newStel,newSadd,newRname,newRtel,newRadd;
    private  String rName,rTel,rAdd,rState,sName,sID,sTel,sAdd,goodsName,goodsSpe,goodsQu,goodsWeight,rWarehouse,companyName
            ,courierName,courierTel,time;
    public Adminlogin()
    {

        jButton = new JButton("添加");
        jButton.setFont(font);
        jButton.setBounds(320,650,70,50);

        JMenuBar menuBar=new JMenuBar();//创建一个菜单栏
        //创建一级菜单
        JMenu menu1=new JMenu("快件管理");
        JMenu menu2=new JMenu("用户管理");
        JMenu menu3 = new JMenu("关于我们");
        //一级菜单添加到菜单栏
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        JMenuItem menuItem1=new JMenuItem("添加快件");
        JMenuItem menuItem2=new JMenuItem("删除快件");
        //JMenuItem menuItem3=new JMenuItem("查询快件");
        JMenuItem menuItem4=new JMenuItem("查询与修改快件");
        //子菜单添加到一级菜单
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        //menu1.add(menuItem3);
        menu1.add(menuItem4);

        JMenuItem m1=new JMenuItem("用户授权");
        JMenuItem m2=new JMenuItem("删除用户");
         //子菜单添加到一级菜单
        menu2.add(m1);
        menu2.add(m2);

        JMenuItem jMenuItem = new JMenuItem("联系客服管理员");
        menu3.add(jMenuItem);
        myFrame = this;
        JDesktopPane desktopPane=new JDesktopPane();
        myFrame.add(desktopPane);
        jButton2 = new JButton("确认");
        jButton2.setFont(font);
        jButton2.setBounds(350,350,80,50);


        font = new Font("宋体",Font.PLAIN,15);

        jButton3 = new JButton("确认");
        jButton3.setFont(font);
        jButton3.setBounds(160,350,80,50);

        jButton4 = new JButton("更新");
        jButton4.setFont(font);
        jButton4.setBounds(240,670,70,50);
        jButton42 = new JButton("确认");
        jButton42.setFont(new Font("宋体",Font.PLAIN,10));
        jButton42.setBounds(400,120,60,40);

        jButton5 = new JButton("确认");
        jButton5.setFont(font);
        jButton5.setBounds(350,600,80,50);

        jButton6 = new JButton("确认");
        jButton6.setFont(font);
        jButton6.setBounds(350,600,80,50);
        /*
        设置监听器
         */
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JInternalFrame inFrame = new JInternalFrame("添加快件", true, true, true, true);
                inFrame.setSize(new Dimension(800, 800));
                //inFrame.setBounds(0,0,500,800);
                //inFrame.setLayout(null);
                inFrame.setVisible(true);
                inFrame.setResizable(true);
                inFrame.setIconifiable(true);
                Container c=inFrame.getContentPane();
                c.setLayout(null);
                add(inFrame);

                trackInformation = new JLabel("快件信息");
                trackInformation.setBounds(300,10,200,50);
                trackInformation.setFont(new Font("宋体",Font.PLAIN,30));

                font = new Font("宋体",Font.PLAIN,12);

                //左边
                sNameLabel = new JLabel("收件人姓名");
                sNameLabel.setFont(font);
                sNameLabel.setBounds(50,60,60,50);
                sIdLabel = new JLabel("收件人ID");
                sIdLabel.setFont(font);
                sIdLabel.setBounds(50,130,60,50);
                sTelLabel = new JLabel("收件人电话");
                sTelLabel.setFont(font);
                sTelLabel.setBounds(50,200,60,50);
                sAddLabel = new JLabel("收件人地址");
                sAddLabel.setFont(font);
                sAddLabel.setBounds(50,270,60,50);

                rNameLabel = new JLabel("寄件人姓名");
                rNameLabel.setFont(font);
                rNameLabel.setBounds(50,340,60,50);
                rTelLabel = new JLabel("寄件人电话");
                rTelLabel.setFont(font);
                rTelLabel.setBounds(50,410,60,50);


                rAddLabel = new JLabel("寄件人地址");
                rAddLabel.setFont(font);
                rAddLabel.setBounds(50,480,60,50);

                companyNameLabel = new JLabel("公司");
                companyNameLabel.setFont(font);
                companyNameLabel.setBounds(50,550,60,50);

                courierNameLabel = new JLabel("业务员姓名");
                courierNameLabel.setFont(font);
                courierNameLabel.setBounds(50,620,60,50);
//右边


                rNumberLabel = new JLabel("单号");
                rNameLabel.setFont(font);
                rNumberLabel.setBounds(400,60,60,50);
                rWarehouseLabel = new JLabel("快件仓库");
                rWarehouseLabel.setFont(font);
                rWarehouseLabel.setBounds(400,130,60,50);
                rStateLabel= new JLabel("快件状态");
                rStateLabel.setFont(font);
                rStateLabel.setBounds(400,200,60,50);

                goodsNameLabel = new JLabel("货物名称");
                goodsNameLabel.setFont(font);
                goodsNameLabel.setBounds(400,270,60,50);

                goodsSpeLabel = new JLabel("货物规格");
                goodsSpeLabel.setFont(font);
                goodsSpeLabel.setBounds(400,340,60,50);

                goodsQuLabel = new JLabel("货物数量");
                goodsQuLabel.setFont(font);
                goodsQuLabel.setBounds(400,410,60,50);

                goodsWeightLabel = new JLabel("货物重量");
                goodsWeightLabel .setFont(font);
                goodsWeightLabel.setBounds(400,480,60,50);

                courierTelLabel = new JLabel("业务员电话");
                courierTelLabel.setFont(font);
                courierTelLabel.setBounds(400,550,60,50);

                timeLabel = new JLabel("接洽时间");
                timeLabel.setFont(font);
                timeLabel.setBounds(400,620,60,50);

                //左边
                sNameText = new JTextField();
                sNameText.setBounds(150,60,150,40);
                sIdText = new JTextField();
                sIdText.setBounds(150,130,150,40);

                sTelText = new JTextField();
                sTelText.setBounds(150,200,150,40);
                sAddText = new JTextField();
                sAddText.setBounds(150,270,150,40);


                rNameText = new JTextField();
                rNameText.setBounds(150,340,150,40);
                rTelText = new JTextField();
                rTelText.setBounds(150,410,150,40);
                rAddText = new JTextField();
                rAddText.setBounds(150,480,150,40);

                companyNameText = new JTextField();
                companyNameText.setBounds(150,550,150,40);

                courierNameText = new JTextField();
                courierNameText.setBounds(150,620,150,40);


                //右边
                rNumberText = new JTextField();
                rNumberText.setBounds(500,60,150,40);
                rWarehouseText = new JTextField();
                rWarehouseText.setBounds(500,130,150,40);
                rStateText = new JTextField();
                rStateText.setBounds(500,200,150,40);

                goodsNameText = new JTextField();
                goodsNameText.setBounds(500,270,150,40);
                goodsSpeText = new JTextField();
                goodsSpeText.setBounds(500,340,150,40);
                goodsQuText= new JTextField();
                goodsQuText.setFont(font);
                goodsQuText.setBounds(500,410,150,40);
                goodsWeightText = new JTextField();
                goodsWeightText.setBounds(500,480,150,40);

                courierTelText = new JTextField();
                courierTelText.setBounds(500,550,150,40);

                timeText = new JTextField();
                timeText.setBounds(500,620,150,40);

                inFrame.add(trackInformation);
                inFrame.add(sNameLabel);
                inFrame.add(sNameText);
                inFrame.add(sIdLabel);
                inFrame.add(sIdText);
                inFrame.add(sAddText);
                inFrame.add(sTelLabel);
                inFrame.add(sTelText);
                inFrame.add(sAddLabel);
                inFrame.add(sAddText);
                inFrame.add(rNameLabel);
                inFrame.add(rNameText);
                inFrame.add(rTelLabel);
                inFrame.add(goodsNameLabel);
                inFrame.add(goodsNameText);
                inFrame.add(goodsQuLabel);
                inFrame.add(goodsQuText);
                inFrame.add(goodsSpeLabel);
                inFrame.add(goodsSpeText);
                inFrame.add(goodsWeightLabel);
                inFrame.add(goodsWeightText);
                inFrame.add(courierNameLabel);
                inFrame.add(courierNameText);
                inFrame.add(companyNameLabel);
                inFrame.add(companyNameText);
                inFrame.add(courierTelLabel);
                inFrame.add(courierTelText);
                inFrame.add(timeLabel);
                inFrame.add(timeText);

                inFrame.add(rTelText);
                inFrame.add(rAddLabel);
                inFrame.add(rAddText);
                inFrame.add(rNumberLabel);
                inFrame.add(rNumberText);
                inFrame.add(rWarehouseLabel);
                inFrame.add(rWarehouseText);
                inFrame.add(rStateLabel);
                inFrame.add(rStateText);
                inFrame.add(jButton);

            }
        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sName = sNameText.getText();
                sID = sIdText.getText();
                sTel = sTelText.getText();//
                sAdd = sAddText.getText();//
                rName = rNameText.getText();
                rTel = rTelText.getText();
                rAdd = rAddText.getText();
                number = rNumberText.getText();
                rWarehouse = rWarehouseText.getText();
                rState = rStateText.getText();
                goodsName = goodsNameText.getText();
                goodsSpe = goodsSpeText.getText();
                goodsQu = goodsQuText.getText();
                goodsWeight = goodsWeightText.getText();
                companyName = companyNameText.getText();
                courierName = courierNameText.getText();
                courierTel = courierTelText.getText();
                time  = timeText.getText();


                Connection conn = new DBC().connect();
                new DBC().update(sName,sID,sTel,sAdd,rName,rTel,rAdd,number,rWarehouse,rState,goodsName,goodsSpe,goodsQu
                        ,goodsWeight,companyName,courierName,courierTel,time);
                JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.CLOSED_OPTION);
            }
        });
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JInternalFrame inFrame = new JInternalFrame("删除快件", true, true, true, true);
                inFrame.setSize(new Dimension(800, 800));
                //inFrame.setBounds(0,0,500,800);
                //inFrame.setLayout(null);
                inFrame.setVisible(true);
                inFrame.setResizable(true);
                inFrame.setIconifiable(true);
                Container c2=inFrame.getContentPane();
                c2.setLayout(null);
                add(inFrame);

                font = new Font("宋体",Font.PLAIN,15);

//                jButton2 = new JButton("确认");
//                jButton2.setFont(font);
//                jButton2.setBounds(160,350,80,50);

                userImformation = new JLabel("快件信息");
                userImformation.setFont(new Font("宋体",Font.PLAIN,25));
                userImformation.setBounds(300,20,300,100);
                userNameLabel = new JLabel("快件单号");
                userNameLabel.setFont(font);
                userNameLabel.setBounds(200,200,200,40);

                userNameText = new JTextField();
                userNameText.setBounds(300,200,250,40);

                c2.add(userImformation);
                c2.add(userNameLabel);
                c2.add(userNameText);
//                c2.add(userIDLabel);
//                c2.add(userIDText);
                c2.add(jButton2);
                add(inFrame);


            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number = userNameText.getText();
                Connection conn = new DBC().connect();
                new DBC().delete(number);
                System.out.println("删除成功");
                JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.CLOSED_OPTION);

            }
        });

        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JInternalFrame inFrame = new JInternalFrame("查询与修改快件", true, true, true, true);
                inFrame.setSize(new Dimension(800, 800));
                //inFrame.setBounds(0,0,500,800);
                //inFrame.setLayout(null);
                inFrame.setVisible(true);
                inFrame.setResizable(true);
                inFrame.setIconifiable(true);
                Container c=inFrame.getContentPane();
                c.setLayout(null);
                add(inFrame);


                Container c2 = getContentPane();
                c2.setLayout(null);
//                jButton4 = new JButton("确认");
//                jButton4.setFont(font);
//                jButton4.setBounds(240,670,70,50);

                trackInformation = new JLabel("快件信息");
                trackInformation.setBounds(200,0,100,50);
                trackInformation.setFont(new Font("宋体",Font.PLAIN,25));

                font = new Font("宋体",Font.PLAIN,12);

                sNameLabel = new JLabel("收件人姓名");
                sNameLabel.setFont(font);
                sNameLabel.setBounds(100,160,60,60);
//                sIdLabel = new JLabel("收件人ID");
//                sIdLabel.setFont(font);
//                sIdLabel.setBounds(100,210,60,60);
                sTelLabel = new JLabel("收件人电话");
                sTelLabel.setFont(font);
                sTelLabel.setBounds(100,210,60,60);
                sAddLabel = new JLabel("收件人地址");
                sAddLabel.setFont(font);
                sAddLabel.setBounds(100,260,60,60);

                rNameLabel = new JLabel("寄件人姓名");
                rNameLabel.setFont(font);
                rNameLabel.setBounds(100,310,60,60);
                rTelLabel = new JLabel("寄件人电话");
                rTelLabel.setFont(font);
                rTelLabel.setBounds(100,360,60,60);
                rAddLabel = new JLabel("寄件人地址");
                rAddLabel.setFont(font);
                rAddLabel.setBounds(100,410,60,60);

                rNumberLabel = new JLabel("快件单号");
                rNameLabel.setFont(font);
                rNumberLabel.setBounds(100,460,60,60);
                rWarehouseLabel = new JLabel("快件仓库");
                rWarehouseLabel.setFont(font);
                rWarehouseLabel.setBounds(100,510,60,60);
                rStateLabel= new JLabel("快件状态");
                rStateLabel.setFont(font);
                rStateLabel.setBounds(100,560,60,60);
                oldUserIDLabel = new JLabel("快递单号");
                oldUserIDLabel.setFont(font);
                oldUserIDLabel.setBounds( 100,110,60,60);
//                oldUserNameLabel = new JLabel("原姓名");
//                oldUserNameLabel.setFont(font);
//                oldUserNameLabel.setBounds(100,60,60,60);

                sNameText = new JTextField();
                sNameText.setBounds(170,170,200,40);
//                sIdText = new JTextField();
//                sIdText.setBounds(170,220,200,40);

                sAddText = new JTextField();
                sAddText.setBounds(170,220,200,40);
                sTelText = new JTextField();
                sTelText.setBounds(170,270,200,40);

                rNameText = new JTextField();
                rNameText.setBounds(170,320,200,40);
                rTelText = new JTextField();
                rTelText.setBounds(170,370,200,40);
                rAddText = new JTextField();
                rAddText.setBounds(170,420,200,40);
                rNumberText = new JTextField();
                rNumberText.setBounds(170,470,200,40);
                rNumberText.setEditable(false);
                rWarehouseText = new JTextField();
                rWarehouseText.setBounds(170,520,200,40);
                rWarehouseText.setEditable(false);
                rStateText = new JTextField();
                rStateText.setBounds(170,570,200,40);
                rStateText.setEditable(false);
                oldUserIDText = new JTextField();
                oldUserIDText.setBounds(170,120,200,40);
//                oldUserNameText = new JTextField();
//                oldUserNameText.setBounds(170,70,200,40);

                inFrame.add(trackInformation);
//                inFrame.add(oldUserNameLabel);
//                inFrame.add(oldUserNameText);
                inFrame.add(oldUserIDLabel);
                inFrame.add(oldUserIDText);
                inFrame.add(sNameLabel);
                inFrame.add(sNameText);
              //  inFrame.add(sIdLabel);
                // inFrame.add(sIdText);
                inFrame.add(sAddText);
                inFrame.add(sTelLabel);
                inFrame.add(sTelText);
                inFrame.add(sAddLabel);
                inFrame.add(sAddText);
                inFrame.add(rNameLabel);
                inFrame.add(rNameText);
                inFrame.add(rTelLabel);
                inFrame.add(rTelText);
                inFrame.add(rAddLabel);
                inFrame.add(rAddText);
                inFrame.add(rNumberLabel);
                inFrame.add(rNumberText);
                inFrame.add(rWarehouseLabel);
                inFrame.add(rWarehouseText);
                inFrame.add(rStateLabel);
                inFrame.add(rStateText);
                inFrame.add(jButton4);
                inFrame.add(jButton42);


            }
        });
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = new DBC().connect();
                newSname =sNameText.getText();
                newStel = sTelText.getText();
                newSadd = sAddText.getText();
                newRname = rNameText.getText();
                newRtel = rTelText.getText();
                newRadd = rAddText.getText();
                int i = new DBC().update(number,newSname,newStel,newSadd,newRname,newRtel,newRadd);
                if(i ==1){
                    System.out.println("更新成功");
                    JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.CLOSED_OPTION);
                }
                else {
                    System.out.println("更新失败");
                    JOptionPane.showMessageDialog(null, "更新失败", "提示", JOptionPane.CLOSED_OPTION);
                }
            }

        });
        jButton42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = new DBC().connect();
                number = oldUserIDText.getText();
                System.out.println(number);
                ResultSet rs3 = new DBC().reaseach(number);
                try {
                    while (rs3.next()) {
                        sNameText.setText(rs3.getString(1));
                        sTelText.setText(rs3.getString(3));
                        sAddText.setText(rs3.getString(4));
                        rNameText.setText(rs3.getString(5));
                        rTelText.setText(rs3.getString(6));
                        rAddText.setText(rs3.getString(7));
                        rNumberText.setText(rs3.getString(8));
                        rWarehouseText.setText(rs3.getString(9));
                        rStateText.setText(rs3.getString(10));
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        });
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JInternalFrame inFrame = new JInternalFrame("用户授权", true, true, true, true);
                inFrame.setSize(new Dimension(800, 800));
                //inFrame.setBounds(0,0,500,800);
                //inFrame.setLayout(null);
                inFrame.setVisible(true);
                inFrame.setResizable(true);
                inFrame.setIconifiable(true);
                Container c2=inFrame.getContentPane();
                c2.setLayout(null);
                add(inFrame);
//
//                font = new Font("宋体",Font.PLAIN,15);
//
//                jButton2 = new JButton("确认");
//                jButton2.setFont(font);
//                jButton2.setBounds(160,350,80,50);

                userImformation = new JLabel("用户信息");
                userImformation.setFont(new Font("宋体",Font.PLAIN,30));
                userImformation.setBounds(350,10,200,100);
                userNameLabel = new JLabel("用户姓名");
                userNameLabel.setFont(font);
                userNameLabel.setBounds(200,150,200,100);

                userIDLabel = new JLabel("用户ID");
                userIDLabel.setFont(font);
                userIDLabel.setBounds(200,400,200,100);

                userNameText = new JTextField();
                userNameText.setBounds(300,180,250,40);

                userIDText = new JTextField();
                userIDText.setBounds(300,440,250,40);
                c2.add(userImformation);
                c2.add(userNameLabel);
                c2.add(userNameText);
                c2.add(userIDLabel);
                c2.add(userIDText);
                c2.add(jButton5);
                add(inFrame);
            }
        });
        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = userNameText.getText();
                ID = userIDText.getText();
                Connection conn = new DBC().connect();

                new DBC().authorized(name,ID);
                JOptionPane.showMessageDialog(null, "授权成功", "提示", JOptionPane.CLOSED_OPTION);
                System.out.println("name: "+name+" id" +ID);
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("高级查询");
                JInternalFrame inFrame = new JInternalFrame("删除用户", true, true, true, true);
                inFrame.setSize(new Dimension(800, 800));


                inFrame.setVisible(true);
                inFrame.setResizable(true);
                inFrame.setIconifiable(true);
                Container c2=inFrame.getContentPane();
                c2.setLayout(null);
                add(inFrame);

                userImformation = new JLabel("用户信息");
                userImformation.setFont(new Font("宋体",Font.PLAIN,30));
                userImformation.setBounds(350,10,200,100);
                userNameLabel = new JLabel("用户姓名");
                userNameLabel.setFont(font);
                userNameLabel.setBounds(200,150,200,100);

                userIDLabel = new JLabel("用户ID");
                userIDLabel.setFont(font);
                userIDLabel.setBounds(200,400,200,100);

                userNameText = new JTextField();
                userNameText.setBounds(300,180,250,40);

                userIDText = new JTextField();
                userIDText.setBounds(300,440,250,40);
                c2.add(userImformation);
                c2.add(userNameLabel);
                c2.add(userNameText);
                c2.add(userIDLabel);
                c2.add(userIDText);
                c2.add(jButton6);
                add(inFrame);
            }
        });
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("name: "+name+" id" +ID);
                name = userNameText.getText();
                ID = userIDText.getText();
                Connection conn = new DBC().connect();

                 new DBC().delete(name,ID);
            }
        });
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JInternalFrame internalFrame = new JInternalFrame("联系数据库管理员", true, true, true, true);
                internalFrame.setSize(new Dimension(800, 800));
                internalFrame.setLayout(new BorderLayout());
                internalFrame.setVisible(true);
                Container icontentpane=internalFrame.getContentPane();
                contactKF=new JLabel("数据库管理员QQ：240484406",JLabel.CENTER);
                contactKF.setFont(new Font("宋体",Font.BOLD,40));
                add(internalFrame);
                icontentpane.add(contactKF);
            }
        });


        setTitle("物流集散中心信息管理系统");
        setSize(500,300);
        setJMenuBar(menuBar);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());//设置窗口布局为流式布局





    }
    public static void main(String [] args)
    {

        run(new Adminlogin(),800,900);
    }

}
