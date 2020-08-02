package com.sky.每日一题.程序员面试金典;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question10 {
}
class Q1001{
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    public TreeNode buildTree(int[] nums,int l,int r){
        if(l > r){
            return null;
        }
        if(l == r){
            return new TreeNode(nums[l]);
        }
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left  = buildTree(nums,l,mid-1);
        root.right = buildTree(nums,mid+1,r);
        return root;
    }
}

class Q1002{
    //特定深度结点链表
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return new ListNode[]{};
        }
        List<ListNode> listNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();   //双向链表适合增删改
        queue.offer(tree);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.peek();
            int size = queue.size();
            ListNode depthNode = new ListNode(tmp.val);
            ListNode back = depthNode;
            for(int i = 0;i < size;i++){
                TreeNode tmp2 = queue.poll();
                if(i!=0){
                    depthNode.next = new ListNode(tmp2.val);
                    depthNode = depthNode.next;
                }
                if(tmp2.left!=null){
                    queue.offer(tmp2.left);
                }
                if(tmp2.right!=null){
                    queue.offer(tmp2.right);
                }
            }
            listNodes.add(back);
        }
        return listNodes.toArray(new ListNode[]{});
    }
}