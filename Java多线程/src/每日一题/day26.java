package 每日一题;

import java.util.Arrays;
import java.util.Scanner;

public class day26 {
    public static void main(String[] args) {
        long n = Long.parseLong("10");

        System.out.println(Long.toBinaryString(n));
    }
}

class Main261{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int x = scanner.nextInt();
            System.out.println(midFind(arr,0,arr.length-1,x));
        }
    }
    public static int midFind(int[] arr,int left,int right,int x){
        if(left > right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        while (left <= right){
            if(midVal < x){
                return midFind(arr,mid+1,right,x);
            }else if(midVal > x){
                return midFind(arr,left,mid-1,x);
            }else{
                return mid;
            }
        }
        return -1;
    }
}
class Main262{
    //整数与ip地址间的转换
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String IP = scanner.next();   //IP地址
            String p = scanner.next();    //十进制型的IP地址
            System.out.println(ipToTen(IP));
            tenToIp(p);
        }
    }
    private static void tenToIp(String p){
        long temp = Long.parseLong(p);
        String ip = Long.toBinaryString(temp);
        StringBuilder sb = new StringBuilder();
        if(ip.length() < 32){
            for(int i = 0;i < (32-ip.length());i++){
                sb.append(0);
            }
            sb.append(ip);
        }else if(ip.length() == 32){
            sb.append(ip);
        }

        for(int i = 0;i < sb.length()-8;i = i+8){
            System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
        }
        System.out.print(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));
    }
    private static long ipToTen(String ip) {
        String[] arr = ip.split("\\.");
        long n = Long.parseLong(arr[0]); //将字符串转为long类型
        for(int i = 1;i < arr.length;i++){
            n = n<<8;  //位运算符  等于n*二的八次方
            n = n+Long.parseLong(arr[i]);
        }
        return n;
    }
}