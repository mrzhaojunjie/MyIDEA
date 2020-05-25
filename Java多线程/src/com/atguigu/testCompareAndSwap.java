package com.atguigu;

public class testCompareAndSwap {
    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();
        for(int i = 0;i < 10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int exceptedValue = cas.get();
                    boolean b = cas.compareAndSet(exceptedValue, (int)(Math.random() * 101));
                    System.out.println(b);
                }
            }).start();
        }
    }
}
class CompareAndSwap{
    private int value;

    public synchronized int get(){
        return value;
    }
    public synchronized int compareAndSwap(int exceptedValue,int newValue){
        int oldValue = value;
        if(exceptedValue == oldValue){
            this.value = newValue;
        }
        return oldValue;
    }
    public synchronized boolean compareAndSet(int exceptedValue,int newValue){
        return exceptedValue==compareAndSwap(exceptedValue,newValue);
    }
}
