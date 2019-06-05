package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> data = new HashMap<>();
        data.put('2',"abc");
        data.put('3', "def");
        data.put('4', "ghi");
        data.put('5', "jkl");
        data.put('6', "mno");
        data.put('7', "pqrs");
        data.put('8', "tuv");
        data.put('9', "wxyz");
        List<String> r = new ArrayList<>();
        if(digits == null || digits.isEmpty()) return r;
        printLetters(r, "", digits, data);
        return r;
    }

    public void printLetters(List<String> r, String pre, String digits, Map<Character, String> data){
        String tmp = data.get(digits.charAt(0));
        if(digits.length() == 1){
            for(int i=0; i<tmp.length(); i++){
                r.add(pre+tmp.charAt(i));
            }
            return;
        }

        for(int i=0; i<tmp.length(); i++){
            printLetters(r, pre+tmp.charAt(i), digits.substring(1), data);
        }
    }
}
