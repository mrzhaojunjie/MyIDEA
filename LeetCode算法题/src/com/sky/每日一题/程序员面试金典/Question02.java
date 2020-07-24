package com.sky.每日一题.程序员面试金典;


public class Question02 {
}
class Q0201{
    //一次编辑
    public boolean oneEditAway(String first, String second) {
        if(first == null||second == null){return false;}
        int len1 = first.length();
        int len2 = second.length();
        if(Math.abs(len1-len2) > 1){return false;}
        if(len2 > len1){
            return oneEditAway(second,first);
        }
        for(int i = 0;i < len2;i++){
            if(first.charAt(i) != second.charAt(i)){
                return first.substring(i+1).equals(second.substring(len1 == len2?i+1:i));
            }
        }
        return true;
    }
}
class Q0202{
    public String compressString(String S) {
        //字符串压缩
        if(S.length() == 0){
            return S;
        }
        int count = 1;
        char ch = S.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i < S.length();i++){
            if(ch == S.charAt(i)){
                count++;
            }else {
                sb.append(ch);
                sb.append(count+"");
                ch = S.charAt(i);
                count = 1;
            }
        }
        sb.append(ch);
        sb.append(count+"");
        return sb.length() < S.length()?sb.toString():S;

    }
}
class Q0203{
    public void rotate(int[][] matrix) {
        int leftTop; //左上
        int leftBottom;  //坐下
        int rightTop;  //右上
        int rightBottom;  //右下

        for(int i = 0;i <matrix.length;i++){
            for(int j = i;j < matrix.length-i-1;j++){
                leftTop = matrix[i][j];

                leftBottom = matrix[matrix.length-j-1][i];

                rightTop = matrix[j][matrix.length-i-1];

                rightBottom = matrix[matrix.length-1-i][matrix.length-1-j];

                matrix[i][j] = leftBottom;
                //左下=右下
                matrix[matrix.length - 1- j][i] = rightBottom;
                //右下=右上
                matrix[matrix.length - 1- i][matrix.length - 1 - j] = rightTop;
                //右上=左上
                matrix[j][matrix.length - 1- i] = leftTop;
            }
        }
    }
}