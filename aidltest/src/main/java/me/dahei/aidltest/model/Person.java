package me.dahei.aidltest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * created by yubosu
 * 2018年07月31日上午9:36
 */
public class Person implements Parcelable {

    private int age;
    private int gender;
    private String name;

    public Person(int age, int gender, String name) {
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

    public Person(Parcel in) {
        age = in.readInt();
        gender = in.readInt();
        name = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(age);
        parcel.writeInt(gender);
        parcel.writeString(name);
    }
}
