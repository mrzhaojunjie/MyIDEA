package com.atguigu;

public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Window extends Thread{

    //必须加静态，不然会认为是三个线程各自有各自的ticket  一共300张票
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized(Window.class){
                if(ticket > 0){
                    System.out.println(getName()+":卖票，票号为"+ticket);
                    ticket--;
                }else{
                    System.out.println("票已售光");
                    break;
                }
            }
        }
    }
}
