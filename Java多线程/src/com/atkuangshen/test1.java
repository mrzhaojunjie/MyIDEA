package com.atkuangshen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class test1 {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();   List线程不安全，
        //List<String> list = new CopyOnWriteArrayList<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for(int i = 1;i <= 30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
