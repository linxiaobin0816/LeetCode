package IntersectionofTwoArraysII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num1Map = new HashMap<>();
        Map<Integer, Integer> num2Map = new HashMap<>();
        Map<Integer, Integer> interset = new HashMap<>();
        for(int num1 : nums1){
            if(num1Map.containsKey(num1)){
                num1Map.put(num1, num1Map.get(num1)+1);
            }else {
                num1Map.put(num1, 1);
            }
        }

        for(int num2 : nums2){
            if(num2Map.containsKey(num2)){
                num2Map.put(num2, num2Map.get(num2)+1);
            }else {
                num2Map.put(num2, 1);
            }
        }
        int count = 0;
        for(int keyInNum1 : num1Map.keySet()){
            if(num2Map.containsKey(keyInNum1)){
                int v1 = num1Map.get(keyInNum1);
                int v2 = num2Map.get(keyInNum1);
                interset.put(keyInNum1, Math.min(v1, v2));
                count += Math.min(v1, v2);
            }
        }
        if(count == 0) return null;
        int[] r = new int[count];
        int index = 0;
        for(int v: interset.keySet()){
            int loop = interset.get(v);
            for(int i=0; i<loop; i++){
                r[index] = v;
                index++;
            }
        }
        return r;
    }
}
