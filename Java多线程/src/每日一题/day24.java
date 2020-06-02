package 每日一题;

import java.util.Scanner;

public class day24 {
}
class Main241{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] score = new int[n];  //课程学分
            for(int i = 0;i < n;i++){
                score[i] = sc.nextInt();
            }
            int[] truth = new int[n];
            for(int i = 0;i < n;i++){
                truth[i] = sc.nextInt();
            }
            double[] grade = new double[n];
            for(int i = 0;i < n;i++){
                if(truth[i] < 60){
                    grade[i] = 0;
                }
                if(truth[i] >= 60 && truth[i]<=63){
                    grade[i] = 1.0;
                }
                if(truth[i] >= 64 && truth[i]<=67){
                    grade[i] = 1.5;
                }
                if(truth[i] >= 68 && truth[i]<=71){
                    grade[i] = 2.0;
                }
                if(truth[i] >= 72 && truth[i]<=74){
                    grade[i] = 2.3;
                }
                if(truth[i] >= 75 && truth[i]<=77){
                    grade[i] = 2.7;
                }
                if(truth[i] >= 78 && truth[i]<=81){
                    grade[i] = 3.0;
                }
                if(truth[i] >= 82 && truth[i]<=84){
                    grade[i] = 3.3;
                }
                if(truth[i] >= 85 && truth[i]<=89){
                    grade[i] = 3.7;
                }
                if(truth[i] >= 90 && truth[i]<=100){
                    grade[i] = 4.0;
                }
            }
            double[] gpa = new double[n];
            double gpaSum = 0;  //所有学科绩点之和
            double scoreSum = 0;  //所有课程学分之和
            for(int i = 0;i < n;i++){
                scoreSum += score[i];
                gpa[i] = score[i]*grade[i];
                gpaSum += gpa[i];
            }
            double total = gpaSum/scoreSum;
            System.out.printf("%.2f",total);
        }
    }
}
