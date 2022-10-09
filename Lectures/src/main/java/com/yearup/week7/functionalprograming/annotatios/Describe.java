package com.yearup.week7.functionalprograming.annotatios;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Describe {
    String value();
}
