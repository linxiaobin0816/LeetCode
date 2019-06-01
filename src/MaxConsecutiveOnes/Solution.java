package MaxConsecutiveOnes;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int maxlen = 0;
        for(int i: nums){
            if(i == 1){
                maxlen = maxlen+1;
                if(maxlen > result) result = maxlen;
            }else{
                maxlen = 0;
            }
        }
        return maxlen;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] num = {1,0,1,1,0,1};
        System.out.println(s.findMaxConsecutiveOnes(num));
    }
}
