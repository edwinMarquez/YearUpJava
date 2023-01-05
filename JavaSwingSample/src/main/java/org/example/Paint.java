package org.example;

import javax.swing.*;
import java.awt.*;

public class Paint {

    public static void main(String[] args){

        JFrame jFrame = new JFrame("painting");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(800,600);


        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton btnClear = new JButton("clear");
        JButton btnChangeColor = new JButton("color");
        buttonsPanel.add(btnClear);
        buttonsPanel.add(btnChangeColor);

        PaintPanel paintPanel = new PaintPanel();
        btnClear.addActionListener( actionEvent -> {
            paintPanel.clear();
        });
        btnChangeColor.addActionListener(actionEvent -> {
            Color color = JColorChooser.showDialog(jFrame,"choose color", null);
            paintPanel.setColor(color);
        });


        jFrame.setLayout(new BorderLayout());

        jFrame.add(buttonsPanel,BorderLayout.PAGE_START);
        jFrame.add(paintPanel, BorderLayout.CENTER);
        jFrame.setVisible(true);


    }


}
