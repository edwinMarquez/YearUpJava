package com.yearup.week7.annotationssample.annotatios;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Describe {
    String value();
}
