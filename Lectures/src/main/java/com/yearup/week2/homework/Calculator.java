package com.yearup.week2.homework;
import java.util.*;
//LuClandereine Leger
//Week 2 Homework Year Up Java

interface Calculator{
    //Create a Calculator interface within the above package, with the following methods
    double Area(double length, double width);

    double Sum(double num1, double num2);

    double Volume(double length, double width, double height);

}
class Square implements Calculator{
    //Create a class which implements the above package
    private double length;//part 3 step 4
    Scanner scanner = new Scanner(System.in);
    void setLength(){
        System.out.println("What is the length?");
        this.length = scanner.nextDouble();
        //The display message to get the user input and assigning the scanner value should be in a separate method
    }
    double getLength(){
        return this.length;
    }

    @Override
    public double Area(double length,double w) {
        return this.length*this.length;
        //part 3 step 5
    }

    void showArea(){
        System.out.println("The area is " + this.length*this.length);
    }

    @Override
    public double Sum(double num1, double num2) {
        return 0;
    }

    @Override
    public double Volume(double length, double width, double height) {
        return 0;
    }

}

class Main{
    public static void main(String[] args){
        double length; // part 3 step 3
        System.out.println("------------------------------\n"+
                            "Welcome to the Calculator!!!\n"+
                            "-----------------------------\n");

        Square square = new Square();
        square.setLength();
        length = square.getLength();
        square.Area(length,length);
        square.showArea();
    }
}
