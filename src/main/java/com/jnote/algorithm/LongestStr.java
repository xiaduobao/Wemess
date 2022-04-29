package com.jnote.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestStr {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0, right = 1;
        Map<Character, Integer> map = new HashMap();

        while (right < s.length() && left <= right) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left,map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right),right);
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(new LongestStr().lengthOfLongestSubstring2("dvdf"));
    }
}
