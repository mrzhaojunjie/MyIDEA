package 每日一题;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day29 {
    public static void main(String[] args) {
        String s = Integer.toBinaryString('3');
        System.out.println(s);   //将字符3（字符3的ASCII码为51）转为51的二进制
        System.out.println(String.format("%07d",Integer.parseInt(s)));  //转为7位二进制
    }
}
class Main291{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            char[] ch = s.toCharArray();
            for(char c: ch){
                String s1 = Integer.toBinaryString(c);
                String s2 = String.format("%07d",Integer.parseInt(s1));
                int count = 0;
                for(int i = 0;i < 7;i++){
                    if(s2.charAt(i) == '1'){
                        count++;
                    }
                }
                System.out.println(count%2==0?"1"+s2:"0"+s2);
            }
        }
    }
}
class Main292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BigInteger> list = new ArrayList<>();
        while (sc.hasNext()) {
            int N = sc.nextInt();
            for(int i = 0;i < N;i++){
                list.add(new BigInteger((sc.next())));
            }
            Collections.sort(list);
            for(BigInteger b:list){
                System.out.println(b);
            }
        }
    }
}