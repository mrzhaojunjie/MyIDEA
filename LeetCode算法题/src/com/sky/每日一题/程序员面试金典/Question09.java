package com.sky.每日一题.程序员面试金典;

import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Question09 {
}
class SortedStack {
    //栈排序
    Stack<Integer> s1;
    Stack<Integer> s2;
    public SortedStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        if(s1.isEmpty()){
            s1.push(val);
        }else{
            while (!s1.isEmpty()&&val>s1.peek()){
                s2.push(s1.pop());
            }
            s1.push(val);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    }

    public void pop() {
        if(s1.isEmpty()){
            return;
        }else{
            s1.pop();
        }
    }

    public int peek() {
        if(s1.isEmpty()){
            return -1;
        }else{
            return s1.peek();
        }
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}

class Q0902{

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(start);
        for(int[] a: graph){
            if(set.contains(a[0])){
                set.add(a[1]);
            }
        }
        return set.contains(target);
    }
}


