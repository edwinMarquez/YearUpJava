package com.yearup.week2;

public class TypeCastingExercise1
{
	// Exercise to show that the final value is casted to the highest order data type.
    public static void main(String[] args)
    {
        Double doubleObject = Double.parseDouble("2.4");
        int integerValue = doubleObject.intValue();
        byte byteValue = doubleObject.byteValue();
        float floatValue = doubleObject.floatValue();
        double doubleValue = doubleObject.doubleValue();
	
System.out.println("int:");
System.out.println(integerValue);
System.out.println("byte:");
System.out.println(byteValue);
System.out.println("double:");
System.out.println(doubleValue);
System.out.println("float:");	
System.out.println(floatValue);
System.out.println ("sum of the values:"); 
System.out.println (integerValue + byteValue + floatValue + doubleValue); 
    }
}