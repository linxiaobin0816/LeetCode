package RemoveAllAdjacentDuplicatesInString;

public class Solution {
    public String removeDuplicates(String S) {
        if(S == null || S.length() == 0) return S;
        int begin = 0;
        while(begin < S.length()){
            int j = begin+1;
            if (j<S.length() && S.charAt(begin) == S.charAt(j)) {
                j++;
            }
            if(j > begin+1){
                S = S.substring(0,begin) + S.substring(j);
                begin = begin-1 < 0?0:begin-1;
            }else {
                begin++;
            }
        }
        return S;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        String S = "abbaca";
        System.out.println(s.removeDuplicates(S));
    }
}
