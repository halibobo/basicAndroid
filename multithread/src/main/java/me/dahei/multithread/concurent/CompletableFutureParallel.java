package me.dahei.multithread.concurent;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import me.dahei.basis.Test;
import me.dahei.multithread.concurent.model.OrderInfo;

/**
 * created by yubosu
 * 2018年09月18日下午3:36
 */
public class CompletableFutureParallel implements Test {

    private String tag = "CompletableFutureParallel";
    private static final int CORE_POOL_SIZE = 4;
    private static final int MAX_POOL_SIZE = 12;
    private static final long KEEP_ALIVE_TIME = 5L;
    private final static int QUEUE_SIZE = 1600;

    protected final static ExecutorService THREAD_POOL = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<>(QUEUE_SIZE));


    public void test() throws InterruptedException, ExecutionException, TimeoutException {
        OrderInfo orderInfo = new OrderInfo();
        //CompletableFuture 的List
        List<CompletableFuture> futures = new ArrayList<>();
        futures.add(CompletableFuture.runAsync(() -> {
            Log.d(tag, "当前任务Customer,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setCustomerInfo("");
        }, THREAD_POOL));
        futures.add(CompletableFuture.runAsync(() -> {
            Log.d(tag, "当前任务Discount,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setDiscountInfo("");
        }, THREAD_POOL));
        futures.add(CompletableFuture.runAsync(() -> {
            Log.d(tag, "当前任务Food,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setFoodListInfo("");
        }, THREAD_POOL));
        futures.add(CompletableFuture.runAsync(() -> {
            Log.d(tag, "当前任务Other,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setOtherInfo("");
        }, THREAD_POOL));
        CompletableFuture allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allDoneFuture.get(10, TimeUnit.SECONDS);
        System.out.println(orderInfo);
    }

    @Override
    public void doTest() {
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTestName() {
        return "CompletableFutureParallel";
    }
}
