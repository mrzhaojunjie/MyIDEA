package com.atguigu;

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w = new Window2();
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
class Window2 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            //synchronized (obj) {
           // synchronized (this) {
                //synchronized(Window1.class){
               show();
            }
        }
        public synchronized void show(){   //此处的同步监视器为this
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
                ticket--;
            }
        }
    }

