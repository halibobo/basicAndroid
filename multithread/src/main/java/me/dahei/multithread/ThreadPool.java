package me.dahei.multithread;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * created by yubosu
 * 2018年08月01日上午9:45
 */
public class ThreadPool {

    private int workCount = 3;
    private Thread[] workThread;

    private ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue = new ConcurrentLinkedQueue();

}
