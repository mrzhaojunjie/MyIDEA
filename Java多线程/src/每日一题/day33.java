package 每日一题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class day33 {
}
class Main331{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String old = scanner.nextLine();
            String now = scanner.nextLine();
            Set<Character> oldset = new HashSet<>();
            Set<Character> nowset = new HashSet<>();
            for(Character ch:old.toCharArray()){
                if(Character.isLetter(ch)){
                    oldset.add(Character.toUpperCase(ch));
                }else if(Character.isDigit(ch)){
                    oldset.add(ch);
                }
            }
            System.out.println(oldset);
            for(Character ch:now.toCharArray()){
                if(Character.isLetter(ch)){
                    nowset.add(Character.toUpperCase(ch));
                }else{
                    nowset.add(ch);
                }
            }
            System.out.println(nowset);
            for(Character ch:nowset){
                if(oldset.contains(ch));
                oldset.remove(ch);
            }
            for(Character ch:oldset){
                System.out.print(ch);
            }
        }
    }
}
class Main332{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            double x0 = scanner.nextFloat();
            double y0 = scanner.nextFloat();
            double z0 = scanner.nextFloat();
            double x1 = scanner.nextFloat();
            double y1 = scanner.nextFloat();
            double z1 = scanner.nextFloat();
            double radius = getRadius(x0, y0, z0, x1, y1, z1);
            double volume = getVolume(radius);
            System.out.printf("%.3f",radius);
            System.out.print(" ");
            System.out.printf("%.3f",volume);

        }
    }
    public static double getRadius(double x0,double y0,double z0,double x1,double y1,double z1){
        double res = (x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0);
        double r = Math.sqrt(res);
        return r;
    }
    public static double getVolume(double r){
        double v = 4*Math.acos(-1)*Math.pow(r,3)/3;
        return v;
    }
}
