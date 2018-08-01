package me.dahei.multithread.produceConsume;

import android.util.Log;

/**
 * created by yubosu
 * 2018年08月01日上午10:14
 */
public class AppleProducer implements Runnable {

    private final String TAG = "AppleProducer";


    private Store store;

    public AppleProducer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            Log.d(TAG, "苹果工厂生产中...");
            for(int i=0;i<1;i++) {
                store.addPhone(new Phone("苹果手机"));
                Log.d(TAG, "生产了一台苹果手机");
            }
            try {
                Log.d(TAG, "苹果工厂酝酿中...");
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
