package 每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class day35 {
}
class Main351{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            Map<Character,Integer> map = new TreeMap<>();
            for(char ch = 'A';ch <= 'Z';ch = (char) (ch+1)){
                map.put(ch,0);
            }
            for(char ch : s.toCharArray()){
                if(ch > 'A'&&ch < 'Z'){
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }
            }
            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }
    }
}
class Main352{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            s = s.substring(2);
            int len = s.length();
            int tenCount = 0;
            for(int i = 0;i < len;i++){
                if(Character.isLetter(s.charAt(i))){
                    if(s.charAt(i) == 'A'){
                        tenCount += 10*Math.pow(16,len-1-i);
                        continue;
                    }
                    if(s.charAt(i) == 'B'){
                        tenCount += 11*Math.pow(16,len-1-i);
                        continue;
                    }
                    if(s.charAt(i) == 'C'){
                        tenCount += 12*Math.pow(16,len-1-i);
                        continue;
                    }
                    if(s.charAt(i) == 'D'){
                        tenCount += 13*Math.pow(16,len-1-i);
                        continue;
                    }
                    if(s.charAt(i) == 'E'){
                        tenCount += 14*Math.pow(16,len-1-i);
                        continue;
                    }
                    if(s.charAt(i) == 'F'){
                        tenCount += 15*Math.pow(16,len-1-i);
                        continue;
                    }
                }else{
                    tenCount += Integer.parseInt(String.valueOf(s.charAt(i)))*Math.pow(16,len-1-i);
                    continue;
                }
            }
            System.out.println(tenCount);
        }
    }
}
