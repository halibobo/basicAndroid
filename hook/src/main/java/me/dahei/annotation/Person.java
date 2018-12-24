package me.dahei.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * created by yubosu
 * 2018年12月20日5:34 PM
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface Person {

    String name() default "hello";

    int age() default 20;

}
