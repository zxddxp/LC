package com.github.zxddxp.LC;

import java.util.ArrayList;

public class GrayCode {

    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<Integer> result = new ArrayList<Integer>(n);
        if (n == 0) {
            result.add(0);
            return result;
        }
        int m = 2;
        result.add(0);
        result.add(1);
        n--;
        while (n > 0) {
            for (int i = m - 1; i >= 0; i--) {
                result.add(m + result.get(i));
            }
            m *= 2;
            n--;
        }
        return result;
    }

}
