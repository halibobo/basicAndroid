package me.dahei.aidltest.model;

import java.io.Serializable;

/**
 * created by yubosu
 * 2018年07月31日上午9:44
 */
public class SerialPerson implements Serializable {

    private final long SerialVersionUID = 1231231313l;

    private int age;
    private int gender;
    private String name;

    public SerialPerson(int age, int gender, String name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
