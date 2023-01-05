package org.example;

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;

public class componentsSample {


    public static void main(String[] args){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(800,600);



        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
        JScrollPane jScrollPane = new JScrollPane(content);
        jFrame.add(jScrollPane);

        JButton button = new JButton("button");
        JLabel jLabel = new JLabel("Label");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField jTextField = new JTextField();
        jTextField.setMaximumSize(new Dimension(200,20));
        JCheckBox jCheckBox = new JCheckBox();
        JRadioButton jRadioButton = new JRadioButton();

        content.add(button);
        content.add(jLabel);
        content.add(jCheckBox);
        content.add(jRadioButton);
        content.add(jTextField);


        JPanel horizontalPane = new JPanel();
        horizontalPane.setLayout(new FlowLayout());
        JButton horizontal1 = new JButton("horizontal1");
        JButton horizontal2 = new JButton("horizontal 2");
        JButton horizontal3 = new JButton("horizontal 3");
        horizontalPane.add(horizontal1);
        horizontalPane.add(horizontal2);
        horizontalPane.add(horizontal3);
        content.add(horizontalPane);


        jFrame.setVisible(true);
    }
}
