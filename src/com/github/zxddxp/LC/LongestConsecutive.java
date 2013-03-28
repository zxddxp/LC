package com.github.zxddxp.LC;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutive {

    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null || num.length == 0) {
            return 0;
        } else if (num.length == 1) {
            return 1;
        }

        HashSet<Integer> dict = new HashSet<Integer>();
        int j = 0;
        for (int i = 0; i < num.length; i++) {
            if (dict.contains(num[i])) {
                continue;
            } else {
                dict.add(num[i]);
                num[j++] = num[i];
            }
        }

        int maxCount = 0;
        HashMap<Integer, D> minIdx = new HashMap<Integer, D>();
        HashMap<Integer, D> maxIdx = new HashMap<Integer, D>();

        for (int i = 0; i < j; i++) {
            int k = num[i];
            D d1 = null;
            if (minIdx.containsKey(k + 1) && maxIdx.containsKey(k - 1)) {
                d1 = maxIdx.remove(k - 1);
                D d2 = minIdx.remove(k + 1);
                d1.chain(d2);
            } else if (!minIdx.containsKey(k + 1) && maxIdx.containsKey(k - 1)) {
                d1 = maxIdx.remove(k - 1);
                d1.extR();
            } else if (minIdx.containsKey(k + 1) && !maxIdx.containsKey(k - 1)) {
                d1 = minIdx.remove(k + 1);
                d1.extL();
            } else {
                d1 = new D(k);
            }
            minIdx.put(d1.minV, d1);
            maxIdx.put(d1.maxV, d1);
            maxCount = Math.max(maxCount, d1.count);
        }

        return maxCount;
    }

    class D {
        int minV;
        int maxV;
        int count;

        D(int v) {
            minV = v;
            maxV = v;
            count = 1;
        }

        void extR() {
            maxV++;
            count++;
        }

        void extL() {
            minV--;
            count++;
        }

        void chain(D d) {
            maxV = d.maxV;
            count += (d.count + 1);
        }
    }

}
