package com.github.zxddxp.LC;

import java.util.ArrayList;
import java.util.Arrays;

public class Permute {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null && num.length == 0) {
            return null;
        }
        return permute(num, num.length);
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num, int N) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (N == 1) {
            ArrayList<Integer> r = new ArrayList<Integer>(1);
            r.add(num[0]);
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(1);
            result.add(r);
            return result;
        }

        ArrayList<ArrayList<Integer>> sub = permute(num, N - 1);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(sub.size() * N);
        int n = num[N - 1];
        for (ArrayList<Integer> r : sub) {
            Integer[] t = new Integer[r.size() + 1];
            for (int i = 0; i < t.length - 1; i++) {
                t[i] = r.get(i);
            }
            t[t.length - 1] = n;
            for (int i = 0; i < t.length; i++) {
                Integer temp = t[i];
                t[i] = t[t.length - 1];
                t[t.length - 1] = temp;
                result.add(new ArrayList<Integer>(Arrays.asList(t)));
                temp = t[i];
                t[i] = t[t.length - 1];
                t[t.length - 1] = temp;
            }
        }

        return result;
    }

}
