package exer;


import java.util.concurrent.ThreadPoolExecutor;

public class AcountTest {
    public static void main(String[] args) {
        User user = new User();
        Thread t1 = new Thread(user);
        Thread t2 = new Thread(user);
        t1.setName("用户甲");
        t2.setName("用户乙");
        t1.start();
        t2.start();
    }
}
class Account{
    private double balance;
    public Account(double balance){
        this.balance = balance;
    }

    public synchronized void deposit(double amt){
        if(amt > 0){
            balance += amt;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"存入"+amt+"元，账户余额为"+balance);
    }
}
class User implements Runnable{
    private Account account = new Account(0);
    @Override
    public void run() {
        for(int i = 0; i < 3;i++){
            account.deposit(1000);
        }
    }
}
