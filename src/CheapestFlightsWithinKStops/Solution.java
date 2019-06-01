package CheapestFlightsWithinKStops;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int result = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights1, int src, int dst, int K) {
        int[][] flights = new int[n * (n - 1) / 2][n * (n - 1) / 2];
        int len = flights1.length;
        for(int l=0; l<len; l++){
            flights[flights1[l][0]][flights1[l][1]] = flights1[l][2];
        }
        dfs(0, flights[src], dst, K, flights);
        if(result == Integer.MAX_VALUE){
            result = -1;
        }
        return result;
    }

    public void dfs(int price, int[] cost, int dst, int k, int[][] flights){
        k--;
        for(int i=0; i<cost.length; i++){
            if(cost[i] <=0) continue;
            if(i == dst){
                if(cost[i] + price < result) {
                    result = cost[i] + price;
                }
                continue;
            }
            if(k>=0 && price+cost[i] < result){
                dfs(price+cost[i], flights[i], dst, k, flights);
            }
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] data = {{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}};
        s.findCheapestPrice(5, data, 0, 4, 1);
        System.out.println(s.result);
    }
}
