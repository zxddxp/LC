package com.github.zxddxp.LC;

public class Divide {

    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long div = dividend;
        boolean same = true;
        if (dividend < 0) {
            same = !same;
            div = 0 - div;
        }
        long divi = divisor;
        if (divisor < 0) {
            same = !same;
            divi = 0 - divi;
        }

        if (divi > div) {
            return 0;
        } else {
            int result = 0;
            long base = 1;
            long sub = divi;
            while (sub <= div) {
                sub = sub << 1;
                base = base << 1;
            }
            while (sub > divi) {
                sub = sub >> 1;
                base = base >> 1;
                if (div >= sub) {
                    result += base;
                    div -= sub;
                }
            }
            if (same) {
                return result;
            } else {
                return 0 - result;
            }
        }
    }
}
