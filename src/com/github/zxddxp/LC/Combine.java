package com.github.zxddxp.LC;

import java.util.ArrayList;

public class Combine {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (n < k) {
            return result;
        }

        int[] digits = new int[k];
        for (int i = 0; i < k; i++) {
            digits[i] = i + 1;
        }
        //so far, the first combination is 1,2,...,k

        while (digits[0] <= (n - k + 1)) {
            //1st step, write down the last valid solution
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (Integer i : digits) {
                r.add(i);
            }
            result.add(r);

            //2nd step, generate the next combination
            int last = k - 1;
            while (last >= 0) {
                digits[last]++;
                if (digits[last] > (n + last - (k - 1))) {
                    last--;
                } else {
                    break;
                }
            }
            if (last < 0) {
                return result;//job done
            } else if (last < (k - 1)) {
                for (int j = last; j < (k - 1); j++) {
                    digits[j + 1] = digits[j] + 1;
                }
            }
        }

        return result;

    }
}
