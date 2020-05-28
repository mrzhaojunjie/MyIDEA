package 每日一题;

import java.util.Scanner;

public class day22 {
}
class Main222{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            int[] res = new int[N];
            for(int i = 0;i < N;i++){
                res[i] = scanner.nextInt();
            }
            int count2 = 0;
            int count4 = 0;
            int sum = 0;
            int A1 = 0;
            int A2 = 0;
            int A3 = 0;
            double A4 = 0.0;
            int A5 = 0;
            for(int i = 0;i < N;i++){
                if(res[i] %5 == 0&&res[i] % 2!=1 ){
                    A1 += res[i];
                }
                if(res[i] %5 == 1){
                    A2 += res[i]* Math.pow(-1,count2);
                    count2++;
                }
                if(res[i]%5 == 2){
                    A3++;
                }
                if(res[i] %5 == 3){
                    count4++;
                    sum += res[i];
                }
                if(res[i]%5 == 4){
                    if(res[i] > A5){
                        A5 = res[i];
                    }
                }
            }
            A4 = sum/count4;
            System.out.println(A1+" "+A2+" "+A3+" "+A4+" "+A5);
        }
    }
}
/*class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
//平衡二叉树的判断
/*class Main221{
    public int getHigh(TreeNode root){
        return root == null?0:Math.max(getHigh(root.left),getHigh(root.right))+1;
    }
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        return Math.abs(getHigh(root.left)-getHigh(root.right))<2
                &&isBalance(root.left)
                &&isBalance(root.right);
    }
}*/
