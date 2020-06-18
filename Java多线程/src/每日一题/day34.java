package 每日一题;

import java.util.Scanner;

public class day34 {
}
class Main34{
    public int calculateMax(int[] prices) {
        int result = 0;
        for(int i = 0;i < prices.length;i++){   //将数组分成两部分求最大差值的和的最大值
            result = Math.max(result,getMax(prices,0,i)+getMax(prices,i+1,prices.length-1));
        }
        return result;
    }
    //求区间的最大差值
    public int getMax(int[] prices,int start,int end){
        if(start >= end){
            return 0;
        }
        int max = 0;
        for(int i = start;i <= end;i++){
            for(int j = start;j < i;j++){
                max = Math.max(max,prices[i]-prices[j]);
            }
        }
        return max;
    }
}
