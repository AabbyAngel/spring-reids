package com.hsnet.winner.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhanggl on 2017/9/11.
 */
public class TestCachedThreadPool {

    public static void main(String[] args) {
        //缓存型池子，先查看池中是否有以前建立的线程，如果有，就复用，如果没有，就新建一个线程假如池子
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TestRunnable());
            System.out.println("**************** a" + i + "****************");
        }
        executorService.shutdown();
    }



}

class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
    }
}
