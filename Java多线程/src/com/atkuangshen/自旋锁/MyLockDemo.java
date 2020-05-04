package com.atkuangshen.自旋锁;

import java.util.concurrent.atomic.AtomicReference;

public class MyLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = new Thread();
        System.out.println(Thread.currentThread().getName()+"上锁");

        while (atomicReference.compareAndSet(null,thread)){

        }
    }
    public void myUnLock(){
        Thread thread = new Thread();
        System.out.println(Thread.currentThread().getName()+"解锁");
        atomicReference.compareAndSet(thread,null);
    }
}
