package com.sky.每日一题.程序员面试金典;

public class Question14 {
}
class Q1401{
    //二进制数转字符串
    public String printBin(double num) {
        if(num >=1||num <0){
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num!=0){
            num *= 2;
            if(num >= 1){
                sb.append("1");
                num -= 1;
            }else{
                sb.append(0);
            }
            if(sb.length() > 32){
                return "ERROR";
            }
        }
        return sb.toString();
    }
}
class Q1402{
    //翻转数位
    public int reverseBits(int num) {
        if(num == Integer.MAX_VALUE) return 32;
        String s = Integer.toBinaryString(num);
        String[] str = s.split("0");
        int res = str.length>0?str[0].length()+1:1;
        for(int i = 1;i < str.length;i++){
            res = Math.max(res,str[i-1].length()+str[i].length()+1);
        }
        return res;
    }
}
class Q1403{
    //反转链表
    public ListNode reverseList(ListNode head) {
       ListNode nhead = null;
       ListNode cur = head;
       while (cur != null){
           ListNode temp = cur.next;
           cur.next = nhead;
           nhead = cur;
           cur = temp;
       }
       return nhead;
    }
}