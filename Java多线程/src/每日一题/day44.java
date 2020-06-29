package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class day44 {
}
class Main441{
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() > len){
                return entry.getKey();
            }
        }
        return 0;
    }
}
