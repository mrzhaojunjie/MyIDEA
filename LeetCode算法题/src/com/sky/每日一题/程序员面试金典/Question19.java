package com.sky.每日一题.程序员面试金典;

import java.util.*;

public class Question19 {
}
//二叉树根节点到叶子节点的所有路径和
class Q1901 {

    public int sumNumbers(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        getPathSum(root, 0, list);
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public void getPathSum(TreeNode root, int value, List<Integer> list) {
        if (root == null) {
            return;
        }
        value = value * 10 + root.val;
        if (root.left == null && root.right == null) {
            list.add(value);
            return;
        }
        if (root.left != null || root.right != null) {
            getPathSum(root.left, value, list);
            getPathSum(root.right, value, list);
        }
    }
}
//百度测开面试题：统计高频字符
class Q1902{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            Map<Character,Integer> map = new TreeMap<>();
            for (int i = 0; i < str.length(); i++) {
                Character ch = str.charAt(i);
                Character small = Character.toLowerCase(ch);
                Character big = Character.toUpperCase(ch);
                if(map.containsKey(small)){
                    map.put(small,map.getOrDefault(small,0)+1);
                    continue;
                }else if(map.containsKey(big)){
                    map.put(big,map.getOrDefault(big,0)+1);
                    continue;
                }
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            });
            System.out.println(list.get(0).getKey()+" "+list.get(0).getValue());

        }
    }
}
