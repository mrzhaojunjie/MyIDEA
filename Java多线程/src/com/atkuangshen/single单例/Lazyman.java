package com.atkuangshen.single单例;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Lazyman {
    private static boolean flag = false;

    private Lazyman() throws Exception {
        synchronized (Lazyman.class){
            if(flag == false){
                flag = true;
            }else{
                throw new RuntimeException("不要试图通过反射破坏单例");
            }
        }
    }
    /*private Lazyman() throws Exception {
        synchronized (Lazyman.class){
            if(lazyman != null) {
                throw new RuntimeException("不要尝试用反射破坏单例模式");
            }
        }
    }*/
    private static volatile Lazyman lazyman;

    //DCL懒汉式  （Double check lock）双重检测锁模式
    public static Lazyman getInstance() throws Exception {
        if(lazyman == null){
            synchronized (Lazyman.class){
                if(lazyman == null){
                    lazyman = new Lazyman();  //非原子性操作
                    /**
                     * 1 分配内存空间
                     * 2 执行构造方法
                     * 3 把对象指向空间
                     *
                     * 期望123，可能会出现132  所以要避免指令重排
                     */
                }
            }
        }

        return lazyman;
    }

    public static void main(String[] args) throws Exception {
        //Lazyman lazyman = Lazyman.getInstance();
        Constructor<Lazyman> declaredConstructor = Lazyman.class.getDeclaredConstructor(null);

        declaredConstructor.setAccessible(true);  //设置权限可进入，就可以通过构造器直接调用newInstance
        Field flag = Lazyman.class.getDeclaredField("flag");
        flag.setAccessible(true);

        Lazyman lazyman = declaredConstructor.newInstance();
        flag.set(lazyman,false);
        Lazyman lazyman1 = declaredConstructor.newInstance();
        System.out.println(lazyman);
        System.out.println(lazyman1);

    }
}
