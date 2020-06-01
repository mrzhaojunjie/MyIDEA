package 每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day23 {
}
class Main231{
    public static int GYS(int n1,int n2){
        int GYS = 0;
        int temp = 1;
        if(n1 < n2){
            temp = n1;
            n1 = n2;
            n2 = temp;
        }
        while (temp != 0){
            temp = n1 % n2;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int[] b = new int[n];
            for(int i = 0;i < n;i++){
                b[i] = scanner.nextInt();
            }
            for(int i = 0;i < n;i++){
                if(b[i] <= a){
                    a += b[i];
                }else if(b[i] > a){
                    a += GYS(b[i],a);
                }
            }
            System.out.println(a);
        }
    }
}
class Main232{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
           int N = sc.nextInt();  //学生数目
           int M = sc.nextInt();  // 操作数目
           int[] score = new int[N];
           int max = 0;
           List<ArrayList<Character>> list = new ArrayList<>(M);
           for(int i = 0;i < N;i++){
               score[i] = sc.nextInt();
           }
           for(int i = 0;i < M;i++){
                ArrayList<Character> a = new ArrayList<>(3);
                for(int j = 0;j < 3;j++){
                    a.set(j,sc.next().charAt(0));
                }
                list.set(i,a);
           }
           for(int i = 0;i < M;i++){
               for(int j = 0;j < 3;j++){
                   if(list.get(i).get(0) == 'Q'){
                       int s = Integer.valueOf(list.get(i).get(1));
                       int e = Integer.valueOf(list.get(i).get(2));
                       for(int k = s-1;k <= e-1;k++){
                           if(score[k] > max){
                               max = score[k];
                           }
                       }
                       System.out.println(max);
                   }else if(list.get(i).get(0) == 'U'){
                       int id = Integer.valueOf(list.get(i).get(1));
                       int update = Integer.valueOf(list.get(i).get(2));
                       score[id-1] = update;
                   }
               }
           }
        }
    }
}