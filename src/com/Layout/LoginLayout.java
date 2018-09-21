package com.Layout;

import javax.swing.*;
import java.awt.*;

public class LoginLayout extends JFrame {
    public  static  void run(final JFrame f,final int width,final int height){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle("物流集散中心信息管理系统");//标题
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出行为
                f.setResizable(false);//不可改变大小
                f.setLocationRelativeTo(null);//窗口的相对位置，处于中央
                f.setSize(width,height);
                f.setVisible(true);
            }
        });
    }
}
