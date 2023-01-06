package org.example.ui;

import org.example.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MainUI  extends JPanel {

    static ArrayList<Student> students;
    static ArrayList<Student> workingList;
    private static final int DELAY_IN_SECONDS = 10;
    private static int pos = -1;


    Button buttonChooseStudent;
    Button yesButton;
    Button noButton;
    private static String uiCounter = "";
    /**
     * unfortunate way to handle state. due to time
     * 0 : choosing phase.
     * 1: count down.
     */
//    private static AtomicInteger uiState = new AtomicInteger(0);
    enum State{
        CHOOSING,
        COUNTDOWN,
        VERIFY
    }

    State uiState = State.CHOOSING;

    public MainUI(){

        setupStudents();
        System.out.println(students);

        buttonChooseStudent = new Button("Choose student");
        yesButton = new Button("Yes");
        noButton = new Button("No");
        buttonChooseStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseVolunteer();
                repaint();
            }
        });
        yesButton.addActionListener(e -> {
            workingList.remove(pos);
            uiState = State.CHOOSING;
            add(buttonChooseStudent);
            MainUI.this.repaint();
        });
        noButton.addActionListener( e -> {
            uiState = State.CHOOSING;
            add(buttonChooseStudent);
            MainUI.this.repaint();
        });
        add(buttonChooseStudent);
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.decode("#ffdfbf"));
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLACK);
        int width = getWidth();
        int height = getHeight();

        Point centerPoint = new Point(width/2,height/2);
        float nameFontSize = height/10f;//10% of the height, so that it can scale
        float verifyFotSize = height/15f;

        Graphics2D g2d = (Graphics2D) g;

        switch (uiState){
            case CHOOSING:{
                remove(yesButton);
                remove(noButton);
                //outside state
                float buttonFontSize = height/20f;
                String button = "Choose Volunteer";
                g2d.setFont(g2d.getFont().deriveFont(buttonFontSize));
                FontMetrics fm = g2d.getFontMetrics();
                int chooseButtonTS = fm.stringWidth(button);
                g2d.setColor(Color.CYAN);
                g2d.fillRect(centerPoint.x - (chooseButtonTS/2), centerPoint.y - (int)buttonFontSize,chooseButtonTS,(int)buttonFontSize);
                g2d.setColor(Color.BLACK);
                g2d.drawString(button,centerPoint.x - (chooseButtonTS/2), centerPoint.y);

                buttonChooseStudent.setBounds(centerPoint.x, centerPoint.y,
                        chooseButtonTS, (int) buttonFontSize);
                break;

            }
            case COUNTDOWN: {
                remove(buttonChooseStudent);
                g2d.setFont(g2d.getFont().deriveFont(height/2f));
                g2d.setColor(Color.decode("#eb4034"));
                g2d.drawString(uiCounter, centerPoint.x, centerPoint.y);

                g2d.setColor(Color.BLACK);
                String name = workingList.get(pos).getFirstName();
                g2d.setFont(g2d.getFont().deriveFont(nameFontSize));
                FontMetrics fm = g2d.getFontMetrics();
                int nameScreenLen = fm.stringWidth(name);
                g2d.drawString(name, centerPoint.x - (nameScreenLen / 2), centerPoint.y - nameFontSize);
                break;
            }
            case VERIFY: {
                String verifyQ = "Did they answer correctly?";
                g2d.setFont(g2d.getFont().deriveFont(verifyFotSize));
                FontMetrics fm = g2d.getFontMetrics();
                g2d.drawString(verifyQ, 0f, centerPoint.y);
                yesButton.setBounds(centerPoint.x - width/10,centerPoint.y + height/10 + height/20,width/10,height/20);
                noButton.setBounds(centerPoint.x , centerPoint.y + height/10 + height/20,width/10,height/20);
                break;
            }
        }


    }






    //-----------------------------------
    private static void setupStudents() {
        students = new ArrayList<>();
        Scanner sc = new Scanner(MainUI.class.getClassLoader().getResourceAsStream("names.txt"));
        while(sc.hasNextLine()){
            String name = sc.nextLine();
            String[] fullName = name.split(" ");
            String firstName = fullName[0];
            String lastName = fullName[fullName.length-1];
            students.add(new Student(firstName, lastName));
        }
    }

    private void chooseVolunteer() {
        if(workingList == null || workingList.isEmpty())
            workingList = (ArrayList<Student>)students.clone();
        uiState = State.COUNTDOWN;
        Random r = new Random();
        pos = r.nextInt(workingList.size());
        System.out.println("The chosen volunteer is:");

        System.out.println(workingList.get(pos).getFirstName());

        Thread counter = new Thread(new Runnable() {
            @Override
            public void run() {
                uiCounter = "" + DELAY_IN_SECONDS;
                for (int i = 0; i<= DELAY_IN_SECONDS; i++){
                    System.out.println(DELAY_IN_SECONDS-i);
                    try {
                        Thread.sleep(1000);
                        uiCounter = "" + (DELAY_IN_SECONDS - i);
                        MainUI.this.repaint();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                add(yesButton);
                add(noButton);
                uiState = State.VERIFY;
                //--------------------------->

//                System.out.print("Did they answer correctly? :");
//                Scanner sc = new Scanner(System.in);
//                String in = sc.nextLine();
//                if(in.equals("y") || in.equals("Y")){
//                    System.out.println("Good job "+ workingList.get(pos).getFirstName()+"!");
//                    workingList.remove(pos);
//                }
//                else{
//                    System.out.println("Well tried "+workingList.get(pos).getFirstName()+"!\nAdding them back to the queue");
//                }
                //manually moving to state 0//
//                add(buttonChooseStudent);
//                uiState = State.CHOOSING;
//                repaint();
            }
        });
        counter.start();
    }



}
