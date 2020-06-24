package 每日一题;

import java.util.*;

public class day39 {
}
class Main391{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        while (sc.hasNext()){
            String s = sc.nextLine();
            String r = sc.nextLine();
            for(char ch:r.toCharArray()){
                set.add(ch);
            }
            for(char ch:s.toCharArray()){
                if(!set.contains(ch)){
                    list.add(ch);
                }
            }
            char[] res =new char[list.size()];
            for(int i = 0;i < res.length;i++){
                res[i] = list.get(i);
            }
            System.out.println(String.copyValueOf(res));
        }
    }
}
class Main392{
    public static String reverse(String sentence){
        String[] res = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = res.length-1;i >= 0;i--){
            if(i == 0){
                sb.append(res[i]);
                break;
            }
            sb.append(res[i]+" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String reverse = reverse(s);
            System.out.println(reverse);
        }
    }
}
