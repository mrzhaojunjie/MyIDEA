package 每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day21 {
}
class Main211{
    //到底买不买
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()){
            String sell = scanner.next();
            String buy = scanner.next();
            for(Character ch:buy.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            /*for(Map.Entry<Character,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey()+"  "+entry.getValue());
            }*/
            for(Character ch:sell.toCharArray()){
                if(map.containsKey(ch)){
                    if(map.get(ch) == 0){
                        sb.append(ch);
                        continue;
                    }
                    map.put(ch,map.get(ch)-1);
                }else{
                    sb.append(ch);
                }
            }
            /*System.out.println("--------------------");
            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey()+"  "+entry.getValue());
            }*/
            int lack = 0;
            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                if(entry.getValue() != 0){
                    lack += entry.getValue();
                }
            }
            if(lack != 0){
                System.out.println("No "+lack);
            }else{
                System.out.println("Yes "+sb.length());
            }
        }
    }
}
class Main212 {
    //链式A+B
    public ListNode1 plusAB(ListNode1 a, ListNode1 b) {
        // write code here
        ListNode1 curA = a;
        ListNode1 curB = b;
        ListNode1 head = new ListNode1(-1);
        ListNode1 cur = head;
        int res = 0;
        while (curA != null || curB != null) {
            if (curA != null && curB != null) {
                cur.next = new ListNode1((curA.val + curB.val + res) % 10);
                cur = cur.next;
                res = (res + curA.val + curB.val) / 10;
                curA = curA.next;
                curB = curB.next;
            } else if (curA != null) {
                cur.next = new ListNode1((curA.val + res) % 10);
                cur = cur.next;
                res = (res + curA.val) / 10;
                curA = curA.next;
            } else if (curB != null) {
                cur.next = new ListNode1((curB.val + res) % 10);
                cur = cur.next;
                res = (res + curB.val) / 10;
                curB = curB.next;
            }
        }
        if (res > 0) {
            cur.next = new ListNode1(res);
            cur = cur.next;
        }
        return head.next;
    }
}

class ListNode1{
    int val;
    ListNode1 next = null;

    ListNode1(int val) {
        this.val = val;
    }
}
