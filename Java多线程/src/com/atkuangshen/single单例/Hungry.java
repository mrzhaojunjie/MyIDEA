package com.atkuangshen.single单例;

public class Hungry {
    private Hungry(){

    }
    private final static Hungry hungry = new Hungry();
    public Hungry getInstance(){
        return hungry;
    }
}
