package com.sky.每日一题.程序员面试金典;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question07 {
}
class MinStack{
    int min = Integer.MAX_VALUE;
    Stack<Integer> valStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    //栈的最小值
    public MinStack() {

    }
    public void push(int x) {
        min = Math.min(min,x);
        valStack.push(x);
        minStack.push(min);
    }

    public void pop() {
        valStack.pop();
        minStack.pop();
        if(minStack.isEmpty()){
            min = Integer.MAX_VALUE;
        }else{
            min = minStack.peek();
        }
    }

    public int top() {
        return valStack.peek();
    }

    public int getMin() {
        return min;
    }
}
class StackOfPlates {
    //堆盘子
    private int cap;
    private List<List<Integer>> list;
    public StackOfPlates(int cap) {
        this.cap = cap;
        list = new ArrayList<>();
    }

    public void push(int val) {
        if(cap == 0){
            return;
        }
        if(list.isEmpty()||list.get(list.size()-1).size() == cap){
            list.get(list.size()-1).add(val);
        }
    }

    public int pop() {
        if(list.isEmpty()){
            return -1;
        }
        int a = list.get(list.size()-1).get(list.get(list.size()-1).size()-1);
        list.get(list.size()-1).remove(list.get(list.size()-1).size()-1);
        if(list.get(list.size()-1).isEmpty()){
            list.remove(list.size()-1);
        }
        return a;
    }

    public int popAt(int index) {
        if(index >= list.get(index).size()){
            return -1;
        }
        int a = list.get(index).get(list.get(index).size()-1);
        list.get(index).remove(list.get(index).size()-1);
        if(list.get(index).isEmpty()){
            list.remove(index);
        }
        return a;
    }
}