package com.github.zxddxp.LC;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function

        StringBuilder sb = new StringBuilder("");

        if (strs == null || strs.length == 0) {
            return sb.toString();
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            int maxLen = Integer.MAX_VALUE;
            for (String s : strs) {
                if (s.length() < maxLen) {
                    maxLen = s.length();
                }
            }
            Arrays.sort(strs);
            for (int i = 0; i < maxLen; i++) {
                if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                    break;
                } else {
                    sb.append(strs[0].charAt(i));
                }
            }
            return sb.toString();
        }
    }

}
