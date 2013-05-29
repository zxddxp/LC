package com.github.zxddxp.LC;

public class ReverseInteger {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (x == 0) {
            return x;
        }
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        int result = 0;
        while (x > 0) {
            result *= 10;
            result += (x % 10);
            x /= 10;
        }
        return neg ? -result : result;
    }

}
