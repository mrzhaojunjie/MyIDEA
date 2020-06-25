package 每日一题;

import java.util.Scanner;

public class day40 {
}
class Main401{
    //连续最大和
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] res = new int[n];
            for(int i = 0;i < n;i++){
                res[i] = sc.nextInt();
            }
            int max = res[0];
            int sum = res[0];
            for(int i = 1;i < n;i++){
                if(sum >=0){
                    sum += res[i];
                }else{
                    sum = res[i];
                }
                if(sum > max){
                    max = sum;
                }
            }
            System.out.println(max);
        }
    }
}
class Main402{
    //坐标移动
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String[] res = s.split("\\;");
            int x = 0,y = 0;
            for(String se:res){
                char[] seChar=se.toCharArray();
                if(seChar.length==3){
                    if(Character.isLetter(seChar[0])&&Character.isDigit(seChar[1])&&Character.isDigit(seChar[2])){
                        int m = Integer.parseInt("" + seChar[1] + seChar[2]);
                        switch (seChar[0]){
                            case 'A':
                                x = x-m;
                                break;
                            case 'D':
                                x = x+m;
                                break;
                            case 'W':
                                y = y+m;
                                break;
                            case 'S':
                                y = y-m;
                                break;
                        }
                    }
                }
            }
            System.out.println(x+","+y);
        }
    }
}
