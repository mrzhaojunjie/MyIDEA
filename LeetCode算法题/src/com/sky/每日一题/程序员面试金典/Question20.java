package com.sky.每日一题.程序员面试金典;

public class Question20 {
}
class Q2001{
    public boolean Find(int target,int[][] array){
        int i = 0;
        int j = array[0].length - 1;

        while (i < array.length&&j >= 0){
            if(target > array[i][j]){
                i++;
            }else if(target < array[i][j]){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }
}
//旋转数组的最小数字
class Q2002{
    public int minNumberInRotateArray(int[] array){
        if(array == null||array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length -1;
        int mid = 0;
        while (left < right){
            if(right - left == 1){
                mid = right;
                break;
            }
            if(array[left] == array[right] && array[left] == array[mid]){
                int res = array[left];
                for(int i = left+1;i < right;i++){
                    if(res > array[i]){
                        res = array[i];
                    }
                }
                return res;
            }
            mid = (left + right) >> 1;
            if(array[mid] >= array[left]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return array[mid];
    }
}