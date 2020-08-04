package com.sky.每日一题.程序员面试金典;

public class Question12 {
}
class Q1201{
    //后继者
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        TreeNode node = inorderSuccessor(root.left,p);
        if(node != null){
            return node;
        }
        if(p.val > root.val){
            return root;
        }
        return inorderSuccessor(root.right,p);
    }

}
class Q1202{
    //首个公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
