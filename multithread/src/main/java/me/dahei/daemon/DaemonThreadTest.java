package me.dahei.daemon;

import java.util.concurrent.TimeUnit;

/**
 * created by yubosu
 * 2018年12月19日3:30 PM
 */
public class DaemonThreadTest {


    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread childThread = new Thread(new ChildThread());
                childThread.setDaemon(true);
                childThread.start();
                startNewThread();
                System.out.println("main thread run ...");
            }
        });
        thread.start();
    }

    private static void startNewThread() {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count <= 5) {
                    try {
                        System.out.println("thread2 run ...");
                        TimeUnit.MILLISECONDS.sleep(1000);
                        count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread2.start();
    }
}
