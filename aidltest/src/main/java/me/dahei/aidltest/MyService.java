package me.dahei.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * created by yubosu
 * 2018年07月31日下午2:48
 */
public class MyService extends Service {

    private String TAG = "MyService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "oncreate");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return new serviceImpl();
    }

    public class serviceImpl extends IMyAidlInterface.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString){

        }

        @Override
        public String getJob(int age, int gender, String name){
            return name + "-" + age + "-" + (gender == 0 ? "男" : "女");
        }
    }
}
