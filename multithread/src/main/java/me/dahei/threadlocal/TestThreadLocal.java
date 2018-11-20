package me.dahei.threadlocal;

import me.dahei.basis.Test;

/**
 * created by yubosu
 * 2018年11月14日3:55 PM
 */
public class TestThreadLocal implements Test {


    @Override
    public void doTest() {
        Thread t = new Thread() {
            ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("me.dahei");
                mStringThreadLocal.get();
            }
        };

        t.start();
    }

    @Override
    public String getTestName() {
        return "thread local test";
    }


}
