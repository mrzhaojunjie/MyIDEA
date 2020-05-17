package com.atkuangshen;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        /*ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        ExecutorService executorService3 = Executors.newCachedThreadPool();*/
        System.out.println(Runtime.getRuntime().availableProcessors());  //查看计算机CPU的核数
     /*   ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );
        threadPool.execute(()->{
            //业务代码
        });*/
    }
}
