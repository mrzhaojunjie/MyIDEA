package 每日一题;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class day36 {
}
/*class Main361{   超时 case 95%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] vedge = new int[n]; //边的集合
            for(int i = 0;i < n;i++){
                int operator = sc.nextInt();  //操作
                int L = sc.nextInt();   //边长
                if(operator == 1){
                    vedge[i] = L;
                }else{
                    for(int j = i-1;j >= 0;j--){
                        if(vedge[j] == L){
                            vedge[j] = 0;
                            break;
                        }
                    }
                }

                int v = 0;
                for(int k = 0;k < n;k++){
                    if(vedge[k] != 0){
                        v++;
                    }
                }
                int[] array = new int[v];
                int index = 0;
                for(int k = 0;k < n;k++){
                    if(vedge[k] != 0){
                        array[index] = vedge[k];
                        index++;
                    }
                }
                if(judge(array)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }

    //能否构成n边形的条件是任意n-1条边的和大于另一条边
    public static boolean judge(int[] v){   //判断能否构成多边形  v是边的集合  n是边的数量   即v的长度
        boolean flag = true;
        if(v.length < 3){
            return false;
        }
        Arrays.sort(v,0,v.length);   //按长度进行排序
        int sum = 0;
        for(int i = 0;i < v.length-1;i++){
            sum += v[i];
        }
        if(sum <= v[v.length-1]){
            flag = false;
        }
        return flag;
    }
}*/
class Main3612{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] vedge = new int[n]; //边的集合
            for (int i = 0; i < n; i++) {
                int operator = sc.nextInt();  //操作
                int L = sc.nextInt();   //边长
                if (operator == 1) {
                    vedge[i] = L;
                } else {
                    for (int j = 0;j < n;j++) {
                        if (vedge[j] == L) {
                            vedge[j] = 0;
                            break;
                        }
                    }
                }
                if(judge(vedge,i+1)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
    public static boolean judge(int[] v, int n) {   //判断能否构成多边形  v是边的集合  n是边的数量   即v的长度
        boolean flag = true;
        if (n < 3) {
            return false;
        }
        Arrays.sort(v, 0, n);   //按长度进行排序
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += v[i];
        }
        if (sum <= v[n - 1]) {
            flag = false;
        }
        return flag;
    }

}
class Main362{

    //地下迷宫
    static int n,m,maxEnergy = 0;
    static String path = "";
    static int[][] map;
    static boolean flag = false;
    static LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            m = scanner.nextInt();
            int P = scanner.nextInt();  //青蛙体力
            map = new int[n][m];
            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    map[i][j] = scanner.nextInt();
                }
            }
            runMap(0,0,P);

            if(!flag){
                System.out.println("Can not escape!");
            }else{
                System.out.println(path);
            }

        }

    public static void runMap(int x,int y,int energy) {
        if (x < 0 || y < 0 || x >= n || m >= n || map[x][y] != 1) {
            return;
        }else{
            list.offer("["+x+","+y+"]");
            map[x][y] = 0;
            if(x == 0&&y == m-1){
                if(energy >= maxEnergy){
                    maxEnergy = energy;
                    updatePath();
                }
                map[x][y] = 1;
                list.removeLast();
                flag = true;
                return;
            }
            runMap(x, y+1, energy-1);
            runMap(x+1, y, energy);
            runMap(x-1, y, energy-3);
            runMap(x, y-1, energy-1);
            map[x][y] = 1;
            list.removeLast();
        }
   }

    public static void updatePath() {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()){
            sb.append(it.next()+",");
        }
        if(sb.length() > 0){
            sb.deleteCharAt(sb.length()-1);
        }
        path = sb.toString();
    }
}

