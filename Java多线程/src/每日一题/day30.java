package 每日一题;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class day30 {
}
class Main301{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            Stack<String> st = new Stack<>();
            String[] res = s.split(" ");
            for(int i = res.length-1;i >= 0;i--){
                if(i == 0){
                    System.out.print(res[i]);
                }else{
                    System.out.print(res[i]+" ");
                }
            }
        }
    }
}
class Main302{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String path = scanner.next();
            int lineNum = scanner.nextInt();
            String[] res = path.split("\\\\");
            String fin = res[res.length - 1];
            if (fin.length() > 16) {
                fin = fin.substring(fin.length() - 16);
            }
            String key = fin + " " + lineNum;
            int value = 1;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, value);
            }
        }
        int count = 0;
        for(String s:map.keySet()){
            count++;
            if(count >(map.keySet().size()-8)){
                System.out.println(s+" "+map.get(s));
            }
        }
    }
}
