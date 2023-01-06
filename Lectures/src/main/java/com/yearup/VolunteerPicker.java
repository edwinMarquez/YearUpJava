package com.yearup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class generates the volunteer who should answer the quiz
 */
public class VolunteerPicker {
    static ArrayList<Student> students;
    static ArrayList<Student> workingList;
    private static final int DELAY_IN_SECONDS = 5;

    public static void main(String[] args) {
        int input;
        do{
            setupStudents();
            System.out.println("*********************************************************");
            System.out.println("Your turn too shall come!!!");
            System.out.println("1. Choose Volunteer\n2. Remaining Students\n3. Exit");
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
            switch (input){
                case 1: chooseVolunteer();break;
                case 2: showRemainingStudents(); break;
                case 3: System.exit(0);
            }
        }while(input!=3);
    }

    private static void showRemainingStudents() {
        System.out.println("There are "+workingList.size()+" remaining Students. They are:");
        for (Student student :
                workingList) {
            System.out.println(student.getFirstName());
        }
    }

    private static void setupStudents() {
        students = new ArrayList<>();
        File f = new File("C:\\Users\\rishi\\OneDrive\\Documents\\GitHub\\students.txt");
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String name = sc.nextLine();
                String[] fullName = name.split(" ");
                String firstName = fullName[0];
                String lastName = fullName[fullName.length-1];
                students.add(new Student(firstName, lastName));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void chooseVolunteer() {
        if(workingList == null || workingList.isEmpty())
            workingList = (ArrayList<Student>)students.clone();

        Random r = new Random();
        int pos = r.nextInt(workingList.size());
        System.out.println("The chosen volunteer is:");
        for (int i = 0; i< DELAY_IN_SECONDS; i++){
            System.out.println(DELAY_IN_SECONDS-i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(workingList.get(pos).getFirstName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
    }
}


class Student{
    private String firstName;
    private String lastName;
    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString(){
        return firstName;
    }
}