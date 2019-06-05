package PredicttheWinner;

public class Solution {
    boolean result = true;
    public boolean PredictTheWinner(int[] nums) {
        int begin = 0;
        int end = nums.length-1;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        iter(begin, end, true, 0, 0, sum/2+1, nums);
        return result;
    }

    public void iter(int begin, int end, boolean isPlayerOneturn, int playerOneSum, int playerTwoSum, int half, int[] nums){
        if(playerOneSum > half){
            return;
        }

        if(playerTwoSum > half){
            result = false;
            return;
        }

        if(begin == end){
            if(isPlayerOneturn){
                playerOneSum += nums[begin];
            }else {
                playerTwoSum += nums[begin];
            }
            if(playerOneSum < playerTwoSum) result = false;
            return;
        }
        if(!result) return;
        if(isPlayerOneturn){
            iter(begin+1, end, false, playerOneSum+nums[begin], playerTwoSum, half, nums);
            if(!result) return;
            iter(begin, end-1, false, playerOneSum+nums[end], playerTwoSum, half, nums);
        }else {
            iter(begin+1, end, true, playerOneSum, playerTwoSum+nums[begin], half, nums);
            if(!result) return;
            iter(begin, end-1, true, playerOneSum, playerTwoSum+nums[end], half, nums);

        }
    }
}
