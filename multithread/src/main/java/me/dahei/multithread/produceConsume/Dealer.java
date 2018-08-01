package me.dahei.multithread.produceConsume;

import android.util.Log;

/**
 * created by yubosu
 * 2018年08月01日上午10:15
 */
public class Dealer implements Runnable {

    private final String TAG = "Dealer";

    private Store store;
    private String name;
    private boolean waiting = false;

    public Dealer(Store store, String name) {
        this.store = store;
        this.name = name;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void stopWait() {
        if (waiting) {
            try {
                synchronized (this) {
                    notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(3000);
                if(store.hasPhone()) {
                    Phone phone = store.buyPhone();
                    if (phone != null) {
                        Log.d(TAG, name + "买到了一台" + phone.getName());
                    }
                }else{
                    Log.d(TAG, name + "等待中");
                    synchronized (this){
                        waiting = true;
                        this.wait();
                        waiting = false;
                    }
                    Log.d(TAG, name + "排队中呢！");
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
