package com.github.zxddxp.LC;

public class NumDecodings {

    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] counts = new int[s.length() + 1];
        counts[0] = 1;
        counts[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (!(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')) {
                    return 0;
                }
                counts[i + 1] = counts[i - 1];
            } else if (s.charAt(i) <= '6' && s.charAt(i) >= '1') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    counts[i + 1] = counts[i - 1] + counts[i];
                } else {
                    counts[i + 1] = counts[i];
                }
            } else {// '7'-'9'
                if (s.charAt(i - 1) == '1') {
                    counts[i + 1] = counts[i - 1] + counts[i];
                } else {
                    counts[i + 1] = counts[i];
                }
            }
        }

        return counts[s.length()];
    }

}
