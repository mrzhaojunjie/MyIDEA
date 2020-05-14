package exer;

import java.util.Scanner;

public class exchangePrint {
    public static void main(String[] args) {
        Print print = new Print();
        Thread t1 = new Thread(print);
        Thread t2 = new Thread(print);

        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }


}
class Print implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while(true){
            synchronized(this){
                notify();
                if(number <= 100){
                    System.out.println(Thread.currentThread().getName()+"打印"+number);
                    number++;
                }else{
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


