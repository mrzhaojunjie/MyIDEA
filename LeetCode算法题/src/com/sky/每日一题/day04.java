package com.sky.每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class day04 {
    public static void main(String[] args) {
        String s = Main041.removeDuplicates("abbaca");
        System.out.println(s);
    }
}
class Main041{
    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < S.length();i++){
            if(!stack.isEmpty()){
                if(stack.peek() == S.charAt(i)){
                    stack.pop();
                    continue;
                }else{
                    stack.add(S.charAt(i));
                }
            }else{
                stack.add(S.charAt(i));
            }
        }
        System.out.println(stack.size());
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for(int i = 0;i < size;i++){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

class Main042{
    //1171.从链表中删去总和值为0的连续节点
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer,ListNode> map = new HashMap<>();
        int sum = 0;
        for(ListNode d = dummy;d!=null;d = d.next){
            sum += d.val;
            map.put(sum,d);
        }
        sum = 0;
        for(ListNode d = dummy;d!=null;d = d.next){
            sum += d.val;
            d.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
class Main043{
    //两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        if(head == null||head.next == null){
            return head;
        }
        //firstNode和secondNode表示两个要互换的节点
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        //返回的是互换后的新表头
        return secondNode;
    }
}
