package 每日一题;

import java.util.*;

public class day15 {
    public static void main(String[] args) {
        A classa = new A("he");
        A classb = new A("he");
        System.out.println(classa==classb);
    }
}
class A{
    public A(String str){}
}
class Main151{
    public int addAB(int A, int B) {
        // write code here
        int temp = 0;
        int res = 0;
        while (B!= 0){
            res = A^B;
            temp = (A&B)<<1;
            A = res;
            B = temp;
        }
        return A;
    }
}
class Main152{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int x = scanner.nextInt();
            Queue<Long> queue = new LinkedList<>();
            Map<Long,Integer> map = new HashMap<>();
            map.put((long)x,1);
            queue.offer((long)x);
            while (!queue.isEmpty()){
                long n = queue.poll();
                if(n == 0){
                    System.out.println(map.get(n)-1);
                    return;
                }
                if(!map.containsKey((4*n+3)%1000000007)){
                    map.put((4*n+3)%1000000007,map.get(n)+1);
                    queue.offer((4*n+3)%1000000007);
                }
                if(!map.containsKey((8*n+7)%1000000007)){
                    map.put((8*n+7)%1000000007,map.get(n)+1);
                    queue.offer((8*n+7)%1000000007);
                }
            }
            System.out.println(-1);
        }
    }
}

