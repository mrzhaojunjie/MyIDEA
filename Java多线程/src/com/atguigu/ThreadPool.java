package com.atguigu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new numberThread1());
        service.execute(new numberThread2());
    }
}
class numberThread2 implements Runnable{
    @Override
    public void run() {
        for(int i = 1;i <= 100;i++){
            if(i % 2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class numberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
