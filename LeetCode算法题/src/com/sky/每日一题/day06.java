package com.sky.每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class day06 {
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
class Main061{
    //116.填充每个节点的下一个右侧节点指针
    public Node connect(Node root){
        dfs(root,null);
        return root;
    }
    public void dfs(Node node,Node next){  //深搜遍历
        if(node != null){
            node.next = next;
            dfs(node.left,node.right);
            dfs(node.right,node.next!=null?node.next.left:null);
        }
    }
}
class Main062 {
    //1209.删除字符串中的所有相邻重复项II
    public String removeDuplicates(String s, int k) {
        int len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                len = 1;
            }
            if (len == k) {
                return removeDuplicates(s.substring(0, i - k + 1) + s.substring(i + 1), k);
            }
        }
        return s;
    }
}
class Main063{
    public String strWithout3a3b(int A, int B) {
        //984.不含AAA或BBB的字符串
        StringBuilder sb = new StringBuilder();
        while (A > 0&&B >0){
            if(A > B){
                sb.append("aab");
                A -= 2;
                B -= 1;
            }else if(A == B){
                for(int i = 0;i < A;i++){
                    sb.append("ab");
                }
                A = 0;
                B = 0;
            }else{
                sb.append("bba");
                A -= 1;
                B -= 2;
            }
        }
        if(A == 0){
            for(int i = 0;i < B;i++){
                sb.append("b");
            }
        }else if(B == 0){
            for(int i = 0;i < A;i++){
                sb.append("a");
            }
        }
        return sb.toString();
    }
}