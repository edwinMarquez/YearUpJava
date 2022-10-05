package com.yearup.week7.functionalprograming;


import com.yearup.week7.functionalprograming.finterfaces.CalculatorListener;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * This is a calculator that doesn't know how to calculate. 🤖 on lazy developers to do list.
 */
public class Calculator {

    CalculatorListener listener;
    Scanner scanner;
    Stack<String> operators = new Stack<>();//symbols
    Stack<Double> operands = new Stack<>();//numbers

    //keeping this locally, calculator know a bit
    HashMap<String, Integer> precedence = new HashMap<>();

    public Calculator(CalculatorListener listener){
        this.listener = listener;
        scanner = new Scanner(System.in);
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*",2);
        precedence.put("/", 2);
    }


    public void start() {
        String line;
        while(true){
            operators.clear();
            operands.clear();
            System.out.println("What are you calculating today: (quit to exit)");
            line = scanner.nextLine();
            if(line.trim().equals("quit"))break;


            try {
                //parsing input.
                boolean isParsingANumber = false;
                boolean isParsingAOperand = false;
                StringBuilder number = new StringBuilder();
                StringBuilder operator = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char target = line.charAt(i);
                    if (Character.isDigit(target)) {
                        if (isParsingAOperand) {
                            //push operand to the stack
                            operators.push(operator.toString());
                            isParsingAOperand = false;
                            //---> check operand
                        }
                        isParsingANumber = true;
                        number.append(target);
                    } else if (target == ' ') {
                        //special case.
                        if (isParsingANumber) {
                            operands.push(Double.parseDouble(number.toString()));
                            isParsingANumber = false;
                        }
                        if(isParsingAOperand){
                            operators.push(operator.toString());
                            isParsingAOperand = false;
                            //---> check operand
                        }
                    } else{
                        if(isParsingANumber){
                            operands.push(Double.parseDouble(number.toString()));
                            isParsingANumber = false;
                        }
                        isParsingAOperand = true;
                        operator.append(target);
                    }
                }
                //finish process it;
                Double result;
                while(!operators.isEmpty()){
                    operators.pop();
                }
            }catch (Exception e){
                System.out.println("Error processing operation. try another one or quit to exit");
            }

        }
    }
}
