package com.sky.每日一题;

import java.util.*;

public class day02 {

}
class Main021{
    //15.三数之和
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        Arrays.sort(nums); // 将数组进行排序
        for(int i = 0;i < nums.length;i++){
            if(i > 0&&nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int j = i+1;
            int k = nums.length-1;
            while (j < k){
                if(nums[j]+nums[k] == target){  //
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;k--;
                    while (j < nums.length&& nums[j]==nums[j-1]) j++;  //去重
                    while (k > j&&nums[k] == nums[k+1]) k--;  //去重
                }else if(nums[j]+nums[k] > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}
class Main022{
    //873.最长的斐波那契子序列
    public int lenLongestFibSubseq(int[] A) {
        int res = 0;
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        for(int a:A){
            set.add(a);
        }
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                int count = 0;
                if(set.contains(A[i]+A[j])){
                    int u = A[i];
                    int v = A[j];
                    while (set.contains(u+v)){
                        count++;
                        int temp = v;
                        v = u+ v;
                        u = temp;
                    }
                    res = Math.max(res,count+2);
                }
            }
        }
        return res;
    }
}
class Main023{
    public List<Integer> minSubsequence(int[] nums) {
        //1403.非递增顺序的最小子序列
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
        }
        int right = 0;
        for(int i = nums.length-1;i >= 0;i--){
            if(right > sum){
                break;
            }
            right += nums[i];
            sum -= nums[i];
            list.add(nums[i]);
        }
        return list;
    }
}
