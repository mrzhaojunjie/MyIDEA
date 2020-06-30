package 每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day43 {
}
class Main431{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String[] res = s.split("\\_");
            StringBuilder sb = new StringBuilder();
            sb.append(res[0]);
            for(int i = 1;i <res.length;i++){
                char[] chars = res[i].toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                sb.append(String.copyValueOf(chars));
            }
            System.out.println(sb.toString());
        }
    }
}
class Main432{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < s.length();i++){
                char c = s.charAt(i);
                if((c>='A'&&c<='Z')||(c>='a'&&c<='z')){
                    sb.append(c);
                }else{
                    sb.append(" ");
                }
            }
            String[] res = sb.toString().split(" ");
            for(int i = res.length-1;i > 1;i--){
                System.out.println(res[i]+" ");
            }
            if(res[0].length() == 0){
                System.out.println(res[1]);
            }else{
                System.out.println(res[1]+" "+res[0]);
            }

        }
    }

}