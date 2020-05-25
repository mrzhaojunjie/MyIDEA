package com.atguigu;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class testCopyOnWrite {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();

        for(int i = 0;i < 10;i++){
            new Thread(helloThread).start();
        }
    }
}
class HelloThread implements Runnable{
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }
    @Override
    public void run() {
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            list.add("AA");
        }

    }
}
