package 每日一题;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class day42 {
}

class Main421{
    //好未来笔试：求和
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1;i <= n;i++){
                list.add(i);
                count(m,i,i,n,list);
                list.remove(list.size()-1);
            }
        }
    }

    private static void count(int m,int sum,int currentVal,int n,ArrayList list) {
        if(sum > m) return;
        if(sum == m){
            StringBuilder sb = new StringBuilder();
            Iterator it = list.iterator();
            while (it.hasNext()){
                sb.append(it.next()+" ");
            }
            System.out.println(sb.toString().trim());
        }else{
            for(int i = currentVal+1;i <= n;i++){
                list.add(i);
                count(m,sum+i,i,n,list);
                list.remove(list.size()-1);
            }
        }
    }

}
