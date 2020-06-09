package 每日一题;

import java.util.Scanner;
import java.util.Stack;

public class day27 {
}
class Main271{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        while (sc.hasNext()){
            int N1 = sc.nextInt();
            int N2 = (int) Math.pow(N1,2);
            while (N1 > 0){
                st1.push(N1%10);
                N1 = N1/10;
            }

            while (N2 > 10){
                st2.push(N2%10);
                N2 = N2/10;
            }
            if(st1.equals(st2)){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
}
class Main272{
    //密码验证合格程序
    public static boolean judgeLength(String s){
        if(s == null || s.length() <= 8 ){
            return false;
        }else{
            return true;
        }
    }
    public static boolean judgeType(String s){
        int digit = 0;
        int big = 0;
        int small = 0;
        int other = 0;
        for(char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                digit = 1;
                continue;
            } else if (ch >= 'A' && ch <= 'Z') {
                big = 1;
                continue;
            } else if (ch >= 'a' && ch <= 'z') {
                small = 1;
                continue;
            } else {
                other = 1;
            }
        }
        int total = digit+small+big+other;
        return total >= 3?true:false;

    }
    public static boolean judgeStr(String s){
        for(int i = 0;i < s.length()-2;i++){
            String str = s.substring(i,i+3);  //长度超过2的子串
            if(s.substring(i+1).contains(str)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            if(judgeLength(s)&&judgeType(s)&&judgeStr(s)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }

        }
    }
}
