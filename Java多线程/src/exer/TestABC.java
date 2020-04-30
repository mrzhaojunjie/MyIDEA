package exer;
//按ABCABCABC的顺序分别打印10遍
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestABC {
    public static void main(String[] args) {
        AlternateDemo alternateDemo = new AlternateDemo();
        new Thread(()->{
            for(int i = 1;i <=10;i++){
                alternateDemo.printA(i);
            }
        },"打印A").start();
        new Thread(()->{
            for(int i = 1;i <=10;i++){
                alternateDemo.printB(i);
            }
        },"打印B").start();
        new Thread(()->{
            for(int i = 1;i <=10;i++){
                alternateDemo.printC(i);
                System.out.println("------------------------------------------");
            }
        },"打印C").start();
    }
}
class AlternateDemo{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public void printA(int totalLoop){
        lock.lock();
        try {
            while (number != 1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+"A       第"+totalLoop+"遍");
            condition2.signal();
            number = 2;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(int totalLoop){
        lock.lock();
        try {
            while (number != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+"B       第"+totalLoop+"遍");
            condition3.signal();
            number = 3;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printC(int totalLoop){
        lock.lock();
        try {
            while (number != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+"C       第"+totalLoop+"遍");
            condition1.signal();
            number = 1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
