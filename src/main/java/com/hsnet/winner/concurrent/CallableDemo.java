package com.hsnet.winner.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhanggl on 2017/9/11.
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(new TaskWithResult(i));
            resultList.add(future);
        }
        resultList.stream().forEach(e -> {
            try {
                System.out.println(e.get());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        });

    }
}

class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
//        System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
        return "call()方法被自动调用，任务返回的结果是：" + id + "  " + Thread.currentThread().getName();
    }
}
