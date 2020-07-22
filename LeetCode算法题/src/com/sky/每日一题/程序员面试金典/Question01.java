package com.sky.每日一题.程序员面试金典;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question01 {
}

class Q0101{
    //判断字符是否唯一
    public boolean isUnique(String astr) {
        Map<Character,Integer> map = new HashMap<>();
        for(Character ch:astr.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue() > 1){
                return false;
            }
        }
        return true;
    }
}
class Q0102{
    //判断是否互为字符重排
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(Character ch:s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i = 0;i < s2.length();i++){
            Character key = s2.charAt(i);
            if(map.containsKey(key)){
                map.put(key,map.get(key)-1);
                if(map.get(key) == 0){
                    map.remove(key);
                }
            }else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
class Q0103{
    //URL化
    public String replaceSpaces(String S, int length) {
        return S.substring(0,length).replace(" ","%20");
    }
}
class Q0104{
    public boolean canPermutePalindrome(String s) {
        if(s == null){
            return false;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(Character ch:chars){
            if(set.contains(ch)){
                set.remove(ch);
            }else{
                set.add(ch);
            }
        }
        return set.size() <= 1;
    }
}
