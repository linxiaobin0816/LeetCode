package MovingStonesUntilConsecutive;

import java.util.*;

public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] data = new int[3];
        data[0] = a;
        data[1] = b;
        data[2] = c;
        Arrays.sort(data);
        int[] r = new int[2];
        int gap1 = data[1]-data[0];
        int gap2 = data[2]-data[1];
        r[1] = gap1-1 + gap2-1;

        if(gap1 == 1 && gap2 == 1){
            r[0] = 0;
        }else if(gap1 <= 2 || gap2 <= 2){
            r[0] = 1;
        }else {
            r[0] = 2;
        }
        return r;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] r = s.numMovesStones(3,5,1);
        System.out.println(r[0] + r[1]);
    }
}
