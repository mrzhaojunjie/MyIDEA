package 练习题;

public class Practice1 {
}
//110.平衡二叉树
class Q1{
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.abs(left-right)<2&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getHigh(TreeNode root){
        return root == null?0:Math.max(getHigh(root.left),getHigh(root.right))+1;
    }
}
//两数相加
class Q2{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        if(l1 != null||l2 != null){
            dummy.val = ((l1!=null)?l1.val:0)+((l2!=null)?l2.val:0);
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            if(dummy.val>=10){
                if(l1!=null){
                    l1.val += 1;
                }else{
                    l1 = new ListNode(1);
                }
            }
            dummy.next = addTwoNumbers(l1,l2);
        }else{
            return null;
        }
        return dummy;
    }
}
