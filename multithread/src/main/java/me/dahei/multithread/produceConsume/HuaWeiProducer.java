package me.dahei.multithread.produceConsume;

import android.util.Log;

/**
 * created by yubosu
 * 2018年08月01日上午10:14
 */
public class HuaWeiProducer implements Runnable {

    private final String TAG = "AppleProducer";


    private Store store;

    public HuaWeiProducer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            Log.d(TAG, "华为工厂生产中...");
            for (int i = 0; i < 2; i++) {
                store.addPhone(new Phone("华为手机"));
                Log.d(TAG, "生产了一台华为手机");
            }
            try {
                Log.d(TAG, "华为工厂酝酿中...");
                Thread.sleep(8* 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
