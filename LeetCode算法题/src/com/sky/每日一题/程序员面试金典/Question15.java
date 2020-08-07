package com.sky.每日一题.程序员面试金典;

public class Question15 {

}
class Q1501{
    //下一个数
    public int[] findClosedNumbers(int num) {
        int oneCount = Integer.bitCount(num);
        int[] res = new int[2];
        if(num == Integer.MAX_VALUE) return new int[]{-1,-1};
        int left = -1;
        int right = -1;
        for(int i = num+1;i > 0;i++){
            if(Integer.bitCount(i) == oneCount){
                right = i;
                break;
            }
        }
        for(int i = num-1;i >= 0;i--){
            if(Integer.bitCount(i) == oneCount){
                left = i;
                break;
            }
        }
        res[1] = left;
        res[0] = right;
        return res;
    }
}

