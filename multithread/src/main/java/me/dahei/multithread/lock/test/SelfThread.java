package me.dahei.multithread.lock.test;

/**
 * created by yubosu
 * 2018年10月13日10:46 AM
 */
public class SelfThread implements Runnable {

    public static String str1 = "";
    public static String str2 = "";
    private int i = 1;

    public SelfThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        if (i == 1) {
            synchronized (str1) {
                try {
                    System.out.println("thread1 pre sleep");
                    Thread.sleep(2000);
                    System.out.println("thread1 after sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (str2) {
                    System.out.println("thread1获得str2");
                }
            }
        } else if (i == 2) {
            synchronized (str2) {
                try {
                    System.out.println("thread2 pre sleep");
                    Thread.sleep(1000);
                    System.out.println("thread2 after sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (str1) {
                    System.out.println("thread1获得str1");
                }
            }
        }
    }
}
