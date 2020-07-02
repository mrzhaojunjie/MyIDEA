package com.sky.每日一题;

import java.util.HashMap;
import java.util.Map;

public class day01 {
}
class Main011{
    //739.每日温度
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] res = new int[length];
        for(int i = 0;i < length;i++){
            int num = T[i];
            for(int j = i+1;j < length;j++){
                if(num < T[j]){
                    res[i] = j-i;
                    break;
                }
                if(j == length-1&&num >= T[j]){
                    res[i] = 0;
                }
            }
        }
        return res;
    }
}
class Main012{
    //1103.分糖果II
    public int[] distributeCandies(int candies, int num_people) {
        int curGive = 0;  //当前应分的糖果数
        int[] res = new int[num_people];
        while (candies > 0){
            //当前应分的糖果数对人数取余即下标
            res[curGive % num_people] += Math.min(++curGive,candies);
            candies -= curGive;
        }
        return res;
    }
}
class Main013{

    //1160.拼写单词
    public int countCharacters(String[] words, String chars) {
        int length = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (String word : words) {
            for(int i = 0;i < chars.length();i++){
                map.put(chars.charAt(i),map.getOrDefault(chars.charAt(i),0)+1);
            }
            int index = 0;
            for(int i = 0;i < word.length();i++){
                if(map.containsKey(word.charAt(i))){
                    if(map.get(word.charAt(i)) > 0){
                        map.put(word.charAt(i),map.get(word.charAt(i))-1);
                        index++;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
                if(index == word.length()){
                    length += index;
                }
            }
            map.clear();
        }
        return length;
    }
}
