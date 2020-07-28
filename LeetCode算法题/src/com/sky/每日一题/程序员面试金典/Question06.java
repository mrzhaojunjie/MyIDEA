package com.sky.每日一题.程序员面试金典;

public class Question06 {
}
class Q0601{
    //链表相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA!=curB){
            curA = curA == null?headB:curA.next;
            curB = curB == null?headA:curB.next;
        }
        return curA;
    }
}
class TripleInOne {
    private int[] arr = {};  //实际栈
    private int[] size = {};  //存储实时长度
    private int stackSize;  //初始栈长

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[3*stackSize];
        size = new int[]{0,0,0};
    }

    public void push(int stackNum, int value) {
        int length = size[stackNum];
        if(length < stackSize){
            arr[stackNum*stackSize+length] = value;
            size[stackNum] = length+1;
        }
    }

    public int pop(int stackNum) {
        int topVal = peek(stackNum);
        if(size[stackNum] > 0){
            size[stackNum] -= 1;
        }
        return topVal;
    }

    public int peek(int stackNum) {
        if(size[stackNum] == 0){
            return -1;
        }
        return arr[stackNum*stackSize+size[stackNum]-1];
    }

    public boolean isEmpty(int stackNum) {
        return size[stackNum] == 0;
    }
}
