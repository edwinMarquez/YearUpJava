package com.yearup.week7.annotationssample.annotatios;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //source , class or runtime.
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
/*
Element type: https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/ElementType.html
 */
public @interface Describe {
    String value();
}
