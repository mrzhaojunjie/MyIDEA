package com.atkuangshen.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c1 = Class.forName("com.atkuangshen.reflection.User");
        Method[] methods = c1.getMethods();   //获得public的方法包括Object中的方法
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("------------------------");
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {  //获得类所有方法不包括Object中的方法
            System.out.println(method);
        }
        System.out.println("--------------------------");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-----------------------------");
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, String.class);//获取指定构造器
        System.out.println(declaredConstructor);
        System.out.println("--------------------------------");
        Method setAge = c1.getMethod("setAge", int.class);//获取指定方法
        System.out.println(setAge);
    }
}
