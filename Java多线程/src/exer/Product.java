package exer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        productor pro = new productor(clerk);
        Thread t1 = new Thread(pro);
        consumer con = new consumer(clerk);
        Thread t2 = new Thread(con);
        t1.start();
        t2.start();
    }
}
class Clerk{
    private int productorCount = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produceProductor() {
        lock.lock();
        try {
            if(productorCount < 20){
                productorCount++;
                System.out.println("生产者生产第"+productorCount+"个产品");
                //此时生产了就可以消费了，唤醒消费线程
                /*notify();*/
                condition.signal();
            }else{
                /*try {
                    //如果等于20个就不再生产，让线程等待阻塞
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }
    }

    public void consumeProductor() {
        lock.lock();
        try {
            if(productorCount > 0){
                System.out.println("消费者消费第"+productorCount+"个产品");
                productorCount--;
                //消费了之后就可以生产了，此时唤醒生产线程
                condition.signal();
            }else{
                /*try {
                    //如果等于零，就不再消费，线程就阻塞。
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }
    }
}
class productor implements Runnable{  //生产者
    private Clerk clerk;

    public productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProductor();
        }
    }


}
class consumer implements Runnable{  //消费者
    private Clerk clerk;

    public consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProductor();
        }
    }
}
