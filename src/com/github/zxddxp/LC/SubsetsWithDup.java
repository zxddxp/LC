package com.github.zxddxp.LC;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsWithDup {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (num == null || num.length == 0) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            result.add(new ArrayList<Integer>());
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        ArrayList<Integer> SS = new ArrayList<Integer>(num.length);
        for (int i = 0; i < num.length; i++) {
            SS.add(num[i]);
        }
        Collections.sort(SS);

        int i = 0;
        while (i < SS.size()) {
            int size = result.size();
            int m = i;
            while (m < SS.size() && SS.get(i) == SS.get(m)) {

                for (int j = 0; j < size; j++) {
                    ArrayList<Integer> a = result.get(j);
                    ArrayList<Integer> b = new ArrayList<Integer>();
                    for (Integer k : a) {
                        b.add(k);
                    }
                    for (int n = i; n <= m; n++) {
                        b.add(SS.get(n));
                    }
                    result.add(b);
                }
                m++;
            }
            i++;
            while (i < SS.size() && SS.get(i) == SS.get(i - 1)) {
                i++;
            }
        }

        return result;
    }

}
