package exer;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    public static void main(String[] args) {
        readWriteLockDemo rd = new readWriteLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                rd.set((int) (Math.random() * 101));
            }
        }, "Write").start();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rd.get();
                }
            }).start();
        }
    }
}
class readWriteLockDemo{
    private int number = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void get(){
        lock.readLock().lock();
        try {

            System.out.println(Thread.currentThread().getName()+":"+number);
        }finally {
            lock.readLock().unlock();
        }
    }
    public void set(int number){
        lock.writeLock().lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }finally {
            lock.writeLock().unlock();
        }
    }
}
