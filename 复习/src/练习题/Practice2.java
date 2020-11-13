package 练习题;

public class Practice2 {

    //删除给定值结点
    public static ListNode  deleteListNode(int val,ListNode head){
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur!=null){
            if(cur.val == val){
                if(head.val == val){
                    head = head.next;
                }else{
                    prev.next = cur.next;
                }
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    public static int sizeOfList(ListNode head){
        ListNode cur = head;
        int size = 0;
        while (cur!=null){
            cur = cur.next;
            size++;
        }
        return size;
    }
    //找到链表中间节点
    public static ListNode middleNode(ListNode head){
        ListNode cur = head;
        int size = sizeOfList(head);
        int step = size/2;
        if(head == null){
            return null;
        }else{
            for(int i = 0;i < step;i++){
                cur = cur.next;
            }
            return cur;
        }
    }
}

