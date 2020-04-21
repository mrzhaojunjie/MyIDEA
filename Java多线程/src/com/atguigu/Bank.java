package com.atguigu;
//线程安全并且效率较高的单例模式
public class Bank {
    private Bank(){}
    private volatile static Bank instance = null;

    private static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }


}
