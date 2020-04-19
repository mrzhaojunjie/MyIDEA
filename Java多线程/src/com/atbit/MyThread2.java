package com.atbit;

public class MyThread2 {
    static class myThread1 extends Thread{
        @Override
        public void run() {

        }
    }
    static class myThread2 implements Runnable{

        @Override
        public void run() {

        }
    }
    public static void main(String[] args) {
        myThread1 m1 = new myThread1();
        m1.start();
        myThread2 m2 = new myThread2();
        Thread thread1 = new Thread(m2);
        System.out.println("线程m1的id"+m1.getId());
        System.out.println("线程m1的优先级"+m1.getPriority());
        System.out.println("线程m1的当前状态"+m1.isAlive());
        System.out.println("线程m1是否是后台线程"+m1.isDaemon());
        System.out.println("线程m1是否被中断"+m1.isInterrupted());
    }
}
