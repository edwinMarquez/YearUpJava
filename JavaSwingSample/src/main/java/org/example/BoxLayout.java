package org.example;

import javax.swing.*;
import java.awt.*;

public class BoxLayout {


    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Screen title");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(800,600);
        jFrame.setVisible(true);


        JButton btnPageStart = new JButton("page start");
        JButton btnPageEnd = new JButton("page end");
        JButton btnLineStart = new JButton("line start");
        JButton btnLineEnd = new JButton("line end");
        JButton btnCenter = new JButton("center");

        btnPageStart.addActionListener( actionEvent -> {
            System.out.println("page start");
            Color color = JColorChooser.showDialog(jFrame,"pick a color",null);
            System.out.println("color:" + color);
        });

        jFrame.setLayout(new BorderLayout());
        jFrame.add(btnPageStart, BorderLayout.PAGE_START);
        jFrame.add(btnPageEnd, BorderLayout.PAGE_END);
        jFrame.add(btnLineStart, BorderLayout.LINE_START);
        jFrame.add(btnLineEnd, BorderLayout.LINE_END);
        jFrame.add(btnCenter, BorderLayout.CENTER);







    }


}