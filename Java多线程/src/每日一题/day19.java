package 每日一题;


import java.util.HashMap;
import java.util.Map;

public class    day19 {
}
class Main191{
    public int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            map.put(gifts[i],map.getOrDefault(gifts[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }
        return 0;
        // write code here
    }
}
class Main192{
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode cur = pHead;
        ListNode sHead = null;
        ListNode sLast = null;
        ListNode bHead = null;
        ListNode bLast = null;
        while (cur != null){
            if(cur.val < x){
                if(sHead == null){
                    sHead = cur;
                }else{
                    sLast.next = cur;
                }
                sLast = cur;
            }else {
                if(bHead == null){
                    bHead = cur;
                }else{
                    bLast.next = cur;
                }
                bLast = cur;
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
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
