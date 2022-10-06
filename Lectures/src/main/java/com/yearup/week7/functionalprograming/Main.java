package com.yearup.week7.functionalprograming;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

public class Main {


    //parse math operation in the form (+(* a b) c) = (a*b) + c
    //(* (+ a b) c)
    //1 + 2 * 24 -5;

    private static HashMap<String, Integer> precedence = new HashMap<>();

    public static void main(String[] args){
        precedence.put("+", 1);
        precedence.put("-" , 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        MathOperation sum = (l,r)->l+r;
        MathOperation res = (l,r)-> l-r;
        MathOperation mult = (l,r)->l*r;
        MathOperation div = (l,r)->l/r;

        Calculator calc = new Calculator((operator)->{
            return switch (operator) {
                case "+" -> sum;
                case "-" -> res;
                case "*" -> mult;
                case "/" -> div;
                default -> throw new Exception("bad operation");
            };
        }, (opA, opB)->{
            Integer precedenceA = precedence.get(opA);
            Integer precedenceB = precedence.get(opB);
            if(precedenceA == null || precedenceB == null)return true;//not on the list.
            return precedenceA > precedenceB;
        });

        calc.start();

    }


}
