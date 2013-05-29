package com.github.zxddxp.LC;

public class Pow {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        double result = 1.0;
        if (n == 0) {
            return result;
        }

        boolean neg = false;
        if (n < 0) {
            neg = true;
            n = -n;
        }

        while (n > 0) {
            if ((n % 2) == 1) {
                result *= x;
            }
            n = n / 2;
            x = x * x;
        }
        return neg ? 1.0 / result : result;
    }

}
