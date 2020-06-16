package 每日一题;

import java.util.Scanner;

public class day31 {
}
class Main311{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String P = scanner.nextLine();
            String A = scanner.nextLine();
            String[] Pm = P.split("[.]");
            String[] Am = A.split("[.]");
            int Pr = (Integer.valueOf(Pm[0])*17+Integer.valueOf(Pm[1]))*29+Integer.valueOf(Pm[2]);
            int Ar = (Integer.valueOf(Am[0])*17+Integer.valueOf(Am[1]))*29+Integer.valueOf(Am[2]);
            int res = 0;
            if(Pr > Ar){
                System.out.print("-");
                res = Pr- Ar;
            }else{
                res = Ar - Pr;
            }
            int G = res /29/17;
            int S = res/29%17;
            int K = res%29;
            System.out.println(String.format("%d.%d.%d",S,G,K));
        }
    }
}
/*public class Count2 {
    public int countNumberOf2s(int n) {

    }
}*/

