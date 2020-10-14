package com.sky.每日一题.程序员面试金典;

import java.util.ArrayList;
import java.util.List;

public class Question18 {
}
class Q1801{
    //无重复字符串的排列组合
    public String[] permutation(String S){
        char[] str = S.toCharArray();
        List<String> list = new ArrayList<>();
        arrange(str,list,0);
        return list.toArray(new String[list.size()]);

    }
    public void arrange(char[] str,List<String> list,int start){
        if(start == str.length-1){
            list.add(String.valueOf(str));
        }else{
            for(int i = start;i < str.length;i++){
                swap(str,i,start);
                arrange(str,list,start+1);
                swap(str,i,start);
            }
        }
    }
    public void swap(char[] str,int i,int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
