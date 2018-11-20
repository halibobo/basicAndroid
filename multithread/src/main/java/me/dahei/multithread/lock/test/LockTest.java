package me.dahei.multithread.lock.test;

/**
 * created by yubosu
 * 2018年10月13日10:39 AM
 */
public class LockTest {

    public static void main(String[] args) {
        SelfThread selfThread1 = new SelfThread(1);
        SelfThread selfThread2 = new SelfThread(2);
        new Thread((selfThread1)).start();
        new Thread((selfThread2)).start();

    }

}
