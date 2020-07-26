package com.sky.每日一题.程序员面试金典;

public class Qusetion04 {
}
class Q0401{
    //返回倒数第K个结点
    public int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur!=null){
            count++;
            cur = cur.next;
        }
        cur = head;
        for(int i = 0;i < count-k;i++){
            cur = cur.next;
        }
        return cur.val;
    }
}
class Q0402{
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
class Q0403{
    //分割链表
    public ListNode partition(ListNode head, int x) {
        ListNode sHead = null;
        ListNode sLast = null;
        ListNode bHead = null;
        ListNode bLast = null;
        ListNode cur = head;
        while (cur!=null){
            if(cur.val < x){
                if(sHead == null){
                    sHead = cur;
                    sLast = cur;
                }else{
                    sLast.next = cur;
                    sLast = sLast.next;
                }
            }else{
                if(bHead == null){
                    bHead = cur;
                    bLast = cur;
                }else{
                    bLast.next = cur;
                    bLast = bLast.next;
                }

            }
            cur = cur.next;
        }
        if(sHead == null){
            return bHead;
        }
        if(bHead == null){
            return sHead;
        }
        sLast.next = bHead;
        bLast.next = null;
        return sHead;
    }
}