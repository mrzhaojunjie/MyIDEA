package 每日一题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class day38 {
}
class Main381{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            int pre1 = 1;
            int pre2 = 2;
            while (true){
                if(N < pre2 && N > pre1){
                    System.out.println(Math.min(Math.abs(N-pre1),Math.abs(N-pre2)));
                    break;
                }
                int fib = pre1+pre2;
                pre1 = pre2;
                pre2 = fib;

            }
        }
    }
}
class Main382{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            String[] res = s.split(" ");
            for (int i = 0; i < res.length; i++) {
                set.add(res[i]);
            }
        }
        System.out.println(set.size());
        set.clear();
    }
}
class Main383{
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n*n];
        int index = 0;
        int beginX = 0;  //x的起始位
        int beginY = n-1;  //y的起始位
        while (beginX < n){
            int x = beginX;
            int y = beginY;
            while (x < n&& y < n){
                res[index++] = arr[x++][y++];
            }
            if(beginY > 0){
                beginY--;
            }else{
                beginX++;
            }
        }
        return res;
    }
}
class Main384{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            char[] res = s.toCharArray();
            int i = 0;
            int j = res.length-1;
            boolean result = false;
            while (i < j){
                if(res[i] != res[j]){
                    result = judge(res,i+1,j)||judge(res,i,j-1);
                    break;
                }
                i++;
                j--;
            }
            System.out.println(result == true?"Yes":"No");
        }

    }
    public static boolean judge(char[] c,int l,int r){
        int i = l;
        int j = r;
        while (i < j){
            if(c[i++]!=c[j--]){
                return false;
            }
        }
        return true;
    }
}