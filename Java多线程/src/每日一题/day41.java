package 每日一题;

import java.util.Scanner;

public class day41 {
}
class Main411{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int i = iConverDateToDay(year,month,day);
            System.out.println(i);
        }
    }
    public static int iConverDateToDay(int year,int month,int day){

        int sumDay = 0;
        for(int i = 1;i <= month;i++){
            if(i % 2==1){
                sumDay+=30;
            }else{
                sumDay+=31;
            }
        }
        sumDay += day;
        return sumDay;
    }

}
class Main412{
    //字符串加解密
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            char[] aucPassword = s.toCharArray();
            char[] aucResult = new char[aucPassword.length];
            Encrypt(aucPassword,aucResult);
        }
    }
    public static void Encrypt(char[] aucPassword,char[] aucResult){  //加密
        for(int i = 0;i < aucPassword.length;i++){
            if(aucPassword[i] >= 'A'&&aucPassword[i] <= 'Z'){
                if(aucPassword[i] == 'Z'){
                    aucResult[i] = 'A';
                }else{
                    aucResult[i] =  (char) Character.toLowerCase((aucPassword[i] + 1));
                }

            }else if(aucPassword[i] >= 'a'&&aucPassword[i] <= 'z') {
                if (aucPassword[i] == 'z') {
                    aucResult[i] = 'A';
                }else{
                    aucResult[i] = (char) Character.toUpperCase((aucPassword[i] + 1));
                }
            }else if(aucPassword[i] >='0'&&aucPassword[i]<='9'){
                if(aucPassword[i] == '9'){
                    aucResult[i] = '0';
                }else{
                    aucResult[i] = (char) (aucPassword[i]+1);
                }
            }
        }
        System.out.println(String.copyValueOf(aucResult));
    }
    public static void unEncrypt(char[] aucPassword,char[] aucResult){
        for(int i = 0;i < aucPassword.length;i++){
            if(aucPassword[i] >= 'A'&&aucPassword[i] <= 'Z'){
                if(aucPassword[i] == 'Z'){
                    aucResult[i] = 'a';
                }else{
                    aucResult[i] =  (char) Character.toLowerCase((aucPassword[i] - 1));
                }

            }else if(aucPassword[i] >= 'a'&&aucPassword[i] <= 'z') {
                if (aucPassword[i] == 'a') {
                    aucResult[i] = 'Z';
                }else{
                    aucResult[i] = (char) Character.toUpperCase((aucPassword[i] - 1));
                }
            }else if(aucPassword[i] >='0'&&aucPassword[i]<='9'){
                if(aucPassword[i] == '0'){
                    aucResult[i] = '9';
                }else{
                    aucResult[i] = (char) (aucPassword[i]-1);
                }
            }
        }
        System.out.println(String.copyValueOf(aucResult));
    }
}