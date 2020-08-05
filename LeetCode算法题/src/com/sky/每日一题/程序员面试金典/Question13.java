package com.sky.每日一题.程序员面试金典;

public class Question13 {
}
class Q1301{
    //检查子树
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //空树一定是子树
        if(t2 == null){
            return true;
        }
        if(t1 == null){
            return false;
        }
        //两结点值相等要同时向左右递归看是否完全相同  所以用&&
        if(t1.val == t2.val){
            return checkSubTree(t1.left,t2.left)&&checkSubTree(t1.right,t2.right);
        }
        //两节点值不相等就向左向右递归，任意子树上有t2树就行  所以用||
        return checkSubTree(t1.left,t2)||checkSubTree(t1.right,t2);
    }
}
class Q1302{
    //求和路径:暴力法以每个节点为起始节点和为sum的路径
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        return helper(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);

    }
    public int helper(TreeNode root,int sum){  //以root结点为出发结点的路径条数
        if(null == root){
            return 0;
        }
        sum -= root.val;
        int count = sum == 0?1:0;
        count += helper(root.left,sum);
        count += helper(root.right,sum);
        return count;
    }

}
