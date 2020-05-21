package com.atguigu;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Window3 implements Runnable{
    private int ticket = 100;
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try{
                lock.lock();  //上锁进去为单线程
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName()+"售票,票号为"+ticket);
                    ticket--;
                }else{
                    System.out.println("票已售空");
                    break;
                }
            }finally {  //最后解锁
                lock.unlock();
            }
        }
    }
}

