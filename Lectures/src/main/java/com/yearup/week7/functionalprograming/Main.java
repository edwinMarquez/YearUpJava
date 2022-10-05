package com.yearup.week7.functionalprograming;

import java.util.Scanner;
import java.util.Stack;

public class Main {


    //parse math operation in the form (+(* a b) c) = (a*b) + c
    //(* (+ a b) c)
    //1 + 2 * 24 -5;

    public static void main(String[] args){

        MathOperation sum = (l,r)->l+r;
        MathOperation res = (l,r)-> l-r;
        MathOperation mult = (l,r)->l*r;
        MathOperation div = (l,r)->l/r;

        Calculator calc = new Calculator((operator)->{
            return switch (operator) {
                case "+" -> sum;
                case "-" -> res;
                case "*" -> mult;
                case "div" -> div;
                default -> throw new Exception("bad operation");
            };
        });

        calc.start();

    }


}
