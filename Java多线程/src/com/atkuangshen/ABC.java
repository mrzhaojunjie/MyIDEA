package com.atkuangshen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for(int i = 1;i <=10;i++){
                data.PrintA(i);
            }
        },"打印A").start();
        new Thread(()->{
            for(int i = 1;i <=10;i++){
                data.PrintB(i);
            }
        },"打印B").start();
        new Thread(()->{
            for(int i = 1;i <=10;i++){
                data.PrintC(i);
                System.out.println("---------------------------------");
            }
        },"打印C").start();
    }
}
class Data{
    private Lock lock = new ReentrantLock();
    public Condition condition1 = lock.newCondition();
    public Condition condition2 = lock.newCondition();
    public Condition condition3 = lock.newCondition();
    private int number = 1;
    public void PrintA(int ptn){
        lock.lock();
        try {
            while (number != 1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"---> 第"+ptn+"遍");
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void PrintB(int ptn){
        lock.lock();
        try {
            while (number != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"---> 第"+ptn+"遍");
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void PrintC(int ptn){
        lock.lock();
        try {
            while (number != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"---> 第"+ptn+"遍");
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
