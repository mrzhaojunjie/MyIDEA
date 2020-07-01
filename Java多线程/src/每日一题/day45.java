package 每日一题;

import java.util.*;

public class day45 {
}
class Main451{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String A = sc.next();
            String B = sc.next();
            int count = 0;
            Map<Character,Integer> mapA = new HashMap<>();
            Map<Character,Integer> mapB = new HashMap<>();
            for(Character ch:A.toCharArray()){
                mapA.put(ch,mapA.getOrDefault(ch,0)+1);
            }
            for(Character ch:B.toCharArray()){
                mapB.put(ch,mapB.getOrDefault(ch,0)+1);
            }
            if(mapA.size() < mapB.size()){
                System.out.println("No");
            }else{
                for(Map.Entry<Character,Integer> entry:mapB.entrySet()){
                    if(!mapA.containsKey(entry.getKey())){
                        break;
                    }else{
                        if(entry.getValue() <= mapA.get(entry.getKey())){
                            count++;
                            if(count == mapB.size()){
                                System.out.println("Yes");
                            }
                        }
                    }

                }
                if(count != mapB.size()){
                    System.out.println("No");
                }
            }


        }
    }
}
class MainWeb{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < n;i++){
                int key = sc.nextInt();
                map.put(key,map.getOrDefault(key,0)+1);
            }
            List<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                if(entry.getValue() % 2 == 1){
                    list.add(entry.getKey());
                }
            }
            Collections.sort(list);
            System.out.println(list.get(0)+" "+list.get(1));
        }
    }
}
class MainWeb01{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            int[][] res = new int[n][2];
            for(int i = 0;i < n;i++){
                int num = arr[i];
                for(int j = i;j >=0;j--){
                    if(num > arr[j]){
                        res[i][0] = j;
                        break;
                    }else if(j == 0){
                        res[i][0] = -1;
                    }
                }
                for(int j = i;j < n;j++){
                    if(num > arr[j]) {
                        res[i][1] = j;
                        break;
                    }else if(j == n-1){
                        res[i][1] = -1;
                    }
                }
            }
            for(int i = 0;i < n;i++){
                System.out.println(res[i][0]+" "+res[i][1]);
            }
        }
    }
}