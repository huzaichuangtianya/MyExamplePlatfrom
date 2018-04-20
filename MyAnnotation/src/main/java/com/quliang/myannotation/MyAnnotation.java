package com.quliang.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by quliang on 18-3-21.
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface MyAnnotation {

    String value();
}
