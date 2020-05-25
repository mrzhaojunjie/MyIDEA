package com.atguigu;

import java.util.concurrent.CountDownLatch;

public class testCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);
        latchDemo ld = new latchDemo(latch);
        long start = System.currentTimeMillis();
        for(int i =0;i < 5;i++){
            new Thread(ld).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为"+(end-start));

    }
}
class latchDemo implements Runnable{
    private CountDownLatch latch;
    public latchDemo(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        synchronized(this){
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            }finally {
                latch.countDown();
            }
        }
    }
}
