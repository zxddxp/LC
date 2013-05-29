package com.github.zxddxp.LC;

import java.util.*;

public class MinWindow {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S == null || T == null || S.length() < T.length() || T.length() == 0) {
            return "";
        }
        int minSoFar = S.length() + 1;
        int minStart = 0;
        TreeMap<Character, Integer> count = new TreeMap<Character, Integer>();
        TreeMap<Character, Integer> dict = new TreeMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.put(c, 1);
            }
        }

        int left = 0;
        int right = 0;
        int totalNeed = dict.size();
        while (right < S.length()) {
            char c = S.charAt(right);
            if (dict.containsKey(c)) {
                if (count.containsKey(c)) {
                    count.put(c, count.get(c) + 1);
                } else {
                    count.put(c, 1);
                }
                if (count.get(c) == dict.get(c)) {
                    totalNeed--;
                }
            }
            if (totalNeed == 0) {
                break;
            } else {
                right++;
            }
        }

        while (right < S.length()) {
            char c = S.charAt(left);
            while (!count.containsKey(c) || count.get(c) > dict.get(c)) {
                if (count.containsKey(c) && count.get(c) > dict.get(c)) {
                    count.put(c, count.get(c) - 1);
                }
                left++;
                c = S.charAt(left);
            }
            if ((right - left + 1) < minSoFar) {
                minSoFar = right - left + 1;
                minStart = left;
            }
            right++;
            if (right < S.length()) {
                c = S.charAt(right);
                if (dict.containsKey(c)) {
                    if (count.containsKey(c)) {
                        count.put(c, count.get(c) + 1);
                    } else {
                        count.put(c, 1);
                    }
                }
            }
        }

        if (minSoFar < (S.length() + 1)) {
            return S.substring(minStart, minStart + minSoFar);
        } else {
            return "";
        }
    }


    public static void main(String[] args) {
        MinWindow m = new MinWindow();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
    }
}
