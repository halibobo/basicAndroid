package me.dahei.multithread.reentrantlock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import me.dahei.basis.Test;

/**
 * created by yubosu
 * 2018年09月26日10:47 AM
 */
public class ReentrantLockTest extends Thread  implements Test {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public static AtomicInteger integer = new AtomicInteger(0);

    public ReentrantLockTest(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        reentrantAdd();
//        syncAdd();
    }

    private void syncAdd() {
        for (int j = 0; j < 500000; j++) {
            try {
                System.out.println(this.getName() + " " + integer.incrementAndGet());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void reentrantAdd() {
        for (int j = 0; j < 500000; j++) {
            lock.lock();
            try {
                System.out.println(this.getName() + " " + i);
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void doTest() {
        ReentrantLockTest test1 = new ReentrantLockTest("thread1");
        ReentrantLockTest test2 = new ReentrantLockTest("thread2");
        ReentrantLockTest test3 = new ReentrantLockTest("thread3");
        ReentrantLockTest test4 = new ReentrantLockTest("thread4");

        long start = System.currentTimeMillis();
        test1.start();
        test2.start();
        test3.start();
        test4.start();
        try {
            test1.join();
            test2.join();
            test3.join();
            test4.join();
            long end = System.currentTimeMillis();
            System.out.println(i);
            System.out.println(integer.get());
            System.out.println("耗时："+(end-start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getTestName() {
        return "ReentrantLockTest";
    }
}
