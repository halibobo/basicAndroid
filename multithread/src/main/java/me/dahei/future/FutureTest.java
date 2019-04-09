package me.dahei.future;

import android.os.Looper;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import me.dahei.basis.Test;

/**
 * created by yubosu
 * 2019年02月11日2:11 PM
 */
public class FutureTest implements Test {

    @Override
    public void doTest() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() {
                Log.e("Callable", "Callable");
                System.out.println("Callable");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "12345";
            }
        });
        executor.execute(futureTask);
        try {
            Log.e("isMain", "，" + (Looper.getMainLooper() == Looper.myLooper()));

            String result = futureTask.get();
            Log.e("result", "result" + result);
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTestName() {
        return "Future test";
    }

    public static void main(String[] args) {
        new FutureTest().doTest();
    }
}
