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
    private static String uiCounter = "";
    /**
     * unfortunate way to handle state. due to time
     * 0 : choosing phase.
     * 1: count down.
     */
    private static AtomicInteger uiState = new AtomicInteger(0);
    public MainUI(){

        setupStudents();
        System.out.println(students);


        buttonChooseStudent = new Button("Choose student");
        buttonChooseStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
                chooseVolunteer();
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
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

        Graphics2D g2d = (Graphics2D) g;

        int state = uiState.get();
        switch (state){
            case 0:{
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
            case 1:
                remove(buttonChooseStudent);
                //currently on timer
                String name = workingList.get(pos).getFirstName();
                g2d.setFont(g2d.getFont().deriveFont(nameFontSize));
                FontMetrics fm = g2d.getFontMetrics();
                int nameScreenLen = fm.stringWidth(name);
                //test
                g2d.drawString(uiCounter,centerPoint.x, centerPoint.y);

                g2d.drawString(name,centerPoint.x - (nameScreenLen/2), centerPoint.y - nameFontSize);
                break;
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
        uiState.set(1); //change ui state to 1, currently on choose.
        Random r = new Random();
        pos = r.nextInt(workingList.size());
        System.out.println("The chosen volunteer is:");

        System.out.println(workingList.get(pos).getFirstName());

        Thread counter = new Thread(new Runnable() {
            @Override
            public void run() {
                uiCounter = "" + DELAY_IN_SECONDS;
                for (int i = 0; i< DELAY_IN_SECONDS; i++){
                    System.out.println(DELAY_IN_SECONDS-i);
                    try {
                        Thread.sleep(1000);
                        uiCounter = "" + (DELAY_IN_SECONDS - i);
                        MainUI.this.repaint();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("Did they answer correctly? :");
                Scanner sc = new Scanner(System.in);
                String in = sc.nextLine();
                if(in.equals("y") || in.equals("Y")){
                    System.out.println("Good job "+ workingList.get(pos).getFirstName()+"!");
                    workingList.remove(pos);
                }
                else{
                    System.out.println("Well tried "+workingList.get(pos).getFirstName()+"!\nAdding them back to the queue");
                }
                //manually moving to state 0//
                add(buttonChooseStudent);
                uiState.set(0);
                repaint();
            }
        });
        counter.start();
    }



}
