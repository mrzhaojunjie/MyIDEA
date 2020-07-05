package com.sky.每日一题;

import java.util.*;

public class day03 {
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
class Main031{
    //102.二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        //辅助队列
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < size;i++){
                TreeNode treeNode = nodes.remove(0);
                list.add(treeNode.val);
                if(treeNode.left!=null){
                    nodes.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    nodes.add(treeNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
class Main032{
    public void duplicateZeros(int[] arr) {
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == 0){
                for(int j = arr.length-1;j > i;j--){
                    arr[j] = arr[j-1];
                }
                i++;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
class Main033{
    //1122.数组的相对排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int j = 0;j < arr2.length;j++){
            for(int i = 0;i < arr1.length;i++){
                if(arr1[i]==arr2[j]){
                    list.add(arr1[i]);
                }
            }
            set.add(arr2[j]);
        }
        for(int i = 0;i <arr1.length;i++){
            if(!set.contains(arr1[i])){
                temp.add(arr1[i]);
            }
        }
        Collections.sort(temp);
        for(int i = 0;i < temp.size();i++){
            list.add(temp.get(i));
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}