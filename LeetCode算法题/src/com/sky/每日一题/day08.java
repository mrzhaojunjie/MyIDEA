package com.sky.每日一题;

import java.util.*;

public class day08 {
}
class Main081{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()){
                Map<Integer,Integer> map = new HashMap<>();
                int n = sc.nextInt(); //n张桌子
                int m = sc.nextInt();  //m批客人
                for(int i = 0;i < n;i++){
                    int a = sc.nextInt();
                    map.put(a,map.getOrDefault(a,0)+1);
                }
                List<List<Integer>> list = new ArrayList<>();
                for(int i = 0;i < m;i++){
                    List<Integer> a = new ArrayList<>();
                    a.add(0,sc.nextInt());
                    a.add(1,sc.nextInt());
                    list.add(a);
                }
                int sum = 0;
                int max = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int num = entry.getKey();
                    if (entry.getValue() == 0) {
                        map.remove(num);
                        break;
                    }
                    int index = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (num >= list.get(i).get(0) && list.get(i).get(1) > max) {
                            max = list.get(i).get(1);
                            index = i;
                        }
                    }
                    sum = sum + max;
                    map.put(num, map.get(num) - 1);
                    list.remove(index);
                }
                System.out.println(sum);
            }

        }
}
class Main082{
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode p = head;
        int cnt = 0;
        while (p != null && cnt < k){
            p = p.next;
            cnt++;
        }
        if(cnt < k){
            return head;
        }
        ListNode pre = head;
        ListNode cur = null;
        while (pre != p){
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        head.next = reverseKGroup(p,k);
        return cur;
    }
}