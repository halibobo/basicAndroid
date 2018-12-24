package me.dahei.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * created by yubosu
 * 2018年12月20日5:40 PM
 */

public class Student {

    @Person(name = "name--")
    private String name;

    public static void main(String[] args) {
        boolean hasAnnotation = Student.class.isAnnotationPresent(Person.class);
        if (hasAnnotation) {
            Person testAnnotation = Student.class.getAnnotation(Person.class);

            System.out.println("id:" + testAnnotation.name());
            System.out.println("msg:" + testAnnotation.age());
        }else{
            System.out.println("no class");
        }

        try {
            Field a = Student.class.getDeclaredField("name");
            a.setAccessible(true);
            //获取一个成员变量上的注解
            Person check = a.getAnnotation(Person.class);

            if (check != null) {
                System.out.println("check value:" + check.name());
            }

            Method testMethod = Student.class.getDeclaredMethod("test");

            if (testMethod != null) {
                // 获取方法中的注解
                Annotation[] ans = testMethod.getAnnotations();
                for (int i = 0; i < ans.length; i++) {
                    System.out.println("method testMethod annotation:" + ans[i].annotationType().getSimpleName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Person(name = "hello", age = 33)
    private void test() {

    }
}
