package exer;

import java.util.concurrent.TimeUnit;

public class eightLockDemo {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone1.sendSms();
        },"线程1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone2.call();
        },"线程2").start();
    }

}
class Phone{
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"发短信");
    }
    public static synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"打电话");
    }
    public void play(){
        System.out.println(Thread.currentThread().getName()+"打游戏");
    }
}

