package com.atbit;

public class MyThread {
    private static final long count = 10_1000_0000L;
    private static final int N = 10;
    private static void calc(){
        long r = 0;
        for(int i = 0;i < count;i++){
            r += i;
        }
    }
    private static class CalcThread extends Thread{
        @Override
        public void run() {
            calc();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        CalcThread[] threads = new CalcThread[N-1];
        for(int i = 0; i < N-1;i++){
            CalcThread thread = new CalcThread();
            thread.start();
            threads[i] = thread;
        }
        calc();
        for(int i = 0;i < N-1;i++){
            threads[i].join();  //线程阻塞
        }
        long end = System.nanoTime();
        System.out.println("");
    }
}
