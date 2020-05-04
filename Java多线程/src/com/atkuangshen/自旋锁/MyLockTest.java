package com.atkuangshen.自旋锁;

import java.util.concurrent.TimeUnit;

public class MyLockTest {
    static MyLockDemo myLockDemo = new MyLockDemo();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            myLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                myLockDemo.myUnLock();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(5);
        new Thread(()->{
            myLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                myLockDemo.myUnLock();
            }
        },"B").start();
    }
}
