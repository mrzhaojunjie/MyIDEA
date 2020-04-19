package com.atbit;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String A = scanner.next();
            String B = scanner.next();
            System.out.println(reserveString(A,B));
        }
    }
    public static int reserveString(String A,String B){
        int count = 0;
        for(int i=0;i <= A.length();i++){
            String str= A.substring(0,i)+B+A.substring(i,A.length());
            if(judgeReserve(str)){
                count++;
            }
        }
        return count;
    }
    public static boolean judgeReserve(String S){  //判断回文
        int i = 0;
        int j = S.length()-1;
        while(i < j){
            if(S.charAt(i)!=S.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
