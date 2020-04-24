package 每日一题;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class day16 {
}
class Main161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        while (groups-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] res = new int[2*n];
            Stack<Integer> st = new Stack<>();
            for(int i = 0;i < 2*n;i++){
                res[i] = sc.nextInt();
            }
            for(int z = 0;z < k;z++){
                help(res,n,st);
            }
            if(res.length> 0) System.out.print(res[0]);
            for(int i = 1;i< 2*n;i++){
                System.out.print(" "+res[i]);
            }
        }
    }
    public static void help(int[] arr,int n,Stack<Integer> st){
        int i = n-1,j = 2*n-1;
        while (i >= 0&&j >=n){
            st.push(arr[j]);
            st.push(arr[i]);
            i--;
            j--;
        }
        for(int m = 0;m < 2*n;m++){
            arr[m] = st.pop();
        }
    }
}
class Main162{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            int[] res = new int[N];
            for(int i = 0;i < N;i++){
                res[i] = scanner.nextInt();
            }
            int key = scanner.nextInt();
            int count = 0;
            for(int i = 0;i < res.length;i++){
                if(res[i] == key){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

