package ShortestDistancetoaCharacter;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> loc = new ArrayList<>();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == C) loc.add(i);
        }
        int[] r = new int[S.length()];
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == C) r[i] = 0;
            else {
                int min = Integer.MAX_VALUE;
                for(int j=0; j<loc.size(); j++){
                    if(Math.abs(i-loc.get(j)) < min) min = Math.abs(i-loc.get(j));
                }
                r[i] = min;
            }
        }
        return r;
    }
}
