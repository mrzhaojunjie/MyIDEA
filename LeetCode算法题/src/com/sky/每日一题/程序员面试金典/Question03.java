package com.sky.每日一题.程序员面试金典;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question03 {
}

class Q0301{
    //零矩阵
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(0,i);
                    list.add(1,j);
                    lists.add(list);
                }
            }
        }
        for(int z = 0;z <lists.size();z++){
            int x = lists.get(z).get(0);
            int y = lists.get(z).get(1);
            for(int i = 0;i < matrix.length;i++){
                matrix[i][y] = 0;
            }
            for(int i = 0;i < matrix[0].length;i++){
                matrix[x][i] = 0;
            }
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
class Q0302{
    //字符串轮转
    public boolean isFlipedString(String s1, String s2) {
        return s1.equals(s2)||s1.length() == s2.length()&&(s1+s1).contains(s2);
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
class Q0303{
    //移除重复结点
    public  ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (cur != null){
            if(set.contains(cur.val)){
               pre.next = cur.next;
            }else{
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
