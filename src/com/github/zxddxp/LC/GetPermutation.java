package com.github.zxddxp.LC;

import java.util.ArrayList;

public class GetPermutation {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function

        k--; //so that index starts with 0

        ArrayList<Character> digits = new ArrayList<Character>();

        for (int i = 1; i <= n; i++) {
            digits.add((char) ('0' + i));
        }

        ArrayList<Integer> needed = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            needed.add(0);
        }

        StringBuilder sb = new StringBuilder();

        int perm = 1;

        int i = 2;
        int remain = 0;
        while (i <= n) {
            perm = perm * i;
            remain = k % perm;
            needed.set(n - i, remain / (perm / i));
            i++;
        }

        for (int j = 0; j < n; j++) {
            sb.append(digits.get((int) needed.get(j)));
            digits.remove((int) needed.get(j));
        }

        return sb.toString();

    }

}
