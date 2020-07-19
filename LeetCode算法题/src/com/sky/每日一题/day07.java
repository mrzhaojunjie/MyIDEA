package com.sky.每日一题;

import java.util.*;

public class day07 {
}
class Main071{
    //915.分割数组
    public int partitionDisjoint(int[] A) {
        if(A == null||A.length==0){
            return 0;
        }
        int leftMax = A[0]; //左侧数组最大值
        int max = A[0];    //整个数组最大值
        int index = 0;
        for(int i = 1;i < A.length;i++){
            max = Math.max(max,A[i]);
            if(leftMax > A[i]){
                leftMax = max;
                index = i;
            }
        }
        return index+1;
    }
}
class Main072{
    //1408.数组中的字符串匹配
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        for(int i = 0;i < words.length;i++){
            String now = words[i];
            for(int j = 0;j < words.length;j++){
                if(!now.equals(words[j])&&now.length() > words[j].length()){
                    if(now.contains(words[j])&& !list.contains(words[j])){
                        list.add(words[j]);
                    }
                }
            }
        }
        return list;
    }
}
class Main073{
    //946.验证栈序列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int index = 0;
        for(int i = 0;i < pushed.length;i++){
            st.push(pushed[i]);
            while (!st.isEmpty()&&st.peek() == popped[index]){
                st.pop();
                index++;
            }
        }
        return st.isEmpty();
    }
}