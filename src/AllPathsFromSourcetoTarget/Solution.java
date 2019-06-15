package AllPathsFromSourcetoTarget;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        int len = graph.length;
        if(graph == null || graph.length == 0) return r;
        int[] begin = graph[0];
        dfs(graph, "0", begin, len-1, r);
        return r;
    }

    public void dfs(int[][] graph, String path, int[] edgs, int target, List<List<Integer>> r){
        for(int d: edgs){
            if(d == target){
                String[] tmp = path.split(" ");
                List<Integer> reachPath = new ArrayList<>();
                for(String p : tmp){
                    reachPath.add(Integer.parseInt(p));
                }
                reachPath.add(d);
                r.add(reachPath);
            }else {
                dfs(graph, path+" "+d, graph[d], target, r);
            }
        }
    }

}
