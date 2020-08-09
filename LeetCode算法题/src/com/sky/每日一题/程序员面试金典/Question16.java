package com.sky.每日一题.程序员面试金典;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question16 {
}
class Q1601{
    public int waysToStep(int n) {
        //三步问题
        if(n <= 2){
            return n;
        }
        if(n == 3){
            return 4;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i <= n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007+dp[i-3];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
class Q1602{
    //迷路的机器人
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(obstacleGrid.length < 1||obstacleGrid[0].length <1||obstacleGrid[0][0] == 1){
            return result;
        }
        if(obstacleGrid.length==1){
            List<List<Integer>> tmp = new ArrayList<>();
            for(int i = 0;i < obstacleGrid[0].length;i++){
                if(obstacleGrid[0][i] == 1){
                    return result;
                }
                List<Integer> t = new ArrayList<>();
                t.add(0);
                t.add(i);
                tmp.add(t);
            }
            return tmp;
        }
        if(obstacleGrid[0].length==1){
            List<List<Integer>> tmp = new ArrayList<>();
            for(int i = 0;i < obstacleGrid.length;i++){
                if(obstacleGrid[i][0] == 1){
                    return result;
                }
                List<Integer> t = new ArrayList<>();
                t.add(i);
                t.add(0);
                tmp.add(t);
            }
            return tmp;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;

        for(int i = 1;i < n;i++){
            if(obstacleGrid[0][i] == 1){
                dp[0][i] = false;
            }else{
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i = 1;i < m;i++){
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = false;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j <n;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = false;
                }else{
                    dp[i][j] = dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        if(!dp[m-1][n-1]){
            return new ArrayList<List<Integer>>();
        }

        int i = m-1;
        int j = n-1;
        while (i >= 0&&j >=0){
            if(dp[i][j]){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                result.addFirst(tmp);
            }
            if(i > 0&&dp[i-1][j]){
                i--;
            }else{
                j--;
            }
        }
        return result;
    }
}
