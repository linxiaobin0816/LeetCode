package OpentheLock;

import javax.sql.rowset.Joinable;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>();
        Collections.addAll(deadend, deadends);
        String init = "0000";
        Set<String> visited = new HashSet<>();
        visited.add(init);

        Queue<String> queue = new LinkedList<>();
        queue.add(init);
        int k = 0;
        while (!queue.isEmpty()){
            k++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                char[] head = queue.poll().toCharArray();

                for(int j=0; j<4; j++){
                    char tmp = head[j];

                    char forward = forward(tmp);
                    head[j] = forward;
                    String forst = new String(head);
                    if(forst.equals(target)) return k;
                    if(!visited.contains(forst) && !deadend.contains(forst)) {
                        queue.add(forst);
                        visited.add(forst);
                    }

                    char backward = backward(tmp);
                    head[j] = backward;
                    String backst = new String(head);
                    if(backst.equals(target)) return k;
                    if(!visited.contains(backst) && !deadend.contains(backst)) {
                        queue.add(backst);
                        visited.add(backst);
                    }

                    head[j] = tmp;
                }

            }
        }

        return -1;
    }

    public char forward(char now){
        if(now == '9') return '0';
        return (char)(now+1);
    }

    public char backward(char now){
        if(now == '0') return '9';
        return (char)(now-1);
    }


    public static void main(String[] args){
       String target = "0202";
       String[] deadends = {"0201","0101","0102","1212","2002"};
       Solution s = new Solution();
       System.out.println(s.openLock(deadends, target));
    }
}
