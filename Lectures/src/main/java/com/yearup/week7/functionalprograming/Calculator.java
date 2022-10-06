package com.yearup.week7.functionalprograming;


import com.yearup.week7.functionalprograming.finterfaces.CalculatorListener;
import com.yearup.week7.functionalprograming.finterfaces.PrecedenceChecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * This is a calculator that doesn't know how to calculate. 🤖 on lazy developers to do list.
 */
public class Calculator {

    CalculatorListener listener;
    PrecedenceChecker precedenceChecker;
    Scanner scanner;
    Stack<String> operators = new Stack<>();//symbols
    Stack<Double> operands = new Stack<>();//numbers

    public Calculator(CalculatorListener listener, PrecedenceChecker precedenceChecker){
        this.listener = listener;
        this.precedenceChecker = precedenceChecker;
        scanner = new Scanner(System.in);
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
                    if (Character.isDigit(target) || target == '.') {
                        if (isParsingAOperand) {
                            //push operand to the stack
                            String currentOperator = operator.toString();
                            operator.delete(0, operator.length());
                            isParsingAOperand = false;
                            //---> check operand
                            if(operators.size() >=1 && precedenceChecker.hasHigherPrecedence(operators.peek(),currentOperator)){
                                //previous had higher precedence. proceed to parse operator.
                                MathOperation mo = listener.onDoOperation(operators.pop());
                                Double operandB = operands.pop();
                                Double operandA = operands.pop();
                                operands.push(mo.calculate(operandA, operandB));
                            }
                            operators.push(currentOperator);
                        }
                        isParsingANumber = true;
                        number.append(target);
                    } else if (target == ' ') {
                        //special case.
                        if (isParsingANumber) {
                            operands.push(Double.parseDouble(number.toString()));
                            number.delete(0, number.length());
                            isParsingANumber = false;
                        }
                        if(isParsingAOperand){
                            String currentOperator = operator.toString();
                            operator.delete(0, operator.length());
                            isParsingAOperand = false;
                            //---> check operand
                            if(operators.size() >=1 && precedenceChecker.hasHigherPrecedence(operators.peek(),currentOperator)){
                                //previous had higher precedence. proceed to parse operator.
                                MathOperation mo = listener.onDoOperation(operators.pop());
                                Double operandB = operands.pop();
                                Double operandA = operands.pop();
                                operands.push(mo.calculate(operandA, operandB));
                            }
                            operators.push(currentOperator);
                        }
                    } else{
                        if(isParsingANumber){
                            operands.push(Double.parseDouble(number.toString()));
                            number.delete(0, number.length());
                            isParsingANumber = false;
                        }
                        isParsingAOperand = true;
                        operator.append(target);
                    }
                }
                if(!operator.isEmpty())operators.push(operators.toString());
                if(!number.isEmpty())operands.push(Double.parseDouble(number.toString()));

                System.out.println("partial result");
                System.out.println(Arrays.toString(operators.toArray()));
                System.out.println(Arrays.toString(operands.toArray()));

                //finish process it;
                Double result;
                while(!operators.isEmpty()){
                    MathOperation mo = listener.onDoOperation(operators.pop());
                    Double operandB = operands.pop();
                    Double operandA = operands.pop();
                    operands.push(mo.calculate(operandA, operandB));
                }
                System.out.println("The result is: " + operands.pop());
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Error processing operation. try another one or quit to exit: ");
            }

        }
    }
}
