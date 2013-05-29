package com.github.zxddxp.LC;

import java.util.TreeMap;

public class RomanToInt {

    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s == null || s.length() == 0) {
            return 0;
        }

        TreeMap<Character, Integer> dict = new TreeMap<Character, Integer>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (dict.get(s.charAt(i)) < dict.get(s.charAt(i + 1))) {
                result -= dict.get(s.charAt(i));
            } else {
                result += dict.get(s.charAt(i));
            }
        }
        result += dict.get(s.charAt(s.length() - 1));

        return result;
    }

}
