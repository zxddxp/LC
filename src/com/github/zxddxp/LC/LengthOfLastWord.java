package com.github.zxddxp.LC;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s == null || s.length() == 0) {
            return 0;
        } else {
            s = s.trim();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    count = 0;
                } else {
                    count++;
                }
            }
            return count;
        }
    }

}
