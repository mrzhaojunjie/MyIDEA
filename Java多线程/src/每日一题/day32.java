package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day32 {
    //上楼梯
    public int countWays(int n) {
        long[] res = {1,2,4};
        if(n <= 0){
            return 0;
        }else if(n <= 3){
            return (int) res[n-1];
        }else{
            for(int i = 4;i <= n;i++){
                int temp = (int) (((res[0]+res[1])%1000000007+res[2])%1000000007);
                res[0] = res[1];
                res[1] = res[2];
                res[2] = temp;
            }
        }
        return (int) res[2];
    }
}

class Main321{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            char[][] info = new char[N][2];
            int balance = 0;
            int jwin = 0;
            int jlose = 0;
            Model J = new Model();
            Model Y = new Model();
            for(int i = 0;i < info.length;i++){
                info[i][0] = sc.next().charAt(0);
                info[i][1] = sc.next().charAt(0);
                if(info[i][0]!=info[i][1]){
                    if(info[i][0] == 'C'&&info[i][1]=='J'){
                        jwin++;
                        J.map.put('C',J.map.get('C')+1);
                        continue;
                    }
                    if(info[i][0] == 'C'&&info[i][1]=='B'){
                        jlose++;
                        Y.map.put('B',Y.map.get('B')+1);
                        continue;
                    }
                    if(info[i][0] == 'J'&&info[i][1]=='C'){
                        jlose++;
                        Y.map.put('C',Y.map.get('C')+1);
                        continue;
                    }
                    if(info[i][0] == 'J'&&info[i][1]=='B'){
                        jwin++;
                        J.map.put('J',J.map.get('J')+1);
                        continue;
                    }
                    if(info[i][0] == 'B'&&info[i][1]=='C'){
                        jwin++;
                        J.map.put('B',J.map.get('B')+1);
                        continue;
                    }
                    if(info[i][0] == 'B'&&info[i][1]=='J'){
                        jlose++;
                        Y.map.put('J',Y.map.get('J')+1);
                        continue;
                    }
                }else{
                    balance++;
                }
            }
            System.out.println(jwin+" "+balance+" "+jlose);
            System.out.println(jlose+" "+balance+" "+jwin);
            System.out.println(getMostGen(J.map)+" "+getMostGen(Y.map));

        }
    }
    static class Model {
        Map<Character, Integer> map;

        Model() {
            map = new HashMap<>();
            map.put('C', 0);
            map.put('J', 0);
            map.put('B', 0);
        }
    }
    public static Character getMostGen(Map<Character,Integer> map) {
        if (map.get('C') >= map.get('J')) {
            if (map.get('C') > map.get('B')) {
                return 'C';
            } else {
                return 'B';
            }
        } else {
            if (map.get('J') > map.get('B')) {
                return 'J';
            } else {
                return 'B';
            }
        }
    }
}
