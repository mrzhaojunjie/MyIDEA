package 每日一题;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class day17 {
    static boolean flag;
    public static void main(String[] args) {
        System.out.println(flag);
    }
}
class Test{
    public String name = "ABC";
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        System.out.println(t1.equals(t2)+","+t1.name.equals(t2.name));
    }
}
class TestDemo{
    private int count;
    public static void main(String[] args) {
        TestDemo t = new TestDemo(88);
        System.out.println(t.count);
    }
    public TestDemo(int a){
        count = a;
    }
}
class Main171{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for(int i = 0;i < N;i++){
                arr[i] = scanner.nextInt();
            }

        }
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
class Main172{
    //二叉树的镜像
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null&&root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
}
class Huochejinzhan{
    //火车进站
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i = 0;i < n;i++){
                array[i] = sc.nextInt();
            }
            Train t = new Train(array);
            t.start();
        }
    }
}
class Train{
    private ArrayList<String> result = new ArrayList<>();
    private int[] array;
    public Train(int[] array){
        this.array = array;
    }

    public void start(){
        StringBuilder outStation = new StringBuilder(); // 出站序列
        Stack<Integer> inStation = new Stack<>();  // 站内情况
        int index = 0;
        trainOut(outStation,inStation,index);
        Collections.sort(result);
        print();

    }
    public void print(){
        for(String s:result){
            for(int i = 0;i < s.length();i++){
                if(i!=s.length()-1){
                    System.out.print(s.charAt(i)+" ");
                }else{
                    System.out.println(s.charAt(i));
                }
            }
        }
    }

    private void trainOut(StringBuilder outStation,Stack<Integer> inStation,int index){
        if(index == array.length){
            while (!inStation.isEmpty()){
                outStation.append(inStation.pop());
            }
            result.add(outStation.toString());
            return;
        }

        if(!inStation.isEmpty()){
            Stack<Integer> newInStation = new Stack<>();
            newInStation.addAll(inStation);
            StringBuilder newOutStation = new StringBuilder(outStation);
            newOutStation.append(newInStation.pop());
            trainOut(newOutStation,newInStation,index);

        }

        if(index < array.length){
            Stack<Integer> newInStation = new Stack<>();
            newInStation.addAll(inStation);
            newInStation.push(array[index]);
            trainOut(outStation,newInStation,index+1);
        }
    }
}