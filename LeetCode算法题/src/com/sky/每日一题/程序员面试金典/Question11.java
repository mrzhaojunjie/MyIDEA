package com.sky.每日一题.程序员面试金典;

import java.util.ArrayList;
import java.util.List;

public class Question11 {
}
class Q1101{
    //检查平衡性
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.abs(left-right)<2&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getHigh(TreeNode root){
        return root==null?0:Math.max(getHigh(root.left),getHigh(root.right))+1;
    }
}
class Q1102{
    //合法二叉搜索树
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return ans;
    }
    private long cur = Long.MIN_VALUE;
    private Boolean ans = true;
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        long next = root.val;
        if(cur < next&&ans){
            cur = next;
        }else{
            ans = false;
        }
        inorder(root.right);
    }
}
