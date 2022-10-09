package com.yearup.week7.functionalprograming;

import com.yearup.week7.functionalprograming.finterfaces.DoubleGenerator;
import com.yearup.week7.functionalprograming.finterfaces.DoubleGenerator2Param;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.function.Function;

public class FunctionalProgrammingMain {

    public static void main(String[] args){

        //lambda syntax.
        DoubleGenerator randomNum = () -> Math.random(); //lambda expression.
        System.out.println("Random Num 0-9: " + randomNum.getValue());

        DoubleGenerator randomNum1to100 = () -> Math.random()*99d + 1d; //up to 99.999....
        System.out.println("Random Num 1-100: " + randomNum1to100.getValue());

        //this is how an anonymous class would look like instead:
        DoubleGenerator anonymousRandomGen = new DoubleGenerator() {
            @Override
            public Double getValue() {
                return Math.random();
            }
        };

        //we might as well use block with our lambda expressions. if we need to use multiple statement:
        DoubleGenerator secureRandomGenerator = () -> {
            SecureRandom secureRandom = new SecureRandom();
            return secureRandom.nextDouble();
        };

        //with parameters.
        DoubleGenerator2Param randomInRange = (rStart, rEnd) -> rStart + Math.random()*(rEnd-rStart);//will fail when rStart > rEnd
        System.out.println("random from 10 to 20: " + randomInRange.getValue(10d,20d));


    }

}
