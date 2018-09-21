package com.Layout;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class DBC {
    public  static Connection conn;
    ResultSet rs;
    String Pwd,ID;
    String tel=null,password=null,address = null;
    int i=0,j=0,k=0,l=0;
    public Connection  connect() {
        try{
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
            String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Logistic";//数据源  ！！！！注意若出现加载或者连接数据库失败一般是这里出现问题
            String Name = "sa";
            String Pwd = "123456";
            conn = DriverManager.getConnection(dbURL, Name, Pwd);
            System.out.println("连接数据库成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败");
        }
        return  conn;
    }
    public  ResultSet reaseach(String name,String Pwd,String ID){


            String sql ="select * from  Track where Tsname = '" +name+
                    " 'and TID = "+ID;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public  void  authorized(String name,String ID){
        String sql ="select * from  UserCol where Uname = '" +name+
                " 'and UID = "+ID;
        String sql3 = "delete from UserCol where Uname = '"+name+
                " 'and UID = "+ID;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()){
                tel = resultSet.getString(5);
                password = resultSet.getString(3);
                address = resultSet.getString(4);
                String sql2 = "insert into Administrator  values('" +name+
                        "','" +ID+
                        "','" +tel+
                        "', '" +password+
                        "','" +address+
                        "')";
                PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
                preparedStatement2.execute();
                System.out.println("successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
            int i = preparedStatement3.executeUpdate();
            if(1==i) {
                System.out.println("successful");
            }
            else
                System.out.println("fail");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  void  update(String name,String ID,String stel,String sAdd,String rName,String rTel,String rAdd,String number,
                         String rWarehouse,String rState,String goodsName,String goodsSpe,String goodsQu,String goodsWeight,
                         String companyName,String courierName,String courierTel,String time){
        String sql = "insert into Track values('" +name+
                "','" +ID+
                "','" +stel+
                "','" +sAdd+
                "','" +rName+
                "','" +rTel+
                "','" +rAdd+
                "','" +number+
                "','" +rWarehouse+
                "','" +rState+
                "')";
        String sql2 = "insert into Goods values('"  +number+
                "','" +goodsName+
                "','" +goodsSpe+
                "','" +goodsQu+
                "','" +goodsWeight+
                "')";
        String sql3 = "insert into Company values('" +number+
                "','" +companyName+
                "')";
        String sql4 = "insert into Courier values('" +courierName+
                "','" +courierTel+
                "','" +number+
                "','" +time+
                "')";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql2,ResultSet.TYPE_SCROLL_INSENSITIVE);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement2 = null;
        try {
            preparedStatement2 = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE);
            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement3 =null;
        try {
            preparedStatement3 = conn.prepareStatement(sql3);
            preparedStatement3.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement4 = null;
        try {
            preparedStatement4 = conn.prepareStatement(sql4);
            preparedStatement4.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void delete(String name,String ID){
        String sql = "delete  from UserCol where Uname = '"+name+
                "'and UID = '"+ID+"'";
        String sql2= "exec sp_droplogin  '"+name+"'";
        String sql3 = "exec sp_revokedbaccess '"+name+"'";
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement1 = conn.prepareStatement(sql2);
            preparedStatement2 = conn.prepareStatement(sql3);
            int i = preparedStatement.executeUpdate();
            int j = preparedStatement1.executeUpdate();
            int k=  preparedStatement2.executeUpdate();
            System.out.println("i  =  "+i);
            if(1==i){
                JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.CLOSED_OPTION);
            }else {
                JOptionPane.showMessageDialog(null,"删除失败","提示",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        String sql ="select * from  Administrator where Aname = '" +name+
//                " 'and AID = '"+ID+"'";
//        String sql3 = "delete from Administrator where Aname = '"+name+
//                " 'and AID = '"+ID+"'";
//
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ResultSet resultSet = null;
//        try {
//            resultSet = preparedStatement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            while (resultSet.next()){
//                tel = resultSet.getString(3);
//                password = resultSet.getString(4);
//                address = resultSet.getString(5);
//                String sql2 = "insert into UserCol  values('" +name+
//                        "','" +ID+
//                        "','" +password+
//                        "', '" +address+
//                        "','" +tel+
//                        "')";
//                PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
//                preparedStatement2.execute();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
//            int i = preparedStatement3.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public  ResultSet reaseach(String number){


        String sql ="select * from  Track where Tnumber= '" +number+"'";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public  void delete(String number){
        String sql ="delete from  Track where Tnumber= '" +number+"'";
        String sql1 = "delete from Goods Where Gnumber ='"+number+"'";
        String sql2 =  "delete from Company Where Cnumber ='"+number+"'";
        String sql3 =  "delete from Courier Where Ctracknumber ='"+number+"'";

        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        PreparedStatement preparedStatement3 = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            int i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql fail");
        }
        try {
            preparedStatement1 = conn.prepareStatement(sql1);
            int j = preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql1 fail");
        }
        try {
            preparedStatement2 =conn.prepareStatement(sql2);
            int k = preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql2 fail");
        }
        try {
            preparedStatement3 = conn.prepareStatement(sql3);
            int l = preparedStatement3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql3 fail");
        }
    }
    public  ResultSet reaseach(String name, String Pwd){


        String sql ="select * from  UserCol where Uname = '" +name+
                "' and Upassword = "+Pwd;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public  int  update(String name,String ID,String  password,String tel,String add) {
        String sql = "update  UserCol set Upassword='" + password +
                "',Uadd ='" + add +
                "',Utel ='" + tel+
                "' where UID ='"+ID+
                "'";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public  int  update(String number,String name,String stel,String sadd,String rname,String rtel,String radd) {
        String sql = "update  Track set Tsname='" + name +
                "',Tstel ='" + stel +
                "',Tsadd ='" +sadd+
                "',Trname='" +rname+
                "',Trtel= '"+rtel+
                "',Tradd ='"+radd+
                "' where Tnumber ='"+number+
                "'";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args)  {
        conn = new DBC().connect();
        /*String sql = "select * from Administrator where Aname = 'hdq' and Apassword = 123456";
        PreparedStatement psmt2 = null;
        try {
            psmt2 = conn.prepareStatement(sql);
            ResultSet rs = psmt2.executeQuery();
            if (rs.next()) {
                System.out.println("成功");
                run(new Userlogin(), 500, 500);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        ResultSet rs = new DBC().reaseach("plp","123","12");
        System.out.println("成功");
        try {
            if(rs.next()){
                for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
                System.out.println(rs.getMetaData().getColumnName(i));
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
