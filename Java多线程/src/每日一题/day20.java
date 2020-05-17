package 每日一题;
import java.util.Scanner;

public class day20 {
}
class Main201{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int month = scanner.nextInt();
            System.out.println(getTotalCount(month));;
        }
    }
    public static int getTotalCount(int monthCount){
        if(monthCount == 1|| monthCount == 2){
            return 1;
        }
        return getTotalCount(monthCount -1)+getTotalCount(monthCount -2);
    }
}
class Main202{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            char[] result = s.toCharArray();
            for(int i = 0;i < result.length;i++){
                if(Character.isLetter(result[i])){
                    if(result[i] <= 'U'){
                       result[i] += 5;
                    }else{
                       result[i] -= 21;
                    }
                }
            }
            System.out.println(new String(result));
        }
    }
}
