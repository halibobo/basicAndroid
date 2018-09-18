package me.dahei.multithread.concurent;

import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import me.dahei.basis.Test;
import me.dahei.multithread.concurent.model.OrderInfo;

/**
 * created by yubosu
 * 2018年09月18日下午3:26
 */
public class CountDownTask implements Test {

    private String tag = "CountDownTask";

    private static final int CORE_POOL_SIZE = 4;
    private static final int MAX_POOL_SIZE = 12;
    private static final long KEEP_ALIVE_TIME = 5L;
    private final static int QUEUE_SIZE = 1600;

    protected final static ExecutorService THREAD_POOL = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<>(QUEUE_SIZE));

    public void startTest() throws InterruptedException {
        // 新建一个为5的计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        OrderInfo orderInfo = new OrderInfo();
        THREAD_POOL.execute(() -> {
            Log.d(tag,"当前任务Customer,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setCustomerInfo("setCustomerInfo");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            Log.d(tag,"当前任务Discount,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setDiscountInfo("dis");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            Log.d(tag,"当前任务Food,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setFoodListInfo("setFoodListInfo");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            Log.d(tag,"当前任务Tenant,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setTenantInfo("TenantInfo");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            Log.d(tag,"当前任务OtherInfo,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setOtherInfo("OtherInfo");
            countDownLatch.countDown();
        });
        boolean success = countDownLatch.await(5, TimeUnit.SECONDS);
        Log.d(tag, "success is " + success);
        Log.d(tag,"主线程：" + Thread.currentThread().getName());
    }

    @Override
    public void doTest() {
        try {
            startTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTestName() {
        return "CountDownTask test";
    }
}
