package com.github.zxddxp.LC;

import java.util.ArrayList;

public class RestoreIpAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4) {
            return result;
        }

        return restoreIpAddresses(s, 4);

    }

    public ArrayList<String> restoreIpAddresses(String s, int k) {
        if (k == 1) {//base case
            if (Integer.parseInt(s) <= 255
                    && (!((s.length() > 1) && (s.charAt(0) == '0')))) {
                ArrayList<String> result = new ArrayList<String>();
                result.add(s);
                return result;
            } else {
                return null;
            }
        }

        int lowerBound = (k - 1) * 1;
        int upperBound = (k - 1) * 3;

        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < Math.min(3, s.length()); i++) {
            if (Integer.parseInt(s.substring(0, i + 1)) <= 255
                    && (s.length() - i - 1) >= lowerBound
                    && (s.length() - i - 1) <= upperBound
                    && (!((i > 0) && (s.charAt(0) == '0')))) {
                String prefix = s.substring(0, i + 1);
                ArrayList<String> subResult = restoreIpAddresses(s.substring(i + 1), k - 1);
                if (subResult != null) {
                    for (String ss : subResult) {
                        result.add(prefix + "." + ss);
                    }
                }
            }
        }
        return result;
    }

}
