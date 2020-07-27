package com.sky.每日一题.程序员面试金典;

public class Question05 {
}
class Q0501{
    //链表求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;  //表示进位
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (l1 != null || l2!= null){
            int num1 = l1 == null?0:l1.val;
            int num2 = l2 == null?0:l2.val;

            int num = num1+num2+count;
            count = num/10;
            cur.next = new ListNode(num%10);

            l1 = l1 == null?null:l1.next;
            l2 = l2 == null?null:l2.next;

            cur = cur.next;
        }
        if(count == 1){
            cur.next = new ListNode(count);
        }
        return ans.next;
    }
}
class Q0502{
    //回文链表
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

       //快慢指针找中点
        while (fast != null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //反转后半部分
        ListNode pre = null;
        while (slow!=null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        ListNode node = head;
        while (pre!=null){
            if(pre.val != node.val){
                return false;
            }
            pre = pre.next;
            node = node.next;
        }
        return true;

    }
}