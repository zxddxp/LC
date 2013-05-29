package com.github.zxddxp.LC;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 1;
        int tail = 1;
        HashMap<Character, Integer> hist = new HashMap<Character, Integer>();//<char,lastSeenAt>
        hist.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            Character c = new Character(s.charAt(i));
            Integer j = hist.get(c);
            if (j == null) {//a new char hasn't seen before
                tail++;
            } else {
                int length = i - j;
                if (length <= tail) {
                    tail = length;
                } else {
                    tail++;
                }
            }
            hist.put(c, i);
            result = Math.max(tail, result);
        }
        return result;
    }

}
