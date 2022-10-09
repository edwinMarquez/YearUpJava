package com.yearup.week7.annotationssample;

import com.yearup.week7.annotationssample.annotatios.Cat;
import com.yearup.week7.annotationssample.annotatios.Describe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationsMain {

    public static void main(String[] args){
        System.out.println("Reading RUNTIME annotations");


        //Runtime annotations can be read on the program, as they are accessible on the JVM.
        //this is just to illustrate how can this be done using java reflections.
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Info about ");
        Class<Cat> catClass = Cat.class;
        Describe annotation = catClass.getAnnotation(Describe.class);
        stringBuilder.append(catClass.getSimpleName()).append(" Class: ").append(annotation.value()).append("\n");
        //get Annotations from parameters:
        Field[] fields = catClass.getFields();
        for(Field f: fields){
            Describe fAnnotation = f.getAnnotation(Describe.class);
            if(fAnnotation!= null){
                stringBuilder.append("Field ").append(f.getName()).append(": ")
                        .append(fAnnotation.value()).append("\n");
            }
        }
        //get Annotations from methods:
        Method[] methods = catClass.getMethods();
        for(Method m : methods){
            Describe mAnnotation = m.getAnnotation(Describe.class);
            if(mAnnotation != null){
                stringBuilder.append("Method ").append(m.getName()).append(": ")
                        .append(mAnnotation.value()).append("\n");
            }
        }
        System.out.println("==== cat class ======\n" + stringBuilder.toString() + "\n============");



    }





}
