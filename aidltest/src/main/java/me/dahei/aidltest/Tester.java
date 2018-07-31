package me.dahei.aidltest;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import me.dahei.aidltest.model.Person;
import me.dahei.aidltest.model.SerialPerson;
import me.dahei.basis.AppContext;
import me.dahei.basis.Test;
import me.dahei.basis.util.FileUtil;

/**
 * created by yubosu
 * 2018年07月31日上午9:42
 */
public class Tester implements Test{

    private final String TAG = "AIDL_TESTER";

    @Override
    public void doTest() {
        testParcel();
        testSerial();
        loadSerial();
        loadParcel();
    }

    @Override
    public String getTestName() {
        return "Parcelable Serializable Test";
    }

    public void testSerial() {

        SerialPerson serialPerson = new SerialPerson(20, 1, "二十岁");

        File file = FileUtil.getFilePath(AppContext.getInstance(), "serialPerson.txt");
        long startTime = System.currentTimeMillis();
        Log.d(TAG, "Serial start millis = " + startTime);
        Log.d(TAG, "path=" + file.getPath());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(serialPerson);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        Log.d(TAG, "Serial end millis = " + endTime);
        Log.d(TAG, "Serial spend time = " + (endTime - startTime));
    }


    private void testParcel() {
        Person person = new Person(20, 1, "二十岁");

        File file =  FileUtil.getFilePath(AppContext.getInstance(), "person.txt");
        long startTime = System.currentTimeMillis();
        Log.d(TAG, "Parcel start millis = " + startTime);
        try {
            FileOutputStream oos = new FileOutputStream(file);
//            oos.writeObject(person);
            Parcel parcel = Parcel.obtain();
            parcel.writeParcelable(person, 0);
            oos.write(parcel.marshall());

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        Log.d(TAG, "Parcel end millis = " + endTime);
        Log.d(TAG, "Parcel spend time = " + (endTime - startTime));
    }

    private void loadSerial() {
        File file = FileUtil.getFilePath(AppContext.getInstance(), "serialPerson.txt");
        try {
            long startTime = System.currentTimeMillis();
            Log.d(TAG, "Serial read start millis = " + startTime);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            SerialPerson serialPerson = (SerialPerson) objectInputStream.readObject();
            long endTime = System.currentTimeMillis();
            Log.d(TAG, "Serial read end millis = " + endTime);
            Log.d(TAG, "serialPerson name " + serialPerson.getName());
            Log.d(TAG, "serialPerson read spend time = " + (endTime - startTime));
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadParcel() {
        File file = FileUtil.getFilePath(AppContext.getInstance(), "person.txt");
        try {
            long startTime = System.currentTimeMillis();
            Log.d(TAG, "parcel read start millis = " + startTime);
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(bytes,0,bytes.length);
            parcel.setDataPosition(0);
            Person person = Person.CREATOR.createFromParcel(parcel);
            long endTime = System.currentTimeMillis();
            Log.d(TAG, "parcel read end millis = " + endTime);
            Log.d(TAG, "parcel person name = " + person.getName());
            Log.d(TAG, "parcel read spend time = " + (endTime - startTime));
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
