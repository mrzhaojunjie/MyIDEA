package com.atguigu;

public class volatileTest {
    public static void main(String[] args) {
        myThread mt = new myThread();
        new Thread(mt).start();
        while(true){
            if(mt.isFlag()){
                System.out.println("------------------------");
                break;
            }
        }
    }
}
class myThread implements Runnable{
    private volatile boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = "+isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}