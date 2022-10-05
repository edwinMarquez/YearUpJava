package com.yearup.week7.functionalprograming.finterfaces;

import com.yearup.week7.functionalprograming.MathOperation;

@FunctionalInterface
public interface CalculatorListener {

    MathOperation onDoOperation(String operation) throws Exception;
}
