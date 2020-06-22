package 每日一题;

public class day37 {
}
class Main371{
    public static void main(String[] args) {

    }
    public int getLCA(int a, int b) {
        while (a!=b){
            if(a < b){
                b = b/2;
            }else{
                a = a/2;
            }
        }
        return a;
    }

}
class Main372{
    public String replaceSpace(String iniString, int length) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i <length;i++){
            if(iniString.charAt(i) == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(iniString.charAt(i));
        }
        return sb.toString();
    }
}
