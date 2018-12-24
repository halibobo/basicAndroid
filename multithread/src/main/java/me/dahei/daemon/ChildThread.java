package me.dahei.daemon;


import java.util.concurrent.TimeUnit;

/**
 * created by yubosu
 * 2018年12月19日3:31 PM
 */
public class ChildThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("child thread ");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
