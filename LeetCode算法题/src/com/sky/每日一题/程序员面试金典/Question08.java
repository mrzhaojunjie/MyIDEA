package com.sky.每日一题.程序员面试金典;

import java.util.Stack;

public class Question08 {
}
class Q0801{
    //整数拆分
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int a = 1;
        while (n > 4){
            n = n - 3;
            a = a * 3;
        }
        return a*n;
    }
}
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return s1.isEmpty();
    }
}

