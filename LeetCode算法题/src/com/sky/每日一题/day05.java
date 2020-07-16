package com.sky.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day05 {
}
class Main051{
    //1299.将每个元素替换为右侧最大元素
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i <arr.length;i++){
            if(i == arr.length-1){
                arr[i] = -1;
                break;
            }
            for(int j = i+1;j < arr.length;j++){
                if(arr[j] > max){
                    max = arr[j];
                }
            }
            arr[i] = max;
            max = Integer.MIN_VALUE;
        }
        return arr;
    }
}
class Main052{
    //187.重复的DNA序列
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0;i <= s.length()-10;i++){
            map.put(s.substring(i,i+10),map.getOrDefault(s.substring(i,i+10),0)+1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue() > 1){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
class Main053{

    //779.第K个语法符号
    public int kthGrammar(int N, int K){
        if(N == 1){
            return 0;
        }
        int value = kthGrammar(N-1,(K+1)/2);
        return value == 0?1-(K%2):K%2;
    }
}
