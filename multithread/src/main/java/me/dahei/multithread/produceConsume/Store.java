package me.dahei.multithread.produceConsume;

import android.util.Log;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * created by yubosu
 * 2018年08月01日上午10:22
 */
public class Store {

    private Notify notify;
    private ConcurrentLinkedQueue<Phone> phones = new ConcurrentLinkedQueue<>();

    public Phone buyPhone() {
        if (notify != null) {
            notify.buyPhone();
        }
        return phones.poll();
    }

    public boolean addPhone(Phone phone) {
        if (notify != null) {
            notify.addPhone();
        }
        Log.d("Store", "添加了一台" + phone.getName());
        return phones.add(phone);
    }

    public boolean hasPhone() {
        return !phones.isEmpty();
    }

    public void setNotify(Notify notify) {
        this.notify = notify;
    }

    interface Notify {
        void addPhone();

        void buyPhone();
    }
}
