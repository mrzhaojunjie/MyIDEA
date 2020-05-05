package 每日一题;

import java.util.*;

public class day18 {
}
class Main181{
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] res = new boolean[n];
        for(int i = 0;i < n;i++){
            if(s.contains(p[i])) {
                res[i] = true;
            }else {
                res[i] = false;
            }
        }
        return res;
    }
}

class Main182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int option = sc.nextInt();
            /*List<Student> list = new ArrayList<>();*/
            Map<String,Integer> map = new TreeMap<>();
            for(int i = 0;i < n;i++){
                map.put(sc.next(),sc.nextInt());
                /*list.add(new Student(sc.next(),sc.nextInt()));*/
            }
            List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
            if(option == 0){
                Collections.sort(list,(e1,e2)->{
                    return e2.getValue()-e1.getValue();
                });
                for(Map.Entry<String,Integer> entry:map.entrySet()){
                    System.out.println(entry.getKey()+" "+entry.getValue());
                }
            }else if(option == 1){
                Collections.sort(list,(e1,e2)->{
                    return e1.getValue()-e2.getValue();
                });
                for(Map.Entry<String,Integer> entry:map.entrySet()){
                    System.out.println(entry.getKey()+" "+entry.getValue());
                }
            }
            /*if (option == 0) {  //降序输出   流式计算+Lambda表达式
                list.stream().sorted((e1, e2) -> {
                    return e1.score - e2.score;
                }).forEach(System.out::println);
            } else if (option == 1) {   //升序
                list.stream().sorted((e1, e2) -> {
                    return e2.score - e1.score;
                }).forEach(System.out::println);
            }*/
        }
    }
}
class Student{
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name+" "+this.score;
    }
}