package com.atguigu;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        threadNew tn = new threadNew();
        FutureTask futureTask = new FutureTask(tn);
        new Thread(futureTask).start();
        try {
            //get方法返回值即Callable方法中重写的call方法的返回值
            Object o = futureTask.get();
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class threadNew implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 1;i <= 100;i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        return sum;
    }
}
