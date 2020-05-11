package com.atkuangshen;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class test2 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1;i <= countDownLatch.getCount();i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go out");
                countDownLatch.countDown();
            },"线程"+i).start();

        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程全部执行完，主线程执行");
    }
}
class CyclicBarrirTest{
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,new Thread(()->{
            System.out.println("收集七个龙珠召唤神龙");
        }));
        for(int i = 1;i <= 7;i++){
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"召唤了第"+temp+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
