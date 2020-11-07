package com.atkuangshen;

public class pc {
    public static void main(String[] args) {
        Date date = new Date();
        new Thread(()->{
            for(int i = 0;i < 10;i++){
                try {
                    date.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i = 0;i < 10;i++){
                try {
                    date.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }

}
class Date{
    private  int number = 0;
    public synchronized void increment() throws InterruptedException {
        while (number != 0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"-->"+number);
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while (number == 0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"-->"+number);
        this.notifyAll();
    }
}
