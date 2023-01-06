package org.example;

import org.example.ui.MainUI;

import javax.swing.*;
import java.awt.*;

public class MainCounter {
    public static void main(String[] args) {

        //start ui.
        JFrame frame = new JFrame("counter");
        Dimension dimension = new Dimension(800,800);
        frame.setSize(dimension);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(new MainUI());


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });

    }
}