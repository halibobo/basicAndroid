package me.dahei.multithread.produceConsume;

import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import me.dahei.basis.Test;

/**
 * created by yubosu
 * 2018年08月01日上午10:13
 */
public class QueueTest implements Test {

    private final String TAG = "QueueTest";
    final Store store = new Store();
    @Override
    public void doTest() {
//        new Thread(new AppleProducer()).start();
//        new Thread(new Dealer()).start();
//        new Thread(new Dealer()).start();
//        new Thread(new AppleProducer()).start();


        final Dealer consumer = new Dealer(store, "顾客1");
        final Dealer consumer2 = new Dealer(store, "顾客2");
        final Dealer consumer3 = new Dealer(store, "顾客3");

        AppleProducer producer = new AppleProducer(store);
        HuaWeiProducer huaWeiProducer = new HuaWeiProducer(store);
        new Thread(producer).start();
        new Thread(huaWeiProducer).start();
        new Thread(consumer).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
        store.setNotify(new Store.Notify() {
            @Override
            public void addPhone() {
                consumer.stopWait();
                consumer2.stopWait();
                consumer3.stopWait();
            }
            @Override
            public void buyPhone() {

            }
        });
    }

    @Override
    public String getTestName() {
        return "queue test";
    }

    private static Integer count = 0;//缓冲区
    private final Integer FULL = 5;
    final Lock lock = new ReentrantLock(); //获得可重入锁
    final Condition put = lock.newCondition();
    final Condition get = lock.newCondition();

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == FULL) {
                        try {
                            put.await();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    count++;
                    Log.d(TAG,Thread.currentThread().getName() + "produce:: " + count);
                    get.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == 0) {
                        try {
                            get.await();
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }
                    count--;
                    Log.d(TAG,Thread.currentThread().getName()+ "consume:: " + count);
                    put.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
