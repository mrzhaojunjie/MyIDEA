package com.sky.每日一题.程序员面试金典;

import java.util.ArrayList;
import java.util.List;

public class Question17 {
}
class Q1701{
    //魔术索引
    public int findMagicIndex(int[] nums) {
        int index = -1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == i){
                index = i;
                break;
            }
        }
        return index;
    }
}
class Q1702{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());  //空集
        for(int num:nums){
            int length = res.size();  //2
            for(int i = 0;i < length;i++){
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(res.get(i));
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }
}
