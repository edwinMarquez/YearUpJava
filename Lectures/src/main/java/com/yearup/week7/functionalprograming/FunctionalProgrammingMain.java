package com.yearup.week7.functionalprograming;

import com.yearup.week7.functionalprograming.finterfaces.DoubleGenerator;
import com.yearup.week7.functionalprograming.finterfaces.DoubleGenerator2Param;

public class FunctionalProgrammingMain {

    public static void main(String[] args){

        //lambda syntax.
        DoubleGenerator logBaseE = (param) -> Math.log(param); //lambda expression.
        System.out.println("Log base e of 10 is: " + logBaseE.getValue(10L));

        //using two parameters
        DoubleGenerator2Param logBase10 = (base, value) -> Math.log(value)/Math.log(base);
        System.out.println("Log base 10, of 100 is: " + logBase10.getValue(10d,100d));

        //this is how an anonymous class would look like instead:
        DoubleGenerator anonymousLogBaseE = new DoubleGenerator() {
            @Override
            public Double getValue(long param) {
                return Math.log(param);
            }
        };
        System.out.println("Log base e of 10 is: " + anonymousLogBaseE.getValue(10L));

    }

}
