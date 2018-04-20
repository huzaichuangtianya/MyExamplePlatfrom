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
public @interface Factory {
    /**
     * 工厂的名字
     */
    Class type();

    /**
     * 用来表示生成哪个对象的唯一id
     */
    String id();
}
