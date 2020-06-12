package 每日一题;

import java.util.Scanner;

public class day28 {
}
class Main281 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] arr = new int[n];
            long[] dp = new long[sum+1];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                for(int j = sum;j >=0;j--){
                    if(dp[j] > arr[i]){
                        dp[j] += dp[j-arr[i]];
                    }
                }
            }
            System.out.println(dp[sum]);

        }
    }
}
class Main282{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            float res = (getSon(n)/getMother(n))*100;
            System.out.print(String.format("%.2f",res)+"%");
        }
    }
    public static float getMother(int n){
        if(n == 0){
            return 1;
        }
        return n*getMother(n-1);
    }
    public static float getSon(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return (n-1)*(getSon(n-1)+getSon(n-2));
    }
}

