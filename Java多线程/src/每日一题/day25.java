package 每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day25 {
}
class Main251{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n1 = scanner.nextInt();
            int n2 = (int) Math.pow(n1,2);

            System.out.println(count(n1)+" "+count(n2));
        }
    }
    public static int count(int n){
        int count = 0;
        while (n > 0){
            count += n%10;
            n = n/10;
        }
        return count;
    }
}
class Main252{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            Map<String,Integer> map = new HashMap<>();
            for(int i = 0;i < n;i++){
                map.put(sc.next(),0);
            }
            int p = sc.nextInt();
            String[] pick = new String[p];
            for(int i = 0;i < p;i++){
                String s = sc.next();
                if(map.containsKey(s)){
                    map.put(s,map.getOrDefault(s,0)+1);
                }
            }
            int count = 0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                count += entry.getValue();
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
            System.out.println("Invalid:"+count);

        }
    }
}